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
    private static final int fhL = TbadkCoreApplication.getInst().getListItemRule().yd();
    private BdListView Hi;
    private NoNetworkView cDV;
    private TextView cWm;
    private TextView cWn;
    private com.baidu.tbadk.core.view.b ckn;
    private View cyT;
    private RelativeLayout eNQ;
    private y eTE;
    private m fgq;
    private b fhF;
    private View fhM;
    private d fhN;
    private NewSubPbActivity fhO;
    private RelativeLayout fhP;
    private View fhT;
    private ThreadSkinView fhZ;
    private SubPbModel fhr;
    private e fia;
    private View fie;
    private ArrayList<PostData> fii;
    private String fij;
    private RelativeLayout fik;
    private ImageView fil;
    private ImageView fim;
    private View.OnClickListener mCommonClickListener;
    private ProgressBar mProgress;
    private g mNoDataView = null;
    private TbRichTextView.g fhw = null;
    private View.OnClickListener Sm = null;
    private TbRichTextView.h fhv = null;
    private NavigationBar mNavigationBar = null;
    private View aqE = null;
    private TextView fhQ = null;
    private LinearLayout fhR = null;
    private HeadImageView fhS = null;
    private ClickableHeaderImageView fcl = null;
    private TextView apa = null;
    private ImageView fhU = null;
    private TextView fcb = null;
    private TextView fhV = null;
    private TextView eRr = null;
    private EllipsizeRichTextView fhW = null;
    private TbImageView fhX = null;
    private PlayVoiceBntNew caQ = null;
    private TextView fhY = null;
    private MorePopupWindow fib = null;
    private al fic = null;
    private com.baidu.tbadk.core.dialog.b fcU = null;
    private Dialog fcJ = null;
    private com.baidu.tbadk.core.dialog.a fcL = null;
    private boolean eQU = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener ayP = null;
    private NewSubPbActivity.a fif = null;
    private NewSubPbActivity.a fig = null;
    private h ebg = null;
    private String fih = null;
    private int aUO = 0;
    private PostData eQo = null;
    private int fin = 0;
    private int fio = 2;
    private int fip = 0;
    private boolean aCt = true;
    private View.OnClickListener eQZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (!com.baidu.tieba.c.a.abp() || !com.baidu.tieba.c.a.a(c.this.fhO.getBaseContext(), c.this.fhO.getThreadId(), c.this.fhO.getPostId(), c.this.fhO.aRB())) {
                        if (booleanValue2) {
                            sparseArray.put(d.g.tag_from, 1);
                            c.this.fhO.c(sparseArray);
                            return;
                        }
                        c.this.bm(view);
                    }
                } else if (booleanValue2) {
                    sparseArray.put(d.g.tag_from, 0);
                    c.this.fhO.c(sparseArray);
                } else if (booleanValue3) {
                    c.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aVK = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.c.2
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
    protected AdapterView.OnItemClickListener fiq = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.9
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ax.aS(c.this.fhO.getPageContext().getPageActivity())) {
                if (c.this.fhF != null) {
                    c.this.fhF.apd();
                }
                c.this.aXw();
                if (view == null || !(view.getTag() instanceof d.a)) {
                    PostData postData = (PostData) v.c(c.this.fii, i);
                    if (postData == null) {
                        c.this.fij = null;
                    } else {
                        c.this.fij = postData.getId();
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(d.g.tag_photo_username);
                        String str2 = (String) sparseArray.get(d.g.tag_photo_userid);
                        if (str != null) {
                            c.this.ebg.setReplyId(str2);
                            c.this.ebg.gg(str);
                        }
                    }
                    c.this.aXx();
                    return;
                }
                c.this.aXy();
                c.this.fhr.aXT();
            }
        }
    };

    public c(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.eNQ = null;
        this.fhM = null;
        this.Hi = null;
        this.fhN = null;
        this.fhO = null;
        this.cDV = null;
        this.fhP = null;
        this.cWn = null;
        this.fhT = null;
        this.fia = null;
        this.fie = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.cWm = null;
        this.fik = null;
        this.fil = null;
        this.fim = null;
        this.fhO = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.eNQ = (RelativeLayout) LayoutInflater.from(this.fhO.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_layout, (ViewGroup) null);
        this.fhM = LayoutInflater.from(this.fhO.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_head, (ViewGroup) null);
        this.cWn = (TextView) this.eNQ.findViewById(d.g.no_reply_list_view);
        this.fik = (RelativeLayout) this.eNQ.findViewById(d.g.subpb_editor_tool_comment);
        this.cWm = (TextView) this.eNQ.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.cWm.setOnClickListener(this.mCommonClickListener);
        this.fil = (ImageView) this.eNQ.findViewById(d.g.subpb_editor_tool_more_img);
        this.fim = (ImageView) this.eNQ.findViewById(d.g.subpb_editor_tool_emotion_img);
        this.fim.setOnClickListener(this.mCommonClickListener);
        this.fil.setOnClickListener(this.mCommonClickListener);
        this.cDV = (NoNetworkView) this.eNQ.findViewById(d.g.view_no_network);
        apl();
        aXv();
        this.fhP = (RelativeLayout) this.eNQ.findViewById(d.g.sub_pb_body_layout);
        this.Hi = (BdListView) this.eNQ.findViewById(d.g.new_sub_pb_list);
        this.fhZ = (ThreadSkinView) LayoutInflater.from(this.fhO.getPageContext().getPageActivity()).inflate(d.h.thread_skin_layout, (ViewGroup) null);
        this.Hi.addHeaderView(this.fhZ);
        this.Hi.addHeaderView(this.fhM);
        this.cyT = BdListViewHelper.a(this.fhO.getActivity(), this.Hi, BdListViewHelper.HeadType.DEFAULT);
        this.fhN = new d(this.fhO.getPageContext().getPageActivity());
        this.fhN.G(this.eQZ);
        this.fhN.setIsFromCDN(this.mIsFromCDN);
        this.fhN.ko(true);
        this.Hi.setAdapter((ListAdapter) this.fhN);
        this.fia = new e(this.fhO.getPageContext());
        this.fie = this.fia.getView();
        this.Hi.setNextPage(this.fia);
        this.fia.setOnClickListener(this.mCommonClickListener);
        this.Hi.setOnItemClickListener(this.fiq);
        this.Hi.setOnTouchListener(this.aVK);
        this.mProgress = (ProgressBar) this.eNQ.findViewById(d.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fhM != null) {
            this.fhM.setVisibility(4);
        }
        if (this.fhP != null) {
            this.fhP.setVisibility(4);
        }
        this.fhT = com.baidu.tbadk.ala.b.nv().g(this.fhO.getActivity(), 4);
        if (this.fhT != null) {
            this.fhT.setVisibility(8);
            this.fhR.addView(this.fhT, 3);
        }
    }

    public ListView getListView() {
        return this.Hi;
    }

    public void aXv() {
        this.fhR = (LinearLayout) this.fhM.findViewById(d.g.subpb_head_user_info_root);
        this.fhR.setOnClickListener(this.mCommonClickListener);
        this.fhS = (HeadImageView) this.fhM.findViewById(d.g.photo);
        this.fhS.setRadius(l.f(this.fhO.getActivity(), d.e.ds30));
        this.fhS.setClickable(false);
        this.fcl = (ClickableHeaderImageView) this.fhM.findViewById(d.g.god_user_photo);
        this.fcl.setGodIconMargin(0);
        this.fcl.setGodIconWidth(d.e.ds24);
        this.fcl.setRadius(l.f(this.fhO.getActivity(), d.e.ds30));
        this.fcl.setClickable(false);
        this.apa = (TextView) this.fhM.findViewById(d.g.user_name);
        this.fhU = (ImageView) this.fhM.findViewById(d.g.user_rank);
        this.fhU.setVisibility(8);
        this.fcb = (TextView) this.fhM.findViewById(d.g.floor_owner);
        this.fhQ = (TextView) this.fhM.findViewById(d.g.see_subject);
        this.fhQ.setOnClickListener(this.mCommonClickListener);
        this.fhV = (TextView) this.fhM.findViewById(d.g.floor);
        this.eRr = (TextView) this.fhM.findViewById(d.g.time);
        this.fhW = (EllipsizeRichTextView) this.fhM.findViewById(d.g.content_text);
        this.fhW.setOnClickListener(this.mCommonClickListener);
        aj.i(this.fhW, d.C0095d.cp_cont_b);
        this.fhW.setLinkTextColor(aj.getColor(d.C0095d.cp_link_tip_c));
        this.fhW.setLineSpacing(0.0f, 1.25f);
        this.fhX = (TbImageView) this.fhM.findViewById(d.g.sub_pb_image);
        this.fhX.setOnClickListener(this.mCommonClickListener);
        this.fhY = (TextView) this.fhM.findViewById(d.g.advert);
        this.caQ = (PlayVoiceBntNew) this.fhM.findViewById(d.g.voice_btn);
        this.fhM.setOnTouchListener(this.aVK);
        this.fhM.setOnClickListener(this.mCommonClickListener);
    }

    public void fx(boolean z) {
        if (this.cyT != null && this.cyT.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cyT.getLayoutParams();
            if (z) {
                app();
                layoutParams.height = l.f(this.fhO.getPageContext().getPageActivity(), d.e.ds88);
            } else {
                layoutParams.height = l.f(this.fhO.getPageContext().getPageActivity(), d.e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.cyT.setLayoutParams(layoutParams);
        }
    }

    private void app() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public View apq() {
        return this.cyT;
    }

    public void apl() {
        int f = l.f(this.fhO.getPageContext().getPageActivity(), d.e.ds88);
        int f2 = l.f(this.fhO.getPageContext().getPageActivity(), d.e.ds14);
        this.mNavigationBar = (NavigationBar) this.eNQ.findViewById(d.g.view_navigation_bar);
        this.aqE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqE.getLayoutParams();
            layoutParams.height = f;
            layoutParams.width = f;
            layoutParams.leftMargin = f2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aqE != null && (this.aqE.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aqE.getLayoutParams();
            layoutParams2.width = f;
            layoutParams2.height = f;
            this.aqE.setLayoutParams(layoutParams2);
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
        if (this.fcJ == null) {
            this.fcJ = new Dialog(this.fhO.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fcJ.setCanceledOnTouchOutside(true);
            this.fcJ.setCancelable(true);
            View inflate = LayoutInflater.from(this.fhO.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
            this.fhO.getLayoutMode().t(inflate);
            this.fcJ.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.fcJ.getWindow().getAttributes();
            attributes.width = (int) (l.ac(this.fhO.getPageContext().getPageActivity()) * 0.9d);
            this.fcJ.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fcJ.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fcJ.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fcJ.findViewById(d.g.disable_reply_btn);
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
                    if (c.this.fcJ != null && (c.this.fcJ instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(c.this.fcJ, c.this.fhO.getPageContext());
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
                    if (c.this.fcJ != null && (c.this.fcJ instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(c.this.fcJ, c.this.fhO.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && c.this.fif != null) {
                        c.this.fif.f(new Object[]{sparseArray4.get(d.g.tag_manage_user_identity), sparseArray4.get(d.g.tag_forbid_user_name), sparseArray4.get(d.g.tag_forbid_user_post_id)});
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
                    if (c.this.fcJ != null && (c.this.fcJ instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(c.this.fcJ, c.this.fhO.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        c.this.fhO.a(z, (String) sparseArray5.get(d.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fcJ, this.fhO.getPageContext());
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
        this.fcL = new com.baidu.tbadk.core.dialog.a(this.fhO.getPageContext().getPageActivity());
        this.fcL.cd(i3);
        this.fcL.z(sparseArray);
        this.fcL.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (c.this.fig != null) {
                    c.this.fig.f(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.fcL.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fcL.ao(true);
        this.fcL.b(this.fhO.getPageContext());
        this.fcL.th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fv(final boolean z) {
        if (this.Hi != null) {
            if (!z) {
                this.Hi.setEnabled(z);
            } else {
                this.Hi.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.c.8
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.Hi.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void b(b.InterfaceC0060b interfaceC0060b, boolean z) {
        String string;
        if (this.fcU != null) {
            this.fcU.dismiss();
            this.fcU = null;
        }
        if (z) {
            string = this.fhO.getResources().getString(d.j.remove_mark);
        } else {
            string = this.fhO.getResources().getString(d.j.mark);
        }
        this.fcU = new com.baidu.tbadk.core.dialog.b(this.fhO.getPageContext().getPageActivity());
        this.fcU.cg(d.j.operation);
        this.fcU.a(new String[]{this.fhO.getResources().getString(d.j.copy), string}, interfaceC0060b);
        this.fcU.d(this.fhO.getPageContext());
        this.fcU.tl();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.fif = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.fig = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.fhO.showToast(this.fhO.getResources().getString(d.j.delete_success));
        } else if (str != null && z2) {
            this.fhO.showToast(str);
        }
    }

    public void aE(View view) {
        if (this.cyT != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cyT.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.Hi != null) {
                    this.Hi.removeHeaderView(this.cyT);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.cyT.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.f(this.fhO.getActivity(), d.e.ds98)));
            } else if (this.Hi != null) {
                this.Hi.addHeaderView(this.cyT, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(h hVar) {
        if (hVar != null && hVar.De() != null) {
            this.ebg = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.eNQ.addView(hVar.De(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.fhF = bVar;
    }

    public void aXw() {
        if (this.Hi != null) {
            this.fip = this.Hi.getLastVisiblePosition();
        }
    }

    public void aXx() {
        if (this.fhr != null) {
            if ((!aXA() && this.fie != null && this.fie.isShown()) || v.w(this.fii)) {
                this.fhr.kr(false);
            } else {
                this.fhr.kr(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.fhr = subPbModel;
    }

    public void aXy() {
        a(this.fhO);
        this.Hi.setNextPage(this.fia);
    }

    public void n(PostData postData) {
        int i;
        if (postData != null) {
            postData.nc(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!aXA() && this.fie != null && this.fie.isShown()) {
                i = (this.fip - this.fio) - 1;
            } else {
                i = this.fip - this.fio;
            }
            int v = v.v(this.fii);
            if (i > v) {
                i = v;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(v.a(this.fii, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.fhN.setDatas(arrayList);
            this.fhN.notifyDataSetChanged();
            this.Hi.smoothScrollToPosition(this.fip + 2);
            this.Hi.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Hi.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.Hi.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.eNQ;
    }

    public void aWx() {
        if (this.fib != null) {
            com.baidu.adp.lib.g.g.a(this.fib, this.fhO.getPageContext().getPageActivity());
        }
        if (this.fcU != null) {
            this.fcU.dismiss();
        }
        if (this.fcL != null) {
            this.fcL.dismiss();
        }
        if (this.fcJ != null) {
            com.baidu.adp.lib.g.g.b(this.fcJ, this.fhO.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.eTE != null) {
            this.eTE.dismiss();
        }
    }

    public void aXz() {
        this.Hi.setNextPage(this.fia);
        this.fia.wv();
    }

    public void iY(boolean z) {
        this.eQU = z;
    }

    public void setIsFromPb(boolean z) {
        this.aCt = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(m mVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (mVar != null) {
            if (this.aCt && this.fhM != null) {
                this.fhN.kp(true);
                this.fhM.setVisibility(8);
                this.Hi.removeHeaderView(this.fhM);
                this.fio = 1;
            }
            this.fgq = mVar;
            this.fhN.R(this.fgq.Ox());
            if (this.fhM != null) {
                this.fhM.setVisibility(0);
            }
            if (this.fhP != null) {
                this.fhP.setVisibility(0);
            }
            if (mVar.aSc() != null) {
                this.fih = mVar.aSc().getId();
                this.aUO = mVar.aSc().bwV();
                if (this.aUO > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.fhO.getResources().getString(d.j.subpb_floor_reply_count), am.y(mVar.getTotalCount())));
                    this.cWm.setText(d.j.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.fhO.aXu()) {
                    str = "PB";
                }
                if (mVar.aSc().rR() != null) {
                    this.fhZ.a(this.fhO.getPageContext(), mVar.aSc().rR(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", mVar.aSj().getId(), mVar.aSj().getName(), mVar.Ox().getId(), str));
                } else {
                    this.fhZ.a(null, null, null);
                }
            }
            if (mVar.hasMore()) {
                this.fia.wv();
                this.fhN.setHasMoreData(true);
            } else {
                this.fia.ww();
                this.fhN.setHasMoreData(false);
            }
            this.fii = mVar.aSg();
            if (v.w(this.fii)) {
                this.Hi.setNextPage(null);
                if (this.aCt) {
                    this.cWn.setVisibility(0);
                }
            } else {
                this.Hi.setNextPage(this.fia);
                if (this.aCt) {
                    this.cWn.setVisibility(8);
                }
            }
            if (this.fii == null || this.fii.size() <= fhL) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.fii.size() - fhL;
                qu(size);
                int firstVisiblePosition = this.Hi.getFirstVisiblePosition() - size;
                View childAt = this.Hi.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.fhN.setDatas(this.fii);
            boolean z2 = false;
            if (mVar.Ox() != null && mVar.Ox().rv() != null && (userId = mVar.Ox().rv().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.fhN.y(i, z2);
            this.fhN.notifyDataSetChanged();
            a(mVar.aSc(), mVar.aCD(), mVar.nH(), i, z);
            if (i4 > 0) {
                this.Hi.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void qu(int i) {
        if (this.fii != null) {
            if (this.fii.size() <= i) {
                this.fii.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.fii.iterator();
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

    public boolean aXA() {
        return this.fhN.cjI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.aCt) {
            this.eQo = postData;
            if (!StringUtils.isNull(postData.bxc())) {
                this.fhX.setVisibility(0);
                this.fhX.startLoad(postData.bxc(), 10, true);
            } else {
                this.fhX.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.h bxe = postData.bxe();
            if (bxe != null && bxe.gBB) {
                this.fhY.setVisibility(0);
            } else {
                this.fhY.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.fhM.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.fhM.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.fhV.setText((CharSequence) null);
            this.apa.setText((CharSequence) null);
            this.fcb.setVisibility(8);
            if (!this.aCt) {
                c(postData.rv());
                if (z) {
                    this.fcb.setVisibility(0);
                    aj.i(this.fcb, d.C0095d.cp_link_tip_a);
                }
            }
            this.eRr.setText(am.r(postData.getTime()));
            this.fhV.setText(String.format(this.fhO.getPageContext().getString(d.j.is_floor), Integer.valueOf(postData.bwV())));
            postData.rv().getUserTbVipInfoData();
            boolean a = a(this.fhW, postData.bwY());
            if (StringUtils.isNull(postData.bxc()) && !a && postData.Jz() != null) {
                this.caQ.setVisibility(0);
                this.caQ.setTag(postData.Jz());
                return;
            }
            this.caQ.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.aP(metaData.getSealPrefix()) + 2 : 0) + w.gX(name_show) > 14) {
                name_show = w.e(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.apa.setText(ag(metaData.getSealPrefix(), name_show));
            } else {
                this.apa.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.fhT != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.fhT.setVisibility(8);
                } else {
                    this.fhT.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.Rc = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.fhT.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.fcl.setVisibility(0);
                this.fhS.setVisibility(8);
                this.fcl.setUserId(metaData.getUserId());
                this.fcl.setUserName(metaData.getUserName());
                this.fcl.startLoad(metaData.getPortrait(), 28, false);
                aj.i(this.apa, d.C0095d.cp_cont_r);
            } else {
                this.fcl.setVisibility(8);
                this.fhS.setVisibility(0);
                this.fhS.setUserId(metaData.getUserId());
                this.fhS.setUserName(metaData.getUserName());
                this.fhS.setDefaultResource(d.f.transparent_bg);
                this.fhS.setDefaultErrorResource(d.f.icon_default_avatar100);
                this.fhS.startLoad(metaData.getPortrait(), 28, false);
                aj.i(this.apa, d.C0095d.cp_cont_c);
            }
            this.fhR.setTag(d.g.tag_user_id, metaData.getUserId());
            this.fhR.setTag(d.g.tag_user_name, metaData.getUserName());
            this.fhR.setTag(d.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
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
                        textView.setMovementMethod(com.baidu.tieba.view.d.bEK());
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
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fhO.getPageContext().getString(d.j.refresh_view_title_text), this.Sm));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.fhO.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.fhP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.f.pic_emotion07, l.f(pageActivity, d.e.ds300), l.f(pageActivity, d.e.ds480), l.f(pageActivity, d.e.ds360)), dVar, a);
        }
        this.fhP.setVisibility(0);
        this.Hi.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.ebg.Ea();
        aj.k(this.mNoDataView, d.C0095d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.fhO.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void gV(int i) {
        b(NoDataViewFactory.d.D(i, d.j.refresh_view_title_text));
        if (this.fhF != null) {
            this.fhF.bp(this.eNQ);
        }
        this.fik.setVisibility(8);
    }

    public void ll(String str) {
        b(NoDataViewFactory.d.af(str, this.fhO.getPageContext().getString(d.j.refresh_view_title_text)));
        if (this.fhF != null) {
            this.fhF.bp(this.eNQ);
        }
        this.fik.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Hi.setVisibility(0);
            this.fik.setVisibility(0);
            this.eNQ.setOnTouchListener(null);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.Sm = onClickListener;
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
            if (this.fgq != null && this.fgq.Ox() != null && this.fgq.Ox().rv() != null && postData.rv() != null) {
                String userId3 = this.fgq.Ox().rv().getUserId();
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
                    int i2 = postData.bwV() != 1 ? 0 : 1;
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
                        if (this.fgq.Ox() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fgq.Ox().getId());
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
            if (postData.bwV() != 1) {
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
        if (this.eTE != null && this.eTE.aVa() != null) {
            if (z) {
                this.eTE.aVa().setText(d.j.remove_mark);
            } else {
                this.eTE.aVa().setText(d.j.mark);
            }
            this.eTE.refreshUI();
        }
    }

    public View aXB() {
        return this.fie;
    }

    public void onChangeSkinType(int i) {
        this.fhO.getLayoutMode().ag(i == 1);
        this.fhO.getLayoutMode().t(this.eNQ);
        this.fhO.getLayoutMode().t(this.fhM);
        this.mNavigationBar.onChangeSkinType(this.fhO.getPageContext(), i);
        if (this.fhQ != null) {
            aj.i(this.fhQ, d.C0095d.goto_see_subject_color);
        }
        aj.i(this.cWn, d.C0095d.cp_cont_d);
        this.cDV.onChangeSkinType(this.fhO.getPageContext(), i);
        this.fhO.getLayoutMode().t(this.fie);
        aj.i(this.fhW, d.C0095d.cp_cont_b);
        this.fhW.setLinkTextColor(aj.getColor(d.C0095d.cp_link_tip_c));
        if (this.ebg != null && this.ebg.De() != null) {
            this.ebg.De().onChangeSkinType(i);
        }
        this.fia.dz(i);
        this.caQ.bmf();
        aj.i(this.cWm, d.C0095d.cp_cont_e);
        aj.i(this.fcb, d.C0095d.cp_link_tip_a);
        aj.i(this.apa, d.C0095d.cp_cont_c);
        this.cWm.setAlpha(0.95f);
        if (this.fhN != null) {
            this.fhN.notifyDataSetChanged();
        }
    }

    public void aXC() {
        this.mProgress.setVisibility(0);
    }

    public void aXD() {
        this.Hi.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fia.ww();
    }

    public void aiX() {
        this.Hi.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fia.aiX();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ayP = onLongClickListener;
        this.fhM.setOnLongClickListener(this.ayP);
    }

    public View aXE() {
        return this.fhM;
    }

    public TextView apr() {
        return this.cWm;
    }

    public ImageView aXF() {
        return this.fil;
    }

    public ImageView aXG() {
        return this.fim;
    }

    public void qf(String str) {
        int qg = this.fhN.qg(str);
        if (qg > -1) {
            this.fhN.qv(qg);
            if (qg > 2) {
                this.Hi.setSelection(qg - 2);
            } else {
                this.Hi.setSelection(qg);
            }
            this.Hi.invalidate();
        }
    }

    public View aXH() {
        return this.fhQ;
    }

    public View aXI() {
        return this.fhX;
    }

    public MorePopupWindow aXJ() {
        return this.fib;
    }

    public void showLoadingDialog() {
        if (this.ckn == null) {
            this.ckn = new com.baidu.tbadk.core.view.b(this.fhO.getPageContext());
        }
        this.ckn.aE(true);
    }

    public void XC() {
        if (this.ckn != null) {
            this.ckn.aE(false);
        }
    }

    public TextView aXK() {
        return this.fhW;
    }

    public void setOnLinkImageClickListener(TbRichTextView.h hVar) {
        this.fhv = hVar;
    }

    public void setOnImageClickListener(TbRichTextView.g gVar) {
        this.fhw = gVar;
    }

    public y aXL() {
        return this.eTE;
    }

    public void anV() {
    }

    public void anW() {
    }

    public void onActivityDestroy() {
    }

    public void aXM() {
        if (this.fhO.aeF()) {
        }
    }

    public View aXN() {
        return this.fhR;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.k.a((Context) this.fhO.getActivity(), str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
