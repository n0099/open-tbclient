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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
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
    private static final int fKN = TbadkCoreApplication.getInst().getListItemRule().Cn();
    private BdListView LO;
    private RelativeLayout bPE;
    private com.baidu.tbadk.core.view.a cIH;
    private View cYM;
    private TextView dAN;
    private TextView dAO;
    private e dKo;
    private NoNetworkView div;
    private k fJp;
    private a fKH;
    private View fKO;
    private c fKP;
    private NewSubPbActivity fKQ;
    private RelativeLayout fKR;
    private View fKV;
    private SubPbModel fKt;
    private ThreadSkinView fLc;
    private d fLd;
    private View fLg;
    private ArrayList<PostData> fLk;
    private String fLl;
    private RelativeLayout fLm;
    private ImageView fLn;
    private ImageView fLo;
    private y fvB;
    private View.OnClickListener mCommonClickListener;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private TbRichTextView.h fKy = null;
    private View.OnClickListener abe = null;
    private TbRichTextView.i fKx = null;
    private NavigationBar mNavigationBar = null;
    private View aAZ = null;
    private TextView fKS = null;
    private LinearLayout fKT = null;
    private HeadImageView fKU = null;
    private ClickableHeaderImageView fFf = null;
    private TextView ayY = null;
    private ImageView fKW = null;
    private TextView fEX = null;
    private TextView fKX = null;
    private TextView fKY = null;
    private EllipsizeRichTextView fKZ = null;
    private TbImageView fLa = null;
    private PlayVoiceBntNew czb = null;
    private TextView fLb = null;
    private MorePopupWindow fLe = null;
    private am fLf = null;
    private com.baidu.tbadk.core.dialog.b fFO = null;
    private Dialog fFD = null;
    private com.baidu.tbadk.core.dialog.a fFF = null;
    private boolean fxJ = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener aJp = null;
    private NewSubPbActivity.a fLh = null;
    private NewSubPbActivity.a fLi = null;
    private g eIk = null;
    private String fLj = null;
    private int bfg = 0;
    private PostData ftv = null;
    private int fLp = 0;
    private int fLq = 2;
    private int fLr = 0;
    private boolean aMC = true;
    private View.OnClickListener fxR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
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
                        b.this.fKQ.b(sparseArray);
                        return;
                    }
                    b.this.bl(view);
                } else if (booleanValue2) {
                    sparseArray.put(d.g.tag_from, 0);
                    b.this.fKQ.b(sparseArray);
                } else if (booleanValue3) {
                    b.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c bge = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.b.3
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            b.this.gd(false);
            b.this.aA(view);
            b.this.gd(true);
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
    protected AdapterView.OnItemClickListener fLs = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ba.aV(b.this.fKQ.getPageContext().getPageActivity())) {
                if (b.this.fKQ.eIc == null || b.this.fKt == null || b.this.fKt.Ce() == null || b.this.fKQ.eIc.cP(b.this.fKt.Ce().replyPrivateFlag)) {
                    if (b.this.fKH != null) {
                        b.this.fKH.ayn();
                    }
                    b.this.bfu();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) w.d(b.this.fLk, i);
                        if (postData == null) {
                            b.this.fLl = null;
                        } else {
                            b.this.fLl = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(d.g.tag_photo_username);
                            String str2 = (String) sparseArray.get(d.g.tag_photo_userid);
                            if (str != null) {
                                b.this.eIk.setReplyId(str2);
                                b.this.eIk.gV(str);
                            }
                        }
                        b.this.bfv();
                        return;
                    }
                    b.this.bfw();
                    b.this.fKt.bfR();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.bPE = null;
        this.fKO = null;
        this.LO = null;
        this.fKP = null;
        this.fKQ = null;
        this.div = null;
        this.fKR = null;
        this.dAO = null;
        this.fKV = null;
        this.fLd = null;
        this.fLg = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.dAN = null;
        this.fLm = null;
        this.fLn = null;
        this.fLo = null;
        this.fKQ = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.bPE = (RelativeLayout) LayoutInflater.from(this.fKQ.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_layout, (ViewGroup) null);
        this.fKO = LayoutInflater.from(this.fKQ.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_head, (ViewGroup) null);
        this.dAO = (TextView) this.bPE.findViewById(d.g.no_reply_list_view);
        this.fLm = (RelativeLayout) this.bPE.findViewById(d.g.subpb_editor_tool_comment);
        this.dAN = (TextView) this.bPE.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.dAN.setOnClickListener(this.mCommonClickListener);
        this.fLn = (ImageView) this.bPE.findViewById(d.g.subpb_editor_tool_more_img);
        this.fLo = (ImageView) this.bPE.findViewById(d.g.subpb_editor_tool_emotion_img);
        this.fLo.setOnClickListener(this.mCommonClickListener);
        this.fLn.setOnClickListener(this.mCommonClickListener);
        this.div = (NoNetworkView) this.bPE.findViewById(d.g.view_no_network);
        ayv();
        asn();
        this.fKR = (RelativeLayout) this.bPE.findViewById(d.g.sub_pb_body_layout);
        this.LO = (BdListView) this.bPE.findViewById(d.g.new_sub_pb_list);
        this.fLc = (ThreadSkinView) LayoutInflater.from(this.fKQ.getPageContext().getPageActivity()).inflate(d.h.thread_skin_layout, (ViewGroup) null);
        this.LO.addHeaderView(this.fLc);
        this.LO.addHeaderView(this.fKO);
        this.cYM = BdListViewHelper.a(this.fKQ.getActivity(), this.LO, BdListViewHelper.HeadType.DEFAULT);
        this.fKP = new c(this.fKQ.getPageContext().getPageActivity());
        this.fKP.K(this.fxR);
        this.fKP.setIsFromCDN(this.mIsFromCDN);
        this.fKP.kK(true);
        this.LO.setAdapter((ListAdapter) this.fKP);
        this.fLd = new d(this.fKQ.getPageContext());
        this.fLg = this.fLd.getView();
        this.LO.setNextPage(this.fLd);
        this.fLd.setOnClickListener(this.mCommonClickListener);
        this.LO.setOnItemClickListener(this.fLs);
        this.LO.setOnTouchListener(this.bge);
        this.mProgress = (ProgressBar) this.bPE.findViewById(d.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fKO != null) {
            this.fKO.setVisibility(4);
        }
        if (this.fKR != null) {
            this.fKR.setVisibility(4);
        }
        this.fKV = com.baidu.tbadk.ala.b.rx().g(this.fKQ.getActivity(), 4);
        if (this.fKV != null) {
            this.fKV.setVisibility(8);
            this.fKT.addView(this.fKV, 3);
        }
    }

    public ListView getListView() {
        return this.LO;
    }

    public void asn() {
        this.fKT = (LinearLayout) this.fKO.findViewById(d.g.subpb_head_user_info_root);
        this.fKT.setOnClickListener(this.mCommonClickListener);
        this.fKU = (HeadImageView) this.fKO.findViewById(d.g.photo);
        this.fKU.setRadius(l.f(this.fKQ.getActivity(), d.e.ds30));
        this.fKU.setClickable(false);
        this.fFf = (ClickableHeaderImageView) this.fKO.findViewById(d.g.god_user_photo);
        this.fFf.setGodIconMargin(0);
        this.fFf.setGodIconWidth(d.e.ds24);
        this.fFf.setRadius(l.f(this.fKQ.getActivity(), d.e.ds30));
        this.fFf.setClickable(false);
        this.ayY = (TextView) this.fKO.findViewById(d.g.user_name);
        this.fKW = (ImageView) this.fKO.findViewById(d.g.user_rank);
        this.fKW.setVisibility(8);
        this.fEX = (TextView) this.fKO.findViewById(d.g.floor_owner);
        this.fKS = (TextView) this.fKO.findViewById(d.g.see_subject);
        this.fKS.setOnClickListener(this.mCommonClickListener);
        this.fKX = (TextView) this.fKO.findViewById(d.g.floor);
        this.fKY = (TextView) this.fKO.findViewById(d.g.time);
        this.fKZ = (EllipsizeRichTextView) this.fKO.findViewById(d.g.content_text);
        this.fKZ.setOnClickListener(this.mCommonClickListener);
        com.baidu.tbadk.core.util.am.h(this.fKZ, d.C0140d.cp_cont_b);
        this.fKZ.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(d.C0140d.cp_link_tip_c));
        this.fKZ.setLineSpacing(0.0f, 1.25f);
        this.fLa = (TbImageView) this.fKO.findViewById(d.g.sub_pb_image);
        this.fLa.setOnClickListener(this.mCommonClickListener);
        this.fLb = (TextView) this.fKO.findViewById(d.g.advert);
        this.czb = (PlayVoiceBntNew) this.fKO.findViewById(d.g.voice_btn);
        this.fKO.setOnTouchListener(this.bge);
        this.fKO.setOnClickListener(this.mCommonClickListener);
    }

    public void gf(boolean z) {
        if (this.cYM != null && this.cYM.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cYM.getLayoutParams();
            if (z) {
                ayz();
                layoutParams.height = l.f(this.fKQ.getPageContext().getPageActivity(), d.e.ds88);
            } else {
                layoutParams.height = l.f(this.fKQ.getPageContext().getPageActivity(), d.e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.cYM.setLayoutParams(layoutParams);
        }
    }

    private void ayz() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public View ayA() {
        return this.cYM;
    }

    public void ayv() {
        int f = l.f(this.fKQ.getPageContext().getPageActivity(), d.e.ds88);
        int f2 = l.f(this.fKQ.getPageContext().getPageActivity(), d.e.ds14);
        this.mNavigationBar = (NavigationBar) this.bPE.findViewById(d.g.view_navigation_bar);
        this.aAZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aAZ.getLayoutParams();
            layoutParams.height = f;
            layoutParams.width = f;
            layoutParams.leftMargin = f2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aAZ != null && (this.aAZ.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aAZ.getLayoutParams();
            layoutParams2.width = f;
            layoutParams2.height = f;
            this.aAZ.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar Vf() {
        return this.mNavigationBar;
    }

    public void bl(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.fFD == null) {
            this.fFD = new Dialog(this.fKQ.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fFD.setCanceledOnTouchOutside(true);
            this.fFD.setCancelable(true);
            View inflate = LayoutInflater.from(this.fKQ.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
            this.fKQ.getLayoutMode().onModeChanged(inflate);
            this.fFD.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.fFD.getWindow().getAttributes();
            attributes.width = (int) (l.ah(this.fKQ.getPageContext().getPageActivity()) * 0.9d);
            this.fFD.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fFD.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fFD.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fFD.findViewById(d.g.disable_reply_btn);
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
                    if (b.this.fFD != null && (b.this.fFD instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fFD, b.this.fKQ.getPageContext());
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
                    if (b.this.fFD != null && (b.this.fFD instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fFD, b.this.fKQ.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.fLh != null) {
                        b.this.fLh.i(new Object[]{sparseArray4.get(d.g.tag_manage_user_identity), sparseArray4.get(d.g.tag_forbid_user_name), sparseArray4.get(d.g.tag_forbid_user_post_id), sparseArray4.get(d.g.tag_forbid_user_name_show), sparseArray4.get(d.g.tag_forbid_user_portrait)});
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
                textView3.setText(d.j.un_mute);
            } else {
                textView3.setText(d.j.mute);
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
                    if (b.this.fFD != null && (b.this.fFD instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fFD, b.this.fKQ.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.fKQ.a(z, (String) sparseArray5.get(d.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fFD, this.fKQ.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        final SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(d.g.tag_del_post_id, str);
        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = d.j.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = d.j.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = d.j.report_thread_confirm;
            } else {
                i3 = d.j.del_thread_confirm;
            }
        }
        this.fFF = new com.baidu.tbadk.core.dialog.a(this.fKQ.getPageContext().getPageActivity());
        this.fFF.cf(i3);
        this.fFF.C(sparseArray);
        this.fFF.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.fLi != null) {
                    b.this.fLi.i(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.fFF.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fFF.au(true);
        this.fFF.b(this.fKQ.getPageContext());
        if (z) {
            this.fFF.xf();
        } else {
            d(sparseArray);
        }
    }

    private void d(final SparseArray<Object> sparseArray) {
        AntiData Ce;
        if (this.fKQ != null && sparseArray != null && this.fKO != null) {
            if (this.dKo == null) {
                this.dKo = new e(this.fKQ.getPageContext(), this.fKO);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.fKt != null && (Ce = this.fKt.Ce()) != null && Ce.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = Ce.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray2);
            this.dKo.setDefaultReasonArray(new String[]{this.fKQ.getString(d.j.delete_thread_reason_1), this.fKQ.getString(d.j.delete_thread_reason_2), this.fKQ.getString(d.j.delete_thread_reason_3), this.fKQ.getString(d.j.delete_thread_reason_4), this.fKQ.getString(d.j.delete_thread_reason_5)});
            this.dKo.setData(ahVar);
            this.dKo.hY("4");
            this.dKo.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.b.9
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void f(JSONArray jSONArray) {
                    String d = ap.d(jSONArray);
                    if (b.this.fLi != null) {
                        b.this.fLi.i(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type), d});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gd(final boolean z) {
        if (this.LO != null) {
            if (!z) {
                this.LO.setEnabled(z);
            } else {
                this.LO.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.b.10
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.LO.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void b(b.InterfaceC0101b interfaceC0101b, boolean z) {
        String string;
        if (this.fFO != null) {
            this.fFO.dismiss();
            this.fFO = null;
        }
        if (z) {
            string = this.fKQ.getResources().getString(d.j.remove_mark);
        } else {
            string = this.fKQ.getResources().getString(d.j.mark);
        }
        this.fFO = new com.baidu.tbadk.core.dialog.b(this.fKQ.getPageContext().getPageActivity());
        this.fFO.ci(d.j.operation);
        this.fFO.a(new String[]{this.fKQ.getResources().getString(d.j.copy), string}, interfaceC0101b);
        this.fFO.d(this.fKQ.getPageContext());
        this.fFO.xi();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.fLh = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.fLi = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.fKQ.showToast(this.fKQ.getResources().getString(d.j.delete_success));
        } else if (str != null && z2) {
            this.fKQ.showToast(str);
        }
    }

    public void aA(View view) {
        if (this.cYM != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cYM.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.LO != null) {
                    this.LO.removeHeaderView(this.cYM);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.cYM.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.f(this.fKQ.getActivity(), d.e.ds98)));
            } else if (this.LO != null) {
                this.LO.addHeaderView(this.cYM, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.Ht() != null) {
            this.eIk = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bPE.addView(gVar.Ht(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.fKH = aVar;
    }

    public void bfu() {
        if (this.LO != null) {
            this.fLr = this.LO.getLastVisiblePosition();
        }
    }

    public void bfv() {
        if (this.fKt != null) {
            if ((!bfy() && this.fLg != null && this.fLg.isShown()) || w.z(this.fLk)) {
                this.fKt.kN(false);
            } else {
                this.fKt.kN(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.fKt = subPbModel;
    }

    public void bfw() {
        a(this.fKQ);
        this.LO.setNextPage(this.fLd);
    }

    public void m(PostData postData) {
        int i;
        if (postData != null) {
            postData.ms(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bfy() && this.fLg != null && this.fLg.isShown()) {
                i = (this.fLr - this.fLq) - 1;
            } else {
                i = this.fLr - this.fLq;
            }
            int y = w.y(this.fLk);
            if (i > y) {
                i = y;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(w.a(this.fLk, 0, i));
            w.b(arrayList, postData2);
            w.b(arrayList, postData);
            this.fKP.setDatas(arrayList);
            this.fKP.notifyDataSetChanged();
            this.LO.smoothScrollToPosition(this.fLr + 2);
            this.LO.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.LO.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.LO.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.bPE;
    }

    public void beq() {
        if (this.fLe != null) {
            com.baidu.adp.lib.g.g.a(this.fLe, this.fKQ.getPageContext().getPageActivity());
        }
        if (this.fFO != null) {
            this.fFO.dismiss();
        }
        if (this.fFF != null) {
            this.fFF.dismiss();
        }
        if (this.fFD != null) {
            com.baidu.adp.lib.g.g.b(this.fFD, this.fKQ.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.fvB != null) {
            this.fvB.dismiss();
        }
    }

    public void bfx() {
        this.LO.setNextPage(this.fLd);
        this.fLd.Ax();
    }

    public void jt(boolean z) {
        this.fxJ = z;
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
            if (this.aMC && this.fKO != null) {
                this.fKP.kL(true);
                this.fKO.setVisibility(8);
                this.LO.removeHeaderView(this.fKO);
                this.fLq = 1;
            }
            this.fJp = kVar;
            this.fKP.Z(this.fJp.Td());
            if (this.fKO != null) {
                this.fKO.setVisibility(0);
            }
            if (this.fKR != null) {
                this.fKR.setVisibility(0);
            }
            if (kVar.aZZ() != null) {
                this.fLj = kVar.aZZ().getId();
                this.bfg = kVar.aZZ().bwf();
                if (this.bfg > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.fKQ.getResources().getString(d.j.subpb_floor_reply_count), ap.F(kVar.getTotalCount())));
                    this.dAN.setText(d.j.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.fKQ.bft()) {
                    str = "PB";
                }
                if (kVar.aZZ().vF() != null) {
                    this.fLc.setData(this.fKQ.getPageContext(), kVar.aZZ().vF(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", kVar.bag().getId(), kVar.bag().getName(), kVar.Td().getId(), str));
                } else {
                    this.fLc.setData(null, null, null);
                }
            }
            if (kVar.hasMore()) {
                this.fLd.Ax();
                this.fKP.setHasMoreData(true);
            } else {
                this.fLd.Ay();
                this.fKP.setHasMoreData(false);
            }
            this.fLk = kVar.bad();
            if (w.z(this.fLk)) {
                this.LO.setNextPage(null);
                if (this.aMC) {
                    this.dAO.setVisibility(0);
                }
            } else {
                this.LO.setNextPage(this.fLd);
                if (this.aMC) {
                    this.dAO.setVisibility(8);
                }
            }
            if (this.fLk == null || this.fLk.size() <= fKN) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.fLk.size() - fKN;
                qW(size);
                int firstVisiblePosition = this.LO.getFirstVisiblePosition() - size;
                View childAt = this.LO.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.fKP.setDatas(this.fLk);
            boolean z2 = false;
            if (kVar.Td() != null && kVar.Td().vk() != null && (userId = kVar.Td().vk().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.fKP.A(i, z2);
            this.fKP.notifyDataSetChanged();
            a(kVar.aZZ(), kVar.aMN(), kVar.rN(), i, z);
            if (i4 > 0) {
                this.LO.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void qW(int i) {
        if (this.fLk != null) {
            if (this.fLk.size() <= i) {
                this.fLk.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.fLk.iterator();
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

    public boolean bfy() {
        return this.fKP.cHN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.aMC) {
            this.ftv = postData;
            if (!StringUtils.isNull(postData.bwm())) {
                this.fLa.setVisibility(0);
                this.fLa.startLoad(postData.bwm(), 10, true);
            } else {
                this.fLa.setVisibility(8);
            }
            h bwo = postData.bwo();
            if (bwo != null && bwo.gNB) {
                this.fLb.setVisibility(0);
            } else {
                this.fLb.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.fKO.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.fKO.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.fKX.setText((CharSequence) null);
            this.ayY.setText((CharSequence) null);
            this.fEX.setVisibility(8);
            if (!this.aMC) {
                c(postData.vk());
                if (z) {
                    this.fEX.setVisibility(0);
                    com.baidu.tbadk.core.util.am.h(this.fEX, d.C0140d.cp_link_tip_a);
                }
            }
            this.fKY.setText(ap.w(postData.getTime()));
            this.fKX.setText(String.format(this.fKQ.getPageContext().getString(d.j.is_floor), Integer.valueOf(postData.bwf())));
            postData.vk().getUserTbVipInfoData();
            boolean a = a(this.fKZ, postData.bwh());
            if (StringUtils.isNull(postData.bwm()) && !a && postData.NF() != null) {
                this.czb.setVisibility(0);
                this.czb.setTag(postData.NF());
                return;
            }
            this.czb.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.k.bj(metaData.getSealPrefix()) + 2 : 0) + com.baidu.tbadk.util.w.hH(name_show) > 14) {
                name_show = com.baidu.tbadk.util.w.k(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.ayY.setText(ai(metaData.getSealPrefix(), name_show));
            } else {
                this.ayY.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.fKV != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.fKV.setVisibility(8);
                } else {
                    this.fKV.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.ZR = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.fKV.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.fFf.setVisibility(0);
                this.fKU.setVisibility(8);
                this.fFf.setUserId(metaData.getUserId());
                this.fFf.setUserName(metaData.getUserName());
                this.fFf.startLoad(metaData.getPortrait(), 28, false);
                com.baidu.tbadk.core.util.am.h(this.ayY, d.C0140d.cp_cont_r);
            } else {
                this.fFf.setVisibility(8);
                this.fKU.setVisibility(0);
                this.fKU.setUserId(metaData.getUserId());
                this.fKU.setUserName(metaData.getUserName());
                this.fKU.setDefaultResource(d.f.transparent_bg);
                this.fKU.setDefaultErrorResource(d.f.icon_default_avatar100);
                this.fKU.startLoad(metaData.getPortrait(), 28, false);
                com.baidu.tbadk.core.util.am.h(this.ayY, d.C0140d.cp_cont_c);
            }
            this.fKT.setTag(d.g.tag_user_id, metaData.getUserId());
            this.fKT.setTag(d.g.tag_user_name, metaData.getUserName());
            this.fKT.setTag(d.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.Nx() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.Nx().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.NE());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.cn(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.bEr());
                        continue;
                    case 17:
                        String str = next.NI().mGifInfo.mSharpText;
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
        if (!tbRichTextData.NN()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.NE() == null || tbRichTextData.NE().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.NE());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fKQ.getPageContext().getString(d.j.refresh_view_title_text), this.abe));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.fKQ.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.fKR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.f.pic_emotion07, l.f(pageActivity, d.e.ds250), l.f(pageActivity, d.e.ds480), l.f(pageActivity, d.e.ds360)), dVar, a);
        }
        this.fKR.setVisibility(0);
        this.LO.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.eIk.Ip();
        com.baidu.tbadk.core.util.am.j(this.mNoDataView, d.C0140d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.fKQ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void it(int i) {
        b(NoDataViewFactory.d.E(i, d.j.refresh_view_title_text));
        if (this.fKH != null) {
            this.fKH.bo(this.bPE);
        }
        this.fLm.setVisibility(8);
    }

    public void mF(String str) {
        b(NoDataViewFactory.d.ah(str, this.fKQ.getPageContext().getString(d.j.refresh_view_title_text)));
        if (this.fKH != null) {
            this.fKH.bo(this.bPE);
        }
        this.fLm.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.LO.setVisibility(0);
            this.fLm.setVisibility(0);
            this.bPE.setOnTouchListener(null);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.abe = onClickListener;
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
                String userId2 = postData.vk().getUserId();
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
            if (this.fJp != null && this.fJp.Td() != null && this.fJp.Td().vk() != null && postData.vk() != null) {
                String userId3 = this.fJp.Td().vk().getUserId();
                String userId4 = postData.vk().getUserId();
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
                    userId = postData.vk().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.bwf() != 1 ? 0 : 1;
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
                        if (postData.vk() != null) {
                            sparseArray.put(d.g.tag_forbid_user_name, postData.vk().getUserName());
                            sparseArray.put(d.g.tag_forbid_user_name_show, postData.vk().getName_show());
                            sparseArray.put(d.g.tag_forbid_user_portrait, postData.vk().getPortrait());
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
                        if (postData.vk() != null) {
                            sparseArray.put(d.g.tag_forbid_user_name, postData.vk().getUserName());
                            sparseArray.put(d.g.tag_forbid_user_name_show, postData.vk().getName_show());
                            sparseArray.put(d.g.tag_forbid_user_portrait, postData.vk().getPortrait());
                        }
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.vk() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.vk().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.vk().getUserName());
                            sparseArray.put(d.g.tag_user_mute_mute_nameshow, postData.vk().getName_show());
                        }
                        if (this.fJp.Td() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fJp.Td().getId());
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
            userId = postData.vk().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.bwf() != 1) {
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

    public void kJ(boolean z) {
        if (this.fvB != null && this.fvB.bcU() != null) {
            if (z) {
                this.fvB.bcU().setText(d.j.remove_mark);
            } else {
                this.fvB.bcU().setText(d.j.mark);
            }
            this.fvB.refreshUI();
        }
    }

    public View bfz() {
        return this.fLg;
    }

    public void onChangeSkinType(int i) {
        this.fKQ.getLayoutMode().setNightMode(i == 1);
        this.fKQ.getLayoutMode().onModeChanged(this.bPE);
        this.fKQ.getLayoutMode().onModeChanged(this.fKO);
        this.mNavigationBar.onChangeSkinType(this.fKQ.getPageContext(), i);
        if (this.fKS != null) {
            com.baidu.tbadk.core.util.am.h(this.fKS, d.C0140d.goto_see_subject_color);
        }
        com.baidu.tbadk.core.util.am.h(this.dAO, d.C0140d.cp_cont_d);
        this.div.onChangeSkinType(this.fKQ.getPageContext(), i);
        this.fKQ.getLayoutMode().onModeChanged(this.fLg);
        com.baidu.tbadk.core.util.am.h(this.fKZ, d.C0140d.cp_cont_b);
        this.fKZ.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(d.C0140d.cp_link_tip_c));
        if (this.eIk != null && this.eIk.Ht() != null) {
            this.eIk.Ht().onChangeSkinType(i);
        }
        this.fLd.dC(i);
        this.czb.aPt();
        com.baidu.tbadk.core.util.am.h(this.dAN, d.C0140d.cp_cont_e);
        com.baidu.tbadk.core.util.am.h(this.fEX, d.C0140d.cp_link_tip_a);
        com.baidu.tbadk.core.util.am.h(this.ayY, d.C0140d.cp_cont_c);
        this.dAN.setAlpha(0.95f);
        if (this.fKP != null) {
            this.fKP.notifyDataSetChanged();
        }
    }

    public void bfA() {
        this.mProgress.setVisibility(0);
    }

    public void bfB() {
        this.LO.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fLd.Ay();
    }

    public void aqL() {
        this.LO.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fLd.aqL();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aJp = onLongClickListener;
        this.fKO.setOnLongClickListener(this.aJp);
    }

    public View bfC() {
        return this.fKO;
    }

    public TextView ayB() {
        return this.dAN;
    }

    public ImageView bfD() {
        return this.fLn;
    }

    public ImageView bfE() {
        return this.fLo;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void qX(int i) {
    }

    public void rA(String str) {
        int rB = this.fKP.rB(str);
        if (rB > -1) {
            this.fKP.qY(rB);
            if (rB > 2) {
                this.LO.setSelection(rB - 2);
            } else {
                this.LO.setSelection(rB);
            }
            this.LO.invalidate();
        }
    }

    public View bfF() {
        return this.fKS;
    }

    public View bfG() {
        return this.fLa;
    }

    public MorePopupWindow bfH() {
        return this.fLe;
    }

    public void showLoadingDialog() {
        if (this.cIH == null) {
            this.cIH = new com.baidu.tbadk.core.view.a(this.fKQ.getPageContext());
        }
        this.cIH.aM(true);
    }

    public void aeP() {
        if (this.cIH != null) {
            this.cIH.aM(false);
        }
    }

    public TextView bfI() {
        return this.fKZ;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.fKx = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fKy = hVar;
    }

    public y bfJ() {
        return this.fvB;
    }

    public void axo() {
    }

    public void axp() {
    }

    public void onActivityDestroy() {
    }

    public void bfK() {
        if (this.fKQ.isPaused()) {
        }
    }

    public View bfL() {
        return this.fKT;
    }

    private SpannableStringBuilder ai(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, d.f.pic_smalldot_title));
            return o.a((Context) this.fKQ.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
