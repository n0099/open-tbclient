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
    private static final int glV = TbadkCoreApplication.getInst().getListItemRule().Hc();
    private RelativeLayout ciS;
    private NoNetworkView dHD;
    private com.baidu.tbadk.core.view.d dih;
    private View dxN;
    private TextView eaw;
    private com.baidu.tieba.NEGFeedBack.e ekK;
    private y fWT;
    private View ggS;
    private com.baidu.tbadk.core.dialog.b ggV;
    private j gkC;
    private SubPbModel glB;
    private a glP;
    private View glW;
    private NewSubPbActivity glX;
    private RelativeLayout glY;
    private View gmc;
    private ThreadSkinView gmj;
    private e gmk;
    private View gmn;
    private ArrayList<PostData> gmr;
    private String gms;
    private RelativeLayout gmt;
    private ImageView gmu;
    private ImageView gmv;
    private d gmz;
    private View.OnClickListener mCommonClickListener;
    private BdTypeListView mListView;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener anx = null;
    private TbRichTextView.i glF = null;
    private NavigationBar mNavigationBar = null;
    private View aNz = null;
    private TextView glZ = null;
    private LinearLayout gma = null;
    private HeadImageView gmb = null;
    private ClickableHeaderImageView ggl = null;
    private TextView aLy = null;
    private ImageView gmd = null;
    private TextView ggd = null;
    private TextView gme = null;
    private TextView gmf = null;
    private EllipsizeRichTextView gmg = null;
    private TbImageView gmh = null;
    private PlayVoiceBntNew cYz = null;
    private TextView gmi = null;
    private MorePopupWindow gml = null;
    private am gmm = null;
    private com.baidu.tbadk.core.dialog.b ggU = null;
    private Dialog ggJ = null;
    private com.baidu.tbadk.core.dialog.a ggL = null;
    private boolean fZa = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener aWd = null;
    private NewSubPbActivity.a gmo = null;
    private NewSubPbActivity.a gmp = null;
    private g fiT = null;
    private String gmq = null;
    private int brI = 0;
    private PostData fUE = null;
    private int gmw = 0;
    private int gmx = 2;
    private int gmy = 0;
    private boolean aZt = true;
    private View.OnClickListener fZi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
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
                        b.this.glX.b(sparseArray);
                        return;
                    }
                    b.this.bF(view);
                } else if (booleanValue2) {
                    sparseArray.put(e.g.tag_from, 0);
                    b.this.glX.b(sparseArray);
                } else if (booleanValue3) {
                    b.this.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c bsF = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.b.4
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
    protected AdapterView.OnItemLongClickListener gmA = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.d(b.this.gmr, i);
            if (view == null || view.getTag() == null) {
                return false;
            }
            if (b.this.fWT == null) {
                b.this.fWT = new y(b.this.glX.getPageContext(), b.this.mCommonClickListener);
            }
            b.this.fWT.showDialog();
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
            b.this.fWT.a(sparseArray, b.this.glB.bhL(), kJ);
            if (kJ) {
                b.this.fWT.bll().setVisibility(0);
                b.this.fWT.bll().setTag(postData.getId());
            } else {
                b.this.fWT.bll().setVisibility(8);
            }
            b.this.fWT.blj().setVisibility(8);
            b.this.fWT.refreshUI();
            return false;
        }
    };
    protected AdapterView.OnItemClickListener gmB = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ba.bJ(b.this.glX.getPageContext().getPageActivity())) {
                if (b.this.glX.fiL == null || b.this.glB == null || b.this.glB.aBj() == null || b.this.glX.fiL.dK(b.this.glB.aBj().replyPrivateFlag)) {
                    if (b.this.glP != null) {
                        b.this.glP.aGm();
                    }
                    b.this.bnN();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) v.d(b.this.gmr, i);
                        if (postData == null) {
                            b.this.gms = null;
                        } else {
                            b.this.gms = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(e.g.tag_photo_username);
                            String str2 = (String) sparseArray.get(e.g.tag_photo_userid);
                            if (str != null) {
                                b.this.fiT.setReplyId(str2);
                                b.this.fiT.in(str);
                            }
                        }
                        b.this.bnO();
                        return;
                    }
                    b.this.bnP();
                    b.this.glB.bok();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.ciS = null;
        this.glW = null;
        this.mListView = null;
        this.glX = null;
        this.dHD = null;
        this.glY = null;
        this.gmc = null;
        this.gmk = null;
        this.gmn = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.eaw = null;
        this.gmt = null;
        this.gmu = null;
        this.gmv = null;
        this.glX = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.ciS = (RelativeLayout) LayoutInflater.from(this.glX.getPageContext().getPageActivity()).inflate(e.h.new_sub_pb_layout, (ViewGroup) null);
        this.glW = LayoutInflater.from(this.glX.getPageContext().getPageActivity()).inflate(e.h.new_sub_pb_head, (ViewGroup) null);
        this.gmt = (RelativeLayout) this.ciS.findViewById(e.g.subpb_editor_tool_comment);
        this.eaw = (TextView) this.ciS.findViewById(e.g.subpb_editor_tool_comment_reply_text);
        this.eaw.setOnClickListener(this.mCommonClickListener);
        this.gmu = (ImageView) this.ciS.findViewById(e.g.subpb_editor_tool_more_img);
        this.gmv = (ImageView) this.ciS.findViewById(e.g.subpb_editor_tool_emotion_img);
        this.gmv.setOnClickListener(this.mCommonClickListener);
        this.gmu.setOnClickListener(this.mCommonClickListener);
        this.dHD = (NoNetworkView) this.ciS.findViewById(e.g.view_no_network);
        aGu();
        azU();
        this.glY = (RelativeLayout) this.ciS.findViewById(e.g.sub_pb_body_layout);
        this.mListView = (BdTypeListView) this.ciS.findViewById(e.g.new_sub_pb_list);
        this.gmj = (ThreadSkinView) LayoutInflater.from(this.glX.getPageContext().getPageActivity()).inflate(e.h.thread_skin_layout, (ViewGroup) null);
        this.mListView.addHeaderView(this.gmj);
        this.mListView.addHeaderView(this.glW);
        this.dxN = BdListViewHelper.a(this.glX.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.gmk = new e(this.glX.getPageContext());
        this.gmk.Fm();
        this.gmn = this.gmk.getView();
        this.mListView.setNextPage(this.gmk);
        this.gmk.setOnClickListener(this.mCommonClickListener);
        this.mListView.setOnItemClickListener(this.gmB);
        this.mListView.setOnItemLongClickListener(this.gmA);
        this.mListView.setOnTouchListener(this.bsF);
        this.mProgress = (ProgressBar) this.ciS.findViewById(e.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.glW != null) {
            this.glW.setVisibility(4);
        }
        if (this.glY != null) {
            this.glY.setVisibility(4);
        }
        this.gmc = com.baidu.tbadk.ala.b.wg().j(this.glX.getActivity(), 4);
        if (this.gmc != null) {
            this.gmc.setVisibility(8);
            this.gma.addView(this.gmc, 3);
        }
        this.gmz = new d(this.glX, this.mListView);
        this.gmz.setFromCDN(this.mIsFromCDN);
        this.gmz.s(this.mCommonClickListener);
        this.gmz.initAdapters();
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void azU() {
        this.gma = (LinearLayout) this.glW.findViewById(e.g.subpb_head_user_info_root);
        this.gma.setOnClickListener(this.mCommonClickListener);
        this.gmb = (HeadImageView) this.glW.findViewById(e.g.photo);
        this.gmb.setRadius(l.h(this.glX.getActivity(), e.C0210e.ds30));
        this.gmb.setClickable(false);
        this.ggl = (ClickableHeaderImageView) this.glW.findViewById(e.g.god_user_photo);
        this.ggl.setGodIconMargin(0);
        this.ggl.setGodIconWidth(e.C0210e.ds24);
        this.ggl.setRadius(l.h(this.glX.getActivity(), e.C0210e.ds30));
        this.ggl.setClickable(false);
        this.aLy = (TextView) this.glW.findViewById(e.g.user_name);
        this.gmd = (ImageView) this.glW.findViewById(e.g.user_rank);
        this.gmd.setVisibility(8);
        this.ggd = (TextView) this.glW.findViewById(e.g.floor_owner);
        this.glZ = (TextView) this.glW.findViewById(e.g.see_subject);
        this.glZ.setOnClickListener(this.mCommonClickListener);
        this.gme = (TextView) this.glW.findViewById(e.g.floor);
        this.gmf = (TextView) this.glW.findViewById(e.g.time);
        this.gmg = (EllipsizeRichTextView) this.glW.findViewById(e.g.content_text);
        this.gmg.setOnClickListener(this.mCommonClickListener);
        al.h(this.gmg, e.d.cp_cont_b);
        this.gmg.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
        this.gmg.setLineSpacing(0.0f, 1.25f);
        this.gmh = (TbImageView) this.glW.findViewById(e.g.sub_pb_image);
        this.gmh.setOnClickListener(this.mCommonClickListener);
        this.gmi = (TextView) this.glW.findViewById(e.g.advert);
        this.cYz = (PlayVoiceBntNew) this.glW.findViewById(e.g.voice_btn);
        this.glW.setOnTouchListener(this.bsF);
        this.glW.setOnClickListener(this.mCommonClickListener);
    }

    public void hm(boolean z) {
        if (this.dxN != null && this.dxN.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.dxN.getLayoutParams();
            if (z) {
                aGy();
                layoutParams.height = l.h(this.glX.getPageContext().getPageActivity(), e.C0210e.ds88);
            } else {
                layoutParams.height = l.h(this.glX.getPageContext().getPageActivity(), e.C0210e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.dxN.setLayoutParams(layoutParams);
        }
    }

    private void aGy() {
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_close, e.f.subpb_navigationbar_close);
    }

    public void a(b.InterfaceC0158b interfaceC0158b, boolean z) {
        if (this.ggV != null) {
            this.ggV.dismiss();
            this.ggV = null;
        }
        this.ggV = new com.baidu.tbadk.core.dialog.b(this.glX.getPageContext().getPageActivity());
        if (z) {
            this.ggV.a(new String[]{this.glX.getPageContext().getString(e.j.save_to_emotion)}, interfaceC0158b);
        } else {
            this.ggV.a(new String[]{this.glX.getPageContext().getString(e.j.save_to_emotion), this.glX.getPageContext().getString(e.j.save_to_local)}, interfaceC0158b);
        }
        this.ggV.d(this.glX.getPageContext());
        this.ggV.BV();
    }

    public void bH(View view) {
        this.ggS = view;
    }

    public View aGz() {
        return this.dxN;
    }

    public void aGu() {
        int h = l.h(this.glX.getPageContext().getPageActivity(), e.C0210e.ds88);
        int h2 = l.h(this.glX.getPageContext().getPageActivity(), e.C0210e.ds2);
        this.mNavigationBar = (NavigationBar) this.ciS.findViewById(e.g.view_navigation_bar);
        this.aNz = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aNz.getLayoutParams();
            layoutParams.height = h;
            layoutParams.width = h;
            layoutParams.leftMargin = h2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aNz != null && (this.aNz.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aNz.getLayoutParams();
            layoutParams2.width = h;
            layoutParams2.height = h;
            this.aNz.setLayoutParams(layoutParams2);
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
        if (this.ggJ == null) {
            this.ggJ = new Dialog(this.glX.getPageContext().getPageActivity(), e.k.common_alert_dialog);
            this.ggJ.setCanceledOnTouchOutside(true);
            this.ggJ.setCancelable(true);
            View inflate = LayoutInflater.from(this.glX.getPageContext().getPageActivity()).inflate(e.h.forum_manage_dialog, (ViewGroup) null);
            this.glX.getLayoutMode().onModeChanged(inflate);
            this.ggJ.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.ggJ.getWindow().getAttributes();
            attributes.width = (int) (l.aO(this.glX.getPageContext().getPageActivity()) * 0.9d);
            this.ggJ.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.ggJ.findViewById(e.g.del_post_btn);
        TextView textView2 = (TextView) this.ggJ.findViewById(e.g.forbid_user_btn);
        TextView textView3 = (TextView) this.ggJ.findViewById(e.g.disable_reply_btn);
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
                    if (b.this.ggJ != null && (b.this.ggJ instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.ggJ, b.this.glX.getPageContext());
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
                    if (b.this.ggJ != null && (b.this.ggJ instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.ggJ, b.this.glX.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.gmo != null) {
                        b.this.gmo.m(new Object[]{sparseArray4.get(e.g.tag_manage_user_identity), sparseArray4.get(e.g.tag_forbid_user_name), sparseArray4.get(e.g.tag_forbid_user_post_id), sparseArray4.get(e.g.tag_forbid_user_name_show), sparseArray4.get(e.g.tag_forbid_user_portrait)});
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
                    if (b.this.ggJ != null && (b.this.ggJ instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.ggJ, b.this.glX.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.glX.a(z, (String) sparseArray5.get(e.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.ggJ, this.glX.getPageContext());
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
        this.ggL = new com.baidu.tbadk.core.dialog.a(this.glX.getPageContext().getPageActivity());
        this.ggL.db(i3);
        this.ggL.H(sparseArray);
        this.ggL.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.gmp != null) {
                    b.this.gmp.m(new Object[]{sparseArray.get(e.g.tag_del_post_id), sparseArray.get(e.g.tag_manage_user_identity), sparseArray.get(e.g.tag_del_post_is_self), sparseArray.get(e.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.ggL.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.ggL.bg(true);
        this.ggL.b(this.glX.getPageContext());
        if (z) {
            this.ggL.BS();
        } else {
            d(sparseArray);
        }
    }

    private void d(final SparseArray<Object> sparseArray) {
        AntiData aBj;
        if (this.glX != null && sparseArray != null && this.glW != null) {
            if (this.ekK == null) {
                this.ekK = new com.baidu.tieba.NEGFeedBack.e(this.glX.getPageContext(), this.glW);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.glB != null && (aBj = this.glB.aBj()) != null && aBj.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = aBj.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray2);
            this.ekK.setDefaultReasonArray(new String[]{this.glX.getString(e.j.delete_thread_reason_1), this.glX.getString(e.j.delete_thread_reason_2), this.glX.getString(e.j.delete_thread_reason_3), this.glX.getString(e.j.delete_thread_reason_4), this.glX.getString(e.j.delete_thread_reason_5)});
            this.ekK.setData(ahVar);
            this.ekK.jy("4");
            this.ekK.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.b.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void m(JSONArray jSONArray) {
                    String i2 = ao.i(jSONArray);
                    if (b.this.gmp != null) {
                        b.this.gmp.m(new Object[]{sparseArray.get(e.g.tag_del_post_id), sparseArray.get(e.g.tag_manage_user_identity), sparseArray.get(e.g.tag_del_post_is_self), sparseArray.get(e.g.tag_del_post_type), i2});
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
        this.gmo = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.gmp = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.glX.showToast(this.glX.getResources().getString(e.j.delete_success));
        } else if (str != null && z2) {
            this.glX.showToast(str);
        }
    }

    public void aT(View view) {
        if (this.dxN != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dxN.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.dxN);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.dxN.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.glX.getActivity(), e.C0210e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.dxN, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.Mp() != null) {
            this.fiT = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.ciS.addView(gVar.Mp(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.glP = aVar;
    }

    public void bnN() {
        if (this.mListView != null) {
            this.gmy = this.mListView.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kJ(boolean z) {
        if (this.glB == null || this.glB.boh() == null) {
            return false;
        }
        if (this.glB.bhL() != 0) {
            return false;
        }
        return (this.gkC == null || this.gkC.aaq() == null || this.gkC.aaq().zT() == null || !TextUtils.equals(this.gkC.aaq().zT().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void bnO() {
        if (this.glB != null) {
            if ((!bnR() && this.gmn != null && this.gmn.isShown()) || v.I(this.gmr)) {
                this.glB.lR(false);
            } else {
                this.glB.lR(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.glB = subPbModel;
    }

    public void bnP() {
        a(this.glX);
        this.mListView.setNextPage(this.gmk);
    }

    public void p(PostData postData) {
        int i;
        if (postData != null) {
            postData.nx(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bnR() && this.gmn != null && this.gmn.isShown()) {
                i = (this.gmy - this.gmx) - 1;
            } else {
                i = this.gmy - this.gmx;
            }
            int H = v.H(this.gmr);
            if (i > H) {
                i = H;
            }
            ArrayList arrayList = new ArrayList(v.b(this.gmr, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.mListView.smoothScrollToPosition(this.gmy + 2);
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
        return this.ciS;
    }

    public void bmF() {
        if (this.gml != null) {
            com.baidu.adp.lib.g.g.a(this.gml, this.glX.getPageContext().getPageActivity());
        }
        if (this.ggU != null) {
            this.ggU.dismiss();
        }
        if (this.ggL != null) {
            this.ggL.dismiss();
        }
        if (this.ggJ != null) {
            com.baidu.adp.lib.g.g.b(this.ggJ, this.glX.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.fWT != null) {
            this.fWT.dismiss();
        }
    }

    public void bnQ() {
        this.mListView.setNextPage(this.gmk);
        this.gmk.Fp();
    }

    public void kC(boolean z) {
        this.fZa = z;
    }

    public void setIsFromPb(boolean z) {
        this.aZt = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v36, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(j jVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (jVar != null) {
            if (this.aZt && this.glW != null) {
                this.glW.setVisibility(8);
                this.mListView.removeHeaderView(this.glW);
                this.gmx = 1;
            }
            this.gkC = jVar;
            if (this.glW != null) {
                this.glW.setVisibility(0);
            }
            if (this.glY != null) {
                this.glY.setVisibility(0);
            }
            if (jVar.big() != null) {
                this.gmq = jVar.big().getId();
                this.brI = jVar.big().bES();
                if (this.brI > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.glX.getResources().getString(e.j.subpb_floor_reply), Integer.valueOf(this.brI)));
                    this.eaw.setText(e.j.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = this.glX.bnM() ? "PB" : null;
                if (jVar.big().Ap() != null) {
                    this.gmj.setData(this.glX.getPageContext(), jVar.big().Ap(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", jVar.bim().getId(), jVar.bim().getName(), jVar.aaq().getId(), str));
                } else {
                    this.gmj.setData(null, null, null);
                }
            }
            if (jVar.hasMore()) {
                this.gmk.Fp();
                this.gmz.setHasMoreData(true);
            } else {
                this.gmk.Fq();
                this.gmz.setHasMoreData(false);
            }
            this.gmr = jVar.bik();
            if (this.gmr == null || this.gmr.size() <= glV) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.gmr.size() - glV;
                sX(size);
                int firstVisiblePosition = this.mListView.getFirstVisiblePosition() - size;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.gmr);
            if (v.I(this.gmr)) {
                this.mListView.setNextPage(null);
                if (this.aZt) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.mListView.setNextPage(this.gmk);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(jVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.aZt) {
                arrayList.add(0, jVar.big());
            }
            this.gmz.a(this.gkC.aaq(), arrayList);
            a(jVar.big(), jVar.aUP(), jVar.wx(), i, z);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void sX(int i) {
        if (this.gmr != null) {
            if (this.gmr.size() <= i) {
                this.gmr.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.gmr.iterator();
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
        return this.gmz.hasMoreData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.aZt) {
            this.fUE = postData;
            if (!StringUtils.isNull(postData.bEZ())) {
                this.gmh.setVisibility(0);
                this.gmh.startLoad(postData.bEZ(), 10, true);
            } else {
                this.gmh.setVisibility(8);
            }
            h bFb = postData.bFb();
            if (bFb != null && bFb.hpl) {
                this.gmi.setVisibility(0);
            } else {
                this.gmi.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.glW.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.glW.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.gme.setText((CharSequence) null);
            this.aLy.setText((CharSequence) null);
            this.ggd.setVisibility(8);
            if (!this.aZt) {
                c(postData.zT());
                if (z) {
                    this.ggd.setVisibility(0);
                    al.h(this.ggd, e.d.cp_link_tip_a);
                }
            }
            this.gmf.setText(ao.M(postData.getTime()));
            this.gme.setText(String.format(this.glX.getPageContext().getString(e.j.is_floor), Integer.valueOf(postData.bES())));
            postData.zT().getUserTbVipInfoData();
            boolean a = a(this.gmg, postData.bEU());
            if (StringUtils.isNull(postData.bEZ()) && !a && postData.SF() != null) {
                this.cYz.setVisibility(0);
                this.cYz.setTag(postData.SF());
                return;
            }
            this.cYz.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.bz(metaData.getSealPrefix()) + 2 : 0) + z.jc(name_show) > 14) {
                name_show = z.q(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.aLy.setText(aF(metaData.getSealPrefix(), name_show));
            } else {
                this.aLy.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.gmc != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.gmc.setVisibility(8);
                } else {
                    this.gmc.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.amc = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.gmc.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.ggl.setVisibility(0);
                this.gmb.setVisibility(8);
                this.ggl.setUserId(metaData.getUserId());
                this.ggl.setUserName(metaData.getUserName());
                this.ggl.startLoad(metaData.getPortrait(), 28, false);
                al.h(this.aLy, e.d.cp_cont_r);
            } else {
                this.ggl.setVisibility(8);
                this.gmb.setVisibility(0);
                this.gmb.setUserId(metaData.getUserId());
                this.gmb.setUserName(metaData.getUserName());
                this.gmb.setDefaultResource(e.f.transparent_bg);
                this.gmb.setDefaultErrorResource(e.f.icon_default_avatar100);
                this.gmb.startLoad(metaData.getPortrait(), 28, false);
                al.h(this.aLy, e.d.cp_cont_c);
            }
            this.gma.setTag(e.g.tag_user_id, metaData.getUserId());
            this.gma.setTag(e.g.tag_user_name, metaData.getUserName());
            this.gma.setTag(e.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
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
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.glX.getPageContext().getString(e.j.refresh_view_title_text), this.anx));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.glX.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.glY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, e.f.pic_emotion07, l.h(pageActivity, e.C0210e.ds250), l.h(pageActivity, e.C0210e.ds480), l.h(pageActivity, e.C0210e.ds360)), dVar, a);
        }
        this.glY.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.fiT.Nl();
        al.j(this.mNoDataView, e.d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.glX.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void kf(int i) {
        b(NoDataViewFactory.d.H(i, e.j.refresh_view_title_text));
        if (this.glP != null) {
            this.glP.bI(this.ciS);
        }
        this.gmt.setVisibility(8);
    }

    public void oH(String str) {
        b(NoDataViewFactory.d.aE(str, this.glX.getPageContext().getString(e.j.refresh_view_title_text)));
        if (this.glP != null) {
            this.glP.bI(this.ciS);
        }
        this.gmt.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            this.gmt.setVisibility(0);
            this.ciS.setOnTouchListener(null);
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.anx = onClickListener;
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
            if (this.gkC != null && this.gkC.aaq() != null && this.gkC.aaq().zT() != null && postData.zT() != null) {
                String userId3 = this.gkC.aaq().zT().getUserId();
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
                        if (this.gkC.aaq() != null) {
                            sparseArray.put(e.g.tag_user_mute_thread_id, this.gkC.aaq().getId());
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
        if (this.fWT != null && this.fWT.blj() != null) {
            if (z) {
                this.fWT.blj().setText(e.j.remove_mark);
            } else {
                this.fWT.blj().setText(e.j.mark);
            }
            this.fWT.refreshUI();
        }
    }

    public View bnS() {
        return this.gmn;
    }

    public void onChangeSkinType(int i) {
        this.glX.getLayoutMode().setNightMode(i == 1);
        this.glX.getLayoutMode().onModeChanged(this.ciS);
        this.glX.getLayoutMode().onModeChanged(this.glW);
        this.mNavigationBar.onChangeSkinType(this.glX.getPageContext(), i);
        if (this.glZ != null) {
            al.h(this.glZ, e.d.goto_see_subject_color);
        }
        this.dHD.onChangeSkinType(this.glX.getPageContext(), i);
        this.glX.getLayoutMode().onModeChanged(this.gmn);
        al.h(this.gmg, e.d.cp_cont_b);
        this.gmg.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
        if (this.fiT != null && this.fiT.Mp() != null) {
            this.fiT.Mp().onChangeSkinType(i);
        }
        this.gmk.ey(i);
        this.cYz.aXt();
        al.h(this.eaw, e.d.cp_cont_e);
        al.h(this.ggd, e.d.cp_link_tip_a);
        al.h(this.aLy, e.d.cp_cont_c);
        this.eaw.setAlpha(0.95f);
        if (this.ggS != null) {
            com.baidu.tbadk.o.a.a(this.glX.getPageContext(), this.ggS);
        }
        if (this.gmz != null) {
            this.gmz.notifyDataSetChanged();
        }
    }

    public void bnT() {
        this.mProgress.setVisibility(0);
    }

    public void bnU() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.gmk.Fq();
    }

    public void ayr() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.gmk.ayr();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aWd = onLongClickListener;
        this.gmz.c(onLongClickListener);
    }

    public View bnV() {
        return this.glW;
    }

    public TextView aGA() {
        return this.eaw;
    }

    public ImageView bnW() {
        return this.gmu;
    }

    public ImageView bnX() {
        return this.gmv;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void sY(int i) {
    }

    public View bnY() {
        return this.glZ;
    }

    public View bnZ() {
        return this.gmh;
    }

    public MorePopupWindow boa() {
        return this.gml;
    }

    public void showLoadingDialog() {
        if (this.dih == null) {
            this.dih = new com.baidu.tbadk.core.view.d(this.glX.getPageContext());
        }
        this.dih.bB(true);
    }

    public void alK() {
        if (this.dih != null) {
            this.dih.bB(false);
        }
    }

    public TextView bob() {
        return this.gmg;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.glF = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.gmz.setOnImageClickListener(hVar);
    }

    public void notifyDataSetChanged() {
        if (this.gmz != null) {
            this.gmz.notifyDataSetChanged();
        }
    }

    public y boc() {
        return this.fWT;
    }

    public void aFm() {
    }

    public void aFn() {
    }

    public void onActivityDestroy() {
    }

    public void bod() {
        if (this.glX.isPaused()) {
        }
    }

    public View boe() {
        return this.gma;
    }

    private SpannableStringBuilder aF(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, e.f.pic_smalldot_title));
            return o.a((Context) this.glX.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
