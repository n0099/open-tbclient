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
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.i;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.post.a;
import com.baidu.tieba.tbadkCore.h.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends BaseAdapter implements PhotoLiveCardView.a, PhotoLiveCardView.b, PersonPostModel.a, a.InterfaceC0073a {
    private int ckO;
    private String csN;
    public PersonPostModel csU;
    private a ctn;
    private BaseFragmentActivity mActivity;
    private final String wq;
    private com.baidu.tieba.tbadkCore.h.a cjl = null;
    private boolean cto = false;
    private List<PersonPostModel.PostInfoList> ctp = new ArrayList();
    private PhotoLiveCardData ctq = null;
    private com.baidu.tbadk.core.dialog.a cmg = null;
    private final com.baidu.adp.base.g cjF = new q(this);

    /* loaded from: classes.dex */
    public interface a {
        void b(PersonPostModel personPostModel, boolean z);
    }

    public p(BaseFragmentActivity baseFragmentActivity, String str, String str2) {
        this.mActivity = baseFragmentActivity;
        this.wq = str;
        this.csU = new PersonPostModel(this.mActivity.getPageContext());
    }

    public void fa(boolean z) {
        if (this.csU == null) {
            this.csU = new PersonPostModel(this.mActivity.getPageContext());
        }
        this.csU.fetchPost(this.mActivity.getPageContext(), this, z, this.wq, true, this.ckO);
    }

    public void ajz() {
        if (this.csU != null) {
            this.csU.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.person.PersonPostModel.a
    public void a(PersonPostModel personPostModel, boolean z) {
        if (z) {
            this.csU = personPostModel;
            if (this.csU != null) {
                this.ctp.clear();
                this.ctp.addAll(this.csU.post_list);
            }
        } else if (this.csU != null) {
            this.csU.post_list.addAll(personPostModel.post_list);
            this.ctp.addAll(personPostModel.post_list);
        }
        if (this.ctn != null) {
            this.ctn.b(personPostModel, z);
        }
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.ctn = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ctp != null) {
            return this.ctp.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jy */
    public PersonPostModel.PostInfoList getItem(int i) {
        if (this.ctp == null || this.ctp.size() - 1 < i) {
            return null;
        }
        return this.ctp.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        boolean z;
        b bVar;
        PersonPostModel.PostInfoList item = getItem(i);
        if (item == null || item.thread_type != 33) {
            z = false;
        } else {
            z = true;
        }
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(i.g.person_post_item_thread, viewGroup, false);
            b bVar2 = new b(view, this.mActivity.getPageContext());
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        if (!z) {
            bVar.csC.setPadding(0, (int) this.mActivity.getResources().getDimension(i.d.ds18), 0, 0);
            bVar.csJ.setVisibility(0);
            bVar.csF.setVisibility(0);
            bVar.csE.setVisibility(0);
            bVar.csK.setVisibility(0);
            bVar.csM.setVisibility(0);
            bVar.aPy.setVisibility(0);
            bVar.caI.setVisibility(0);
            bVar.cts.setVisibility(0);
            bVar.ctt.setVisibility(0);
            bVar.ctu.setVisibility(0);
            bVar.ctv.setVisibility(0);
            bVar.Xo.setVisibility(0);
            bVar.ctx.setVisibility(8);
            if (i == 0) {
                bVar.csJ.setVisibility(0);
            } else {
                bVar.csJ.setVisibility(8);
            }
            if (this.csN == null) {
                this.csN = item.user_portrait;
            }
            bVar.a(item, true, this.csN);
            String str = item.title;
            if (str.trim().length() > 0) {
                bVar.aPy.setText(str);
                bVar.aPy.setVisibility(0);
            } else {
                bVar.aPy.setVisibility(8);
            }
            LiveCardData a2 = a(item.anchor_info);
            if (a2.getAuthorId() != 0) {
                bVar.cts.setVisibility(8);
                bVar.ctu.setVisibility(0);
                bVar.ctw.setData(a2);
            } else {
                bVar.ctu.setVisibility(8);
                if (com.baidu.tbadk.core.m.qV().qZ() && item.media != null && item.media.length > 0) {
                    int min = Math.min(item.media.length, 3);
                    PersonPostModel.Media[] mediaArr = new PersonPostModel.Media[min];
                    for (int i2 = 0; i2 < min; i2++) {
                        mediaArr[i2] = item.media[i2];
                    }
                    bVar.cts.setVisibility(0);
                    bVar.cts.setTags(mediaArr);
                } else {
                    bVar.cts.setVisibility(8);
                    bVar.cts.setTags(null);
                }
            }
            if (item.abs_thread != null && item.abs_thread.length > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < item.abs_thread.length; i3++) {
                    sb.append(item.abs_thread[i3].text);
                }
                String sb2 = sb.toString();
                if (sb2.trim().length() > 0) {
                    bVar.caI.setText(sb2);
                    bVar.caI.setVisibility(0);
                } else {
                    bVar.caI.setVisibility(8);
                }
            } else {
                bVar.caI.setVisibility(8);
            }
            if (!bVar.caI.isShown() && a2.getAuthorId() != 0) {
                bVar.ctt.setVisibility(8);
            } else {
                bVar.ctt.setVisibility(0);
            }
            bVar.a(this);
        } else if (item != null) {
            bVar.csC.setPadding(0, 0, 0, 0);
            bVar.csJ.setVisibility(8);
            bVar.csF.setVisibility(8);
            bVar.csE.setVisibility(8);
            bVar.csK.setVisibility(8);
            bVar.csM.setVisibility(8);
            bVar.aPy.setVisibility(8);
            bVar.caI.setVisibility(8);
            bVar.cts.setVisibility(8);
            bVar.ctt.setVisibility(8);
            bVar.ctu.setVisibility(8);
            bVar.ctv.setVisibility(8);
            bVar.Xo.setVisibility(8);
            bVar.ctx.setVisibility(0);
            PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
            int i4 = 2;
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
                i4 = a(item.twzhibo_info);
                photoLiveCardData.setShowExpressionViewIndex(item.twzhibo_info.showExpressionViewIndex);
                photoLiveCardData.setShowStyle(item.twzhibo_info.showStyle);
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
            bVar.aXN.setOnClickListener(new r(this));
            bVar.aXN.setTag(item);
            bVar.aXN.setPortraitClicklistener(this);
            bVar.aXN.setDeleteButtonClickListener(this);
            bVar.aXN.setShowBottom(true);
            bVar.aXN.setShowReplyNumInButtom(true);
            bVar.aXN.setShowHead(false);
            bVar.aXN.setShowTitle(true);
            bVar.aXN.setShowRefreshTimeInTitle(true);
            bVar.aXN.setHeadPaddingTop(i.d.ds24);
            if (2 == i4) {
                bVar.aXN.setShowContent(true);
                bVar.aXN.setShowCover(false);
                bVar.aXN.setShowExpression(false);
                bVar.aXN.setShowRefreshTimeInTitle(false);
            } else {
                bVar.aXN.setShowContent(false);
                bVar.aXN.setShowCover(true);
                bVar.aXN.setShowExpression(true);
                bVar.aXN.setShowRefreshTimeInTitle(true);
            }
            bVar.aXN.setShowLiveIcon(true);
            bVar.aXN.setChooseStyle(photoLiveCardData.getShowStyle());
            bVar.aXN.setShowDeleteButtonInTitle(this.cto);
            if (this.cto) {
                bVar.aXN.setTitlePaddingRight(i.d.ds84);
            } else {
                bVar.aXN.setTitlePaddingRight(0);
            }
            bVar.aXN.setData(photoLiveCardData);
        }
        bVar.cN(TbadkCoreApplication.m411getInst().getSkinType());
        an.i(bVar.Xo, i.c.cp_bg_line_b);
        bVar.ctw.onChangeSkinType(this.mActivity.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mActivity.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.mActivity.getLayoutMode().k(bVar.mContentView);
        return view;
    }

    private int a(PersonPostModel.ZhiBoInfoTW zhiBoInfoTW) {
        return !StringUtils.isNull(zhiBoInfoTW.livecover_src) ? 1 : 2;
    }

    private ArrayList<com.baidu.tbadk.coreExtra.view.o> a(PersonPostModel.LabelInfo[] labelInfoArr) {
        ArrayList<com.baidu.tbadk.coreExtra.view.o> arrayList = new ArrayList<>();
        if (labelInfoArr == null || labelInfoArr.length <= 0) {
            return arrayList;
        }
        for (int i = 0; i < labelInfoArr.length; i++) {
            com.baidu.tbadk.coreExtra.view.o oVar = new com.baidu.tbadk.coreExtra.view.o();
            if (labelInfoArr[i] != null) {
                oVar.dD(labelInfoArr[i].labelHot);
                oVar.setLabelName(labelInfoArr[i].labelName);
                oVar.setLabelId(labelInfoArr[i].LabelId);
                arrayList.add(oVar);
            }
        }
        return arrayList;
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

    @Override // com.baidu.tieba.person.post.a.InterfaceC0073a
    public void ad(View view) {
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
        View Xo;
        TextView aPy;
        PhotoLiveCardView aXN;
        TextView caI;
        TripleTbImageView cts;
        View ctt;
        LinearLayout ctu;
        LinearLayout ctv;
        LiveBroadcastCard ctw;
        LinearLayout ctx;
        View mContentView;

        @Override // com.baidu.tieba.person.post.a
        public /* bridge */ /* synthetic */ void a(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
            super.a(postInfoList, z, str);
        }

        @Override // com.baidu.tieba.person.post.a
        public /* bridge */ /* synthetic */ void a(a.InterfaceC0073a interfaceC0073a) {
            super.a(interfaceC0073a);
        }

        @Override // com.baidu.tieba.person.post.a, android.view.View.OnClickListener
        public /* bridge */ /* synthetic */ void onClick(View view) {
            super.onClick(view);
        }

        b(View view, TbPageContext<?> tbPageContext) {
            super(view, tbPageContext);
            this.mContentView = view.findViewById(i.f.item_content);
            this.aPy = (TextView) view.findViewById(i.f.title);
            this.caI = (TextView) view.findViewById(i.f.content);
            this.cts = (TripleTbImageView) view.findViewById(i.f.images);
            this.ctt = view.findViewById(i.f.post_line);
            this.ctu = (LinearLayout) view.findViewById(i.f.person_post_item_live_card);
            this.ctw = (LiveBroadcastCard) view.findViewById(i.f.person_post_item_feed_item_card);
            this.Xo = view.findViewById(i.f.person_post_thread_item_divider_1);
            this.ctx = (LinearLayout) view.findViewById(i.f.person_post_item_photo_live_card);
            this.aXN = (PhotoLiveCardView) view.findViewById(i.f.photo_live_card);
            this.ctv = (LinearLayout) view.findViewById(i.f.person_post_item_live_card);
        }

        @Override // com.baidu.tieba.person.post.a
        public void cN(int i) {
            super.cN(i);
            an.b(this.aPy, i.c.cp_cont_b, 1);
            an.b(this.caI, i.c.cp_cont_f, 1);
            an.i(this.ctt, i.c.cp_bg_line_b);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        this.mActivity.finish();
    }

    public void bC(int i) {
        this.ckO = i;
    }

    public void fb(boolean z) {
        this.cto = z;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.a
    public void onDeleteClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            this.ctq = (PhotoLiveCardData) tag;
            ajA();
        }
    }

    public void ajA() {
        if (this.cmg == null) {
            String string = this.mActivity.getPageContext().getResources().getString(i.h.del_thread_confirm);
            this.cmg = new com.baidu.tbadk.core.dialog.a(this.mActivity.getActivity());
            this.cmg.cu(string);
            this.cmg.a(i.h.dialog_ok, new s(this));
            this.cmg.b(i.h.dialog_cancel, new t(this));
            this.cmg.aj(true);
            this.cmg.b(this.mActivity.getPageContext());
        }
        this.cmg.sR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajB() {
        if (this.ctq != null) {
            if (this.cjl == null) {
                this.cjl = new com.baidu.tieba.tbadkCore.h.a(this.mActivity);
                this.cjl.setLoadDataCallBack(this.cjF);
            }
            if (!this.cjl.ayB()) {
                this.mActivity.showProgressBar();
                String valueOf = String.valueOf(this.ctq.getForumId());
                String forumName = this.ctq.getForumName();
                String valueOf2 = String.valueOf(this.ctq.getThreadId());
                this.cjl.a(valueOf, forumName, valueOf2, valueOf2, 0, 0, true);
                this.ctq = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        if (bVar != null) {
            a(0, bVar.An, bVar.ddm, true);
            if (bVar.An && bVar.ddk == 0) {
                List<PersonPostModel.PostInfoList> list = this.ctp;
                int size = list.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    if (!(com.baidu.adp.lib.g.b.c(bVar.mPostId, -1L) == list.get(i).thread_id)) {
                        i++;
                    } else {
                        list.remove(i);
                        break;
                    }
                }
                notifyDataSetChanged();
            }
        }
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.mActivity.hideProgressBar();
        if (z && z2) {
            this.mActivity.showToast(this.mActivity.getPageContext().getString(i.h.cash_del_suc));
        } else if (str != null && z2) {
            this.mActivity.showToast(str);
        }
    }

    public PersonPostModel ajC() {
        return this.csU;
    }
}
