package com.baidu.tieba.person.post;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tieba.i;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.post.a;
/* loaded from: classes.dex */
public class o extends BaseAdapter implements PersonPostModel.a, a.InterfaceC0067a {
    private String ckH;
    public PersonPostModel ckO;
    private a clh;
    private BaseFragmentActivity mActivity;
    private final String wr;

    /* loaded from: classes.dex */
    public interface a {
        void b(PersonPostModel personPostModel, boolean z);
    }

    public o(BaseFragmentActivity baseFragmentActivity, String str, String str2) {
        this.mActivity = baseFragmentActivity;
        this.wr = str;
    }

    public void eI(boolean z) {
        if (this.ckO == null) {
            this.ckO = new PersonPostModel(this.mActivity.getPageContext());
        }
        this.ckO.fetchPost(this.mActivity.getPageContext(), this, z, this.wr, true);
    }

    public void agH() {
        if (this.ckO != null) {
            this.ckO.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.person.PersonPostModel.a
    public void a(PersonPostModel personPostModel, boolean z) {
        if (z) {
            this.ckO = personPostModel;
        } else if (this.ckO != null) {
            this.ckO.post_list.addAll(personPostModel.post_list);
        }
        if (this.clh != null) {
            this.clh.b(personPostModel, z);
        }
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.clh = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ckO == null || this.ckO.post_list == null) {
            return 0;
        }
        return this.ckO.post_list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.ckO.post_list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(i.g.person_post_item_thread, viewGroup, false);
            b bVar2 = new b(view, this.mActivity.getPageContext());
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        if (i == 0) {
            bVar.ckD.setVisibility(0);
        } else {
            bVar.ckD.setVisibility(8);
        }
        PersonPostModel.PostInfoList postInfoList = this.ckO.post_list.get(i);
        if (this.ckH == null) {
            this.ckH = postInfoList.user_portrait;
        }
        bVar.a(postInfoList, true, this.ckH);
        String str = postInfoList.title;
        if (str.trim().length() > 0) {
            bVar.aPV.setText(str);
            bVar.aPV.setVisibility(0);
        } else {
            bVar.aPV.setVisibility(8);
        }
        LiveCardData a2 = a(postInfoList.anchor_info);
        if (a2.getAuthorId() != 0) {
            bVar.cli.setVisibility(8);
            bVar.clk.setVisibility(0);
            bVar.cll.setData(a2);
        } else {
            bVar.clk.setVisibility(8);
            if (com.baidu.tbadk.core.m.rd().rh() && postInfoList.media != null && postInfoList.media.length > 0) {
                int min = Math.min(postInfoList.media.length, 3);
                PersonPostModel.Media[] mediaArr = new PersonPostModel.Media[min];
                for (int i2 = 0; i2 < min; i2++) {
                    mediaArr[i2] = postInfoList.media[i2];
                }
                bVar.cli.setVisibility(0);
                bVar.cli.setTags(mediaArr);
            } else {
                bVar.cli.setVisibility(8);
                bVar.cli.setTags(null);
            }
        }
        if (postInfoList.abs_thread != null && postInfoList.abs_thread.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < postInfoList.abs_thread.length; i3++) {
                sb.append(postInfoList.abs_thread[i3].text);
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                bVar.bVE.setText(sb2);
                bVar.bVE.setVisibility(0);
            } else {
                bVar.bVE.setVisibility(8);
            }
        } else {
            bVar.bVE.setVisibility(8);
        }
        if (!bVar.bVE.isShown() && a2.getAuthorId() != 0) {
            bVar.clj.setVisibility(8);
        } else {
            bVar.clj.setVisibility(0);
        }
        bVar.a(this);
        bVar.cG(TbadkCoreApplication.m411getInst().getSkinType());
        al.i(bVar.Xi, i.c.cp_bg_line_b);
        bVar.cll.onChangeSkinType(this.mActivity.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mActivity.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.mActivity.getLayoutMode().k(bVar.mContentView);
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

    @Override // com.baidu.tieba.person.post.a.InterfaceC0067a
    public void ac(View view) {
        String[] strArr;
        if (this.mActivity != null) {
            int id = view.getId();
            if (id == i.f.forum_name) {
                String str = (String) view.getTag();
                if (str != null) {
                    this.mActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mActivity.getPageContext().getPageActivity()).createNormalCfg(str, "")));
                }
            } else if (id == i.f.portrait) {
                this.mActivity.finish();
            } else if (id == i.f.username) {
                this.mActivity.finish();
            } else if ((id == i.f.item_content || id == i.f.item_header || id == i.f.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mActivity.getPageContext().getPageActivity()).createCfgForPersonCenter(strArr[0], strArr[1], "person_post", 18005)));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends com.baidu.tieba.person.post.a {
        View Xi;
        TextView aPV;
        TextView bVE;
        TripleTbImageView cli;
        View clj;
        LinearLayout clk;
        LiveBroadcastCard cll;
        View mContentView;

        @Override // com.baidu.tieba.person.post.a
        public /* bridge */ /* synthetic */ void a(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
            super.a(postInfoList, z, str);
        }

        @Override // com.baidu.tieba.person.post.a
        public /* bridge */ /* synthetic */ void a(a.InterfaceC0067a interfaceC0067a) {
            super.a(interfaceC0067a);
        }

        @Override // com.baidu.tieba.person.post.a, android.view.View.OnClickListener
        public /* bridge */ /* synthetic */ void onClick(View view) {
            super.onClick(view);
        }

        b(View view, TbPageContext<?> tbPageContext) {
            super(view, tbPageContext);
            this.mContentView = view.findViewById(i.f.item_content);
            this.aPV = (TextView) view.findViewById(i.f.title);
            this.bVE = (TextView) view.findViewById(i.f.content);
            this.cli = (TripleTbImageView) view.findViewById(i.f.images);
            this.clj = view.findViewById(i.f.post_line);
            this.clk = (LinearLayout) view.findViewById(i.f.person_post_item_live_card);
            this.cll = (LiveBroadcastCard) view.findViewById(i.f.person_post_item_feed_item_card);
            this.Xi = view.findViewById(i.f.person_post_thread_item_divider_1);
        }

        @Override // com.baidu.tieba.person.post.a
        public void cG(int i) {
            super.cG(i);
            al.b(this.aPV, i.c.cp_cont_b, 1);
            al.b(this.bVE, i.c.cp_cont_f, 1);
            al.i(this.clj, i.c.cp_bg_line_b);
        }
    }
}
