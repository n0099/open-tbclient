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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.i;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.post.a;
import com.baidu.tieba.tbadkCore.h.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends BaseAdapter implements PhotoLiveCardView.a, PhotoLiveCardView.b, PersonPostModel.a, a.InterfaceC0069a {
    private int cdc;
    private String clC;
    public PersonPostModel clJ;
    private a cmc;
    private BaseFragmentActivity mActivity;
    private final String wp;
    private com.baidu.tieba.tbadkCore.h.a cbI = null;
    private boolean cme = false;
    private List<PersonPostModel.PostInfoList> cmf = new ArrayList();
    private PhotoLiveCardData cmg = null;
    private com.baidu.tbadk.core.dialog.a cfo = null;
    private final com.baidu.adp.base.g ccb = new q(this);

    /* loaded from: classes.dex */
    public interface a {
        void b(PersonPostModel personPostModel, boolean z);
    }

    public p(BaseFragmentActivity baseFragmentActivity, String str, String str2) {
        this.mActivity = baseFragmentActivity;
        this.wp = str;
    }

    public void eR(boolean z) {
        if (this.clJ == null) {
            this.clJ = new PersonPostModel(this.mActivity.getPageContext());
        }
        this.clJ.fetchPost(this.mActivity.getPageContext(), this, z, this.wp, true, this.cdc);
    }

    public void agX() {
        if (this.clJ != null) {
            this.clJ.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.person.PersonPostModel.a
    public void a(PersonPostModel personPostModel, boolean z) {
        if (z) {
            this.clJ = personPostModel;
            if (this.clJ != null) {
                this.cmf.clear();
                this.cmf.addAll(this.clJ.post_list);
            }
        } else if (this.clJ != null) {
            this.clJ.post_list.addAll(personPostModel.post_list);
            this.cmf.addAll(personPostModel.post_list);
        }
        if (this.cmc != null) {
            this.cmc.b(personPostModel, z);
        }
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.cmc = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cmf != null) {
            return this.cmf.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ja */
    public PersonPostModel.PostInfoList getItem(int i) {
        if (this.cmf == null || this.cmf.size() - 1 < i) {
            return null;
        }
        return this.cmf.get(i);
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
            bVar.clr.setPadding(0, (int) this.mActivity.getResources().getDimension(i.d.ds18), 0, 0);
            bVar.cly.setVisibility(0);
            bVar.clu.setVisibility(0);
            bVar.clt.setVisibility(0);
            bVar.clz.setVisibility(0);
            bVar.clB.setVisibility(0);
            bVar.aQj.setVisibility(0);
            bVar.bWk.setVisibility(0);
            bVar.cmi.setVisibility(0);
            bVar.cmj.setVisibility(0);
            bVar.cmk.setVisibility(0);
            bVar.cml.setVisibility(0);
            bVar.Xr.setVisibility(0);
            bVar.cmn.setVisibility(8);
            if (i == 0) {
                bVar.cly.setVisibility(0);
            } else {
                bVar.cly.setVisibility(8);
            }
            if (this.clC == null) {
                this.clC = item.user_portrait;
            }
            bVar.a(item, true, this.clC);
            String str = item.title;
            if (str.trim().length() > 0) {
                bVar.aQj.setText(str);
                bVar.aQj.setVisibility(0);
            } else {
                bVar.aQj.setVisibility(8);
            }
            LiveCardData a2 = a(item.anchor_info);
            if (a2.getAuthorId() != 0) {
                bVar.cmi.setVisibility(8);
                bVar.cmk.setVisibility(0);
                bVar.cmm.setData(a2);
            } else {
                bVar.cmk.setVisibility(8);
                if (com.baidu.tbadk.core.m.rb().rf() && item.media != null && item.media.length > 0) {
                    int min = Math.min(item.media.length, 3);
                    PersonPostModel.Media[] mediaArr = new PersonPostModel.Media[min];
                    for (int i2 = 0; i2 < min; i2++) {
                        mediaArr[i2] = item.media[i2];
                    }
                    bVar.cmi.setVisibility(0);
                    bVar.cmi.setTags(mediaArr);
                } else {
                    bVar.cmi.setVisibility(8);
                    bVar.cmi.setTags(null);
                }
            }
            if (item.abs_thread != null && item.abs_thread.length > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < item.abs_thread.length; i3++) {
                    sb.append(item.abs_thread[i3].text);
                }
                String sb2 = sb.toString();
                if (sb2.trim().length() > 0) {
                    bVar.bWk.setText(sb2);
                    bVar.bWk.setVisibility(0);
                } else {
                    bVar.bWk.setVisibility(8);
                }
            } else {
                bVar.bWk.setVisibility(8);
            }
            if (!bVar.bWk.isShown() && a2.getAuthorId() != 0) {
                bVar.cmj.setVisibility(8);
            } else {
                bVar.cmj.setVisibility(0);
            }
            bVar.a(this);
        } else if (item != null) {
            bVar.clr.setPadding(0, 0, 0, 0);
            bVar.cly.setVisibility(8);
            bVar.clu.setVisibility(8);
            bVar.clt.setVisibility(8);
            bVar.clz.setVisibility(8);
            bVar.clB.setVisibility(8);
            bVar.aQj.setVisibility(8);
            bVar.bWk.setVisibility(8);
            bVar.cmi.setVisibility(8);
            bVar.cmj.setVisibility(8);
            bVar.cmk.setVisibility(8);
            bVar.cml.setVisibility(8);
            bVar.Xr.setVisibility(8);
            bVar.cmn.setVisibility(0);
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
            bVar.aXZ.setOnClickListener(new r(this));
            bVar.aXZ.setTag(item);
            bVar.aXZ.setPortraitClicklistener(this);
            bVar.aXZ.setDeleteButtonClickListener(this);
            bVar.aXZ.setShowBottom(true);
            bVar.aXZ.setShowReplyNumInButtom(true);
            bVar.aXZ.setShowHead(false);
            bVar.aXZ.setShowTitle(true);
            bVar.aXZ.setShowRefreshTimeInTitle(true);
            bVar.aXZ.setHeadPaddingTop(i.d.ds24);
            if (2 == i4) {
                bVar.aXZ.setShowContent(true);
                bVar.aXZ.setShowCover(false);
                bVar.aXZ.setShowExpression(false);
                bVar.aXZ.setShowRefreshTimeInTitle(false);
            } else {
                bVar.aXZ.setShowContent(false);
                bVar.aXZ.setShowCover(true);
                bVar.aXZ.setShowExpression(true);
                bVar.aXZ.setShowRefreshTimeInTitle(true);
            }
            bVar.aXZ.setShowLiveIcon(true);
            bVar.aXZ.setChooseStyle(photoLiveCardData.getShowStyle());
            bVar.aXZ.setShowDeleteButtonInTitle(this.cme);
            if (this.cme) {
                bVar.aXZ.setTitlePaddingRight(i.d.ds84);
            } else {
                bVar.aXZ.setTitlePaddingRight(0);
            }
            bVar.aXZ.setData(photoLiveCardData);
        }
        bVar.cM(TbadkCoreApplication.m411getInst().getSkinType());
        al.h(bVar.Xr, i.c.cp_bg_line_b);
        bVar.cmm.onChangeSkinType(this.mActivity.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mActivity.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.mActivity.getLayoutMode().k(bVar.mContentView);
        return view;
    }

    private int a(PersonPostModel.ZhiBoInfoTW zhiBoInfoTW) {
        return !StringUtils.isNull(zhiBoInfoTW.livecover_src) ? 1 : 2;
    }

    private ArrayList<com.baidu.tbadk.coreExtra.view.p> a(PersonPostModel.LabelInfo[] labelInfoArr) {
        ArrayList<com.baidu.tbadk.coreExtra.view.p> arrayList = new ArrayList<>();
        if (labelInfoArr == null || labelInfoArr.length <= 0) {
            return arrayList;
        }
        for (int i = 0; i < labelInfoArr.length; i++) {
            com.baidu.tbadk.coreExtra.view.p pVar = new com.baidu.tbadk.coreExtra.view.p();
            if (labelInfoArr[i] != null) {
                pVar.dC(labelInfoArr[i].labelHot);
                pVar.setLabelName(labelInfoArr[i].labelName);
                pVar.setLabelId(labelInfoArr[i].LabelId);
                arrayList.add(pVar);
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

    @Override // com.baidu.tieba.person.post.a.InterfaceC0069a
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
        View Xr;
        TextView aQj;
        PhotoLiveCardView aXZ;
        TextView bWk;
        TripleTbImageView cmi;
        View cmj;
        LinearLayout cmk;
        LinearLayout cml;
        LiveBroadcastCard cmm;
        LinearLayout cmn;
        View mContentView;

        @Override // com.baidu.tieba.person.post.a
        public /* bridge */ /* synthetic */ void a(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
            super.a(postInfoList, z, str);
        }

        @Override // com.baidu.tieba.person.post.a
        public /* bridge */ /* synthetic */ void a(a.InterfaceC0069a interfaceC0069a) {
            super.a(interfaceC0069a);
        }

        @Override // com.baidu.tieba.person.post.a, android.view.View.OnClickListener
        public /* bridge */ /* synthetic */ void onClick(View view) {
            super.onClick(view);
        }

        b(View view, TbPageContext<?> tbPageContext) {
            super(view, tbPageContext);
            this.mContentView = view.findViewById(i.f.item_content);
            this.aQj = (TextView) view.findViewById(i.f.title);
            this.bWk = (TextView) view.findViewById(i.f.content);
            this.cmi = (TripleTbImageView) view.findViewById(i.f.images);
            this.cmj = view.findViewById(i.f.post_line);
            this.cmk = (LinearLayout) view.findViewById(i.f.person_post_item_live_card);
            this.cmm = (LiveBroadcastCard) view.findViewById(i.f.person_post_item_feed_item_card);
            this.Xr = view.findViewById(i.f.person_post_thread_item_divider_1);
            this.cmn = (LinearLayout) view.findViewById(i.f.person_post_item_photo_live_card);
            this.aXZ = (PhotoLiveCardView) view.findViewById(i.f.photo_live_card);
            this.cml = (LinearLayout) view.findViewById(i.f.person_post_item_live_card);
        }

        @Override // com.baidu.tieba.person.post.a
        public void cM(int i) {
            super.cM(i);
            al.b(this.aQj, i.c.cp_cont_b, 1);
            al.b(this.bWk, i.c.cp_cont_f, 1);
            al.h(this.cmj, i.c.cp_bg_line_b);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        this.mActivity.finish();
    }

    public void bC(int i) {
        this.cdc = i;
    }

    public void eS(boolean z) {
        this.cme = z;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.a
    public void onDeleteClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            this.cmg = (PhotoLiveCardData) tag;
            agY();
        }
    }

    public void agY() {
        if (this.cfo == null) {
            String string = this.mActivity.getPageContext().getResources().getString(i.h.del_thread_confirm);
            this.cfo = new com.baidu.tbadk.core.dialog.a(this.mActivity.getActivity());
            this.cfo.ct(string);
            this.cfo.a(i.h.dialog_ok, new s(this));
            this.cfo.b(i.h.dialog_cancel, new t(this));
            this.cfo.aj(true);
            this.cfo.b(this.mActivity.getPageContext());
        }
        this.cfo.sU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agZ() {
        if (this.cmg != null) {
            if (this.cbI == null) {
                this.cbI = new com.baidu.tieba.tbadkCore.h.a(this.mActivity);
                this.cbI.setLoadDataCallBack(this.ccb);
            }
            if (!this.cbI.avb()) {
                this.mActivity.showProgressBar();
                String valueOf = String.valueOf(this.cmg.getForumId());
                String forumName = this.cmg.getForumName();
                String valueOf2 = String.valueOf(this.cmg.getThreadId());
                this.cbI.a(valueOf, forumName, valueOf2, valueOf2, 0, 0, true);
                this.cmg = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.b bVar) {
        if (bVar != null) {
            a(0, bVar.Am, bVar.cSW, true);
            if (bVar.Am && bVar.cSU == 0) {
                List<PersonPostModel.PostInfoList> list = this.cmf;
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
}
