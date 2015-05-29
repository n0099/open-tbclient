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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.ch;
/* loaded from: classes.dex */
public class q extends BaseAdapter implements ch, b {
    private String bTZ;
    public PersonPostModel bUg;
    private r bUz;
    private BaseFragmentActivity mActivity;
    private final String mUid;

    public q(BaseFragmentActivity baseFragmentActivity, String str, String str2) {
        this.mActivity = baseFragmentActivity;
        this.mUid = str;
    }

    public void eq(boolean z) {
        if (this.bUg == null) {
            this.bUg = new PersonPostModel(this.mActivity.getPageContext());
        }
        this.bUg.fetchPost(this.mActivity.getPageContext(), this, z, this.mUid, true);
    }

    public void aeO() {
        if (this.bUg != null) {
            this.bUg.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.person.ch
    public void a(PersonPostModel personPostModel, boolean z) {
        if (z) {
            this.bUg = personPostModel;
        } else if (this.bUg != null) {
            this.bUg.post_list.addAll(personPostModel.post_list);
        }
        if (this.bUz != null) {
            this.bUz.b(personPostModel, z);
        }
        notifyDataSetChanged();
    }

    public void a(r rVar) {
        this.bUz = rVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bUg == null || this.bUg.post_list == null) {
            return 0;
        }
        return this.bUg.post_list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bUg.post_list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        s sVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.hr().a(viewGroup.getContext(), com.baidu.tieba.r.person_post_item_thread, viewGroup, false);
            s sVar2 = new s(view, this.mActivity.getPageContext());
            view.setTag(sVar2);
            sVar = sVar2;
        } else {
            sVar = (s) view.getTag();
        }
        if (i == 0) {
            sVar.bTV.setVisibility(0);
        } else {
            sVar.bTV.setVisibility(8);
        }
        PersonPostModel.PostList postList = this.bUg.post_list.get(i);
        if (this.bTZ == null) {
            this.bTZ = postList.user_portrait;
        }
        sVar.a(postList, true, this.bTZ);
        String str = postList.title;
        if (str.trim().length() > 0) {
            sVar.mTitle.setText(str);
            sVar.mTitle.setVisibility(0);
        } else {
            sVar.mTitle.setVisibility(8);
        }
        LiveCardData a = a(postList.anchor_info);
        if (a.getAuthorId() != 0) {
            sVar.bUA.setVisibility(8);
            sVar.bUC.setVisibility(0);
            sVar.bUD.setData(a);
        } else {
            sVar.bUC.setVisibility(8);
            if (com.baidu.tbadk.core.n.qc().qg() && postList.media != null && postList.media.length > 0) {
                int min = Math.min(postList.media.length, 3);
                PersonPostModel.Media[] mediaArr = new PersonPostModel.Media[min];
                for (int i2 = 0; i2 < min; i2++) {
                    mediaArr[i2] = postList.media[i2];
                }
                sVar.bUA.setVisibility(0);
                sVar.bUA.setTags(mediaArr);
            } else {
                sVar.bUA.setVisibility(8);
                sVar.bUA.setTags(null);
            }
        }
        if (postList.abs_thread != null && postList.abs_thread.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < postList.abs_thread.length; i3++) {
                sb.append(postList.abs_thread[i3].text);
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                sVar.bFO.setText(sb2);
                sVar.bFO.setVisibility(0);
            } else {
                sVar.bFO.setVisibility(8);
            }
        } else {
            sVar.bFO.setVisibility(8);
        }
        if (!sVar.bFO.isShown() && a.getAuthorId() != 0) {
            sVar.bUB.setVisibility(8);
        } else {
            sVar.bUB.setVisibility(0);
        }
        sVar.a(this);
        sVar.cy(TbadkCoreApplication.m411getInst().getSkinType());
        ay.i(sVar.So, com.baidu.tieba.n.cp_bg_line_b);
        sVar.bUD.onChangeSkinType(this.mActivity.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mActivity.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.mActivity.getLayoutMode().j(sVar.mContentView);
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
        if (this.mActivity != null) {
            int id = view.getId();
            if (id == com.baidu.tieba.q.forum_name) {
                String str = (String) view.getTag();
                if (str != null) {
                    this.mActivity.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mActivity.getPageContext().getPageActivity()).createNormalCfg(str, "")));
                }
            } else if (id == com.baidu.tieba.q.portrait) {
                this.mActivity.finish();
            } else if (id == com.baidu.tieba.q.username) {
                this.mActivity.finish();
            } else if ((id == com.baidu.tieba.q.item_content || id == com.baidu.tieba.q.item_header || id == com.baidu.tieba.q.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mActivity.getPageContext().getPageActivity()).createCfgForPersonCenter(strArr[0], strArr[1], "person_post", 18005)));
            }
        }
    }
}
