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
import com.baidu.tbadk.core.util.am;
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
import com.baidu.tieba.pb.pb.main.al;
import com.baidu.tieba.pb.pb.main.aq;
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class c {
    private static final int fhG = TbadkCoreApplication.getInst().getListItemRule().yd();
    private BdListView Hh;
    private NoNetworkView cDR;
    private TextView cWi;
    private TextView cWj;
    private com.baidu.tbadk.core.view.b ckj;
    private View cyP;
    private RelativeLayout eNL;
    private y eTz;
    private m fgl;
    private b fhA;
    private View fhH;
    private d fhI;
    private NewSubPbActivity fhJ;
    private RelativeLayout fhK;
    private View fhO;
    private ThreadSkinView fhU;
    private e fhV;
    private View fhY;
    private SubPbModel fhm;
    private ArrayList<PostData> fic;
    private String fie;
    private RelativeLayout fif;
    private ImageView fig;
    private ImageView fih;
    private View.OnClickListener mCommonClickListener;
    private ProgressBar mProgress;
    private g mNoDataView = null;
    private TbRichTextView.g fhr = null;
    private View.OnClickListener Sl = null;
    private TbRichTextView.h fhq = null;
    private NavigationBar mNavigationBar = null;
    private View aqB = null;
    private TextView fhL = null;
    private LinearLayout fhM = null;
    private HeadImageView fhN = null;
    private ClickableHeaderImageView fcg = null;
    private TextView aoX = null;
    private ImageView fhP = null;
    private TextView fbW = null;
    private TextView fhQ = null;
    private TextView eRm = null;
    private EllipsizeRichTextView fhR = null;
    private TbImageView fhS = null;
    private PlayVoiceBntNew caM = null;
    private TextView fhT = null;
    private MorePopupWindow fhW = null;
    private al fhX = null;
    private com.baidu.tbadk.core.dialog.b fcP = null;
    private Dialog fcE = null;
    private com.baidu.tbadk.core.dialog.a fcG = null;
    private boolean eQP = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener ayM = null;
    private NewSubPbActivity.a fhZ = null;
    private NewSubPbActivity.a fia = null;
    private h ebc = null;
    private String fib = null;
    private int aUL = 0;
    private PostData eQj = null;
    private int fii = 0;
    private int fij = 2;
    private int fik = 0;
    private boolean aCq = true;
    private View.OnClickListener eQU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (!com.baidu.tieba.c.a.abp() || !com.baidu.tieba.c.a.a(c.this.fhJ.getBaseContext(), c.this.fhJ.getThreadId(), c.this.fhJ.getPostId(), c.this.fhJ.aRA())) {
                        if (booleanValue2) {
                            sparseArray.put(d.g.tag_from, 1);
                            c.this.fhJ.c(sparseArray);
                            return;
                        }
                        c.this.bm(view);
                    }
                } else if (booleanValue2) {
                    sparseArray.put(d.g.tag_from, 0);
                    c.this.fhJ.c(sparseArray);
                } else if (booleanValue3) {
                    c.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aVH = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.c.2
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            c.this.fv(false);
            c.this.aE(view);
            c.this.fv(true);
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
    protected AdapterView.OnItemClickListener fil = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.9
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ax.aS(c.this.fhJ.getPageContext().getPageActivity())) {
                if (c.this.fhA != null) {
                    c.this.fhA.apc();
                }
                c.this.aXv();
                if (view == null || !(view.getTag() instanceof d.a)) {
                    PostData postData = (PostData) v.c(c.this.fic, i);
                    if (postData == null) {
                        c.this.fie = null;
                    } else {
                        c.this.fie = postData.getId();
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(d.g.tag_photo_username);
                        String str2 = (String) sparseArray.get(d.g.tag_photo_userid);
                        if (str != null) {
                            c.this.ebc.setReplyId(str2);
                            c.this.ebc.gg(str);
                        }
                    }
                    c.this.aXw();
                    return;
                }
                c.this.aXx();
                c.this.fhm.aXS();
            }
        }
    };

    public c(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.eNL = null;
        this.fhH = null;
        this.Hh = null;
        this.fhI = null;
        this.fhJ = null;
        this.cDR = null;
        this.fhK = null;
        this.cWj = null;
        this.fhO = null;
        this.fhV = null;
        this.fhY = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.cWi = null;
        this.fif = null;
        this.fig = null;
        this.fih = null;
        this.fhJ = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.eNL = (RelativeLayout) LayoutInflater.from(this.fhJ.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_layout, (ViewGroup) null);
        this.fhH = LayoutInflater.from(this.fhJ.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_head, (ViewGroup) null);
        this.cWj = (TextView) this.eNL.findViewById(d.g.no_reply_list_view);
        this.fif = (RelativeLayout) this.eNL.findViewById(d.g.subpb_editor_tool_comment);
        this.cWi = (TextView) this.eNL.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.cWi.setOnClickListener(this.mCommonClickListener);
        this.fig = (ImageView) this.eNL.findViewById(d.g.subpb_editor_tool_more_img);
        this.fih = (ImageView) this.eNL.findViewById(d.g.subpb_editor_tool_emotion_img);
        this.fih.setOnClickListener(this.mCommonClickListener);
        this.fig.setOnClickListener(this.mCommonClickListener);
        this.cDR = (NoNetworkView) this.eNL.findViewById(d.g.view_no_network);
        apk();
        aXu();
        this.fhK = (RelativeLayout) this.eNL.findViewById(d.g.sub_pb_body_layout);
        this.Hh = (BdListView) this.eNL.findViewById(d.g.new_sub_pb_list);
        this.fhU = (ThreadSkinView) LayoutInflater.from(this.fhJ.getPageContext().getPageActivity()).inflate(d.h.thread_skin_layout, (ViewGroup) null);
        this.Hh.addHeaderView(this.fhU);
        this.Hh.addHeaderView(this.fhH);
        this.cyP = BdListViewHelper.a(this.fhJ.getActivity(), this.Hh, BdListViewHelper.HeadType.DEFAULT);
        this.fhI = new d(this.fhJ.getPageContext().getPageActivity());
        this.fhI.G(this.eQU);
        this.fhI.setIsFromCDN(this.mIsFromCDN);
        this.fhI.ko(true);
        this.Hh.setAdapter((ListAdapter) this.fhI);
        this.fhV = new e(this.fhJ.getPageContext());
        this.fhY = this.fhV.getView();
        this.Hh.setNextPage(this.fhV);
        this.fhV.setOnClickListener(this.mCommonClickListener);
        this.Hh.setOnItemClickListener(this.fil);
        this.Hh.setOnTouchListener(this.aVH);
        this.mProgress = (ProgressBar) this.eNL.findViewById(d.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fhH != null) {
            this.fhH.setVisibility(4);
        }
        if (this.fhK != null) {
            this.fhK.setVisibility(4);
        }
        this.fhO = com.baidu.tbadk.ala.b.nv().g(this.fhJ.getActivity(), 4);
        if (this.fhO != null) {
            this.fhO.setVisibility(8);
            this.fhM.addView(this.fhO, 3);
        }
    }

    public ListView getListView() {
        return this.Hh;
    }

    public void aXu() {
        this.fhM = (LinearLayout) this.fhH.findViewById(d.g.subpb_head_user_info_root);
        this.fhM.setOnClickListener(this.mCommonClickListener);
        this.fhN = (HeadImageView) this.fhH.findViewById(d.g.photo);
        this.fhN.setRadius(l.f(this.fhJ.getActivity(), d.e.ds30));
        this.fhN.setClickable(false);
        this.fcg = (ClickableHeaderImageView) this.fhH.findViewById(d.g.god_user_photo);
        this.fcg.setGodIconMargin(0);
        this.fcg.setGodIconWidth(d.e.ds24);
        this.fcg.setRadius(l.f(this.fhJ.getActivity(), d.e.ds30));
        this.fcg.setClickable(false);
        this.aoX = (TextView) this.fhH.findViewById(d.g.user_name);
        this.fhP = (ImageView) this.fhH.findViewById(d.g.user_rank);
        this.fhP.setVisibility(8);
        this.fbW = (TextView) this.fhH.findViewById(d.g.floor_owner);
        this.fhL = (TextView) this.fhH.findViewById(d.g.see_subject);
        this.fhL.setOnClickListener(this.mCommonClickListener);
        this.fhQ = (TextView) this.fhH.findViewById(d.g.floor);
        this.eRm = (TextView) this.fhH.findViewById(d.g.time);
        this.fhR = (EllipsizeRichTextView) this.fhH.findViewById(d.g.content_text);
        this.fhR.setOnClickListener(this.mCommonClickListener);
        aj.i(this.fhR, d.C0096d.cp_cont_b);
        this.fhR.setLinkTextColor(aj.getColor(d.C0096d.cp_link_tip_c));
        this.fhR.setLineSpacing(0.0f, 1.25f);
        this.fhS = (TbImageView) this.fhH.findViewById(d.g.sub_pb_image);
        this.fhS.setOnClickListener(this.mCommonClickListener);
        this.fhT = (TextView) this.fhH.findViewById(d.g.advert);
        this.caM = (PlayVoiceBntNew) this.fhH.findViewById(d.g.voice_btn);
        this.fhH.setOnTouchListener(this.aVH);
        this.fhH.setOnClickListener(this.mCommonClickListener);
    }

    public void fx(boolean z) {
        if (this.cyP != null && this.cyP.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cyP.getLayoutParams();
            if (z) {
                apo();
                layoutParams.height = l.f(this.fhJ.getPageContext().getPageActivity(), d.e.ds88);
            } else {
                layoutParams.height = l.f(this.fhJ.getPageContext().getPageActivity(), d.e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.cyP.setLayoutParams(layoutParams);
        }
    }

    private void apo() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public View app() {
        return this.cyP;
    }

    public void apk() {
        int f = l.f(this.fhJ.getPageContext().getPageActivity(), d.e.ds88);
        int f2 = l.f(this.fhJ.getPageContext().getPageActivity(), d.e.ds14);
        this.mNavigationBar = (NavigationBar) this.eNL.findViewById(d.g.view_navigation_bar);
        this.aqB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqB.getLayoutParams();
            layoutParams.height = f;
            layoutParams.width = f;
            layoutParams.leftMargin = f2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aqB != null && (this.aqB.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aqB.getLayoutParams();
            layoutParams2.width = f;
            layoutParams2.height = f;
            this.aqB.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar alD() {
        return this.mNavigationBar;
    }

    public void bm(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.fcE == null) {
            this.fcE = new Dialog(this.fhJ.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fcE.setCanceledOnTouchOutside(true);
            this.fcE.setCancelable(true);
            View inflate = LayoutInflater.from(this.fhJ.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
            this.fhJ.getLayoutMode().t(inflate);
            this.fcE.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.fcE.getWindow().getAttributes();
            attributes.width = (int) (l.ac(this.fhJ.getPageContext().getPageActivity()) * 0.9d);
            this.fcE.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fcE.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fcE.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fcE.findViewById(d.g.disable_reply_btn);
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
                    if (c.this.fcE != null && (c.this.fcE instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(c.this.fcE, c.this.fhJ.getPageContext());
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
                    if (c.this.fcE != null && (c.this.fcE instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(c.this.fcE, c.this.fhJ.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && c.this.fhZ != null) {
                        c.this.fhZ.f(new Object[]{sparseArray4.get(d.g.tag_manage_user_identity), sparseArray4.get(d.g.tag_forbid_user_name), sparseArray4.get(d.g.tag_forbid_user_post_id)});
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
                    if (c.this.fcE != null && (c.this.fcE instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(c.this.fcE, c.this.fhJ.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        c.this.fhJ.a(z, (String) sparseArray5.get(d.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fcE, this.fhJ.getPageContext());
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
        this.fcG = new com.baidu.tbadk.core.dialog.a(this.fhJ.getPageContext().getPageActivity());
        this.fcG.cd(i3);
        this.fcG.z(sparseArray);
        this.fcG.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (c.this.fia != null) {
                    c.this.fia.f(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.fcG.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fcG.ao(true);
        this.fcG.b(this.fhJ.getPageContext());
        this.fcG.th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fv(final boolean z) {
        if (this.Hh != null) {
            if (!z) {
                this.Hh.setEnabled(z);
            } else {
                this.Hh.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.c.8
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.Hh.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void b(b.InterfaceC0061b interfaceC0061b, boolean z) {
        String string;
        if (this.fcP != null) {
            this.fcP.dismiss();
            this.fcP = null;
        }
        if (z) {
            string = this.fhJ.getResources().getString(d.j.remove_mark);
        } else {
            string = this.fhJ.getResources().getString(d.j.mark);
        }
        this.fcP = new com.baidu.tbadk.core.dialog.b(this.fhJ.getPageContext().getPageActivity());
        this.fcP.cg(d.j.operation);
        this.fcP.a(new String[]{this.fhJ.getResources().getString(d.j.copy), string}, interfaceC0061b);
        this.fcP.d(this.fhJ.getPageContext());
        this.fcP.tl();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.fhZ = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.fia = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.fhJ.showToast(this.fhJ.getResources().getString(d.j.delete_success));
        } else if (str != null && z2) {
            this.fhJ.showToast(str);
        }
    }

    public void aE(View view) {
        if (this.cyP != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cyP.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.Hh != null) {
                    this.Hh.removeHeaderView(this.cyP);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.cyP.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.f(this.fhJ.getActivity(), d.e.ds98)));
            } else if (this.Hh != null) {
                this.Hh.addHeaderView(this.cyP, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(h hVar) {
        if (hVar != null && hVar.De() != null) {
            this.ebc = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.eNL.addView(hVar.De(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.fhA = bVar;
    }

    public void aXv() {
        if (this.Hh != null) {
            this.fik = this.Hh.getLastVisiblePosition();
        }
    }

    public void aXw() {
        if (this.fhm != null) {
            if ((!aXz() && this.fhY != null && this.fhY.isShown()) || v.w(this.fic)) {
                this.fhm.kr(false);
            } else {
                this.fhm.kr(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.fhm = subPbModel;
    }

    public void aXx() {
        a(this.fhJ);
        this.Hh.setNextPage(this.fhV);
    }

    public void n(PostData postData) {
        int i;
        if (postData != null) {
            postData.nc(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!aXz() && this.fhY != null && this.fhY.isShown()) {
                i = (this.fik - this.fij) - 1;
            } else {
                i = this.fik - this.fij;
            }
            int v = v.v(this.fic);
            if (i > v) {
                i = v;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(v.a(this.fic, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.fhI.setDatas(arrayList);
            this.fhI.notifyDataSetChanged();
            this.Hh.smoothScrollToPosition(this.fik + 2);
            this.Hh.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Hh.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.Hh.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.eNL;
    }

    public void aWw() {
        if (this.fhW != null) {
            com.baidu.adp.lib.g.g.a(this.fhW, this.fhJ.getPageContext().getPageActivity());
        }
        if (this.fcP != null) {
            this.fcP.dismiss();
        }
        if (this.fcG != null) {
            this.fcG.dismiss();
        }
        if (this.fcE != null) {
            com.baidu.adp.lib.g.g.b(this.fcE, this.fhJ.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.eTz != null) {
            this.eTz.dismiss();
        }
    }

    public void aXy() {
        this.Hh.setNextPage(this.fhV);
        this.fhV.wv();
    }

    public void iY(boolean z) {
        this.eQP = z;
    }

    public void setIsFromPb(boolean z) {
        this.aCq = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(m mVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (mVar != null) {
            if (this.aCq && this.fhH != null) {
                this.fhI.kp(true);
                this.fhH.setVisibility(8);
                this.Hh.removeHeaderView(this.fhH);
                this.fij = 1;
            }
            this.fgl = mVar;
            this.fhI.R(this.fgl.Ox());
            if (this.fhH != null) {
                this.fhH.setVisibility(0);
            }
            if (this.fhK != null) {
                this.fhK.setVisibility(0);
            }
            if (mVar.aSb() != null) {
                this.fib = mVar.aSb().getId();
                this.aUL = mVar.aSb().bwU();
                if (this.aUL > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.fhJ.getResources().getString(d.j.subpb_floor_reply_count), am.y(mVar.getTotalCount())));
                    this.cWi.setText(d.j.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.fhJ.aXt()) {
                    str = "PB";
                }
                if (mVar.aSb().rR() != null) {
                    this.fhU.a(this.fhJ.getPageContext(), mVar.aSb().rR(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", mVar.aSi().getId(), mVar.aSi().getName(), mVar.Ox().getId(), str));
                } else {
                    this.fhU.a(null, null, null);
                }
            }
            if (mVar.hasMore()) {
                this.fhV.wv();
                this.fhI.setHasMoreData(true);
            } else {
                this.fhV.ww();
                this.fhI.setHasMoreData(false);
            }
            this.fic = mVar.aSf();
            if (v.w(this.fic)) {
                this.Hh.setNextPage(null);
                if (this.aCq) {
                    this.cWj.setVisibility(0);
                }
            } else {
                this.Hh.setNextPage(this.fhV);
                if (this.aCq) {
                    this.cWj.setVisibility(8);
                }
            }
            if (this.fic == null || this.fic.size() <= fhG) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.fic.size() - fhG;
                qu(size);
                int firstVisiblePosition = this.Hh.getFirstVisiblePosition() - size;
                View childAt = this.Hh.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.fhI.setDatas(this.fic);
            boolean z2 = false;
            if (mVar.Ox() != null && mVar.Ox().rv() != null && (userId = mVar.Ox().rv().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.fhI.y(i, z2);
            this.fhI.notifyDataSetChanged();
            a(mVar.aSb(), mVar.aCC(), mVar.nH(), i, z);
            if (i4 > 0) {
                this.Hh.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void qu(int i) {
        if (this.fic != null) {
            if (this.fic.size() <= i) {
                this.fic.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.fic.iterator();
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

    public boolean aXz() {
        return this.fhI.cjE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.aCq) {
            this.eQj = postData;
            if (!StringUtils.isNull(postData.bxb())) {
                this.fhS.setVisibility(0);
                this.fhS.startLoad(postData.bxb(), 10, true);
            } else {
                this.fhS.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.h bxd = postData.bxd();
            if (bxd != null && bxd.gBw) {
                this.fhT.setVisibility(0);
            } else {
                this.fhT.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.fhH.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.fhH.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.fhQ.setText((CharSequence) null);
            this.aoX.setText((CharSequence) null);
            this.fbW.setVisibility(8);
            if (!this.aCq) {
                c(postData.rv());
                if (z) {
                    this.fbW.setVisibility(0);
                    aj.i(this.fbW, d.C0096d.cp_link_tip_a);
                }
            }
            this.eRm.setText(am.r(postData.getTime()));
            this.fhQ.setText(String.format(this.fhJ.getPageContext().getString(d.j.is_floor), Integer.valueOf(postData.bwU())));
            postData.rv().getUserTbVipInfoData();
            boolean a = a(this.fhR, postData.bwX());
            if (StringUtils.isNull(postData.bxb()) && !a && postData.Jz() != null) {
                this.caM.setVisibility(0);
                this.caM.setTag(postData.Jz());
                return;
            }
            this.caM.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.aP(metaData.getSealPrefix()) + 2 : 0) + w.gX(name_show) > 14) {
                name_show = w.e(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.aoX.setText(ag(metaData.getSealPrefix(), name_show));
            } else {
                this.aoX.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.fhO != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.fhO.setVisibility(8);
                } else {
                    this.fhO.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.Rb = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.fhO.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.fcg.setVisibility(0);
                this.fhN.setVisibility(8);
                this.fcg.setUserId(metaData.getUserId());
                this.fcg.setUserName(metaData.getUserName());
                this.fcg.startLoad(metaData.getPortrait(), 28, false);
                aj.i(this.aoX, d.C0096d.cp_cont_r);
            } else {
                this.fcg.setVisibility(8);
                this.fhN.setVisibility(0);
                this.fhN.setUserId(metaData.getUserId());
                this.fhN.setUserName(metaData.getUserName());
                this.fhN.setDefaultResource(d.f.transparent_bg);
                this.fhN.setDefaultErrorResource(d.f.icon_default_avatar100);
                this.fhN.startLoad(metaData.getPortrait(), 28, false);
                aj.i(this.aoX, d.C0096d.cp_cont_c);
            }
            this.fhM.setTag(d.g.tag_user_id, metaData.getUserId());
            this.fhM.setTag(d.g.tag_user_name, metaData.getUserName());
            this.fhM.setTag(d.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.Jr() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.Jr().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.Jy());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.ch(true);
                        textView.setMovementMethod(com.baidu.tieba.view.d.bEJ());
                        continue;
                    case 17:
                        String str = next.JC().mGifInfo.mSharpText;
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
        if (!tbRichTextData.JH()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.Jy() == null || tbRichTextData.Jy().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.Jy());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fhJ.getPageContext().getString(d.j.refresh_view_title_text), this.Sl));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.fhJ.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.fhK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.f.pic_emotion07, l.f(pageActivity, d.e.ds300), l.f(pageActivity, d.e.ds480), l.f(pageActivity, d.e.ds360)), dVar, a);
        }
        this.fhK.setVisibility(0);
        this.Hh.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.ebc.Ea();
        aj.k(this.mNoDataView, d.C0096d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.fhJ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void gV(int i) {
        b(NoDataViewFactory.d.D(i, d.j.refresh_view_title_text));
        if (this.fhA != null) {
            this.fhA.bp(this.eNL);
        }
        this.fif.setVisibility(8);
    }

    public void ll(String str) {
        b(NoDataViewFactory.d.af(str, this.fhJ.getPageContext().getString(d.j.refresh_view_title_text)));
        if (this.fhA != null) {
            this.fhA.bp(this.eNL);
        }
        this.fif.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Hh.setVisibility(0);
            this.fif.setVisibility(0);
            this.eNL.setOnTouchListener(null);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.Sl = onClickListener;
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
                String userId2 = postData.rv().getUserId();
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
            if (this.fgl != null && this.fgl.Ox() != null && this.fgl.Ox().rv() != null && postData.rv() != null) {
                String userId3 = this.fgl.Ox().rv().getUserId();
                String userId4 = postData.rv().getUserId();
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
                    userId = postData.rv().getUserId();
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
                        sparseArray.put(d.g.tag_forbid_user_name, postData.rv().getUserName());
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
                        sparseArray.put(d.g.tag_forbid_user_name, postData.rv().getUserName());
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.rv() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.rv().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.rv().getUserName());
                        }
                        if (this.fgl.Ox() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fgl.Ox().getId());
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
            userId = postData.rv().getUserId();
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

    public void kn(boolean z) {
        if (this.eTz != null && this.eTz.aUZ() != null) {
            if (z) {
                this.eTz.aUZ().setText(d.j.remove_mark);
            } else {
                this.eTz.aUZ().setText(d.j.mark);
            }
            this.eTz.refreshUI();
        }
    }

    public View aXA() {
        return this.fhY;
    }

    public void onChangeSkinType(int i) {
        this.fhJ.getLayoutMode().ag(i == 1);
        this.fhJ.getLayoutMode().t(this.eNL);
        this.fhJ.getLayoutMode().t(this.fhH);
        this.mNavigationBar.onChangeSkinType(this.fhJ.getPageContext(), i);
        if (this.fhL != null) {
            aj.i(this.fhL, d.C0096d.goto_see_subject_color);
        }
        aj.i(this.cWj, d.C0096d.cp_cont_d);
        this.cDR.onChangeSkinType(this.fhJ.getPageContext(), i);
        this.fhJ.getLayoutMode().t(this.fhY);
        aj.i(this.fhR, d.C0096d.cp_cont_b);
        this.fhR.setLinkTextColor(aj.getColor(d.C0096d.cp_link_tip_c));
        if (this.ebc != null && this.ebc.De() != null) {
            this.ebc.De().onChangeSkinType(i);
        }
        this.fhV.dz(i);
        this.caM.bme();
        aj.i(this.cWi, d.C0096d.cp_cont_e);
        aj.i(this.fbW, d.C0096d.cp_link_tip_a);
        aj.i(this.aoX, d.C0096d.cp_cont_c);
        this.cWi.setAlpha(0.95f);
        if (this.fhI != null) {
            this.fhI.notifyDataSetChanged();
        }
    }

    public void aXB() {
        this.mProgress.setVisibility(0);
    }

    public void aXC() {
        this.Hh.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fhV.ww();
    }

    public void aiX() {
        this.Hh.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fhV.aiX();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ayM = onLongClickListener;
        this.fhH.setOnLongClickListener(this.ayM);
    }

    public View aXD() {
        return this.fhH;
    }

    public TextView apq() {
        return this.cWi;
    }

    public ImageView aXE() {
        return this.fig;
    }

    public ImageView aXF() {
        return this.fih;
    }

    public void qf(String str) {
        int qg = this.fhI.qg(str);
        if (qg > -1) {
            this.fhI.qv(qg);
            if (qg > 2) {
                this.Hh.setSelection(qg - 2);
            } else {
                this.Hh.setSelection(qg);
            }
            this.Hh.invalidate();
        }
    }

    public View aXG() {
        return this.fhL;
    }

    public View aXH() {
        return this.fhS;
    }

    public MorePopupWindow aXI() {
        return this.fhW;
    }

    public void showLoadingDialog() {
        if (this.ckj == null) {
            this.ckj = new com.baidu.tbadk.core.view.b(this.fhJ.getPageContext());
        }
        this.ckj.aE(true);
    }

    public void XC() {
        if (this.ckj != null) {
            this.ckj.aE(false);
        }
    }

    public TextView aXJ() {
        return this.fhR;
    }

    public void setOnLinkImageClickListener(TbRichTextView.h hVar) {
        this.fhq = hVar;
    }

    public void setOnImageClickListener(TbRichTextView.g gVar) {
        this.fhr = gVar;
    }

    public y aXK() {
        return this.eTz;
    }

    public void anU() {
    }

    public void anV() {
    }

    public void onActivityDestroy() {
    }

    public void aXL() {
        if (this.fhJ.aeF()) {
        }
    }

    public View aXM() {
        return this.fhM;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.k.a((Context) this.fhJ.getActivity(), str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
