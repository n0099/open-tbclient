package com.baidu.tieba.person.post;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.post.a;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.f.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class q extends BaseAdapter implements PhotoLiveCardView.a, PhotoLiveCardView.b, PersonPostModel.a, a.InterfaceC0080a {
    private BaseFragmentActivity cZG;
    private String dgC;
    public PersonPostModel dgK;
    private a dhc;
    private int mThreadType;
    private final String wH;
    private com.baidu.tieba.tbadkCore.f.a cMH = null;
    private boolean dhd = false;
    private List<PersonPostModel.PostInfoList> dhe = new ArrayList();
    private PhotoLiveCardData dhf = null;
    private com.baidu.tbadk.core.dialog.a cRb = null;
    private final com.baidu.adp.base.g cNg = new r(this);

    /* loaded from: classes.dex */
    public interface a {
        void b(PersonPostModel personPostModel, boolean z);

        void ga(boolean z);
    }

    public q(BaseFragmentActivity baseFragmentActivity, String str, String str2) {
        this.cZG = baseFragmentActivity;
        this.wH = str;
        this.dgK = new PersonPostModel(this.cZG.getPageContext());
    }

    public void fY(boolean z) {
        if (this.dgK == null) {
            this.dgK = new PersonPostModel(this.cZG.getPageContext());
        }
        this.dgK.fetchPost(this.cZG.getPageContext(), this, z, this.wH, true, this.mThreadType);
    }

    public void auS() {
        if (this.dgK != null) {
            this.dgK.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.person.PersonPostModel.a
    public void a(PersonPostModel personPostModel, boolean z) {
        if (z) {
            this.dgK = personPostModel;
            if (this.dgK != null) {
                this.dhe.clear();
                this.dhe.addAll(this.dgK.post_list);
            }
        } else if (this.dgK != null) {
            this.dgK.post_list.addAll(personPostModel.post_list);
            this.dhe.addAll(personPostModel.post_list);
        }
        if (this.dhc != null) {
            this.dhc.b(personPostModel, z);
        }
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.dhc = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dhe != null) {
            return this.dhe.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lB */
    public PersonPostModel.PostInfoList getItem(int i) {
        if (this.dhe == null || this.dhe.size() - 1 < i) {
            return null;
        }
        return this.dhe.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        PersonPostModel.PostInfoList item = getItem(i);
        boolean z = item != null && item.thread_type == 33;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(t.h.person_post_item_thread, viewGroup, false);
            b bVar2 = new b(view, this.cZG.getPageContext());
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        if (!z) {
            bVar.dgr.setPadding(0, (int) this.cZG.getResources().getDimension(t.e.ds18), 0, 0);
            bVar.dgy.setVisibility(0);
            bVar.dgu.setVisibility(0);
            bVar.dgt.setVisibility(0);
            bVar.dgz.setVisibility(0);
            bVar.dgB.setVisibility(0);
            bVar.aPr.setVisibility(0);
            bVar.cmF.setVisibility(0);
            bVar.dhh.setVisibility(0);
            bVar.dhi.setVisibility(0);
            bVar.dhj.setVisibility(8);
            if (i == 0) {
                bVar.dgy.setVisibility(0);
            } else {
                bVar.dgy.setVisibility(8);
            }
            if (this.dgC == null) {
                this.dgC = item.user_portrait;
            }
            bVar.a(item, true, this.dgC);
            String str = item.title;
            if (str.trim().length() > 0) {
                bVar.aPr.setText(str);
                bVar.aPr.setVisibility(0);
            } else {
                bVar.aPr.setVisibility(8);
            }
            if (com.baidu.tbadk.core.l.rn().rt() && item.media != null && item.media.length > 0) {
                int min = Math.min(item.media.length, 3);
                PersonPostModel.Media[] mediaArr = new PersonPostModel.Media[min];
                for (int i3 = 0; i3 < min; i3++) {
                    mediaArr[i3] = item.media[i3];
                }
                bVar.dhh.setVisibility(0);
                bVar.dhh.setTags(mediaArr);
            } else {
                bVar.dhh.setVisibility(8);
                bVar.dhh.setTags(null);
            }
            if (item.abs_thread != null && item.abs_thread.length > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i4 = 0; i4 < item.abs_thread.length; i4++) {
                    sb.append(item.abs_thread[i4].text);
                }
                String sb2 = sb.toString();
                if (sb2.trim().length() > 0) {
                    bVar.cmF.setText(sb2);
                    bVar.cmF.setVisibility(0);
                } else {
                    bVar.cmF.setVisibility(8);
                }
            } else {
                bVar.cmF.setVisibility(8);
            }
            bVar.dhi.setVisibility(0);
            bVar.a(this);
        } else if (item != null) {
            bVar.dgr.setPadding(0, 0, 0, 0);
            bVar.dgy.setVisibility(8);
            bVar.dgu.setVisibility(8);
            bVar.dgt.setVisibility(8);
            bVar.dgz.setVisibility(8);
            bVar.dgB.setVisibility(8);
            bVar.aPr.setVisibility(8);
            bVar.cmF.setVisibility(8);
            bVar.dhh.setVisibility(8);
            bVar.dhi.setVisibility(8);
            bVar.dhj.setVisibility(0);
            PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
            if (item.twzhibo_info != null) {
                if (item.twzhibo_info.zan != null) {
                    photoLiveCardData.setPraiseNum(item.twzhibo_info.zan.num);
                }
                photoLiveCardData.setLastModifiedTime(item.twzhibo_info.last_modified_time);
                photoLiveCardData.setPostNum(item.twzhibo_info.post_num);
                photoLiveCardData.setLiveCoverSrcBsize(item.twzhibo_info.livecover_src_bsize);
                photoLiveCardData.setExpressionDatas(a(item.twzhibo_info.labelList));
                photoLiveCardData.setCover(item.twzhibo_info.livecover_src);
                photoLiveCardData.setContent(item.twzhibo_info.content);
                i2 = a(item.twzhibo_info);
                photoLiveCardData.setShowExpressionViewIndex(item.twzhibo_info.showExpressionViewIndex);
                photoLiveCardData.setShowStyle(item.twzhibo_info.showStyle);
            } else {
                i2 = 2;
            }
            photoLiveCardData.setAuthorId(String.valueOf(item.user_id));
            photoLiveCardData.setAuthorName(item.user_name);
            photoLiveCardData.setAuthorPortrait(item.user_portrait);
            photoLiveCardData.setDiscussNum(item.reply_num);
            photoLiveCardData.setForumId(item.forum_id);
            photoLiveCardData.setForumName(item.forum_name);
            if (item.abs_thread != null && item.abs_thread.length > 0) {
                StringBuilder sb3 = new StringBuilder();
                for (int i5 = 0; i5 < item.abs_thread.length; i5++) {
                    sb3.append(item.abs_thread[i5].text);
                }
                photoLiveCardData.setContent(photoLiveCardData.deleteBlackSpace(sb3.toString()));
            }
            photoLiveCardData.setTitle(photoLiveCardData.deleteBlackSpace(item.title));
            photoLiveCardData.setThreadId(item.thread_id);
            bVar.bkD.setOnClickListener(new s(this));
            bVar.bkD.setTag(item);
            bVar.bkD.setPortraitClicklistener(this);
            bVar.bkD.setDeleteButtonClickListener(this);
            bVar.bkD.setShowBottom(true);
            bVar.bkD.setShowReplyNumInButtom(true);
            bVar.bkD.setShowHead(false);
            bVar.bkD.setShowTitle(true);
            bVar.bkD.setShowRefreshTimeInTitle(true);
            bVar.bkD.setHeadPaddingTop(t.e.ds24);
            if (2 == i2) {
                bVar.bkD.setShowContent(true);
                bVar.bkD.setShowCover(false);
                bVar.bkD.setShowExpression(false);
                bVar.bkD.setShowRefreshTimeInTitle(false);
            } else {
                bVar.bkD.setShowContent(false);
                bVar.bkD.setShowCover(true);
                bVar.bkD.setShowExpression(true);
                bVar.bkD.setShowRefreshTimeInTitle(true);
            }
            bVar.bkD.setShowImage(com.baidu.tbadk.core.l.rn().rt());
            bVar.bkD.setShowLiveIcon(true);
            bVar.bkD.setChooseStyle(photoLiveCardData.getShowStyle());
            bVar.bkD.setShowDeleteButtonInTitle(this.dhd);
            if (this.dhd) {
                bVar.bkD.setTitlePaddingRight(t.e.ds84);
            } else {
                bVar.bkD.setTitlePaddingRight(0);
            }
            bVar.bkD.setData(photoLiveCardData);
        }
        bVar.dg(TbadkCoreApplication.m411getInst().getSkinType());
        this.cZG.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cZG.getLayoutMode().x(bVar.mContentView);
        return view;
    }

    private int a(PersonPostModel.ZhiBoInfoTW zhiBoInfoTW) {
        return !StringUtils.isNull(zhiBoInfoTW.livecover_src) ? 1 : 2;
    }

    private ArrayList<com.baidu.tbadk.coreExtra.view.n> a(PersonPostModel.LabelInfo[] labelInfoArr) {
        ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList = new ArrayList<>();
        if (labelInfoArr == null || labelInfoArr.length <= 0) {
            return arrayList;
        }
        for (int i = 0; i < labelInfoArr.length; i++) {
            com.baidu.tbadk.coreExtra.view.n nVar = new com.baidu.tbadk.coreExtra.view.n();
            if (labelInfoArr[i] != null) {
                nVar.eh(labelInfoArr[i].labelHot);
                nVar.setLabelName(labelInfoArr[i].labelName);
                nVar.setLabelId(labelInfoArr[i].LabelId);
                arrayList.add(nVar);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.person.post.a.InterfaceC0080a
    public void aI(View view) {
        String[] strArr;
        if (this.cZG != null) {
            int id = view.getId();
            if (id == t.g.forum_name) {
                String str = (String) view.getTag();
                if (str != null) {
                    this.cZG.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cZG.getPageContext().getPageActivity()).createNormalCfg(str, "")));
                }
            } else if (id == t.g.portrait) {
                this.cZG.finish();
            } else if (id == t.g.username) {
                this.cZG.finish();
            } else if ((id == t.g.item_content || id == t.g.item_header || id == t.g.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.cZG.getPageContext().getPageActivity()).createCfgForPersonCenter(strArr[0], strArr[1], "person_post", 18005)));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends com.baidu.tieba.person.post.a {
        TextView aPr;
        PhotoLiveCardView bkD;
        TextView cmF;
        TripleTbImageView dhh;
        View dhi;
        LinearLayout dhj;
        View mContentView;

        @Override // com.baidu.tieba.person.post.a
        public /* bridge */ /* synthetic */ void a(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
            super.a(postInfoList, z, str);
        }

        @Override // com.baidu.tieba.person.post.a
        public /* bridge */ /* synthetic */ void a(a.InterfaceC0080a interfaceC0080a) {
            super.a(interfaceC0080a);
        }

        @Override // com.baidu.tieba.person.post.a, android.view.View.OnClickListener
        public /* bridge */ /* synthetic */ void onClick(View view) {
            super.onClick(view);
        }

        b(View view, TbPageContext<?> tbPageContext) {
            super(view, tbPageContext);
            this.mContentView = view.findViewById(t.g.item_content);
            this.aPr = (TextView) view.findViewById(t.g.title);
            this.cmF = (TextView) view.findViewById(t.g.content);
            this.dhh = (TripleTbImageView) view.findViewById(t.g.images);
            this.dhi = view.findViewById(t.g.post_line);
            this.bkD = (PhotoLiveCardView) view.findViewById(t.g.photo_live_card);
            this.dhj = (LinearLayout) view.findViewById(t.g.person_post_item_photo_live_card);
        }

        @Override // com.baidu.tieba.person.post.a
        public void dg(int i) {
            super.dg(i);
            ar.b(this.aPr, t.d.cp_cont_b, 1);
            ar.b(this.cmF, t.d.cp_cont_f, 1);
            ar.k(this.dhi, t.d.cp_bg_line_b);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        this.cZG.finish();
    }

    public void setThreadType(int i) {
        this.mThreadType = i;
    }

    public void fZ(boolean z) {
        this.dhd = z;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.a
    public void onDeleteClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            this.dhf = (PhotoLiveCardData) tag;
            auT();
        }
    }

    public void auT() {
        if (this.cRb == null) {
            String string = this.cZG.getPageContext().getResources().getString(t.j.del_thread_confirm);
            this.cRb = new com.baidu.tbadk.core.dialog.a(this.cZG.getActivity());
            this.cRb.cE(string);
            this.cRb.a(t.j.dialog_ok, new t(this));
            this.cRb.b(t.j.dialog_cancel, new u(this));
            this.cRb.aj(true);
            this.cRb.b(this.cZG.getPageContext());
        }
        this.cRb.uj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auU() {
        if (this.dhf != null) {
            if (this.cMH == null) {
                this.cMH = new com.baidu.tieba.tbadkCore.f.a(this.cZG);
                this.cMH.setLoadDataCallBack(this.cNg);
            }
            if (!this.cMH.aNl()) {
                this.cZG.showProgressBar();
                String valueOf = String.valueOf(this.dhf.getForumId());
                String forumName = this.dhf.getForumName();
                String valueOf2 = String.valueOf(this.dhf.getThreadId());
                this.cMH.a(valueOf, forumName, valueOf2, valueOf2, 0, 0, true);
                this.dhf = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        if (bVar != null) {
            a(0, bVar.AD, bVar.dZa, true);
            if (bVar.AD && bVar.dYY == 0) {
                List<PersonPostModel.PostInfoList> list = this.dhe;
                int size = list.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    if (!(com.baidu.adp.lib.h.b.c(bVar.mPostId, -1L) == list.get(i).thread_id)) {
                        i++;
                    } else {
                        list.remove(i);
                        break;
                    }
                }
                notifyDataSetChanged();
                if (list.size() == 0 && this.dhc != null) {
                    this.dhc.ga(true);
                }
            }
        }
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.cZG.hideProgressBar();
        if (z && z2) {
            this.cZG.showToast(this.cZG.getPageContext().getString(t.j.cash_del_suc));
        } else if (str != null && z2) {
            this.cZG.showToast(str);
        }
    }

    public PersonPostModel auV() {
        return this.dgK;
    }
}
