package com.baidu.tieba.pb.pb.sub;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.SpannableStringBuilder;
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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.k;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.pb.pb.main.am;
import com.baidu.tieba.pb.pb.main.ar;
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class c {
    private static final int fWl = TbadkCoreApplication.getInst().getListItemRule().Ft();
    private BdListView avj;
    private TextView dMZ;
    private TextView dNa;
    private com.baidu.tbadk.core.view.b ddw;
    private View drS;
    private NoNetworkView dxK;
    private RelativeLayout fBM;
    private y fHF;
    private m fUM;
    private SubPbModel fVR;
    private e fWA;
    private View fWD;
    private ArrayList<PostData> fWH;
    private String fWI;
    private RelativeLayout fWJ;
    private ImageView fWK;
    private ImageView fWL;
    private b fWf;
    private View fWm;
    private d fWn;
    private NewSubPbActivity fWo;
    private RelativeLayout fWp;
    private View fWt;
    private ThreadSkinView fWz;
    private View.OnClickListener mCommonClickListener;
    private ProgressBar mProgress;
    private h mNoDataView = null;
    private TbRichTextView.h fVW = null;
    private View.OnClickListener aGO = null;
    private TbRichTextView.i fVV = null;
    private NavigationBar mNavigationBar = null;
    private View beJ = null;
    private TextView fWq = null;
    private LinearLayout fWr = null;
    private HeadImageView fWs = null;
    private ClickableHeaderImageView fQC = null;
    private TextView bdf = null;
    private ImageView fWu = null;
    private TextView fQu = null;
    private TextView fWv = null;
    private TextView fFs = null;
    private EllipsizeRichTextView fWw = null;
    private TbImageView fWx = null;
    private PlayVoiceBntNew cTY = null;
    private TextView fWy = null;
    private MorePopupWindow fWB = null;
    private am fWC = null;
    private com.baidu.tbadk.core.dialog.b fRl = null;
    private Dialog fRa = null;
    private com.baidu.tbadk.core.dialog.a fRc = null;
    private boolean fEV = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener bnd = null;
    private NewSubPbActivity.a fWE = null;
    private NewSubPbActivity.a fWF = null;
    private com.baidu.tbadk.editortools.pb.h eOI = null;
    private String fWG = null;
    private int bIJ = 0;
    private PostData fEp = null;
    private int fWM = 0;
    private int fWN = 2;
    private int fWO = 0;
    private boolean bqx = true;
    private View.OnClickListener fFa = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (!com.baidu.tieba.c.a.ajX() || !com.baidu.tieba.c.a.b(c.this.fWo.getBaseContext(), c.this.fWo.getThreadId(), c.this.fWo.getPostId(), c.this.fWo.aYS())) {
                        if (booleanValue2) {
                            sparseArray.put(d.g.tag_from, 1);
                            c.this.fWo.c(sparseArray);
                            return;
                        }
                        c.this.cz(view);
                    }
                } else if (booleanValue2) {
                    sparseArray.put(d.g.tag_from, 0);
                    c.this.fWo.c(sparseArray);
                } else if (booleanValue3) {
                    c.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c bJG = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.c.2
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            c.this.fX(false);
            c.this.bR(view);
            c.this.fX(true);
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean d(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean e(View view, MotionEvent motionEvent) {
            return true;
        }
    });
    protected AdapterView.OnItemClickListener fWP = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.9
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ax.be(c.this.fWo.getPageContext().getPageActivity())) {
                if (c.this.fWf != null) {
                    c.this.fWf.axg();
                }
                c.this.beQ();
                if (view == null || !(view.getTag() instanceof d.a)) {
                    PostData postData = (PostData) v.f(c.this.fWH, i);
                    if (postData == null) {
                        c.this.fWI = null;
                    } else {
                        c.this.fWI = postData.getId();
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(d.g.tag_photo_username);
                        String str2 = (String) sparseArray.get(d.g.tag_photo_userid);
                        if (str != null) {
                            c.this.eOI.setReplyId(str2);
                            c.this.eOI.go(str);
                        }
                    }
                    c.this.beR();
                    return;
                }
                c.this.beS();
                c.this.fVR.bfn();
            }
        }
    };

    public c(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.fBM = null;
        this.fWm = null;
        this.avj = null;
        this.fWn = null;
        this.fWo = null;
        this.dxK = null;
        this.fWp = null;
        this.dNa = null;
        this.fWt = null;
        this.fWA = null;
        this.fWD = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.dMZ = null;
        this.fWJ = null;
        this.fWK = null;
        this.fWL = null;
        this.fWo = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.fBM = (RelativeLayout) LayoutInflater.from(this.fWo.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_layout, (ViewGroup) null);
        this.fWm = LayoutInflater.from(this.fWo.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_head, (ViewGroup) null);
        this.dNa = (TextView) this.fBM.findViewById(d.g.no_reply_list_view);
        this.fWJ = (RelativeLayout) this.fBM.findViewById(d.g.subpb_editor_tool_comment);
        this.dMZ = (TextView) this.fBM.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.dMZ.setOnClickListener(this.mCommonClickListener);
        this.fWK = (ImageView) this.fBM.findViewById(d.g.subpb_editor_tool_more_img);
        this.fWL = (ImageView) this.fBM.findViewById(d.g.subpb_editor_tool_emotion_img);
        this.fWL.setOnClickListener(this.mCommonClickListener);
        this.fWK.setOnClickListener(this.mCommonClickListener);
        this.dxK = (NoNetworkView) this.fBM.findViewById(d.g.view_no_network);
        axo();
        beP();
        this.fWp = (RelativeLayout) this.fBM.findViewById(d.g.sub_pb_body_layout);
        this.avj = (BdListView) this.fBM.findViewById(d.g.new_sub_pb_list);
        this.fWz = (ThreadSkinView) LayoutInflater.from(this.fWo.getPageContext().getPageActivity()).inflate(d.h.thread_skin_layout, (ViewGroup) null);
        this.avj.addHeaderView(this.fWz);
        this.avj.addHeaderView(this.fWm);
        this.drS = BdListViewHelper.a(this.fWo.getActivity(), this.avj, BdListViewHelper.HeadType.DEFAULT);
        this.fWn = new d(this.fWo.getPageContext().getPageActivity());
        this.fWn.H(this.fFa);
        this.fWn.setIsFromCDN(this.mIsFromCDN);
        this.fWn.kU(true);
        this.avj.setAdapter((ListAdapter) this.fWn);
        this.fWA = new e(this.fWo.getPageContext());
        this.fWD = this.fWA.getView();
        this.avj.setNextPage(this.fWA);
        this.fWA.setOnClickListener(this.mCommonClickListener);
        this.avj.setOnItemClickListener(this.fWP);
        this.avj.setOnTouchListener(this.bJG);
        this.mProgress = (ProgressBar) this.fBM.findViewById(d.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fWm != null) {
            this.fWm.setVisibility(4);
        }
        if (this.fWp != null) {
            this.fWp.setVisibility(4);
        }
        this.fWt = com.baidu.tbadk.ala.b.uY().t(this.fWo.getActivity(), 4);
        if (this.fWt != null) {
            this.fWt.setVisibility(8);
            this.fWr.addView(this.fWt, 3);
        }
    }

    public ListView getListView() {
        return this.avj;
    }

    public void beP() {
        this.fWr = (LinearLayout) this.fWm.findViewById(d.g.subpb_head_user_info_root);
        this.fWr.setOnClickListener(this.mCommonClickListener);
        this.fWs = (HeadImageView) this.fWm.findViewById(d.g.photo);
        this.fWs.setRadius(l.s(this.fWo.getActivity(), d.e.ds30));
        this.fWs.setClickable(false);
        this.fQC = (ClickableHeaderImageView) this.fWm.findViewById(d.g.god_user_photo);
        this.fQC.setGodIconMargin(0);
        this.fQC.setGodIconWidth(d.e.ds24);
        this.fQC.setRadius(l.s(this.fWo.getActivity(), d.e.ds30));
        this.fQC.setClickable(false);
        this.bdf = (TextView) this.fWm.findViewById(d.g.user_name);
        this.fWu = (ImageView) this.fWm.findViewById(d.g.user_rank);
        this.fWu.setVisibility(8);
        this.fQu = (TextView) this.fWm.findViewById(d.g.floor_owner);
        this.fWq = (TextView) this.fWm.findViewById(d.g.see_subject);
        this.fWq.setOnClickListener(this.mCommonClickListener);
        this.fWv = (TextView) this.fWm.findViewById(d.g.floor);
        this.fFs = (TextView) this.fWm.findViewById(d.g.time);
        this.fWw = (EllipsizeRichTextView) this.fWm.findViewById(d.g.content_text);
        this.fWw.setOnClickListener(this.mCommonClickListener);
        aj.r(this.fWw, d.C0107d.cp_cont_b);
        this.fWw.setLinkTextColor(aj.getColor(d.C0107d.cp_link_tip_c));
        this.fWw.setLineSpacing(0.0f, 1.25f);
        this.fWx = (TbImageView) this.fWm.findViewById(d.g.sub_pb_image);
        this.fWx.setOnClickListener(this.mCommonClickListener);
        this.fWy = (TextView) this.fWm.findViewById(d.g.advert);
        this.cTY = (PlayVoiceBntNew) this.fWm.findViewById(d.g.voice_btn);
        this.fWm.setOnTouchListener(this.bJG);
        this.fWm.setOnClickListener(this.mCommonClickListener);
    }

    public void fZ(boolean z) {
        if (this.drS != null && this.drS.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.drS.getLayoutParams();
            if (z) {
                axs();
                layoutParams.height = l.s(this.fWo.getPageContext().getPageActivity(), d.e.ds88);
            } else {
                layoutParams.height = l.s(this.fWo.getPageContext().getPageActivity(), d.e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.drS.setLayoutParams(layoutParams);
        }
    }

    private void axs() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public View axt() {
        return this.drS;
    }

    public void axo() {
        int s = l.s(this.fWo.getPageContext().getPageActivity(), d.e.ds88);
        int s2 = l.s(this.fWo.getPageContext().getPageActivity(), d.e.ds14);
        this.mNavigationBar = (NavigationBar) this.fBM.findViewById(d.g.view_navigation_bar);
        this.beJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.beJ.getLayoutParams();
            layoutParams.height = s;
            layoutParams.width = s;
            layoutParams.leftMargin = s2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.beJ != null && (this.beJ.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.beJ.getLayoutParams();
            layoutParams2.width = s;
            layoutParams2.height = s;
            this.beJ.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar aup() {
        return this.mNavigationBar;
    }

    public void cz(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.fRa == null) {
            this.fRa = new Dialog(this.fWo.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fRa.setCanceledOnTouchOutside(true);
            this.fRa.setCancelable(true);
            View inflate = LayoutInflater.from(this.fWo.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
            this.fWo.getLayoutMode().aM(inflate);
            this.fRa.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.fRa.getWindow().getAttributes();
            attributes.width = (int) (l.ao(this.fWo.getPageContext().getPageActivity()) * 0.9d);
            this.fRa.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fRa.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fRa.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fRa.findViewById(d.g.disable_reply_btn);
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
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.fRa != null && (c.this.fRa instanceof Dialog)) {
                        g.b(c.this.fRa, c.this.fWo.getPageContext());
                    }
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null) {
                        c.this.a(((Integer) sparseArray3.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray3.get(d.g.tag_del_post_id), ((Integer) sparseArray3.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(d.g.tag_forbid_user_name))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(d.g.tag_forbid_user_name, sparseArray.get(d.g.tag_forbid_user_name));
            sparseArray3.put(d.g.tag_manage_user_identity, sparseArray.get(d.g.tag_manage_user_identity));
            sparseArray3.put(d.g.tag_forbid_user_post_id, sparseArray.get(d.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.fRa != null && (c.this.fRa instanceof Dialog)) {
                        g.b(c.this.fRa, c.this.fWo.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && c.this.fWE != null) {
                        c.this.fWE.ak(new Object[]{sparseArray4.get(d.g.tag_manage_user_identity), sparseArray4.get(d.g.tag_forbid_user_name), sparseArray4.get(d.g.tag_forbid_user_post_id)});
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
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.fRa != null && (c.this.fRa instanceof Dialog)) {
                        g.b(c.this.fRa, c.this.fWo.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        c.this.fWo.a(z, (String) sparseArray5.get(d.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.fRa, this.fWo.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        final SparseArray sparseArray = new SparseArray();
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
        this.fRc = new com.baidu.tbadk.core.dialog.a(this.fWo.getPageContext().getPageActivity());
        this.fRc.fb(i3);
        this.fRc.aE(sparseArray);
        this.fRc.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (c.this.fWF != null) {
                    c.this.fWF.ak(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.fRc.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fRc.aV(true);
        this.fRc.b(this.fWo.getPageContext());
        this.fRc.AA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fX(final boolean z) {
        if (this.avj != null) {
            if (!z) {
                this.avj.setEnabled(z);
            } else {
                this.avj.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.c.8
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.avj.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void b(b.InterfaceC0073b interfaceC0073b, boolean z) {
        String string;
        if (this.fRl != null) {
            this.fRl.dismiss();
            this.fRl = null;
        }
        if (z) {
            string = this.fWo.getResources().getString(d.j.remove_mark);
        } else {
            string = this.fWo.getResources().getString(d.j.mark);
        }
        this.fRl = new com.baidu.tbadk.core.dialog.b(this.fWo.getPageContext().getPageActivity());
        this.fRl.fe(d.j.operation);
        this.fRl.a(new String[]{this.fWo.getResources().getString(d.j.copy), string}, interfaceC0073b);
        this.fRl.d(this.fWo.getPageContext());
        this.fRl.AD();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.fWE = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.fWF = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.fWo.showToast(this.fWo.getResources().getString(d.j.delete_success));
        } else if (str != null && z2) {
            this.fWo.showToast(str);
        }
    }

    public void bR(View view) {
        if (this.drS != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.drS.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.avj != null) {
                    this.avj.removeHeaderView(this.drS);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.drS.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.s(this.fWo.getActivity(), d.e.ds98)));
            } else if (this.avj != null) {
                this.avj.addHeaderView(this.drS, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(com.baidu.tbadk.editortools.pb.h hVar) {
        if (hVar != null && hVar.Ku() != null) {
            this.eOI = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.fBM.addView(hVar.Ku(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.fWf = bVar;
    }

    public void beQ() {
        if (this.avj != null) {
            this.fWO = this.avj.getLastVisiblePosition();
        }
    }

    public void beR() {
        if (this.fVR != null) {
            if ((!beU() && this.fWD != null && this.fWD.isShown()) || v.E(this.fWH)) {
                this.fVR.kX(false);
            } else {
                this.fVR.kX(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.fVR = subPbModel;
    }

    public void beS() {
        a(this.fWo);
        this.avj.setNextPage(this.fWA);
    }

    public void n(PostData postData) {
        int i;
        if (postData != null) {
            postData.my(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!beU() && this.fWD != null && this.fWD.isShown()) {
                i = (this.fWO - this.fWN) - 1;
            } else {
                i = this.fWO - this.fWN;
            }
            int D = v.D(this.fWH);
            if (i > D) {
                i = D;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(v.b(this.fWH, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.fWn.setDatas(arrayList);
            this.fWn.notifyDataSetChanged();
            this.avj.smoothScrollToPosition(this.fWO + 2);
            this.avj.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.avj.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.avj.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.fBM;
    }

    public void bdO() {
        if (this.fWB != null) {
            g.a(this.fWB, this.fWo.getPageContext().getPageActivity());
        }
        if (this.fRl != null) {
            this.fRl.dismiss();
        }
        if (this.fRc != null) {
            this.fRc.dismiss();
        }
        if (this.fRa != null) {
            g.b(this.fRa, this.fWo.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.fHF != null) {
            this.fHF.dismiss();
        }
    }

    public void beT() {
        this.avj.setNextPage(this.fWA);
        this.fWA.DK();
    }

    public void jD(boolean z) {
        this.fEV = z;
    }

    public void setIsFromPb(boolean z) {
        this.bqx = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(m mVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (mVar != null) {
            if (this.bqx && this.fWm != null) {
                this.fWn.kV(true);
                this.fWm.setVisibility(8);
                this.avj.removeHeaderView(this.fWm);
                this.fWN = 1;
            }
            this.fUM = mVar;
            this.fWn.Q(this.fUM.VK());
            if (this.fWm != null) {
                this.fWm.setVisibility(0);
            }
            if (this.fWp != null) {
                this.fWp.setVisibility(0);
            }
            if (mVar.aZt() != null) {
                this.fWG = mVar.aZt().getId();
                this.bIJ = mVar.aZt().bvH();
                if (this.bIJ > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.fWo.getResources().getString(d.j.subpb_floor_reply_count), com.baidu.tbadk.core.util.am.H(mVar.getTotalCount())));
                    this.dMZ.setText(d.j.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.fWo.beO()) {
                    str = "PB";
                }
                if (mVar.aZt().zo() != null) {
                    this.fWz.a(this.fWo.getPageContext(), mVar.aZt().zo(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", mVar.aZA().getId(), mVar.aZA().getName(), mVar.VK().getId(), str));
                } else {
                    this.fWz.a(null, null, null);
                }
            }
            if (mVar.hasMore()) {
                this.fWA.DK();
                this.fWn.setHasMoreData(true);
            } else {
                this.fWA.DL();
                this.fWn.setHasMoreData(false);
            }
            this.fWH = mVar.aZx();
            if (v.E(this.fWH)) {
                this.avj.setNextPage(null);
                if (this.bqx) {
                    this.dNa.setVisibility(0);
                }
            } else {
                this.avj.setNextPage(this.fWA);
                if (this.bqx) {
                    this.dNa.setVisibility(8);
                }
            }
            if (this.fWH == null || this.fWH.size() <= fWl) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.fWH.size() - fWl;
                tg(size);
                int firstVisiblePosition = this.avj.getFirstVisiblePosition() - size;
                View childAt = this.avj.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.fWn.setDatas(this.fWH);
            boolean z2 = false;
            if (mVar.VK() != null && mVar.VK().yS() != null && (userId = mVar.VK().yS().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.fWn.J(i, z2);
            this.fWn.notifyDataSetChanged();
            a(mVar.aZt(), mVar.aJJ(), mVar.vk(), i, z);
            if (i4 > 0) {
                this.avj.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void tg(int i) {
        if (this.fWH != null) {
            if (this.fWH.size() <= i) {
                this.fWH.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.fWH.iterator();
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

    public boolean beU() {
        return this.fWn.dcP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.bqx) {
            this.fEp = postData;
            if (!StringUtils.isNull(postData.bvP())) {
                this.fWx.setVisibility(0);
                this.fWx.startLoad(postData.bvP(), 10, true);
            } else {
                this.fWx.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.h bvR = postData.bvR();
            if (bvR != null && bvR.gXO) {
                this.fWy.setVisibility(0);
            } else {
                this.fWy.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.fWm.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.fWm.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.fWv.setText((CharSequence) null);
            this.bdf.setText((CharSequence) null);
            this.fQu.setVisibility(8);
            if (!this.bqx) {
                c(postData.yS());
                if (z) {
                    this.fQu.setVisibility(0);
                    aj.r(this.fQu, d.C0107d.cp_link_tip_a);
                }
            }
            this.fFs.setText(com.baidu.tbadk.core.util.am.z(postData.getTime()));
            this.fWv.setText(String.format(this.fWo.getPageContext().getString(d.j.is_floor), Integer.valueOf(postData.bvH())));
            postData.yS().getUserTbVipInfoData();
            boolean a = a(this.fWw, postData.bvK());
            if (StringUtils.isNull(postData.bvP()) && !a && postData.QJ() != null) {
                this.cTY.setVisibility(0);
                this.cTY.setTag(postData.QJ());
                return;
            }
            this.cTY.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.aX(metaData.getSealPrefix()) + 2 : 0) + w.hb(name_show) > 14) {
                name_show = w.j(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.bdf.setText(af(metaData.getSealPrefix(), name_show));
            } else {
                this.bdf.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.fWt != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.fWt.setVisibility(8);
                } else {
                    this.fWt.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.aFI = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.fWt.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.fQC.setVisibility(0);
                this.fWs.setVisibility(8);
                this.fQC.setUserId(metaData.getUserId());
                this.fQC.setUserName(metaData.getUserName());
                this.fQC.startLoad(metaData.getPortrait(), 28, false);
                aj.r(this.bdf, d.C0107d.cp_cont_r);
            } else {
                this.fQC.setVisibility(8);
                this.fWs.setVisibility(0);
                this.fWs.setUserId(metaData.getUserId());
                this.fWs.setUserName(metaData.getUserName());
                this.fWs.setDefaultResource(d.f.transparent_bg);
                this.fWs.setDefaultErrorResource(d.f.icon_default_avatar100);
                this.fWs.startLoad(metaData.getPortrait(), 28, false);
                aj.r(this.bdf, d.C0107d.cp_cont_c);
            }
            this.fWr.setTag(d.g.tag_user_id, metaData.getUserId());
            this.fWr.setTag(d.g.tag_user_name, metaData.getUserName());
            this.fWr.setTag(d.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.QB() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.QB().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.QI());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.cI(true);
                        textView.setMovementMethod(com.baidu.tieba.view.e.bDU());
                        continue;
                    case 17:
                        String str = next.QM().mGifInfo.mSharpText;
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
        if (!tbRichTextData.QR()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.QI() == null || tbRichTextData.QI().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.QI());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fWo.getPageContext().getString(d.j.refresh_view_title_text), this.aGO));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.fWo.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.fWp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.f.pic_emotion07, l.s(pageActivity, d.e.ds250), l.s(pageActivity, d.e.ds480), l.s(pageActivity, d.e.ds360)), dVar, a);
        }
        this.fWp.setVisibility(0);
        this.avj.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.eOI.Lp();
        aj.t(this.mNoDataView, d.C0107d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.fWo.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void jP(int i) {
        b(NoDataViewFactory.d.aC(i, d.j.refresh_view_title_text));
        if (this.fWf != null) {
            this.fWf.cC(this.fBM);
        }
        this.fWJ.setVisibility(8);
    }

    public void lA(String str) {
        b(NoDataViewFactory.d.ae(str, this.fWo.getPageContext().getString(d.j.refresh_view_title_text)));
        if (this.fWf != null) {
            this.fWf.cC(this.fBM);
        }
        this.fWJ.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.avj.setVisibility(0);
            this.fWJ.setVisibility(0);
            this.fBM.setOnTouchListener(null);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.aGO = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0202  */
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
                String userId2 = postData.yS().getUserId();
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
            if (this.fUM != null && this.fUM.VK() != null && this.fUM.VK().yS() != null && postData.yS() != null) {
                String userId3 = this.fUM.VK().yS().getUserId();
                String userId4 = postData.yS().getUserId();
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
                    userId = postData.yS().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.bvH() != 1 ? 0 : 1;
                    if (ar.k(postData)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(d.g.tag_forbid_user_name, postData.yS().getUserName());
                        sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(d.g.tag_forbid_user_name, "");
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
                        sparseArray.put(d.g.tag_forbid_user_name, postData.yS().getUserName());
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.yS() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.yS().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.yS().getUserName());
                        }
                        if (this.fUM.VK() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fUM.VK().getId());
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
            userId = postData.yS().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.bvH() != 1) {
            }
            if (ar.k(postData)) {
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

    public void kT(boolean z) {
        if (this.fHF != null && this.fHF.bcr() != null) {
            if (z) {
                this.fHF.bcr().setText(d.j.remove_mark);
            } else {
                this.fHF.bcr().setText(d.j.mark);
            }
            this.fHF.refreshUI();
        }
    }

    public View beV() {
        return this.fWD;
    }

    public void onChangeSkinType(int i) {
        this.fWo.getLayoutMode().aM(i == 1);
        this.fWo.getLayoutMode().aM(this.fBM);
        this.fWo.getLayoutMode().aM(this.fWm);
        this.mNavigationBar.onChangeSkinType(this.fWo.getPageContext(), i);
        if (this.fWq != null) {
            aj.r(this.fWq, d.C0107d.goto_see_subject_color);
        }
        aj.r(this.dNa, d.C0107d.cp_cont_d);
        this.dxK.onChangeSkinType(this.fWo.getPageContext(), i);
        this.fWo.getLayoutMode().aM(this.fWD);
        aj.r(this.fWw, d.C0107d.cp_cont_b);
        this.fWw.setLinkTextColor(aj.getColor(d.C0107d.cp_link_tip_c));
        if (this.eOI != null && this.eOI.Ku() != null) {
            this.eOI.Ku().onChangeSkinType(i);
        }
        this.fWA.gv(i);
        this.cTY.bnf();
        aj.r(this.dMZ, d.C0107d.cp_cont_e);
        aj.r(this.fQu, d.C0107d.cp_link_tip_a);
        aj.r(this.bdf, d.C0107d.cp_cont_c);
        this.dMZ.setAlpha(0.95f);
        if (this.fWn != null) {
            this.fWn.notifyDataSetChanged();
        }
    }

    public void beW() {
        this.mProgress.setVisibility(0);
    }

    public void beX() {
        this.avj.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fWA.DL();
    }

    public void arA() {
        this.avj.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fWA.arA();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bnd = onLongClickListener;
        this.fWm.setOnLongClickListener(this.bnd);
    }

    public View beY() {
        return this.fWm;
    }

    public TextView axu() {
        return this.dMZ;
    }

    public ImageView beZ() {
        return this.fWK;
    }

    public ImageView bfa() {
        return this.fWL;
    }

    public void qs(String str) {
        int qt = this.fWn.qt(str);
        if (qt > -1) {
            this.fWn.th(qt);
            if (qt > 2) {
                this.avj.setSelection(qt - 2);
            } else {
                this.avj.setSelection(qt);
            }
            this.avj.invalidate();
        }
    }

    public View bfb() {
        return this.fWq;
    }

    public View bfc() {
        return this.fWx;
    }

    public MorePopupWindow bfd() {
        return this.fWB;
    }

    public void showLoadingDialog() {
        if (this.ddw == null) {
            this.ddw = new com.baidu.tbadk.core.view.b(this.fWo.getPageContext());
        }
        this.ddw.bm(true);
    }

    public void aeY() {
        if (this.ddw != null) {
            this.ddw.bm(false);
        }
    }

    public TextView bfe() {
        return this.fWw;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.fVV = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fVW = hVar;
    }

    public y bff() {
        return this.fHF;
    }

    public void awy() {
    }

    public void awz() {
    }

    public void onActivityDestroy() {
    }

    public void bfg() {
        if (this.fWo.isPaused()) {
        }
    }

    public View bfh() {
        return this.fWr;
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.k.a((Context) this.fWo.getActivity(), str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
