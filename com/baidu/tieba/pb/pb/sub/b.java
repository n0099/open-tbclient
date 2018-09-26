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
/* loaded from: classes2.dex */
public class b implements KeyboardEventLayout.a {
    private static final int fSl = TbadkCoreApplication.getInst().getListItemRule().Dx();
    private RelativeLayout bVs;
    private com.baidu.tbadk.core.view.d cOv;
    private TextView dHu;
    private com.baidu.tieba.NEGFeedBack.e dRu;
    private View deF;
    private NoNetworkView dom;
    private y fDm;
    private View fNe;
    private com.baidu.tbadk.core.dialog.b fNh;
    private j fQO;
    private SubPbModel fRR;
    private e fSA;
    private View fSD;
    private ArrayList<PostData> fSH;
    private String fSI;
    private RelativeLayout fSJ;
    private ImageView fSK;
    private ImageView fSL;
    private d fSP;
    private a fSf;
    private View fSm;
    private NewSubPbActivity fSn;
    private RelativeLayout fSo;
    private View fSs;
    private ThreadSkinView fSz;
    private View.OnClickListener mCommonClickListener;
    private BdTypeListView mListView;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener adI = null;
    private TbRichTextView.i fRV = null;
    private NavigationBar mNavigationBar = null;
    private View aEa = null;
    private TextView fSp = null;
    private LinearLayout fSq = null;
    private HeadImageView fSr = null;
    private ClickableHeaderImageView fMx = null;
    private TextView aBX = null;
    private ImageView fSt = null;
    private TextView fMp = null;
    private TextView fSu = null;
    private TextView fSv = null;
    private EllipsizeRichTextView fSw = null;
    private TbImageView fSx = null;
    private PlayVoiceBntNew cEQ = null;
    private TextView fSy = null;
    private MorePopupWindow fSB = null;
    private am fSC = null;
    private com.baidu.tbadk.core.dialog.b fNg = null;
    private Dialog fMV = null;
    private com.baidu.tbadk.core.dialog.a fMX = null;
    private boolean fFt = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener aMC = null;
    private NewSubPbActivity.a fSE = null;
    private NewSubPbActivity.a fSF = null;
    private g ePv = null;
    private String fSG = null;
    private int biC = 0;
    private PostData fAX = null;
    private int fSM = 0;
    private int fSN = 2;
    private int fSO = 0;
    private boolean aPR = true;
    private View.OnClickListener fFB = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
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
                        b.this.fSn.b(sparseArray);
                        return;
                    }
                    b.this.bA(view);
                } else if (booleanValue2) {
                    sparseArray.put(e.g.tag_from, 0);
                    b.this.fSn.b(sparseArray);
                } else if (booleanValue3) {
                    b.this.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c bjA = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.b.4
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            b.this.gB(false);
            b.this.aO(view);
            b.this.gB(true);
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
    protected AdapterView.OnItemLongClickListener fSQ = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.d(b.this.fSH, i);
            if (view == null || view.getTag() == null) {
                return false;
            }
            if (b.this.fDm == null) {
                b.this.fDm = new y(b.this.fSn.getPageContext(), b.this.mCommonClickListener);
            }
            b.this.fDm.showDialog();
            SparseArray<Object> sparseArray = null;
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray == null) {
                return true;
            }
            boolean kb = b.this.kb(sparseArray.get(e.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue() : false) & TbadkCoreApplication.isLogin();
            b.this.fDm.a(sparseArray, b.this.fRR.bbV(), kb);
            if (kb) {
                b.this.fDm.bfr().setVisibility(0);
                b.this.fDm.bfr().setTag(postData.getId());
            } else {
                b.this.fDm.bfr().setVisibility(8);
            }
            b.this.fDm.bfp().setVisibility(8);
            b.this.fDm.refreshUI();
            return false;
        }
    };
    protected AdapterView.OnItemClickListener fSR = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ba.bA(b.this.fSn.getPageContext().getPageActivity())) {
                if (b.this.fSn.ePn == null || b.this.fRR == null || b.this.fRR.avt() == null || b.this.fSn.ePn.cY(b.this.fRR.avt().replyPrivateFlag)) {
                    if (b.this.fSf != null) {
                        b.this.fSf.aAA();
                    }
                    b.this.bhT();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) v.d(b.this.fSH, i);
                        if (postData == null) {
                            b.this.fSI = null;
                        } else {
                            b.this.fSI = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(e.g.tag_photo_username);
                            String str2 = (String) sparseArray.get(e.g.tag_photo_userid);
                            if (str != null) {
                                b.this.ePv.setReplyId(str2);
                                b.this.ePv.hr(str);
                            }
                        }
                        b.this.bhU();
                        return;
                    }
                    b.this.bhV();
                    b.this.fRR.biq();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.bVs = null;
        this.fSm = null;
        this.mListView = null;
        this.fSn = null;
        this.dom = null;
        this.fSo = null;
        this.fSs = null;
        this.fSA = null;
        this.fSD = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.dHu = null;
        this.fSJ = null;
        this.fSK = null;
        this.fSL = null;
        this.fSn = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.bVs = (RelativeLayout) LayoutInflater.from(this.fSn.getPageContext().getPageActivity()).inflate(e.h.new_sub_pb_layout, (ViewGroup) null);
        this.fSm = LayoutInflater.from(this.fSn.getPageContext().getPageActivity()).inflate(e.h.new_sub_pb_head, (ViewGroup) null);
        this.fSJ = (RelativeLayout) this.bVs.findViewById(e.g.subpb_editor_tool_comment);
        this.dHu = (TextView) this.bVs.findViewById(e.g.subpb_editor_tool_comment_reply_text);
        this.dHu.setOnClickListener(this.mCommonClickListener);
        this.fSK = (ImageView) this.bVs.findViewById(e.g.subpb_editor_tool_more_img);
        this.fSL = (ImageView) this.bVs.findViewById(e.g.subpb_editor_tool_emotion_img);
        this.fSL.setOnClickListener(this.mCommonClickListener);
        this.fSK.setOnClickListener(this.mCommonClickListener);
        this.dom = (NoNetworkView) this.bVs.findViewById(e.g.view_no_network);
        aAI();
        aub();
        this.fSo = (RelativeLayout) this.bVs.findViewById(e.g.sub_pb_body_layout);
        this.mListView = (BdTypeListView) this.bVs.findViewById(e.g.new_sub_pb_list);
        this.fSz = (ThreadSkinView) LayoutInflater.from(this.fSn.getPageContext().getPageActivity()).inflate(e.h.thread_skin_layout, (ViewGroup) null);
        this.mListView.addHeaderView(this.fSz);
        this.mListView.addHeaderView(this.fSm);
        this.deF = BdListViewHelper.a(this.fSn.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.fSA = new e(this.fSn.getPageContext());
        this.fSA.BF();
        this.fSD = this.fSA.getView();
        this.mListView.setNextPage(this.fSA);
        this.fSA.setOnClickListener(this.mCommonClickListener);
        this.mListView.setOnItemClickListener(this.fSR);
        this.mListView.setOnItemLongClickListener(this.fSQ);
        this.mListView.setOnTouchListener(this.bjA);
        this.mProgress = (ProgressBar) this.bVs.findViewById(e.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fSm != null) {
            this.fSm.setVisibility(4);
        }
        if (this.fSo != null) {
            this.fSo.setVisibility(4);
        }
        this.fSs = com.baidu.tbadk.ala.b.sB().i(this.fSn.getActivity(), 4);
        if (this.fSs != null) {
            this.fSs.setVisibility(8);
            this.fSq.addView(this.fSs, 3);
        }
        this.fSP = new d(this.fSn, this.mListView);
        this.fSP.setFromCDN(this.mIsFromCDN);
        this.fSP.q(this.mCommonClickListener);
        this.fSP.initAdapters();
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void aub() {
        this.fSq = (LinearLayout) this.fSm.findViewById(e.g.subpb_head_user_info_root);
        this.fSq.setOnClickListener(this.mCommonClickListener);
        this.fSr = (HeadImageView) this.fSm.findViewById(e.g.photo);
        this.fSr.setRadius(l.h(this.fSn.getActivity(), e.C0141e.ds30));
        this.fSr.setClickable(false);
        this.fMx = (ClickableHeaderImageView) this.fSm.findViewById(e.g.god_user_photo);
        this.fMx.setGodIconMargin(0);
        this.fMx.setGodIconWidth(e.C0141e.ds24);
        this.fMx.setRadius(l.h(this.fSn.getActivity(), e.C0141e.ds30));
        this.fMx.setClickable(false);
        this.aBX = (TextView) this.fSm.findViewById(e.g.user_name);
        this.fSt = (ImageView) this.fSm.findViewById(e.g.user_rank);
        this.fSt.setVisibility(8);
        this.fMp = (TextView) this.fSm.findViewById(e.g.floor_owner);
        this.fSp = (TextView) this.fSm.findViewById(e.g.see_subject);
        this.fSp.setOnClickListener(this.mCommonClickListener);
        this.fSu = (TextView) this.fSm.findViewById(e.g.floor);
        this.fSv = (TextView) this.fSm.findViewById(e.g.time);
        this.fSw = (EllipsizeRichTextView) this.fSm.findViewById(e.g.content_text);
        this.fSw.setOnClickListener(this.mCommonClickListener);
        al.h(this.fSw, e.d.cp_cont_b);
        this.fSw.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
        this.fSw.setLineSpacing(0.0f, 1.25f);
        this.fSx = (TbImageView) this.fSm.findViewById(e.g.sub_pb_image);
        this.fSx.setOnClickListener(this.mCommonClickListener);
        this.fSy = (TextView) this.fSm.findViewById(e.g.advert);
        this.cEQ = (PlayVoiceBntNew) this.fSm.findViewById(e.g.voice_btn);
        this.fSm.setOnTouchListener(this.bjA);
        this.fSm.setOnClickListener(this.mCommonClickListener);
    }

    public void gD(boolean z) {
        if (this.deF != null && this.deF.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.deF.getLayoutParams();
            if (z) {
                aAM();
                layoutParams.height = l.h(this.fSn.getPageContext().getPageActivity(), e.C0141e.ds88);
            } else {
                layoutParams.height = l.h(this.fSn.getPageContext().getPageActivity(), e.C0141e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.deF.setLayoutParams(layoutParams);
        }
    }

    private void aAM() {
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_close, e.f.subpb_navigationbar_close);
    }

    public void a(b.InterfaceC0100b interfaceC0100b, boolean z) {
        if (this.fNh != null) {
            this.fNh.dismiss();
            this.fNh = null;
        }
        this.fNh = new com.baidu.tbadk.core.dialog.b(this.fSn.getPageContext().getPageActivity());
        if (z) {
            this.fNh.a(new String[]{this.fSn.getPageContext().getString(e.j.save_to_emotion)}, interfaceC0100b);
        } else {
            this.fNh.a(new String[]{this.fSn.getPageContext().getString(e.j.save_to_emotion), this.fSn.getPageContext().getString(e.j.save_to_local)}, interfaceC0100b);
        }
        this.fNh.d(this.fSn.getPageContext());
        this.fNh.yo();
    }

    public void bC(View view) {
        this.fNe = view;
    }

    public View aAN() {
        return this.deF;
    }

    public void aAI() {
        int h = l.h(this.fSn.getPageContext().getPageActivity(), e.C0141e.ds88);
        int h2 = l.h(this.fSn.getPageContext().getPageActivity(), e.C0141e.ds2);
        this.mNavigationBar = (NavigationBar) this.bVs.findViewById(e.g.view_navigation_bar);
        this.aEa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aEa.getLayoutParams();
            layoutParams.height = h;
            layoutParams.width = h;
            layoutParams.leftMargin = h2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aEa != null && (this.aEa.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aEa.getLayoutParams();
            layoutParams2.width = h;
            layoutParams2.height = h;
            this.aEa.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_back, e.f.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar WW() {
        return this.mNavigationBar;
    }

    public void bA(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.fMV == null) {
            this.fMV = new Dialog(this.fSn.getPageContext().getPageActivity(), e.k.common_alert_dialog);
            this.fMV.setCanceledOnTouchOutside(true);
            this.fMV.setCancelable(true);
            View inflate = LayoutInflater.from(this.fSn.getPageContext().getPageActivity()).inflate(e.h.forum_manage_dialog, (ViewGroup) null);
            this.fSn.getLayoutMode().onModeChanged(inflate);
            this.fMV.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.fMV.getWindow().getAttributes();
            attributes.width = (int) (l.aO(this.fSn.getPageContext().getPageActivity()) * 0.9d);
            this.fMV.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fMV.findViewById(e.g.del_post_btn);
        TextView textView2 = (TextView) this.fMV.findViewById(e.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fMV.findViewById(e.g.disable_reply_btn);
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
                    if (b.this.fMV != null && (b.this.fMV instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fMV, b.this.fSn.getPageContext());
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
                    if (b.this.fMV != null && (b.this.fMV instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fMV, b.this.fSn.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.fSE != null) {
                        b.this.fSE.j(new Object[]{sparseArray4.get(e.g.tag_manage_user_identity), sparseArray4.get(e.g.tag_forbid_user_name), sparseArray4.get(e.g.tag_forbid_user_post_id), sparseArray4.get(e.g.tag_forbid_user_name_show), sparseArray4.get(e.g.tag_forbid_user_portrait)});
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
                    if (b.this.fMV != null && (b.this.fMV instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fMV, b.this.fSn.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.fSn.a(z, (String) sparseArray5.get(e.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fMV, this.fSn.getPageContext());
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
        this.fMX = new com.baidu.tbadk.core.dialog.a(this.fSn.getPageContext().getPageActivity());
        this.fMX.cp(i3);
        this.fMX.D(sparseArray);
        this.fMX.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.fSF != null) {
                    b.this.fSF.j(new Object[]{sparseArray.get(e.g.tag_del_post_id), sparseArray.get(e.g.tag_manage_user_identity), sparseArray.get(e.g.tag_del_post_is_self), sparseArray.get(e.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.fMX.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fMX.aE(true);
        this.fMX.b(this.fSn.getPageContext());
        if (z) {
            this.fMX.yl();
        } else {
            d(sparseArray);
        }
    }

    private void d(final SparseArray<Object> sparseArray) {
        AntiData avt;
        if (this.fSn != null && sparseArray != null && this.fSm != null) {
            if (this.dRu == null) {
                this.dRu = new com.baidu.tieba.NEGFeedBack.e(this.fSn.getPageContext(), this.fSm);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.fRR != null && (avt = this.fRR.avt()) != null && avt.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = avt.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray2);
            this.dRu.setDefaultReasonArray(new String[]{this.fSn.getString(e.j.delete_thread_reason_1), this.fSn.getString(e.j.delete_thread_reason_2), this.fSn.getString(e.j.delete_thread_reason_3), this.fSn.getString(e.j.delete_thread_reason_4), this.fSn.getString(e.j.delete_thread_reason_5)});
            this.dRu.setData(ahVar);
            this.dRu.iA("4");
            this.dRu.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.b.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void j(JSONArray jSONArray) {
                    String h = ao.h(jSONArray);
                    if (b.this.fSF != null) {
                        b.this.fSF.j(new Object[]{sparseArray.get(e.g.tag_del_post_id), sparseArray.get(e.g.tag_manage_user_identity), sparseArray.get(e.g.tag_del_post_is_self), sparseArray.get(e.g.tag_del_post_type), h});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gB(final boolean z) {
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
        this.fSE = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.fSF = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.fSn.showToast(this.fSn.getResources().getString(e.j.delete_success));
        } else if (str != null && z2) {
            this.fSn.showToast(str);
        }
    }

    public void aO(View view) {
        if (this.deF != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.deF.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.deF);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.deF.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.fSn.getActivity(), e.C0141e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.deF, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.IJ() != null) {
            this.ePv = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bVs.addView(gVar.IJ(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.fSf = aVar;
    }

    public void bhT() {
        if (this.mListView != null) {
            this.fSO = this.mListView.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kb(boolean z) {
        if (this.fRR == null || this.fRR.bin() == null) {
            return false;
        }
        if (this.fRR.bbV() != 0) {
            return false;
        }
        return (this.fQO == null || this.fQO.UT() == null || this.fQO.UT().wm() == null || !TextUtils.equals(this.fQO.UT().wm().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void bhU() {
        if (this.fRR != null) {
            if ((!bhX() && this.fSD != null && this.fSD.isShown()) || v.z(this.fSH)) {
                this.fRR.lj(false);
            } else {
                this.fRR.lj(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.fRR = subPbModel;
    }

    public void bhV() {
        a(this.fSn);
        this.mListView.setNextPage(this.fSA);
    }

    public void n(PostData postData) {
        int i;
        if (postData != null) {
            postData.mP(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bhX() && this.fSD != null && this.fSD.isShown()) {
                i = (this.fSO - this.fSN) - 1;
            } else {
                i = this.fSO - this.fSN;
            }
            int y = v.y(this.fSH);
            if (i > y) {
                i = y;
            }
            ArrayList arrayList = new ArrayList(v.b(this.fSH, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.mListView.smoothScrollToPosition(this.fSO + 2);
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
        return this.bVs;
    }

    public void bgK() {
        if (this.fSB != null) {
            com.baidu.adp.lib.g.g.a(this.fSB, this.fSn.getPageContext().getPageActivity());
        }
        if (this.fNg != null) {
            this.fNg.dismiss();
        }
        if (this.fMX != null) {
            this.fMX.dismiss();
        }
        if (this.fMV != null) {
            com.baidu.adp.lib.g.g.b(this.fMV, this.fSn.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.fDm != null) {
            this.fDm.dismiss();
        }
    }

    public void bhW() {
        this.mListView.setNextPage(this.fSA);
        this.fSA.BI();
    }

    public void jU(boolean z) {
        this.fFt = z;
    }

    public void setIsFromPb(boolean z) {
        this.aPR = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v36, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(j jVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (jVar != null) {
            if (this.aPR && this.fSm != null) {
                this.fSm.setVisibility(8);
                this.mListView.removeHeaderView(this.fSm);
                this.fSN = 1;
            }
            this.fQO = jVar;
            if (this.fSm != null) {
                this.fSm.setVisibility(0);
            }
            if (this.fSo != null) {
                this.fSo.setVisibility(0);
            }
            if (jVar.bcq() != null) {
                this.fSG = jVar.bcq().getId();
                this.biC = jVar.bcq().byM();
                if (this.biC > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.fSn.getResources().getString(e.j.subpb_floor_reply), Integer.valueOf(this.biC)));
                    this.dHu.setText(e.j.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = this.fSn.bhS() ? "PB" : null;
                if (jVar.bcq().wI() != null) {
                    this.fSz.setData(this.fSn.getPageContext(), jVar.bcq().wI(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", jVar.bcx().getId(), jVar.bcx().getName(), jVar.UT().getId(), str));
                } else {
                    this.fSz.setData(null, null, null);
                }
            }
            if (jVar.hasMore()) {
                this.fSA.BI();
                this.fSP.setHasMoreData(true);
            } else {
                this.fSA.BJ();
                this.fSP.setHasMoreData(false);
            }
            this.fSH = jVar.bcu();
            if (this.fSH == null || this.fSH.size() <= fSl) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.fSH.size() - fSl;
                rw(size);
                int firstVisiblePosition = this.mListView.getFirstVisiblePosition() - size;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.fSH);
            if (v.z(this.fSH)) {
                this.mListView.setNextPage(null);
                if (this.aPR) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.mListView.setNextPage(this.fSA);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(jVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.aPR) {
                arrayList.add(0, jVar.bcq());
            }
            this.fSP.a(this.fQO.UT(), arrayList);
            a(jVar.bcq(), jVar.aOZ(), jVar.sR(), i, z);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void rw(int i) {
        if (this.fSH != null) {
            if (this.fSH.size() <= i) {
                this.fSH.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.fSH.iterator();
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

    public boolean bhX() {
        return this.fSP.aiH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.aPR) {
            this.fAX = postData;
            if (!StringUtils.isNull(postData.byT())) {
                this.fSx.setVisibility(0);
                this.fSx.startLoad(postData.byT(), 10, true);
            } else {
                this.fSx.setVisibility(8);
            }
            h byV = postData.byV();
            if (byV != null && byV.gVh) {
                this.fSy.setVisibility(0);
            } else {
                this.fSy.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.fSm.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.fSm.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.fSu.setText((CharSequence) null);
            this.aBX.setText((CharSequence) null);
            this.fMp.setVisibility(8);
            if (!this.aPR) {
                c(postData.wm());
                if (z) {
                    this.fMp.setVisibility(0);
                    al.h(this.fMp, e.d.cp_link_tip_a);
                }
            }
            this.fSv.setText(ao.A(postData.getTime()));
            this.fSu.setText(String.format(this.fSn.getPageContext().getString(e.j.is_floor), Integer.valueOf(postData.byM())));
            postData.wm().getUserTbVipInfoData();
            boolean a = a(this.fSw, postData.byO());
            if (StringUtils.isNull(postData.byT()) && !a && postData.OX() != null) {
                this.cEQ.setVisibility(0);
                this.cEQ.setTag(postData.OX());
                return;
            }
            this.cEQ.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.bA(metaData.getSealPrefix()) + 2 : 0) + com.baidu.tbadk.util.y.m16if(name_show) > 14) {
                name_show = com.baidu.tbadk.util.y.o(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.aBX.setText(ap(metaData.getSealPrefix(), name_show));
            } else {
                this.aBX.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.fSs != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.fSs.setVisibility(8);
                } else {
                    this.fSs.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.acu = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.fSs.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.fMx.setVisibility(0);
                this.fSr.setVisibility(8);
                this.fMx.setUserId(metaData.getUserId());
                this.fMx.setUserName(metaData.getUserName());
                this.fMx.startLoad(metaData.getPortrait(), 28, false);
                al.h(this.aBX, e.d.cp_cont_r);
            } else {
                this.fMx.setVisibility(8);
                this.fSr.setVisibility(0);
                this.fSr.setUserId(metaData.getUserId());
                this.fSr.setUserName(metaData.getUserName());
                this.fSr.setDefaultResource(e.f.transparent_bg);
                this.fSr.setDefaultErrorResource(e.f.icon_default_avatar100);
                this.fSr.startLoad(metaData.getPortrait(), 28, false);
                al.h(this.aBX, e.d.cp_cont_c);
            }
            this.fSq.setTag(e.g.tag_user_id, metaData.getUserId());
            this.fSq.setTag(e.g.tag_user_name, metaData.getUserName());
            this.fSq.setTag(e.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.OP() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.OP().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.OW());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.cA(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.bHk());
                        continue;
                    case 17:
                        String str = next.Pa().mGifInfo.mSharpText;
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
        if (!tbRichTextData.Pf()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.OW() == null || tbRichTextData.OW().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.OW());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fSn.getPageContext().getString(e.j.refresh_view_title_text), this.adI));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.fSn.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.fSo, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, e.f.pic_emotion07, l.h(pageActivity, e.C0141e.ds250), l.h(pageActivity, e.C0141e.ds480), l.h(pageActivity, e.C0141e.ds360)), dVar, a);
        }
        this.fSo.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.ePv.JF();
        al.j(this.mNoDataView, e.d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.fSn.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void iR(int i) {
        b(NoDataViewFactory.d.G(i, e.j.refresh_view_title_text));
        if (this.fSf != null) {
            this.fSf.bD(this.bVs);
        }
        this.fSJ.setVisibility(8);
    }

    public void nk(String str) {
        b(NoDataViewFactory.d.ao(str, this.fSn.getPageContext().getString(e.j.refresh_view_title_text)));
        if (this.fSf != null) {
            this.fSf.bD(this.bVs);
        }
        this.fSJ.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            this.fSJ.setVisibility(0);
            this.bVs.setOnTouchListener(null);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.adI = onClickListener;
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
                String userId2 = postData.wm().getUserId();
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
            if (this.fQO != null && this.fQO.UT() != null && this.fQO.UT().wm() != null && postData.wm() != null) {
                String userId3 = this.fQO.UT().wm().getUserId();
                String userId4 = postData.wm().getUserId();
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
                    userId = postData.wm().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.byM() != 1 ? 0 : 1;
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
                        if (postData.wm() != null) {
                            sparseArray.put(e.g.tag_forbid_user_name, postData.wm().getUserName());
                            sparseArray.put(e.g.tag_forbid_user_name_show, postData.wm().getName_show());
                            sparseArray.put(e.g.tag_forbid_user_portrait, postData.wm().getPortrait());
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
                        if (postData.wm() != null) {
                            sparseArray.put(e.g.tag_forbid_user_name, postData.wm().getUserName());
                            sparseArray.put(e.g.tag_forbid_user_name_show, postData.wm().getName_show());
                            sparseArray.put(e.g.tag_forbid_user_portrait, postData.wm().getPortrait());
                        }
                    } else {
                        sparseArray.put(e.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(e.g.tag_user_mute_visible, true);
                        sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.wm() != null) {
                            sparseArray.put(e.g.tag_user_mute_mute_userid, postData.wm().getUserId());
                            sparseArray.put(e.g.tag_user_mute_mute_username, postData.wm().getUserName());
                            sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.wm().getName_show());
                        }
                        if (this.fQO.UT() != null) {
                            sparseArray.put(e.g.tag_user_mute_thread_id, this.fQO.UT().getId());
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
            userId = postData.wm().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.byM() != 1) {
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

    public void lh(boolean z) {
        if (this.fDm != null && this.fDm.bfp() != null) {
            if (z) {
                this.fDm.bfp().setText(e.j.remove_mark);
            } else {
                this.fDm.bfp().setText(e.j.mark);
            }
            this.fDm.refreshUI();
        }
    }

    public View bhY() {
        return this.fSD;
    }

    public void onChangeSkinType(int i) {
        this.fSn.getLayoutMode().setNightMode(i == 1);
        this.fSn.getLayoutMode().onModeChanged(this.bVs);
        this.fSn.getLayoutMode().onModeChanged(this.fSm);
        this.mNavigationBar.onChangeSkinType(this.fSn.getPageContext(), i);
        if (this.fSp != null) {
            al.h(this.fSp, e.d.goto_see_subject_color);
        }
        this.dom.onChangeSkinType(this.fSn.getPageContext(), i);
        this.fSn.getLayoutMode().onModeChanged(this.fSD);
        al.h(this.fSw, e.d.cp_cont_b);
        this.fSw.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
        if (this.ePv != null && this.ePv.IJ() != null) {
            this.ePv.IJ().onChangeSkinType(i);
        }
        this.fSA.dM(i);
        this.cEQ.aRD();
        al.h(this.dHu, e.d.cp_cont_e);
        al.h(this.fMp, e.d.cp_link_tip_a);
        al.h(this.aBX, e.d.cp_cont_c);
        this.dHu.setAlpha(0.95f);
        if (this.fNe != null) {
            com.baidu.tbadk.o.a.a(this.fSn.getPageContext(), this.fNe);
        }
        if (this.fSP != null) {
            this.fSP.notifyDataSetChanged();
        }
    }

    public void bhZ() {
        this.mProgress.setVisibility(0);
    }

    public void bia() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fSA.BJ();
    }

    public void asz() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fSA.asz();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aMC = onLongClickListener;
        this.fSP.c(onLongClickListener);
    }

    public View bib() {
        return this.fSm;
    }

    public TextView aAO() {
        return this.dHu;
    }

    public ImageView bic() {
        return this.fSK;
    }

    public ImageView bid() {
        return this.fSL;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void rx(int i) {
    }

    public View bie() {
        return this.fSp;
    }

    public View bif() {
        return this.fSx;
    }

    public MorePopupWindow big() {
        return this.fSB;
    }

    public void showLoadingDialog() {
        if (this.cOv == null) {
            this.cOv = new com.baidu.tbadk.core.view.d(this.fSn.getPageContext());
        }
        this.cOv.aZ(true);
    }

    public void agD() {
        if (this.cOv != null) {
            this.cOv.aZ(false);
        }
    }

    public TextView bih() {
        return this.fSw;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.fRV = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fSP.setOnImageClickListener(hVar);
    }

    public void notifyDataSetChanged() {
        if (this.fSP != null) {
            this.fSP.notifyDataSetChanged();
        }
    }

    public y bii() {
        return this.fDm;
    }

    public void azA() {
    }

    public void azB() {
    }

    public void onActivityDestroy() {
    }

    public void bij() {
        if (this.fSn.isPaused()) {
        }
    }

    public View bik() {
        return this.fSq;
    }

    private SpannableStringBuilder ap(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, e.f.pic_smalldot_title));
            return o.a((Context) this.fSn.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
