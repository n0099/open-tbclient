package com.baidu.tieba.person.post;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.data.DealMediaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.post.a;
import com.baidu.tieba.tbadkCore.f.a;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class q extends BaseAdapter implements PhotoLiveCardView.a, PhotoLiveCardView.b, PersonPostModel.a, a.InterfaceC0074a {
    private BdUniqueId aoZ;
    private BaseFragmentActivity bfw;
    private a enE;
    private View.OnClickListener enG;
    private String enb;
    public PersonPostModel enm;
    private int mThreadType;
    private final String mV;
    private com.baidu.tieba.tbadkCore.f.a dON = null;
    private boolean enF = false;
    private List<PersonPostModel.PostInfoList> enH = new ArrayList();
    private PhotoLiveCardData enI = null;
    private com.baidu.tbadk.core.dialog.a dUr = null;
    private final com.baidu.adp.base.g dPq = new r(this);

    /* loaded from: classes.dex */
    public interface a {
        void b(PersonPostModel personPostModel, boolean z);

        void io(boolean z);
    }

    public q(BaseFragmentActivity baseFragmentActivity, String str, String str2, BdUniqueId bdUniqueId) {
        this.bfw = baseFragmentActivity;
        this.mV = str;
        this.enm = new PersonPostModel(this.bfw.getPageContext());
        this.enm.setUniqueId(bdUniqueId);
        this.aoZ = bdUniqueId;
    }

    public void M(View.OnClickListener onClickListener) {
        this.enG = onClickListener;
    }

    public void im(boolean z) {
        if (this.enm == null) {
            this.enm = new PersonPostModel(this.bfw.getPageContext());
            this.enm.setUniqueId(this.aoZ);
        }
        this.enm.fetchPost(this.bfw.getPageContext(), this, z, this.mV, true, this.mThreadType);
    }

    public void cp(long j) {
        this.enm.deferEcommThread(j);
    }

    public void aLP() {
        if (this.enm != null) {
            this.enm.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.person.PersonPostModel.a
    public void a(PersonPostModel personPostModel, boolean z) {
        if (z) {
            this.enm = personPostModel;
            if (this.enm != null) {
                this.enm.setUniqueId(this.aoZ);
                this.enH.clear();
                this.enH.addAll(this.enm.post_list);
            }
        } else if (this.enm != null) {
            this.enm.post_list.addAll(personPostModel.post_list);
            this.enH.addAll(personPostModel.post_list);
        }
        if (this.enE != null) {
            this.enE.b(personPostModel, z);
        }
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.enE = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.enH != null) {
            return this.enH.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oc */
    public PersonPostModel.PostInfoList getItem(int i) {
        if (this.enH == null || this.enH.size() - 1 < i) {
            return null;
        }
        return this.enH.get(i);
    }

    public PersonPostModel.PostInfoList cq(long j) {
        if (this.enH != null) {
            for (PersonPostModel.PostInfoList postInfoList : this.enH) {
                if (postInfoList.thread_id == j) {
                    return postInfoList;
                }
            }
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        PersonPostModel.PostInfoList item = getItem(i);
        return (item == null || !item.isDeal || item.dealInfoData == null) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            return j(i, view, viewGroup);
        }
        if (itemViewType == 1) {
            return i(i, view, viewGroup);
        }
        return view;
    }

    private View i(int i, View view, ViewGroup viewGroup) {
        b bVar;
        double d;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(u.h.person_post_item_thread_ecomm, viewGroup, false);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        PersonPostModel.PostInfoList item = getItem(i);
        if (item != null && item.dealInfoData != null) {
            DealInfoData dealInfoData = item.dealInfoData;
            bVar.enL.setUserId(new StringBuilder(String.valueOf(item.user_id)).toString());
            bVar.enL.setImageDrawable(null);
            bVar.enL.c(item.user_portrait, 28, false);
            bVar.enL.setOnClickListener(new s(this, item));
            bVar.bIg.setText(item.user_name);
            bVar.bIg.setOnClickListener(new t(this, item));
            bVar.enM.setText(dealInfoData.sellerAddress);
            if (dealInfoData.unitPrice > 9999999.0d) {
                bVar.bdJ.setText("¥" + ba.H((long) d));
            } else {
                bVar.bdJ.setText("¥" + String.format(Locale.getDefault(), "%.2f", Double.valueOf(d)));
            }
            String str = dealInfoData.title;
            if (!StringUtils.isNull(str)) {
                String string = this.bfw.getResources().getString(u.j.ecomm_description, str);
                SpannableString spannableString = new SpannableString(string);
                UtilHelper.setSpan(spannableString, string, str, new ForegroundColorSpan(av.getColor(u.d.cp_cont_b)));
                bVar.bIj.setVisibility(0);
                bVar.bIj.setText(spannableString);
            } else {
                bVar.bIj.setVisibility(8);
            }
            bVar.bsk.setText(String.valueOf(ba.c(item.forum_name, 7, "...")) + "吧");
            long j = dealInfoData.recommendations;
            if (j <= 0) {
                bVar.enO.setVisibility(8);
            } else {
                String D = ba.D(j);
                bVar.enO.setVisibility(0);
                bVar.enO.setText(D);
            }
            int i2 = item.reply_num;
            if (i2 > 0) {
                bVar.bNK.setVisibility(0);
                bVar.bNK.setText(ba.D(i2));
            } else {
                bVar.bNK.setVisibility(8);
            }
            if (this.mV.equals(TbadkCoreApplication.getCurrentAccount())) {
                bVar.enP.setVisibility(0);
                long currentTimeMillis = (dealInfoData.expireTime * 1000) - System.currentTimeMillis();
                if (currentTimeMillis <= 0) {
                    bVar.enQ.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icn_shop_personal_delayed), (Drawable) null, (Drawable) null, (Drawable) null);
                    bVar.enQ.setText(u.j.ecomm_no_time);
                    bVar.enP.setTag(Long.valueOf(item.thread_id));
                    bVar.enP.setEnabled(true);
                    bVar.enP.setOnClickListener(this.enG);
                } else {
                    bVar.enP.setEnabled(false);
                    bVar.enQ.setText(this.bfw.getResources().getString(u.j.ecomm_remain_time, ba.w(currentTimeMillis)));
                }
            } else {
                bVar.enP.setVisibility(8);
            }
            if (com.baidu.tbadk.core.l.nW().oc() && dealInfoData.media != null && dealInfoData.media.size() > 0) {
                ArrayList<DealMediaData> arrayList = dealInfoData.media;
                int min = Math.min(arrayList.size(), 3);
                PersonPostModel.Media[] mediaArr = new PersonPostModel.Media[min];
                for (int i3 = 0; i3 < min; i3++) {
                    DealMediaData dealMediaData = arrayList.get(i3);
                    PersonPostModel.Media media = new PersonPostModel.Media();
                    mediaArr[i3] = media;
                    media.type = dealMediaData.type;
                    media.small_pic = dealMediaData.smallPic;
                    media.big_pic = dealMediaData.bigPic;
                }
                bVar.enN.is(false);
                bVar.enN.setVisibility(0);
                bVar.enN.setTags(mediaArr);
            } else {
                bVar.enN.setVisibility(8);
                bVar.enN.setTags(null);
            }
        }
        com.baidu.tbadk.j.a.a(this.bfw.getPageContext(), view);
        return view;
    }

    private View j(int i, View view, ViewGroup viewGroup) {
        c cVar;
        int i2;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(u.h.person_post_item_thread, viewGroup, false);
            cVar = new c(view, this.bfw.getPageContext());
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        PersonPostModel.PostInfoList item = getItem(i);
        if (!(item != null && item.thread_type == 33)) {
            cVar.emQ.setPadding(0, (int) this.bfw.getResources().getDimension(u.e.ds18), 0, 0);
            cVar.emY.setVisibility(0);
            cVar.emT.setVisibility(0);
            cVar.emS.setVisibility(0);
            cVar.emZ.setVisibility(0);
            cVar.dwB.setVisibility(0);
            cVar.aSd.setVisibility(0);
            cVar.ddB.setVisibility(0);
            cVar.enR.setVisibility(0);
            cVar.enS.setVisibility(0);
            cVar.enT.setVisibility(8);
            if (i == 0) {
                cVar.emY.setVisibility(0);
            } else {
                cVar.emY.setVisibility(8);
            }
            if (this.enb == null) {
                this.enb = item.user_portrait;
            }
            cVar.a(item, true, this.enb);
            String str = item.title;
            if (str.trim().length() > 0) {
                cVar.aSd.setText(str);
                cVar.aSd.setVisibility(0);
            } else {
                cVar.aSd.setVisibility(8);
            }
            if (com.baidu.tbadk.core.l.nW().oc() && item.media != null && item.media.length > 0) {
                int min = Math.min(item.media.length, 3);
                PersonPostModel.Media[] mediaArr = new PersonPostModel.Media[min];
                for (int i3 = 0; i3 < min; i3++) {
                    mediaArr[i3] = item.media[i3];
                }
                cVar.enR.is(false);
                cVar.enR.setVisibility(0);
                cVar.enR.setTags(mediaArr);
            } else {
                cVar.enR.setVisibility(8);
                cVar.enR.setTags(null);
            }
            if (item.abs_thread != null && item.abs_thread.length > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i4 = 0; i4 < item.abs_thread.length; i4++) {
                    sb.append(item.abs_thread[i4].text);
                }
                String sb2 = sb.toString();
                if (sb2.trim().length() > 0) {
                    cVar.ddB.setText(sb2);
                    cVar.ddB.setVisibility(0);
                } else {
                    cVar.ddB.setVisibility(8);
                }
            } else {
                cVar.ddB.setVisibility(8);
            }
            cVar.enS.setVisibility(0);
            cVar.a(this);
        } else if (item != null) {
            cVar.emQ.setPadding(0, 0, 0, 0);
            cVar.emY.setVisibility(8);
            cVar.emT.setVisibility(8);
            cVar.emS.setVisibility(8);
            cVar.emZ.setVisibility(8);
            cVar.dwB.setVisibility(8);
            cVar.aSd.setVisibility(8);
            cVar.ddB.setVisibility(8);
            cVar.enR.setVisibility(8);
            cVar.enS.setVisibility(8);
            cVar.enT.setVisibility(0);
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
            cVar.bGe.setOnClickListener(new u(this));
            cVar.bGe.setTag(item);
            cVar.bGe.setPortraitClicklistener(this);
            cVar.bGe.setDeleteButtonClickListener(this);
            cVar.bGe.setShowBottom(true);
            cVar.bGe.setShowReplyNumInButtom(true);
            cVar.bGe.setShowHead(false);
            cVar.bGe.setShowTitle(true);
            cVar.bGe.setShowRefreshTimeInTitle(true);
            cVar.bGe.setHeadPaddingTop(u.e.ds24);
            if (2 == i2) {
                cVar.bGe.setShowContent(true);
                cVar.bGe.setShowCover(false);
                cVar.bGe.setShowExpression(false);
                cVar.bGe.setShowRefreshTimeInTitle(false);
            } else {
                cVar.bGe.setShowContent(false);
                cVar.bGe.setShowCover(true);
                cVar.bGe.setShowExpression(true);
                cVar.bGe.setShowRefreshTimeInTitle(true);
            }
            cVar.bGe.setShowImage(com.baidu.tbadk.core.l.nW().oc());
            cVar.bGe.setShowLiveIcon(true);
            cVar.bGe.setChooseStyle(photoLiveCardData.getShowStyle());
            cVar.bGe.setShowDeleteButtonInTitle(this.enF);
            if (this.enF) {
                cVar.bGe.setTitlePaddingRight(u.e.ds84);
            } else {
                cVar.bGe.setTitlePaddingRight(0);
            }
            cVar.bGe.setData(photoLiveCardData);
        }
        cVar.cT(TbadkCoreApplication.m9getInst().getSkinType());
        this.bfw.getLayoutMode().ad(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.bfw.getLayoutMode().w(cVar.mContentView);
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
                nVar.dR(labelInfoArr[i].labelHot);
                nVar.setLabelName(labelInfoArr[i].labelName);
                nVar.setLabelId(labelInfoArr[i].LabelId);
                arrayList.add(nVar);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.person.post.a.InterfaceC0074a
    public void bc(View view) {
        String[] strArr;
        if (this.bfw != null) {
            int id = view.getId();
            if (id == u.g.forum_name) {
                String str = (String) view.getTag();
                if (str != null) {
                    this.bfw.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bfw.getPageContext().getPageActivity()).createNormalCfg(str, "")));
                }
            } else if (id == u.g.portrait) {
                this.bfw.finish();
            } else if (id == u.g.username) {
                this.bfw.finish();
            } else if ((id == u.g.item_content || id == u.g.item_header || id == u.g.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.bfw.getPageContext().getPageActivity()).createCfgForPersonCenter(strArr[0], strArr[1], "person_post", 18005)));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends com.baidu.tieba.person.post.a {
        TextView aSd;
        PhotoLiveCardView bGe;
        TextView ddB;
        TripleTbImageView enR;
        View enS;
        LinearLayout enT;
        View mContentView;

        @Override // com.baidu.tieba.person.post.a
        public /* bridge */ /* synthetic */ void a(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
            super.a(postInfoList, z, str);
        }

        @Override // com.baidu.tieba.person.post.a
        public /* bridge */ /* synthetic */ void a(a.InterfaceC0074a interfaceC0074a) {
            super.a(interfaceC0074a);
        }

        @Override // com.baidu.tieba.person.post.a, android.view.View.OnClickListener
        public /* bridge */ /* synthetic */ void onClick(View view) {
            super.onClick(view);
        }

        c(View view, TbPageContext<?> tbPageContext) {
            super(view, tbPageContext);
            this.mContentView = view.findViewById(u.g.item_content);
            this.aSd = (TextView) view.findViewById(u.g.title);
            this.ddB = (TextView) view.findViewById(u.g.content);
            this.enR = (TripleTbImageView) view.findViewById(u.g.images);
            this.enS = view.findViewById(u.g.post_line);
            this.bGe = (PhotoLiveCardView) view.findViewById(u.g.photo_live_card);
            this.enT = (LinearLayout) view.findViewById(u.g.person_post_item_photo_live_card);
        }

        @Override // com.baidu.tieba.person.post.a
        public void cT(int i) {
            super.cT(i);
            av.c(this.aSd, u.d.cp_cont_b, 1);
            av.c(this.ddB, u.d.cp_cont_f, 1);
            av.k(this.enS, u.d.cp_bg_line_b);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public TextView bIg;
        public TextView bIj;
        public TextView bNK;
        public TextView bdJ;
        public TextView bsk;
        public HeadImageView enL;
        public TextView enM;
        public TripleTbImageView enN;
        public TextView enO;
        public ViewGroup enP;
        public TextView enQ;

        public b(View view) {
            this.enL = (HeadImageView) view.findViewById(u.g.item_head);
            this.bIg = (TextView) view.findViewById(u.g.item_user_author_name);
            this.enM = (TextView) view.findViewById(u.g.item_address_text);
            this.bdJ = (TextView) view.findViewById(u.g.item_price_text);
            this.bIj = (TextView) view.findViewById(u.g.item_description_text);
            this.enN = (TripleTbImageView) view.findViewById(u.g.item_images);
            this.bsk = (TextView) view.findViewById(u.g.item_forum_name);
            this.enO = (TextView) view.findViewById(u.g.item_recommend_num);
            this.bNK = (TextView) view.findViewById(u.g.item_reply_num);
            this.enP = (ViewGroup) view.findViewById(u.g.item_count_down_layout);
            this.enQ = (TextView) view.findViewById(u.g.item_count_down_time);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        this.bfw.finish();
    }

    public void setThreadType(int i) {
        this.mThreadType = i;
    }

    public void in(boolean z) {
        this.enF = z;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.a
    public void onDeleteClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            this.enI = (PhotoLiveCardData) tag;
            aLQ();
        }
    }

    public void aLQ() {
        if (this.dUr == null) {
            String string = this.bfw.getPageContext().getResources().getString(u.j.del_thread_confirm);
            this.dUr = new com.baidu.tbadk.core.dialog.a(this.bfw.getActivity());
            this.dUr.cz(string);
            this.dUr.a(u.j.dialog_ok, new v(this));
            this.dUr.b(u.j.dialog_cancel, new w(this));
            this.dUr.an(true);
            this.dUr.b(this.bfw.getPageContext());
        }
        this.dUr.rT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLR() {
        if (this.enI != null) {
            if (this.dON == null) {
                this.dON = new com.baidu.tieba.tbadkCore.f.a(this.bfw);
                this.dON.setLoadDataCallBack(this.dPq);
            }
            if (!this.dON.bdc()) {
                this.bfw.showProgressBar();
                String valueOf = String.valueOf(this.enI.getForumId());
                String forumName = this.enI.getForumName();
                String valueOf2 = String.valueOf(this.enI.getThreadId());
                this.dON.a(valueOf, forumName, valueOf2, valueOf2, 0, 0, true);
                this.enI = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        if (bVar != null) {
            a(0, bVar.rg, bVar.eZR, true);
            if (bVar.rg && bVar.eZP == 0) {
                List<PersonPostModel.PostInfoList> list = this.enH;
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
                if (list.size() == 0 && this.enE != null) {
                    this.enE.io(true);
                }
            }
        }
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.bfw.hideProgressBar();
        if (z && z2) {
            this.bfw.showToast(this.bfw.getPageContext().getString(u.j.cash_del_suc));
        } else if (str != null && z2) {
            this.bfw.showToast(str);
        }
    }

    public PersonPostModel aLS() {
        return this.enm;
    }
}
