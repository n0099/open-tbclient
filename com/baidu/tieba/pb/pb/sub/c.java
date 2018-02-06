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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
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
import com.baidu.tieba.card.j;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.main.al;
import com.baidu.tieba.pb.pb.main.aq;
import com.baidu.tieba.pb.pb.main.x;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class c {
    private static final int fZO = TbadkCoreApplication.getInst().getListItemRule().FR();
    private BdListView avh;
    private NoNetworkView dAX;
    private TextView dQt;
    private TextView dQu;
    private com.baidu.tbadk.core.view.b dgK;
    private View dvg;
    private RelativeLayout fFK;
    private x fLk;
    private k fYt;
    private b fZI;
    private View fZP;
    private d fZQ;
    private NewSubPbActivity fZR;
    private RelativeLayout fZS;
    private View fZW;
    private SubPbModel fZu;
    private ThreadSkinView gac;
    private e gad;
    private View gag;
    private ArrayList<PostData> gak;
    private String gal;
    private RelativeLayout gam;
    private ImageView gan;
    private ImageView gao;
    private View.OnClickListener mCommonClickListener;
    private ProgressBar mProgress;
    private h mNoDataView = null;
    private TbRichTextView.h fZz = null;
    private View.OnClickListener aIl = null;
    private TbRichTextView.i fZy = null;
    private NavigationBar mNavigationBar = null;
    private View bgK = null;
    private TextView fZT = null;
    private LinearLayout fZU = null;
    private HeadImageView fZV = null;
    private ClickableHeaderImageView fUk = null;
    private TextView bfg = null;
    private ImageView fZX = null;
    private TextView fUc = null;
    private TextView fZY = null;
    private TextView fJk = null;
    private EllipsizeRichTextView fZZ = null;
    private TbImageView gaa = null;
    private PlayVoiceBntNew cXc = null;
    private TextView gab = null;
    private MorePopupWindow gae = null;
    private al gaf = null;
    private com.baidu.tbadk.core.dialog.b fUT = null;
    private Dialog fUI = null;
    private com.baidu.tbadk.core.dialog.a fUK = null;
    private boolean fIN = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener bpA = null;
    private NewSubPbActivity.a gah = null;
    private NewSubPbActivity.a gai = null;
    private com.baidu.tbadk.editortools.pb.h eTv = null;
    private String gaj = null;
    private int bKW = 0;
    private PostData fIh = null;
    private int gap = 0;
    private int gaq = 2;
    private int gar = 0;
    private boolean bsT = true;
    private View.OnClickListener fIS = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (!com.baidu.tieba.c.a.akM() || !com.baidu.tieba.c.a.b(c.this.fZR.getBaseContext(), c.this.fZR.getThreadId(), c.this.fZR.getPostId(), c.this.fZR.baG())) {
                        if (booleanValue2) {
                            sparseArray.put(d.g.tag_from, 1);
                            c.this.fZR.c(sparseArray);
                            return;
                        }
                        c.this.cy(view);
                    }
                } else if (booleanValue2) {
                    sparseArray.put(d.g.tag_from, 0);
                    c.this.fZR.c(sparseArray);
                } else if (booleanValue3) {
                    c.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c bLT = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.c.2
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            c.this.gh(false);
            c.this.bQ(view);
            c.this.gh(true);
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
    protected AdapterView.OnItemClickListener gas = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.9
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ay.ba(c.this.fZR.getPageContext().getPageActivity())) {
                if (c.this.fZI != null) {
                    c.this.fZI.ayj();
                }
                c.this.bgv();
                if (view == null || !(view.getTag() instanceof d.a)) {
                    PostData postData = (PostData) v.f(c.this.gak, i);
                    if (postData == null) {
                        c.this.gal = null;
                    } else {
                        c.this.gal = postData.getId();
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(d.g.tag_photo_username);
                        String str2 = (String) sparseArray.get(d.g.tag_photo_userid);
                        if (str != null) {
                            c.this.eTv.setReplyId(str2);
                            c.this.eTv.gG(str);
                        }
                    }
                    c.this.bgw();
                    return;
                }
                c.this.bgx();
                c.this.fZu.bgS();
            }
        }
    };

    public c(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.fFK = null;
        this.fZP = null;
        this.avh = null;
        this.fZQ = null;
        this.fZR = null;
        this.dAX = null;
        this.fZS = null;
        this.dQu = null;
        this.fZW = null;
        this.gad = null;
        this.gag = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.dQt = null;
        this.gam = null;
        this.gan = null;
        this.gao = null;
        this.fZR = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.fFK = (RelativeLayout) LayoutInflater.from(this.fZR.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_layout, (ViewGroup) null);
        this.fZP = LayoutInflater.from(this.fZR.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_head, (ViewGroup) null);
        this.dQu = (TextView) this.fFK.findViewById(d.g.no_reply_list_view);
        this.gam = (RelativeLayout) this.fFK.findViewById(d.g.subpb_editor_tool_comment);
        this.dQt = (TextView) this.fFK.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.dQt.setOnClickListener(this.mCommonClickListener);
        this.gan = (ImageView) this.fFK.findViewById(d.g.subpb_editor_tool_more_img);
        this.gao = (ImageView) this.fFK.findViewById(d.g.subpb_editor_tool_emotion_img);
        this.gao.setOnClickListener(this.mCommonClickListener);
        this.gan.setOnClickListener(this.mCommonClickListener);
        this.dAX = (NoNetworkView) this.fFK.findViewById(d.g.view_no_network);
        ayr();
        bgu();
        this.fZS = (RelativeLayout) this.fFK.findViewById(d.g.sub_pb_body_layout);
        this.avh = (BdListView) this.fFK.findViewById(d.g.new_sub_pb_list);
        this.gac = (ThreadSkinView) LayoutInflater.from(this.fZR.getPageContext().getPageActivity()).inflate(d.h.thread_skin_layout, (ViewGroup) null);
        this.avh.addHeaderView(this.gac);
        this.avh.addHeaderView(this.fZP);
        this.dvg = BdListViewHelper.a(this.fZR.getActivity(), this.avh, BdListViewHelper.HeadType.DEFAULT);
        this.fZQ = new d(this.fZR.getPageContext().getPageActivity());
        this.fZQ.H(this.fIS);
        this.fZQ.setIsFromCDN(this.mIsFromCDN);
        this.fZQ.lf(true);
        this.avh.setAdapter((ListAdapter) this.fZQ);
        this.gad = new e(this.fZR.getPageContext());
        this.gag = this.gad.getView();
        this.avh.setNextPage(this.gad);
        this.gad.setOnClickListener(this.mCommonClickListener);
        this.avh.setOnItemClickListener(this.gas);
        this.avh.setOnTouchListener(this.bLT);
        this.mProgress = (ProgressBar) this.fFK.findViewById(d.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fZP != null) {
            this.fZP.setVisibility(4);
        }
        if (this.fZS != null) {
            this.fZS.setVisibility(4);
        }
        this.fZW = com.baidu.tbadk.ala.b.vL().u(this.fZR.getActivity(), 4);
        if (this.fZW != null) {
            this.fZW.setVisibility(8);
            this.fZU.addView(this.fZW, 3);
        }
    }

    public ListView getListView() {
        return this.avh;
    }

    public void bgu() {
        this.fZU = (LinearLayout) this.fZP.findViewById(d.g.subpb_head_user_info_root);
        this.fZU.setOnClickListener(this.mCommonClickListener);
        this.fZV = (HeadImageView) this.fZP.findViewById(d.g.photo);
        this.fZV.setRadius(l.t(this.fZR.getActivity(), d.e.ds30));
        this.fZV.setClickable(false);
        this.fUk = (ClickableHeaderImageView) this.fZP.findViewById(d.g.god_user_photo);
        this.fUk.setGodIconMargin(0);
        this.fUk.setGodIconWidth(d.e.ds24);
        this.fUk.setRadius(l.t(this.fZR.getActivity(), d.e.ds30));
        this.fUk.setClickable(false);
        this.bfg = (TextView) this.fZP.findViewById(d.g.user_name);
        this.fZX = (ImageView) this.fZP.findViewById(d.g.user_rank);
        this.fZX.setVisibility(8);
        this.fUc = (TextView) this.fZP.findViewById(d.g.floor_owner);
        this.fZT = (TextView) this.fZP.findViewById(d.g.see_subject);
        this.fZT.setOnClickListener(this.mCommonClickListener);
        this.fZY = (TextView) this.fZP.findViewById(d.g.floor);
        this.fJk = (TextView) this.fZP.findViewById(d.g.time);
        this.fZZ = (EllipsizeRichTextView) this.fZP.findViewById(d.g.content_text);
        this.fZZ.setOnClickListener(this.mCommonClickListener);
        aj.r(this.fZZ, d.C0140d.cp_cont_b);
        this.fZZ.setLinkTextColor(aj.getColor(d.C0140d.cp_link_tip_c));
        this.fZZ.setLineSpacing(0.0f, 1.25f);
        this.gaa = (TbImageView) this.fZP.findViewById(d.g.sub_pb_image);
        this.gaa.setOnClickListener(this.mCommonClickListener);
        this.gab = (TextView) this.fZP.findViewById(d.g.advert);
        this.cXc = (PlayVoiceBntNew) this.fZP.findViewById(d.g.voice_btn);
        this.fZP.setOnTouchListener(this.bLT);
        this.fZP.setOnClickListener(this.mCommonClickListener);
    }

    public void gj(boolean z) {
        if (this.dvg != null && this.dvg.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.dvg.getLayoutParams();
            if (z) {
                ayv();
                layoutParams.height = l.t(this.fZR.getPageContext().getPageActivity(), d.e.ds88);
            } else {
                layoutParams.height = l.t(this.fZR.getPageContext().getPageActivity(), d.e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.dvg.setLayoutParams(layoutParams);
        }
    }

    private void ayv() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public View ayw() {
        return this.dvg;
    }

    public void ayr() {
        int t = l.t(this.fZR.getPageContext().getPageActivity(), d.e.ds88);
        int t2 = l.t(this.fZR.getPageContext().getPageActivity(), d.e.ds14);
        this.mNavigationBar = (NavigationBar) this.fFK.findViewById(d.g.view_navigation_bar);
        this.bgK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bgK.getLayoutParams();
            layoutParams.height = t;
            layoutParams.width = t;
            layoutParams.leftMargin = t2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.bgK != null && (this.bgK.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bgK.getLayoutParams();
            layoutParams2.width = t;
            layoutParams2.height = t;
            this.bgK.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar avk() {
        return this.mNavigationBar;
    }

    public void cy(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.fUI == null) {
            this.fUI = new Dialog(this.fZR.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fUI.setCanceledOnTouchOutside(true);
            this.fUI.setCancelable(true);
            View inflate = LayoutInflater.from(this.fZR.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
            this.fZR.getLayoutMode().aM(inflate);
            this.fUI.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.fUI.getWindow().getAttributes();
            attributes.width = (int) (l.ao(this.fZR.getPageContext().getPageActivity()) * 0.9d);
            this.fUI.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fUI.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fUI.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fUI.findViewById(d.g.disable_reply_btn);
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
                    if (c.this.fUI != null && (c.this.fUI instanceof Dialog)) {
                        g.b(c.this.fUI, c.this.fZR.getPageContext());
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
                    if (c.this.fUI != null && (c.this.fUI instanceof Dialog)) {
                        g.b(c.this.fUI, c.this.fZR.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && c.this.gah != null) {
                        c.this.gah.ak(new Object[]{sparseArray4.get(d.g.tag_manage_user_identity), sparseArray4.get(d.g.tag_forbid_user_name), sparseArray4.get(d.g.tag_forbid_user_post_id)});
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
                    if (c.this.fUI != null && (c.this.fUI instanceof Dialog)) {
                        g.b(c.this.fUI, c.this.fZR.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        c.this.fZR.a(z, (String) sparseArray5.get(d.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.fUI, this.fZR.getPageContext());
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
        this.fUK = new com.baidu.tbadk.core.dialog.a(this.fZR.getPageContext().getPageActivity());
        this.fUK.fb(i3);
        this.fUK.aE(sparseArray);
        this.fUK.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (c.this.gai != null) {
                    c.this.gai.ak(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.fUK.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fUK.aZ(true);
        this.fUK.b(this.fZR.getPageContext());
        this.fUK.AU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gh(final boolean z) {
        if (this.avh != null) {
            if (!z) {
                this.avh.setEnabled(z);
            } else {
                this.avh.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.c.8
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.avh.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void b(b.InterfaceC0096b interfaceC0096b, boolean z) {
        String string;
        if (this.fUT != null) {
            this.fUT.dismiss();
            this.fUT = null;
        }
        if (z) {
            string = this.fZR.getResources().getString(d.j.remove_mark);
        } else {
            string = this.fZR.getResources().getString(d.j.mark);
        }
        this.fUT = new com.baidu.tbadk.core.dialog.b(this.fZR.getPageContext().getPageActivity());
        this.fUT.fe(d.j.operation);
        this.fUT.a(new String[]{this.fZR.getResources().getString(d.j.copy), string}, interfaceC0096b);
        this.fUT.d(this.fZR.getPageContext());
        this.fUT.AX();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.gah = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.gai = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.fZR.showToast(this.fZR.getResources().getString(d.j.delete_success));
        } else if (str != null && z2) {
            this.fZR.showToast(str);
        }
    }

    public void bQ(View view) {
        if (this.dvg != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dvg.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.avh != null) {
                    this.avh.removeHeaderView(this.dvg);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.dvg.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.t(this.fZR.getActivity(), d.e.ds98)));
            } else if (this.avh != null) {
                this.avh.addHeaderView(this.dvg, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(com.baidu.tbadk.editortools.pb.h hVar) {
        if (hVar != null && hVar.Lc() != null) {
            this.eTv = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.fFK.addView(hVar.Lc(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.fZI = bVar;
    }

    public void bgv() {
        if (this.avh != null) {
            this.gar = this.avh.getLastVisiblePosition();
        }
    }

    public void bgw() {
        if (this.fZu != null) {
            if ((!bgz() && this.gag != null && this.gag.isShown()) || v.E(this.gak)) {
                this.fZu.li(false);
            } else {
                this.fZu.li(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.fZu = subPbModel;
    }

    public void bgx() {
        a(this.fZR);
        this.avh.setNextPage(this.gad);
    }

    public void n(PostData postData) {
        int i;
        if (postData != null) {
            postData.mI(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bgz() && this.gag != null && this.gag.isShown()) {
                i = (this.gar - this.gaq) - 1;
            } else {
                i = this.gar - this.gaq;
            }
            int D = v.D(this.gak);
            if (i > D) {
                i = D;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(v.b(this.gak, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.fZQ.setDatas(arrayList);
            this.fZQ.notifyDataSetChanged();
            this.avh.smoothScrollToPosition(this.gar + 2);
            this.avh.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.avh.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.avh.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.fFK;
    }

    public void bfv() {
        if (this.gae != null) {
            g.a(this.gae, this.fZR.getPageContext().getPageActivity());
        }
        if (this.fUT != null) {
            this.fUT.dismiss();
        }
        if (this.fUK != null) {
            this.fUK.dismiss();
        }
        if (this.fUI != null) {
            g.b(this.fUI, this.fZR.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.fLk != null) {
            this.fLk.dismiss();
        }
    }

    public void bgy() {
        this.avh.setNextPage(this.gad);
        this.gad.Eg();
    }

    public void jP(boolean z) {
        this.fIN = z;
    }

    public void setIsFromPb(boolean z) {
        this.bsT = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(k kVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (kVar != null) {
            if (this.bsT && this.fZP != null) {
                this.fZQ.lg(true);
                this.fZP.setVisibility(8);
                this.avh.removeHeaderView(this.fZP);
                this.gaq = 1;
            }
            this.fYt = kVar;
            this.fZQ.T(this.fYt.WE());
            if (this.fZP != null) {
                this.fZP.setVisibility(0);
            }
            if (this.fZS != null) {
                this.fZS.setVisibility(0);
            }
            if (kVar.bbd() != null) {
                this.gaj = kVar.bbd().getId();
                this.bKW = kVar.bbd().bwU();
                if (this.bKW > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.fZR.getResources().getString(d.j.subpb_floor_reply_count), am.H(kVar.getTotalCount())));
                    this.dQt.setText(d.j.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.fZR.bgt()) {
                    str = "PB";
                }
                if (kVar.bbd().zJ() != null) {
                    this.gac.a(this.fZR.getPageContext(), kVar.bbd().zJ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", kVar.bbk().getId(), kVar.bbk().getName(), kVar.WE().getId(), str));
                } else {
                    this.gac.a(null, null, null);
                }
            }
            if (kVar.hasMore()) {
                this.gad.Eg();
                this.fZQ.setHasMoreData(true);
            } else {
                this.gad.Eh();
                this.fZQ.setHasMoreData(false);
            }
            this.gak = kVar.bbh();
            if (v.E(this.gak)) {
                this.avh.setNextPage(null);
                if (this.bsT) {
                    this.dQu.setVisibility(0);
                }
            } else {
                this.avh.setNextPage(this.gad);
                if (this.bsT) {
                    this.dQu.setVisibility(8);
                }
            }
            if (this.gak == null || this.gak.size() <= fZO) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.gak.size() - fZO;
                tk(size);
                int firstVisiblePosition = this.avh.getFirstVisiblePosition() - size;
                View childAt = this.avh.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.fZQ.setDatas(this.gak);
            boolean z2 = false;
            if (kVar.WE() != null && kVar.WE().zn() != null && (userId = kVar.WE().zn().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.fZQ.P(i, z2);
            this.fZQ.notifyDataSetChanged();
            a(kVar.bbd(), kVar.aLq(), kVar.vX(), i, z);
            if (i4 > 0) {
                this.avh.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void tk(int i) {
        if (this.gak != null) {
            if (this.gak.size() <= i) {
                this.gak.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.gak.iterator();
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

    public boolean bgz() {
        return this.fZQ.dfX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.bsT) {
            this.fIh = postData;
            if (!StringUtils.isNull(postData.bxc())) {
                this.gaa.setVisibility(0);
                this.gaa.startLoad(postData.bxc(), 10, true);
            } else {
                this.gaa.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.h bxe = postData.bxe();
            if (bxe != null && bxe.hay) {
                this.gab.setVisibility(0);
            } else {
                this.gab.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.fZP.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.fZP.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.fZY.setText((CharSequence) null);
            this.bfg.setText((CharSequence) null);
            this.fUc.setVisibility(8);
            if (!this.bsT) {
                c(postData.zn());
                if (z) {
                    this.fUc.setVisibility(0);
                    aj.r(this.fUc, d.C0140d.cp_link_tip_a);
                }
            }
            this.fJk.setText(am.z(postData.getTime()));
            this.fZY.setText(String.format(this.fZR.getPageContext().getString(d.j.is_floor), Integer.valueOf(postData.bwU())));
            postData.zn().getUserTbVipInfoData();
            boolean a = a(this.fZZ, postData.bwX());
            if (StringUtils.isNull(postData.bxc()) && !a && postData.Rq() != null) {
                this.cXc.setVisibility(0);
                this.cXc.setTag(postData.Rq());
                return;
            }
            this.cXc.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.k.aX(metaData.getSealPrefix()) + 2 : 0) + w.hs(name_show) > 14) {
                name_show = w.j(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.bfg.setText(af(metaData.getSealPrefix(), name_show));
            } else {
                this.bfg.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.fZW != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.fZW.setVisibility(8);
                } else {
                    this.fZW.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.aHe = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.fZW.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.fUk.setVisibility(0);
                this.fZV.setVisibility(8);
                this.fUk.setUserId(metaData.getUserId());
                this.fUk.setUserName(metaData.getUserName());
                this.fUk.startLoad(metaData.getPortrait(), 28, false);
                aj.r(this.bfg, d.C0140d.cp_cont_r);
            } else {
                this.fUk.setVisibility(8);
                this.fZV.setVisibility(0);
                this.fZV.setUserId(metaData.getUserId());
                this.fZV.setUserName(metaData.getUserName());
                this.fZV.setDefaultResource(d.f.transparent_bg);
                this.fZV.setDefaultErrorResource(d.f.icon_default_avatar100);
                this.fZV.startLoad(metaData.getPortrait(), 28, false);
                aj.r(this.bfg, d.C0140d.cp_cont_c);
            }
            this.fZU.setTag(d.g.tag_user_id, metaData.getUserId());
            this.fZU.setTag(d.g.tag_user_name, metaData.getUserName());
            this.fZU.setTag(d.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.Ri() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.Ri().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.Rp());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.cN(true);
                        textView.setMovementMethod(com.baidu.tieba.view.e.bEM());
                        continue;
                    case 17:
                        String str = next.Rt().mGifInfo.mSharpText;
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
        if (!tbRichTextData.Ry()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.Rp() == null || tbRichTextData.Rp().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.Rp());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fZR.getPageContext().getString(d.j.refresh_view_title_text), this.aIl));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.fZR.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.fZS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.f.pic_emotion07, l.t(pageActivity, d.e.ds250), l.t(pageActivity, d.e.ds480), l.t(pageActivity, d.e.ds360)), dVar, a);
        }
        this.fZS.setVisibility(0);
        this.avh.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.eTv.LX();
        aj.t(this.mNoDataView, d.C0140d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.fZR.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void lc(int i) {
        b(NoDataViewFactory.d.aC(i, d.j.refresh_view_title_text));
        if (this.fZI != null) {
            this.fZI.cB(this.fFK);
        }
        this.gam.setVisibility(8);
    }

    public void lS(String str) {
        b(NoDataViewFactory.d.ae(str, this.fZR.getPageContext().getString(d.j.refresh_view_title_text)));
        if (this.fZI != null) {
            this.fZI.cB(this.fFK);
        }
        this.gam.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.avh.setVisibility(0);
            this.gam.setVisibility(0);
            this.fFK.setOnTouchListener(null);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.aIl = onClickListener;
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
                String userId2 = postData.zn().getUserId();
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
            if (this.fYt != null && this.fYt.WE() != null && this.fYt.WE().zn() != null && postData.zn() != null) {
                String userId3 = this.fYt.WE().zn().getUserId();
                String userId4 = postData.zn().getUserId();
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
                    userId = postData.zn().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.bwU() != 1 ? 0 : 1;
                    if (aq.k(postData)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(d.g.tag_forbid_user_name, postData.zn().getUserName());
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
                        sparseArray.put(d.g.tag_forbid_user_name, postData.zn().getUserName());
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.zn() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.zn().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.zn().getUserName());
                        }
                        if (this.fYt.WE() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fYt.WE().getId());
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
            userId = postData.zn().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.bwU() != 1) {
            }
            if (aq.k(postData)) {
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

    public void le(boolean z) {
        if (this.fLk != null && this.fLk.bdY() != null) {
            if (z) {
                this.fLk.bdY().setText(d.j.remove_mark);
            } else {
                this.fLk.bdY().setText(d.j.mark);
            }
            this.fLk.refreshUI();
        }
    }

    public View bgA() {
        return this.gag;
    }

    public void onChangeSkinType(int i) {
        this.fZR.getLayoutMode().aQ(i == 1);
        this.fZR.getLayoutMode().aM(this.fFK);
        this.fZR.getLayoutMode().aM(this.fZP);
        this.mNavigationBar.onChangeSkinType(this.fZR.getPageContext(), i);
        if (this.fZT != null) {
            aj.r(this.fZT, d.C0140d.goto_see_subject_color);
        }
        aj.r(this.dQu, d.C0140d.cp_cont_d);
        this.dAX.onChangeSkinType(this.fZR.getPageContext(), i);
        this.fZR.getLayoutMode().aM(this.gag);
        aj.r(this.fZZ, d.C0140d.cp_cont_b);
        this.fZZ.setLinkTextColor(aj.getColor(d.C0140d.cp_link_tip_c));
        if (this.eTv != null && this.eTv.Lc() != null) {
            this.eTv.Lc().onChangeSkinType(i);
        }
        this.gad.gx(i);
        this.cXc.aNR();
        aj.r(this.dQt, d.C0140d.cp_cont_e);
        aj.r(this.fUc, d.C0140d.cp_link_tip_a);
        aj.r(this.bfg, d.C0140d.cp_cont_c);
        this.dQt.setAlpha(0.95f);
        if (this.fZQ != null) {
            this.fZQ.notifyDataSetChanged();
        }
    }

    public void bgB() {
        this.mProgress.setVisibility(0);
    }

    public void bgC() {
        this.avh.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.gad.Eh();
    }

    public void asv() {
        this.avh.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.gad.asv();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bpA = onLongClickListener;
        this.fZP.setOnLongClickListener(this.bpA);
    }

    public View bgD() {
        return this.fZP;
    }

    public TextView ayx() {
        return this.dQt;
    }

    public ImageView bgE() {
        return this.gan;
    }

    public ImageView bgF() {
        return this.gao;
    }

    public void qI(String str) {
        int qJ = this.fZQ.qJ(str);
        if (qJ > -1) {
            this.fZQ.tl(qJ);
            if (qJ > 2) {
                this.avh.setSelection(qJ - 2);
            } else {
                this.avh.setSelection(qJ);
            }
            this.avh.invalidate();
        }
    }

    public View bgG() {
        return this.fZT;
    }

    public View bgH() {
        return this.gaa;
    }

    public MorePopupWindow bgI() {
        return this.gae;
    }

    public void showLoadingDialog() {
        if (this.dgK == null) {
            this.dgK = new com.baidu.tbadk.core.view.b(this.fZR.getPageContext());
        }
        this.dgK.bq(true);
    }

    public void agg() {
        if (this.dgK != null) {
            this.dgK.bq(false);
        }
    }

    public TextView bgJ() {
        return this.fZZ;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.fZy = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fZz = hVar;
    }

    public x bgK() {
        return this.fLk;
    }

    public void axC() {
    }

    public void axD() {
    }

    public void onActivityDestroy() {
    }

    public void bgL() {
        if (this.fZR.isPaused()) {
        }
    }

    public View bgM() {
        return this.fZU;
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new j.a(str, d.f.pic_smalldot_title));
            return j.a((Context) this.fZR.getActivity(), str2, (ArrayList<j.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
