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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.pb.pb.main.aj;
import com.baidu.tieba.pb.pb.main.ao;
import com.baidu.tieba.pb.pb.main.w;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.h;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class c {
    private static final int eZQ = TbadkCoreApplication.getInst().getListItemRule().yb();
    private BdListView Hj;
    private TextView cMK;
    private TextView cML;
    private com.baidu.tbadk.core.view.a cbu;
    private View cpW;
    private NoNetworkView cuD;
    private RelativeLayout eEZ;
    private w eKS;
    private m eYw;
    private b eZJ;
    private View eZR;
    private d eZS;
    private NewSubPbActivity eZT;
    private RelativeLayout eZU;
    private View eZY;
    private SubPbModel eZv;
    private ThreadSkinView fae;
    private e faf;
    private View fai;
    private ArrayList<PostData> fam;
    private String fan;
    private RelativeLayout fao;
    private ImageView fap;
    private ImageView faq;
    private View.OnClickListener mCommonClickListener;
    private ProgressBar mProgress;
    private f mNoDataView = null;
    private TbRichTextView.f eZA = null;
    private View.OnClickListener RF = null;
    private TbRichTextView.g eZz = null;
    private NavigationBar mNavigationBar = null;
    private View aqg = null;
    private TextView eZV = null;
    private LinearLayout eZW = null;
    private HeadImageView eZX = null;
    private ClickableHeaderImageView eSv = null;
    private TextView aoD = null;
    private ImageView eZZ = null;
    private TextView eSl = null;
    private TextView faa = null;
    private TextView eIG = null;
    private EllipsizeRichTextView fab = null;
    private TbImageView fac = null;
    private PlayVoiceBntNew bSW = null;
    private TextView fad = null;
    private MorePopupWindow fag = null;
    private aj fah = null;
    private com.baidu.tbadk.core.dialog.b eTe = null;
    private Dialog eSS = null;
    private com.baidu.tbadk.core.dialog.a eSU = null;
    private boolean eIj = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener ayg = null;
    private NewSubPbActivity.a faj = null;
    private NewSubPbActivity.a fak = null;
    private com.baidu.tbadk.editortools.pb.f dSh = null;
    private String fal = null;
    private int aRK = 0;
    private PostData eHv = null;
    private int far = 0;
    private int fas = 2;
    private int fat = 0;
    private boolean eZK = true;
    private View.OnClickListener eIo = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (!com.baidu.tieba.c.a.ZF() || !com.baidu.tieba.c.a.a(c.this.eZT.getBaseContext(), c.this.eZT.getThreadId(), c.this.eZT.getPostId(), c.this.eZT.aQh())) {
                        if (booleanValue2) {
                            sparseArray.put(d.g.tag_from, 1);
                            c.this.eZT.c(sparseArray);
                            return;
                        }
                        c.this.bo(view);
                    }
                } else if (booleanValue2) {
                    sparseArray.put(d.g.tag_from, 0);
                    c.this.eZT.c(sparseArray);
                } else if (booleanValue3) {
                    c.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aSE = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.c.2
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            c.this.fd(false);
            c.this.aA(view);
            c.this.fd(true);
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
    protected AdapterView.OnItemClickListener fau = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.9
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ax.aT(c.this.eZT.getPageContext().getPageActivity())) {
                if (c.this.eZJ != null) {
                    c.this.eZJ.ana();
                }
                c.this.aWp();
                if (view == null || !(view.getTag() instanceof d.a)) {
                    PostData postData = (PostData) v.c(c.this.fam, i);
                    if (postData == null) {
                        c.this.fan = null;
                    } else {
                        c.this.fan = postData.getId();
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(d.g.tag_photo_username);
                        String str2 = (String) sparseArray.get(d.g.tag_photo_userid);
                        if (str != null) {
                            c.this.dSh.setReplyId(str2);
                            c.this.dSh.ge(str);
                        }
                    }
                    c.this.aWq();
                    return;
                }
                c.this.aWr();
                c.this.eZv.aWM();
            }
        }
    };

    public c(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.eEZ = null;
        this.eZR = null;
        this.Hj = null;
        this.eZS = null;
        this.eZT = null;
        this.cuD = null;
        this.eZU = null;
        this.cML = null;
        this.eZY = null;
        this.faf = null;
        this.fai = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.cMK = null;
        this.fao = null;
        this.fap = null;
        this.faq = null;
        this.eZT = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.eEZ = (RelativeLayout) LayoutInflater.from(this.eZT.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_layout, (ViewGroup) null);
        this.eZR = LayoutInflater.from(this.eZT.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_head, (ViewGroup) null);
        this.cML = (TextView) this.eEZ.findViewById(d.g.no_reply_list_view);
        this.fao = (RelativeLayout) this.eEZ.findViewById(d.g.subpb_editor_tool_comment);
        this.cMK = (TextView) this.eEZ.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.cMK.setOnClickListener(this.mCommonClickListener);
        this.fap = (ImageView) this.eEZ.findViewById(d.g.subpb_editor_tool_more_img);
        this.faq = (ImageView) this.eEZ.findViewById(d.g.subpb_editor_tool_emotion_img);
        this.faq.setOnClickListener(this.mCommonClickListener);
        this.fap.setOnClickListener(this.mCommonClickListener);
        this.cuD = (NoNetworkView) this.eEZ.findViewById(d.g.view_no_network);
        ani();
        aWo();
        this.eZU = (RelativeLayout) this.eEZ.findViewById(d.g.sub_pb_body_layout);
        this.Hj = (BdListView) this.eEZ.findViewById(d.g.new_sub_pb_list);
        this.fae = (ThreadSkinView) LayoutInflater.from(this.eZT.getPageContext().getPageActivity()).inflate(d.h.thread_skin_layout, (ViewGroup) null);
        this.Hj.addHeaderView(this.fae);
        this.Hj.addHeaderView(this.eZR);
        this.cpW = BdListViewHelper.a(this.eZT.getActivity(), this.Hj, BdListViewHelper.HeadType.DEFAULT);
        this.eZS = new d(this.eZT.getPageContext().getPageActivity());
        this.eZS.F(this.eIo);
        this.eZS.setIsFromCDN(this.mIsFromCDN);
        this.eZS.jP(true);
        this.Hj.setAdapter((ListAdapter) this.eZS);
        this.faf = new e(this.eZT.getPageContext());
        this.fai = this.faf.getView();
        this.Hj.setNextPage(this.faf);
        this.faf.setOnClickListener(this.mCommonClickListener);
        this.Hj.setOnItemClickListener(this.fau);
        this.Hj.setOnTouchListener(this.aSE);
        this.mProgress = (ProgressBar) this.eEZ.findViewById(d.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.eZR != null) {
            this.eZR.setVisibility(4);
        }
        if (this.eZU != null) {
            this.eZU.setVisibility(4);
        }
        this.eZY = com.baidu.tbadk.ala.b.nu().g(this.eZT.getActivity(), 4);
        if (this.eZY != null) {
            this.eZY.setVisibility(8);
            this.eZW.addView(this.eZY, 3);
        }
    }

    public ListView getListView() {
        return this.Hj;
    }

    public void aWo() {
        this.eZW = (LinearLayout) this.eZR.findViewById(d.g.subpb_head_user_info_root);
        this.eZW.setOnClickListener(this.mCommonClickListener);
        this.eZX = (HeadImageView) this.eZR.findViewById(d.g.photo);
        this.eZX.setRadius(l.f(this.eZT.getActivity(), d.e.ds30));
        this.eZX.setClickable(false);
        this.eSv = (ClickableHeaderImageView) this.eZR.findViewById(d.g.god_user_photo);
        this.eSv.setGodIconMargin(0);
        this.eSv.setGodIconWidth(d.e.ds24);
        this.eSv.setRadius(l.f(this.eZT.getActivity(), d.e.ds30));
        this.eSv.setClickable(false);
        this.aoD = (TextView) this.eZR.findViewById(d.g.user_name);
        this.eZZ = (ImageView) this.eZR.findViewById(d.g.user_rank);
        this.eZZ.setVisibility(8);
        this.eSl = (TextView) this.eZR.findViewById(d.g.floor_owner);
        this.eZV = (TextView) this.eZR.findViewById(d.g.see_subject);
        this.eZV.setOnClickListener(this.mCommonClickListener);
        this.faa = (TextView) this.eZR.findViewById(d.g.floor);
        this.eIG = (TextView) this.eZR.findViewById(d.g.time);
        this.fab = (EllipsizeRichTextView) this.eZR.findViewById(d.g.content_text);
        this.fab.setOnClickListener(this.mCommonClickListener);
        com.baidu.tbadk.core.util.aj.i(this.fab, d.C0080d.cp_cont_b);
        this.fab.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0080d.cp_link_tip_c));
        this.fab.setLineSpacing(0.0f, 1.25f);
        this.fac = (TbImageView) this.eZR.findViewById(d.g.sub_pb_image);
        this.fac.setOnClickListener(this.mCommonClickListener);
        this.fad = (TextView) this.eZR.findViewById(d.g.advert);
        this.bSW = (PlayVoiceBntNew) this.eZR.findViewById(d.g.voice_btn);
        this.eZR.setOnTouchListener(this.aSE);
        this.eZR.setOnClickListener(this.mCommonClickListener);
    }

    public void ff(boolean z) {
        if (this.cpW != null && this.cpW.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cpW.getLayoutParams();
            if (z) {
                anm();
                layoutParams.height = l.f(this.eZT.getPageContext().getPageActivity(), d.e.ds88);
            } else {
                layoutParams.height = l.f(this.eZT.getPageContext().getPageActivity(), d.e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.cpW.setLayoutParams(layoutParams);
        }
    }

    private void anm() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public View ann() {
        return this.cpW;
    }

    public void ani() {
        int f = l.f(this.eZT.getPageContext().getPageActivity(), d.e.ds88);
        int f2 = l.f(this.eZT.getPageContext().getPageActivity(), d.e.ds14);
        this.mNavigationBar = (NavigationBar) this.eEZ.findViewById(d.g.view_navigation_bar);
        this.aqg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqg.getLayoutParams();
            layoutParams.height = f;
            layoutParams.width = f;
            layoutParams.leftMargin = f2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aqg != null && (this.aqg.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aqg.getLayoutParams();
            layoutParams2.width = f;
            layoutParams2.height = f;
            this.aqg.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar ajA() {
        return this.mNavigationBar;
    }

    public void bo(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.eSS == null) {
            this.eSS = new Dialog(this.eZT.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.eSS.setCanceledOnTouchOutside(true);
            this.eSS.setCancelable(true);
            View inflate = LayoutInflater.from(this.eZT.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
            this.eZT.getLayoutMode().t(inflate);
            this.eSS.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.eSS.getWindow().getAttributes();
            attributes.width = (int) (l.ac(this.eZT.getPageContext().getPageActivity()) * 0.9d);
            this.eSS.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.eSS.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.eSS.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.eSS.findViewById(d.g.disable_reply_btn);
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
                    if (c.this.eSS != null && (c.this.eSS instanceof Dialog)) {
                        g.b(c.this.eSS, c.this.eZT.getPageContext());
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
                    if (c.this.eSS != null && (c.this.eSS instanceof Dialog)) {
                        g.b(c.this.eSS, c.this.eZT.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && c.this.faj != null) {
                        c.this.faj.f(new Object[]{sparseArray4.get(d.g.tag_manage_user_identity), sparseArray4.get(d.g.tag_forbid_user_name), sparseArray4.get(d.g.tag_forbid_user_post_id)});
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
                    if (c.this.eSS != null && (c.this.eSS instanceof Dialog)) {
                        g.b(c.this.eSS, c.this.eZT.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        c.this.eZT.a(z, (String) sparseArray5.get(d.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.eSS, this.eZT.getPageContext());
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
        this.eSU = new com.baidu.tbadk.core.dialog.a(this.eZT.getPageContext().getPageActivity());
        this.eSU.cc(i3);
        this.eSU.z(sparseArray);
        this.eSU.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (c.this.fak != null) {
                    c.this.fak.f(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.eSU.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eSU.ao(true);
        this.eSU.b(this.eZT.getPageContext());
        this.eSU.th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fd(final boolean z) {
        if (this.Hj != null) {
            if (!z) {
                this.Hj.setEnabled(z);
            } else {
                this.Hj.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.c.8
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.Hj.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void b(b.InterfaceC0047b interfaceC0047b, boolean z) {
        String string;
        if (this.eTe != null) {
            this.eTe.dismiss();
            this.eTe = null;
        }
        if (z) {
            string = this.eZT.getResources().getString(d.j.remove_mark);
        } else {
            string = this.eZT.getResources().getString(d.j.mark);
        }
        this.eTe = new com.baidu.tbadk.core.dialog.b(this.eZT.getPageContext().getPageActivity());
        this.eTe.cf(d.j.operation);
        this.eTe.a(new String[]{this.eZT.getResources().getString(d.j.copy), string}, interfaceC0047b);
        this.eTe.d(this.eZT.getPageContext());
        this.eTe.tl();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.faj = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.fak = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.eZT.showToast(this.eZT.getResources().getString(d.j.delete_success));
        } else if (str != null && z2) {
            this.eZT.showToast(str);
        }
    }

    public void aA(View view) {
        if (this.cpW != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cpW.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.Hj != null) {
                    this.Hj.removeHeaderView(this.cpW);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.cpW.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.f(this.eZT.getActivity(), d.e.ds98)));
            } else if (this.Hj != null) {
                this.Hj.addHeaderView(this.cpW, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void f(com.baidu.tbadk.editortools.pb.f fVar) {
        if (fVar != null && fVar.CU() != null) {
            this.dSh = fVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.eEZ.addView(fVar.CU(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.eZJ = bVar;
    }

    public void aWp() {
        if (this.Hj != null) {
            this.fat = this.Hj.getLastVisiblePosition();
        }
    }

    public void aWq() {
        if (this.eZv != null) {
            if ((!aWt() && this.fai != null && this.fai.isShown()) || v.v(this.fam)) {
                this.eZv.jS(false);
            } else {
                this.eZv.jS(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.eZv = subPbModel;
    }

    public void aWr() {
        a(this.eZT);
        this.Hj.setNextPage(this.faf);
    }

    public void n(PostData postData) {
        int i;
        if (postData != null) {
            postData.mD(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!aWt() && this.fai != null && this.fai.isShown()) {
                i = (this.fat - this.fas) - 1;
            } else {
                i = this.fat - this.fas;
            }
            int u = v.u(this.fam);
            if (i > u) {
                i = u;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(v.a(this.fam, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.eZS.setDatas(arrayList);
            this.eZS.notifyDataSetChanged();
            this.Hj.smoothScrollToPosition(this.fat + 2);
            this.Hj.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Hj.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.Hj.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.eEZ;
    }

    public void aEU() {
        if (this.fag != null) {
            g.a(this.fag, this.eZT.getPageContext().getPageActivity());
        }
        if (this.eTe != null) {
            this.eTe.dismiss();
        }
        if (this.eSU != null) {
            this.eSU.dismiss();
        }
        if (this.eSS != null) {
            g.b(this.eSS, this.eZT.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.eKS != null) {
            this.eKS.dismiss();
        }
    }

    public void aWs() {
        this.Hj.setNextPage(this.faf);
        this.faf.wt();
    }

    public void iE(boolean z) {
        this.eIj = z;
    }

    public void setIsFromPb(boolean z) {
        this.eZK = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(m mVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (mVar != null) {
            if (this.eZK && this.eZR != null) {
                this.eZS.jQ(true);
                this.eZR.setVisibility(8);
                this.Hj.removeHeaderView(this.eZR);
                this.fas = 1;
            }
            this.eYw = mVar;
            this.eZS.M(this.eYw.NA());
            if (this.eZR != null) {
                this.eZR.setVisibility(0);
            }
            if (this.eZU != null) {
                this.eZU.setVisibility(0);
            }
            if (mVar.aQG() != null) {
                this.fal = mVar.aQG().getId();
                this.aRK = mVar.aQG().buG();
                if (this.aRK > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.eZT.getResources().getString(d.j.subpb_floor_reply_count), am.y(mVar.getTotalCount())));
                    this.cMK.setText(d.j.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.eZT.aWn()) {
                    str = "PB";
                }
                if (mVar.aQG().rP() != null) {
                    this.fae.a(this.eZT.getPageContext(), mVar.aQG().rP(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", mVar.aQN().getId(), mVar.aQN().getName(), mVar.NA().getId(), str));
                } else {
                    this.fae.a(null, null, null);
                }
            }
            if (mVar.hasMore()) {
                this.faf.wt();
                this.eZS.setHasMoreData(true);
            } else {
                this.faf.wu();
                this.eZS.setHasMoreData(false);
            }
            this.fam = mVar.aQK();
            if (v.v(this.fam)) {
                this.Hj.setNextPage(null);
                if (this.eZK) {
                    this.cML.setVisibility(0);
                }
            } else {
                this.Hj.setNextPage(this.faf);
                if (this.eZK) {
                    this.cML.setVisibility(8);
                }
            }
            if (this.fam == null || this.fam.size() <= eZQ) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.fam.size() - eZQ;
                qc(size);
                int firstVisiblePosition = this.Hj.getFirstVisiblePosition() - size;
                View childAt = this.Hj.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.eZS.setDatas(this.fam);
            boolean z2 = false;
            if (mVar.NA() != null && mVar.NA().rt() != null && (userId = mVar.NA().rt().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.eZS.z(i, z2);
            this.eZS.notifyDataSetChanged();
            a(mVar.aQG(), mVar.aAU(), mVar.nC(), i, z);
            if (i4 > 0) {
                this.Hj.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void qc(int i) {
        if (this.fam != null) {
            if (this.fam.size() <= i) {
                this.fam.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.fam.iterator();
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

    public boolean aWt() {
        return this.eZS.caT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.eZK) {
            this.eHv = postData;
            if (!StringUtils.isNull(postData.buM())) {
                this.fac.setVisibility(0);
                this.fac.startLoad(postData.buM(), 10, true);
            } else {
                this.fac.setVisibility(8);
            }
            h buO = postData.buO();
            if (buO != null && buO.gpV) {
                this.fad.setVisibility(0);
            } else {
                this.fad.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.eZR.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.eZR.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.faa.setText((CharSequence) null);
            this.aoD.setText((CharSequence) null);
            this.eSl.setVisibility(8);
            if (!this.eZK) {
                d(postData.rt());
                if (z) {
                    this.eSl.setVisibility(0);
                    com.baidu.tbadk.core.util.aj.i(this.eSl, d.C0080d.cp_link_tip_a);
                }
            }
            this.eIG.setText(am.r(postData.getTime()));
            this.faa.setText(String.format(this.eZT.getPageContext().getString(d.j.is_floor), Integer.valueOf(postData.buG())));
            postData.rt().getUserTbVipInfoData();
            boolean a = a(this.fab, postData.aEx());
            if (StringUtils.isNull(postData.buM()) && !a && postData.Jb() != null) {
                this.bSW.setVisibility(0);
                this.bSW.setTag(postData.Jb());
                return;
            }
            this.bSW.setVisibility(8);
        }
    }

    private void d(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.aP(metaData.getSealPrefix()) + 2 : 0) + com.baidu.tbadk.util.w.gW(name_show) > 14) {
                name_show = com.baidu.tbadk.util.w.e(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.aoD.setText(ag(metaData.getSealPrefix(), name_show));
            } else {
                this.aoD.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.eZY != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.eZY.setVisibility(8);
                } else {
                    this.eZY.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.QK = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.eZY.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.eSv.setVisibility(0);
                this.eZX.setVisibility(8);
                this.eSv.setUserId(metaData.getUserId());
                this.eSv.setUserName(metaData.getUserName());
                this.eSv.startLoad(metaData.getPortrait(), 28, false);
                com.baidu.tbadk.core.util.aj.i(this.aoD, d.C0080d.cp_cont_r);
            } else {
                this.eSv.setVisibility(8);
                this.eZX.setVisibility(0);
                this.eZX.setUserId(metaData.getUserId());
                this.eZX.setUserName(metaData.getUserName());
                this.eZX.setDefaultResource(d.f.transparent_bg);
                this.eZX.setDefaultErrorResource(d.f.icon_default_avatar100);
                this.eZX.startLoad(metaData.getPortrait(), 28, false);
                com.baidu.tbadk.core.util.aj.i(this.aoD, d.C0080d.cp_cont_c);
            }
            this.eZW.setTag(d.g.tag_user_id, metaData.getUserId());
            this.eZW.setTag(d.g.tag_user_name, metaData.getUserName());
            this.eZW.setTag(d.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.IT() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.IT().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.Ja());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.cd(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.bBt());
                        continue;
                    case 17:
                        String str = next.Je().mGifInfo.mSharpText;
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
        if (!tbRichTextData.Jj()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.Ja() == null || tbRichTextData.Ja().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.Ja());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eZT.getPageContext().getString(d.j.refresh_view_title_text), this.RF));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.eZT.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.eZU, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.f.pic_emotion07, l.f(pageActivity, d.e.ds300), l.f(pageActivity, d.e.ds480), l.f(pageActivity, d.e.ds360)), dVar, a);
        }
        this.eZU.setVisibility(0);
        this.Hj.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.dSh.DS();
        com.baidu.tbadk.core.util.aj.k(this.mNoDataView, d.C0080d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.eZT.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void gC(int i) {
        b(NoDataViewFactory.d.D(i, d.j.refresh_view_title_text));
        if (this.eZJ != null) {
            this.eZJ.br(this.eEZ);
        }
        this.fao.setVisibility(8);
    }

    public void ld(String str) {
        b(NoDataViewFactory.d.af(str, this.eZT.getPageContext().getString(d.j.refresh_view_title_text)));
        if (this.eZJ != null) {
            this.eZJ.br(this.eEZ);
        }
        this.fao.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Hj.setVisibility(0);
            this.fao.setVisibility(0);
            this.eEZ.setOnTouchListener(null);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.RF = onClickListener;
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
                String userId2 = postData.rt().getUserId();
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
            if (this.eYw != null && this.eYw.NA() != null && this.eYw.NA().rt() != null && postData.rt() != null) {
                String userId3 = this.eYw.NA().rt().getUserId();
                String userId4 = postData.rt().getUserId();
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
                    userId = postData.rt().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.buG() != 1 ? 0 : 1;
                    if (ao.k(postData)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(d.g.tag_forbid_user_name, postData.rt().getUserName());
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
                        sparseArray.put(d.g.tag_forbid_user_name, postData.rt().getUserName());
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.rt() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.rt().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.rt().getUserName());
                        }
                        if (this.eYw.NA() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.eYw.NA().getId());
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
            userId = postData.rt().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.buG() != 1) {
            }
            if (ao.k(postData)) {
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

    public void jO(boolean z) {
        if (this.eKS != null && this.eKS.aTs() != null) {
            if (z) {
                this.eKS.aTs().setText(d.j.remove_mark);
            } else {
                this.eKS.aTs().setText(d.j.mark);
            }
            this.eKS.refreshUI();
        }
    }

    public View aWu() {
        return this.fai;
    }

    public void onChangeSkinType(int i) {
        this.eZT.getLayoutMode().ag(i == 1);
        this.eZT.getLayoutMode().t(this.eEZ);
        this.eZT.getLayoutMode().t(this.eZR);
        this.mNavigationBar.onChangeSkinType(this.eZT.getPageContext(), i);
        if (this.eZV != null) {
            com.baidu.tbadk.core.util.aj.i(this.eZV, d.C0080d.goto_see_subject_color);
        }
        com.baidu.tbadk.core.util.aj.i(this.cML, d.C0080d.cp_cont_d);
        this.cuD.onChangeSkinType(this.eZT.getPageContext(), i);
        this.eZT.getLayoutMode().t(this.fai);
        com.baidu.tbadk.core.util.aj.i(this.fab, d.C0080d.cp_cont_b);
        this.fab.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0080d.cp_link_tip_c));
        if (this.dSh != null && this.dSh.CU() != null) {
            this.dSh.CU().onChangeSkinType(i);
        }
        this.faf.dy(i);
        this.bSW.bjz();
        com.baidu.tbadk.core.util.aj.i(this.cMK, d.C0080d.cp_cont_e);
        com.baidu.tbadk.core.util.aj.i(this.eSl, d.C0080d.cp_link_tip_a);
        com.baidu.tbadk.core.util.aj.i(this.aoD, d.C0080d.cp_cont_c);
        this.cMK.setAlpha(0.95f);
        if (this.eZS != null) {
            this.eZS.notifyDataSetChanged();
        }
    }

    public void aWv() {
        this.mProgress.setVisibility(0);
    }

    public void aWw() {
        this.Hj.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.faf.wu();
    }

    public void ahd() {
        this.Hj.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.faf.ahd();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ayg = onLongClickListener;
        this.eZR.setOnLongClickListener(this.ayg);
    }

    public View aWx() {
        return this.eZR;
    }

    public TextView ano() {
        return this.cMK;
    }

    public ImageView aWy() {
        return this.fap;
    }

    public ImageView aWz() {
        return this.faq;
    }

    public void pS(String str) {
        int pT = this.eZS.pT(str);
        if (pT > -1) {
            this.eZS.qd(pT);
            if (pT > 2) {
                this.Hj.setSelection(pT - 2);
            } else {
                this.Hj.setSelection(pT);
            }
            this.Hj.invalidate();
        }
    }

    public View aWA() {
        return this.eZV;
    }

    public View aWB() {
        return this.fac;
    }

    public MorePopupWindow aWC() {
        return this.fag;
    }

    public void showLoadingDialog() {
        if (this.cbu == null) {
            this.cbu = new com.baidu.tbadk.core.view.a(this.eZT.getPageContext());
        }
        this.cbu.aE(true);
    }

    public void VR() {
        if (this.cbu != null) {
            this.cbu.aE(false);
        }
    }

    public TextView aWD() {
        return this.fab;
    }

    public void setOnLinkImageClickListener(TbRichTextView.g gVar) {
        this.eZz = gVar;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.eZA = fVar;
    }

    public w aWE() {
        return this.eKS;
    }

    public void alR() {
    }

    public void alS() {
    }

    public void onActivityDestroy() {
    }

    public void aWF() {
        if (this.eZT.acM()) {
        }
    }

    public View aWG() {
        return this.eZW;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.eZT.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
