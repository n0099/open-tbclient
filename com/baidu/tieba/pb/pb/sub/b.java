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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
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
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.main.al;
import com.baidu.tieba.pb.pb.main.ar;
import com.baidu.tieba.pb.pb.main.x;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.c;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.h;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class b implements KeyboardEventLayout.a {
    private static final int ftW = TbadkCoreApplication.getInst().getListItemRule().yE();
    private BdListView FL;
    private RelativeLayout bDv;
    private View cNI;
    private NoNetworkView cTx;
    private com.baidu.tbadk.core.view.a cym;
    private TextView dkx;
    private TextView dky;
    private x feR;
    private k fsB;
    private SubPbModel ftC;
    private a ftQ;
    private View ftX;
    private c ftY;
    private NewSubPbActivity ftZ;
    private RelativeLayout fua;
    private View fue;
    private ThreadSkinView ful;
    private d fum;
    private View fuq;
    private ArrayList<PostData> fuu;
    private String fuv;
    private RelativeLayout fuw;
    private ImageView fux;
    private ImageView fuy;
    private View.OnClickListener mCommonClickListener;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private TbRichTextView.h ftH = null;
    private View.OnClickListener Tt = null;
    private TbRichTextView.i ftG = null;
    private NavigationBar mNavigationBar = null;
    private View asg = null;
    private TextView fub = null;
    private LinearLayout fuc = null;
    private HeadImageView fud = null;
    private ClickableHeaderImageView foq = null;
    private TextView aqm = null;
    private ImageView fuf = null;
    private TextView foi = null;
    private TextView fug = null;
    private TextView fuh = null;
    private EllipsizeRichTextView fui = null;
    private TbImageView fuj = null;
    private PlayVoiceBntNew coR = null;
    private TextView fuk = null;
    private MorePopupWindow fuo = null;
    private al fup = null;
    private com.baidu.tbadk.core.dialog.b fpa = null;
    private Dialog foP = null;
    private com.baidu.tbadk.core.dialog.a foR = null;
    private boolean fgZ = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener azP = null;
    private NewSubPbActivity.a fur = null;
    private NewSubPbActivity.a fus = null;
    private g eoa = null;
    private String fut = null;
    private int aVB = 0;
    private PostData fcM = null;
    private int fuz = 0;
    private int fuA = 2;
    private int fuB = 0;
    private boolean aDj = true;
    private View.OnClickListener fhh = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray<Object> sparseArray;
            if (view2 != null && (sparseArray = (SparseArray) view2.getTag()) != null) {
                boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (!com.baidu.tieba.c.a.aeW() || !com.baidu.tieba.c.a.b(b.this.ftZ.getBaseContext(), b.this.ftZ.getThreadId(), b.this.ftZ.getPostId(), b.this.ftZ.aVE())) {
                        if (booleanValue2) {
                            sparseArray.put(d.g.tag_from, 1);
                            b.this.ftZ.b(sparseArray);
                            return;
                        }
                        b.this.be(view2);
                    }
                } else if (booleanValue2) {
                    sparseArray.put(d.g.tag_from, 0);
                    b.this.ftZ.b(sparseArray);
                } else if (booleanValue3) {
                    b.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aWx = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view2, MotionEvent motionEvent) {
            b.this.fN(false);
            b.this.av(view2);
            b.this.fN(true);
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view2, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view2, MotionEvent motionEvent) {
            return true;
        }
    });
    protected AdapterView.OnItemClickListener fuC = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.9
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            if (az.aK(b.this.ftZ.getPageContext().getPageActivity())) {
                if (b.this.ftZ.enS == null || b.this.ftC == null || b.this.ftC.aWk() == null || b.this.ftZ.enS.cJ(b.this.ftC.aWk().replyPrivateFlag)) {
                    if (b.this.ftQ != null) {
                        b.this.ftQ.asZ();
                    }
                    b.this.bbu();
                    if (view2 == null || !(view2.getTag() instanceof c.a)) {
                        PostData postData = (PostData) v.c(b.this.fuu, i);
                        if (postData == null) {
                            b.this.fuv = null;
                        } else {
                            b.this.fuv = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view2.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(d.g.tag_photo_username);
                            String str2 = (String) sparseArray.get(d.g.tag_photo_userid);
                            if (str != null) {
                                b.this.eoa.setReplyId(str2);
                                b.this.eoa.gx(str);
                            }
                        }
                        b.this.bbv();
                        return;
                    }
                    b.this.bbw();
                    b.this.ftC.bbR();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.bDv = null;
        this.ftX = null;
        this.FL = null;
        this.ftY = null;
        this.ftZ = null;
        this.cTx = null;
        this.fua = null;
        this.dky = null;
        this.fue = null;
        this.fum = null;
        this.fuq = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.dkx = null;
        this.fuw = null;
        this.fux = null;
        this.fuy = null;
        this.ftZ = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.bDv = (RelativeLayout) LayoutInflater.from(this.ftZ.getPageContext().getPageActivity()).inflate(d.i.new_sub_pb_layout, (ViewGroup) null);
        this.ftX = LayoutInflater.from(this.ftZ.getPageContext().getPageActivity()).inflate(d.i.new_sub_pb_head, (ViewGroup) null);
        this.dky = (TextView) this.bDv.findViewById(d.g.no_reply_list_view);
        this.fuw = (RelativeLayout) this.bDv.findViewById(d.g.subpb_editor_tool_comment);
        this.dkx = (TextView) this.bDv.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.dkx.setOnClickListener(this.mCommonClickListener);
        this.fux = (ImageView) this.bDv.findViewById(d.g.subpb_editor_tool_more_img);
        this.fuy = (ImageView) this.bDv.findViewById(d.g.subpb_editor_tool_emotion_img);
        this.fuy.setOnClickListener(this.mCommonClickListener);
        this.fux.setOnClickListener(this.mCommonClickListener);
        this.cTx = (NoNetworkView) this.bDv.findViewById(d.g.view_no_network);
        ath();
        bbt();
        this.fua = (RelativeLayout) this.bDv.findViewById(d.g.sub_pb_body_layout);
        this.FL = (BdListView) this.bDv.findViewById(d.g.new_sub_pb_list);
        this.ful = (ThreadSkinView) LayoutInflater.from(this.ftZ.getPageContext().getPageActivity()).inflate(d.i.thread_skin_layout, (ViewGroup) null);
        this.FL.addHeaderView(this.ful);
        this.FL.addHeaderView(this.ftX);
        this.cNI = BdListViewHelper.a(this.ftZ.getActivity(), this.FL, BdListViewHelper.HeadType.DEFAULT);
        this.ftY = new c(this.ftZ.getPageContext().getPageActivity());
        this.ftY.I(this.fhh);
        this.ftY.setIsFromCDN(this.mIsFromCDN);
        this.ftY.kH(true);
        this.FL.setAdapter((ListAdapter) this.ftY);
        this.fum = new d(this.ftZ.getPageContext());
        this.fuq = this.fum.getView();
        this.FL.setNextPage(this.fum);
        this.fum.setOnClickListener(this.mCommonClickListener);
        this.FL.setOnItemClickListener(this.fuC);
        this.FL.setOnTouchListener(this.aWx);
        this.mProgress = (ProgressBar) this.bDv.findViewById(d.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.ftX != null) {
            this.ftX.setVisibility(4);
        }
        if (this.fua != null) {
            this.fua.setVisibility(4);
        }
        this.fue = com.baidu.tbadk.ala.b.os().f(this.ftZ.getActivity(), 4);
        if (this.fue != null) {
            this.fue.setVisibility(8);
            this.fuc.addView(this.fue, 3);
        }
    }

    public ListView getListView() {
        return this.FL;
    }

    public void bbt() {
        this.fuc = (LinearLayout) this.ftX.findViewById(d.g.subpb_head_user_info_root);
        this.fuc.setOnClickListener(this.mCommonClickListener);
        this.fud = (HeadImageView) this.ftX.findViewById(d.g.photo);
        this.fud.setRadius(l.e(this.ftZ.getActivity(), d.e.ds30));
        this.fud.setClickable(false);
        this.foq = (ClickableHeaderImageView) this.ftX.findViewById(d.g.god_user_photo);
        this.foq.setGodIconMargin(0);
        this.foq.setGodIconWidth(d.e.ds24);
        this.foq.setRadius(l.e(this.ftZ.getActivity(), d.e.ds30));
        this.foq.setClickable(false);
        this.aqm = (TextView) this.ftX.findViewById(d.g.user_name);
        this.fuf = (ImageView) this.ftX.findViewById(d.g.user_rank);
        this.fuf.setVisibility(8);
        this.foi = (TextView) this.ftX.findViewById(d.g.floor_owner);
        this.fub = (TextView) this.ftX.findViewById(d.g.see_subject);
        this.fub.setOnClickListener(this.mCommonClickListener);
        this.fug = (TextView) this.ftX.findViewById(d.g.floor);
        this.fuh = (TextView) this.ftX.findViewById(d.g.time);
        this.fui = (EllipsizeRichTextView) this.ftX.findViewById(d.g.content_text);
        this.fui.setOnClickListener(this.mCommonClickListener);
        ak.h(this.fui, d.C0126d.cp_cont_b);
        this.fui.setLinkTextColor(ak.getColor(d.C0126d.cp_link_tip_c));
        this.fui.setLineSpacing(0.0f, 1.25f);
        this.fuj = (TbImageView) this.ftX.findViewById(d.g.sub_pb_image);
        this.fuj.setOnClickListener(this.mCommonClickListener);
        this.fuk = (TextView) this.ftX.findViewById(d.g.advert);
        this.coR = (PlayVoiceBntNew) this.ftX.findViewById(d.g.voice_btn);
        this.ftX.setOnTouchListener(this.aWx);
        this.ftX.setOnClickListener(this.mCommonClickListener);
    }

    public void fP(boolean z) {
        if (this.cNI != null && this.cNI.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cNI.getLayoutParams();
            if (z) {
                atl();
                layoutParams.height = l.e(this.ftZ.getPageContext().getPageActivity(), d.e.ds88);
            } else {
                layoutParams.height = l.e(this.ftZ.getPageContext().getPageActivity(), d.e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.cNI.setLayoutParams(layoutParams);
        }
    }

    private void atl() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public View atm() {
        return this.cNI;
    }

    public void ath() {
        int e = l.e(this.ftZ.getPageContext().getPageActivity(), d.e.ds88);
        int e2 = l.e(this.ftZ.getPageContext().getPageActivity(), d.e.ds14);
        this.mNavigationBar = (NavigationBar) this.bDv.findViewById(d.g.view_navigation_bar);
        this.asg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.asg.getLayoutParams();
            layoutParams.height = e;
            layoutParams.width = e;
            layoutParams.leftMargin = e2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.asg != null && (this.asg.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.asg.getLayoutParams();
            layoutParams2.width = e;
            layoutParams2.height = e;
            this.asg.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar Rg() {
        return this.mNavigationBar;
    }

    public void be(View view2) {
        SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.foP == null) {
            this.foP = new Dialog(this.ftZ.getPageContext().getPageActivity(), d.l.common_alert_dialog);
            this.foP.setCanceledOnTouchOutside(true);
            this.foP.setCancelable(true);
            View inflate = LayoutInflater.from(this.ftZ.getPageContext().getPageActivity()).inflate(d.i.forum_manage_dialog, (ViewGroup) null);
            this.ftZ.getLayoutMode().u(inflate);
            this.foP.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.foP.getWindow().getAttributes();
            attributes.width = (int) (l.af(this.ftZ.getPageContext().getPageActivity()) * 0.9d);
            this.foP.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.foP.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.foP.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.foP.findViewById(d.g.disable_reply_btn);
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
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.foP != null && (b.this.foP instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.foP, b.this.ftZ.getPageContext());
                    }
                    SparseArray sparseArray3 = (SparseArray) view2.getTag();
                    if (sparseArray3 != null) {
                        b.this.a(((Integer) sparseArray3.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray3.get(d.g.tag_del_post_id), ((Integer) sparseArray3.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(d.g.tag_del_post_is_self)).booleanValue());
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
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.foP != null && (b.this.foP instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.foP, b.this.ftZ.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view2.getTag();
                    if (sparseArray4 != null && b.this.fur != null) {
                        b.this.fur.f(new Object[]{sparseArray4.get(d.g.tag_manage_user_identity), sparseArray4.get(d.g.tag_forbid_user_name), sparseArray4.get(d.g.tag_forbid_user_post_id)});
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
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.foP != null && (b.this.foP instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.foP, b.this.ftZ.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view2.getTag();
                    if (sparseArray5 != null) {
                        b.this.ftZ.a(z, (String) sparseArray5.get(d.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.foP, this.ftZ.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        final SparseArray sparseArray = new SparseArray();
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
        this.foR = new com.baidu.tbadk.core.dialog.a(this.ftZ.getPageContext().getPageActivity());
        this.foR.bZ(i3);
        this.foR.z(sparseArray);
        this.foR.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.fus != null) {
                    b.this.fus.f(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.foR.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.foR.ar(true);
        this.foR.b(this.ftZ.getPageContext());
        this.foR.tD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fN(final boolean z) {
        if (this.FL != null) {
            if (!z) {
                this.FL.setEnabled(z);
            } else {
                this.FL.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.FL.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void b(b.InterfaceC0086b interfaceC0086b, boolean z) {
        String string;
        if (this.fpa != null) {
            this.fpa.dismiss();
            this.fpa = null;
        }
        if (z) {
            string = this.ftZ.getResources().getString(d.k.remove_mark);
        } else {
            string = this.ftZ.getResources().getString(d.k.mark);
        }
        this.fpa = new com.baidu.tbadk.core.dialog.b(this.ftZ.getPageContext().getPageActivity());
        this.fpa.cc(d.k.operation);
        this.fpa.a(new String[]{this.ftZ.getResources().getString(d.k.copy), string}, interfaceC0086b);
        this.fpa.d(this.ftZ.getPageContext());
        this.fpa.tG();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.fur = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.fus = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.ftZ.showToast(this.ftZ.getResources().getString(d.k.delete_success));
        } else if (str != null && z2) {
            this.ftZ.showToast(str);
        }
    }

    public void av(View view2) {
        if (this.cNI != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cNI.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.FL != null) {
                    this.FL.removeHeaderView(this.cNI);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.cNI.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.e(this.ftZ.getActivity(), d.e.ds98)));
            } else if (this.FL != null) {
                this.FL.addHeaderView(this.cNI, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.DF() != null) {
            this.eoa = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bDv.addView(gVar.DF(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.ftQ = aVar;
    }

    public void bbu() {
        if (this.FL != null) {
            this.fuB = this.FL.getLastVisiblePosition();
        }
    }

    public void bbv() {
        if (this.ftC != null) {
            if ((!bby() && this.fuq != null && this.fuq.isShown()) || v.w(this.fuu)) {
                this.ftC.kK(false);
            } else {
                this.ftC.kK(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.ftC = subPbModel;
    }

    public void bbw() {
        a(this.ftZ);
        this.FL.setNextPage(this.fum);
    }

    public void m(PostData postData) {
        int i;
        if (postData != null) {
            postData.mp(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bby() && this.fuq != null && this.fuq.isShown()) {
                i = (this.fuB - this.fuA) - 1;
            } else {
                i = this.fuB - this.fuA;
            }
            int v = v.v(this.fuu);
            if (i > v) {
                i = v;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(v.a(this.fuu, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.ftY.setDatas(arrayList);
            this.ftY.notifyDataSetChanged();
            this.FL.smoothScrollToPosition(this.fuB + 2);
            this.FL.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.FL.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.FL.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.bDv;
    }

    public void bar() {
        if (this.fuo != null) {
            com.baidu.adp.lib.g.g.a(this.fuo, this.ftZ.getPageContext().getPageActivity());
        }
        if (this.fpa != null) {
            this.fpa.dismiss();
        }
        if (this.foR != null) {
            this.foR.dismiss();
        }
        if (this.foP != null) {
            com.baidu.adp.lib.g.g.b(this.foP, this.ftZ.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.feR != null) {
            this.feR.dismiss();
        }
    }

    public void bbx() {
        this.FL.setNextPage(this.fum);
        this.fum.wR();
    }

    public void jq(boolean z) {
        this.fgZ = z;
    }

    public void setIsFromPb(boolean z) {
        this.aDj = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(k kVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (kVar != null) {
            if (this.aDj && this.ftX != null) {
                this.ftY.kI(true);
                this.ftX.setVisibility(8);
                this.FL.removeHeaderView(this.ftX);
                this.fuA = 1;
            }
            this.fsB = kVar;
            this.ftY.T(this.fsB.Pe());
            if (this.ftX != null) {
                this.ftX.setVisibility(0);
            }
            if (this.fua != null) {
                this.fua.setVisibility(0);
            }
            if (kVar.aWc() != null) {
                this.fut = kVar.aWc().getId();
                this.aVB = kVar.aWc().brZ();
                if (this.aVB > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.ftZ.getResources().getString(d.k.subpb_floor_reply_count), an.z(kVar.getTotalCount())));
                    this.dkx.setText(d.k.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.ftZ.bbs()) {
                    str = "PB";
                }
                if (kVar.aWc().sk() != null) {
                    this.ful.setData(this.ftZ.getPageContext(), kVar.aWc().sk(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", kVar.aWj().getId(), kVar.aWj().getName(), kVar.Pe().getId(), str));
                } else {
                    this.ful.setData(null, null, null);
                }
            }
            if (kVar.hasMore()) {
                this.fum.wR();
                this.ftY.setHasMoreData(true);
            } else {
                this.fum.wS();
                this.ftY.setHasMoreData(false);
            }
            this.fuu = kVar.aWg();
            if (v.w(this.fuu)) {
                this.FL.setNextPage(null);
                if (this.aDj) {
                    this.dky.setVisibility(0);
                }
            } else {
                this.FL.setNextPage(this.fum);
                if (this.aDj) {
                    this.dky.setVisibility(8);
                }
            }
            if (this.fuu == null || this.fuu.size() <= ftW) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.fuu.size() - ftW;
                qG(size);
                int firstVisiblePosition = this.FL.getFirstVisiblePosition() - size;
                View childAt = this.FL.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.ftY.setDatas(this.fuu);
            boolean z2 = false;
            if (kVar.Pe() != null && kVar.Pe().rQ() != null && (userId = kVar.Pe().rQ().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.ftY.B(i, z2);
            this.ftY.notifyDataSetChanged();
            a(kVar.aWc(), kVar.aGn(), kVar.oI(), i, z);
            if (i4 > 0) {
                this.FL.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void qG(int i) {
        if (this.fuu != null) {
            if (this.fuu.size() <= i) {
                this.fuu.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.fuu.iterator();
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

    public boolean bby() {
        return this.ftY.cxA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.aDj) {
            this.fcM = postData;
            if (!StringUtils.isNull(postData.bsg())) {
                this.fuj.setVisibility(0);
                this.fuj.startLoad(postData.bsg(), 10, true);
            } else {
                this.fuj.setVisibility(8);
            }
            h bsi = postData.bsi();
            if (bsi != null && bsi.gwa) {
                this.fuk.setVisibility(0);
            } else {
                this.fuk.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.ftX.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.ftX.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.fug.setText((CharSequence) null);
            this.aqm.setText((CharSequence) null);
            this.foi.setVisibility(8);
            if (!this.aDj) {
                c(postData.rQ());
                if (z) {
                    this.foi.setVisibility(0);
                    ak.h(this.foi, d.C0126d.cp_link_tip_a);
                }
            }
            this.fuh.setText(an.s(postData.getTime()));
            this.fug.setText(String.format(this.ftZ.getPageContext().getString(d.k.is_floor), Integer.valueOf(postData.brZ())));
            postData.rQ().getUserTbVipInfoData();
            boolean a = a(this.fui, postData.bsb());
            if (StringUtils.isNull(postData.bsg()) && !a && postData.JR() != null) {
                this.coR.setVisibility(0);
                this.coR.setTag(postData.JR());
                return;
            }
            this.coR.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.k.aU(metaData.getSealPrefix()) + 2 : 0) + w.hk(name_show) > 14) {
                name_show = w.k(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.aqm.setText(ag(metaData.getSealPrefix(), name_show));
            } else {
                this.aqm.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.fue != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.fue.setVisibility(8);
                } else {
                    this.fue.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.Se = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.fue.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.foq.setVisibility(0);
                this.fud.setVisibility(8);
                this.foq.setUserId(metaData.getUserId());
                this.foq.setUserName(metaData.getUserName());
                this.foq.startLoad(metaData.getPortrait(), 28, false);
                ak.h(this.aqm, d.C0126d.cp_cont_r);
            } else {
                this.foq.setVisibility(8);
                this.fud.setVisibility(0);
                this.fud.setUserId(metaData.getUserId());
                this.fud.setUserName(metaData.getUserName());
                this.fud.setDefaultResource(d.f.transparent_bg);
                this.fud.setDefaultErrorResource(d.f.icon_default_avatar100);
                this.fud.startLoad(metaData.getPortrait(), 28, false);
                ak.h(this.aqm, d.C0126d.cp_cont_c);
            }
            this.fuc.setTag(d.g.tag_user_id, metaData.getUserId());
            this.fuc.setTag(d.g.tag_user_name, metaData.getUserName());
            this.fuc.setTag(d.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.JJ() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.JJ().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.JQ());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.cf(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.bAd());
                        continue;
                    case 17:
                        String str = next.JU().mGifInfo.mSharpText;
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
        if (!tbRichTextData.JZ()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.JQ() == null || tbRichTextData.JQ().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.JQ());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.ftZ.getPageContext().getString(d.k.refresh_view_title_text), this.Tt));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.ftZ.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.fua, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.f.pic_emotion07, l.e(pageActivity, d.e.ds250), l.e(pageActivity, d.e.ds480), l.e(pageActivity, d.e.ds360)), dVar, a);
        }
        this.fua.setVisibility(0);
        this.FL.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.eoa.EA();
        ak.j(this.mNoDataView, d.C0126d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.ftZ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void ij(int i) {
        b(NoDataViewFactory.d.C(i, d.k.refresh_view_title_text));
        if (this.ftQ != null) {
            this.ftQ.bh(this.bDv);
        }
        this.fuw.setVisibility(8);
    }

    public void lW(String str) {
        b(NoDataViewFactory.d.af(str, this.ftZ.getPageContext().getString(d.k.refresh_view_title_text)));
        if (this.ftQ != null) {
            this.ftQ.bh(this.bDv);
        }
        this.fuw.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.FL.setVisibility(0);
            this.fuw.setVisibility(0);
            this.bDv.setOnTouchListener(null);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.Tt = onClickListener;
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
                String userId2 = postData.rQ().getUserId();
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
            if (this.fsB != null && this.fsB.Pe() != null && this.fsB.Pe().rQ() != null && postData.rQ() != null) {
                String userId3 = this.fsB.Pe().rQ().getUserId();
                String userId4 = postData.rQ().getUserId();
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
                    userId = postData.rQ().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.brZ() != 1 ? 0 : 1;
                    if (ar.j(postData)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(d.g.tag_forbid_user_name, postData.rQ().getUserName());
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
                        sparseArray.put(d.g.tag_forbid_user_name, postData.rQ().getUserName());
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.rQ() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.rQ().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.rQ().getUserName());
                        }
                        if (this.fsB.Pe() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fsB.Pe().getId());
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
            userId = postData.rQ().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.brZ() != 1) {
            }
            if (ar.j(postData)) {
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

    public void kG(boolean z) {
        if (this.feR != null && this.feR.aYV() != null) {
            if (z) {
                this.feR.aYV().setText(d.k.remove_mark);
            } else {
                this.feR.aYV().setText(d.k.mark);
            }
            this.feR.refreshUI();
        }
    }

    public View bbz() {
        return this.fuq;
    }

    public void onChangeSkinType(int i) {
        this.ftZ.getLayoutMode().setNightMode(i == 1);
        this.ftZ.getLayoutMode().u(this.bDv);
        this.ftZ.getLayoutMode().u(this.ftX);
        this.mNavigationBar.onChangeSkinType(this.ftZ.getPageContext(), i);
        if (this.fub != null) {
            ak.h(this.fub, d.C0126d.goto_see_subject_color);
        }
        ak.h(this.dky, d.C0126d.cp_cont_d);
        this.cTx.onChangeSkinType(this.ftZ.getPageContext(), i);
        this.ftZ.getLayoutMode().u(this.fuq);
        ak.h(this.fui, d.C0126d.cp_cont_b);
        this.fui.setLinkTextColor(ak.getColor(d.C0126d.cp_link_tip_c));
        if (this.eoa != null && this.eoa.DF() != null) {
            this.eoa.DF().onChangeSkinType(i);
        }
        this.fum.dv(i);
        this.coR.aIT();
        ak.h(this.dkx, d.C0126d.cp_cont_e);
        ak.h(this.foi, d.C0126d.cp_link_tip_a);
        ak.h(this.aqm, d.C0126d.cp_cont_c);
        this.dkx.setAlpha(0.95f);
        if (this.ftY != null) {
            this.ftY.notifyDataSetChanged();
        }
    }

    public void bbA() {
        this.mProgress.setVisibility(0);
    }

    public void bbB() {
        this.FL.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fum.wS();
    }

    public void amL() {
        this.FL.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fum.amL();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.azP = onLongClickListener;
        this.ftX.setOnLongClickListener(this.azP);
    }

    public View bbC() {
        return this.ftX;
    }

    public TextView atn() {
        return this.dkx;
    }

    public ImageView bbD() {
        return this.fux;
    }

    public ImageView bbE() {
        return this.fuy;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void qH(int i) {
    }

    public void qO(String str) {
        int qP = this.ftY.qP(str);
        if (qP > -1) {
            this.ftY.qI(qP);
            if (qP > 2) {
                this.FL.setSelection(qP - 2);
            } else {
                this.FL.setSelection(qP);
            }
            this.FL.invalidate();
        }
    }

    public View bbF() {
        return this.fub;
    }

    public View bbG() {
        return this.fuj;
    }

    public MorePopupWindow bbH() {
        return this.fuo;
    }

    public void showLoadingDialog() {
        if (this.cym == null) {
            this.cym = new com.baidu.tbadk.core.view.a(this.ftZ.getPageContext());
        }
        this.cym.aI(true);
    }

    public void aas() {
        if (this.cym != null) {
            this.cym.aI(false);
        }
    }

    public TextView bbI() {
        return this.fui;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.ftG = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.ftH = hVar;
    }

    public x bbJ() {
        return this.feR;
    }

    public void asb() {
    }

    public void asc() {
    }

    public void onActivityDestroy() {
    }

    public void bbK() {
        if (this.ftZ.isPaused()) {
        }
    }

    public View bbL() {
        return this.fuc;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, d.f.pic_smalldot_title));
            return o.a((Context) this.ftZ.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
