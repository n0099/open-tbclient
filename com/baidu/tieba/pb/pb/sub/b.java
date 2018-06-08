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
import com.baidu.tbadk.core.util.ao;
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
    private static final int fGy = TbadkCoreApplication.getInst().getListItemRule().Cd();
    private BdListView LQ;
    private RelativeLayout bMA;
    private com.baidu.tbadk.core.view.a cIg;
    private View cXU;
    private NoNetworkView ddN;
    private TextView duS;
    private TextView duT;
    private k fEZ;
    private c fGA;
    private NewSubPbActivity fGB;
    private RelativeLayout fGC;
    private View fGG;
    private ThreadSkinView fGN;
    private d fGO;
    private View fGR;
    private ArrayList<PostData> fGV;
    private String fGW;
    private RelativeLayout fGX;
    private ImageView fGY;
    private ImageView fGZ;
    private SubPbModel fGe;
    private a fGs;
    private View fGz;
    private x frx;
    private View.OnClickListener mCommonClickListener;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private TbRichTextView.h fGj = null;
    private View.OnClickListener aby = null;
    private TbRichTextView.i fGi = null;
    private NavigationBar mNavigationBar = null;
    private View aAn = null;
    private TextView fGD = null;
    private LinearLayout fGE = null;
    private HeadImageView fGF = null;
    private ClickableHeaderImageView fAR = null;
    private TextView ayt = null;
    private ImageView fGH = null;
    private TextView fAJ = null;
    private TextView fGI = null;
    private TextView fGJ = null;
    private EllipsizeRichTextView fGK = null;
    private TbImageView fGL = null;
    private PlayVoiceBntNew cyE = null;
    private TextView fGM = null;
    private MorePopupWindow fGP = null;
    private al fGQ = null;
    private com.baidu.tbadk.core.dialog.b fBA = null;
    private Dialog fBp = null;
    private com.baidu.tbadk.core.dialog.a fBr = null;
    private boolean ftF = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener aIl = null;
    private NewSubPbActivity.a fGS = null;
    private NewSubPbActivity.a fGT = null;
    private g eAA = null;
    private String fGU = null;
    private int bdG = 0;
    private PostData fpp = null;
    private int fHa = 0;
    private int fHb = 2;
    private int fHc = 0;
    private boolean aLG = true;
    private View.OnClickListener ftN = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
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
                        b.this.fGB.b(sparseArray);
                        return;
                    }
                    b.this.bh(view);
                } else if (booleanValue2) {
                    sparseArray.put(d.g.tag_from, 0);
                    b.this.fGB.b(sparseArray);
                } else if (booleanValue3) {
                    b.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c beE = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            b.this.fT(false);
            b.this.av(view);
            b.this.fT(true);
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
    protected AdapterView.OnItemClickListener fHd = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.9
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ba.aU(b.this.fGB.getPageContext().getPageActivity())) {
                if (b.this.fGB.eAs == null || b.this.fGe == null || b.this.fGe.bbg() == null || b.this.fGB.eAs.cM(b.this.fGe.bbg().replyPrivateFlag)) {
                    if (b.this.fGs != null) {
                        b.this.fGs.axe();
                    }
                    b.this.bgu();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) w.c(b.this.fGV, i);
                        if (postData == null) {
                            b.this.fGW = null;
                        } else {
                            b.this.fGW = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(d.g.tag_photo_username);
                            String str2 = (String) sparseArray.get(d.g.tag_photo_userid);
                            if (str != null) {
                                b.this.eAA.setReplyId(str2);
                                b.this.eAA.gV(str);
                            }
                        }
                        b.this.bgv();
                        return;
                    }
                    b.this.bgw();
                    b.this.fGe.bgR();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.bMA = null;
        this.fGz = null;
        this.LQ = null;
        this.fGA = null;
        this.fGB = null;
        this.ddN = null;
        this.fGC = null;
        this.duT = null;
        this.fGG = null;
        this.fGO = null;
        this.fGR = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.duS = null;
        this.fGX = null;
        this.fGY = null;
        this.fGZ = null;
        this.fGB = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.bMA = (RelativeLayout) LayoutInflater.from(this.fGB.getPageContext().getPageActivity()).inflate(d.i.new_sub_pb_layout, (ViewGroup) null);
        this.fGz = LayoutInflater.from(this.fGB.getPageContext().getPageActivity()).inflate(d.i.new_sub_pb_head, (ViewGroup) null);
        this.duT = (TextView) this.bMA.findViewById(d.g.no_reply_list_view);
        this.fGX = (RelativeLayout) this.bMA.findViewById(d.g.subpb_editor_tool_comment);
        this.duS = (TextView) this.bMA.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.duS.setOnClickListener(this.mCommonClickListener);
        this.fGY = (ImageView) this.bMA.findViewById(d.g.subpb_editor_tool_more_img);
        this.fGZ = (ImageView) this.bMA.findViewById(d.g.subpb_editor_tool_emotion_img);
        this.fGZ.setOnClickListener(this.mCommonClickListener);
        this.fGY.setOnClickListener(this.mCommonClickListener);
        this.ddN = (NoNetworkView) this.bMA.findViewById(d.g.view_no_network);
        axm();
        bgt();
        this.fGC = (RelativeLayout) this.bMA.findViewById(d.g.sub_pb_body_layout);
        this.LQ = (BdListView) this.bMA.findViewById(d.g.new_sub_pb_list);
        this.fGN = (ThreadSkinView) LayoutInflater.from(this.fGB.getPageContext().getPageActivity()).inflate(d.i.thread_skin_layout, (ViewGroup) null);
        this.LQ.addHeaderView(this.fGN);
        this.LQ.addHeaderView(this.fGz);
        this.cXU = BdListViewHelper.a(this.fGB.getActivity(), this.LQ, BdListViewHelper.HeadType.DEFAULT);
        this.fGA = new c(this.fGB.getPageContext().getPageActivity());
        this.fGA.I(this.ftN);
        this.fGA.setIsFromCDN(this.mIsFromCDN);
        this.fGA.kO(true);
        this.LQ.setAdapter((ListAdapter) this.fGA);
        this.fGO = new d(this.fGB.getPageContext());
        this.fGR = this.fGO.getView();
        this.LQ.setNextPage(this.fGO);
        this.fGO.setOnClickListener(this.mCommonClickListener);
        this.LQ.setOnItemClickListener(this.fHd);
        this.LQ.setOnTouchListener(this.beE);
        this.mProgress = (ProgressBar) this.bMA.findViewById(d.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fGz != null) {
            this.fGz.setVisibility(4);
        }
        if (this.fGC != null) {
            this.fGC.setVisibility(4);
        }
        this.fGG = com.baidu.tbadk.ala.b.rM().f(this.fGB.getActivity(), 4);
        if (this.fGG != null) {
            this.fGG.setVisibility(8);
            this.fGE.addView(this.fGG, 3);
        }
    }

    public ListView getListView() {
        return this.LQ;
    }

    public void bgt() {
        this.fGE = (LinearLayout) this.fGz.findViewById(d.g.subpb_head_user_info_root);
        this.fGE.setOnClickListener(this.mCommonClickListener);
        this.fGF = (HeadImageView) this.fGz.findViewById(d.g.photo);
        this.fGF.setRadius(l.e(this.fGB.getActivity(), d.e.ds30));
        this.fGF.setClickable(false);
        this.fAR = (ClickableHeaderImageView) this.fGz.findViewById(d.g.god_user_photo);
        this.fAR.setGodIconMargin(0);
        this.fAR.setGodIconWidth(d.e.ds24);
        this.fAR.setRadius(l.e(this.fGB.getActivity(), d.e.ds30));
        this.fAR.setClickable(false);
        this.ayt = (TextView) this.fGz.findViewById(d.g.user_name);
        this.fGH = (ImageView) this.fGz.findViewById(d.g.user_rank);
        this.fGH.setVisibility(8);
        this.fAJ = (TextView) this.fGz.findViewById(d.g.floor_owner);
        this.fGD = (TextView) this.fGz.findViewById(d.g.see_subject);
        this.fGD.setOnClickListener(this.mCommonClickListener);
        this.fGI = (TextView) this.fGz.findViewById(d.g.floor);
        this.fGJ = (TextView) this.fGz.findViewById(d.g.time);
        this.fGK = (EllipsizeRichTextView) this.fGz.findViewById(d.g.content_text);
        this.fGK.setOnClickListener(this.mCommonClickListener);
        com.baidu.tbadk.core.util.al.h(this.fGK, d.C0141d.cp_cont_b);
        this.fGK.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0141d.cp_link_tip_c));
        this.fGK.setLineSpacing(0.0f, 1.25f);
        this.fGL = (TbImageView) this.fGz.findViewById(d.g.sub_pb_image);
        this.fGL.setOnClickListener(this.mCommonClickListener);
        this.fGM = (TextView) this.fGz.findViewById(d.g.advert);
        this.cyE = (PlayVoiceBntNew) this.fGz.findViewById(d.g.voice_btn);
        this.fGz.setOnTouchListener(this.beE);
        this.fGz.setOnClickListener(this.mCommonClickListener);
    }

    public void fV(boolean z) {
        if (this.cXU != null && this.cXU.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cXU.getLayoutParams();
            if (z) {
                axq();
                layoutParams.height = l.e(this.fGB.getPageContext().getPageActivity(), d.e.ds88);
            } else {
                layoutParams.height = l.e(this.fGB.getPageContext().getPageActivity(), d.e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.cXU.setLayoutParams(layoutParams);
        }
    }

    private void axq() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public View axr() {
        return this.cXU;
    }

    public void axm() {
        int e = l.e(this.fGB.getPageContext().getPageActivity(), d.e.ds88);
        int e2 = l.e(this.fGB.getPageContext().getPageActivity(), d.e.ds14);
        this.mNavigationBar = (NavigationBar) this.bMA.findViewById(d.g.view_navigation_bar);
        this.aAn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aAn.getLayoutParams();
            layoutParams.height = e;
            layoutParams.width = e;
            layoutParams.leftMargin = e2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aAn != null && (this.aAn.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aAn.getLayoutParams();
            layoutParams2.width = e;
            layoutParams2.height = e;
            this.aAn.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar UB() {
        return this.mNavigationBar;
    }

    public void bh(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.fBp == null) {
            this.fBp = new Dialog(this.fGB.getPageContext().getPageActivity(), d.l.common_alert_dialog);
            this.fBp.setCanceledOnTouchOutside(true);
            this.fBp.setCancelable(true);
            View inflate = LayoutInflater.from(this.fGB.getPageContext().getPageActivity()).inflate(d.i.forum_manage_dialog, (ViewGroup) null);
            this.fGB.getLayoutMode().onModeChanged(inflate);
            this.fBp.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.fBp.getWindow().getAttributes();
            attributes.width = (int) (l.ah(this.fGB.getPageContext().getPageActivity()) * 0.9d);
            this.fBp.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fBp.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fBp.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fBp.findViewById(d.g.disable_reply_btn);
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
                public void onClick(View view) {
                    if (b.this.fBp != null && (b.this.fBp instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fBp, b.this.fGB.getPageContext());
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
            sparseArray3.put(d.g.tag_manage_user_identity, sparseArray.get(d.g.tag_manage_user_identity));
            sparseArray3.put(d.g.tag_forbid_user_post_id, sparseArray.get(d.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.fBp != null && (b.this.fBp instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fBp, b.this.fGB.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.fGS != null) {
                        b.this.fGS.i(new Object[]{sparseArray4.get(d.g.tag_manage_user_identity), sparseArray4.get(d.g.tag_forbid_user_name), sparseArray4.get(d.g.tag_forbid_user_post_id), sparseArray4.get(d.g.tag_forbid_user_name_show)});
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
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.fBp != null && (b.this.fBp instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fBp, b.this.fGB.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.fGB.a(z, (String) sparseArray5.get(d.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fBp, this.fGB.getPageContext());
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
        this.fBr = new com.baidu.tbadk.core.dialog.a(this.fGB.getPageContext().getPageActivity());
        this.fBr.cc(i3);
        this.fBr.C(sparseArray);
        this.fBr.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.fGT != null) {
                    b.this.fGT.i(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.fBr.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fBr.au(true);
        this.fBr.b(this.fGB.getPageContext());
        this.fBr.xa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fT(final boolean z) {
        if (this.LQ != null) {
            if (!z) {
                this.LQ.setEnabled(z);
            } else {
                this.LQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.LQ.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void b(b.InterfaceC0103b interfaceC0103b, boolean z) {
        String string;
        if (this.fBA != null) {
            this.fBA.dismiss();
            this.fBA = null;
        }
        if (z) {
            string = this.fGB.getResources().getString(d.k.remove_mark);
        } else {
            string = this.fGB.getResources().getString(d.k.mark);
        }
        this.fBA = new com.baidu.tbadk.core.dialog.b(this.fGB.getPageContext().getPageActivity());
        this.fBA.cf(d.k.operation);
        this.fBA.a(new String[]{this.fGB.getResources().getString(d.k.copy), string}, interfaceC0103b);
        this.fBA.d(this.fGB.getPageContext());
        this.fBA.xd();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.fGS = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.fGT = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.fGB.showToast(this.fGB.getResources().getString(d.k.delete_success));
        } else if (str != null && z2) {
            this.fGB.showToast(str);
        }
    }

    public void av(View view) {
        if (this.cXU != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cXU.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.LQ != null) {
                    this.LQ.removeHeaderView(this.cXU);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.cXU.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.e(this.fGB.getActivity(), d.e.ds98)));
            } else if (this.LQ != null) {
                this.LQ.addHeaderView(this.cXU, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.Hg() != null) {
            this.eAA = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bMA.addView(gVar.Hg(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.fGs = aVar;
    }

    public void bgu() {
        if (this.LQ != null) {
            this.fHc = this.LQ.getLastVisiblePosition();
        }
    }

    public void bgv() {
        if (this.fGe != null) {
            if ((!bgy() && this.fGR != null && this.fGR.isShown()) || w.z(this.fGV)) {
                this.fGe.kR(false);
            } else {
                this.fGe.kR(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.fGe = subPbModel;
    }

    public void bgw() {
        a(this.fGB);
        this.LQ.setNextPage(this.fGO);
    }

    public void m(PostData postData) {
        int i;
        if (postData != null) {
            postData.mw(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bgy() && this.fGR != null && this.fGR.isShown()) {
                i = (this.fHc - this.fHb) - 1;
            } else {
                i = this.fHc - this.fHb;
            }
            int y = w.y(this.fGV);
            if (i > y) {
                i = y;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(w.a(this.fGV, 0, i));
            w.b(arrayList, postData2);
            w.b(arrayList, postData);
            this.fGA.setDatas(arrayList);
            this.fGA.notifyDataSetChanged();
            this.LQ.smoothScrollToPosition(this.fHc + 2);
            this.LQ.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.LQ.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.LQ.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.bMA;
    }

    public void bfp() {
        if (this.fGP != null) {
            com.baidu.adp.lib.g.g.a(this.fGP, this.fGB.getPageContext().getPageActivity());
        }
        if (this.fBA != null) {
            this.fBA.dismiss();
        }
        if (this.fBr != null) {
            this.fBr.dismiss();
        }
        if (this.fBp != null) {
            com.baidu.adp.lib.g.g.b(this.fBp, this.fGB.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.frx != null) {
            this.frx.dismiss();
        }
    }

    public void bgx() {
        this.LQ.setNextPage(this.fGO);
        this.fGO.Ar();
    }

    public void jx(boolean z) {
        this.ftF = z;
    }

    public void setIsFromPb(boolean z) {
        this.aLG = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(k kVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (kVar != null) {
            if (this.aLG && this.fGz != null) {
                this.fGA.kP(true);
                this.fGz.setVisibility(8);
                this.LQ.removeHeaderView(this.fGz);
                this.fHb = 1;
            }
            this.fEZ = kVar;
            this.fGA.T(this.fEZ.Sz());
            if (this.fGz != null) {
                this.fGz.setVisibility(0);
            }
            if (this.fGC != null) {
                this.fGC.setVisibility(0);
            }
            if (kVar.baY() != null) {
                this.fGU = kVar.baY().getId();
                this.bdG = kVar.baY().bwZ();
                if (this.bdG > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.fGB.getResources().getString(d.k.subpb_floor_reply_count), ao.C(kVar.getTotalCount())));
                    this.duS.setText(d.k.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.fGB.bgs()) {
                    str = "PB";
                }
                if (kVar.baY().vG() != null) {
                    this.fGN.setData(this.fGB.getPageContext(), kVar.baY().vG(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", kVar.bbf().getId(), kVar.bbf().getName(), kVar.Sz().getId(), str));
                } else {
                    this.fGN.setData(null, null, null);
                }
            }
            if (kVar.hasMore()) {
                this.fGO.Ar();
                this.fGA.setHasMoreData(true);
            } else {
                this.fGO.As();
                this.fGA.setHasMoreData(false);
            }
            this.fGV = kVar.bbc();
            if (w.z(this.fGV)) {
                this.LQ.setNextPage(null);
                if (this.aLG) {
                    this.duT.setVisibility(0);
                }
            } else {
                this.LQ.setNextPage(this.fGO);
                if (this.aLG) {
                    this.duT.setVisibility(8);
                }
            }
            if (this.fGV == null || this.fGV.size() <= fGy) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.fGV.size() - fGy;
                qR(size);
                int firstVisiblePosition = this.LQ.getFirstVisiblePosition() - size;
                View childAt = this.LQ.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.fGA.setDatas(this.fGV);
            boolean z2 = false;
            if (kVar.Sz() != null && kVar.Sz().vm() != null && (userId = kVar.Sz().vm().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.fGA.B(i, z2);
            this.fGA.notifyDataSetChanged();
            a(kVar.baY(), kVar.aLg(), kVar.sc(), i, z);
            if (i4 > 0) {
                this.LQ.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void qR(int i) {
        if (this.fGV != null) {
            if (this.fGV.size() <= i) {
                this.fGV.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.fGV.iterator();
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

    public boolean bgy() {
        return this.fGA.cHm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.aLG) {
            this.fpp = postData;
            if (!StringUtils.isNull(postData.bxg())) {
                this.fGL.setVisibility(0);
                this.fGL.startLoad(postData.bxg(), 10, true);
            } else {
                this.fGL.setVisibility(8);
            }
            h bxi = postData.bxi();
            if (bxi != null && bxi.gID) {
                this.fGM.setVisibility(0);
            } else {
                this.fGM.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.fGz.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.fGz.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.fGI.setText((CharSequence) null);
            this.ayt.setText((CharSequence) null);
            this.fAJ.setVisibility(8);
            if (!this.aLG) {
                c(postData.vm());
                if (z) {
                    this.fAJ.setVisibility(0);
                    com.baidu.tbadk.core.util.al.h(this.fAJ, d.C0141d.cp_link_tip_a);
                }
            }
            this.fGJ.setText(ao.v(postData.getTime()));
            this.fGI.setText(String.format(this.fGB.getPageContext().getString(d.k.is_floor), Integer.valueOf(postData.bwZ())));
            postData.vm().getUserTbVipInfoData();
            boolean a = a(this.fGK, postData.bxb());
            if (StringUtils.isNull(postData.bxg()) && !a && postData.No() != null) {
                this.cyE.setVisibility(0);
                this.cyE.setTag(postData.No());
                return;
            }
            this.cyE.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.k.bg(metaData.getSealPrefix()) + 2 : 0) + com.baidu.tbadk.util.x.hG(name_show) > 14) {
                name_show = com.baidu.tbadk.util.x.k(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.ayt.setText(ak(metaData.getSealPrefix(), name_show));
            } else {
                this.ayt.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.fGG != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.fGG.setVisibility(8);
                } else {
                    this.fGG.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.aak = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.fGG.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.fAR.setVisibility(0);
                this.fGF.setVisibility(8);
                this.fAR.setUserId(metaData.getUserId());
                this.fAR.setUserName(metaData.getUserName());
                this.fAR.startLoad(metaData.getPortrait(), 28, false);
                com.baidu.tbadk.core.util.al.h(this.ayt, d.C0141d.cp_cont_r);
            } else {
                this.fAR.setVisibility(8);
                this.fGF.setVisibility(0);
                this.fGF.setUserId(metaData.getUserId());
                this.fGF.setUserName(metaData.getUserName());
                this.fGF.setDefaultResource(d.f.transparent_bg);
                this.fGF.setDefaultErrorResource(d.f.icon_default_avatar100);
                this.fGF.startLoad(metaData.getPortrait(), 28, false);
                com.baidu.tbadk.core.util.al.h(this.ayt, d.C0141d.cp_cont_c);
            }
            this.fGE.setTag(d.g.tag_user_id, metaData.getUserId());
            this.fGE.setTag(d.g.tag_user_name, metaData.getUserName());
            this.fGE.setTag(d.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.Ng() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.Ng().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.Nn());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.ck(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.bFg());
                        continue;
                    case 17:
                        String str = next.Nr().mGifInfo.mSharpText;
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
        if (!tbRichTextData.Nw()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.Nn() == null || tbRichTextData.Nn().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.Nn());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fGB.getPageContext().getString(d.k.refresh_view_title_text), this.aby));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.fGB.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.fGC, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.f.pic_emotion07, l.e(pageActivity, d.e.ds250), l.e(pageActivity, d.e.ds480), l.e(pageActivity, d.e.ds360)), dVar, a);
        }
        this.fGC.setVisibility(0);
        this.LQ.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.eAA.Ic();
        com.baidu.tbadk.core.util.al.j(this.mNoDataView, d.C0141d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.fGB.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void ij(int i) {
        b(NoDataViewFactory.d.D(i, d.k.refresh_view_title_text));
        if (this.fGs != null) {
            this.fGs.bk(this.bMA);
        }
        this.fGX.setVisibility(8);
    }

    public void mG(String str) {
        b(NoDataViewFactory.d.aj(str, this.fGB.getPageContext().getString(d.k.refresh_view_title_text)));
        if (this.fGs != null) {
            this.fGs.bk(this.bMA);
        }
        this.fGX.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.LQ.setVisibility(0);
            this.fGX.setVisibility(0);
            this.bMA.setOnTouchListener(null);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.aby = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0231  */
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
                String userId2 = postData.vm().getUserId();
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
            if (this.fEZ != null && this.fEZ.Sz() != null && this.fEZ.Sz().vm() != null && postData.vm() != null) {
                String userId3 = this.fEZ.Sz().vm().getUserId();
                String userId4 = postData.vm().getUserId();
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
                    userId = postData.vm().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.bwZ() != 1 ? 0 : 1;
                    if (ar.j(postData)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(d.g.tag_forbid_user_name, postData.vm().getUserName());
                        sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
                        sparseArray.put(d.g.tag_forbid_user_name_show, postData.vm().getName_show());
                        z7 = true;
                    } else {
                        sparseArray.put(d.g.tag_forbid_user_name, "");
                        sparseArray.put(d.g.tag_forbid_user_name_show, "");
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
                        sparseArray.put(d.g.tag_forbid_user_name, postData.vm().getUserName());
                        sparseArray.put(d.g.tag_forbid_user_name_show, postData.vm().getName_show());
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.vm() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.vm().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.vm().getUserName());
                            sparseArray.put(d.g.tag_user_mute_mute_nameshow, postData.vm().getName_show());
                        }
                        if (this.fEZ.Sz() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fEZ.Sz().getId());
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
            userId = postData.vm().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.bwZ() != 1) {
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

    public void kN(boolean z) {
        if (this.frx != null && this.frx.bdT() != null) {
            if (z) {
                this.frx.bdT().setText(d.k.remove_mark);
            } else {
                this.frx.bdT().setText(d.k.mark);
            }
            this.frx.refreshUI();
        }
    }

    public View bgz() {
        return this.fGR;
    }

    public void onChangeSkinType(int i) {
        this.fGB.getLayoutMode().setNightMode(i == 1);
        this.fGB.getLayoutMode().onModeChanged(this.bMA);
        this.fGB.getLayoutMode().onModeChanged(this.fGz);
        this.mNavigationBar.onChangeSkinType(this.fGB.getPageContext(), i);
        if (this.fGD != null) {
            com.baidu.tbadk.core.util.al.h(this.fGD, d.C0141d.goto_see_subject_color);
        }
        com.baidu.tbadk.core.util.al.h(this.duT, d.C0141d.cp_cont_d);
        this.ddN.onChangeSkinType(this.fGB.getPageContext(), i);
        this.fGB.getLayoutMode().onModeChanged(this.fGR);
        com.baidu.tbadk.core.util.al.h(this.fGK, d.C0141d.cp_cont_b);
        this.fGK.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0141d.cp_link_tip_c));
        if (this.eAA != null && this.eAA.Hg() != null) {
            this.eAA.Hg().onChangeSkinType(i);
        }
        this.fGO.dy(i);
        this.cyE.aNN();
        com.baidu.tbadk.core.util.al.h(this.duS, d.C0141d.cp_cont_e);
        com.baidu.tbadk.core.util.al.h(this.fAJ, d.C0141d.cp_link_tip_a);
        com.baidu.tbadk.core.util.al.h(this.ayt, d.C0141d.cp_cont_c);
        this.duS.setAlpha(0.95f);
        if (this.fGA != null) {
            this.fGA.notifyDataSetChanged();
        }
    }

    public void bgA() {
        this.mProgress.setVisibility(0);
    }

    public void bgB() {
        this.LQ.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fGO.As();
    }

    public void aqQ() {
        this.LQ.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fGO.aqQ();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aIl = onLongClickListener;
        this.fGz.setOnLongClickListener(this.aIl);
    }

    public View bgC() {
        return this.fGz;
    }

    public TextView axs() {
        return this.duS;
    }

    public ImageView bgD() {
        return this.fGY;
    }

    public ImageView bgE() {
        return this.fGZ;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void qS(int i) {
    }

    public void rH(String str) {
        int rI = this.fGA.rI(str);
        if (rI > -1) {
            this.fGA.qT(rI);
            if (rI > 2) {
                this.LQ.setSelection(rI - 2);
            } else {
                this.LQ.setSelection(rI);
            }
            this.LQ.invalidate();
        }
    }

    public View bgF() {
        return this.fGD;
    }

    public View bgG() {
        return this.fGL;
    }

    public MorePopupWindow bgH() {
        return this.fGP;
    }

    public void showLoadingDialog() {
        if (this.cIg == null) {
            this.cIg = new com.baidu.tbadk.core.view.a(this.fGB.getPageContext());
        }
        this.cIg.aM(true);
    }

    public void adT() {
        if (this.cIg != null) {
            this.cIg.aM(false);
        }
    }

    public TextView bgI() {
        return this.fGK;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.fGi = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fGj = hVar;
    }

    public x bgJ() {
        return this.frx;
    }

    public void awf() {
    }

    public void awg() {
    }

    public void onActivityDestroy() {
    }

    public void bgK() {
        if (this.fGB.isPaused()) {
        }
    }

    public View bgL() {
        return this.fGE;
    }

    private SpannableStringBuilder ak(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, d.f.pic_smalldot_title));
            return o.a((Context) this.fGB.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
