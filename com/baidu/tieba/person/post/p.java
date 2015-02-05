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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.bq;
/* loaded from: classes.dex */
public class p extends BaseAdapter implements bq, b {
    private static BaseFragmentActivity mActivity;
    private String bIS;
    public PersonPostModel bIZ;
    private q bJs;
    private final String mUid;

    public p(BaseFragmentActivity baseFragmentActivity, String str, String str2) {
        mActivity = baseFragmentActivity;
        this.mUid = str;
    }

    public void ej(boolean z) {
        if (this.bIZ == null) {
            this.bIZ = new PersonPostModel(mActivity.getPageContext());
        }
        this.bIZ.fetchPost(mActivity.getPageContext(), this, z, this.mUid, true);
    }

    public void abf() {
        if (this.bIZ != null) {
            this.bIZ.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.person.bq
    public void a(PersonPostModel personPostModel, boolean z) {
        if (z) {
            this.bIZ = personPostModel;
        } else if (this.bIZ != null) {
            this.bIZ.post_list.addAll(personPostModel.post_list);
        }
        if (this.bJs != null) {
            this.bJs.b(personPostModel, z);
        }
        notifyDataSetChanged();
    }

    public void a(q qVar) {
        this.bJs = qVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bIZ == null || this.bIZ.post_list == null) {
            return 0;
        }
        return this.bIZ.post_list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bIZ.post_list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        r rVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.ei().a(viewGroup.getContext(), com.baidu.tieba.x.person_post_item_thread, viewGroup, false);
            r rVar2 = new r(view);
            view.setTag(rVar2);
            rVar = rVar2;
        } else {
            rVar = (r) view.getTag();
        }
        if (i == 0) {
            rVar.bIO.setVisibility(0);
        } else {
            rVar.bIO.setVisibility(8);
        }
        PersonPostModel.PostList postList = this.bIZ.post_list.get(i);
        if (this.bIS == null) {
            this.bIS = postList.user_portrait;
        }
        rVar.a(postList, true, this.bIS);
        String str = postList.title;
        if (str.trim().length() > 0) {
            rVar.mTitle.setText(str);
            rVar.mTitle.setVisibility(0);
        } else {
            rVar.mTitle.setVisibility(8);
        }
        LiveCardData a = a(postList.anchor_info);
        if (a.getAuthorId() != 0) {
            rVar.bJt.setVisibility(8);
            rVar.bJv.setVisibility(0);
            rVar.bJw.setData(a);
        } else {
            rVar.bJv.setVisibility(8);
            if (com.baidu.tbadk.core.l.lV().lZ() && postList.media != null && postList.media.length > 0) {
                int min = Math.min(postList.media.length, 3);
                PersonPostModel.Media[] mediaArr = new PersonPostModel.Media[min];
                for (int i2 = 0; i2 < min; i2++) {
                    mediaArr[i2] = postList.media[i2];
                }
                rVar.bJt.setVisibility(0);
                rVar.bJt.setTags(mediaArr);
            } else {
                rVar.bJt.setVisibility(8);
                rVar.bJt.setTags(null);
            }
        }
        if (postList.abs_thread != null && postList.abs_thread.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < postList.abs_thread.length; i3++) {
                sb.append(postList.abs_thread[i3].text);
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                rVar.bst.setText(sb2);
                rVar.bst.setVisibility(0);
            } else {
                rVar.bst.setVisibility(8);
            }
        } else {
            rVar.bst.setVisibility(8);
        }
        if (!rVar.bst.isShown() && a.getAuthorId() != 0) {
            rVar.bJu.setVisibility(8);
        } else {
            rVar.bJu.setVisibility(0);
        }
        rVar.a(this);
        rVar.cs(TbadkCoreApplication.m255getInst().getSkinType());
        bc.i(rVar.abo, com.baidu.tieba.t.cp_bg_line_b);
        rVar.bJw.onChangeSkinType(mActivity.getPageContext(), TbadkCoreApplication.m255getInst().getSkinType());
        mActivity.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        mActivity.getLayoutMode().h(rVar.mContentView);
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
