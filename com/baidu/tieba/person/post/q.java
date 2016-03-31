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
public class q extends BaseAdapter implements PhotoLiveCardView.a, PhotoLiveCardView.b, PersonPostModel.a, a.InterfaceC0077a {
    private a dBC;
    private String dBb;
    public PersonPostModel dBj;
    private BdUniqueId dBk;
    private BaseFragmentActivity duj;
    private int mThreadType;
    private final String wY;
    private com.baidu.tieba.tbadkCore.f.a dgC = null;
    private boolean dBD = false;
    private List<PersonPostModel.PostInfoList> dBE = new ArrayList();
    private PhotoLiveCardData dBF = null;
    private com.baidu.tbadk.core.dialog.a dlz = null;
    private final com.baidu.adp.base.g dhe = new r(this);

    /* loaded from: classes.dex */
    public interface a {
        void b(PersonPostModel personPostModel, boolean z);

        void gN(boolean z);
    }

    public q(BaseFragmentActivity baseFragmentActivity, String str, String str2, BdUniqueId bdUniqueId) {
        this.duj = baseFragmentActivity;
        this.wY = str;
        this.dBj = new PersonPostModel(this.duj.getPageContext());
        this.dBj.setUniqueId(bdUniqueId);
        this.dBk = bdUniqueId;
    }

    public void gL(boolean z) {
        if (this.dBj == null) {
            this.dBj = new PersonPostModel(this.duj.getPageContext());
            this.dBj.setUniqueId(this.dBk);
        }
        this.dBj.fetchPost(this.duj.getPageContext(), this, z, this.wY, true, this.mThreadType);
    }

    public void aCy() {
        if (this.dBj != null) {
            this.dBj.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.person.PersonPostModel.a
    public void a(PersonPostModel personPostModel, boolean z) {
        if (z) {
            this.dBj = personPostModel;
            if (this.dBj != null) {
                this.dBj.setUniqueId(this.dBk);
                this.dBE.clear();
                this.dBE.addAll(this.dBj.post_list);
            }
        } else if (this.dBj != null) {
            this.dBj.post_list.addAll(personPostModel.post_list);
            this.dBE.addAll(personPostModel.post_list);
        }
        if (this.dBC != null) {
            this.dBC.b(personPostModel, z);
        }
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.dBC = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dBE != null) {
            return this.dBE.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mK */
    public PersonPostModel.PostInfoList getItem(int i) {
        if (this.dBE == null || this.dBE.size() - 1 < i) {
            return null;
        }
        return this.dBE.get(i);
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
            b bVar2 = new b(view, this.duj.getPageContext());
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        if (!z) {
            bVar.dAQ.setPadding(0, (int) this.duj.getResources().getDimension(t.e.ds18), 0, 0);
            bVar.dAY.setVisibility(0);
            bVar.dAT.setVisibility(0);
            bVar.dAS.setVisibility(0);
            bVar.dAZ.setVisibility(0);
            bVar.cPU.setVisibility(0);
            bVar.aSh.setVisibility(0);
            bVar.cxh.setVisibility(0);
            bVar.dBH.setVisibility(0);
            bVar.dBI.setVisibility(0);
            bVar.dBJ.setVisibility(8);
            if (i == 0) {
                bVar.dAY.setVisibility(0);
            } else {
                bVar.dAY.setVisibility(8);
            }
            if (this.dBb == null) {
                this.dBb = item.user_portrait;
            }
            bVar.a(item, true, this.dBb);
            String str = item.title;
            if (str.trim().length() > 0) {
                bVar.aSh.setText(str);
                bVar.aSh.setVisibility(0);
            } else {
                bVar.aSh.setVisibility(8);
            }
            if (com.baidu.tbadk.core.l.qE().qK() && item.media != null && item.media.length > 0) {
                int min = Math.min(item.media.length, 3);
                PersonPostModel.Media[] mediaArr = new PersonPostModel.Media[min];
                for (int i3 = 0; i3 < min; i3++) {
                    mediaArr[i3] = item.media[i3];
                }
                bVar.dBH.gQ(false);
                bVar.dBH.setVisibility(0);
                bVar.dBH.setTags(mediaArr);
            } else {
                bVar.dBH.setVisibility(8);
                bVar.dBH.setTags(null);
            }
            if (item.abs_thread != null && item.abs_thread.length > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i4 = 0; i4 < item.abs_thread.length; i4++) {
                    sb.append(item.abs_thread[i4].text);
                }
                String sb2 = sb.toString();
                if (sb2.trim().length() > 0) {
                    bVar.cxh.setText(sb2);
                    bVar.cxh.setVisibility(0);
                } else {
                    bVar.cxh.setVisibility(8);
                }
            } else {
                bVar.cxh.setVisibility(8);
            }
            bVar.dBI.setVisibility(0);
            bVar.a(this);
        } else if (item != null) {
            bVar.dAQ.setPadding(0, 0, 0, 0);
            bVar.dAY.setVisibility(8);
            bVar.dAT.setVisibility(8);
            bVar.dAS.setVisibility(8);
            bVar.dAZ.setVisibility(8);
            bVar.cPU.setVisibility(8);
            bVar.aSh.setVisibility(8);
            bVar.cxh.setVisibility(8);
            bVar.dBH.setVisibility(8);
            bVar.dBI.setVisibility(8);
            bVar.dBJ.setVisibility(0);
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
            bVar.bpS.setOnClickListener(new s(this));
            bVar.bpS.setTag(item);
            bVar.bpS.setPortraitClicklistener(this);
            bVar.bpS.setDeleteButtonClickListener(this);
            bVar.bpS.setShowBottom(true);
            bVar.bpS.setShowReplyNumInButtom(true);
            bVar.bpS.setShowHead(false);
            bVar.bpS.setShowTitle(true);
            bVar.bpS.setShowRefreshTimeInTitle(true);
            bVar.bpS.setHeadPaddingTop(t.e.ds24);
            if (2 == i2) {
                bVar.bpS.setShowContent(true);
                bVar.bpS.setShowCover(false);
                bVar.bpS.setShowExpression(false);
                bVar.bpS.setShowRefreshTimeInTitle(false);
            } else {
                bVar.bpS.setShowContent(false);
                bVar.bpS.setShowCover(true);
                bVar.bpS.setShowExpression(true);
                bVar.bpS.setShowRefreshTimeInTitle(true);
            }
            bVar.bpS.setShowImage(com.baidu.tbadk.core.l.qE().qK());
            bVar.bpS.setShowLiveIcon(true);
            bVar.bpS.setChooseStyle(photoLiveCardData.getShowStyle());
            bVar.bpS.setShowDeleteButtonInTitle(this.dBD);
            if (this.dBD) {
                bVar.bpS.setTitlePaddingRight(t.e.ds84);
            } else {
                bVar.bpS.setTitlePaddingRight(0);
            }
            bVar.bpS.setData(photoLiveCardData);
        }
        bVar.dj(TbadkCoreApplication.m411getInst().getSkinType());
        this.duj.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.duj.getLayoutMode().x(bVar.mContentView);
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
                nVar.ek(labelInfoArr[i].labelHot);
                nVar.setLabelName(labelInfoArr[i].labelName);
                nVar.setLabelId(labelInfoArr[i].LabelId);
                arrayList.add(nVar);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.person.post.a.InterfaceC0077a
    public void aQ(View view) {
        String[] strArr;
        if (this.duj != null) {
            int id = view.getId();
            if (id == t.g.forum_name) {
                String str = (String) view.getTag();
                if (str != null) {
                    this.duj.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.duj.getPageContext().getPageActivity()).createNormalCfg(str, "")));
                }
            } else if (id == t.g.portrait) {
                this.duj.finish();
            } else if (id == t.g.username) {
                this.duj.finish();
            } else if ((id == t.g.item_content || id == t.g.item_header || id == t.g.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.duj.getPageContext().getPageActivity()).createCfgForPersonCenter(strArr[0], strArr[1], "person_post", 18005)));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends com.baidu.tieba.person.post.a {
        TextView aSh;
        PhotoLiveCardView bpS;
        TextView cxh;
        TripleTbImageView dBH;
        View dBI;
        LinearLayout dBJ;
        View mContentView;

        @Override // com.baidu.tieba.person.post.a
        public /* bridge */ /* synthetic */ void a(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
            super.a(postInfoList, z, str);
        }

        @Override // com.baidu.tieba.person.post.a
        public /* bridge */ /* synthetic */ void a(a.InterfaceC0077a interfaceC0077a) {
            super.a(interfaceC0077a);
        }

        @Override // com.baidu.tieba.person.post.a, android.view.View.OnClickListener
        public /* bridge */ /* synthetic */ void onClick(View view) {
            super.onClick(view);
        }

        b(View view, TbPageContext<?> tbPageContext) {
            super(view, tbPageContext);
            this.mContentView = view.findViewById(t.g.item_content);
            this.aSh = (TextView) view.findViewById(t.g.title);
            this.cxh = (TextView) view.findViewById(t.g.content);
            this.dBH = (TripleTbImageView) view.findViewById(t.g.images);
            this.dBI = view.findViewById(t.g.post_line);
            this.bpS = (PhotoLiveCardView) view.findViewById(t.g.photo_live_card);
            this.dBJ = (LinearLayout) view.findViewById(t.g.person_post_item_photo_live_card);
        }

        @Override // com.baidu.tieba.person.post.a
        public void dj(int i) {
            super.dj(i);
            at.b(this.aSh, t.d.cp_cont_b, 1);
            at.b(this.cxh, t.d.cp_cont_f, 1);
            at.k(this.dBI, t.d.cp_bg_line_b);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        this.duj.finish();
    }

    public void setThreadType(int i) {
        this.mThreadType = i;
    }

    public void gM(boolean z) {
        this.dBD = z;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.a
    public void onDeleteClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            this.dBF = (PhotoLiveCardData) tag;
            aCz();
        }
    }

    public void aCz() {
        if (this.dlz == null) {
            String string = this.duj.getPageContext().getResources().getString(t.j.del_thread_confirm);
            this.dlz = new com.baidu.tbadk.core.dialog.a(this.duj.getActivity());
            this.dlz.cC(string);
            this.dlz.a(t.j.dialog_ok, new t(this));
            this.dlz.b(t.j.dialog_cancel, new u(this));
            this.dlz.am(true);
            this.dlz.b(this.duj.getPageContext());
        }
        this.dlz.up();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCA() {
        if (this.dBF != null) {
            if (this.dgC == null) {
                this.dgC = new com.baidu.tieba.tbadkCore.f.a(this.duj);
                this.dgC.setLoadDataCallBack(this.dhe);
            }
            if (!this.dgC.aUn()) {
                this.duj.showProgressBar();
                String valueOf = String.valueOf(this.dBF.getForumId());
                String forumName = this.dBF.getForumName();
                String valueOf2 = String.valueOf(this.dBF.getThreadId());
                this.dgC.a(valueOf, forumName, valueOf2, valueOf2, 0, 0, true);
                this.dBF = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        if (bVar != null) {
            a(0, bVar.AU, bVar.erS, true);
            if (bVar.AU && bVar.erQ == 0) {
                List<PersonPostModel.PostInfoList> list = this.dBE;
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
                if (list.size() == 0 && this.dBC != null) {
                    this.dBC.gN(true);
                }
            }
        }
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.duj.hideProgressBar();
        if (z && z2) {
            this.duj.showToast(this.duj.getPageContext().getString(t.j.cash_del_suc));
        } else if (str != null && z2) {
            this.duj.showToast(str);
        }
    }

    public PersonPostModel aCB() {
        return this.dBj;
    }
}
