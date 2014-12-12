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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.br;
/* loaded from: classes.dex */
public class q extends BaseAdapter implements br, b {
    private static BaseFragmentActivity mActivity;
    private r bHH;
    private String bHh;
    public PersonPostModel bHo;
    private final String mUid;

    public q(BaseFragmentActivity baseFragmentActivity, String str, String str2) {
        mActivity = baseFragmentActivity;
        this.mUid = str;
    }

    public void ed(boolean z) {
        if (this.bHo == null) {
            this.bHo = new PersonPostModel(mActivity.getPageContext());
        }
        this.bHo.fetchPost(mActivity.getPageContext(), this, z, this.mUid, true);
    }

    public void aaF() {
        if (this.bHo != null) {
            this.bHo.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.person.br
    public void a(PersonPostModel personPostModel, boolean z) {
        if (z) {
            this.bHo = personPostModel;
        } else if (this.bHo != null) {
            this.bHo.post_list.addAll(personPostModel.post_list);
        }
        if (this.bHH != null) {
            this.bHH.b(personPostModel, z);
        }
        notifyDataSetChanged();
    }

    public void a(r rVar) {
        this.bHH = rVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bHo == null || this.bHo.post_list == null) {
            return 0;
        }
        return this.bHo.post_list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bHo.post_list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        s sVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.ek().a(viewGroup.getContext(), com.baidu.tieba.x.person_post_item_thread, viewGroup, false);
            s sVar2 = new s(view);
            view.setTag(sVar2);
            sVar = sVar2;
        } else {
            sVar = (s) view.getTag();
        }
        if (i == 0) {
            sVar.bHd.setVisibility(0);
        } else {
            sVar.bHd.setVisibility(8);
        }
        PersonPostModel.PostList postList = this.bHo.post_list.get(i);
        if (this.bHh == null) {
            this.bHh = postList.user_portrait;
        }
        sVar.a(postList, true, this.bHh);
        String str = postList.title;
        if (str.trim().length() > 0) {
            sVar.mTitle.setText(str);
            sVar.mTitle.setVisibility(0);
        } else {
            sVar.mTitle.setVisibility(8);
        }
        LiveCardData a = a(postList.anchor_info);
        if (a.getAuthorId() != 0) {
            sVar.bHI.setVisibility(8);
            sVar.bHK.setVisibility(0);
            sVar.bHL.setData(a);
        } else {
            sVar.bHK.setVisibility(8);
            if (com.baidu.tbadk.core.l.mc().mg() && postList.media != null && postList.media.length > 0) {
                int min = Math.min(postList.media.length, 3);
                PersonPostModel.Media[] mediaArr = new PersonPostModel.Media[min];
                for (int i2 = 0; i2 < min; i2++) {
                    mediaArr[i2] = postList.media[i2];
                }
                sVar.bHI.setVisibility(0);
                sVar.bHI.setTags(mediaArr);
            } else {
                sVar.bHI.setVisibility(8);
                sVar.bHI.setTags(null);
            }
        }
        if (postList.abs_thread != null && postList.abs_thread.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < postList.abs_thread.length; i3++) {
                sb.append(postList.abs_thread[i3].text);
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                sVar.bqW.setText(sb2);
                sVar.bqW.setVisibility(0);
            } else {
                sVar.bqW.setVisibility(8);
            }
        } else {
            sVar.bqW.setVisibility(8);
        }
        if (!sVar.bqW.isShown() && a.getAuthorId() != 0) {
            sVar.bHJ.setVisibility(8);
        } else {
            sVar.bHJ.setVisibility(0);
        }
        sVar.a(this);
        sVar.cl(TbadkCoreApplication.m255getInst().getSkinType());
        ax.i(sVar.aaQ, com.baidu.tieba.t.cp_bg_line_b);
        sVar.bHL.onChangeSkinType(mActivity.getPageContext(), TbadkCoreApplication.m255getInst().getSkinType());
        mActivity.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
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
    public void O(View view) {
        String[] strArr;
        if (mActivity != null) {
            int id = view.getId();
            if (id == com.baidu.tieba.w.forum_name) {
                String str = (String) view.getTag();
                if (str != null) {
                    mActivity.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(mActivity.getPageContext().getPageActivity()).createNormalCfg(str, "")));
                }
            } else if (id == com.baidu.tieba.w.portrait) {
                mActivity.finish();
            } else if (id == com.baidu.tieba.w.username) {
                mActivity.finish();
            } else if ((id == com.baidu.tieba.w.item_content || id == com.baidu.tieba.w.item_header || id == com.baidu.tieba.w.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(mActivity.getPageContext().getPageActivity()).createCfgForPersonCenter(strArr[0], strArr[1], "person_post", 18005)));
            }
        }
    }
}
