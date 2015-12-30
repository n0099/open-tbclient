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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.n;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.post.a;
import com.baidu.tieba.tbadkCore.f.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends BaseAdapter implements PhotoLiveCardView.a, PhotoLiveCardView.b, PersonPostModel.a, a.InterfaceC0077a {
    private int cHd;
    private a cVB;
    private String cVc;
    public PersonPostModel cVj;
    private BaseFragmentActivity mActivity;
    private final String wy;
    private com.baidu.tieba.tbadkCore.f.a cFn = null;
    private boolean cVC = false;
    private List<PersonPostModel.PostInfoList> cVD = new ArrayList();
    private PhotoLiveCardData cVE = null;
    private com.baidu.tbadk.core.dialog.a cIW = null;
    private final com.baidu.adp.base.g cFI = new q(this);

    /* loaded from: classes.dex */
    public interface a {
        void b(PersonPostModel personPostModel, boolean z);

        void fI(boolean z);
    }

    public p(BaseFragmentActivity baseFragmentActivity, String str, String str2) {
        this.mActivity = baseFragmentActivity;
        this.wy = str;
        this.cVj = new PersonPostModel(this.mActivity.getPageContext());
    }

    public void fG(boolean z) {
        if (this.cVj == null) {
            this.cVj = new PersonPostModel(this.mActivity.getPageContext());
        }
        this.cVj.fetchPost(this.mActivity.getPageContext(), this, z, this.wy, true, this.cHd);
    }

    public void apF() {
        if (this.cVj != null) {
            this.cVj.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.person.PersonPostModel.a
    public void a(PersonPostModel personPostModel, boolean z) {
        if (z) {
            this.cVj = personPostModel;
            if (this.cVj != null) {
                this.cVD.clear();
                this.cVD.addAll(this.cVj.post_list);
            }
        } else if (this.cVj != null) {
            this.cVj.post_list.addAll(personPostModel.post_list);
            this.cVD.addAll(personPostModel.post_list);
        }
        if (this.cVB != null) {
            this.cVB.b(personPostModel, z);
        }
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.cVB = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cVD != null) {
            return this.cVD.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: kS */
    public PersonPostModel.PostInfoList getItem(int i) {
        if (this.cVD == null || this.cVD.size() - 1 < i) {
            return null;
        }
        return this.cVD.get(i);
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(n.h.person_post_item_thread, viewGroup, false);
            b bVar2 = new b(view, this.mActivity.getPageContext());
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        if (!z) {
            bVar.cUR.setPadding(0, (int) this.mActivity.getResources().getDimension(n.e.ds18), 0, 0);
            bVar.cUY.setVisibility(0);
            bVar.cUU.setVisibility(0);
            bVar.cUT.setVisibility(0);
            bVar.cUZ.setVisibility(0);
            bVar.cVb.setVisibility(0);
            bVar.aOn.setVisibility(0);
            bVar.cif.setVisibility(0);
            bVar.cVG.setVisibility(0);
            bVar.cVH.setVisibility(0);
            bVar.cVI.setVisibility(0);
            bVar.cVJ.setVisibility(0);
            bVar.YE.setVisibility(0);
            bVar.cVL.setVisibility(8);
            if (i == 0) {
                bVar.cUY.setVisibility(0);
            } else {
                bVar.cUY.setVisibility(8);
            }
            if (this.cVc == null) {
                this.cVc = item.user_portrait;
            }
            bVar.a(item, true, this.cVc);
            String str = item.title;
            if (str.trim().length() > 0) {
                bVar.aOn.setText(str);
                bVar.aOn.setVisibility(0);
            } else {
                bVar.aOn.setVisibility(8);
            }
            LiveCardData a2 = a(item.anchor_info);
            if (a2.getAuthorId() != 0) {
                bVar.cVG.setVisibility(8);
                bVar.cVI.setVisibility(0);
                bVar.cVK.setData(a2);
            } else {
                bVar.cVI.setVisibility(8);
                if (com.baidu.tbadk.core.m.qQ().qW() && item.media != null && item.media.length > 0) {
                    int min = Math.min(item.media.length, 3);
                    PersonPostModel.Media[] mediaArr = new PersonPostModel.Media[min];
                    for (int i2 = 0; i2 < min; i2++) {
                        mediaArr[i2] = item.media[i2];
                    }
                    bVar.cVG.setVisibility(0);
                    bVar.cVG.setTags(mediaArr);
                } else {
                    bVar.cVG.setVisibility(8);
                    bVar.cVG.setTags(null);
                }
            }
            if (item.abs_thread != null && item.abs_thread.length > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < item.abs_thread.length; i3++) {
                    sb.append(item.abs_thread[i3].text);
                }
                String sb2 = sb.toString();
                if (sb2.trim().length() > 0) {
                    bVar.cif.setText(sb2);
                    bVar.cif.setVisibility(0);
                } else {
                    bVar.cif.setVisibility(8);
                }
            } else {
                bVar.cif.setVisibility(8);
            }
            if (!bVar.cif.isShown() && a2.getAuthorId() != 0) {
                bVar.cVH.setVisibility(8);
            } else {
                bVar.cVH.setVisibility(0);
            }
            bVar.a(this);
        } else if (item != null) {
            bVar.cUR.setPadding(0, 0, 0, 0);
            bVar.cUY.setVisibility(8);
            bVar.cUU.setVisibility(8);
            bVar.cUT.setVisibility(8);
            bVar.cUZ.setVisibility(8);
            bVar.cVb.setVisibility(8);
            bVar.aOn.setVisibility(8);
            bVar.cif.setVisibility(8);
            bVar.cVG.setVisibility(8);
            bVar.cVH.setVisibility(8);
            bVar.cVI.setVisibility(8);
            bVar.cVJ.setVisibility(8);
            bVar.YE.setVisibility(8);
            bVar.cVL.setVisibility(0);
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
            bVar.bhL.setOnClickListener(new r(this));
            bVar.bhL.setTag(item);
            bVar.bhL.setPortraitClicklistener(this);
            bVar.bhL.setDeleteButtonClickListener(this);
            bVar.bhL.setShowBottom(true);
            bVar.bhL.setShowReplyNumInButtom(true);
            bVar.bhL.setShowHead(false);
            bVar.bhL.setShowTitle(true);
            bVar.bhL.setShowRefreshTimeInTitle(true);
            bVar.bhL.setHeadPaddingTop(n.e.ds24);
            if (2 == i4) {
                bVar.bhL.setShowContent(true);
                bVar.bhL.setShowCover(false);
                bVar.bhL.setShowExpression(false);
                bVar.bhL.setShowRefreshTimeInTitle(false);
            } else {
                bVar.bhL.setShowContent(false);
                bVar.bhL.setShowCover(true);
                bVar.bhL.setShowExpression(true);
                bVar.bhL.setShowRefreshTimeInTitle(true);
            }
            bVar.bhL.setShowImage(com.baidu.tbadk.core.m.qQ().qW());
            bVar.bhL.setShowLiveIcon(true);
            bVar.bhL.setChooseStyle(photoLiveCardData.getShowStyle());
            bVar.bhL.setShowDeleteButtonInTitle(this.cVC);
            if (this.cVC) {
                bVar.bhL.setTitlePaddingRight(n.e.ds84);
            } else {
                bVar.bhL.setTitlePaddingRight(0);
            }
            bVar.bhL.setData(photoLiveCardData);
        }
        bVar.cP(TbadkCoreApplication.m411getInst().getSkinType());
        as.i(bVar.YE, n.d.cp_bg_line_b);
        bVar.cVK.onChangeSkinType(this.mActivity.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mActivity.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
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
                oVar.dM(labelInfoArr[i].labelHot);
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

    @Override // com.baidu.tieba.person.post.a.InterfaceC0077a
    public void as(View view) {
        String[] strArr;
        if (this.mActivity != null) {
            int id = view.getId();
            if (id == n.g.forum_name) {
                String str = (String) view.getTag();
                if (str != null) {
                    this.mActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mActivity.getPageContext().getPageActivity()).createNormalCfg(str, "")));
                }
            } else if (id == n.g.portrait) {
                this.mActivity.finish();
            } else if (id == n.g.username) {
                this.mActivity.finish();
            } else if ((id == n.g.item_content || id == n.g.item_header || id == n.g.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mActivity.getPageContext().getPageActivity()).createCfgForPersonCenter(strArr[0], strArr[1], "person_post", 18005)));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends com.baidu.tieba.person.post.a {
        View YE;
        TextView aOn;
        PhotoLiveCardView bhL;
        TripleTbImageView cVG;
        View cVH;
        LinearLayout cVI;
        LinearLayout cVJ;
        LiveBroadcastCard cVK;
        LinearLayout cVL;
        TextView cif;
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
            this.mContentView = view.findViewById(n.g.item_content);
            this.aOn = (TextView) view.findViewById(n.g.title);
            this.cif = (TextView) view.findViewById(n.g.content);
            this.cVG = (TripleTbImageView) view.findViewById(n.g.images);
            this.cVH = view.findViewById(n.g.post_line);
            this.cVI = (LinearLayout) view.findViewById(n.g.person_post_item_live_card);
            this.cVK = (LiveBroadcastCard) view.findViewById(n.g.person_post_item_feed_item_card);
            this.YE = view.findViewById(n.g.person_post_thread_item_divider_1);
            this.cVL = (LinearLayout) view.findViewById(n.g.person_post_item_photo_live_card);
            this.bhL = (PhotoLiveCardView) view.findViewById(n.g.photo_live_card);
            this.cVJ = (LinearLayout) view.findViewById(n.g.person_post_item_live_card);
        }

        @Override // com.baidu.tieba.person.post.a
        public void cP(int i) {
            super.cP(i);
            as.b(this.aOn, n.d.cp_cont_b, 1);
            as.b(this.cif, n.d.cp_cont_f, 1);
            as.i(this.cVH, n.d.cp_bg_line_b);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        this.mActivity.finish();
    }

    public void setThreadType(int i) {
        this.cHd = i;
    }

    public void fH(boolean z) {
        this.cVC = z;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.a
    public void onDeleteClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            this.cVE = (PhotoLiveCardData) tag;
            apG();
        }
    }

    public void apG() {
        if (this.cIW == null) {
            String string = this.mActivity.getPageContext().getResources().getString(n.j.del_thread_confirm);
            this.cIW = new com.baidu.tbadk.core.dialog.a(this.mActivity.getActivity());
            this.cIW.cF(string);
            this.cIW.a(n.j.dialog_ok, new s(this));
            this.cIW.b(n.j.dialog_cancel, new t(this));
            this.cIW.ai(true);
            this.cIW.b(this.mActivity.getPageContext());
        }
        this.cIW.tf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apH() {
        if (this.cVE != null) {
            if (this.cFn == null) {
                this.cFn = new com.baidu.tieba.tbadkCore.f.a(this.mActivity);
                this.cFn.setLoadDataCallBack(this.cFI);
            }
            if (!this.cFn.aGg()) {
                this.mActivity.showProgressBar();
                String valueOf = String.valueOf(this.cVE.getForumId());
                String forumName = this.cVE.getForumName();
                String valueOf2 = String.valueOf(this.cVE.getThreadId());
                this.cFn.a(valueOf, forumName, valueOf2, valueOf2, 0, 0, true);
                this.cVE = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        if (bVar != null) {
            a(0, bVar.Av, bVar.dJa, true);
            if (bVar.Av && bVar.dIY == 0) {
                List<PersonPostModel.PostInfoList> list = this.cVD;
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
                if (list.size() == 0 && this.cVB != null) {
                    this.cVB.fI(true);
                }
            }
        }
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.mActivity.hideProgressBar();
        if (z && z2) {
            this.mActivity.showToast(this.mActivity.getPageContext().getString(n.j.cash_del_suc));
        } else if (str != null && z2) {
            this.mActivity.showToast(str);
        }
    }

    public PersonPostModel apI() {
        return this.cVj;
    }
}
