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
import com.baidu.tbadk.util.z;
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
    private static final int glU = TbadkCoreApplication.getInst().getListItemRule().Hc();
    private RelativeLayout ciR;
    private NoNetworkView dHC;
    private com.baidu.tbadk.core.view.d dig;
    private View dxM;
    private TextView eav;
    private com.baidu.tieba.NEGFeedBack.e ekJ;
    private y fWS;
    private View ggR;
    private com.baidu.tbadk.core.dialog.b ggU;
    private j gkB;
    private SubPbModel glA;
    private a glO;
    private View glV;
    private NewSubPbActivity glW;
    private RelativeLayout glX;
    private View gmb;
    private ThreadSkinView gmi;
    private e gmj;
    private View gmm;
    private ArrayList<PostData> gmq;
    private String gmr;
    private RelativeLayout gms;
    private ImageView gmt;
    private ImageView gmu;
    private d gmy;
    private View.OnClickListener mCommonClickListener;
    private BdTypeListView mListView;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener anw = null;
    private TbRichTextView.i glE = null;
    private NavigationBar mNavigationBar = null;
    private View aNy = null;
    private TextView glY = null;
    private LinearLayout glZ = null;
    private HeadImageView gma = null;
    private ClickableHeaderImageView ggk = null;
    private TextView aLx = null;
    private ImageView gmc = null;
    private TextView ggc = null;
    private TextView gmd = null;
    private TextView gme = null;
    private EllipsizeRichTextView gmf = null;
    private TbImageView gmg = null;
    private PlayVoiceBntNew cYy = null;
    private TextView gmh = null;
    private MorePopupWindow gmk = null;
    private am gml = null;
    private com.baidu.tbadk.core.dialog.b ggT = null;
    private Dialog ggI = null;
    private com.baidu.tbadk.core.dialog.a ggK = null;
    private boolean fYZ = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener aWc = null;
    private NewSubPbActivity.a gmn = null;
    private NewSubPbActivity.a gmo = null;
    private g fiS = null;
    private String gmp = null;
    private int brH = 0;
    private PostData fUD = null;
    private int gmv = 0;
    private int gmw = 2;
    private int gmx = 0;
    private boolean aZs = true;
    private View.OnClickListener fZh = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
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
                        b.this.glW.b(sparseArray);
                        return;
                    }
                    b.this.bF(view);
                } else if (booleanValue2) {
                    sparseArray.put(e.g.tag_from, 0);
                    b.this.glW.b(sparseArray);
                } else if (booleanValue3) {
                    b.this.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c bsE = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.b.4
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            b.this.hk(false);
            b.this.aT(view);
            b.this.hk(true);
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
    protected AdapterView.OnItemLongClickListener gmz = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.d(b.this.gmq, i);
            if (view == null || view.getTag() == null) {
                return false;
            }
            if (b.this.fWS == null) {
                b.this.fWS = new y(b.this.glW.getPageContext(), b.this.mCommonClickListener);
            }
            b.this.fWS.showDialog();
            SparseArray<Object> sparseArray = null;
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray == null) {
                return true;
            }
            boolean kJ = b.this.kJ(sparseArray.get(e.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue() : false) & TbadkCoreApplication.isLogin();
            b.this.fWS.a(sparseArray, b.this.glA.bhL(), kJ);
            if (kJ) {
                b.this.fWS.bll().setVisibility(0);
                b.this.fWS.bll().setTag(postData.getId());
            } else {
                b.this.fWS.bll().setVisibility(8);
            }
            b.this.fWS.blj().setVisibility(8);
            b.this.fWS.refreshUI();
            return false;
        }
    };
    protected AdapterView.OnItemClickListener gmA = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ba.bJ(b.this.glW.getPageContext().getPageActivity())) {
                if (b.this.glW.fiK == null || b.this.glA == null || b.this.glA.aBj() == null || b.this.glW.fiK.dK(b.this.glA.aBj().replyPrivateFlag)) {
                    if (b.this.glO != null) {
                        b.this.glO.aGm();
                    }
                    b.this.bnN();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) v.d(b.this.gmq, i);
                        if (postData == null) {
                            b.this.gmr = null;
                        } else {
                            b.this.gmr = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(e.g.tag_photo_username);
                            String str2 = (String) sparseArray.get(e.g.tag_photo_userid);
                            if (str != null) {
                                b.this.fiS.setReplyId(str2);
                                b.this.fiS.in(str);
                            }
                        }
                        b.this.bnO();
                        return;
                    }
                    b.this.bnP();
                    b.this.glA.bok();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.ciR = null;
        this.glV = null;
        this.mListView = null;
        this.glW = null;
        this.dHC = null;
        this.glX = null;
        this.gmb = null;
        this.gmj = null;
        this.gmm = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.eav = null;
        this.gms = null;
        this.gmt = null;
        this.gmu = null;
        this.glW = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.ciR = (RelativeLayout) LayoutInflater.from(this.glW.getPageContext().getPageActivity()).inflate(e.h.new_sub_pb_layout, (ViewGroup) null);
        this.glV = LayoutInflater.from(this.glW.getPageContext().getPageActivity()).inflate(e.h.new_sub_pb_head, (ViewGroup) null);
        this.gms = (RelativeLayout) this.ciR.findViewById(e.g.subpb_editor_tool_comment);
        this.eav = (TextView) this.ciR.findViewById(e.g.subpb_editor_tool_comment_reply_text);
        this.eav.setOnClickListener(this.mCommonClickListener);
        this.gmt = (ImageView) this.ciR.findViewById(e.g.subpb_editor_tool_more_img);
        this.gmu = (ImageView) this.ciR.findViewById(e.g.subpb_editor_tool_emotion_img);
        this.gmu.setOnClickListener(this.mCommonClickListener);
        this.gmt.setOnClickListener(this.mCommonClickListener);
        this.dHC = (NoNetworkView) this.ciR.findViewById(e.g.view_no_network);
        aGu();
        azU();
        this.glX = (RelativeLayout) this.ciR.findViewById(e.g.sub_pb_body_layout);
        this.mListView = (BdTypeListView) this.ciR.findViewById(e.g.new_sub_pb_list);
        this.gmi = (ThreadSkinView) LayoutInflater.from(this.glW.getPageContext().getPageActivity()).inflate(e.h.thread_skin_layout, (ViewGroup) null);
        this.mListView.addHeaderView(this.gmi);
        this.mListView.addHeaderView(this.glV);
        this.dxM = BdListViewHelper.a(this.glW.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.gmj = new e(this.glW.getPageContext());
        this.gmj.Fm();
        this.gmm = this.gmj.getView();
        this.mListView.setNextPage(this.gmj);
        this.gmj.setOnClickListener(this.mCommonClickListener);
        this.mListView.setOnItemClickListener(this.gmA);
        this.mListView.setOnItemLongClickListener(this.gmz);
        this.mListView.setOnTouchListener(this.bsE);
        this.mProgress = (ProgressBar) this.ciR.findViewById(e.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.glV != null) {
            this.glV.setVisibility(4);
        }
        if (this.glX != null) {
            this.glX.setVisibility(4);
        }
        this.gmb = com.baidu.tbadk.ala.b.wg().j(this.glW.getActivity(), 4);
        if (this.gmb != null) {
            this.gmb.setVisibility(8);
            this.glZ.addView(this.gmb, 3);
        }
        this.gmy = new d(this.glW, this.mListView);
        this.gmy.setFromCDN(this.mIsFromCDN);
        this.gmy.s(this.mCommonClickListener);
        this.gmy.initAdapters();
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void azU() {
        this.glZ = (LinearLayout) this.glV.findViewById(e.g.subpb_head_user_info_root);
        this.glZ.setOnClickListener(this.mCommonClickListener);
        this.gma = (HeadImageView) this.glV.findViewById(e.g.photo);
        this.gma.setRadius(l.h(this.glW.getActivity(), e.C0210e.ds30));
        this.gma.setClickable(false);
        this.ggk = (ClickableHeaderImageView) this.glV.findViewById(e.g.god_user_photo);
        this.ggk.setGodIconMargin(0);
        this.ggk.setGodIconWidth(e.C0210e.ds24);
        this.ggk.setRadius(l.h(this.glW.getActivity(), e.C0210e.ds30));
        this.ggk.setClickable(false);
        this.aLx = (TextView) this.glV.findViewById(e.g.user_name);
        this.gmc = (ImageView) this.glV.findViewById(e.g.user_rank);
        this.gmc.setVisibility(8);
        this.ggc = (TextView) this.glV.findViewById(e.g.floor_owner);
        this.glY = (TextView) this.glV.findViewById(e.g.see_subject);
        this.glY.setOnClickListener(this.mCommonClickListener);
        this.gmd = (TextView) this.glV.findViewById(e.g.floor);
        this.gme = (TextView) this.glV.findViewById(e.g.time);
        this.gmf = (EllipsizeRichTextView) this.glV.findViewById(e.g.content_text);
        this.gmf.setOnClickListener(this.mCommonClickListener);
        al.h(this.gmf, e.d.cp_cont_b);
        this.gmf.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
        this.gmf.setLineSpacing(0.0f, 1.25f);
        this.gmg = (TbImageView) this.glV.findViewById(e.g.sub_pb_image);
        this.gmg.setOnClickListener(this.mCommonClickListener);
        this.gmh = (TextView) this.glV.findViewById(e.g.advert);
        this.cYy = (PlayVoiceBntNew) this.glV.findViewById(e.g.voice_btn);
        this.glV.setOnTouchListener(this.bsE);
        this.glV.setOnClickListener(this.mCommonClickListener);
    }

    public void hm(boolean z) {
        if (this.dxM != null && this.dxM.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.dxM.getLayoutParams();
            if (z) {
                aGy();
                layoutParams.height = l.h(this.glW.getPageContext().getPageActivity(), e.C0210e.ds88);
            } else {
                layoutParams.height = l.h(this.glW.getPageContext().getPageActivity(), e.C0210e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.dxM.setLayoutParams(layoutParams);
        }
    }

    private void aGy() {
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_close, e.f.subpb_navigationbar_close);
    }

    public void a(b.InterfaceC0158b interfaceC0158b, boolean z) {
        if (this.ggU != null) {
            this.ggU.dismiss();
            this.ggU = null;
        }
        this.ggU = new com.baidu.tbadk.core.dialog.b(this.glW.getPageContext().getPageActivity());
        if (z) {
            this.ggU.a(new String[]{this.glW.getPageContext().getString(e.j.save_to_emotion)}, interfaceC0158b);
        } else {
            this.ggU.a(new String[]{this.glW.getPageContext().getString(e.j.save_to_emotion), this.glW.getPageContext().getString(e.j.save_to_local)}, interfaceC0158b);
        }
        this.ggU.d(this.glW.getPageContext());
        this.ggU.BV();
    }

    public void bH(View view) {
        this.ggR = view;
    }

    public View aGz() {
        return this.dxM;
    }

    public void aGu() {
        int h = l.h(this.glW.getPageContext().getPageActivity(), e.C0210e.ds88);
        int h2 = l.h(this.glW.getPageContext().getPageActivity(), e.C0210e.ds2);
        this.mNavigationBar = (NavigationBar) this.ciR.findViewById(e.g.view_navigation_bar);
        this.aNy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aNy.getLayoutParams();
            layoutParams.height = h;
            layoutParams.width = h;
            layoutParams.leftMargin = h2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aNy != null && (this.aNy.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aNy.getLayoutParams();
            layoutParams2.width = h;
            layoutParams2.height = h;
            this.aNy.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_back, e.f.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar act() {
        return this.mNavigationBar;
    }

    public void bF(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.ggI == null) {
            this.ggI = new Dialog(this.glW.getPageContext().getPageActivity(), e.k.common_alert_dialog);
            this.ggI.setCanceledOnTouchOutside(true);
            this.ggI.setCancelable(true);
            View inflate = LayoutInflater.from(this.glW.getPageContext().getPageActivity()).inflate(e.h.forum_manage_dialog, (ViewGroup) null);
            this.glW.getLayoutMode().onModeChanged(inflate);
            this.ggI.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.ggI.getWindow().getAttributes();
            attributes.width = (int) (l.aO(this.glW.getPageContext().getPageActivity()) * 0.9d);
            this.ggI.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.ggI.findViewById(e.g.del_post_btn);
        TextView textView2 = (TextView) this.ggI.findViewById(e.g.forbid_user_btn);
        TextView textView3 = (TextView) this.ggI.findViewById(e.g.disable_reply_btn);
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
                    if (b.this.ggI != null && (b.this.ggI instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.ggI, b.this.glW.getPageContext());
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
                    if (b.this.ggI != null && (b.this.ggI instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.ggI, b.this.glW.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.gmn != null) {
                        b.this.gmn.m(new Object[]{sparseArray4.get(e.g.tag_manage_user_identity), sparseArray4.get(e.g.tag_forbid_user_name), sparseArray4.get(e.g.tag_forbid_user_post_id), sparseArray4.get(e.g.tag_forbid_user_name_show), sparseArray4.get(e.g.tag_forbid_user_portrait)});
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
                    if (b.this.ggI != null && (b.this.ggI instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.ggI, b.this.glW.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.glW.a(z, (String) sparseArray5.get(e.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.ggI, this.glW.getPageContext());
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
        this.ggK = new com.baidu.tbadk.core.dialog.a(this.glW.getPageContext().getPageActivity());
        this.ggK.db(i3);
        this.ggK.H(sparseArray);
        this.ggK.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.gmo != null) {
                    b.this.gmo.m(new Object[]{sparseArray.get(e.g.tag_del_post_id), sparseArray.get(e.g.tag_manage_user_identity), sparseArray.get(e.g.tag_del_post_is_self), sparseArray.get(e.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.ggK.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.ggK.bg(true);
        this.ggK.b(this.glW.getPageContext());
        if (z) {
            this.ggK.BS();
        } else {
            d(sparseArray);
        }
    }

    private void d(final SparseArray<Object> sparseArray) {
        AntiData aBj;
        if (this.glW != null && sparseArray != null && this.glV != null) {
            if (this.ekJ == null) {
                this.ekJ = new com.baidu.tieba.NEGFeedBack.e(this.glW.getPageContext(), this.glV);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.glA != null && (aBj = this.glA.aBj()) != null && aBj.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = aBj.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray2);
            this.ekJ.setDefaultReasonArray(new String[]{this.glW.getString(e.j.delete_thread_reason_1), this.glW.getString(e.j.delete_thread_reason_2), this.glW.getString(e.j.delete_thread_reason_3), this.glW.getString(e.j.delete_thread_reason_4), this.glW.getString(e.j.delete_thread_reason_5)});
            this.ekJ.setData(ahVar);
            this.ekJ.jy("4");
            this.ekJ.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.b.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void m(JSONArray jSONArray) {
                    String i2 = ao.i(jSONArray);
                    if (b.this.gmo != null) {
                        b.this.gmo.m(new Object[]{sparseArray.get(e.g.tag_del_post_id), sparseArray.get(e.g.tag_manage_user_identity), sparseArray.get(e.g.tag_del_post_is_self), sparseArray.get(e.g.tag_del_post_type), i2});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hk(final boolean z) {
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
        this.gmn = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.gmo = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.glW.showToast(this.glW.getResources().getString(e.j.delete_success));
        } else if (str != null && z2) {
            this.glW.showToast(str);
        }
    }

    public void aT(View view) {
        if (this.dxM != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dxM.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.dxM);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.dxM.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.glW.getActivity(), e.C0210e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.dxM, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.Mp() != null) {
            this.fiS = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.ciR.addView(gVar.Mp(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.glO = aVar;
    }

    public void bnN() {
        if (this.mListView != null) {
            this.gmx = this.mListView.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kJ(boolean z) {
        if (this.glA == null || this.glA.boh() == null) {
            return false;
        }
        if (this.glA.bhL() != 0) {
            return false;
        }
        return (this.gkB == null || this.gkB.aaq() == null || this.gkB.aaq().zT() == null || !TextUtils.equals(this.gkB.aaq().zT().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void bnO() {
        if (this.glA != null) {
            if ((!bnR() && this.gmm != null && this.gmm.isShown()) || v.I(this.gmq)) {
                this.glA.lR(false);
            } else {
                this.glA.lR(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.glA = subPbModel;
    }

    public void bnP() {
        a(this.glW);
        this.mListView.setNextPage(this.gmj);
    }

    public void p(PostData postData) {
        int i;
        if (postData != null) {
            postData.nx(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bnR() && this.gmm != null && this.gmm.isShown()) {
                i = (this.gmx - this.gmw) - 1;
            } else {
                i = this.gmx - this.gmw;
            }
            int H = v.H(this.gmq);
            if (i > H) {
                i = H;
            }
            ArrayList arrayList = new ArrayList(v.b(this.gmq, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.mListView.smoothScrollToPosition(this.gmx + 2);
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
        return this.ciR;
    }

    public void bmF() {
        if (this.gmk != null) {
            com.baidu.adp.lib.g.g.a(this.gmk, this.glW.getPageContext().getPageActivity());
        }
        if (this.ggT != null) {
            this.ggT.dismiss();
        }
        if (this.ggK != null) {
            this.ggK.dismiss();
        }
        if (this.ggI != null) {
            com.baidu.adp.lib.g.g.b(this.ggI, this.glW.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.fWS != null) {
            this.fWS.dismiss();
        }
    }

    public void bnQ() {
        this.mListView.setNextPage(this.gmj);
        this.gmj.Fp();
    }

    public void kC(boolean z) {
        this.fYZ = z;
    }

    public void setIsFromPb(boolean z) {
        this.aZs = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v36, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(j jVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (jVar != null) {
            if (this.aZs && this.glV != null) {
                this.glV.setVisibility(8);
                this.mListView.removeHeaderView(this.glV);
                this.gmw = 1;
            }
            this.gkB = jVar;
            if (this.glV != null) {
                this.glV.setVisibility(0);
            }
            if (this.glX != null) {
                this.glX.setVisibility(0);
            }
            if (jVar.big() != null) {
                this.gmp = jVar.big().getId();
                this.brH = jVar.big().bES();
                if (this.brH > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.glW.getResources().getString(e.j.subpb_floor_reply), Integer.valueOf(this.brH)));
                    this.eav.setText(e.j.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = this.glW.bnM() ? "PB" : null;
                if (jVar.big().Ap() != null) {
                    this.gmi.setData(this.glW.getPageContext(), jVar.big().Ap(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", jVar.bim().getId(), jVar.bim().getName(), jVar.aaq().getId(), str));
                } else {
                    this.gmi.setData(null, null, null);
                }
            }
            if (jVar.hasMore()) {
                this.gmj.Fp();
                this.gmy.setHasMoreData(true);
            } else {
                this.gmj.Fq();
                this.gmy.setHasMoreData(false);
            }
            this.gmq = jVar.bik();
            if (this.gmq == null || this.gmq.size() <= glU) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.gmq.size() - glU;
                sX(size);
                int firstVisiblePosition = this.mListView.getFirstVisiblePosition() - size;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.gmq);
            if (v.I(this.gmq)) {
                this.mListView.setNextPage(null);
                if (this.aZs) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.mListView.setNextPage(this.gmj);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(jVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.aZs) {
                arrayList.add(0, jVar.big());
            }
            this.gmy.a(this.gkB.aaq(), arrayList);
            a(jVar.big(), jVar.aUP(), jVar.wx(), i, z);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void sX(int i) {
        if (this.gmq != null) {
            if (this.gmq.size() <= i) {
                this.gmq.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.gmq.iterator();
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

    public boolean bnR() {
        return this.gmy.hasMoreData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.aZs) {
            this.fUD = postData;
            if (!StringUtils.isNull(postData.bEZ())) {
                this.gmg.setVisibility(0);
                this.gmg.startLoad(postData.bEZ(), 10, true);
            } else {
                this.gmg.setVisibility(8);
            }
            h bFb = postData.bFb();
            if (bFb != null && bFb.hpk) {
                this.gmh.setVisibility(0);
            } else {
                this.gmh.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.glV.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.glV.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.gmd.setText((CharSequence) null);
            this.aLx.setText((CharSequence) null);
            this.ggc.setVisibility(8);
            if (!this.aZs) {
                c(postData.zT());
                if (z) {
                    this.ggc.setVisibility(0);
                    al.h(this.ggc, e.d.cp_link_tip_a);
                }
            }
            this.gme.setText(ao.M(postData.getTime()));
            this.gmd.setText(String.format(this.glW.getPageContext().getString(e.j.is_floor), Integer.valueOf(postData.bES())));
            postData.zT().getUserTbVipInfoData();
            boolean a = a(this.gmf, postData.bEU());
            if (StringUtils.isNull(postData.bEZ()) && !a && postData.SF() != null) {
                this.cYy.setVisibility(0);
                this.cYy.setTag(postData.SF());
                return;
            }
            this.cYy.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.bz(metaData.getSealPrefix()) + 2 : 0) + z.jc(name_show) > 14) {
                name_show = z.q(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.aLx.setText(aF(metaData.getSealPrefix(), name_show));
            } else {
                this.aLx.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.gmb != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.gmb.setVisibility(8);
                } else {
                    this.gmb.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.amc = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.gmb.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.ggk.setVisibility(0);
                this.gma.setVisibility(8);
                this.ggk.setUserId(metaData.getUserId());
                this.ggk.setUserName(metaData.getUserName());
                this.ggk.startLoad(metaData.getPortrait(), 28, false);
                al.h(this.aLx, e.d.cp_cont_r);
            } else {
                this.ggk.setVisibility(8);
                this.gma.setVisibility(0);
                this.gma.setUserId(metaData.getUserId());
                this.gma.setUserName(metaData.getUserName());
                this.gma.setDefaultResource(e.f.transparent_bg);
                this.gma.setDefaultErrorResource(e.f.icon_default_avatar100);
                this.gma.startLoad(metaData.getPortrait(), 28, false);
                al.h(this.aLx, e.d.cp_cont_c);
            }
            this.glZ.setTag(e.g.tag_user_id, metaData.getUserId());
            this.glZ.setTag(e.g.tag_user_name, metaData.getUserName());
            this.glZ.setTag(e.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.Sx() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.Sx().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.SE());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.de(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.bNx());
                        continue;
                    case 17:
                        String str = next.SI().mGifInfo.mSharpText;
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
        if (!tbRichTextData.SN()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.SE() == null || tbRichTextData.SE().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.SE());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.glW.getPageContext().getString(e.j.refresh_view_title_text), this.anw));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.glW.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.glX, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, e.f.pic_emotion07, l.h(pageActivity, e.C0210e.ds250), l.h(pageActivity, e.C0210e.ds480), l.h(pageActivity, e.C0210e.ds360)), dVar, a);
        }
        this.glX.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.fiS.Nl();
        al.j(this.mNoDataView, e.d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.glW.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void kf(int i) {
        b(NoDataViewFactory.d.H(i, e.j.refresh_view_title_text));
        if (this.glO != null) {
            this.glO.bI(this.ciR);
        }
        this.gms.setVisibility(8);
    }

    public void oH(String str) {
        b(NoDataViewFactory.d.aE(str, this.glW.getPageContext().getString(e.j.refresh_view_title_text)));
        if (this.glO != null) {
            this.glO.bI(this.ciR);
        }
        this.gms.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            this.gms.setVisibility(0);
            this.ciR.setOnTouchListener(null);
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.anw = onClickListener;
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
                String userId2 = postData.zT().getUserId();
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
            if (this.gkB != null && this.gkB.aaq() != null && this.gkB.aaq().zT() != null && postData.zT() != null) {
                String userId3 = this.gkB.aaq().zT().getUserId();
                String userId4 = postData.zT().getUserId();
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
                    userId = postData.zT().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.bES() != 1 ? 0 : 1;
                    if (aq.m(postData)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
                        if (postData.zT() != null) {
                            sparseArray.put(e.g.tag_forbid_user_name, postData.zT().getUserName());
                            sparseArray.put(e.g.tag_forbid_user_name_show, postData.zT().getName_show());
                            sparseArray.put(e.g.tag_forbid_user_portrait, postData.zT().getPortrait());
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
                        if (postData.zT() != null) {
                            sparseArray.put(e.g.tag_forbid_user_name, postData.zT().getUserName());
                            sparseArray.put(e.g.tag_forbid_user_name_show, postData.zT().getName_show());
                            sparseArray.put(e.g.tag_forbid_user_portrait, postData.zT().getPortrait());
                        }
                    } else {
                        sparseArray.put(e.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(e.g.tag_user_mute_visible, true);
                        sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.zT() != null) {
                            sparseArray.put(e.g.tag_user_mute_mute_userid, postData.zT().getUserId());
                            sparseArray.put(e.g.tag_user_mute_mute_username, postData.zT().getUserName());
                            sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.zT().getName_show());
                        }
                        if (this.gkB.aaq() != null) {
                            sparseArray.put(e.g.tag_user_mute_thread_id, this.gkB.aaq().getId());
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
            userId = postData.zT().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.bES() != 1) {
            }
            if (aq.m(postData)) {
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

    public void lP(boolean z) {
        if (this.fWS != null && this.fWS.blj() != null) {
            if (z) {
                this.fWS.blj().setText(e.j.remove_mark);
            } else {
                this.fWS.blj().setText(e.j.mark);
            }
            this.fWS.refreshUI();
        }
    }

    public View bnS() {
        return this.gmm;
    }

    public void onChangeSkinType(int i) {
        this.glW.getLayoutMode().setNightMode(i == 1);
        this.glW.getLayoutMode().onModeChanged(this.ciR);
        this.glW.getLayoutMode().onModeChanged(this.glV);
        this.mNavigationBar.onChangeSkinType(this.glW.getPageContext(), i);
        if (this.glY != null) {
            al.h(this.glY, e.d.goto_see_subject_color);
        }
        this.dHC.onChangeSkinType(this.glW.getPageContext(), i);
        this.glW.getLayoutMode().onModeChanged(this.gmm);
        al.h(this.gmf, e.d.cp_cont_b);
        this.gmf.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
        if (this.fiS != null && this.fiS.Mp() != null) {
            this.fiS.Mp().onChangeSkinType(i);
        }
        this.gmj.ey(i);
        this.cYy.aXt();
        al.h(this.eav, e.d.cp_cont_e);
        al.h(this.ggc, e.d.cp_link_tip_a);
        al.h(this.aLx, e.d.cp_cont_c);
        this.eav.setAlpha(0.95f);
        if (this.ggR != null) {
            com.baidu.tbadk.o.a.a(this.glW.getPageContext(), this.ggR);
        }
        if (this.gmy != null) {
            this.gmy.notifyDataSetChanged();
        }
    }

    public void bnT() {
        this.mProgress.setVisibility(0);
    }

    public void bnU() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.gmj.Fq();
    }

    public void ayr() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.gmj.ayr();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aWc = onLongClickListener;
        this.gmy.c(onLongClickListener);
    }

    public View bnV() {
        return this.glV;
    }

    public TextView aGA() {
        return this.eav;
    }

    public ImageView bnW() {
        return this.gmt;
    }

    public ImageView bnX() {
        return this.gmu;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void sY(int i) {
    }

    public View bnY() {
        return this.glY;
    }

    public View bnZ() {
        return this.gmg;
    }

    public MorePopupWindow boa() {
        return this.gmk;
    }

    public void showLoadingDialog() {
        if (this.dig == null) {
            this.dig = new com.baidu.tbadk.core.view.d(this.glW.getPageContext());
        }
        this.dig.bB(true);
    }

    public void alK() {
        if (this.dig != null) {
            this.dig.bB(false);
        }
    }

    public TextView bob() {
        return this.gmf;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.glE = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.gmy.setOnImageClickListener(hVar);
    }

    public void notifyDataSetChanged() {
        if (this.gmy != null) {
            this.gmy.notifyDataSetChanged();
        }
    }

    public y boc() {
        return this.fWS;
    }

    public void aFm() {
    }

    public void aFn() {
    }

    public void onActivityDestroy() {
    }

    public void bod() {
        if (this.glW.isPaused()) {
        }
    }

    public View boe() {
        return this.glZ;
    }

    private SpannableStringBuilder aF(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, e.f.pic_smalldot_title));
            return o.a((Context) this.glW.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
