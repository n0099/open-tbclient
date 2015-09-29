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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.i;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.post.a;
import com.baidu.tieba.tbadkCore.g.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends BaseAdapter implements PhotoLiveCardView.a, PhotoLiveCardView.b, PersonPostModel.a, a.InterfaceC0072a {
    private int cjq;
    private a crG;
    private String crg;
    public PersonPostModel crn;
    private BaseFragmentActivity mActivity;
    private final String wq;
    private com.baidu.tieba.tbadkCore.g.a chX = null;
    private boolean crH = false;
    private List<PersonPostModel.PostInfoList> crI = new ArrayList();
    private PhotoLiveCardData crJ = null;
    private com.baidu.tbadk.core.dialog.a ckH = null;
    private final com.baidu.adp.base.g cir = new q(this);

    /* loaded from: classes.dex */
    public interface a {
        void b(PersonPostModel personPostModel, boolean z);
    }

    public p(BaseFragmentActivity baseFragmentActivity, String str, String str2) {
        this.mActivity = baseFragmentActivity;
        this.wq = str;
        this.crn = new PersonPostModel(this.mActivity.getPageContext());
    }

    public void eX(boolean z) {
        if (this.crn == null) {
            this.crn = new PersonPostModel(this.mActivity.getPageContext());
        }
        this.crn.fetchPost(this.mActivity.getPageContext(), this, z, this.wq, true, this.cjq);
    }

    public void aiX() {
        if (this.crn != null) {
            this.crn.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.person.PersonPostModel.a
    public void a(PersonPostModel personPostModel, boolean z) {
        if (z) {
            this.crn = personPostModel;
            if (this.crn != null) {
                this.crI.clear();
                this.crI.addAll(this.crn.post_list);
            }
        } else if (this.crn != null) {
            this.crn.post_list.addAll(personPostModel.post_list);
            this.crI.addAll(personPostModel.post_list);
        }
        if (this.crG != null) {
            this.crG.b(personPostModel, z);
        }
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.crG = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.crI != null) {
            return this.crI.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jk */
    public PersonPostModel.PostInfoList getItem(int i) {
        if (this.crI == null || this.crI.size() - 1 < i) {
            return null;
        }
        return this.crI.get(i);
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
            bVar.cqV.setPadding(0, (int) this.mActivity.getResources().getDimension(i.d.ds18), 0, 0);
            bVar.crc.setVisibility(0);
            bVar.cqY.setVisibility(0);
            bVar.cqX.setVisibility(0);
            bVar.crd.setVisibility(0);
            bVar.crf.setVisibility(0);
            bVar.aPf.setVisibility(0);
            bVar.bZW.setVisibility(0);
            bVar.crL.setVisibility(0);
            bVar.crM.setVisibility(0);
            bVar.crN.setVisibility(0);
            bVar.crO.setVisibility(0);
            bVar.Xj.setVisibility(0);
            bVar.crQ.setVisibility(8);
            if (i == 0) {
                bVar.crc.setVisibility(0);
            } else {
                bVar.crc.setVisibility(8);
            }
            if (this.crg == null) {
                this.crg = item.user_portrait;
            }
            bVar.a(item, true, this.crg);
            String str = item.title;
            if (str.trim().length() > 0) {
                bVar.aPf.setText(str);
                bVar.aPf.setVisibility(0);
            } else {
                bVar.aPf.setVisibility(8);
            }
            LiveCardData a2 = a(item.anchor_info);
            if (a2.getAuthorId() != 0) {
                bVar.crL.setVisibility(8);
                bVar.crN.setVisibility(0);
                bVar.crP.setData(a2);
            } else {
                bVar.crN.setVisibility(8);
                if (com.baidu.tbadk.core.m.qX().rb() && item.media != null && item.media.length > 0) {
                    int min = Math.min(item.media.length, 3);
                    PersonPostModel.Media[] mediaArr = new PersonPostModel.Media[min];
                    for (int i2 = 0; i2 < min; i2++) {
                        mediaArr[i2] = item.media[i2];
                    }
                    bVar.crL.setVisibility(0);
                    bVar.crL.setTags(mediaArr);
                } else {
                    bVar.crL.setVisibility(8);
                    bVar.crL.setTags(null);
                }
            }
            if (item.abs_thread != null && item.abs_thread.length > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < item.abs_thread.length; i3++) {
                    sb.append(item.abs_thread[i3].text);
                }
                String sb2 = sb.toString();
                if (sb2.trim().length() > 0) {
                    bVar.bZW.setText(sb2);
                    bVar.bZW.setVisibility(0);
                } else {
                    bVar.bZW.setVisibility(8);
                }
            } else {
                bVar.bZW.setVisibility(8);
            }
            if (!bVar.bZW.isShown() && a2.getAuthorId() != 0) {
                bVar.crM.setVisibility(8);
            } else {
                bVar.crM.setVisibility(0);
            }
            bVar.a(this);
        } else if (item != null) {
            bVar.cqV.setPadding(0, 0, 0, 0);
            bVar.crc.setVisibility(8);
            bVar.cqY.setVisibility(8);
            bVar.cqX.setVisibility(8);
            bVar.crd.setVisibility(8);
            bVar.crf.setVisibility(8);
            bVar.aPf.setVisibility(8);
            bVar.bZW.setVisibility(8);
            bVar.crL.setVisibility(8);
            bVar.crM.setVisibility(8);
            bVar.crN.setVisibility(8);
            bVar.crO.setVisibility(8);
            bVar.Xj.setVisibility(8);
            bVar.crQ.setVisibility(0);
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
            bVar.aXt.setOnClickListener(new r(this));
            bVar.aXt.setTag(item);
            bVar.aXt.setPortraitClicklistener(this);
            bVar.aXt.setDeleteButtonClickListener(this);
            bVar.aXt.setShowBottom(true);
            bVar.aXt.setShowReplyNumInButtom(true);
            bVar.aXt.setShowHead(false);
            bVar.aXt.setShowTitle(true);
            bVar.aXt.setShowRefreshTimeInTitle(true);
            bVar.aXt.setHeadPaddingTop(i.d.ds24);
            if (2 == i4) {
                bVar.aXt.setShowContent(true);
                bVar.aXt.setShowCover(false);
                bVar.aXt.setShowExpression(false);
                bVar.aXt.setShowRefreshTimeInTitle(false);
            } else {
                bVar.aXt.setShowContent(false);
                bVar.aXt.setShowCover(true);
                bVar.aXt.setShowExpression(true);
                bVar.aXt.setShowRefreshTimeInTitle(true);
            }
            bVar.aXt.setShowLiveIcon(true);
            bVar.aXt.setChooseStyle(photoLiveCardData.getShowStyle());
            bVar.aXt.setShowDeleteButtonInTitle(this.crH);
            if (this.crH) {
                bVar.aXt.setTitlePaddingRight(i.d.ds84);
            } else {
                bVar.aXt.setTitlePaddingRight(0);
            }
            bVar.aXt.setData(photoLiveCardData);
        }
        bVar.cN(TbadkCoreApplication.m411getInst().getSkinType());
        am.i(bVar.Xj, i.c.cp_bg_line_b);
        bVar.crP.onChangeSkinType(this.mActivity.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
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

    @Override // com.baidu.tieba.person.post.a.InterfaceC0072a
    public void ae(View view) {
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
        View Xj;
        TextView aPf;
        PhotoLiveCardView aXt;
        TextView bZW;
        TripleTbImageView crL;
        View crM;
        LinearLayout crN;
        LinearLayout crO;
        LiveBroadcastCard crP;
        LinearLayout crQ;
        View mContentView;

        @Override // com.baidu.tieba.person.post.a
        public /* bridge */ /* synthetic */ void a(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
            super.a(postInfoList, z, str);
        }

        @Override // com.baidu.tieba.person.post.a
        public /* bridge */ /* synthetic */ void a(a.InterfaceC0072a interfaceC0072a) {
            super.a(interfaceC0072a);
        }

        @Override // com.baidu.tieba.person.post.a, android.view.View.OnClickListener
        public /* bridge */ /* synthetic */ void onClick(View view) {
            super.onClick(view);
        }

        b(View view, TbPageContext<?> tbPageContext) {
            super(view, tbPageContext);
            this.mContentView = view.findViewById(i.f.item_content);
            this.aPf = (TextView) view.findViewById(i.f.title);
            this.bZW = (TextView) view.findViewById(i.f.content);
            this.crL = (TripleTbImageView) view.findViewById(i.f.images);
            this.crM = view.findViewById(i.f.post_line);
            this.crN = (LinearLayout) view.findViewById(i.f.person_post_item_live_card);
            this.crP = (LiveBroadcastCard) view.findViewById(i.f.person_post_item_feed_item_card);
            this.Xj = view.findViewById(i.f.person_post_thread_item_divider_1);
            this.crQ = (LinearLayout) view.findViewById(i.f.person_post_item_photo_live_card);
            this.aXt = (PhotoLiveCardView) view.findViewById(i.f.photo_live_card);
            this.crO = (LinearLayout) view.findViewById(i.f.person_post_item_live_card);
        }

        @Override // com.baidu.tieba.person.post.a
        public void cN(int i) {
            super.cN(i);
            am.b(this.aPf, i.c.cp_cont_b, 1);
            am.b(this.bZW, i.c.cp_cont_f, 1);
            am.i(this.crM, i.c.cp_bg_line_b);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        this.mActivity.finish();
    }

    public void bC(int i) {
        this.cjq = i;
    }

    public void eY(boolean z) {
        this.crH = z;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.a
    public void onDeleteClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            this.crJ = (PhotoLiveCardData) tag;
            aiY();
        }
    }

    public void aiY() {
        if (this.ckH == null) {
            String string = this.mActivity.getPageContext().getResources().getString(i.h.del_thread_confirm);
            this.ckH = new com.baidu.tbadk.core.dialog.a(this.mActivity.getActivity());
            this.ckH.ct(string);
            this.ckH.a(i.h.dialog_ok, new s(this));
            this.ckH.b(i.h.dialog_cancel, new t(this));
            this.ckH.aj(true);
            this.ckH.b(this.mActivity.getPageContext());
        }
        this.ckH.sR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiZ() {
        if (this.crJ != null) {
            if (this.chX == null) {
                this.chX = new com.baidu.tieba.tbadkCore.g.a(this.mActivity);
                this.chX.setLoadDataCallBack(this.cir);
            }
            if (!this.chX.axm()) {
                this.mActivity.showProgressBar();
                String valueOf = String.valueOf(this.crJ.getForumId());
                String forumName = this.crJ.getForumName();
                String valueOf2 = String.valueOf(this.crJ.getThreadId());
                this.chX.a(valueOf, forumName, valueOf2, valueOf2, 0, 0, true);
                this.crJ = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        if (bVar != null) {
            a(0, bVar.An, bVar.daB, true);
            if (bVar.An && bVar.daz == 0) {
                List<PersonPostModel.PostInfoList> list = this.crI;
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

    public PersonPostModel aja() {
        return this.crn;
    }
}
