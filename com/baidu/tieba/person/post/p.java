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
public class p extends BaseAdapter implements PhotoLiveCardView.a, PhotoLiveCardView.b, PersonPostModel.a, a.InterfaceC0082a {
    private int cDo;
    private String cQA;
    public PersonPostModel cQH;
    private a cQZ;
    private BaseFragmentActivity mActivity;
    private final String ww;
    private com.baidu.tieba.tbadkCore.f.a cBI = null;
    private boolean cRa = false;
    private List<PersonPostModel.PostInfoList> cRb = new ArrayList();
    private PhotoLiveCardData cRc = null;
    private com.baidu.tbadk.core.dialog.a cEX = null;
    private final com.baidu.adp.base.g cCc = new q(this);

    /* loaded from: classes.dex */
    public interface a {
        void b(PersonPostModel personPostModel, boolean z);

        void fJ(boolean z);
    }

    public p(BaseFragmentActivity baseFragmentActivity, String str, String str2) {
        this.mActivity = baseFragmentActivity;
        this.ww = str;
        this.cQH = new PersonPostModel(this.mActivity.getPageContext());
    }

    public void fH(boolean z) {
        if (this.cQH == null) {
            this.cQH = new PersonPostModel(this.mActivity.getPageContext());
        }
        this.cQH.fetchPost(this.mActivity.getPageContext(), this, z, this.ww, true, this.cDo);
    }

    public void aov() {
        if (this.cQH != null) {
            this.cQH.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.person.PersonPostModel.a
    public void a(PersonPostModel personPostModel, boolean z) {
        if (z) {
            this.cQH = personPostModel;
            if (this.cQH != null) {
                this.cRb.clear();
                this.cRb.addAll(this.cQH.post_list);
            }
        } else if (this.cQH != null) {
            this.cQH.post_list.addAll(personPostModel.post_list);
            this.cRb.addAll(personPostModel.post_list);
        }
        if (this.cQZ != null) {
            this.cQZ.b(personPostModel, z);
        }
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.cQZ = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cRb != null) {
            return this.cRb.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: kv */
    public PersonPostModel.PostInfoList getItem(int i) {
        if (this.cRb == null || this.cRb.size() - 1 < i) {
            return null;
        }
        return this.cRb.get(i);
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(n.g.person_post_item_thread, viewGroup, false);
            b bVar2 = new b(view, this.mActivity.getPageContext());
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        if (!z) {
            bVar.cQp.setPadding(0, (int) this.mActivity.getResources().getDimension(n.d.ds18), 0, 0);
            bVar.cQw.setVisibility(0);
            bVar.cQs.setVisibility(0);
            bVar.cQr.setVisibility(0);
            bVar.cQx.setVisibility(0);
            bVar.cQz.setVisibility(0);
            bVar.aUB.setVisibility(0);
            bVar.cee.setVisibility(0);
            bVar.cRe.setVisibility(0);
            bVar.cRf.setVisibility(0);
            bVar.cRg.setVisibility(0);
            bVar.cRh.setVisibility(0);
            bVar.Yb.setVisibility(0);
            bVar.cRj.setVisibility(8);
            if (i == 0) {
                bVar.cQw.setVisibility(0);
            } else {
                bVar.cQw.setVisibility(8);
            }
            if (this.cQA == null) {
                this.cQA = item.user_portrait;
            }
            bVar.a(item, true, this.cQA);
            String str = item.title;
            if (str.trim().length() > 0) {
                bVar.aUB.setText(str);
                bVar.aUB.setVisibility(0);
            } else {
                bVar.aUB.setVisibility(8);
            }
            LiveCardData a2 = a(item.anchor_info);
            if (a2.getAuthorId() != 0) {
                bVar.cRe.setVisibility(8);
                bVar.cRg.setVisibility(0);
                bVar.cRi.setData(a2);
            } else {
                bVar.cRg.setVisibility(8);
                if (com.baidu.tbadk.core.m.rh().rn() && item.media != null && item.media.length > 0) {
                    int min = Math.min(item.media.length, 3);
                    PersonPostModel.Media[] mediaArr = new PersonPostModel.Media[min];
                    for (int i2 = 0; i2 < min; i2++) {
                        mediaArr[i2] = item.media[i2];
                    }
                    bVar.cRe.setVisibility(0);
                    bVar.cRe.setTags(mediaArr);
                } else {
                    bVar.cRe.setVisibility(8);
                    bVar.cRe.setTags(null);
                }
            }
            if (item.abs_thread != null && item.abs_thread.length > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < item.abs_thread.length; i3++) {
                    sb.append(item.abs_thread[i3].text);
                }
                String sb2 = sb.toString();
                if (sb2.trim().length() > 0) {
                    bVar.cee.setText(sb2);
                    bVar.cee.setVisibility(0);
                } else {
                    bVar.cee.setVisibility(8);
                }
            } else {
                bVar.cee.setVisibility(8);
            }
            if (!bVar.cee.isShown() && a2.getAuthorId() != 0) {
                bVar.cRf.setVisibility(8);
            } else {
                bVar.cRf.setVisibility(0);
            }
            bVar.a(this);
        } else if (item != null) {
            bVar.cQp.setPadding(0, 0, 0, 0);
            bVar.cQw.setVisibility(8);
            bVar.cQs.setVisibility(8);
            bVar.cQr.setVisibility(8);
            bVar.cQx.setVisibility(8);
            bVar.cQz.setVisibility(8);
            bVar.aUB.setVisibility(8);
            bVar.cee.setVisibility(8);
            bVar.cRe.setVisibility(8);
            bVar.cRf.setVisibility(8);
            bVar.cRg.setVisibility(8);
            bVar.cRh.setVisibility(8);
            bVar.Yb.setVisibility(8);
            bVar.cRj.setVisibility(0);
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
            bVar.bdM.setOnClickListener(new r(this));
            bVar.bdM.setTag(item);
            bVar.bdM.setPortraitClicklistener(this);
            bVar.bdM.setDeleteButtonClickListener(this);
            bVar.bdM.setShowBottom(true);
            bVar.bdM.setShowReplyNumInButtom(true);
            bVar.bdM.setShowHead(false);
            bVar.bdM.setShowTitle(true);
            bVar.bdM.setShowRefreshTimeInTitle(true);
            bVar.bdM.setHeadPaddingTop(n.d.ds24);
            if (2 == i4) {
                bVar.bdM.setShowContent(true);
                bVar.bdM.setShowCover(false);
                bVar.bdM.setShowExpression(false);
                bVar.bdM.setShowRefreshTimeInTitle(false);
            } else {
                bVar.bdM.setShowContent(false);
                bVar.bdM.setShowCover(true);
                bVar.bdM.setShowExpression(true);
                bVar.bdM.setShowRefreshTimeInTitle(true);
            }
            bVar.bdM.setShowLiveIcon(true);
            bVar.bdM.setChooseStyle(photoLiveCardData.getShowStyle());
            bVar.bdM.setShowDeleteButtonInTitle(this.cRa);
            if (this.cRa) {
                bVar.bdM.setTitlePaddingRight(n.d.ds84);
            } else {
                bVar.bdM.setTitlePaddingRight(0);
            }
            bVar.bdM.setData(photoLiveCardData);
        }
        bVar.cV(TbadkCoreApplication.m411getInst().getSkinType());
        as.i(bVar.Yb, n.c.cp_bg_line_b);
        bVar.cRi.onChangeSkinType(this.mActivity.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mActivity.getLayoutMode().af(TbadkCoreApplication.m411getInst().getSkinType() == 1);
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
                oVar.dS(labelInfoArr[i].labelHot);
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

    @Override // com.baidu.tieba.person.post.a.InterfaceC0082a
    public void am(View view) {
        String[] strArr;
        if (this.mActivity != null) {
            int id = view.getId();
            if (id == n.f.forum_name) {
                String str = (String) view.getTag();
                if (str != null) {
                    this.mActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mActivity.getPageContext().getPageActivity()).createNormalCfg(str, "")));
                }
            } else if (id == n.f.portrait) {
                this.mActivity.finish();
            } else if (id == n.f.username) {
                this.mActivity.finish();
            } else if ((id == n.f.item_content || id == n.f.item_header || id == n.f.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mActivity.getPageContext().getPageActivity()).createCfgForPersonCenter(strArr[0], strArr[1], "person_post", 18005)));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends com.baidu.tieba.person.post.a {
        View Yb;
        TextView aUB;
        PhotoLiveCardView bdM;
        TripleTbImageView cRe;
        View cRf;
        LinearLayout cRg;
        LinearLayout cRh;
        LiveBroadcastCard cRi;
        LinearLayout cRj;
        TextView cee;
        View mContentView;

        @Override // com.baidu.tieba.person.post.a
        public /* bridge */ /* synthetic */ void a(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
            super.a(postInfoList, z, str);
        }

        @Override // com.baidu.tieba.person.post.a
        public /* bridge */ /* synthetic */ void a(a.InterfaceC0082a interfaceC0082a) {
            super.a(interfaceC0082a);
        }

        @Override // com.baidu.tieba.person.post.a, android.view.View.OnClickListener
        public /* bridge */ /* synthetic */ void onClick(View view) {
            super.onClick(view);
        }

        b(View view, TbPageContext<?> tbPageContext) {
            super(view, tbPageContext);
            this.mContentView = view.findViewById(n.f.item_content);
            this.aUB = (TextView) view.findViewById(n.f.title);
            this.cee = (TextView) view.findViewById(n.f.content);
            this.cRe = (TripleTbImageView) view.findViewById(n.f.images);
            this.cRf = view.findViewById(n.f.post_line);
            this.cRg = (LinearLayout) view.findViewById(n.f.person_post_item_live_card);
            this.cRi = (LiveBroadcastCard) view.findViewById(n.f.person_post_item_feed_item_card);
            this.Yb = view.findViewById(n.f.person_post_thread_item_divider_1);
            this.cRj = (LinearLayout) view.findViewById(n.f.person_post_item_photo_live_card);
            this.bdM = (PhotoLiveCardView) view.findViewById(n.f.photo_live_card);
            this.cRh = (LinearLayout) view.findViewById(n.f.person_post_item_live_card);
        }

        @Override // com.baidu.tieba.person.post.a
        public void cV(int i) {
            super.cV(i);
            as.b(this.aUB, n.c.cp_cont_b, 1);
            as.b(this.cee, n.c.cp_cont_f, 1);
            as.i(this.cRf, n.c.cp_bg_line_b);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        this.mActivity.finish();
    }

    public void setThreadType(int i) {
        this.cDo = i;
    }

    public void fI(boolean z) {
        this.cRa = z;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.a
    public void onDeleteClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            this.cRc = (PhotoLiveCardData) tag;
            aow();
        }
    }

    public void aow() {
        if (this.cEX == null) {
            String string = this.mActivity.getPageContext().getResources().getString(n.i.del_thread_confirm);
            this.cEX = new com.baidu.tbadk.core.dialog.a(this.mActivity.getActivity());
            this.cEX.cC(string);
            this.cEX.a(n.i.dialog_ok, new s(this));
            this.cEX.b(n.i.dialog_cancel, new t(this));
            this.cEX.al(true);
            this.cEX.b(this.mActivity.getPageContext());
        }
        this.cEX.tv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aox() {
        if (this.cRc != null) {
            if (this.cBI == null) {
                this.cBI = new com.baidu.tieba.tbadkCore.f.a(this.mActivity);
                this.cBI.setLoadDataCallBack(this.cCc);
            }
            if (!this.cBI.aDT()) {
                this.mActivity.showProgressBar();
                String valueOf = String.valueOf(this.cRc.getForumId());
                String forumName = this.cRc.getForumName();
                String valueOf2 = String.valueOf(this.cRc.getThreadId());
                this.cBI.a(valueOf, forumName, valueOf2, valueOf2, 0, 0, true);
                this.cRc = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        if (bVar != null) {
            a(0, bVar.At, bVar.dBx, true);
            if (bVar.At && bVar.dBv == 0) {
                List<PersonPostModel.PostInfoList> list = this.cRb;
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
                if (list.size() == 0 && this.cQZ != null) {
                    this.cQZ.fJ(true);
                }
            }
        }
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.mActivity.hideProgressBar();
        if (z && z2) {
            this.mActivity.showToast(this.mActivity.getPageContext().getString(n.i.cash_del_suc));
        } else if (str != null && z2) {
            this.mActivity.showToast(str);
        }
    }

    public PersonPostModel aoy() {
        return this.cQH;
    }
}
