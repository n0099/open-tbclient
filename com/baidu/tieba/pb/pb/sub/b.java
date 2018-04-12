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
    private static final int ftZ = TbadkCoreApplication.getInst().getListItemRule().yE();
    private BdListView FL;
    private RelativeLayout bDx;
    private View cNL;
    private NoNetworkView cTA;
    private com.baidu.tbadk.core.view.a cyp;
    private TextView dkA;
    private TextView dkB;
    private x feU;
    private k fsE;
    private SubPbModel ftF;
    private a ftT;
    private ImageView fuA;
    private ImageView fuB;
    private View fua;
    private c fub;
    private NewSubPbActivity fuc;
    private RelativeLayout fud;
    private View fuh;
    private ThreadSkinView fup;
    private d fuq;
    private View fut;
    private ArrayList<PostData> fux;
    private String fuy;
    private RelativeLayout fuz;
    private View.OnClickListener mCommonClickListener;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private TbRichTextView.h ftK = null;
    private View.OnClickListener Tt = null;
    private TbRichTextView.i ftJ = null;
    private NavigationBar mNavigationBar = null;
    private View asg = null;
    private TextView fue = null;
    private LinearLayout fuf = null;
    private HeadImageView fug = null;
    private ClickableHeaderImageView fou = null;
    private TextView aqm = null;
    private ImageView fui = null;
    private TextView fol = null;
    private TextView fuj = null;
    private TextView fuk = null;
    private EllipsizeRichTextView ful = null;
    private TbImageView fum = null;
    private PlayVoiceBntNew coU = null;
    private TextView fuo = null;
    private MorePopupWindow fur = null;
    private al fus = null;
    private com.baidu.tbadk.core.dialog.b fpd = null;
    private Dialog foS = null;
    private com.baidu.tbadk.core.dialog.a foU = null;
    private boolean fhc = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener azP = null;
    private NewSubPbActivity.a fuu = null;
    private NewSubPbActivity.a fuv = null;
    private g eod = null;
    private String fuw = null;
    private int aVB = 0;
    private PostData fcP = null;
    private int fuC = 0;
    private int fuD = 2;
    private int fuE = 0;
    private boolean aDj = true;
    private View.OnClickListener fhk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray<Object> sparseArray;
            if (view2 != null && (sparseArray = (SparseArray) view2.getTag()) != null) {
                boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (!com.baidu.tieba.c.a.aeW() || !com.baidu.tieba.c.a.b(b.this.fuc.getBaseContext(), b.this.fuc.getThreadId(), b.this.fuc.getPostId(), b.this.fuc.aVE())) {
                        if (booleanValue2) {
                            sparseArray.put(d.g.tag_from, 1);
                            b.this.fuc.b(sparseArray);
                            return;
                        }
                        b.this.be(view2);
                    }
                } else if (booleanValue2) {
                    sparseArray.put(d.g.tag_from, 0);
                    b.this.fuc.b(sparseArray);
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
    protected AdapterView.OnItemClickListener fuF = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.9
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            if (az.aK(b.this.fuc.getPageContext().getPageActivity())) {
                if (b.this.fuc.enV == null || b.this.ftF == null || b.this.ftF.aWk() == null || b.this.fuc.enV.cK(b.this.ftF.aWk().replyPrivateFlag)) {
                    if (b.this.ftT != null) {
                        b.this.ftT.asZ();
                    }
                    b.this.bbu();
                    if (view2 == null || !(view2.getTag() instanceof c.a)) {
                        PostData postData = (PostData) v.c(b.this.fux, i);
                        if (postData == null) {
                            b.this.fuy = null;
                        } else {
                            b.this.fuy = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view2.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(d.g.tag_photo_username);
                            String str2 = (String) sparseArray.get(d.g.tag_photo_userid);
                            if (str != null) {
                                b.this.eod.setReplyId(str2);
                                b.this.eod.gx(str);
                            }
                        }
                        b.this.bbv();
                        return;
                    }
                    b.this.bbw();
                    b.this.ftF.bbR();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.bDx = null;
        this.fua = null;
        this.FL = null;
        this.fub = null;
        this.fuc = null;
        this.cTA = null;
        this.fud = null;
        this.dkB = null;
        this.fuh = null;
        this.fuq = null;
        this.fut = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.dkA = null;
        this.fuz = null;
        this.fuA = null;
        this.fuB = null;
        this.fuc = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.bDx = (RelativeLayout) LayoutInflater.from(this.fuc.getPageContext().getPageActivity()).inflate(d.i.new_sub_pb_layout, (ViewGroup) null);
        this.fua = LayoutInflater.from(this.fuc.getPageContext().getPageActivity()).inflate(d.i.new_sub_pb_head, (ViewGroup) null);
        this.dkB = (TextView) this.bDx.findViewById(d.g.no_reply_list_view);
        this.fuz = (RelativeLayout) this.bDx.findViewById(d.g.subpb_editor_tool_comment);
        this.dkA = (TextView) this.bDx.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.dkA.setOnClickListener(this.mCommonClickListener);
        this.fuA = (ImageView) this.bDx.findViewById(d.g.subpb_editor_tool_more_img);
        this.fuB = (ImageView) this.bDx.findViewById(d.g.subpb_editor_tool_emotion_img);
        this.fuB.setOnClickListener(this.mCommonClickListener);
        this.fuA.setOnClickListener(this.mCommonClickListener);
        this.cTA = (NoNetworkView) this.bDx.findViewById(d.g.view_no_network);
        ath();
        bbt();
        this.fud = (RelativeLayout) this.bDx.findViewById(d.g.sub_pb_body_layout);
        this.FL = (BdListView) this.bDx.findViewById(d.g.new_sub_pb_list);
        this.fup = (ThreadSkinView) LayoutInflater.from(this.fuc.getPageContext().getPageActivity()).inflate(d.i.thread_skin_layout, (ViewGroup) null);
        this.FL.addHeaderView(this.fup);
        this.FL.addHeaderView(this.fua);
        this.cNL = BdListViewHelper.a(this.fuc.getActivity(), this.FL, BdListViewHelper.HeadType.DEFAULT);
        this.fub = new c(this.fuc.getPageContext().getPageActivity());
        this.fub.I(this.fhk);
        this.fub.setIsFromCDN(this.mIsFromCDN);
        this.fub.kH(true);
        this.FL.setAdapter((ListAdapter) this.fub);
        this.fuq = new d(this.fuc.getPageContext());
        this.fut = this.fuq.getView();
        this.FL.setNextPage(this.fuq);
        this.fuq.setOnClickListener(this.mCommonClickListener);
        this.FL.setOnItemClickListener(this.fuF);
        this.FL.setOnTouchListener(this.aWx);
        this.mProgress = (ProgressBar) this.bDx.findViewById(d.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fua != null) {
            this.fua.setVisibility(4);
        }
        if (this.fud != null) {
            this.fud.setVisibility(4);
        }
        this.fuh = com.baidu.tbadk.ala.b.os().f(this.fuc.getActivity(), 4);
        if (this.fuh != null) {
            this.fuh.setVisibility(8);
            this.fuf.addView(this.fuh, 3);
        }
    }

    public ListView getListView() {
        return this.FL;
    }

    public void bbt() {
        this.fuf = (LinearLayout) this.fua.findViewById(d.g.subpb_head_user_info_root);
        this.fuf.setOnClickListener(this.mCommonClickListener);
        this.fug = (HeadImageView) this.fua.findViewById(d.g.photo);
        this.fug.setRadius(l.e(this.fuc.getActivity(), d.e.ds30));
        this.fug.setClickable(false);
        this.fou = (ClickableHeaderImageView) this.fua.findViewById(d.g.god_user_photo);
        this.fou.setGodIconMargin(0);
        this.fou.setGodIconWidth(d.e.ds24);
        this.fou.setRadius(l.e(this.fuc.getActivity(), d.e.ds30));
        this.fou.setClickable(false);
        this.aqm = (TextView) this.fua.findViewById(d.g.user_name);
        this.fui = (ImageView) this.fua.findViewById(d.g.user_rank);
        this.fui.setVisibility(8);
        this.fol = (TextView) this.fua.findViewById(d.g.floor_owner);
        this.fue = (TextView) this.fua.findViewById(d.g.see_subject);
        this.fue.setOnClickListener(this.mCommonClickListener);
        this.fuj = (TextView) this.fua.findViewById(d.g.floor);
        this.fuk = (TextView) this.fua.findViewById(d.g.time);
        this.ful = (EllipsizeRichTextView) this.fua.findViewById(d.g.content_text);
        this.ful.setOnClickListener(this.mCommonClickListener);
        ak.h(this.ful, d.C0126d.cp_cont_b);
        this.ful.setLinkTextColor(ak.getColor(d.C0126d.cp_link_tip_c));
        this.ful.setLineSpacing(0.0f, 1.25f);
        this.fum = (TbImageView) this.fua.findViewById(d.g.sub_pb_image);
        this.fum.setOnClickListener(this.mCommonClickListener);
        this.fuo = (TextView) this.fua.findViewById(d.g.advert);
        this.coU = (PlayVoiceBntNew) this.fua.findViewById(d.g.voice_btn);
        this.fua.setOnTouchListener(this.aWx);
        this.fua.setOnClickListener(this.mCommonClickListener);
    }

    public void fP(boolean z) {
        if (this.cNL != null && this.cNL.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cNL.getLayoutParams();
            if (z) {
                atl();
                layoutParams.height = l.e(this.fuc.getPageContext().getPageActivity(), d.e.ds88);
            } else {
                layoutParams.height = l.e(this.fuc.getPageContext().getPageActivity(), d.e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.cNL.setLayoutParams(layoutParams);
        }
    }

    private void atl() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public View atm() {
        return this.cNL;
    }

    public void ath() {
        int e = l.e(this.fuc.getPageContext().getPageActivity(), d.e.ds88);
        int e2 = l.e(this.fuc.getPageContext().getPageActivity(), d.e.ds14);
        this.mNavigationBar = (NavigationBar) this.bDx.findViewById(d.g.view_navigation_bar);
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
        if (this.foS == null) {
            this.foS = new Dialog(this.fuc.getPageContext().getPageActivity(), d.l.common_alert_dialog);
            this.foS.setCanceledOnTouchOutside(true);
            this.foS.setCancelable(true);
            View inflate = LayoutInflater.from(this.fuc.getPageContext().getPageActivity()).inflate(d.i.forum_manage_dialog, (ViewGroup) null);
            this.fuc.getLayoutMode().u(inflate);
            this.foS.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.foS.getWindow().getAttributes();
            attributes.width = (int) (l.af(this.fuc.getPageContext().getPageActivity()) * 0.9d);
            this.foS.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.foS.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.foS.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.foS.findViewById(d.g.disable_reply_btn);
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
                    if (b.this.foS != null && (b.this.foS instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.foS, b.this.fuc.getPageContext());
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
                    if (b.this.foS != null && (b.this.foS instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.foS, b.this.fuc.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view2.getTag();
                    if (sparseArray4 != null && b.this.fuu != null) {
                        b.this.fuu.f(new Object[]{sparseArray4.get(d.g.tag_manage_user_identity), sparseArray4.get(d.g.tag_forbid_user_name), sparseArray4.get(d.g.tag_forbid_user_post_id)});
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
                    if (b.this.foS != null && (b.this.foS instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.foS, b.this.fuc.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view2.getTag();
                    if (sparseArray5 != null) {
                        b.this.fuc.a(z, (String) sparseArray5.get(d.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.foS, this.fuc.getPageContext());
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
        this.foU = new com.baidu.tbadk.core.dialog.a(this.fuc.getPageContext().getPageActivity());
        this.foU.ca(i3);
        this.foU.z(sparseArray);
        this.foU.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.fuv != null) {
                    b.this.fuv.f(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.foU.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.foU.ar(true);
        this.foU.b(this.fuc.getPageContext());
        this.foU.tD();
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
        if (this.fpd != null) {
            this.fpd.dismiss();
            this.fpd = null;
        }
        if (z) {
            string = this.fuc.getResources().getString(d.k.remove_mark);
        } else {
            string = this.fuc.getResources().getString(d.k.mark);
        }
        this.fpd = new com.baidu.tbadk.core.dialog.b(this.fuc.getPageContext().getPageActivity());
        this.fpd.cd(d.k.operation);
        this.fpd.a(new String[]{this.fuc.getResources().getString(d.k.copy), string}, interfaceC0086b);
        this.fpd.d(this.fuc.getPageContext());
        this.fpd.tG();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.fuu = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.fuv = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.fuc.showToast(this.fuc.getResources().getString(d.k.delete_success));
        } else if (str != null && z2) {
            this.fuc.showToast(str);
        }
    }

    public void av(View view2) {
        if (this.cNL != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cNL.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.FL != null) {
                    this.FL.removeHeaderView(this.cNL);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.cNL.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.e(this.fuc.getActivity(), d.e.ds98)));
            } else if (this.FL != null) {
                this.FL.addHeaderView(this.cNL, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.DF() != null) {
            this.eod = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bDx.addView(gVar.DF(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.ftT = aVar;
    }

    public void bbu() {
        if (this.FL != null) {
            this.fuE = this.FL.getLastVisiblePosition();
        }
    }

    public void bbv() {
        if (this.ftF != null) {
            if ((!bby() && this.fut != null && this.fut.isShown()) || v.w(this.fux)) {
                this.ftF.kK(false);
            } else {
                this.ftF.kK(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.ftF = subPbModel;
    }

    public void bbw() {
        a(this.fuc);
        this.FL.setNextPage(this.fuq);
    }

    public void m(PostData postData) {
        int i;
        if (postData != null) {
            postData.mp(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bby() && this.fut != null && this.fut.isShown()) {
                i = (this.fuE - this.fuD) - 1;
            } else {
                i = this.fuE - this.fuD;
            }
            int v = v.v(this.fux);
            if (i > v) {
                i = v;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(v.a(this.fux, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.fub.setDatas(arrayList);
            this.fub.notifyDataSetChanged();
            this.FL.smoothScrollToPosition(this.fuE + 2);
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
        return this.bDx;
    }

    public void bar() {
        if (this.fur != null) {
            com.baidu.adp.lib.g.g.a(this.fur, this.fuc.getPageContext().getPageActivity());
        }
        if (this.fpd != null) {
            this.fpd.dismiss();
        }
        if (this.foU != null) {
            this.foU.dismiss();
        }
        if (this.foS != null) {
            com.baidu.adp.lib.g.g.b(this.foS, this.fuc.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.feU != null) {
            this.feU.dismiss();
        }
    }

    public void bbx() {
        this.FL.setNextPage(this.fuq);
        this.fuq.wR();
    }

    public void jq(boolean z) {
        this.fhc = z;
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
            if (this.aDj && this.fua != null) {
                this.fub.kI(true);
                this.fua.setVisibility(8);
                this.FL.removeHeaderView(this.fua);
                this.fuD = 1;
            }
            this.fsE = kVar;
            this.fub.T(this.fsE.Pe());
            if (this.fua != null) {
                this.fua.setVisibility(0);
            }
            if (this.fud != null) {
                this.fud.setVisibility(0);
            }
            if (kVar.aWc() != null) {
                this.fuw = kVar.aWc().getId();
                this.aVB = kVar.aWc().brZ();
                if (this.aVB > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.fuc.getResources().getString(d.k.subpb_floor_reply_count), an.z(kVar.getTotalCount())));
                    this.dkA.setText(d.k.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.fuc.bbs()) {
                    str = "PB";
                }
                if (kVar.aWc().sk() != null) {
                    this.fup.setData(this.fuc.getPageContext(), kVar.aWc().sk(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", kVar.aWj().getId(), kVar.aWj().getName(), kVar.Pe().getId(), str));
                } else {
                    this.fup.setData(null, null, null);
                }
            }
            if (kVar.hasMore()) {
                this.fuq.wR();
                this.fub.setHasMoreData(true);
            } else {
                this.fuq.wS();
                this.fub.setHasMoreData(false);
            }
            this.fux = kVar.aWg();
            if (v.w(this.fux)) {
                this.FL.setNextPage(null);
                if (this.aDj) {
                    this.dkB.setVisibility(0);
                }
            } else {
                this.FL.setNextPage(this.fuq);
                if (this.aDj) {
                    this.dkB.setVisibility(8);
                }
            }
            if (this.fux == null || this.fux.size() <= ftZ) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.fux.size() - ftZ;
                qH(size);
                int firstVisiblePosition = this.FL.getFirstVisiblePosition() - size;
                View childAt = this.FL.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.fub.setDatas(this.fux);
            boolean z2 = false;
            if (kVar.Pe() != null && kVar.Pe().rQ() != null && (userId = kVar.Pe().rQ().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.fub.B(i, z2);
            this.fub.notifyDataSetChanged();
            a(kVar.aWc(), kVar.aGn(), kVar.oI(), i, z);
            if (i4 > 0) {
                this.FL.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void qH(int i) {
        if (this.fux != null) {
            if (this.fux.size() <= i) {
                this.fux.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.fux.iterator();
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
        return this.fub.cxD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.aDj) {
            this.fcP = postData;
            if (!StringUtils.isNull(postData.bsg())) {
                this.fum.setVisibility(0);
                this.fum.startLoad(postData.bsg(), 10, true);
            } else {
                this.fum.setVisibility(8);
            }
            h bsi = postData.bsi();
            if (bsi != null && bsi.gwd) {
                this.fuo.setVisibility(0);
            } else {
                this.fuo.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.fua.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.fua.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.fuj.setText((CharSequence) null);
            this.aqm.setText((CharSequence) null);
            this.fol.setVisibility(8);
            if (!this.aDj) {
                c(postData.rQ());
                if (z) {
                    this.fol.setVisibility(0);
                    ak.h(this.fol, d.C0126d.cp_link_tip_a);
                }
            }
            this.fuk.setText(an.s(postData.getTime()));
            this.fuj.setText(String.format(this.fuc.getPageContext().getString(d.k.is_floor), Integer.valueOf(postData.brZ())));
            postData.rQ().getUserTbVipInfoData();
            boolean a = a(this.ful, postData.bsb());
            if (StringUtils.isNull(postData.bsg()) && !a && postData.JR() != null) {
                this.coU.setVisibility(0);
                this.coU.setTag(postData.JR());
                return;
            }
            this.coU.setVisibility(8);
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
            if (metaData.getAlaUserData() != null && this.fuh != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.fuh.setVisibility(8);
                } else {
                    this.fuh.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.Se = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.fuh.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.fou.setVisibility(0);
                this.fug.setVisibility(8);
                this.fou.setUserId(metaData.getUserId());
                this.fou.setUserName(metaData.getUserName());
                this.fou.startLoad(metaData.getPortrait(), 28, false);
                ak.h(this.aqm, d.C0126d.cp_cont_r);
            } else {
                this.fou.setVisibility(8);
                this.fug.setVisibility(0);
                this.fug.setUserId(metaData.getUserId());
                this.fug.setUserName(metaData.getUserName());
                this.fug.setDefaultResource(d.f.transparent_bg);
                this.fug.setDefaultErrorResource(d.f.icon_default_avatar100);
                this.fug.startLoad(metaData.getPortrait(), 28, false);
                ak.h(this.aqm, d.C0126d.cp_cont_c);
            }
            this.fuf.setTag(d.g.tag_user_id, metaData.getUserId());
            this.fuf.setTag(d.g.tag_user_name, metaData.getUserName());
            this.fuf.setTag(d.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
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
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fuc.getPageContext().getString(d.k.refresh_view_title_text), this.Tt));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.fuc.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.fud, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.f.pic_emotion07, l.e(pageActivity, d.e.ds250), l.e(pageActivity, d.e.ds480), l.e(pageActivity, d.e.ds360)), dVar, a);
        }
        this.fud.setVisibility(0);
        this.FL.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.eod.EA();
        ak.j(this.mNoDataView, d.C0126d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.fuc.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void ik(int i) {
        b(NoDataViewFactory.d.C(i, d.k.refresh_view_title_text));
        if (this.ftT != null) {
            this.ftT.bh(this.bDx);
        }
        this.fuz.setVisibility(8);
    }

    public void lW(String str) {
        b(NoDataViewFactory.d.af(str, this.fuc.getPageContext().getString(d.k.refresh_view_title_text)));
        if (this.ftT != null) {
            this.ftT.bh(this.bDx);
        }
        this.fuz.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.FL.setVisibility(0);
            this.fuz.setVisibility(0);
            this.bDx.setOnTouchListener(null);
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
            if (this.fsE != null && this.fsE.Pe() != null && this.fsE.Pe().rQ() != null && postData.rQ() != null) {
                String userId3 = this.fsE.Pe().rQ().getUserId();
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
                        if (this.fsE.Pe() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fsE.Pe().getId());
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
        if (this.feU != null && this.feU.aYV() != null) {
            if (z) {
                this.feU.aYV().setText(d.k.remove_mark);
            } else {
                this.feU.aYV().setText(d.k.mark);
            }
            this.feU.refreshUI();
        }
    }

    public View bbz() {
        return this.fut;
    }

    public void onChangeSkinType(int i) {
        this.fuc.getLayoutMode().setNightMode(i == 1);
        this.fuc.getLayoutMode().u(this.bDx);
        this.fuc.getLayoutMode().u(this.fua);
        this.mNavigationBar.onChangeSkinType(this.fuc.getPageContext(), i);
        if (this.fue != null) {
            ak.h(this.fue, d.C0126d.goto_see_subject_color);
        }
        ak.h(this.dkB, d.C0126d.cp_cont_d);
        this.cTA.onChangeSkinType(this.fuc.getPageContext(), i);
        this.fuc.getLayoutMode().u(this.fut);
        ak.h(this.ful, d.C0126d.cp_cont_b);
        this.ful.setLinkTextColor(ak.getColor(d.C0126d.cp_link_tip_c));
        if (this.eod != null && this.eod.DF() != null) {
            this.eod.DF().onChangeSkinType(i);
        }
        this.fuq.dw(i);
        this.coU.aIT();
        ak.h(this.dkA, d.C0126d.cp_cont_e);
        ak.h(this.fol, d.C0126d.cp_link_tip_a);
        ak.h(this.aqm, d.C0126d.cp_cont_c);
        this.dkA.setAlpha(0.95f);
        if (this.fub != null) {
            this.fub.notifyDataSetChanged();
        }
    }

    public void bbA() {
        this.mProgress.setVisibility(0);
    }

    public void bbB() {
        this.FL.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fuq.wS();
    }

    public void amL() {
        this.FL.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fuq.amL();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.azP = onLongClickListener;
        this.fua.setOnLongClickListener(this.azP);
    }

    public View bbC() {
        return this.fua;
    }

    public TextView atn() {
        return this.dkA;
    }

    public ImageView bbD() {
        return this.fuA;
    }

    public ImageView bbE() {
        return this.fuB;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void qI(int i) {
    }

    public void qO(String str) {
        int qP = this.fub.qP(str);
        if (qP > -1) {
            this.fub.qJ(qP);
            if (qP > 2) {
                this.FL.setSelection(qP - 2);
            } else {
                this.FL.setSelection(qP);
            }
            this.FL.invalidate();
        }
    }

    public View bbF() {
        return this.fue;
    }

    public View bbG() {
        return this.fum;
    }

    public MorePopupWindow bbH() {
        return this.fur;
    }

    public void showLoadingDialog() {
        if (this.cyp == null) {
            this.cyp = new com.baidu.tbadk.core.view.a(this.fuc.getPageContext());
        }
        this.cyp.aI(true);
    }

    public void aas() {
        if (this.cyp != null) {
            this.cyp.aI(false);
        }
    }

    public TextView bbI() {
        return this.ful;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.ftJ = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.ftK = hVar;
    }

    public x bbJ() {
        return this.feU;
    }

    public void asb() {
    }

    public void asc() {
    }

    public void onActivityDestroy() {
    }

    public void bbK() {
        if (this.fuc.isPaused()) {
        }
    }

    public View bbL() {
        return this.fuf;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, d.f.pic_smalldot_title));
            return o.a((Context) this.fuc.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
