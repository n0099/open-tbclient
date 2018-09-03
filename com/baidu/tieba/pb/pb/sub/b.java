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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.card.o;
import com.baidu.tieba.f;
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
    private static final int fKG = TbadkCoreApplication.getInst().getListItemRule().Ck();
    private BdListView LO;
    private RelativeLayout bPD;
    private com.baidu.tbadk.core.view.a cIE;
    private View cYI;
    private TextView dAK;
    private TextView dAL;
    private e dKk;
    private NoNetworkView dit;
    private k fJi;
    private a fKA;
    private View fKH;
    private c fKI;
    private NewSubPbActivity fKJ;
    private RelativeLayout fKK;
    private View fKO;
    private ThreadSkinView fKV;
    private d fKW;
    private View fKZ;
    private SubPbModel fKm;
    private ArrayList<PostData> fLd;
    private String fLe;
    private RelativeLayout fLf;
    private ImageView fLg;
    private ImageView fLh;
    private y fvu;
    private View.OnClickListener mCommonClickListener;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private TbRichTextView.h fKr = null;
    private View.OnClickListener abf = null;
    private TbRichTextView.i fKq = null;
    private NavigationBar mNavigationBar = null;
    private View aAW = null;
    private TextView fKL = null;
    private LinearLayout fKM = null;
    private HeadImageView fKN = null;
    private ClickableHeaderImageView fEY = null;
    private TextView ayV = null;
    private ImageView fKP = null;
    private TextView fEQ = null;
    private TextView fKQ = null;
    private TextView fKR = null;
    private EllipsizeRichTextView fKS = null;
    private TbImageView fKT = null;
    private PlayVoiceBntNew cyY = null;
    private TextView fKU = null;
    private MorePopupWindow fKX = null;
    private am fKY = null;
    private com.baidu.tbadk.core.dialog.b fFH = null;
    private Dialog fFw = null;
    private com.baidu.tbadk.core.dialog.a fFy = null;
    private boolean fxC = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener aJm = null;
    private NewSubPbActivity.a fLa = null;
    private NewSubPbActivity.a fLb = null;
    private g eIf = null;
    private String fLc = null;
    private int bfh = 0;
    private PostData fto = null;
    private int fLi = 0;
    private int fLj = 2;
    private int fLk = 0;
    private boolean aMz = true;
    private View.OnClickListener fxK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(f.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(f.g.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(f.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(f.g.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(f.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(f.g.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (booleanValue2) {
                        sparseArray.put(f.g.tag_from, 1);
                        b.this.fKJ.b(sparseArray);
                        return;
                    }
                    b.this.bl(view);
                } else if (booleanValue2) {
                    sparseArray.put(f.g.tag_from, 0);
                    b.this.fKJ.b(sparseArray);
                } else if (booleanValue3) {
                    b.this.a(((Integer) sparseArray.get(f.g.tag_del_post_type)).intValue(), (String) sparseArray.get(f.g.tag_del_post_id), ((Integer) sparseArray.get(f.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(f.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c bgf = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.b.3
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
    protected AdapterView.OnItemClickListener fLl = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (bb.aU(b.this.fKJ.getPageContext().getPageActivity())) {
                if (b.this.fKJ.eHX == null || b.this.fKm == null || b.this.fKm.Cb() == null || b.this.fKJ.eHX.cP(b.this.fKm.Cb().replyPrivateFlag)) {
                    if (b.this.fKA != null) {
                        b.this.fKA.ayl();
                    }
                    b.this.bfp();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) w.d(b.this.fLd, i);
                        if (postData == null) {
                            b.this.fLe = null;
                        } else {
                            b.this.fLe = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(f.g.tag_photo_username);
                            String str2 = (String) sparseArray.get(f.g.tag_photo_userid);
                            if (str != null) {
                                b.this.eIf.setReplyId(str2);
                                b.this.eIf.gV(str);
                            }
                        }
                        b.this.bfq();
                        return;
                    }
                    b.this.bfr();
                    b.this.fKm.bfM();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.bPD = null;
        this.fKH = null;
        this.LO = null;
        this.fKI = null;
        this.fKJ = null;
        this.dit = null;
        this.fKK = null;
        this.dAL = null;
        this.fKO = null;
        this.fKW = null;
        this.fKZ = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.dAK = null;
        this.fLf = null;
        this.fLg = null;
        this.fLh = null;
        this.fKJ = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.bPD = (RelativeLayout) LayoutInflater.from(this.fKJ.getPageContext().getPageActivity()).inflate(f.h.new_sub_pb_layout, (ViewGroup) null);
        this.fKH = LayoutInflater.from(this.fKJ.getPageContext().getPageActivity()).inflate(f.h.new_sub_pb_head, (ViewGroup) null);
        this.dAL = (TextView) this.bPD.findViewById(f.g.no_reply_list_view);
        this.fLf = (RelativeLayout) this.bPD.findViewById(f.g.subpb_editor_tool_comment);
        this.dAK = (TextView) this.bPD.findViewById(f.g.subpb_editor_tool_comment_reply_text);
        this.dAK.setOnClickListener(this.mCommonClickListener);
        this.fLg = (ImageView) this.bPD.findViewById(f.g.subpb_editor_tool_more_img);
        this.fLh = (ImageView) this.bPD.findViewById(f.g.subpb_editor_tool_emotion_img);
        this.fLh.setOnClickListener(this.mCommonClickListener);
        this.fLg.setOnClickListener(this.mCommonClickListener);
        this.dit = (NoNetworkView) this.bPD.findViewById(f.g.view_no_network);
        ayt();
        asn();
        this.fKK = (RelativeLayout) this.bPD.findViewById(f.g.sub_pb_body_layout);
        this.LO = (BdListView) this.bPD.findViewById(f.g.new_sub_pb_list);
        this.fKV = (ThreadSkinView) LayoutInflater.from(this.fKJ.getPageContext().getPageActivity()).inflate(f.h.thread_skin_layout, (ViewGroup) null);
        this.LO.addHeaderView(this.fKV);
        this.LO.addHeaderView(this.fKH);
        this.cYI = BdListViewHelper.a(this.fKJ.getActivity(), this.LO, BdListViewHelper.HeadType.DEFAULT);
        this.fKI = new c(this.fKJ.getPageContext().getPageActivity());
        this.fKI.K(this.fxK);
        this.fKI.setIsFromCDN(this.mIsFromCDN);
        this.fKI.kK(true);
        this.LO.setAdapter((ListAdapter) this.fKI);
        this.fKW = new d(this.fKJ.getPageContext());
        this.fKZ = this.fKW.getView();
        this.LO.setNextPage(this.fKW);
        this.fKW.setOnClickListener(this.mCommonClickListener);
        this.LO.setOnItemClickListener(this.fLl);
        this.LO.setOnTouchListener(this.bgf);
        this.mProgress = (ProgressBar) this.bPD.findViewById(f.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fKH != null) {
            this.fKH.setVisibility(4);
        }
        if (this.fKK != null) {
            this.fKK.setVisibility(4);
        }
        this.fKO = com.baidu.tbadk.ala.b.rv().g(this.fKJ.getActivity(), 4);
        if (this.fKO != null) {
            this.fKO.setVisibility(8);
            this.fKM.addView(this.fKO, 3);
        }
    }

    public ListView getListView() {
        return this.LO;
    }

    public void asn() {
        this.fKM = (LinearLayout) this.fKH.findViewById(f.g.subpb_head_user_info_root);
        this.fKM.setOnClickListener(this.mCommonClickListener);
        this.fKN = (HeadImageView) this.fKH.findViewById(f.g.photo);
        this.fKN.setRadius(l.f(this.fKJ.getActivity(), f.e.ds30));
        this.fKN.setClickable(false);
        this.fEY = (ClickableHeaderImageView) this.fKH.findViewById(f.g.god_user_photo);
        this.fEY.setGodIconMargin(0);
        this.fEY.setGodIconWidth(f.e.ds24);
        this.fEY.setRadius(l.f(this.fKJ.getActivity(), f.e.ds30));
        this.fEY.setClickable(false);
        this.ayV = (TextView) this.fKH.findViewById(f.g.user_name);
        this.fKP = (ImageView) this.fKH.findViewById(f.g.user_rank);
        this.fKP.setVisibility(8);
        this.fEQ = (TextView) this.fKH.findViewById(f.g.floor_owner);
        this.fKL = (TextView) this.fKH.findViewById(f.g.see_subject);
        this.fKL.setOnClickListener(this.mCommonClickListener);
        this.fKQ = (TextView) this.fKH.findViewById(f.g.floor);
        this.fKR = (TextView) this.fKH.findViewById(f.g.time);
        this.fKS = (EllipsizeRichTextView) this.fKH.findViewById(f.g.content_text);
        this.fKS.setOnClickListener(this.mCommonClickListener);
        com.baidu.tbadk.core.util.am.h(this.fKS, f.d.cp_cont_b);
        this.fKS.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(f.d.cp_link_tip_c));
        this.fKS.setLineSpacing(0.0f, 1.25f);
        this.fKT = (TbImageView) this.fKH.findViewById(f.g.sub_pb_image);
        this.fKT.setOnClickListener(this.mCommonClickListener);
        this.fKU = (TextView) this.fKH.findViewById(f.g.advert);
        this.cyY = (PlayVoiceBntNew) this.fKH.findViewById(f.g.voice_btn);
        this.fKH.setOnTouchListener(this.bgf);
        this.fKH.setOnClickListener(this.mCommonClickListener);
    }

    public void gf(boolean z) {
        if (this.cYI != null && this.cYI.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cYI.getLayoutParams();
            if (z) {
                ayx();
                layoutParams.height = l.f(this.fKJ.getPageContext().getPageActivity(), f.e.ds88);
            } else {
                layoutParams.height = l.f(this.fKJ.getPageContext().getPageActivity(), f.e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.cYI.setLayoutParams(layoutParams);
        }
    }

    private void ayx() {
        this.mNavigationBar.setmBackImageViewBg(f.C0146f.subpb_navigationbar_close, f.C0146f.subpb_navigationbar_close);
    }

    public View ayy() {
        return this.cYI;
    }

    public void ayt() {
        int f = l.f(this.fKJ.getPageContext().getPageActivity(), f.e.ds88);
        int f2 = l.f(this.fKJ.getPageContext().getPageActivity(), f.e.ds14);
        this.mNavigationBar = (NavigationBar) this.bPD.findViewById(f.g.view_navigation_bar);
        this.aAW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aAW.getLayoutParams();
            layoutParams.height = f;
            layoutParams.width = f;
            layoutParams.leftMargin = f2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aAW != null && (this.aAW.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aAW.getLayoutParams();
            layoutParams2.width = f;
            layoutParams2.height = f;
            this.aAW.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(f.C0146f.subpb_navigationbar_back, f.C0146f.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar Vj() {
        return this.mNavigationBar;
    }

    public void bl(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.fFw == null) {
            this.fFw = new Dialog(this.fKJ.getPageContext().getPageActivity(), f.k.common_alert_dialog);
            this.fFw.setCanceledOnTouchOutside(true);
            this.fFw.setCancelable(true);
            View inflate = LayoutInflater.from(this.fKJ.getPageContext().getPageActivity()).inflate(f.h.forum_manage_dialog, (ViewGroup) null);
            this.fKJ.getLayoutMode().onModeChanged(inflate);
            this.fFw.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.fFw.getWindow().getAttributes();
            attributes.width = (int) (l.ah(this.fKJ.getPageContext().getPageActivity()) * 0.9d);
            this.fFw.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fFw.findViewById(f.g.del_post_btn);
        TextView textView2 = (TextView) this.fFw.findViewById(f.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fFw.findViewById(f.g.disable_reply_btn);
        if ("".equals(sparseArray.get(f.g.tag_del_post_id))) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            sparseArray2.put(f.g.tag_del_post_id, sparseArray.get(f.g.tag_del_post_id));
            sparseArray2.put(f.g.tag_del_post_type, sparseArray.get(f.g.tag_del_post_type));
            sparseArray2.put(f.g.tag_del_post_is_self, sparseArray.get(f.g.tag_del_post_is_self));
            sparseArray2.put(f.g.tag_manage_user_identity, sparseArray.get(f.g.tag_manage_user_identity));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.fFw != null && (b.this.fFw instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fFw, b.this.fKJ.getPageContext());
                    }
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null) {
                        b.this.a(((Integer) sparseArray3.get(f.g.tag_del_post_type)).intValue(), (String) sparseArray3.get(f.g.tag_del_post_id), ((Integer) sparseArray3.get(f.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(f.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(f.g.tag_forbid_user_name)) && "".equals(sparseArray.get(f.g.tag_forbid_user_name_show))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(f.g.tag_forbid_user_name, sparseArray.get(f.g.tag_forbid_user_name));
            sparseArray3.put(f.g.tag_forbid_user_name_show, sparseArray.get(f.g.tag_forbid_user_name_show));
            sparseArray3.put(f.g.tag_forbid_user_portrait, sparseArray.get(f.g.tag_forbid_user_portrait));
            sparseArray3.put(f.g.tag_manage_user_identity, sparseArray.get(f.g.tag_manage_user_identity));
            sparseArray3.put(f.g.tag_forbid_user_post_id, sparseArray.get(f.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.fFw != null && (b.this.fFw instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fFw, b.this.fKJ.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.fLa != null) {
                        b.this.fLa.i(new Object[]{sparseArray4.get(f.g.tag_manage_user_identity), sparseArray4.get(f.g.tag_forbid_user_name), sparseArray4.get(f.g.tag_forbid_user_post_id), sparseArray4.get(f.g.tag_forbid_user_name_show), sparseArray4.get(f.g.tag_forbid_user_portrait)});
                    }
                }
            });
        }
        if (!((sparseArray.get(f.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(f.g.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(f.j.un_mute);
            } else {
                textView3.setText(f.j.mute);
            }
            sparseArray4.put(f.g.tag_is_mem, sparseArray.get(f.g.tag_is_mem));
            sparseArray4.put(f.g.tag_user_mute_mute_userid, sparseArray.get(f.g.tag_user_mute_mute_userid));
            sparseArray4.put(f.g.tag_user_mute_mute_username, sparseArray.get(f.g.tag_user_mute_mute_username));
            sparseArray4.put(f.g.tag_user_mute_post_id, sparseArray.get(f.g.tag_user_mute_post_id));
            sparseArray4.put(f.g.tag_user_mute_thread_id, sparseArray.get(f.g.tag_user_mute_thread_id));
            sparseArray4.put(f.g.tag_user_mute_mute_nameshow, sparseArray.get(f.g.tag_user_mute_mute_nameshow));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.fFw != null && (b.this.fFw instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fFw, b.this.fKJ.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.fKJ.a(z, (String) sparseArray5.get(f.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fFw, this.fKJ.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        final SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(f.g.tag_del_post_id, str);
        sparseArray.put(f.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(f.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(f.g.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = f.j.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = f.j.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = f.j.report_thread_confirm;
            } else {
                i3 = f.j.del_thread_confirm;
            }
        }
        this.fFy = new com.baidu.tbadk.core.dialog.a(this.fKJ.getPageContext().getPageActivity());
        this.fFy.cf(i3);
        this.fFy.C(sparseArray);
        this.fFy.a(f.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.fLb != null) {
                    b.this.fLb.i(new Object[]{sparseArray.get(f.g.tag_del_post_id), sparseArray.get(f.g.tag_manage_user_identity), sparseArray.get(f.g.tag_del_post_is_self), sparseArray.get(f.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.fFy.b(f.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fFy.av(true);
        this.fFy.b(this.fKJ.getPageContext());
        if (z) {
            this.fFy.xe();
        } else {
            d(sparseArray);
        }
    }

    private void d(final SparseArray<Object> sparseArray) {
        AntiData Cb;
        if (this.fKJ != null && sparseArray != null && this.fKH != null) {
            if (this.dKk == null) {
                this.dKk = new e(this.fKJ.getPageContext(), this.fKH);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.fKm != null && (Cb = this.fKm.Cb()) != null && Cb.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = Cb.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray2);
            this.dKk.setDefaultReasonArray(new String[]{this.fKJ.getString(f.j.delete_thread_reason_1), this.fKJ.getString(f.j.delete_thread_reason_2), this.fKJ.getString(f.j.delete_thread_reason_3), this.fKJ.getString(f.j.delete_thread_reason_4), this.fKJ.getString(f.j.delete_thread_reason_5)});
            this.dKk.setData(ahVar);
            this.dKk.hZ("4");
            this.dKk.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.b.9
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void f(JSONArray jSONArray) {
                    String d = ap.d(jSONArray);
                    if (b.this.fLb != null) {
                        b.this.fLb.i(new Object[]{sparseArray.get(f.g.tag_del_post_id), sparseArray.get(f.g.tag_manage_user_identity), sparseArray.get(f.g.tag_del_post_is_self), sparseArray.get(f.g.tag_del_post_type), d});
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
        if (this.fFH != null) {
            this.fFH.dismiss();
            this.fFH = null;
        }
        if (z) {
            string = this.fKJ.getResources().getString(f.j.remove_mark);
        } else {
            string = this.fKJ.getResources().getString(f.j.mark);
        }
        this.fFH = new com.baidu.tbadk.core.dialog.b(this.fKJ.getPageContext().getPageActivity());
        this.fFH.ci(f.j.operation);
        this.fFH.a(new String[]{this.fKJ.getResources().getString(f.j.copy), string}, interfaceC0101b);
        this.fFH.d(this.fKJ.getPageContext());
        this.fFH.xh();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.fLa = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.fLb = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.fKJ.showToast(this.fKJ.getResources().getString(f.j.delete_success));
        } else if (str != null && z2) {
            this.fKJ.showToast(str);
        }
    }

    public void aA(View view) {
        if (this.cYI != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cYI.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.LO != null) {
                    this.LO.removeHeaderView(this.cYI);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.cYI.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.f(this.fKJ.getActivity(), f.e.ds98)));
            } else if (this.LO != null) {
                this.LO.addHeaderView(this.cYI, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.Ht() != null) {
            this.eIf = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bPD.addView(gVar.Ht(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.fKA = aVar;
    }

    public void bfp() {
        if (this.LO != null) {
            this.fLk = this.LO.getLastVisiblePosition();
        }
    }

    public void bfq() {
        if (this.fKm != null) {
            if ((!bft() && this.fKZ != null && this.fKZ.isShown()) || w.z(this.fLd)) {
                this.fKm.kN(false);
            } else {
                this.fKm.kN(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.fKm = subPbModel;
    }

    public void bfr() {
        a(this.fKJ);
        this.LO.setNextPage(this.fKW);
    }

    public void m(PostData postData) {
        int i;
        if (postData != null) {
            postData.ms(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bft() && this.fKZ != null && this.fKZ.isShown()) {
                i = (this.fLk - this.fLj) - 1;
            } else {
                i = this.fLk - this.fLj;
            }
            int y = w.y(this.fLd);
            if (i > y) {
                i = y;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(w.a(this.fLd, 0, i));
            w.b(arrayList, postData2);
            w.b(arrayList, postData);
            this.fKI.setDatas(arrayList);
            this.fKI.notifyDataSetChanged();
            this.LO.smoothScrollToPosition(this.fLk + 2);
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
        return this.bPD;
    }

    public void bel() {
        if (this.fKX != null) {
            com.baidu.adp.lib.g.g.a(this.fKX, this.fKJ.getPageContext().getPageActivity());
        }
        if (this.fFH != null) {
            this.fFH.dismiss();
        }
        if (this.fFy != null) {
            this.fFy.dismiss();
        }
        if (this.fFw != null) {
            com.baidu.adp.lib.g.g.b(this.fFw, this.fKJ.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.fvu != null) {
            this.fvu.dismiss();
        }
    }

    public void bfs() {
        this.LO.setNextPage(this.fKW);
        this.fKW.Av();
    }

    public void jt(boolean z) {
        this.fxC = z;
    }

    public void setIsFromPb(boolean z) {
        this.aMz = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(k kVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (kVar != null) {
            if (this.aMz && this.fKH != null) {
                this.fKI.kL(true);
                this.fKH.setVisibility(8);
                this.LO.removeHeaderView(this.fKH);
                this.fLj = 1;
            }
            this.fJi = kVar;
            this.fKI.Z(this.fJi.Tg());
            if (this.fKH != null) {
                this.fKH.setVisibility(0);
            }
            if (this.fKK != null) {
                this.fKK.setVisibility(0);
            }
            if (kVar.aZU() != null) {
                this.fLc = kVar.aZU().getId();
                this.bfh = kVar.aZU().bwg();
                if (this.bfh > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.fKJ.getResources().getString(f.j.subpb_floor_reply_count), ap.F(kVar.getTotalCount())));
                    this.dAK.setText(f.j.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.fKJ.bfo()) {
                    str = "PB";
                }
                if (kVar.aZU().vE() != null) {
                    this.fKV.setData(this.fKJ.getPageContext(), kVar.aZU().vE(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", kVar.bab().getId(), kVar.bab().getName(), kVar.Tg().getId(), str));
                } else {
                    this.fKV.setData(null, null, null);
                }
            }
            if (kVar.hasMore()) {
                this.fKW.Av();
                this.fKI.setHasMoreData(true);
            } else {
                this.fKW.Aw();
                this.fKI.setHasMoreData(false);
            }
            this.fLd = kVar.aZY();
            if (w.z(this.fLd)) {
                this.LO.setNextPage(null);
                if (this.aMz) {
                    this.dAL.setVisibility(0);
                }
            } else {
                this.LO.setNextPage(this.fKW);
                if (this.aMz) {
                    this.dAL.setVisibility(8);
                }
            }
            if (this.fLd == null || this.fLd.size() <= fKG) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.fLd.size() - fKG;
                qW(size);
                int firstVisiblePosition = this.LO.getFirstVisiblePosition() - size;
                View childAt = this.LO.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.fKI.setDatas(this.fLd);
            boolean z2 = false;
            if (kVar.Tg() != null && kVar.Tg().vj() != null && (userId = kVar.Tg().vj().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.fKI.A(i, z2);
            this.fKI.notifyDataSetChanged();
            a(kVar.aZU(), kVar.aMK(), kVar.rL(), i, z);
            if (i4 > 0) {
                this.LO.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void qW(int i) {
        if (this.fLd != null) {
            if (this.fLd.size() <= i) {
                this.fLd.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.fLd.iterator();
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

    public boolean bft() {
        return this.fKI.cHK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.aMz) {
            this.fto = postData;
            if (!StringUtils.isNull(postData.bwn())) {
                this.fKT.setVisibility(0);
                this.fKT.startLoad(postData.bwn(), 10, true);
            } else {
                this.fKT.setVisibility(8);
            }
            h bwp = postData.bwp();
            if (bwp != null && bwp.gND) {
                this.fKU.setVisibility(0);
            } else {
                this.fKU.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.fKH.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.fKH.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(f.g.tag_clip_board, postData);
            sparseArray.put(f.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.fKQ.setText((CharSequence) null);
            this.ayV.setText((CharSequence) null);
            this.fEQ.setVisibility(8);
            if (!this.aMz) {
                c(postData.vj());
                if (z) {
                    this.fEQ.setVisibility(0);
                    com.baidu.tbadk.core.util.am.h(this.fEQ, f.d.cp_link_tip_a);
                }
            }
            this.fKR.setText(ap.w(postData.getTime()));
            this.fKQ.setText(String.format(this.fKJ.getPageContext().getString(f.j.is_floor), Integer.valueOf(postData.bwg())));
            postData.vj().getUserTbVipInfoData();
            boolean a = a(this.fKS, postData.bwi());
            if (StringUtils.isNull(postData.bwn()) && !a && postData.NE() != null) {
                this.cyY.setVisibility(0);
                this.cyY.setTag(postData.NE());
                return;
            }
            this.cyY.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.k.bj(metaData.getSealPrefix()) + 2 : 0) + com.baidu.tbadk.util.w.hH(name_show) > 14) {
                name_show = com.baidu.tbadk.util.w.k(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.ayV.setText(ah(metaData.getSealPrefix(), name_show));
            } else {
                this.ayV.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.fKO != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.fKO.setVisibility(8);
                } else {
                    this.fKO.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.ZS = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.fKO.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.fEY.setVisibility(0);
                this.fKN.setVisibility(8);
                this.fEY.setUserId(metaData.getUserId());
                this.fEY.setUserName(metaData.getUserName());
                this.fEY.startLoad(metaData.getPortrait(), 28, false);
                com.baidu.tbadk.core.util.am.h(this.ayV, f.d.cp_cont_r);
            } else {
                this.fEY.setVisibility(8);
                this.fKN.setVisibility(0);
                this.fKN.setUserId(metaData.getUserId());
                this.fKN.setUserName(metaData.getUserName());
                this.fKN.setDefaultResource(f.C0146f.transparent_bg);
                this.fKN.setDefaultErrorResource(f.C0146f.icon_default_avatar100);
                this.fKN.startLoad(metaData.getPortrait(), 28, false);
                com.baidu.tbadk.core.util.am.h(this.ayV, f.d.cp_cont_c);
            }
            this.fKM.setTag(f.g.tag_user_id, metaData.getUserId());
            this.fKM.setTag(f.g.tag_user_name, metaData.getUserName());
            this.fKM.setTag(f.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.Nw() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.Nw().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.ND());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.co(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.bEt());
                        continue;
                    case 17:
                        String str = next.NH().mGifInfo.mSharpText;
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
        if (!tbRichTextData.NM()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.ND() == null || tbRichTextData.ND().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.ND());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fKJ.getPageContext().getString(f.j.refresh_view_title_text), this.abf));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.fKJ.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.fKK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, f.C0146f.pic_emotion07, l.f(pageActivity, f.e.ds250), l.f(pageActivity, f.e.ds480), l.f(pageActivity, f.e.ds360)), dVar, a);
        }
        this.fKK.setVisibility(0);
        this.LO.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.eIf.Ip();
        com.baidu.tbadk.core.util.am.j(this.mNoDataView, f.d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.fKJ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void is(int i) {
        b(NoDataViewFactory.d.E(i, f.j.refresh_view_title_text));
        if (this.fKA != null) {
            this.fKA.bo(this.bPD);
        }
        this.fLf.setVisibility(8);
    }

    public void mH(String str) {
        b(NoDataViewFactory.d.ag(str, this.fKJ.getPageContext().getString(f.j.refresh_view_title_text)));
        if (this.fKA != null) {
            this.fKA.bo(this.bPD);
        }
        this.fLf.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.LO.setVisibility(0);
            this.fLf.setVisibility(0);
            this.bPD.setOnTouchListener(null);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.abf = onClickListener;
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
                String userId2 = postData.vj().getUserId();
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
            if (this.fJi != null && this.fJi.Tg() != null && this.fJi.Tg().vj() != null && postData.vj() != null) {
                String userId3 = this.fJi.Tg().vj().getUserId();
                String userId4 = postData.vj().getUserId();
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
                    userId = postData.vj().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.bwg() != 1 ? 0 : 1;
                    if (as.j(postData)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(f.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(f.g.tag_forbid_user_post_id, postData.getId());
                        if (postData.vj() != null) {
                            sparseArray.put(f.g.tag_forbid_user_name, postData.vj().getUserName());
                            sparseArray.put(f.g.tag_forbid_user_name_show, postData.vj().getName_show());
                            sparseArray.put(f.g.tag_forbid_user_portrait, postData.vj().getPortrait());
                            z7 = true;
                        } else {
                            z7 = true;
                        }
                    } else {
                        sparseArray.put(f.g.tag_forbid_user_name, "");
                        sparseArray.put(f.g.tag_forbid_user_name_show, "");
                        sparseArray.put(f.g.tag_forbid_user_portrait, "");
                        z7 = false;
                    }
                    if (!z4) {
                        sparseArray.put(f.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(f.g.tag_del_post_is_self, true);
                        sparseArray.put(f.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(f.g.tag_del_post_id, postData.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(f.g.tag_del_post_is_self, false);
                        sparseArray.put(f.g.tag_del_post_type, 0);
                        sparseArray.put(f.g.tag_del_post_id, "");
                    }
                    sparseArray.put(f.g.tag_should_manage_visible, Boolean.valueOf(z7));
                    sparseArray.put(f.g.tag_forbid_user_post_id, postData.getId());
                    if (!z6) {
                        sparseArray.put(f.g.tag_should_manage_visible, true);
                        sparseArray.put(f.g.tag_manage_user_identity, Integer.valueOf(i));
                        if (postData.vj() != null) {
                            sparseArray.put(f.g.tag_forbid_user_name, postData.vj().getUserName());
                            sparseArray.put(f.g.tag_forbid_user_name_show, postData.vj().getName_show());
                            sparseArray.put(f.g.tag_forbid_user_portrait, postData.vj().getPortrait());
                        }
                    } else {
                        sparseArray.put(f.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(f.g.tag_user_mute_visible, true);
                        sparseArray.put(f.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.vj() != null) {
                            sparseArray.put(f.g.tag_user_mute_mute_userid, postData.vj().getUserId());
                            sparseArray.put(f.g.tag_user_mute_mute_username, postData.vj().getUserName());
                            sparseArray.put(f.g.tag_user_mute_mute_nameshow, postData.vj().getName_show());
                        }
                        if (this.fJi.Tg() != null) {
                            sparseArray.put(f.g.tag_user_mute_thread_id, this.fJi.Tg().getId());
                        }
                        sparseArray.put(f.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(f.g.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(f.g.tag_should_delete_visible, true);
                        sparseArray.put(f.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(f.g.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(f.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(f.g.tag_del_post_id, postData.getId());
                        return;
                    }
                    sparseArray.put(f.g.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = postData.vj().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.bwg() != 1) {
            }
            if (as.j(postData)) {
            }
            if (!z6) {
            }
            if (!z4) {
            }
            sparseArray.put(f.g.tag_should_manage_visible, Boolean.valueOf(z7));
            sparseArray.put(f.g.tag_forbid_user_post_id, postData.getId());
            if (!z6) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public void kJ(boolean z) {
        if (this.fvu != null && this.fvu.bcP() != null) {
            if (z) {
                this.fvu.bcP().setText(f.j.remove_mark);
            } else {
                this.fvu.bcP().setText(f.j.mark);
            }
            this.fvu.refreshUI();
        }
    }

    public View bfu() {
        return this.fKZ;
    }

    public void onChangeSkinType(int i) {
        this.fKJ.getLayoutMode().setNightMode(i == 1);
        this.fKJ.getLayoutMode().onModeChanged(this.bPD);
        this.fKJ.getLayoutMode().onModeChanged(this.fKH);
        this.mNavigationBar.onChangeSkinType(this.fKJ.getPageContext(), i);
        if (this.fKL != null) {
            com.baidu.tbadk.core.util.am.h(this.fKL, f.d.goto_see_subject_color);
        }
        com.baidu.tbadk.core.util.am.h(this.dAL, f.d.cp_cont_d);
        this.dit.onChangeSkinType(this.fKJ.getPageContext(), i);
        this.fKJ.getLayoutMode().onModeChanged(this.fKZ);
        com.baidu.tbadk.core.util.am.h(this.fKS, f.d.cp_cont_b);
        this.fKS.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(f.d.cp_link_tip_c));
        if (this.eIf != null && this.eIf.Ht() != null) {
            this.eIf.Ht().onChangeSkinType(i);
        }
        this.fKW.dB(i);
        this.cyY.aPq();
        com.baidu.tbadk.core.util.am.h(this.dAK, f.d.cp_cont_e);
        com.baidu.tbadk.core.util.am.h(this.fEQ, f.d.cp_link_tip_a);
        com.baidu.tbadk.core.util.am.h(this.ayV, f.d.cp_cont_c);
        this.dAK.setAlpha(0.95f);
        if (this.fKI != null) {
            this.fKI.notifyDataSetChanged();
        }
    }

    public void bfv() {
        this.mProgress.setVisibility(0);
    }

    public void bfw() {
        this.LO.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fKW.Aw();
    }

    public void aqL() {
        this.LO.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fKW.aqL();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aJm = onLongClickListener;
        this.fKH.setOnLongClickListener(this.aJm);
    }

    public View bfx() {
        return this.fKH;
    }

    public TextView ayz() {
        return this.dAK;
    }

    public ImageView bfy() {
        return this.fLg;
    }

    public ImageView bfz() {
        return this.fLh;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void qX(int i) {
    }

    public void rD(String str) {
        int rE = this.fKI.rE(str);
        if (rE > -1) {
            this.fKI.qY(rE);
            if (rE > 2) {
                this.LO.setSelection(rE - 2);
            } else {
                this.LO.setSelection(rE);
            }
            this.LO.invalidate();
        }
    }

    public View bfA() {
        return this.fKL;
    }

    public View bfB() {
        return this.fKT;
    }

    public MorePopupWindow bfC() {
        return this.fKX;
    }

    public void showLoadingDialog() {
        if (this.cIE == null) {
            this.cIE = new com.baidu.tbadk.core.view.a(this.fKJ.getPageContext());
        }
        this.cIE.aN(true);
    }

    public void aeR() {
        if (this.cIE != null) {
            this.cIE.aN(false);
        }
    }

    public TextView bfD() {
        return this.fKS;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.fKq = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fKr = hVar;
    }

    public y bfE() {
        return this.fvu;
    }

    public void axn() {
    }

    public void axo() {
    }

    public void onActivityDestroy() {
    }

    public void bfF() {
        if (this.fKJ.isPaused()) {
        }
    }

    public View bfG() {
        return this.fKM;
    }

    private SpannableStringBuilder ah(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, f.C0146f.pic_smalldot_title));
            return o.a((Context) this.fKJ.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
