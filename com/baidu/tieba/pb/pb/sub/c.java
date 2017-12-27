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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.editortools.pb.h;
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
    private static final int fUL = TbadkCoreApplication.getInst().getListItemRule().FC();
    private BdListView avk;
    private com.baidu.tbadk.core.view.b cYR;
    private TextView dIx;
    private TextView dIy;
    private View dnr;
    private NoNetworkView dtk;
    private RelativeLayout fAm;
    private y fGf;
    private m fTm;
    private b fUF;
    private View fUM;
    private d fUN;
    private NewSubPbActivity fUO;
    private RelativeLayout fUP;
    private View fUT;
    private ThreadSkinView fUZ;
    private SubPbModel fUr;
    private e fVa;
    private View fVd;
    private ArrayList<PostData> fVh;
    private String fVi;
    private RelativeLayout fVj;
    private ImageView fVk;
    private ImageView fVl;
    private View.OnClickListener mCommonClickListener;
    private ProgressBar mProgress;
    private g mNoDataView = null;
    private TbRichTextView.h fUw = null;
    private View.OnClickListener aGQ = null;
    private TbRichTextView.i fUv = null;
    private NavigationBar mNavigationBar = null;
    private View beD = null;
    private TextView fUQ = null;
    private LinearLayout fUR = null;
    private HeadImageView fUS = null;
    private ClickableHeaderImageView fPc = null;
    private TextView bcZ = null;
    private ImageView fUU = null;
    private TextView fOU = null;
    private TextView fUV = null;
    private TextView fDS = null;
    private EllipsizeRichTextView fUW = null;
    private TbImageView fUX = null;
    private PlayVoiceBntNew cPw = null;
    private TextView fUY = null;
    private MorePopupWindow fVb = null;
    private am fVc = null;
    private com.baidu.tbadk.core.dialog.b fPL = null;
    private Dialog fPA = null;
    private com.baidu.tbadk.core.dialog.a fPC = null;
    private boolean fDv = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener bmU = null;
    private NewSubPbActivity.a fVe = null;
    private NewSubPbActivity.a fVf = null;
    private h eNj = null;
    private String fVg = null;
    private int bIB = 0;
    private PostData fCP = null;
    private int fVm = 0;
    private int fVn = 2;
    private int fVo = 0;
    private boolean bqo = true;
    private View.OnClickListener fDA = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (!com.baidu.tieba.c.a.aiU() || !com.baidu.tieba.c.a.b(c.this.fUO.getBaseContext(), c.this.fUO.getThreadId(), c.this.fUO.getPostId(), c.this.fUO.aYN())) {
                        if (booleanValue2) {
                            sparseArray.put(d.g.tag_from, 1);
                            c.this.fUO.c(sparseArray);
                            return;
                        }
                        c.this.cx(view);
                    }
                } else if (booleanValue2) {
                    sparseArray.put(d.g.tag_from, 0);
                    c.this.fUO.c(sparseArray);
                } else if (booleanValue3) {
                    c.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c bJy = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.c.2
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            c.this.fT(false);
            c.this.bP(view);
            c.this.fT(true);
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
    protected AdapterView.OnItemClickListener fVp = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.9
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ax.be(c.this.fUO.getPageContext().getPageActivity())) {
                if (c.this.fUF != null) {
                    c.this.fUF.awd();
                }
                c.this.beM();
                if (view == null || !(view.getTag() instanceof d.a)) {
                    PostData postData = (PostData) v.f(c.this.fVh, i);
                    if (postData == null) {
                        c.this.fVi = null;
                    } else {
                        c.this.fVi = postData.getId();
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(d.g.tag_photo_username);
                        String str2 = (String) sparseArray.get(d.g.tag_photo_userid);
                        if (str != null) {
                            c.this.eNj.setReplyId(str2);
                            c.this.eNj.gn(str);
                        }
                    }
                    c.this.beN();
                    return;
                }
                c.this.beO();
                c.this.fUr.bfj();
            }
        }
    };

    public c(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.fAm = null;
        this.fUM = null;
        this.avk = null;
        this.fUN = null;
        this.fUO = null;
        this.dtk = null;
        this.fUP = null;
        this.dIy = null;
        this.fUT = null;
        this.fVa = null;
        this.fVd = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.dIx = null;
        this.fVj = null;
        this.fVk = null;
        this.fVl = null;
        this.fUO = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.fAm = (RelativeLayout) LayoutInflater.from(this.fUO.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_layout, (ViewGroup) null);
        this.fUM = LayoutInflater.from(this.fUO.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_head, (ViewGroup) null);
        this.dIy = (TextView) this.fAm.findViewById(d.g.no_reply_list_view);
        this.fVj = (RelativeLayout) this.fAm.findViewById(d.g.subpb_editor_tool_comment);
        this.dIx = (TextView) this.fAm.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.dIx.setOnClickListener(this.mCommonClickListener);
        this.fVk = (ImageView) this.fAm.findViewById(d.g.subpb_editor_tool_more_img);
        this.fVl = (ImageView) this.fAm.findViewById(d.g.subpb_editor_tool_emotion_img);
        this.fVl.setOnClickListener(this.mCommonClickListener);
        this.fVk.setOnClickListener(this.mCommonClickListener);
        this.dtk = (NoNetworkView) this.fAm.findViewById(d.g.view_no_network);
        awl();
        beL();
        this.fUP = (RelativeLayout) this.fAm.findViewById(d.g.sub_pb_body_layout);
        this.avk = (BdListView) this.fAm.findViewById(d.g.new_sub_pb_list);
        this.fUZ = (ThreadSkinView) LayoutInflater.from(this.fUO.getPageContext().getPageActivity()).inflate(d.h.thread_skin_layout, (ViewGroup) null);
        this.avk.addHeaderView(this.fUZ);
        this.avk.addHeaderView(this.fUM);
        this.dnr = BdListViewHelper.a(this.fUO.getActivity(), this.avk, BdListViewHelper.HeadType.DEFAULT);
        this.fUN = new d(this.fUO.getPageContext().getPageActivity());
        this.fUN.G(this.fDA);
        this.fUN.setIsFromCDN(this.mIsFromCDN);
        this.fUN.kR(true);
        this.avk.setAdapter((ListAdapter) this.fUN);
        this.fVa = new e(this.fUO.getPageContext());
        this.fVd = this.fVa.getView();
        this.avk.setNextPage(this.fVa);
        this.fVa.setOnClickListener(this.mCommonClickListener);
        this.avk.setOnItemClickListener(this.fVp);
        this.avk.setOnTouchListener(this.bJy);
        this.mProgress = (ProgressBar) this.fAm.findViewById(d.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fUM != null) {
            this.fUM.setVisibility(4);
        }
        if (this.fUP != null) {
            this.fUP.setVisibility(4);
        }
        this.fUT = com.baidu.tbadk.ala.b.uY().t(this.fUO.getActivity(), 4);
        if (this.fUT != null) {
            this.fUT.setVisibility(8);
            this.fUR.addView(this.fUT, 3);
        }
    }

    public ListView getListView() {
        return this.avk;
    }

    public void beL() {
        this.fUR = (LinearLayout) this.fUM.findViewById(d.g.subpb_head_user_info_root);
        this.fUR.setOnClickListener(this.mCommonClickListener);
        this.fUS = (HeadImageView) this.fUM.findViewById(d.g.photo);
        this.fUS.setRadius(l.s(this.fUO.getActivity(), d.e.ds30));
        this.fUS.setClickable(false);
        this.fPc = (ClickableHeaderImageView) this.fUM.findViewById(d.g.god_user_photo);
        this.fPc.setGodIconMargin(0);
        this.fPc.setGodIconWidth(d.e.ds24);
        this.fPc.setRadius(l.s(this.fUO.getActivity(), d.e.ds30));
        this.fPc.setClickable(false);
        this.bcZ = (TextView) this.fUM.findViewById(d.g.user_name);
        this.fUU = (ImageView) this.fUM.findViewById(d.g.user_rank);
        this.fUU.setVisibility(8);
        this.fOU = (TextView) this.fUM.findViewById(d.g.floor_owner);
        this.fUQ = (TextView) this.fUM.findViewById(d.g.see_subject);
        this.fUQ.setOnClickListener(this.mCommonClickListener);
        this.fUV = (TextView) this.fUM.findViewById(d.g.floor);
        this.fDS = (TextView) this.fUM.findViewById(d.g.time);
        this.fUW = (EllipsizeRichTextView) this.fUM.findViewById(d.g.content_text);
        this.fUW.setOnClickListener(this.mCommonClickListener);
        aj.r(this.fUW, d.C0108d.cp_cont_b);
        this.fUW.setLinkTextColor(aj.getColor(d.C0108d.cp_link_tip_c));
        this.fUW.setLineSpacing(0.0f, 1.25f);
        this.fUX = (TbImageView) this.fUM.findViewById(d.g.sub_pb_image);
        this.fUX.setOnClickListener(this.mCommonClickListener);
        this.fUY = (TextView) this.fUM.findViewById(d.g.advert);
        this.cPw = (PlayVoiceBntNew) this.fUM.findViewById(d.g.voice_btn);
        this.fUM.setOnTouchListener(this.bJy);
        this.fUM.setOnClickListener(this.mCommonClickListener);
    }

    public void fV(boolean z) {
        if (this.dnr != null && this.dnr.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.dnr.getLayoutParams();
            if (z) {
                awp();
                layoutParams.height = l.s(this.fUO.getPageContext().getPageActivity(), d.e.ds88);
            } else {
                layoutParams.height = l.s(this.fUO.getPageContext().getPageActivity(), d.e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.dnr.setLayoutParams(layoutParams);
        }
    }

    private void awp() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public View awq() {
        return this.dnr;
    }

    public void awl() {
        int s = l.s(this.fUO.getPageContext().getPageActivity(), d.e.ds88);
        int s2 = l.s(this.fUO.getPageContext().getPageActivity(), d.e.ds14);
        this.mNavigationBar = (NavigationBar) this.fAm.findViewById(d.g.view_navigation_bar);
        this.beD = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.beD.getLayoutParams();
            layoutParams.height = s;
            layoutParams.width = s;
            layoutParams.leftMargin = s2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.beD != null && (this.beD.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.beD.getLayoutParams();
            layoutParams2.width = s;
            layoutParams2.height = s;
            this.beD.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar atm() {
        return this.mNavigationBar;
    }

    public void cx(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.fPA == null) {
            this.fPA = new Dialog(this.fUO.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fPA.setCanceledOnTouchOutside(true);
            this.fPA.setCancelable(true);
            View inflate = LayoutInflater.from(this.fUO.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
            this.fUO.getLayoutMode().aM(inflate);
            this.fPA.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.fPA.getWindow().getAttributes();
            attributes.width = (int) (l.ao(this.fUO.getPageContext().getPageActivity()) * 0.9d);
            this.fPA.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fPA.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fPA.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fPA.findViewById(d.g.disable_reply_btn);
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
                    if (c.this.fPA != null && (c.this.fPA instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(c.this.fPA, c.this.fUO.getPageContext());
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
                    if (c.this.fPA != null && (c.this.fPA instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(c.this.fPA, c.this.fUO.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && c.this.fVe != null) {
                        c.this.fVe.ak(new Object[]{sparseArray4.get(d.g.tag_manage_user_identity), sparseArray4.get(d.g.tag_forbid_user_name), sparseArray4.get(d.g.tag_forbid_user_post_id)});
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
                    if (c.this.fPA != null && (c.this.fPA instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(c.this.fPA, c.this.fUO.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        c.this.fUO.a(z, (String) sparseArray5.get(d.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fPA, this.fUO.getPageContext());
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
        this.fPC = new com.baidu.tbadk.core.dialog.a(this.fUO.getPageContext().getPageActivity());
        this.fPC.fd(i3);
        this.fPC.aE(sparseArray);
        this.fPC.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (c.this.fVf != null) {
                    c.this.fVf.ak(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.fPC.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fPC.aV(true);
        this.fPC.b(this.fUO.getPageContext());
        this.fPC.AI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fT(final boolean z) {
        if (this.avk != null) {
            if (!z) {
                this.avk.setEnabled(z);
            } else {
                this.avk.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.c.8
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.avk.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void b(b.InterfaceC0074b interfaceC0074b, boolean z) {
        String string;
        if (this.fPL != null) {
            this.fPL.dismiss();
            this.fPL = null;
        }
        if (z) {
            string = this.fUO.getResources().getString(d.j.remove_mark);
        } else {
            string = this.fUO.getResources().getString(d.j.mark);
        }
        this.fPL = new com.baidu.tbadk.core.dialog.b(this.fUO.getPageContext().getPageActivity());
        this.fPL.fg(d.j.operation);
        this.fPL.a(new String[]{this.fUO.getResources().getString(d.j.copy), string}, interfaceC0074b);
        this.fPL.d(this.fUO.getPageContext());
        this.fPL.AL();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.fVe = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.fVf = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.fUO.showToast(this.fUO.getResources().getString(d.j.delete_success));
        } else if (str != null && z2) {
            this.fUO.showToast(str);
        }
    }

    public void bP(View view) {
        if (this.dnr != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dnr.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.avk != null) {
                    this.avk.removeHeaderView(this.dnr);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.dnr.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.s(this.fUO.getActivity(), d.e.ds98)));
            } else if (this.avk != null) {
                this.avk.addHeaderView(this.dnr, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(h hVar) {
        if (hVar != null && hVar.KF() != null) {
            this.eNj = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.fAm.addView(hVar.KF(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.fUF = bVar;
    }

    public void beM() {
        if (this.avk != null) {
            this.fVo = this.avk.getLastVisiblePosition();
        }
    }

    public void beN() {
        if (this.fUr != null) {
            if ((!beQ() && this.fVd != null && this.fVd.isShown()) || v.G(this.fVh)) {
                this.fUr.kU(false);
            } else {
                this.fUr.kU(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.fUr = subPbModel;
    }

    public void beO() {
        a(this.fUO);
        this.avk.setNextPage(this.fVa);
    }

    public void n(PostData postData) {
        int i;
        if (postData != null) {
            postData.nw(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!beQ() && this.fVd != null && this.fVd.isShown()) {
                i = (this.fVo - this.fVn) - 1;
            } else {
                i = this.fVo - this.fVn;
            }
            int F = v.F(this.fVh);
            if (i > F) {
                i = F;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(v.b(this.fVh, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.fUN.setDatas(arrayList);
            this.fUN.notifyDataSetChanged();
            this.avk.smoothScrollToPosition(this.fVo + 2);
            this.avk.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.avk.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.avk.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.fAm;
    }

    public void bdK() {
        if (this.fVb != null) {
            com.baidu.adp.lib.g.g.a(this.fVb, this.fUO.getPageContext().getPageActivity());
        }
        if (this.fPL != null) {
            this.fPL.dismiss();
        }
        if (this.fPC != null) {
            this.fPC.dismiss();
        }
        if (this.fPA != null) {
            com.baidu.adp.lib.g.g.b(this.fPA, this.fUO.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.fGf != null) {
            this.fGf.dismiss();
        }
    }

    public void beP() {
        this.avk.setNextPage(this.fVa);
        this.fVa.DT();
    }

    public void jA(boolean z) {
        this.fDv = z;
    }

    public void setIsFromPb(boolean z) {
        this.bqo = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(m mVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (mVar != null) {
            if (this.bqo && this.fUM != null) {
                this.fUN.kS(true);
                this.fUM.setVisibility(8);
                this.avk.removeHeaderView(this.fUM);
                this.fVn = 1;
            }
            this.fTm = mVar;
            this.fUN.Q(this.fTm.VW());
            if (this.fUM != null) {
                this.fUM.setVisibility(0);
            }
            if (this.fUP != null) {
                this.fUP.setVisibility(0);
            }
            if (mVar.aZp() != null) {
                this.fVg = mVar.aZp().getId();
                this.bIB = mVar.aZp().bCl();
                if (this.bIB > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.fUO.getResources().getString(d.j.subpb_floor_reply_count), com.baidu.tbadk.core.util.am.G(mVar.getTotalCount())));
                    this.dIx.setText(d.j.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.fUO.beK()) {
                    str = "PB";
                }
                if (mVar.aZp().zt() != null) {
                    this.fUZ.a(this.fUO.getPageContext(), mVar.aZp().zt(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", mVar.aZw().getId(), mVar.aZw().getName(), mVar.VW().getId(), str));
                } else {
                    this.fUZ.a(null, null, null);
                }
            }
            if (mVar.hasMore()) {
                this.fVa.DT();
                this.fUN.setHasMoreData(true);
            } else {
                this.fVa.DU();
                this.fUN.setHasMoreData(false);
            }
            this.fVh = mVar.aZt();
            if (v.G(this.fVh)) {
                this.avk.setNextPage(null);
                if (this.bqo) {
                    this.dIy.setVisibility(0);
                }
            } else {
                this.avk.setNextPage(this.fVa);
                if (this.bqo) {
                    this.dIy.setVisibility(8);
                }
            }
            if (this.fVh == null || this.fVh.size() <= fUL) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.fVh.size() - fUL;
                to(size);
                int firstVisiblePosition = this.avk.getFirstVisiblePosition() - size;
                View childAt = this.avk.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.fUN.setDatas(this.fVh);
            boolean z2 = false;
            if (mVar.VW() != null && mVar.VW().yX() != null && (userId = mVar.VW().yX().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.fUN.J(i, z2);
            this.fUN.notifyDataSetChanged();
            a(mVar.aZp(), mVar.aJE(), mVar.vk(), i, z);
            if (i4 > 0) {
                this.avk.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void to(int i) {
        if (this.fVh != null) {
            if (this.fVh.size() <= i) {
                this.fVh.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.fVh.iterator();
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

    public boolean beQ() {
        return this.fUN.cYl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.bqo) {
            this.fCP = postData;
            if (!StringUtils.isNull(postData.bCt())) {
                this.fUX.setVisibility(0);
                this.fUX.startLoad(postData.bCt(), 10, true);
            } else {
                this.fUX.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.h bCv = postData.bCv();
            if (bCv != null && bCv.hio) {
                this.fUY.setVisibility(0);
            } else {
                this.fUY.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.fUM.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.fUM.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.fUV.setText((CharSequence) null);
            this.bcZ.setText((CharSequence) null);
            this.fOU.setVisibility(8);
            if (!this.bqo) {
                c(postData.yX());
                if (z) {
                    this.fOU.setVisibility(0);
                    aj.r(this.fOU, d.C0108d.cp_link_tip_a);
                }
            }
            this.fDS.setText(com.baidu.tbadk.core.util.am.z(postData.getTime()));
            this.fUV.setText(String.format(this.fUO.getPageContext().getString(d.j.is_floor), Integer.valueOf(postData.bCl())));
            postData.yX().getUserTbVipInfoData();
            boolean a = a(this.fUW, postData.bCo());
            if (StringUtils.isNull(postData.bCt()) && !a && postData.QV() != null) {
                this.cPw.setVisibility(0);
                this.cPw.setTag(postData.QV());
                return;
            }
            this.cPw.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.aX(metaData.getSealPrefix()) + 2 : 0) + w.ha(name_show) > 14) {
                name_show = w.j(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.bcZ.setText(af(metaData.getSealPrefix(), name_show));
            } else {
                this.bcZ.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.fUT != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.fUT.setVisibility(8);
                } else {
                    this.fUT.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.aFJ = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.fUT.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.fPc.setVisibility(0);
                this.fUS.setVisibility(8);
                this.fPc.setUserId(metaData.getUserId());
                this.fPc.setUserName(metaData.getUserName());
                this.fPc.startLoad(metaData.getPortrait(), 28, false);
                aj.r(this.bcZ, d.C0108d.cp_cont_r);
            } else {
                this.fPc.setVisibility(8);
                this.fUS.setVisibility(0);
                this.fUS.setUserId(metaData.getUserId());
                this.fUS.setUserName(metaData.getUserName());
                this.fUS.setDefaultResource(d.f.transparent_bg);
                this.fUS.setDefaultErrorResource(d.f.icon_default_avatar100);
                this.fUS.startLoad(metaData.getPortrait(), 28, false);
                aj.r(this.bcZ, d.C0108d.cp_cont_c);
            }
            this.fUR.setTag(d.g.tag_user_id, metaData.getUserId());
            this.fUR.setTag(d.g.tag_user_name, metaData.getUserName());
            this.fUR.setTag(d.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.QN() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.QN().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.QU());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.cK(true);
                        textView.setMovementMethod(com.baidu.tieba.view.e.bKu());
                        continue;
                    case 17:
                        String str = next.QY().mGifInfo.mSharpText;
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
        if (!tbRichTextData.Rd()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.QU() == null || tbRichTextData.QU().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.QU());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fUO.getPageContext().getString(d.j.refresh_view_title_text), this.aGQ));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.fUO.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.fUP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.f.pic_emotion07, l.s(pageActivity, d.e.ds250), l.s(pageActivity, d.e.ds480), l.s(pageActivity, d.e.ds360)), dVar, a);
        }
        this.fUP.setVisibility(0);
        this.avk.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.eNj.LB();
        aj.t(this.mNoDataView, d.C0108d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.fUO.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void jT(int i) {
        b(NoDataViewFactory.d.aC(i, d.j.refresh_view_title_text));
        if (this.fUF != null) {
            this.fUF.cA(this.fAm);
        }
        this.fVj.setVisibility(8);
    }

    public void ls(String str) {
        b(NoDataViewFactory.d.ae(str, this.fUO.getPageContext().getString(d.j.refresh_view_title_text)));
        if (this.fUF != null) {
            this.fUF.cA(this.fAm);
        }
        this.fVj.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.avk.setVisibility(0);
            this.fVj.setVisibility(0);
            this.fAm.setOnTouchListener(null);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.aGQ = onClickListener;
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
                String userId2 = postData.yX().getUserId();
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
            if (this.fTm != null && this.fTm.VW() != null && this.fTm.VW().yX() != null && postData.yX() != null) {
                String userId3 = this.fTm.VW().yX().getUserId();
                String userId4 = postData.yX().getUserId();
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
                    userId = postData.yX().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.bCl() != 1 ? 0 : 1;
                    if (ar.k(postData)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(d.g.tag_forbid_user_name, postData.yX().getUserName());
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
                        sparseArray.put(d.g.tag_forbid_user_name, postData.yX().getUserName());
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.yX() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.yX().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.yX().getUserName());
                        }
                        if (this.fTm.VW() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fTm.VW().getId());
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
            userId = postData.yX().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.bCl() != 1) {
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

    public void kQ(boolean z) {
        if (this.fGf != null && this.fGf.bcn() != null) {
            if (z) {
                this.fGf.bcn().setText(d.j.remove_mark);
            } else {
                this.fGf.bcn().setText(d.j.mark);
            }
            this.fGf.refreshUI();
        }
    }

    public View beR() {
        return this.fVd;
    }

    public void onChangeSkinType(int i) {
        this.fUO.getLayoutMode().aM(i == 1);
        this.fUO.getLayoutMode().aM(this.fAm);
        this.fUO.getLayoutMode().aM(this.fUM);
        this.mNavigationBar.onChangeSkinType(this.fUO.getPageContext(), i);
        if (this.fUQ != null) {
            aj.r(this.fUQ, d.C0108d.goto_see_subject_color);
        }
        aj.r(this.dIy, d.C0108d.cp_cont_d);
        this.dtk.onChangeSkinType(this.fUO.getPageContext(), i);
        this.fUO.getLayoutMode().aM(this.fVd);
        aj.r(this.fUW, d.C0108d.cp_cont_b);
        this.fUW.setLinkTextColor(aj.getColor(d.C0108d.cp_link_tip_c));
        if (this.eNj != null && this.eNj.KF() != null) {
            this.eNj.KF().onChangeSkinType(i);
        }
        this.fVa.gy(i);
        this.cPw.btM();
        aj.r(this.dIx, d.C0108d.cp_cont_e);
        aj.r(this.fOU, d.C0108d.cp_link_tip_a);
        aj.r(this.bcZ, d.C0108d.cp_cont_c);
        this.dIx.setAlpha(0.95f);
        if (this.fUN != null) {
            this.fUN.notifyDataSetChanged();
        }
    }

    public void beS() {
        this.mProgress.setVisibility(0);
    }

    public void beT() {
        this.avk.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fVa.DU();
    }

    public void aqx() {
        this.avk.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fVa.aqx();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bmU = onLongClickListener;
        this.fUM.setOnLongClickListener(this.bmU);
    }

    public View beU() {
        return this.fUM;
    }

    public TextView awr() {
        return this.dIx;
    }

    public ImageView beV() {
        return this.fVk;
    }

    public ImageView beW() {
        return this.fVl;
    }

    public void qq(String str) {
        int qr = this.fUN.qr(str);
        if (qr > -1) {
            this.fUN.tp(qr);
            if (qr > 2) {
                this.avk.setSelection(qr - 2);
            } else {
                this.avk.setSelection(qr);
            }
            this.avk.invalidate();
        }
    }

    public View beX() {
        return this.fUQ;
    }

    public View beY() {
        return this.fUX;
    }

    public MorePopupWindow beZ() {
        return this.fVb;
    }

    public void showLoadingDialog() {
        if (this.cYR == null) {
            this.cYR = new com.baidu.tbadk.core.view.b(this.fUO.getPageContext());
        }
        this.cYR.bm(true);
    }

    public void afk() {
        if (this.cYR != null) {
            this.cYR.bm(false);
        }
    }

    public TextView bfa() {
        return this.fUW;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.fUv = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fUw = hVar;
    }

    public y bfb() {
        return this.fGf;
    }

    public void avv() {
    }

    public void avw() {
    }

    public void onActivityDestroy() {
    }

    public void bfc() {
        if (this.fUO.isPaused()) {
        }
    }

    public View bfd() {
        return this.fUR;
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.k.a((Context) this.fUO.getActivity(), str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
