package com.baidu.tieba.person.post;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.bo;
/* loaded from: classes.dex */
public class q extends BaseAdapter implements bo, b {
    private static BaseFragmentActivity mActivity;
    public PersonPostModel bRB;
    private r bRS;
    private String bRu;
    private final String mUid;

    public q(BaseFragmentActivity baseFragmentActivity, String str, String str2) {
        mActivity = baseFragmentActivity;
        this.mUid = str;
    }

    public void ee(boolean z) {
        if (this.bRB == null) {
            this.bRB = new PersonPostModel(mActivity.getPageContext());
        }
        this.bRB.fetchPost(mActivity.getPageContext(), this, z, this.mUid, true);
    }

    public void adH() {
        if (this.bRB != null) {
            this.bRB.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.person.bo
    public void a(PersonPostModel personPostModel, boolean z) {
        if (z) {
            this.bRB = personPostModel;
        } else if (this.bRB != null) {
            this.bRB.post_list.addAll(personPostModel.post_list);
        }
        if (this.bRS != null) {
            this.bRS.b(personPostModel, z);
        }
        notifyDataSetChanged();
    }

    public void a(r rVar) {
        this.bRS = rVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bRB == null || this.bRB.post_list == null) {
            return 0;
        }
        return this.bRB.post_list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bRB.post_list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        s sVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.hH().a(viewGroup.getContext(), com.baidu.tieba.w.person_post_item_thread, viewGroup, false);
            s sVar2 = new s(view);
            view.setTag(sVar2);
            sVar = sVar2;
        } else {
            sVar = (s) view.getTag();
        }
        if (i == 0) {
            sVar.bRq.setVisibility(0);
        } else {
            sVar.bRq.setVisibility(8);
        }
        PersonPostModel.PostList postList = this.bRB.post_list.get(i);
        if (this.bRu == null) {
            this.bRu = postList.user_portrait;
        }
        sVar.a(postList, true, this.bRu);
        String str = postList.title;
        if (str.trim().length() > 0) {
            sVar.mTitle.setText(str);
            sVar.mTitle.setVisibility(0);
        } else {
            sVar.mTitle.setVisibility(8);
        }
        LiveCardData a = a(postList.anchor_info);
        if (a.getAuthorId() != 0) {
            sVar.bRT.setVisibility(8);
            sVar.bRV.setVisibility(0);
            sVar.bRW.setData(a);
        } else {
            sVar.bRV.setVisibility(8);
            if (com.baidu.tbadk.core.n.px().pB() && postList.media != null && postList.media.length > 0) {
                int min = Math.min(postList.media.length, 3);
                PersonPostModel.Media[] mediaArr = new PersonPostModel.Media[min];
                for (int i2 = 0; i2 < min; i2++) {
                    mediaArr[i2] = postList.media[i2];
                }
                sVar.bRT.setVisibility(0);
                sVar.bRT.setTags(mediaArr);
            } else {
                sVar.bRT.setVisibility(8);
                sVar.bRT.setTags(null);
            }
        }
        if (postList.abs_thread != null && postList.abs_thread.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < postList.abs_thread.length; i3++) {
                sb.append(postList.abs_thread[i3].text);
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                sVar.byT.setText(sb2);
                sVar.byT.setVisibility(0);
            } else {
                sVar.byT.setVisibility(8);
            }
        } else {
            sVar.byT.setVisibility(8);
        }
        if (!sVar.byT.isShown() && a.getAuthorId() != 0) {
            sVar.bRU.setVisibility(8);
        } else {
            sVar.bRU.setVisibility(0);
        }
        sVar.a(this);
        sVar.ct(TbadkCoreApplication.m411getInst().getSkinType());
        ba.i(sVar.axS, com.baidu.tieba.s.cp_bg_line_b);
        sVar.bRW.onChangeSkinType(mActivity.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        mActivity.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        mActivity.getLayoutMode().h(sVar.mContentView);
        return view;
    }

    private LiveCardData a(PersonPostModel.AnchorInfo anchorInfo) {
        LiveCardData liveCardData = new LiveCardData();
        liveCardData.setAuthorId(anchorInfo.author_id);
        liveCardData.setAuthorName(anchorInfo.author_name);
        liveCardData.setGroupId(anchorInfo.group_id);
        liveCardData.setIntro(anchorInfo.intro);
        liveCardData.setLikers(anchorInfo.likers);
        liveCardData.setListeners(anchorInfo.listeners);
        liveCardData.setName(anchorInfo.name);
        liveCardData.setPortrait(anchorInfo.portrait);
        liveCardData.setPublisherId(anchorInfo.publisherId);
        liveCardData.setPublisherName(anchorInfo.publisherName);
        liveCardData.setStartTime(anchorInfo.start_time);
        liveCardData.setStatus(anchorInfo.status);
        liveCardData.setPublisherPortrait(anchorInfo.publisherPortrait);
        return liveCardData;
    }

    @Override // com.baidu.tieba.person.post.b
    public void Q(View view) {
        String[] strArr;
        if (mActivity != null) {
            int id = view.getId();
            if (id == com.baidu.tieba.v.forum_name) {
                String str = (String) view.getTag();
                if (str != null) {
                    mActivity.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(mActivity.getPageContext().getPageActivity()).createNormalCfg(str, "")));
                }
            } else if (id == com.baidu.tieba.v.portrait) {
                mActivity.finish();
            } else if (id == com.baidu.tieba.v.username) {
                mActivity.finish();
            } else if ((id == com.baidu.tieba.v.item_content || id == com.baidu.tieba.v.item_header || id == com.baidu.tieba.v.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(mActivity.getPageContext().getPageActivity()).createCfgForPersonCenter(strArr[0], strArr[1], "person_post", 18005)));
            }
        }
    }
}
