package com.baidu.tieba.person.post;

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
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.post.a;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.f.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class q extends BaseAdapter implements PhotoLiveCardView.a, PhotoLiveCardView.b, PersonPostModel.a, a.InterfaceC0070a {
    private BdUniqueId aoj;
    private BaseFragmentActivity cSp;
    private a dEK;
    private String dEi;
    public PersonPostModel dEs;
    private int mThreadType;
    private final String mV;
    private com.baidu.tieba.tbadkCore.f.a diO = null;
    private boolean dEL = false;
    private List<PersonPostModel.PostInfoList> dEM = new ArrayList();
    private PhotoLiveCardData dEN = null;
    private com.baidu.tbadk.core.dialog.a dnT = null;
    private final com.baidu.adp.base.g djp = new r(this);

    /* loaded from: classes.dex */
    public interface a {
        void b(PersonPostModel personPostModel, boolean z);

        void ht(boolean z);
    }

    public q(BaseFragmentActivity baseFragmentActivity, String str, String str2, BdUniqueId bdUniqueId) {
        this.cSp = baseFragmentActivity;
        this.mV = str;
        this.dEs = new PersonPostModel(this.cSp.getPageContext());
        this.dEs.setUniqueId(bdUniqueId);
        this.aoj = bdUniqueId;
    }

    public void hr(boolean z) {
        if (this.dEs == null) {
            this.dEs = new PersonPostModel(this.cSp.getPageContext());
            this.dEs.setUniqueId(this.aoj);
        }
        this.dEs.fetchPost(this.cSp.getPageContext(), this, z, this.mV, true, this.mThreadType);
    }

    public void aCR() {
        if (this.dEs != null) {
            this.dEs.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.person.PersonPostModel.a
    public void a(PersonPostModel personPostModel, boolean z) {
        if (z) {
            this.dEs = personPostModel;
            if (this.dEs != null) {
                this.dEs.setUniqueId(this.aoj);
                this.dEM.clear();
                this.dEM.addAll(this.dEs.post_list);
            }
        } else if (this.dEs != null) {
            this.dEs.post_list.addAll(personPostModel.post_list);
            this.dEM.addAll(personPostModel.post_list);
        }
        if (this.dEK != null) {
            this.dEK.b(personPostModel, z);
        }
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.dEK = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dEM != null) {
            return this.dEM.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mB */
    public PersonPostModel.PostInfoList getItem(int i) {
        if (this.dEM == null || this.dEM.size() - 1 < i) {
            return null;
        }
        return this.dEM.get(i);
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
            b bVar2 = new b(view, this.cSp.getPageContext());
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        if (!z) {
            bVar.dDX.setPadding(0, (int) this.cSp.getResources().getDimension(t.e.ds18), 0, 0);
            bVar.dEf.setVisibility(0);
            bVar.dEa.setVisibility(0);
            bVar.dDZ.setVisibility(0);
            bVar.dEg.setVisibility(0);
            bVar.cQR.setVisibility(0);
            bVar.aOG.setVisibility(0);
            bVar.cyf.setVisibility(0);
            bVar.dEP.setVisibility(0);
            bVar.dEQ.setVisibility(0);
            bVar.dER.setVisibility(8);
            if (i == 0) {
                bVar.dEf.setVisibility(0);
            } else {
                bVar.dEf.setVisibility(8);
            }
            if (this.dEi == null) {
                this.dEi = item.user_portrait;
            }
            bVar.a(item, true, this.dEi);
            String str = item.title;
            if (str.trim().length() > 0) {
                bVar.aOG.setText(str);
                bVar.aOG.setVisibility(0);
            } else {
                bVar.aOG.setVisibility(8);
            }
            if (com.baidu.tbadk.core.l.ob().oh() && item.media != null && item.media.length > 0) {
                int min = Math.min(item.media.length, 3);
                PersonPostModel.Media[] mediaArr = new PersonPostModel.Media[min];
                for (int i3 = 0; i3 < min; i3++) {
                    mediaArr[i3] = item.media[i3];
                }
                bVar.dEP.hx(false);
                bVar.dEP.setVisibility(0);
                bVar.dEP.setTags(mediaArr);
            } else {
                bVar.dEP.setVisibility(8);
                bVar.dEP.setTags(null);
            }
            if (item.abs_thread != null && item.abs_thread.length > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i4 = 0; i4 < item.abs_thread.length; i4++) {
                    sb.append(item.abs_thread[i4].text);
                }
                String sb2 = sb.toString();
                if (sb2.trim().length() > 0) {
                    bVar.cyf.setText(sb2);
                    bVar.cyf.setVisibility(0);
                } else {
                    bVar.cyf.setVisibility(8);
                }
            } else {
                bVar.cyf.setVisibility(8);
            }
            bVar.dEQ.setVisibility(0);
            bVar.a(this);
        } else if (item != null) {
            bVar.dDX.setPadding(0, 0, 0, 0);
            bVar.dEf.setVisibility(8);
            bVar.dEa.setVisibility(8);
            bVar.dDZ.setVisibility(8);
            bVar.dEg.setVisibility(8);
            bVar.cQR.setVisibility(8);
            bVar.aOG.setVisibility(8);
            bVar.cyf.setVisibility(8);
            bVar.dEP.setVisibility(8);
            bVar.dEQ.setVisibility(8);
            bVar.dER.setVisibility(0);
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
            bVar.bli.setOnClickListener(new s(this));
            bVar.bli.setTag(item);
            bVar.bli.setPortraitClicklistener(this);
            bVar.bli.setDeleteButtonClickListener(this);
            bVar.bli.setShowBottom(true);
            bVar.bli.setShowReplyNumInButtom(true);
            bVar.bli.setShowHead(false);
            bVar.bli.setShowTitle(true);
            bVar.bli.setShowRefreshTimeInTitle(true);
            bVar.bli.setHeadPaddingTop(t.e.ds24);
            if (2 == i2) {
                bVar.bli.setShowContent(true);
                bVar.bli.setShowCover(false);
                bVar.bli.setShowExpression(false);
                bVar.bli.setShowRefreshTimeInTitle(false);
            } else {
                bVar.bli.setShowContent(false);
                bVar.bli.setShowCover(true);
                bVar.bli.setShowExpression(true);
                bVar.bli.setShowRefreshTimeInTitle(true);
            }
            bVar.bli.setShowImage(com.baidu.tbadk.core.l.ob().oh());
            bVar.bli.setShowLiveIcon(true);
            bVar.bli.setChooseStyle(photoLiveCardData.getShowStyle());
            bVar.bli.setShowDeleteButtonInTitle(this.dEL);
            if (this.dEL) {
                bVar.bli.setTitlePaddingRight(t.e.ds84);
            } else {
                bVar.bli.setTitlePaddingRight(0);
            }
            bVar.bli.setData(photoLiveCardData);
        }
        bVar.cS(TbadkCoreApplication.m11getInst().getSkinType());
        this.cSp.getLayoutMode().ae(TbadkCoreApplication.m11getInst().getSkinType() == 1);
        this.cSp.getLayoutMode().x(bVar.mContentView);
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
                nVar.dQ(labelInfoArr[i].labelHot);
                nVar.setLabelName(labelInfoArr[i].labelName);
                nVar.setLabelId(labelInfoArr[i].LabelId);
                arrayList.add(nVar);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.person.post.a.InterfaceC0070a
    public void aU(View view) {
        String[] strArr;
        if (this.cSp != null) {
            int id = view.getId();
            if (id == t.g.forum_name) {
                String str = (String) view.getTag();
                if (str != null) {
                    this.cSp.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cSp.getPageContext().getPageActivity()).createNormalCfg(str, "")));
                }
            } else if (id == t.g.portrait) {
                this.cSp.finish();
            } else if (id == t.g.username) {
                this.cSp.finish();
            } else if ((id == t.g.item_content || id == t.g.item_header || id == t.g.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.cSp.getPageContext().getPageActivity()).createCfgForPersonCenter(strArr[0], strArr[1], "person_post", 18005)));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends com.baidu.tieba.person.post.a {
        TextView aOG;
        PhotoLiveCardView bli;
        TextView cyf;
        TripleTbImageView dEP;
        View dEQ;
        LinearLayout dER;
        View mContentView;

        @Override // com.baidu.tieba.person.post.a
        public /* bridge */ /* synthetic */ void a(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
            super.a(postInfoList, z, str);
        }

        @Override // com.baidu.tieba.person.post.a
        public /* bridge */ /* synthetic */ void a(a.InterfaceC0070a interfaceC0070a) {
            super.a(interfaceC0070a);
        }

        @Override // com.baidu.tieba.person.post.a, android.view.View.OnClickListener
        public /* bridge */ /* synthetic */ void onClick(View view) {
            super.onClick(view);
        }

        b(View view, TbPageContext<?> tbPageContext) {
            super(view, tbPageContext);
            this.mContentView = view.findViewById(t.g.item_content);
            this.aOG = (TextView) view.findViewById(t.g.title);
            this.cyf = (TextView) view.findViewById(t.g.content);
            this.dEP = (TripleTbImageView) view.findViewById(t.g.images);
            this.dEQ = view.findViewById(t.g.post_line);
            this.bli = (PhotoLiveCardView) view.findViewById(t.g.photo_live_card);
            this.dER = (LinearLayout) view.findViewById(t.g.person_post_item_photo_live_card);
        }

        @Override // com.baidu.tieba.person.post.a
        public void cS(int i) {
            super.cS(i);
            at.c(this.aOG, t.d.cp_cont_b, 1);
            at.c(this.cyf, t.d.cp_cont_f, 1);
            at.k(this.dEQ, t.d.cp_bg_line_b);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        this.cSp.finish();
    }

    public void setThreadType(int i) {
        this.mThreadType = i;
    }

    public void hs(boolean z) {
        this.dEL = z;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.a
    public void onDeleteClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            this.dEN = (PhotoLiveCardData) tag;
            aCS();
        }
    }

    public void aCS() {
        if (this.dnT == null) {
            String string = this.cSp.getPageContext().getResources().getString(t.j.del_thread_confirm);
            this.dnT = new com.baidu.tbadk.core.dialog.a(this.cSp.getActivity());
            this.dnT.cA(string);
            this.dnT.a(t.j.dialog_ok, new t(this));
            this.dnT.b(t.j.dialog_cancel, new u(this));
            this.dnT.ap(true);
            this.dnT.b(this.cSp.getPageContext());
        }
        this.dnT.rU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCT() {
        if (this.dEN != null) {
            if (this.diO == null) {
                this.diO = new com.baidu.tieba.tbadkCore.f.a(this.cSp);
                this.diO.setLoadDataCallBack(this.djp);
            }
            if (!this.diO.aUI()) {
                this.cSp.showProgressBar();
                String valueOf = String.valueOf(this.dEN.getForumId());
                String forumName = this.dEN.getForumName();
                String valueOf2 = String.valueOf(this.dEN.getThreadId());
                this.diO.a(valueOf, forumName, valueOf2, valueOf2, 0, 0, true);
                this.dEN = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        if (bVar != null) {
            a(0, bVar.rg, bVar.evb, true);
            if (bVar.rg && bVar.euZ == 0) {
                List<PersonPostModel.PostInfoList> list = this.dEM;
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
                if (list.size() == 0 && this.dEK != null) {
                    this.dEK.ht(true);
                }
            }
        }
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.cSp.hideProgressBar();
        if (z && z2) {
            this.cSp.showToast(this.cSp.getPageContext().getString(t.j.cash_del_suc));
        } else if (str != null && z2) {
            this.cSp.showToast(str);
        }
    }

    public PersonPostModel aCU() {
        return this.dEs;
    }
}
