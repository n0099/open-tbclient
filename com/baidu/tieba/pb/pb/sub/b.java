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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.editortools.pb.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.main.am;
import com.baidu.tieba.pb.pb.main.as;
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
/* loaded from: classes2.dex */
public class b implements KeyboardEventLayout.a {
    private static final int fKz = TbadkCoreApplication.getInst().getListItemRule().Cv();
    private BdListView LS;
    private RelativeLayout bOJ;
    private com.baidu.tbadk.core.view.a cGa;
    private View cVX;
    private e dHz;
    private NoNetworkView dfF;
    private TextView dyb;
    private TextView dyc;
    private k fJa;
    private View fKA;
    private c fKB;
    private NewSubPbActivity fKC;
    private RelativeLayout fKD;
    private View fKH;
    private ThreadSkinView fKO;
    private d fKP;
    private View fKS;
    private ArrayList<PostData> fKW;
    private String fKX;
    private RelativeLayout fKY;
    private ImageView fKZ;
    private SubPbModel fKf;
    private a fKt;
    private ImageView fLa;
    private y fvp;
    private View.OnClickListener mCommonClickListener;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private TbRichTextView.h fKk = null;
    private View.OnClickListener abB = null;
    private TbRichTextView.i fKj = null;
    private NavigationBar mNavigationBar = null;
    private View aBf = null;
    private TextView fKE = null;
    private LinearLayout fKF = null;
    private HeadImageView fKG = null;
    private ClickableHeaderImageView fES = null;
    private TextView azm = null;
    private ImageView fKI = null;
    private TextView fEK = null;
    private TextView fKJ = null;
    private TextView fKK = null;
    private EllipsizeRichTextView fKL = null;
    private TbImageView fKM = null;
    private PlayVoiceBntNew cwy = null;
    private TextView fKN = null;
    private MorePopupWindow fKQ = null;
    private am fKR = null;
    private com.baidu.tbadk.core.dialog.b fFB = null;
    private Dialog fFq = null;
    private com.baidu.tbadk.core.dialog.a fFs = null;
    private boolean fxx = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener aJi = null;
    private NewSubPbActivity.a fKT = null;
    private NewSubPbActivity.a fKU = null;
    private g eEq = null;
    private String fKV = null;
    private int beV = 0;
    private PostData ftj = null;
    private int fLb = 0;
    private int fLc = 2;
    private int fLd = 0;
    private boolean aMC = true;
    private View.OnClickListener fxF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (booleanValue2) {
                        sparseArray.put(d.g.tag_from, 1);
                        b.this.fKC.b(sparseArray);
                        return;
                    }
                    b.this.bi(view);
                } else if (booleanValue2) {
                    sparseArray.put(d.g.tag_from, 0);
                    b.this.fKC.b(sparseArray);
                } else if (booleanValue3) {
                    b.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c bfS = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.b.3
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            b.this.gb(false);
            b.this.ax(view);
            b.this.gb(true);
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
    protected AdapterView.OnItemClickListener fLe = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (bb.aU(b.this.fKC.getPageContext().getPageActivity())) {
                if (b.this.fKC.eEi == null || b.this.fKf == null || b.this.fKf.Cm() == null || b.this.fKC.eEi.cN(b.this.fKf.Cm().replyPrivateFlag)) {
                    if (b.this.fKt != null) {
                        b.this.fKt.axI();
                    }
                    b.this.bhb();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) w.d(b.this.fKW, i);
                        if (postData == null) {
                            b.this.fKX = null;
                        } else {
                            b.this.fKX = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(d.g.tag_photo_username);
                            String str2 = (String) sparseArray.get(d.g.tag_photo_userid);
                            if (str != null) {
                                b.this.eEq.setReplyId(str2);
                                b.this.eEq.gZ(str);
                            }
                        }
                        b.this.bhc();
                        return;
                    }
                    b.this.bhd();
                    b.this.fKf.bhy();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.bOJ = null;
        this.fKA = null;
        this.LS = null;
        this.fKB = null;
        this.fKC = null;
        this.dfF = null;
        this.fKD = null;
        this.dyc = null;
        this.fKH = null;
        this.fKP = null;
        this.fKS = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.dyb = null;
        this.fKY = null;
        this.fKZ = null;
        this.fLa = null;
        this.fKC = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.bOJ = (RelativeLayout) LayoutInflater.from(this.fKC.getPageContext().getPageActivity()).inflate(d.i.new_sub_pb_layout, (ViewGroup) null);
        this.fKA = LayoutInflater.from(this.fKC.getPageContext().getPageActivity()).inflate(d.i.new_sub_pb_head, (ViewGroup) null);
        this.dyc = (TextView) this.bOJ.findViewById(d.g.no_reply_list_view);
        this.fKY = (RelativeLayout) this.bOJ.findViewById(d.g.subpb_editor_tool_comment);
        this.dyb = (TextView) this.bOJ.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.dyb.setOnClickListener(this.mCommonClickListener);
        this.fKZ = (ImageView) this.bOJ.findViewById(d.g.subpb_editor_tool_more_img);
        this.fLa = (ImageView) this.bOJ.findViewById(d.g.subpb_editor_tool_emotion_img);
        this.fLa.setOnClickListener(this.mCommonClickListener);
        this.fKZ.setOnClickListener(this.mCommonClickListener);
        this.dfF = (NoNetworkView) this.bOJ.findViewById(d.g.view_no_network);
        axQ();
        arK();
        this.fKD = (RelativeLayout) this.bOJ.findViewById(d.g.sub_pb_body_layout);
        this.LS = (BdListView) this.bOJ.findViewById(d.g.new_sub_pb_list);
        this.fKO = (ThreadSkinView) LayoutInflater.from(this.fKC.getPageContext().getPageActivity()).inflate(d.i.thread_skin_layout, (ViewGroup) null);
        this.LS.addHeaderView(this.fKO);
        this.LS.addHeaderView(this.fKA);
        this.cVX = BdListViewHelper.a(this.fKC.getActivity(), this.LS, BdListViewHelper.HeadType.DEFAULT);
        this.fKB = new c(this.fKC.getPageContext().getPageActivity());
        this.fKB.M(this.fxF);
        this.fKB.setIsFromCDN(this.mIsFromCDN);
        this.fKB.kY(true);
        this.LS.setAdapter((ListAdapter) this.fKB);
        this.fKP = new d(this.fKC.getPageContext());
        this.fKS = this.fKP.getView();
        this.LS.setNextPage(this.fKP);
        this.fKP.setOnClickListener(this.mCommonClickListener);
        this.LS.setOnItemClickListener(this.fLe);
        this.LS.setOnTouchListener(this.bfS);
        this.mProgress = (ProgressBar) this.bOJ.findViewById(d.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fKA != null) {
            this.fKA.setVisibility(4);
        }
        if (this.fKD != null) {
            this.fKD.setVisibility(4);
        }
        this.fKH = com.baidu.tbadk.ala.b.rM().f(this.fKC.getActivity(), 4);
        if (this.fKH != null) {
            this.fKH.setVisibility(8);
            this.fKF.addView(this.fKH, 3);
        }
    }

    public ListView getListView() {
        return this.LS;
    }

    public void arK() {
        this.fKF = (LinearLayout) this.fKA.findViewById(d.g.subpb_head_user_info_root);
        this.fKF.setOnClickListener(this.mCommonClickListener);
        this.fKG = (HeadImageView) this.fKA.findViewById(d.g.photo);
        this.fKG.setRadius(l.e(this.fKC.getActivity(), d.e.ds30));
        this.fKG.setClickable(false);
        this.fES = (ClickableHeaderImageView) this.fKA.findViewById(d.g.god_user_photo);
        this.fES.setGodIconMargin(0);
        this.fES.setGodIconWidth(d.e.ds24);
        this.fES.setRadius(l.e(this.fKC.getActivity(), d.e.ds30));
        this.fES.setClickable(false);
        this.azm = (TextView) this.fKA.findViewById(d.g.user_name);
        this.fKI = (ImageView) this.fKA.findViewById(d.g.user_rank);
        this.fKI.setVisibility(8);
        this.fEK = (TextView) this.fKA.findViewById(d.g.floor_owner);
        this.fKE = (TextView) this.fKA.findViewById(d.g.see_subject);
        this.fKE.setOnClickListener(this.mCommonClickListener);
        this.fKJ = (TextView) this.fKA.findViewById(d.g.floor);
        this.fKK = (TextView) this.fKA.findViewById(d.g.time);
        this.fKL = (EllipsizeRichTextView) this.fKA.findViewById(d.g.content_text);
        this.fKL.setOnClickListener(this.mCommonClickListener);
        com.baidu.tbadk.core.util.am.h(this.fKL, d.C0142d.cp_cont_b);
        this.fKL.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(d.C0142d.cp_link_tip_c));
        this.fKL.setLineSpacing(0.0f, 1.25f);
        this.fKM = (TbImageView) this.fKA.findViewById(d.g.sub_pb_image);
        this.fKM.setOnClickListener(this.mCommonClickListener);
        this.fKN = (TextView) this.fKA.findViewById(d.g.advert);
        this.cwy = (PlayVoiceBntNew) this.fKA.findViewById(d.g.voice_btn);
        this.fKA.setOnTouchListener(this.bfS);
        this.fKA.setOnClickListener(this.mCommonClickListener);
    }

    public void gd(boolean z) {
        if (this.cVX != null && this.cVX.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cVX.getLayoutParams();
            if (z) {
                axU();
                layoutParams.height = l.e(this.fKC.getPageContext().getPageActivity(), d.e.ds88);
            } else {
                layoutParams.height = l.e(this.fKC.getPageContext().getPageActivity(), d.e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.cVX.setLayoutParams(layoutParams);
        }
    }

    private void axU() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public View axV() {
        return this.cVX;
    }

    public void axQ() {
        int e = l.e(this.fKC.getPageContext().getPageActivity(), d.e.ds88);
        int e2 = l.e(this.fKC.getPageContext().getPageActivity(), d.e.ds14);
        this.mNavigationBar = (NavigationBar) this.bOJ.findViewById(d.g.view_navigation_bar);
        this.aBf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aBf.getLayoutParams();
            layoutParams.height = e;
            layoutParams.width = e;
            layoutParams.leftMargin = e2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aBf != null && (this.aBf.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aBf.getLayoutParams();
            layoutParams2.width = e;
            layoutParams2.height = e;
            this.aBf.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar UW() {
        return this.mNavigationBar;
    }

    public void bi(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.fFq == null) {
            this.fFq = new Dialog(this.fKC.getPageContext().getPageActivity(), d.l.common_alert_dialog);
            this.fFq.setCanceledOnTouchOutside(true);
            this.fFq.setCancelable(true);
            View inflate = LayoutInflater.from(this.fKC.getPageContext().getPageActivity()).inflate(d.i.forum_manage_dialog, (ViewGroup) null);
            this.fKC.getLayoutMode().onModeChanged(inflate);
            this.fFq.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.fFq.getWindow().getAttributes();
            attributes.width = (int) (l.ah(this.fKC.getPageContext().getPageActivity()) * 0.9d);
            this.fFq.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fFq.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fFq.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fFq.findViewById(d.g.disable_reply_btn);
        if ("".equals(sparseArray.get(d.g.tag_del_post_id))) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            sparseArray2.put(d.g.tag_del_post_id, sparseArray.get(d.g.tag_del_post_id));
            sparseArray2.put(d.g.tag_del_post_type, sparseArray.get(d.g.tag_del_post_type));
            sparseArray2.put(d.g.tag_del_post_is_self, sparseArray.get(d.g.tag_del_post_is_self));
            sparseArray2.put(d.g.tag_manage_user_identity, sparseArray.get(d.g.tag_manage_user_identity));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.fFq != null && (b.this.fFq instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fFq, b.this.fKC.getPageContext());
                    }
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null) {
                        b.this.a(((Integer) sparseArray3.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray3.get(d.g.tag_del_post_id), ((Integer) sparseArray3.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(d.g.tag_forbid_user_name)) && "".equals(sparseArray.get(d.g.tag_forbid_user_name_show))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(d.g.tag_forbid_user_name, sparseArray.get(d.g.tag_forbid_user_name));
            sparseArray3.put(d.g.tag_forbid_user_name_show, sparseArray.get(d.g.tag_forbid_user_name_show));
            sparseArray3.put(d.g.tag_forbid_user_portrait, sparseArray.get(d.g.tag_forbid_user_portrait));
            sparseArray3.put(d.g.tag_manage_user_identity, sparseArray.get(d.g.tag_manage_user_identity));
            sparseArray3.put(d.g.tag_forbid_user_post_id, sparseArray.get(d.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.fFq != null && (b.this.fFq instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fFq, b.this.fKC.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.fKT != null) {
                        b.this.fKT.i(new Object[]{sparseArray4.get(d.g.tag_manage_user_identity), sparseArray4.get(d.g.tag_forbid_user_name), sparseArray4.get(d.g.tag_forbid_user_post_id), sparseArray4.get(d.g.tag_forbid_user_name_show), sparseArray4.get(d.g.tag_forbid_user_portrait)});
                    }
                }
            });
        }
        if (!((sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(d.k.un_mute);
            } else {
                textView3.setText(d.k.mute);
            }
            sparseArray4.put(d.g.tag_is_mem, sparseArray.get(d.g.tag_is_mem));
            sparseArray4.put(d.g.tag_user_mute_mute_userid, sparseArray.get(d.g.tag_user_mute_mute_userid));
            sparseArray4.put(d.g.tag_user_mute_mute_username, sparseArray.get(d.g.tag_user_mute_mute_username));
            sparseArray4.put(d.g.tag_user_mute_post_id, sparseArray.get(d.g.tag_user_mute_post_id));
            sparseArray4.put(d.g.tag_user_mute_thread_id, sparseArray.get(d.g.tag_user_mute_thread_id));
            sparseArray4.put(d.g.tag_user_mute_mute_nameshow, sparseArray.get(d.g.tag_user_mute_mute_nameshow));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.fFq != null && (b.this.fFq instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fFq, b.this.fKC.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.fKC.a(z, (String) sparseArray5.get(d.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fFq, this.fKC.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        final SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(d.g.tag_del_post_id, str);
        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = d.k.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = d.k.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = d.k.report_thread_confirm;
            } else {
                i3 = d.k.del_thread_confirm;
            }
        }
        this.fFs = new com.baidu.tbadk.core.dialog.a(this.fKC.getPageContext().getPageActivity());
        this.fFs.cd(i3);
        this.fFs.C(sparseArray);
        this.fFs.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.fKU != null) {
                    b.this.fKU.i(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.fFs.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fFs.aw(true);
        this.fFs.b(this.fKC.getPageContext());
        if (z) {
            this.fFs.xn();
        } else {
            d(sparseArray);
        }
    }

    private void d(final SparseArray<Object> sparseArray) {
        AntiData Cm;
        if (this.fKC != null && sparseArray != null && this.fKA != null) {
            if (this.dHz == null) {
                this.dHz = new e(this.fKC.getPageContext(), this.fKA);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.fKf != null && (Cm = this.fKf.Cm()) != null && Cm.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = Cm.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            ai aiVar = new ai();
            aiVar.a(sparseArray2);
            this.dHz.setDefaultReasonArray(new String[]{this.fKC.getString(d.k.delete_thread_reason_1), this.fKC.getString(d.k.delete_thread_reason_2), this.fKC.getString(d.k.delete_thread_reason_3), this.fKC.getString(d.k.delete_thread_reason_4), this.fKC.getString(d.k.delete_thread_reason_5)});
            this.dHz.setData(aiVar);
            this.dHz.ib("4");
            this.dHz.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.b.9
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void f(JSONArray jSONArray) {
                    String d = ap.d(jSONArray);
                    if (b.this.fKU != null) {
                        b.this.fKU.i(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type), d});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gb(final boolean z) {
        if (this.LS != null) {
            if (!z) {
                this.LS.setEnabled(z);
            } else {
                this.LS.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.b.10
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.LS.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void b(b.InterfaceC0104b interfaceC0104b, boolean z) {
        String string;
        if (this.fFB != null) {
            this.fFB.dismiss();
            this.fFB = null;
        }
        if (z) {
            string = this.fKC.getResources().getString(d.k.remove_mark);
        } else {
            string = this.fKC.getResources().getString(d.k.mark);
        }
        this.fFB = new com.baidu.tbadk.core.dialog.b(this.fKC.getPageContext().getPageActivity());
        this.fFB.cg(d.k.operation);
        this.fFB.a(new String[]{this.fKC.getResources().getString(d.k.copy), string}, interfaceC0104b);
        this.fFB.d(this.fKC.getPageContext());
        this.fFB.xq();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.fKT = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.fKU = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.fKC.showToast(this.fKC.getResources().getString(d.k.delete_success));
        } else if (str != null && z2) {
            this.fKC.showToast(str);
        }
    }

    public void ax(View view) {
        if (this.cVX != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cVX.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.LS != null) {
                    this.LS.removeHeaderView(this.cVX);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.cVX.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.e(this.fKC.getActivity(), d.e.ds98)));
            } else if (this.LS != null) {
                this.LS.addHeaderView(this.cVX, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.Hy() != null) {
            this.eEq = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bOJ.addView(gVar.Hy(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.fKt = aVar;
    }

    public void bhb() {
        if (this.LS != null) {
            this.fLd = this.LS.getLastVisiblePosition();
        }
    }

    public void bhc() {
        if (this.fKf != null) {
            if ((!bhf() && this.fKS != null && this.fKS.isShown()) || w.A(this.fKW)) {
                this.fKf.lb(false);
            } else {
                this.fKf.lb(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.fKf = subPbModel;
    }

    public void bhd() {
        a(this.fKC);
        this.LS.setNextPage(this.fKP);
    }

    public void m(PostData postData) {
        int i;
        if (postData != null) {
            postData.mH(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bhf() && this.fKS != null && this.fKS.isShown()) {
                i = (this.fLd - this.fLc) - 1;
            } else {
                i = this.fLd - this.fLc;
            }
            int z = w.z(this.fKW);
            if (i > z) {
                i = z;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(w.a(this.fKW, 0, i));
            w.b(arrayList, postData2);
            w.b(arrayList, postData);
            this.fKB.setDatas(arrayList);
            this.fKB.notifyDataSetChanged();
            this.LS.smoothScrollToPosition(this.fLd + 2);
            this.LS.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.LS.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.LS.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.bOJ;
    }

    public void bfX() {
        if (this.fKQ != null) {
            com.baidu.adp.lib.g.g.a(this.fKQ, this.fKC.getPageContext().getPageActivity());
        }
        if (this.fFB != null) {
            this.fFB.dismiss();
        }
        if (this.fFs != null) {
            this.fFs.dismiss();
        }
        if (this.fFq != null) {
            com.baidu.adp.lib.g.g.b(this.fFq, this.fKC.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.fvp != null) {
            this.fvp.dismiss();
        }
    }

    public void bhe() {
        this.LS.setNextPage(this.fKP);
        this.fKP.AH();
    }

    public void jH(boolean z) {
        this.fxx = z;
    }

    public void setIsFromPb(boolean z) {
        this.aMC = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(k kVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (kVar != null) {
            if (this.aMC && this.fKA != null) {
                this.fKB.kZ(true);
                this.fKA.setVisibility(8);
                this.LS.removeHeaderView(this.fKA);
                this.fLc = 1;
            }
            this.fJa = kVar;
            this.fKB.X(this.fJa.SV());
            if (this.fKA != null) {
                this.fKA.setVisibility(0);
            }
            if (this.fKD != null) {
                this.fKD.setVisibility(0);
            }
            if (kVar.bbG() != null) {
                this.fKV = kVar.bbG().getId();
                this.beV = kVar.bbG().bxC();
                if (this.beV > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.fKC.getResources().getString(d.k.subpb_floor_reply_count), ap.D(kVar.getTotalCount())));
                    this.dyb.setText(d.k.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.fKC.bha()) {
                    str = "PB";
                }
                if (kVar.bbG().vQ() != null) {
                    this.fKO.setData(this.fKC.getPageContext(), kVar.bbG().vQ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", kVar.bbN().getId(), kVar.bbN().getName(), kVar.SV().getId(), str));
                } else {
                    this.fKO.setData(null, null, null);
                }
            }
            if (kVar.hasMore()) {
                this.fKP.AH();
                this.fKB.setHasMoreData(true);
            } else {
                this.fKP.AI();
                this.fKB.setHasMoreData(false);
            }
            this.fKW = kVar.bbK();
            if (w.A(this.fKW)) {
                this.LS.setNextPage(null);
                if (this.aMC) {
                    this.dyc.setVisibility(0);
                }
            } else {
                this.LS.setNextPage(this.fKP);
                if (this.aMC) {
                    this.dyc.setVisibility(8);
                }
            }
            if (this.fKW == null || this.fKW.size() <= fKz) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.fKW.size() - fKz;
                qZ(size);
                int firstVisiblePosition = this.LS.getFirstVisiblePosition() - size;
                View childAt = this.LS.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.fKB.setDatas(this.fKW);
            boolean z2 = false;
            if (kVar.SV() != null && kVar.SV().vw() != null && (userId = kVar.SV().vw().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.fKB.B(i, z2);
            this.fKB.notifyDataSetChanged();
            a(kVar.bbG(), kVar.aLM(), kVar.sc(), i, z);
            if (i4 > 0) {
                this.LS.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void qZ(int i) {
        if (this.fKW != null) {
            if (this.fKW.size() <= i) {
                this.fKW.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.fKW.iterator();
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

    public boolean bhf() {
        return this.fKB.cFg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.aMC) {
            this.ftj = postData;
            if (!StringUtils.isNull(postData.bxJ())) {
                this.fKM.setVisibility(0);
                this.fKM.startLoad(postData.bxJ(), 10, true);
            } else {
                this.fKM.setVisibility(8);
            }
            h bxL = postData.bxL();
            if (bxL != null && bxL.gMD) {
                this.fKN.setVisibility(0);
            } else {
                this.fKN.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.fKA.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.fKA.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.fKJ.setText((CharSequence) null);
            this.azm.setText((CharSequence) null);
            this.fEK.setVisibility(8);
            if (!this.aMC) {
                c(postData.vw());
                if (z) {
                    this.fEK.setVisibility(0);
                    com.baidu.tbadk.core.util.am.h(this.fEK, d.C0142d.cp_link_tip_a);
                }
            }
            this.fKK.setText(ap.w(postData.getTime()));
            this.fKJ.setText(String.format(this.fKC.getPageContext().getString(d.k.is_floor), Integer.valueOf(postData.bxC())));
            postData.vw().getUserTbVipInfoData();
            boolean a = a(this.fKL, postData.bxE());
            if (StringUtils.isNull(postData.bxJ()) && !a && postData.NH() != null) {
                this.cwy.setVisibility(0);
                this.cwy.setTag(postData.NH());
                return;
            }
            this.cwy.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.k.bi(metaData.getSealPrefix()) + 2 : 0) + x.hK(name_show) > 14) {
                name_show = x.k(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.azm.setText(ak(metaData.getSealPrefix(), name_show));
            } else {
                this.azm.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.fKH != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.fKH.setVisibility(8);
                } else {
                    this.fKH.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.aan = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.fKH.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.fES.setVisibility(0);
                this.fKG.setVisibility(8);
                this.fES.setUserId(metaData.getUserId());
                this.fES.setUserName(metaData.getUserName());
                this.fES.startLoad(metaData.getPortrait(), 28, false);
                com.baidu.tbadk.core.util.am.h(this.azm, d.C0142d.cp_cont_r);
            } else {
                this.fES.setVisibility(8);
                this.fKG.setVisibility(0);
                this.fKG.setUserId(metaData.getUserId());
                this.fKG.setUserName(metaData.getUserName());
                this.fKG.setDefaultResource(d.f.transparent_bg);
                this.fKG.setDefaultErrorResource(d.f.icon_default_avatar100);
                this.fKG.startLoad(metaData.getPortrait(), 28, false);
                com.baidu.tbadk.core.util.am.h(this.azm, d.C0142d.cp_cont_c);
            }
            this.fKF.setTag(d.g.tag_user_id, metaData.getUserId());
            this.fKF.setTag(d.g.tag_user_name, metaData.getUserName());
            this.fKF.setTag(d.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.Nz() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.Nz().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.NG());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.cn(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.bFG());
                        continue;
                    case 17:
                        String str = next.NK().mGifInfo.mSharpText;
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
        if (!tbRichTextData.NP()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.NG() == null || tbRichTextData.NG().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.NG());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fKC.getPageContext().getString(d.k.refresh_view_title_text), this.abB));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.fKC.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.fKD, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.f.pic_emotion07, l.e(pageActivity, d.e.ds250), l.e(pageActivity, d.e.ds480), l.e(pageActivity, d.e.ds360)), dVar, a);
        }
        this.fKD.setVisibility(0);
        this.LS.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.eEq.Iu();
        com.baidu.tbadk.core.util.am.j(this.mNoDataView, d.C0142d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.fKC.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void il(int i) {
        b(NoDataViewFactory.d.D(i, d.k.refresh_view_title_text));
        if (this.fKt != null) {
            this.fKt.bl(this.bOJ);
        }
        this.fKY.setVisibility(8);
    }

    public void mG(String str) {
        b(NoDataViewFactory.d.aj(str, this.fKC.getPageContext().getString(d.k.refresh_view_title_text)));
        if (this.fKt != null) {
            this.fKt.bl(this.bOJ);
        }
        this.fKY.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.LS.setVisibility(0);
            this.fKY.setVisibility(0);
            this.bOJ.setOnTouchListener(null);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.abB = onClickListener;
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
                String userId2 = postData.vw().getUserId();
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
            if (this.fJa != null && this.fJa.SV() != null && this.fJa.SV().vw() != null && postData.vw() != null) {
                String userId3 = this.fJa.SV().vw().getUserId();
                String userId4 = postData.vw().getUserId();
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
                    userId = postData.vw().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.bxC() != 1 ? 0 : 1;
                    if (as.j(postData)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
                        if (postData.vw() != null) {
                            sparseArray.put(d.g.tag_forbid_user_name, postData.vw().getUserName());
                            sparseArray.put(d.g.tag_forbid_user_name_show, postData.vw().getName_show());
                            sparseArray.put(d.g.tag_forbid_user_portrait, postData.vw().getPortrait());
                            z7 = true;
                        } else {
                            z7 = true;
                        }
                    } else {
                        sparseArray.put(d.g.tag_forbid_user_name, "");
                        sparseArray.put(d.g.tag_forbid_user_name_show, "");
                        sparseArray.put(d.g.tag_forbid_user_portrait, "");
                        z7 = false;
                    }
                    if (!z4) {
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(d.g.tag_del_post_is_self, true);
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(d.g.tag_del_post_is_self, false);
                        sparseArray.put(d.g.tag_del_post_type, 0);
                        sparseArray.put(d.g.tag_del_post_id, "");
                    }
                    sparseArray.put(d.g.tag_should_manage_visible, Boolean.valueOf(z7));
                    sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z6) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i));
                        if (postData.vw() != null) {
                            sparseArray.put(d.g.tag_forbid_user_name, postData.vw().getUserName());
                            sparseArray.put(d.g.tag_forbid_user_name_show, postData.vw().getName_show());
                            sparseArray.put(d.g.tag_forbid_user_portrait, postData.vw().getPortrait());
                        }
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.vw() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.vw().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.vw().getUserName());
                            sparseArray.put(d.g.tag_user_mute_mute_nameshow, postData.vw().getName_show());
                        }
                        if (this.fJa.SV() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fJa.SV().getId());
                        }
                        sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(d.g.tag_should_delete_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                        return;
                    }
                    sparseArray.put(d.g.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = postData.vw().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.bxC() != 1) {
            }
            if (as.j(postData)) {
            }
            if (!z6) {
            }
            if (!z4) {
            }
            sparseArray.put(d.g.tag_should_manage_visible, Boolean.valueOf(z7));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            if (!z6) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public void kX(boolean z) {
        if (this.fvp != null && this.fvp.beB() != null) {
            if (z) {
                this.fvp.beB().setText(d.k.remove_mark);
            } else {
                this.fvp.beB().setText(d.k.mark);
            }
            this.fvp.refreshUI();
        }
    }

    public View bhg() {
        return this.fKS;
    }

    public void onChangeSkinType(int i) {
        this.fKC.getLayoutMode().setNightMode(i == 1);
        this.fKC.getLayoutMode().onModeChanged(this.bOJ);
        this.fKC.getLayoutMode().onModeChanged(this.fKA);
        this.mNavigationBar.onChangeSkinType(this.fKC.getPageContext(), i);
        if (this.fKE != null) {
            com.baidu.tbadk.core.util.am.h(this.fKE, d.C0142d.goto_see_subject_color);
        }
        com.baidu.tbadk.core.util.am.h(this.dyc, d.C0142d.cp_cont_d);
        this.dfF.onChangeSkinType(this.fKC.getPageContext(), i);
        this.fKC.getLayoutMode().onModeChanged(this.fKS);
        com.baidu.tbadk.core.util.am.h(this.fKL, d.C0142d.cp_cont_b);
        this.fKL.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(d.C0142d.cp_link_tip_c));
        if (this.eEq != null && this.eEq.Hy() != null) {
            this.eEq.Hy().onChangeSkinType(i);
        }
        this.fKP.dz(i);
        this.cwy.aOt();
        com.baidu.tbadk.core.util.am.h(this.dyb, d.C0142d.cp_cont_e);
        com.baidu.tbadk.core.util.am.h(this.fEK, d.C0142d.cp_link_tip_a);
        com.baidu.tbadk.core.util.am.h(this.azm, d.C0142d.cp_cont_c);
        this.dyb.setAlpha(0.95f);
        if (this.fKB != null) {
            this.fKB.notifyDataSetChanged();
        }
    }

    public void bhh() {
        this.mProgress.setVisibility(0);
    }

    public void bhi() {
        this.LS.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fKP.AI();
    }

    public void aql() {
        this.LS.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fKP.aql();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aJi = onLongClickListener;
        this.fKA.setOnLongClickListener(this.aJi);
    }

    public View bhj() {
        return this.fKA;
    }

    public TextView axW() {
        return this.dyb;
    }

    public ImageView bhk() {
        return this.fKZ;
    }

    public ImageView bhl() {
        return this.fLa;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void ra(int i) {
    }

    public void rG(String str) {
        int rH = this.fKB.rH(str);
        if (rH > -1) {
            this.fKB.rb(rH);
            if (rH > 2) {
                this.LS.setSelection(rH - 2);
            } else {
                this.LS.setSelection(rH);
            }
            this.LS.invalidate();
        }
    }

    public View bhm() {
        return this.fKE;
    }

    public View bhn() {
        return this.fKM;
    }

    public MorePopupWindow bho() {
        return this.fKQ;
    }

    public void showLoadingDialog() {
        if (this.cGa == null) {
            this.cGa = new com.baidu.tbadk.core.view.a(this.fKC.getPageContext());
        }
        this.cGa.aO(true);
    }

    public void aeB() {
        if (this.cGa != null) {
            this.cGa.aO(false);
        }
    }

    public TextView bhp() {
        return this.fKL;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.fKj = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fKk = hVar;
    }

    public y bhq() {
        return this.fvp;
    }

    public void awJ() {
    }

    public void awK() {
    }

    public void onActivityDestroy() {
    }

    public void bhr() {
        if (this.fKC.isPaused()) {
        }
    }

    public View bhs() {
        return this.fKF;
    }

    private SpannableStringBuilder ak(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, d.f.pic_smalldot_title));
            return o.a((Context) this.fKC.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
