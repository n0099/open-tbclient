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
    private static final int fWG = TbadkCoreApplication.getInst().getListItemRule().Fv();
    private BdListView avm;
    private TextView dNu;
    private TextView dNv;
    private com.baidu.tbadk.core.view.b ddR;
    private View dsn;
    private NoNetworkView dyf;
    private RelativeLayout fCh;
    private y fIa;
    private m fVh;
    private b fWA;
    private View fWH;
    private d fWI;
    private NewSubPbActivity fWJ;
    private RelativeLayout fWK;
    private View fWO;
    private ThreadSkinView fWU;
    private e fWV;
    private View fWY;
    private SubPbModel fWm;
    private ArrayList<PostData> fXc;
    private String fXd;
    private RelativeLayout fXe;
    private ImageView fXf;
    private ImageView fXg;
    private View.OnClickListener mCommonClickListener;
    private ProgressBar mProgress;
    private h mNoDataView = null;
    private TbRichTextView.h fWr = null;
    private View.OnClickListener aGR = null;
    private TbRichTextView.i fWq = null;
    private NavigationBar mNavigationBar = null;
    private View beR = null;
    private TextView fWL = null;
    private LinearLayout fWM = null;
    private HeadImageView fWN = null;
    private ClickableHeaderImageView fQX = null;
    private TextView bdn = null;
    private ImageView fWP = null;
    private TextView fQP = null;
    private TextView fWQ = null;
    private TextView fFN = null;
    private EllipsizeRichTextView fWR = null;
    private TbImageView fWS = null;
    private PlayVoiceBntNew cUt = null;
    private TextView fWT = null;
    private MorePopupWindow fWW = null;
    private am fWX = null;
    private com.baidu.tbadk.core.dialog.b fRG = null;
    private Dialog fRv = null;
    private com.baidu.tbadk.core.dialog.a fRx = null;
    private boolean fFq = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener bnm = null;
    private NewSubPbActivity.a fWZ = null;
    private NewSubPbActivity.a fXa = null;
    private com.baidu.tbadk.editortools.pb.h ePd = null;
    private String fXb = null;
    private int bIR = 0;
    private PostData fEK = null;
    private int fXh = 0;
    private int fXi = 2;
    private int fXj = 0;
    private boolean bqG = true;
    private View.OnClickListener fFv = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (!com.baidu.tieba.c.a.akc() || !com.baidu.tieba.c.a.b(c.this.fWJ.getBaseContext(), c.this.fWJ.getThreadId(), c.this.fWJ.getPostId(), c.this.fWJ.aYX())) {
                        if (booleanValue2) {
                            sparseArray.put(d.g.tag_from, 1);
                            c.this.fWJ.c(sparseArray);
                            return;
                        }
                        c.this.cz(view);
                    }
                } else if (booleanValue2) {
                    sparseArray.put(d.g.tag_from, 0);
                    c.this.fWJ.c(sparseArray);
                } else if (booleanValue3) {
                    c.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c bJO = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.c.2
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            c.this.fZ(false);
            c.this.bR(view);
            c.this.fZ(true);
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
    protected AdapterView.OnItemClickListener fXk = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.9
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ax.bb(c.this.fWJ.getPageContext().getPageActivity())) {
                if (c.this.fWA != null) {
                    c.this.fWA.axl();
                }
                c.this.beV();
                if (view == null || !(view.getTag() instanceof d.a)) {
                    PostData postData = (PostData) v.f(c.this.fXc, i);
                    if (postData == null) {
                        c.this.fXd = null;
                    } else {
                        c.this.fXd = postData.getId();
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(d.g.tag_photo_username);
                        String str2 = (String) sparseArray.get(d.g.tag_photo_userid);
                        if (str != null) {
                            c.this.ePd.setReplyId(str2);
                            c.this.ePd.gw(str);
                        }
                    }
                    c.this.beW();
                    return;
                }
                c.this.beX();
                c.this.fWm.bfs();
            }
        }
    };

    public c(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.fCh = null;
        this.fWH = null;
        this.avm = null;
        this.fWI = null;
        this.fWJ = null;
        this.dyf = null;
        this.fWK = null;
        this.dNv = null;
        this.fWO = null;
        this.fWV = null;
        this.fWY = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.dNu = null;
        this.fXe = null;
        this.fXf = null;
        this.fXg = null;
        this.fWJ = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.fCh = (RelativeLayout) LayoutInflater.from(this.fWJ.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_layout, (ViewGroup) null);
        this.fWH = LayoutInflater.from(this.fWJ.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_head, (ViewGroup) null);
        this.dNv = (TextView) this.fCh.findViewById(d.g.no_reply_list_view);
        this.fXe = (RelativeLayout) this.fCh.findViewById(d.g.subpb_editor_tool_comment);
        this.dNu = (TextView) this.fCh.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.dNu.setOnClickListener(this.mCommonClickListener);
        this.fXf = (ImageView) this.fCh.findViewById(d.g.subpb_editor_tool_more_img);
        this.fXg = (ImageView) this.fCh.findViewById(d.g.subpb_editor_tool_emotion_img);
        this.fXg.setOnClickListener(this.mCommonClickListener);
        this.fXf.setOnClickListener(this.mCommonClickListener);
        this.dyf = (NoNetworkView) this.fCh.findViewById(d.g.view_no_network);
        axt();
        beU();
        this.fWK = (RelativeLayout) this.fCh.findViewById(d.g.sub_pb_body_layout);
        this.avm = (BdListView) this.fCh.findViewById(d.g.new_sub_pb_list);
        this.fWU = (ThreadSkinView) LayoutInflater.from(this.fWJ.getPageContext().getPageActivity()).inflate(d.h.thread_skin_layout, (ViewGroup) null);
        this.avm.addHeaderView(this.fWU);
        this.avm.addHeaderView(this.fWH);
        this.dsn = BdListViewHelper.a(this.fWJ.getActivity(), this.avm, BdListViewHelper.HeadType.DEFAULT);
        this.fWI = new d(this.fWJ.getPageContext().getPageActivity());
        this.fWI.H(this.fFv);
        this.fWI.setIsFromCDN(this.mIsFromCDN);
        this.fWI.kW(true);
        this.avm.setAdapter((ListAdapter) this.fWI);
        this.fWV = new e(this.fWJ.getPageContext());
        this.fWY = this.fWV.getView();
        this.avm.setNextPage(this.fWV);
        this.fWV.setOnClickListener(this.mCommonClickListener);
        this.avm.setOnItemClickListener(this.fXk);
        this.avm.setOnTouchListener(this.bJO);
        this.mProgress = (ProgressBar) this.fCh.findViewById(d.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fWH != null) {
            this.fWH.setVisibility(4);
        }
        if (this.fWK != null) {
            this.fWK.setVisibility(4);
        }
        this.fWO = com.baidu.tbadk.ala.b.uZ().t(this.fWJ.getActivity(), 4);
        if (this.fWO != null) {
            this.fWO.setVisibility(8);
            this.fWM.addView(this.fWO, 3);
        }
    }

    public ListView getListView() {
        return this.avm;
    }

    public void beU() {
        this.fWM = (LinearLayout) this.fWH.findViewById(d.g.subpb_head_user_info_root);
        this.fWM.setOnClickListener(this.mCommonClickListener);
        this.fWN = (HeadImageView) this.fWH.findViewById(d.g.photo);
        this.fWN.setRadius(l.s(this.fWJ.getActivity(), d.e.ds30));
        this.fWN.setClickable(false);
        this.fQX = (ClickableHeaderImageView) this.fWH.findViewById(d.g.god_user_photo);
        this.fQX.setGodIconMargin(0);
        this.fQX.setGodIconWidth(d.e.ds24);
        this.fQX.setRadius(l.s(this.fWJ.getActivity(), d.e.ds30));
        this.fQX.setClickable(false);
        this.bdn = (TextView) this.fWH.findViewById(d.g.user_name);
        this.fWP = (ImageView) this.fWH.findViewById(d.g.user_rank);
        this.fWP.setVisibility(8);
        this.fQP = (TextView) this.fWH.findViewById(d.g.floor_owner);
        this.fWL = (TextView) this.fWH.findViewById(d.g.see_subject);
        this.fWL.setOnClickListener(this.mCommonClickListener);
        this.fWQ = (TextView) this.fWH.findViewById(d.g.floor);
        this.fFN = (TextView) this.fWH.findViewById(d.g.time);
        this.fWR = (EllipsizeRichTextView) this.fWH.findViewById(d.g.content_text);
        this.fWR.setOnClickListener(this.mCommonClickListener);
        aj.r(this.fWR, d.C0108d.cp_cont_b);
        this.fWR.setLinkTextColor(aj.getColor(d.C0108d.cp_link_tip_c));
        this.fWR.setLineSpacing(0.0f, 1.25f);
        this.fWS = (TbImageView) this.fWH.findViewById(d.g.sub_pb_image);
        this.fWS.setOnClickListener(this.mCommonClickListener);
        this.fWT = (TextView) this.fWH.findViewById(d.g.advert);
        this.cUt = (PlayVoiceBntNew) this.fWH.findViewById(d.g.voice_btn);
        this.fWH.setOnTouchListener(this.bJO);
        this.fWH.setOnClickListener(this.mCommonClickListener);
    }

    public void gb(boolean z) {
        if (this.dsn != null && this.dsn.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.dsn.getLayoutParams();
            if (z) {
                axx();
                layoutParams.height = l.s(this.fWJ.getPageContext().getPageActivity(), d.e.ds88);
            } else {
                layoutParams.height = l.s(this.fWJ.getPageContext().getPageActivity(), d.e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.dsn.setLayoutParams(layoutParams);
        }
    }

    private void axx() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public View axy() {
        return this.dsn;
    }

    public void axt() {
        int s = l.s(this.fWJ.getPageContext().getPageActivity(), d.e.ds88);
        int s2 = l.s(this.fWJ.getPageContext().getPageActivity(), d.e.ds14);
        this.mNavigationBar = (NavigationBar) this.fCh.findViewById(d.g.view_navigation_bar);
        this.beR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.beR.getLayoutParams();
            layoutParams.height = s;
            layoutParams.width = s;
            layoutParams.leftMargin = s2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.beR != null && (this.beR.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.beR.getLayoutParams();
            layoutParams2.width = s;
            layoutParams2.height = s;
            this.beR.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar auu() {
        return this.mNavigationBar;
    }

    public void cz(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.fRv == null) {
            this.fRv = new Dialog(this.fWJ.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fRv.setCanceledOnTouchOutside(true);
            this.fRv.setCancelable(true);
            View inflate = LayoutInflater.from(this.fWJ.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
            this.fWJ.getLayoutMode().aM(inflate);
            this.fRv.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.fRv.getWindow().getAttributes();
            attributes.width = (int) (l.ao(this.fWJ.getPageContext().getPageActivity()) * 0.9d);
            this.fRv.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fRv.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fRv.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fRv.findViewById(d.g.disable_reply_btn);
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
                    if (c.this.fRv != null && (c.this.fRv instanceof Dialog)) {
                        g.b(c.this.fRv, c.this.fWJ.getPageContext());
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
                    if (c.this.fRv != null && (c.this.fRv instanceof Dialog)) {
                        g.b(c.this.fRv, c.this.fWJ.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && c.this.fWZ != null) {
                        c.this.fWZ.ak(new Object[]{sparseArray4.get(d.g.tag_manage_user_identity), sparseArray4.get(d.g.tag_forbid_user_name), sparseArray4.get(d.g.tag_forbid_user_post_id)});
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
                    if (c.this.fRv != null && (c.this.fRv instanceof Dialog)) {
                        g.b(c.this.fRv, c.this.fWJ.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        c.this.fWJ.a(z, (String) sparseArray5.get(d.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.fRv, this.fWJ.getPageContext());
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
        this.fRx = new com.baidu.tbadk.core.dialog.a(this.fWJ.getPageContext().getPageActivity());
        this.fRx.fb(i3);
        this.fRx.aE(sparseArray);
        this.fRx.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (c.this.fXa != null) {
                    c.this.fXa.ak(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.fRx.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fRx.aW(true);
        this.fRx.b(this.fWJ.getPageContext());
        this.fRx.AB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fZ(final boolean z) {
        if (this.avm != null) {
            if (!z) {
                this.avm.setEnabled(z);
            } else {
                this.avm.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.c.8
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.avm.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void b(b.InterfaceC0073b interfaceC0073b, boolean z) {
        String string;
        if (this.fRG != null) {
            this.fRG.dismiss();
            this.fRG = null;
        }
        if (z) {
            string = this.fWJ.getResources().getString(d.j.remove_mark);
        } else {
            string = this.fWJ.getResources().getString(d.j.mark);
        }
        this.fRG = new com.baidu.tbadk.core.dialog.b(this.fWJ.getPageContext().getPageActivity());
        this.fRG.fe(d.j.operation);
        this.fRG.a(new String[]{this.fWJ.getResources().getString(d.j.copy), string}, interfaceC0073b);
        this.fRG.d(this.fWJ.getPageContext());
        this.fRG.AE();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.fWZ = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.fXa = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.fWJ.showToast(this.fWJ.getResources().getString(d.j.delete_success));
        } else if (str != null && z2) {
            this.fWJ.showToast(str);
        }
    }

    public void bR(View view) {
        if (this.dsn != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dsn.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.avm != null) {
                    this.avm.removeHeaderView(this.dsn);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.dsn.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.s(this.fWJ.getActivity(), d.e.ds98)));
            } else if (this.avm != null) {
                this.avm.addHeaderView(this.dsn, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(com.baidu.tbadk.editortools.pb.h hVar) {
        if (hVar != null && hVar.Kw() != null) {
            this.ePd = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.fCh.addView(hVar.Kw(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.fWA = bVar;
    }

    public void beV() {
        if (this.avm != null) {
            this.fXj = this.avm.getLastVisiblePosition();
        }
    }

    public void beW() {
        if (this.fWm != null) {
            if ((!beZ() && this.fWY != null && this.fWY.isShown()) || v.E(this.fXc)) {
                this.fWm.kZ(false);
            } else {
                this.fWm.kZ(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.fWm = subPbModel;
    }

    public void beX() {
        a(this.fWJ);
        this.avm.setNextPage(this.fWV);
    }

    public void n(PostData postData) {
        int i;
        if (postData != null) {
            postData.mA(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!beZ() && this.fWY != null && this.fWY.isShown()) {
                i = (this.fXj - this.fXi) - 1;
            } else {
                i = this.fXj - this.fXi;
            }
            int D = v.D(this.fXc);
            if (i > D) {
                i = D;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(v.b(this.fXc, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.fWI.setDatas(arrayList);
            this.fWI.notifyDataSetChanged();
            this.avm.smoothScrollToPosition(this.fXj + 2);
            this.avm.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.avm.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.avm.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.fCh;
    }

    public void bdT() {
        if (this.fWW != null) {
            g.a(this.fWW, this.fWJ.getPageContext().getPageActivity());
        }
        if (this.fRG != null) {
            this.fRG.dismiss();
        }
        if (this.fRx != null) {
            this.fRx.dismiss();
        }
        if (this.fRv != null) {
            g.b(this.fRv, this.fWJ.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.fIa != null) {
            this.fIa.dismiss();
        }
    }

    public void beY() {
        this.avm.setNextPage(this.fWV);
        this.fWV.DM();
    }

    public void jF(boolean z) {
        this.fFq = z;
    }

    public void setIsFromPb(boolean z) {
        this.bqG = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(m mVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (mVar != null) {
            if (this.bqG && this.fWH != null) {
                this.fWI.kX(true);
                this.fWH.setVisibility(8);
                this.avm.removeHeaderView(this.fWH);
                this.fXi = 1;
            }
            this.fVh = mVar;
            this.fWI.Q(this.fVh.VM());
            if (this.fWH != null) {
                this.fWH.setVisibility(0);
            }
            if (this.fWK != null) {
                this.fWK.setVisibility(0);
            }
            if (mVar.aZy() != null) {
                this.fXb = mVar.aZy().getId();
                this.bIR = mVar.aZy().bvJ();
                if (this.bIR > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.fWJ.getResources().getString(d.j.subpb_floor_reply_count), com.baidu.tbadk.core.util.am.H(mVar.getTotalCount())));
                    this.dNu.setText(d.j.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.fWJ.beT()) {
                    str = "PB";
                }
                if (mVar.aZy().zp() != null) {
                    this.fWU.a(this.fWJ.getPageContext(), mVar.aZy().zp(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", mVar.aZF().getId(), mVar.aZF().getName(), mVar.VM().getId(), str));
                } else {
                    this.fWU.a(null, null, null);
                }
            }
            if (mVar.hasMore()) {
                this.fWV.DM();
                this.fWI.setHasMoreData(true);
            } else {
                this.fWV.DN();
                this.fWI.setHasMoreData(false);
            }
            this.fXc = mVar.aZC();
            if (v.E(this.fXc)) {
                this.avm.setNextPage(null);
                if (this.bqG) {
                    this.dNv.setVisibility(0);
                }
            } else {
                this.avm.setNextPage(this.fWV);
                if (this.bqG) {
                    this.dNv.setVisibility(8);
                }
            }
            if (this.fXc == null || this.fXc.size() <= fWG) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.fXc.size() - fWG;
                tg(size);
                int firstVisiblePosition = this.avm.getFirstVisiblePosition() - size;
                View childAt = this.avm.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.fWI.setDatas(this.fXc);
            boolean z2 = false;
            if (mVar.VM() != null && mVar.VM().yT() != null && (userId = mVar.VM().yT().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.fWI.J(i, z2);
            this.fWI.notifyDataSetChanged();
            a(mVar.aZy(), mVar.aJO(), mVar.vl(), i, z);
            if (i4 > 0) {
                this.avm.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void tg(int i) {
        if (this.fXc != null) {
            if (this.fXc.size() <= i) {
                this.fXc.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.fXc.iterator();
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

    public boolean beZ() {
        return this.fWI.ddk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.bqG) {
            this.fEK = postData;
            if (!StringUtils.isNull(postData.bvR())) {
                this.fWS.setVisibility(0);
                this.fWS.startLoad(postData.bvR(), 10, true);
            } else {
                this.fWS.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.h bvT = postData.bvT();
            if (bvT != null && bvT.gYi) {
                this.fWT.setVisibility(0);
            } else {
                this.fWT.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.fWH.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.fWH.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.fWQ.setText((CharSequence) null);
            this.bdn.setText((CharSequence) null);
            this.fQP.setVisibility(8);
            if (!this.bqG) {
                c(postData.yT());
                if (z) {
                    this.fQP.setVisibility(0);
                    aj.r(this.fQP, d.C0108d.cp_link_tip_a);
                }
            }
            this.fFN.setText(com.baidu.tbadk.core.util.am.z(postData.getTime()));
            this.fWQ.setText(String.format(this.fWJ.getPageContext().getString(d.j.is_floor), Integer.valueOf(postData.bvJ())));
            postData.yT().getUserTbVipInfoData();
            boolean a = a(this.fWR, postData.bvM());
            if (StringUtils.isNull(postData.bvR()) && !a && postData.QL() != null) {
                this.cUt.setVisibility(0);
                this.cUt.setTag(postData.QL());
                return;
            }
            this.cUt.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.aX(metaData.getSealPrefix()) + 2 : 0) + w.hi(name_show) > 14) {
                name_show = w.j(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.bdn.setText(ae(metaData.getSealPrefix(), name_show));
            } else {
                this.bdn.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.fWO != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.fWO.setVisibility(8);
                } else {
                    this.fWO.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.aFL = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.fWO.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.fQX.setVisibility(0);
                this.fWN.setVisibility(8);
                this.fQX.setUserId(metaData.getUserId());
                this.fQX.setUserName(metaData.getUserName());
                this.fQX.startLoad(metaData.getPortrait(), 28, false);
                aj.r(this.bdn, d.C0108d.cp_cont_r);
            } else {
                this.fQX.setVisibility(8);
                this.fWN.setVisibility(0);
                this.fWN.setUserId(metaData.getUserId());
                this.fWN.setUserName(metaData.getUserName());
                this.fWN.setDefaultResource(d.f.transparent_bg);
                this.fWN.setDefaultErrorResource(d.f.icon_default_avatar100);
                this.fWN.startLoad(metaData.getPortrait(), 28, false);
                aj.r(this.bdn, d.C0108d.cp_cont_c);
            }
            this.fWM.setTag(d.g.tag_user_id, metaData.getUserId());
            this.fWM.setTag(d.g.tag_user_name, metaData.getUserName());
            this.fWM.setTag(d.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.QD() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.QD().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.QK());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.cJ(true);
                        textView.setMovementMethod(com.baidu.tieba.view.e.bDW());
                        continue;
                    case 17:
                        String str = next.QO().mGifInfo.mSharpText;
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
        if (!tbRichTextData.QT()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.QK() == null || tbRichTextData.QK().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.QK());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fWJ.getPageContext().getString(d.j.refresh_view_title_text), this.aGR));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.fWJ.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.fWK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.f.pic_emotion07, l.s(pageActivity, d.e.ds250), l.s(pageActivity, d.e.ds480), l.s(pageActivity, d.e.ds360)), dVar, a);
        }
        this.fWK.setVisibility(0);
        this.avm.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.ePd.Lr();
        aj.t(this.mNoDataView, d.C0108d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.fWJ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void jP(int i) {
        b(NoDataViewFactory.d.aC(i, d.j.refresh_view_title_text));
        if (this.fWA != null) {
            this.fWA.cC(this.fCh);
        }
        this.fXe.setVisibility(8);
    }

    public void lH(String str) {
        b(NoDataViewFactory.d.ad(str, this.fWJ.getPageContext().getString(d.j.refresh_view_title_text)));
        if (this.fWA != null) {
            this.fWA.cC(this.fCh);
        }
        this.fXe.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.avm.setVisibility(0);
            this.fXe.setVisibility(0);
            this.fCh.setOnTouchListener(null);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.aGR = onClickListener;
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
                String userId2 = postData.yT().getUserId();
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
            if (this.fVh != null && this.fVh.VM() != null && this.fVh.VM().yT() != null && postData.yT() != null) {
                String userId3 = this.fVh.VM().yT().getUserId();
                String userId4 = postData.yT().getUserId();
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
                    userId = postData.yT().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.bvJ() != 1 ? 0 : 1;
                    if (ar.k(postData)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(d.g.tag_forbid_user_name, postData.yT().getUserName());
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
                        sparseArray.put(d.g.tag_forbid_user_name, postData.yT().getUserName());
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.yT() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.yT().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.yT().getUserName());
                        }
                        if (this.fVh.VM() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fVh.VM().getId());
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
            userId = postData.yT().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.bvJ() != 1) {
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

    public void kV(boolean z) {
        if (this.fIa != null && this.fIa.bcw() != null) {
            if (z) {
                this.fIa.bcw().setText(d.j.remove_mark);
            } else {
                this.fIa.bcw().setText(d.j.mark);
            }
            this.fIa.refreshUI();
        }
    }

    public View bfa() {
        return this.fWY;
    }

    public void onChangeSkinType(int i) {
        this.fWJ.getLayoutMode().aN(i == 1);
        this.fWJ.getLayoutMode().aM(this.fCh);
        this.fWJ.getLayoutMode().aM(this.fWH);
        this.mNavigationBar.onChangeSkinType(this.fWJ.getPageContext(), i);
        if (this.fWL != null) {
            aj.r(this.fWL, d.C0108d.goto_see_subject_color);
        }
        aj.r(this.dNv, d.C0108d.cp_cont_d);
        this.dyf.onChangeSkinType(this.fWJ.getPageContext(), i);
        this.fWJ.getLayoutMode().aM(this.fWY);
        aj.r(this.fWR, d.C0108d.cp_cont_b);
        this.fWR.setLinkTextColor(aj.getColor(d.C0108d.cp_link_tip_c));
        if (this.ePd != null && this.ePd.Kw() != null) {
            this.ePd.Kw().onChangeSkinType(i);
        }
        this.fWV.gv(i);
        this.cUt.bng();
        aj.r(this.dNu, d.C0108d.cp_cont_e);
        aj.r(this.fQP, d.C0108d.cp_link_tip_a);
        aj.r(this.bdn, d.C0108d.cp_cont_c);
        this.dNu.setAlpha(0.95f);
        if (this.fWI != null) {
            this.fWI.notifyDataSetChanged();
        }
    }

    public void bfb() {
        this.mProgress.setVisibility(0);
    }

    public void bfc() {
        this.avm.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fWV.DN();
    }

    public void arF() {
        this.avm.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fWV.arF();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bnm = onLongClickListener;
        this.fWH.setOnLongClickListener(this.bnm);
    }

    public View bfd() {
        return this.fWH;
    }

    public TextView axz() {
        return this.dNu;
    }

    public ImageView bfe() {
        return this.fXf;
    }

    public ImageView bff() {
        return this.fXg;
    }

    public void qz(String str) {
        int qA = this.fWI.qA(str);
        if (qA > -1) {
            this.fWI.th(qA);
            if (qA > 2) {
                this.avm.setSelection(qA - 2);
            } else {
                this.avm.setSelection(qA);
            }
            this.avm.invalidate();
        }
    }

    public View bfg() {
        return this.fWL;
    }

    public View bfh() {
        return this.fWS;
    }

    public MorePopupWindow bfi() {
        return this.fWW;
    }

    public void showLoadingDialog() {
        if (this.ddR == null) {
            this.ddR = new com.baidu.tbadk.core.view.b(this.fWJ.getPageContext());
        }
        this.ddR.bn(true);
    }

    public void afb() {
        if (this.ddR != null) {
            this.ddR.bn(false);
        }
    }

    public TextView bfj() {
        return this.fWR;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.fWq = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fWr = hVar;
    }

    public y bfk() {
        return this.fIa;
    }

    public void awD() {
    }

    public void awE() {
    }

    public void onActivityDestroy() {
    }

    public void bfl() {
        if (this.fWJ.isPaused()) {
        }
    }

    public View bfm() {
        return this.fWM;
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.k.a((Context) this.fWJ.getActivity(), str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
