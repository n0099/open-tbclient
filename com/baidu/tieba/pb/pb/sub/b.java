package com.baidu.tieba.pb.pb.sub;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.editortools.pb.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.am;
import com.baidu.tieba.pb.pb.main.aq;
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.c;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.h;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class b implements KeyboardEventLayout.a {
    private static final int ghZ = TbadkCoreApplication.getInst().getListItemRule().GO();
    private RelativeLayout chY;
    private NoNetworkView dEf;
    private TextView dWY;
    private com.baidu.tbadk.core.view.d deE;
    private View duq;
    private com.baidu.tieba.NEGFeedBack.e ehm;
    private y fTd;
    private View gcV;
    private com.baidu.tbadk.core.dialog.b gcY;
    private j ggF;
    private SubPbModel ghF;
    private a ghT;
    private ImageView giA;
    private d giE;
    private View gia;
    private NewSubPbActivity gib;
    private RelativeLayout gic;
    private View gih;
    private ThreadSkinView gio;
    private e gip;
    private View gis;
    private ArrayList<PostData> giw;
    private String gix;
    private RelativeLayout giy;
    private ImageView giz;
    private View.OnClickListener mCommonClickListener;
    private BdTypeListView mListView;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener amU = null;
    private TbRichTextView.i ghJ = null;
    private NavigationBar mNavigationBar = null;
    private View aMU = null;
    private TextView gie = null;
    private LinearLayout gif = null;
    private HeadImageView gig = null;
    private ClickableHeaderImageView gco = null;
    private TextView aKT = null;
    private ImageView gii = null;
    private TextView gcg = null;
    private TextView gij = null;
    private TextView gik = null;
    private EllipsizeRichTextView gil = null;
    private TbImageView gim = null;
    private PlayVoiceBntNew cUX = null;
    private TextView gin = null;
    private MorePopupWindow giq = null;
    private am gir = null;
    private com.baidu.tbadk.core.dialog.b gcX = null;
    private Dialog gcM = null;
    private com.baidu.tbadk.core.dialog.a gcO = null;
    private boolean fVk = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener aVr = null;
    private NewSubPbActivity.a git = null;
    private NewSubPbActivity.a giu = null;
    private g ffl = null;
    private String giv = null;
    private int bqQ = 0;
    private PostData fQO = null;
    private int giB = 0;
    private int giC = 2;
    private int giD = 0;
    private boolean aYF = true;
    private View.OnClickListener fVs = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(e.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(e.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(e.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (booleanValue2) {
                        sparseArray.put(e.g.tag_from, 1);
                        b.this.gib.b(sparseArray);
                        return;
                    }
                    b.this.bC(view);
                } else if (booleanValue2) {
                    sparseArray.put(e.g.tag_from, 0);
                    b.this.gib.b(sparseArray);
                } else if (booleanValue3) {
                    b.this.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c brN = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.b.4
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            b.this.he(false);
            b.this.aQ(view);
            b.this.he(true);
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            return true;
        }
    });
    protected AdapterView.OnItemLongClickListener giF = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.d(b.this.giw, i);
            if (view == null || view.getTag() == null) {
                return false;
            }
            if (b.this.fTd == null) {
                b.this.fTd = new y(b.this.gib.getPageContext(), b.this.mCommonClickListener);
            }
            b.this.fTd.showDialog();
            SparseArray<Object> sparseArray = null;
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray == null) {
                return true;
            }
            boolean kG = b.this.kG(sparseArray.get(e.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue() : false) & TbadkCoreApplication.isLogin();
            b.this.fTd.a(sparseArray, b.this.ghF.bgw(), kG);
            if (kG) {
                b.this.fTd.bjS().setVisibility(0);
                b.this.fTd.bjS().setTag(postData.getId());
            } else {
                b.this.fTd.bjS().setVisibility(8);
            }
            b.this.fTd.bjQ().setVisibility(8);
            b.this.fTd.refreshUI();
            return false;
        }
    };
    protected AdapterView.OnItemClickListener giG = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ba.bJ(b.this.gib.getPageContext().getPageActivity())) {
                if (b.this.gib.ffd == null || b.this.ghF == null || b.this.ghF.azX() == null || b.this.gib.ffd.dK(b.this.ghF.azX().replyPrivateFlag)) {
                    if (b.this.ghT != null) {
                        b.this.ghT.aFa();
                    }
                    b.this.bmu();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) v.d(b.this.giw, i);
                        if (postData == null) {
                            b.this.gix = null;
                        } else {
                            b.this.gix = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(e.g.tag_photo_username);
                            String str2 = (String) sparseArray.get(e.g.tag_photo_userid);
                            if (str != null) {
                                b.this.ffl.setReplyId(str2);
                                b.this.ffl.hX(str);
                            }
                        }
                        b.this.bmv();
                        return;
                    }
                    b.this.bmw();
                    b.this.ghF.bmR();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.chY = null;
        this.gia = null;
        this.mListView = null;
        this.gib = null;
        this.dEf = null;
        this.gic = null;
        this.gih = null;
        this.gip = null;
        this.gis = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.dWY = null;
        this.giy = null;
        this.giz = null;
        this.giA = null;
        this.gib = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.chY = (RelativeLayout) LayoutInflater.from(this.gib.getPageContext().getPageActivity()).inflate(e.h.new_sub_pb_layout, (ViewGroup) null);
        this.gia = LayoutInflater.from(this.gib.getPageContext().getPageActivity()).inflate(e.h.new_sub_pb_head, (ViewGroup) null);
        this.giy = (RelativeLayout) this.chY.findViewById(e.g.subpb_editor_tool_comment);
        this.dWY = (TextView) this.chY.findViewById(e.g.subpb_editor_tool_comment_reply_text);
        this.dWY.setOnClickListener(this.mCommonClickListener);
        this.giz = (ImageView) this.chY.findViewById(e.g.subpb_editor_tool_more_img);
        this.giA = (ImageView) this.chY.findViewById(e.g.subpb_editor_tool_emotion_img);
        this.giA.setOnClickListener(this.mCommonClickListener);
        this.giz.setOnClickListener(this.mCommonClickListener);
        this.dEf = (NoNetworkView) this.chY.findViewById(e.g.view_no_network);
        aFi();
        ayI();
        this.gic = (RelativeLayout) this.chY.findViewById(e.g.sub_pb_body_layout);
        this.mListView = (BdTypeListView) this.chY.findViewById(e.g.new_sub_pb_list);
        this.gio = (ThreadSkinView) LayoutInflater.from(this.gib.getPageContext().getPageActivity()).inflate(e.h.thread_skin_layout, (ViewGroup) null);
        this.mListView.addHeaderView(this.gio);
        this.mListView.addHeaderView(this.gia);
        this.duq = BdListViewHelper.a(this.gib.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.gip = new e(this.gib.getPageContext());
        this.gip.EZ();
        this.gis = this.gip.getView();
        this.mListView.setNextPage(this.gip);
        this.gip.setOnClickListener(this.mCommonClickListener);
        this.mListView.setOnItemClickListener(this.giG);
        this.mListView.setOnItemLongClickListener(this.giF);
        this.mListView.setOnTouchListener(this.brN);
        this.mProgress = (ProgressBar) this.chY.findViewById(e.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.gia != null) {
            this.gia.setVisibility(4);
        }
        if (this.gic != null) {
            this.gic.setVisibility(4);
        }
        this.gih = com.baidu.tbadk.ala.b.vZ().j(this.gib.getActivity(), 4);
        if (this.gih != null) {
            this.gih.setVisibility(8);
            this.gif.addView(this.gih, 3);
        }
        this.giE = new d(this.gib, this.mListView);
        this.giE.setFromCDN(this.mIsFromCDN);
        this.giE.s(this.mCommonClickListener);
        this.giE.initAdapters();
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void ayI() {
        this.gif = (LinearLayout) this.gia.findViewById(e.g.subpb_head_user_info_root);
        this.gif.setOnClickListener(this.mCommonClickListener);
        this.gig = (HeadImageView) this.gia.findViewById(e.g.photo);
        this.gig.setRadius(l.h(this.gib.getActivity(), e.C0210e.ds30));
        this.gig.setClickable(false);
        this.gco = (ClickableHeaderImageView) this.gia.findViewById(e.g.god_user_photo);
        this.gco.setGodIconMargin(0);
        this.gco.setGodIconWidth(e.C0210e.ds24);
        this.gco.setRadius(l.h(this.gib.getActivity(), e.C0210e.ds30));
        this.gco.setClickable(false);
        this.aKT = (TextView) this.gia.findViewById(e.g.user_name);
        this.gii = (ImageView) this.gia.findViewById(e.g.user_rank);
        this.gii.setVisibility(8);
        this.gcg = (TextView) this.gia.findViewById(e.g.floor_owner);
        this.gie = (TextView) this.gia.findViewById(e.g.see_subject);
        this.gie.setOnClickListener(this.mCommonClickListener);
        this.gij = (TextView) this.gia.findViewById(e.g.floor);
        this.gik = (TextView) this.gia.findViewById(e.g.time);
        this.gil = (EllipsizeRichTextView) this.gia.findViewById(e.g.content_text);
        this.gil.setOnClickListener(this.mCommonClickListener);
        al.h(this.gil, e.d.cp_cont_b);
        this.gil.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
        this.gil.setLineSpacing(0.0f, 1.25f);
        this.gim = (TbImageView) this.gia.findViewById(e.g.sub_pb_image);
        this.gim.setOnClickListener(this.mCommonClickListener);
        this.gin = (TextView) this.gia.findViewById(e.g.advert);
        this.cUX = (PlayVoiceBntNew) this.gia.findViewById(e.g.voice_btn);
        this.gia.setOnTouchListener(this.brN);
        this.gia.setOnClickListener(this.mCommonClickListener);
    }

    public void hg(boolean z) {
        if (this.duq != null && this.duq.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.duq.getLayoutParams();
            if (z) {
                aFm();
                layoutParams.height = l.h(this.gib.getPageContext().getPageActivity(), e.C0210e.ds88);
            } else {
                layoutParams.height = l.h(this.gib.getPageContext().getPageActivity(), e.C0210e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.duq.setLayoutParams(layoutParams);
        }
    }

    private void aFm() {
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_close, e.f.subpb_navigationbar_close);
    }

    public void a(b.InterfaceC0158b interfaceC0158b, boolean z) {
        if (this.gcY != null) {
            this.gcY.dismiss();
            this.gcY = null;
        }
        this.gcY = new com.baidu.tbadk.core.dialog.b(this.gib.getPageContext().getPageActivity());
        if (z) {
            this.gcY.a(new String[]{this.gib.getPageContext().getString(e.j.save_to_emotion)}, interfaceC0158b);
        } else {
            this.gcY.a(new String[]{this.gib.getPageContext().getString(e.j.save_to_emotion), this.gib.getPageContext().getString(e.j.save_to_local)}, interfaceC0158b);
        }
        this.gcY.d(this.gib.getPageContext());
        this.gcY.BI();
    }

    public void bE(View view) {
        this.gcV = view;
    }

    public View aFn() {
        return this.duq;
    }

    public void aFi() {
        int h = l.h(this.gib.getPageContext().getPageActivity(), e.C0210e.ds88);
        int h2 = l.h(this.gib.getPageContext().getPageActivity(), e.C0210e.ds2);
        this.mNavigationBar = (NavigationBar) this.chY.findViewById(e.g.view_navigation_bar);
        this.aMU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aMU.getLayoutParams();
            layoutParams.height = h;
            layoutParams.width = h;
            layoutParams.leftMargin = h2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aMU != null && (this.aMU.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aMU.getLayoutParams();
            layoutParams2.width = h;
            layoutParams2.height = h;
            this.aMU.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_back, e.f.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar abU() {
        return this.mNavigationBar;
    }

    public void bC(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.gcM == null) {
            this.gcM = new Dialog(this.gib.getPageContext().getPageActivity(), e.k.common_alert_dialog);
            this.gcM.setCanceledOnTouchOutside(true);
            this.gcM.setCancelable(true);
            View inflate = LayoutInflater.from(this.gib.getPageContext().getPageActivity()).inflate(e.h.forum_manage_dialog, (ViewGroup) null);
            this.gib.getLayoutMode().onModeChanged(inflate);
            this.gcM.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.gcM.getWindow().getAttributes();
            attributes.width = (int) (l.aO(this.gib.getPageContext().getPageActivity()) * 0.9d);
            this.gcM.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.gcM.findViewById(e.g.del_post_btn);
        TextView textView2 = (TextView) this.gcM.findViewById(e.g.forbid_user_btn);
        TextView textView3 = (TextView) this.gcM.findViewById(e.g.disable_reply_btn);
        int i = -1;
        if (sparseArray.get(e.g.tag_check_mute_from) instanceof Integer) {
            i = ((Integer) sparseArray.get(e.g.tag_check_mute_from)).intValue();
        }
        if ("".equals(sparseArray.get(e.g.tag_del_post_id)) || i == 2) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            sparseArray2.put(e.g.tag_del_post_id, sparseArray.get(e.g.tag_del_post_id));
            sparseArray2.put(e.g.tag_del_post_type, sparseArray.get(e.g.tag_del_post_type));
            sparseArray2.put(e.g.tag_del_post_is_self, sparseArray.get(e.g.tag_del_post_is_self));
            sparseArray2.put(e.g.tag_manage_user_identity, sparseArray.get(e.g.tag_manage_user_identity));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.gcM != null && (b.this.gcM instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.gcM, b.this.gib.getPageContext());
                    }
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null) {
                        b.this.a(((Integer) sparseArray3.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray3.get(e.g.tag_del_post_id), ((Integer) sparseArray3.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(e.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(e.g.tag_forbid_user_name)) && "".equals(sparseArray.get(e.g.tag_forbid_user_name_show))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(e.g.tag_forbid_user_name, sparseArray.get(e.g.tag_forbid_user_name));
            sparseArray3.put(e.g.tag_forbid_user_name_show, sparseArray.get(e.g.tag_forbid_user_name_show));
            sparseArray3.put(e.g.tag_forbid_user_portrait, sparseArray.get(e.g.tag_forbid_user_portrait));
            sparseArray3.put(e.g.tag_manage_user_identity, sparseArray.get(e.g.tag_manage_user_identity));
            sparseArray3.put(e.g.tag_forbid_user_post_id, sparseArray.get(e.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.gcM != null && (b.this.gcM instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.gcM, b.this.gib.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.git != null) {
                        b.this.git.m(new Object[]{sparseArray4.get(e.g.tag_manage_user_identity), sparseArray4.get(e.g.tag_forbid_user_name), sparseArray4.get(e.g.tag_forbid_user_post_id), sparseArray4.get(e.g.tag_forbid_user_name_show), sparseArray4.get(e.g.tag_forbid_user_portrait)});
                    }
                }
            });
        }
        if (!((sparseArray.get(e.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(e.g.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(e.j.un_mute);
            } else {
                textView3.setText(e.j.mute);
            }
            sparseArray4.put(e.g.tag_is_mem, sparseArray.get(e.g.tag_is_mem));
            sparseArray4.put(e.g.tag_user_mute_mute_userid, sparseArray.get(e.g.tag_user_mute_mute_userid));
            sparseArray4.put(e.g.tag_user_mute_mute_username, sparseArray.get(e.g.tag_user_mute_mute_username));
            sparseArray4.put(e.g.tag_user_mute_post_id, sparseArray.get(e.g.tag_user_mute_post_id));
            sparseArray4.put(e.g.tag_user_mute_thread_id, sparseArray.get(e.g.tag_user_mute_thread_id));
            sparseArray4.put(e.g.tag_user_mute_mute_nameshow, sparseArray.get(e.g.tag_user_mute_mute_nameshow));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.gcM != null && (b.this.gcM instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.gcM, b.this.gib.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.gib.a(z, (String) sparseArray5.get(e.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.gcM, this.gib.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        final SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(e.g.tag_del_post_id, str);
        sparseArray.put(e.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = e.j.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = e.j.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = e.j.report_thread_confirm;
            } else {
                i3 = e.j.del_thread_confirm;
            }
        }
        this.gcO = new com.baidu.tbadk.core.dialog.a(this.gib.getPageContext().getPageActivity());
        this.gcO.db(i3);
        this.gcO.H(sparseArray);
        this.gcO.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.giu != null) {
                    b.this.giu.m(new Object[]{sparseArray.get(e.g.tag_del_post_id), sparseArray.get(e.g.tag_manage_user_identity), sparseArray.get(e.g.tag_del_post_is_self), sparseArray.get(e.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.gcO.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.gcO.bf(true);
        this.gcO.b(this.gib.getPageContext());
        if (z) {
            this.gcO.BF();
        } else {
            d(sparseArray);
        }
    }

    private void d(final SparseArray<Object> sparseArray) {
        AntiData azX;
        if (this.gib != null && sparseArray != null && this.gia != null) {
            if (this.ehm == null) {
                this.ehm = new com.baidu.tieba.NEGFeedBack.e(this.gib.getPageContext(), this.gia);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.ghF != null && (azX = this.ghF.azX()) != null && azX.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = azX.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray2);
            this.ehm.setDefaultReasonArray(new String[]{this.gib.getString(e.j.delete_thread_reason_1), this.gib.getString(e.j.delete_thread_reason_2), this.gib.getString(e.j.delete_thread_reason_3), this.gib.getString(e.j.delete_thread_reason_4), this.gib.getString(e.j.delete_thread_reason_5)});
            this.ehm.setData(ahVar);
            this.ehm.jh("4");
            this.ehm.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.b.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void m(JSONArray jSONArray) {
                    String i2 = ao.i(jSONArray);
                    if (b.this.giu != null) {
                        b.this.giu.m(new Object[]{sparseArray.get(e.g.tag_del_post_id), sparseArray.get(e.g.tag_manage_user_identity), sparseArray.get(e.g.tag_del_post_is_self), sparseArray.get(e.g.tag_del_post_type), i2});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void he(final boolean z) {
        if (this.mListView != null) {
            if (!z) {
                this.mListView.setEnabled(z);
            } else {
                this.mListView.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.b.11
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mListView.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.git = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.giu = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.gib.showToast(this.gib.getResources().getString(e.j.delete_success));
        } else if (str != null && z2) {
            this.gib.showToast(str);
        }
    }

    public void aQ(View view) {
        if (this.duq != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.duq.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.duq);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.duq.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.gib.getActivity(), e.C0210e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.duq, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.LX() != null) {
            this.ffl = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.chY.addView(gVar.LX(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.ghT = aVar;
    }

    public void bmu() {
        if (this.mListView != null) {
            this.giD = this.mListView.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kG(boolean z) {
        if (this.ghF == null || this.ghF.bmO() == null) {
            return false;
        }
        if (this.ghF.bgw() != 0) {
            return false;
        }
        return (this.ggF == null || this.ggF.ZR() == null || this.ggF.ZR().zG() == null || !TextUtils.equals(this.ggF.ZR().zG().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void bmv() {
        if (this.ghF != null) {
            if ((!bmy() && this.gis != null && this.gis.isShown()) || v.I(this.giw)) {
                this.ghF.lO(false);
            } else {
                this.ghF.lO(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.ghF = subPbModel;
    }

    public void bmw() {
        a(this.gib);
        this.mListView.setNextPage(this.gip);
    }

    public void n(PostData postData) {
        int i;
        if (postData != null) {
            postData.nt(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bmy() && this.gis != null && this.gis.isShown()) {
                i = (this.giD - this.giC) - 1;
            } else {
                i = this.giD - this.giC;
            }
            int H = v.H(this.giw);
            if (i > H) {
                i = H;
            }
            ArrayList arrayList = new ArrayList(v.b(this.giw, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.mListView.smoothScrollToPosition(this.giD + 2);
            this.mListView.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.chY;
    }

    public void blm() {
        if (this.giq != null) {
            com.baidu.adp.lib.g.g.a(this.giq, this.gib.getPageContext().getPageActivity());
        }
        if (this.gcX != null) {
            this.gcX.dismiss();
        }
        if (this.gcO != null) {
            this.gcO.dismiss();
        }
        if (this.gcM != null) {
            com.baidu.adp.lib.g.g.b(this.gcM, this.gib.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.fTd != null) {
            this.fTd.dismiss();
        }
    }

    public void bmx() {
        this.mListView.setNextPage(this.gip);
        this.gip.Fc();
    }

    public void kz(boolean z) {
        this.fVk = z;
    }

    public void setIsFromPb(boolean z) {
        this.aYF = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v36, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(j jVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (jVar != null) {
            if (this.aYF && this.gia != null) {
                this.gia.setVisibility(8);
                this.mListView.removeHeaderView(this.gia);
                this.giC = 1;
            }
            this.ggF = jVar;
            if (this.gia != null) {
                this.gia.setVisibility(0);
            }
            if (this.gic != null) {
                this.gic.setVisibility(0);
            }
            if (jVar.bgR() != null) {
                this.giv = jVar.bgR().getId();
                this.bqQ = jVar.bgR().bDs();
                if (this.bqQ > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.gib.getResources().getString(e.j.subpb_floor_reply), Integer.valueOf(this.bqQ)));
                    this.dWY.setText(e.j.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = this.gib.bmt() ? "PB" : null;
                if (jVar.bgR().Ac() != null) {
                    this.gio.setData(this.gib.getPageContext(), jVar.bgR().Ac(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", jVar.bgX().getId(), jVar.bgX().getName(), jVar.ZR().getId(), str));
                } else {
                    this.gio.setData(null, null, null);
                }
            }
            if (jVar.hasMore()) {
                this.gip.Fc();
                this.giE.setHasMoreData(true);
            } else {
                this.gip.Fd();
                this.giE.setHasMoreData(false);
            }
            this.giw = jVar.bgV();
            if (this.giw == null || this.giw.size() <= ghZ) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.giw.size() - ghZ;
                sG(size);
                int firstVisiblePosition = this.mListView.getFirstVisiblePosition() - size;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.giw);
            if (v.I(this.giw)) {
                this.mListView.setNextPage(null);
                if (this.aYF) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.mListView.setNextPage(this.gip);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(jVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.aYF) {
                arrayList.add(0, jVar.bgR());
            }
            this.giE.a(this.ggF.ZR(), arrayList);
            a(jVar.bgR(), jVar.aTC(), jVar.wq(), i, z);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void sG(int i) {
        if (this.giw != null) {
            if (this.giw.size() <= i) {
                this.giw.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.giw.iterator();
            while (it.hasNext()) {
                it.next();
                i2++;
                it.remove();
                if (i2 >= i) {
                    return;
                }
            }
        }
    }

    public boolean bmy() {
        return this.giE.hasMoreData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.aYF) {
            this.fQO = postData;
            if (!StringUtils.isNull(postData.bDz())) {
                this.gim.setVisibility(0);
                this.gim.startLoad(postData.bDz(), 10, true);
            } else {
                this.gim.setVisibility(8);
            }
            h bDB = postData.bDB();
            if (bDB != null && bDB.hkU) {
                this.gin.setVisibility(0);
            } else {
                this.gin.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.gia.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.gia.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.gij.setText((CharSequence) null);
            this.aKT.setText((CharSequence) null);
            this.gcg.setVisibility(8);
            if (!this.aYF) {
                c(postData.zG());
                if (z) {
                    this.gcg.setVisibility(0);
                    al.h(this.gcg, e.d.cp_link_tip_a);
                }
            }
            this.gik.setText(ao.L(postData.getTime()));
            this.gij.setText(String.format(this.gib.getPageContext().getString(e.j.is_floor), Integer.valueOf(postData.bDs())));
            postData.zG().getUserTbVipInfoData();
            boolean a = a(this.gil, postData.bDu());
            if (StringUtils.isNull(postData.bDz()) && !a && postData.Sh() != null) {
                this.cUX.setVisibility(0);
                this.cUX.setTag(postData.Sh());
                return;
            }
            this.cUX.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.bz(metaData.getSealPrefix()) + 2 : 0) + com.baidu.tbadk.util.y.iL(name_show) > 14) {
                name_show = com.baidu.tbadk.util.y.q(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.aKT.setText(aE(metaData.getSealPrefix(), name_show));
            } else {
                this.aKT.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.gih != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.gih.setVisibility(8);
                } else {
                    this.gih.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.alI = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.gih.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.gco.setVisibility(0);
                this.gig.setVisibility(8);
                this.gco.setUserId(metaData.getUserId());
                this.gco.setUserName(metaData.getUserName());
                this.gco.startLoad(metaData.getPortrait(), 28, false);
                al.h(this.aKT, e.d.cp_cont_r);
            } else {
                this.gco.setVisibility(8);
                this.gig.setVisibility(0);
                this.gig.setUserId(metaData.getUserId());
                this.gig.setUserName(metaData.getUserName());
                this.gig.setDefaultResource(e.f.transparent_bg);
                this.gig.setDefaultErrorResource(e.f.icon_default_avatar100);
                this.gig.startLoad(metaData.getPortrait(), 28, false);
                al.h(this.aKT, e.d.cp_cont_c);
            }
            this.gif.setTag(e.g.tag_user_id, metaData.getUserId());
            this.gif.setTag(e.g.tag_user_name, metaData.getUserName());
            this.gif.setTag(e.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.RZ() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.RZ().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.Sg());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.db(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.bMa());
                        continue;
                    case 17:
                        String str = next.Sk().mGifInfo.mSharpText;
                        if (str == null) {
                            continue;
                        } else if (str.startsWith("#(") && str.endsWith(")")) {
                            tbRichTextData.append("[" + str.substring(2, str.length() - 1) + "]");
                            break;
                        }
                        break;
                }
            }
        }
        if (!tbRichTextData.Sp()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.Sg() == null || tbRichTextData.Sg().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.Sg());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.gib.getPageContext().getString(e.j.refresh_view_title_text), this.amU));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.gib.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.gic, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, e.f.pic_emotion07, l.h(pageActivity, e.C0210e.ds250), l.h(pageActivity, e.C0210e.ds480), l.h(pageActivity, e.C0210e.ds360)), dVar, a);
        }
        this.gic.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.ffl.MT();
        al.j(this.mNoDataView, e.d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.gib.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void jX(int i) {
        b(NoDataViewFactory.d.H(i, e.j.refresh_view_title_text));
        if (this.ghT != null) {
            this.ghT.bF(this.chY);
        }
        this.giy.setVisibility(8);
    }

    public void oo(String str) {
        b(NoDataViewFactory.d.aD(str, this.gib.getPageContext().getString(e.j.refresh_view_title_text)));
        if (this.ghT != null) {
            this.ghT.bF(this.chY);
        }
        this.giy.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            this.giy.setVisibility(0);
            this.chY.setOnTouchListener(null);
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.amU = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0262  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PostData postData, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        boolean z6;
        boolean z7;
        if (postData != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            if (i != 0) {
                String userId2 = postData.zG().getUserId();
                boolean z8 = userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount());
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z = true;
                    z2 = false;
                } else {
                    z2 = z8;
                    z = true;
                }
            } else {
                z = false;
                z2 = false;
            }
            if (this.ggF != null && this.ggF.ZR() != null && this.ggF.ZR().zG() != null && postData.zG() != null) {
                String userId3 = this.ggF.ZR().zG().getUserId();
                String userId4 = postData.zG().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = false;
                        z3 = true;
                        z4 = true;
                    } else {
                        z5 = true;
                        z3 = false;
                        z4 = true;
                    }
                    userId = postData.zG().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.bDs() != 1 ? 0 : 1;
                    if (aq.k(postData)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
                        if (postData.zG() != null) {
                            sparseArray.put(e.g.tag_forbid_user_name, postData.zG().getUserName());
                            sparseArray.put(e.g.tag_forbid_user_name_show, postData.zG().getName_show());
                            sparseArray.put(e.g.tag_forbid_user_portrait, postData.zG().getPortrait());
                            z7 = true;
                        } else {
                            z7 = true;
                        }
                    } else {
                        sparseArray.put(e.g.tag_forbid_user_name, "");
                        sparseArray.put(e.g.tag_forbid_user_name_show, "");
                        sparseArray.put(e.g.tag_forbid_user_portrait, "");
                        z7 = false;
                    }
                    if (!z4) {
                        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(e.g.tag_del_post_is_self, true);
                        sparseArray.put(e.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(e.g.tag_del_post_id, postData.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(e.g.tag_del_post_is_self, false);
                        sparseArray.put(e.g.tag_del_post_type, 0);
                        sparseArray.put(e.g.tag_del_post_id, "");
                    }
                    sparseArray.put(e.g.tag_should_manage_visible, Boolean.valueOf(z7));
                    sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
                    if (!z6) {
                        sparseArray.put(e.g.tag_should_manage_visible, true);
                        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(i));
                        if (postData.zG() != null) {
                            sparseArray.put(e.g.tag_forbid_user_name, postData.zG().getUserName());
                            sparseArray.put(e.g.tag_forbid_user_name_show, postData.zG().getName_show());
                            sparseArray.put(e.g.tag_forbid_user_portrait, postData.zG().getPortrait());
                        }
                    } else {
                        sparseArray.put(e.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(e.g.tag_user_mute_visible, true);
                        sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.zG() != null) {
                            sparseArray.put(e.g.tag_user_mute_mute_userid, postData.zG().getUserId());
                            sparseArray.put(e.g.tag_user_mute_mute_username, postData.zG().getUserName());
                            sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.zG().getName_show());
                        }
                        if (this.ggF.ZR() != null) {
                            sparseArray.put(e.g.tag_user_mute_thread_id, this.ggF.ZR().getId());
                        }
                        sparseArray.put(e.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(e.g.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(e.g.tag_should_delete_visible, true);
                        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(e.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(e.g.tag_del_post_id, postData.getId());
                        return;
                    }
                    sparseArray.put(e.g.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = postData.zG().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.bDs() != 1) {
            }
            if (aq.k(postData)) {
            }
            if (!z6) {
            }
            if (!z4) {
            }
            sparseArray.put(e.g.tag_should_manage_visible, Boolean.valueOf(z7));
            sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
            if (!z6) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public void lM(boolean z) {
        if (this.fTd != null && this.fTd.bjQ() != null) {
            if (z) {
                this.fTd.bjQ().setText(e.j.remove_mark);
            } else {
                this.fTd.bjQ().setText(e.j.mark);
            }
            this.fTd.refreshUI();
        }
    }

    public View bmz() {
        return this.gis;
    }

    public void onChangeSkinType(int i) {
        this.gib.getLayoutMode().setNightMode(i == 1);
        this.gib.getLayoutMode().onModeChanged(this.chY);
        this.gib.getLayoutMode().onModeChanged(this.gia);
        this.mNavigationBar.onChangeSkinType(this.gib.getPageContext(), i);
        if (this.gie != null) {
            al.h(this.gie, e.d.goto_see_subject_color);
        }
        this.dEf.onChangeSkinType(this.gib.getPageContext(), i);
        this.gib.getLayoutMode().onModeChanged(this.gis);
        al.h(this.gil, e.d.cp_cont_b);
        this.gil.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
        if (this.ffl != null && this.ffl.LX() != null) {
            this.ffl.LX().onChangeSkinType(i);
        }
        this.gip.ey(i);
        this.cUX.aWg();
        al.h(this.dWY, e.d.cp_cont_e);
        al.h(this.gcg, e.d.cp_link_tip_a);
        al.h(this.aKT, e.d.cp_cont_c);
        this.dWY.setAlpha(0.95f);
        if (this.gcV != null) {
            com.baidu.tbadk.o.a.a(this.gib.getPageContext(), this.gcV);
        }
        if (this.giE != null) {
            this.giE.notifyDataSetChanged();
        }
    }

    public void bmA() {
        this.mProgress.setVisibility(0);
    }

    public void bmB() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.gip.Fd();
    }

    public void axf() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.gip.axf();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aVr = onLongClickListener;
        this.giE.c(onLongClickListener);
    }

    public View bmC() {
        return this.gia;
    }

    public TextView aFo() {
        return this.dWY;
    }

    public ImageView bmD() {
        return this.giz;
    }

    public ImageView bmE() {
        return this.giA;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void sH(int i) {
    }

    public View bmF() {
        return this.gie;
    }

    public View bmG() {
        return this.gim;
    }

    public MorePopupWindow bmH() {
        return this.giq;
    }

    public void showLoadingDialog() {
        if (this.deE == null) {
            this.deE = new com.baidu.tbadk.core.view.d(this.gib.getPageContext());
        }
        this.deE.bA(true);
    }

    public void akP() {
        if (this.deE != null) {
            this.deE.bA(false);
        }
    }

    public TextView bmI() {
        return this.gil;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.ghJ = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.giE.setOnImageClickListener(hVar);
    }

    public void notifyDataSetChanged() {
        if (this.giE != null) {
            this.giE.notifyDataSetChanged();
        }
    }

    public y bmJ() {
        return this.fTd;
    }

    public void aEa() {
    }

    public void aEb() {
    }

    public void onActivityDestroy() {
    }

    public void bmK() {
        if (this.gib.isPaused()) {
        }
    }

    public View bmL() {
        return this.gif;
    }

    private SpannableStringBuilder aE(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, e.f.pic_smalldot_title));
            return o.a((Context) this.gib.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
