package com.baidu.tieba.person.post;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.person.post.PersonPostModel;
/* loaded from: classes.dex */
public class r extends BaseAdapter implements b, g {
    private String bDG;
    public PersonPostModel bDP;
    private s bEj;
    private final BaseFragmentActivity mActivity;
    private final String mUid;

    public r(Context context, String str, String str2) {
        this.mActivity = (BaseFragmentActivity) context;
        this.mUid = str;
    }

    public void ew(boolean z) {
        if (this.bDP == null) {
            this.bDP = new PersonPostModel(this.mActivity);
        }
        this.bDP.fetchPost(this.mActivity, this, z, this.mUid, true);
    }

    public void aao() {
        if (this.bDP != null) {
            this.bDP.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.person.post.g
    public void a(PersonPostModel personPostModel, boolean z) {
        if (z) {
            this.bDP = personPostModel;
        } else if (this.bDP != null) {
            this.bDP.post_list.addAll(personPostModel.post_list);
        }
        if (this.bEj != null) {
            this.bEj.b(personPostModel, z);
        }
        notifyDataSetChanged();
    }

    public void a(s sVar) {
        this.bEj = sVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bDP == null || this.bDP.post_list == null) {
            return 0;
        }
        return this.bDP.post_list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bDP.post_list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        t tVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.ek().a(viewGroup.getContext(), com.baidu.tieba.w.person_post_item_thread, viewGroup, false);
            t tVar2 = new t(view);
            view.setTag(tVar2);
            tVar = tVar2;
        } else {
            tVar = (t) view.getTag();
        }
        if (i == 0) {
            tVar.bDC.setVisibility(0);
        } else {
            tVar.bDC.setVisibility(8);
        }
        PersonPostModel.PostList postList = this.bDP.post_list.get(i);
        if (this.bDG == null) {
            this.bDG = postList.user_portrait;
        }
        tVar.a(postList, true, this.bDG);
        String str = postList.title;
        if (str.trim().length() > 0) {
            tVar.JN.setText(str);
            tVar.JN.setVisibility(0);
        } else {
            tVar.JN.setVisibility(8);
        }
        LiveCardData a = a(postList.anchor_info);
        if (a.getAuthorId() != 0) {
            tVar.bEk.setVisibility(8);
            tVar.bEm.setVisibility(0);
            tVar.bEn.setData(a);
        } else {
            tVar.bEm.setVisibility(8);
            if (com.baidu.tbadk.core.l.js().jw() && postList.media != null && postList.media.length > 0) {
                int min = Math.min(postList.media.length, 3);
                PersonPostModel.Media[] mediaArr = new PersonPostModel.Media[min];
                for (int i2 = 0; i2 < min; i2++) {
                    mediaArr[i2] = postList.media[i2];
                }
                tVar.bEk.setVisibility(0);
                tVar.bEk.setTags(mediaArr);
            } else {
                tVar.bEk.setVisibility(8);
                tVar.bEk.setTags(null);
            }
        }
        if (postList.abs_thread != null && postList.abs_thread.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < postList.abs_thread.length; i3++) {
                sb.append(postList.abs_thread[i3].text);
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                tVar.bmt.setText(sb2);
                tVar.bmt.setVisibility(0);
            } else {
                tVar.bmt.setVisibility(8);
            }
        } else {
            tVar.bmt.setVisibility(8);
        }
        if (!tVar.bmt.isShown() && a.getAuthorId() != 0) {
            tVar.bEl.setVisibility(8);
        } else {
            tVar.bEl.setVisibility(0);
        }
        tVar.a(this);
        tVar.bM(TbadkApplication.m251getInst().getSkinType());
        aw.h(tVar.UM, com.baidu.tieba.s.cp_bg_line_b);
        tVar.bEn.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
        this.mActivity.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.mActivity.getLayoutMode().h(tVar.mContentView);
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
    public void X(View view) {
        String[] strArr;
        int id = view.getId();
        if (id == com.baidu.tieba.v.forum_name) {
            String str = (String) view.getTag();
            if (str != null && (this.mActivity instanceof BaseFragmentActivity)) {
                this.mActivity.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mActivity).createNormalCfg(str, "")));
            }
        } else if (id == com.baidu.tieba.v.portrait) {
            this.mActivity.finish();
        } else if (id == com.baidu.tieba.v.username) {
            this.mActivity.finish();
        } else if ((id == com.baidu.tieba.v.item_content || id == com.baidu.tieba.v.item_header || id == com.baidu.tieba.v.item_footer) && (strArr = (String[]) view.getTag()) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mActivity).createCfgForPersonCenter(strArr[0], strArr[1], "person_post", 18005)));
        }
    }
}
