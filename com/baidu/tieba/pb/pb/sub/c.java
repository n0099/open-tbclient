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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.pb.main.al;
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.pb.pb.main.v;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.h;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class c {
    private static final int eXl = TbadkCoreApplication.getInst().getListItemRule().yr();
    private BdListView JE;
    private com.baidu.tbadk.core.view.a box;
    private View.OnClickListener cNL;
    private View ceG;
    private NoNetworkView cgs;
    private RelativeLayout eEd;
    private v eJo;
    private SubPbModel eWR;
    private n eWa;
    private ThreadSkinView eXA;
    private e eXB;
    private View eXE;
    private ArrayList<PostData> eXI;
    private String eXJ;
    private TextView eXK;
    private b eXf;
    private View eXm;
    private d eXn;
    private NewSubPbActivity eXo;
    private RelativeLayout eXp;
    private TextView eXq;
    private View eXu;
    private ProgressBar mProgress;
    private int maxImageWidth;
    private j mNoDataView = null;
    private TbRichTextView.e eWW = null;
    private View.OnClickListener Sm = null;
    private TbRichTextView.f eWV = null;
    private NavigationBar mNavigationBar = null;
    private View arn = null;
    private TextView eXr = null;
    private LinearLayout eXs = null;
    private HeadImageView eXt = null;
    private ClickableHeaderImageView eQH = null;
    private TextView apH = null;
    private ImageView eXv = null;
    private TextView eQx = null;
    private TextView eXw = null;
    private TextView eHL = null;
    private EllipsizeRichTextView eXx = null;
    private TbImageView eXy = null;
    private PlayVoiceBntNew bIj = null;
    private TextView eXz = null;
    private MorePopupWindow eXC = null;
    private al eXD = null;
    private com.baidu.tbadk.core.dialog.b eRv = null;
    private Dialog eRb = null;
    private com.baidu.tbadk.core.dialog.a eRd = null;
    private boolean eHo = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener cLH = null;
    private NewSubPbActivity.a eXF = null;
    private NewSubPbActivity.a eXG = null;
    private ArrayList<IconData> eHs = null;
    private ArrayList<IconData> drx = null;
    private com.baidu.tbadk.editortools.pb.e dGN = null;
    private String eXH = null;
    private int aQG = 0;
    private PostData eGA = null;
    private int eXL = 0;
    private int eXM = 2;
    private int eXN = 0;
    private boolean eXg = true;
    protected HashMap<Long, HashSet<String>> eXO = new HashMap<>();
    protected final b.a eXP = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.c.1
        @Override // com.baidu.tieba.pb.b.a
        public void d(String str, String str2, String str3, String str4, String str5) {
            if (c.this.eWa != null && c.this.eGA != null && c.this.eWa.aQE() != null && c.this.eWa.MF() != null && c.this.eGA.bto() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                com.baidu.tieba.pb.b.a(c.this.eGA.bto().getTemplateId(), c.this.eGA.bto().bsO(), str, "PB", str2, str3, "tpoint", str4, str5, c.this.eWa.aQE().getId(), c.this.eWa.aQE().getName(), c.this.eWa.MF().getTid());
            }
        }
    };
    private View.OnClickListener eHt = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(d.h.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(d.h.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (!com.baidu.tieba.c.a.VI() || !com.baidu.tieba.c.a.a(c.this.eXo.getBaseContext(), c.this.eXo.getThreadId(), c.this.eXo.getPostId(), c.this.eXo.aQb())) {
                        if (booleanValue2) {
                            sparseArray.put(d.h.tag_from, 1);
                            c.this.eXo.d(sparseArray);
                            return;
                        }
                        c.this.bh(view);
                    }
                } else if (booleanValue2) {
                    sparseArray.put(d.h.tag_from, 0);
                    c.this.eXo.d(sparseArray);
                } else if (booleanValue3) {
                    c.this.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aRO = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.c.6
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            c.this.ka(false);
            c.this.bk(view);
            c.this.ka(true);
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
    protected AdapterView.OnItemClickListener eXQ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (aw.aO(c.this.eXo.getPageContext().getPageActivity())) {
                if (c.this.eXf != null) {
                    c.this.eXf.aVv();
                }
                c.this.aVI();
                if (view == null || !(view.getTag() instanceof d.a)) {
                    PostData postData = (PostData) u.c(c.this.eXI, i);
                    if (postData == null) {
                        c.this.eXJ = null;
                    } else {
                        c.this.eXJ = postData.getId();
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(d.h.tag_photo_username);
                        String str2 = (String) sparseArray.get(d.h.tag_photo_userid);
                        if (str != null) {
                            c.this.dGN.setReplyId(str2);
                            c.this.dGN.gg(str);
                        }
                    }
                    c.this.aVJ();
                    return;
                }
                c.this.aVK();
                c.this.eWR.aWe();
            }
        }
    };
    protected AdapterView.OnItemLongClickListener mOnItemLongClickListener = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.4
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (c.this.cLH != null) {
                c.this.cLH.onLongClick(view);
                return false;
            }
            return false;
        }
    };

    public c(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.eEd = null;
        this.eXm = null;
        this.JE = null;
        this.eXn = null;
        this.eXo = null;
        this.cgs = null;
        this.eXp = null;
        this.eXq = null;
        this.eXu = null;
        this.eXB = null;
        this.eXE = null;
        this.cNL = null;
        this.mProgress = null;
        this.eXK = null;
        this.eXo = newSubPbActivity;
        this.cNL = onClickListener;
        this.eEd = (RelativeLayout) LayoutInflater.from(this.eXo.getPageContext().getPageActivity()).inflate(d.j.new_sub_pb_layout, (ViewGroup) null);
        this.eXm = LayoutInflater.from(this.eXo.getPageContext().getPageActivity()).inflate(d.j.new_sub_pb_head, (ViewGroup) null);
        this.eXq = (TextView) this.eEd.findViewById(d.h.no_reply_list_view);
        this.eXK = (TextView) this.eEd.findViewById(d.h.subpb_editor_tool_reply_text);
        this.eXK.setOnClickListener(this.cNL);
        this.cgs = (NoNetworkView) this.eEd.findViewById(d.h.view_no_network);
        this.maxImageWidth = k.ag(this.eXo.getBaseContext()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds60);
        aVH();
        aVE();
        this.eXp = (RelativeLayout) this.eEd.findViewById(d.h.sub_pb_body_layout);
        this.JE = (BdListView) this.eEd.findViewById(d.h.new_sub_pb_list);
        this.eXA = (ThreadSkinView) LayoutInflater.from(this.eXo.getPageContext().getPageActivity()).inflate(d.j.thread_skin_layout, (ViewGroup) null);
        this.JE.addHeaderView(this.eXA);
        this.JE.addHeaderView(this.eXm);
        this.ceG = BdListViewHelper.a(this.eXo.getActivity(), this.JE, BdListViewHelper.HeadType.DEFAULT);
        this.eXn = new d(this.eXo.getPageContext().getPageActivity());
        this.eXn.I(this.eHt);
        this.eXn.setIsFromCDN(this.mIsFromCDN);
        this.eXn.kc(true);
        this.JE.setAdapter((ListAdapter) this.eXn);
        this.eXB = new e(this.eXo.getPageContext());
        this.eXE = this.eXB.getView();
        this.JE.setNextPage(this.eXB);
        this.eXB.setOnClickListener(this.cNL);
        this.JE.setOnItemClickListener(this.eXQ);
        this.JE.setOnTouchListener(this.aRO);
        this.mProgress = (ProgressBar) this.eEd.findViewById(d.h.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.eXm != null) {
            this.eXm.setVisibility(4);
        }
        if (this.eXp != null) {
            this.eXp.setVisibility(4);
        }
        this.eXu = com.baidu.tbadk.ala.b.nC().h(this.eXo.getActivity(), 4);
        if (this.eXu != null) {
            this.eXu.setVisibility(8);
            this.eXs.addView(this.eXu, 3);
        }
    }

    public ListView getListView() {
        return this.JE;
    }

    public void aVE() {
        this.eXs = (LinearLayout) this.eXm.findViewById(d.h.subpb_head_user_info_root);
        this.eXs.setOnClickListener(this.cNL);
        this.eXt = (HeadImageView) this.eXm.findViewById(d.h.photo);
        this.eXt.setRadius(k.g(this.eXo.getActivity(), d.f.ds30));
        this.eXt.setClickable(false);
        this.eQH = (ClickableHeaderImageView) this.eXm.findViewById(d.h.god_user_photo);
        this.eQH.setGodIconMargin(0);
        this.eQH.setGodIconWidth(d.f.ds24);
        this.eQH.setRadius(k.g(this.eXo.getActivity(), d.f.ds30));
        this.eQH.setClickable(false);
        this.apH = (TextView) this.eXm.findViewById(d.h.user_name);
        this.eXv = (ImageView) this.eXm.findViewById(d.h.user_rank);
        this.eXv.setVisibility(8);
        this.eQx = (TextView) this.eXm.findViewById(d.h.floor_owner);
        this.eXr = (TextView) this.eXm.findViewById(d.h.see_subject);
        this.eXr.setOnClickListener(this.cNL);
        this.eXw = (TextView) this.eXm.findViewById(d.h.floor);
        this.eHL = (TextView) this.eXm.findViewById(d.h.time);
        this.eXx = (EllipsizeRichTextView) this.eXm.findViewById(d.h.content_text);
        this.eXx.setOnClickListener(this.cNL);
        ai.i(this.eXx, d.e.cp_cont_b);
        this.eXx.setLinkTextColor(ai.getColor(d.e.cp_link_tip_c));
        this.eXx.setLineSpacing(0.0f, 1.25f);
        this.eXy = (TbImageView) this.eXm.findViewById(d.h.sub_pb_image);
        this.eXy.setOnClickListener(this.cNL);
        this.eXz = (TextView) this.eXm.findViewById(d.h.advert);
        this.bIj = (PlayVoiceBntNew) this.eXm.findViewById(d.h.voice_btn);
        this.eXm.setOnTouchListener(this.aRO);
        this.eXm.setOnClickListener(this.cNL);
    }

    public void jZ(boolean z) {
        if (this.ceG != null && this.ceG.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.ceG.getLayoutParams();
            if (z) {
                aVF();
                layoutParams.height = k.g(this.eXo.getPageContext().getPageActivity(), d.f.ds98);
            } else {
                layoutParams.height = k.g(this.eXo.getPageContext().getPageActivity(), d.f.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.ceG.setLayoutParams(layoutParams);
        }
    }

    private void aVF() {
        this.mNavigationBar.setmBackImageViewBg(d.g.subpb_navigationbar_close, d.g.subpb_navigationbar_close);
    }

    public View aVG() {
        return this.ceG;
    }

    public void aVH() {
        this.mNavigationBar = (NavigationBar) this.eEd.findViewById(d.h.view_navigation_bar);
        this.arn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.arn.getLayoutParams();
            int g = k.g(this.eXo.getPageContext().getPageActivity(), d.f.ds30);
            layoutParams.height = g;
            layoutParams.width = g;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.arn != null && (this.arn.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.arn.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.arn.setPadding(k.g(this.eXo.getPageContext().getPageActivity(), d.f.ds32), this.arn.getPaddingTop(), this.arn.getPaddingRight(), this.arn.getPaddingBottom());
            this.arn.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.g.subpb_navigationbar_back, d.g.subpb_navigationbar_back);
    }

    public NavigationBar afM() {
        return this.mNavigationBar;
    }

    public void bh(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.eRb == null) {
            this.eRb = new Dialog(this.eXo.getPageContext().getPageActivity(), d.m.common_alert_dialog);
            this.eRb.setCanceledOnTouchOutside(true);
            this.eRb.setCancelable(true);
            View inflate = LayoutInflater.from(this.eXo.getPageContext().getPageActivity()).inflate(d.j.forum_manage_dialog, (ViewGroup) null);
            this.eXo.getLayoutMode().t(inflate);
            this.eRb.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.eRb.getWindow().getAttributes();
            attributes.width = (int) (k.ag(this.eXo.getPageContext().getPageActivity()) * 0.9d);
            this.eRb.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.eRb.findViewById(d.h.del_post_btn);
        TextView textView2 = (TextView) this.eRb.findViewById(d.h.forbid_user_btn);
        TextView textView3 = (TextView) this.eRb.findViewById(d.h.disable_reply_btn);
        if ("".equals(sparseArray.get(d.h.tag_del_post_id))) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            sparseArray2.put(d.h.tag_del_post_id, sparseArray.get(d.h.tag_del_post_id));
            sparseArray2.put(d.h.tag_del_post_type, sparseArray.get(d.h.tag_del_post_type));
            sparseArray2.put(d.h.tag_del_post_is_self, sparseArray.get(d.h.tag_del_post_is_self));
            sparseArray2.put(d.h.tag_manage_user_identity, sparseArray.get(d.h.tag_manage_user_identity));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.eRb != null && (c.this.eRb instanceof Dialog)) {
                        g.b(c.this.eRb, c.this.eXo.getPageContext());
                    }
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null) {
                        c.this.a(((Integer) sparseArray3.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray3.get(d.h.tag_del_post_id), ((Integer) sparseArray3.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(d.h.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(d.h.tag_forbid_user_name))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(d.h.tag_forbid_user_name, sparseArray.get(d.h.tag_forbid_user_name));
            sparseArray3.put(d.h.tag_manage_user_identity, sparseArray.get(d.h.tag_manage_user_identity));
            sparseArray3.put(d.h.tag_forbid_user_post_id, sparseArray.get(d.h.tag_forbid_user_post_id));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.eRb != null && (c.this.eRb instanceof Dialog)) {
                        g.b(c.this.eRb, c.this.eXo.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && c.this.eXF != null) {
                        c.this.eXF.g(new Object[]{sparseArray4.get(d.h.tag_manage_user_identity), sparseArray4.get(d.h.tag_forbid_user_name), sparseArray4.get(d.h.tag_forbid_user_post_id)});
                    }
                }
            });
        }
        if (!((sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(d.l.un_mute);
            } else {
                textView3.setText(d.l.mute);
            }
            sparseArray4.put(d.h.tag_is_mem, sparseArray.get(d.h.tag_is_mem));
            sparseArray4.put(d.h.tag_user_mute_mute_userid, sparseArray.get(d.h.tag_user_mute_mute_userid));
            sparseArray4.put(d.h.tag_user_mute_mute_username, sparseArray.get(d.h.tag_user_mute_mute_username));
            sparseArray4.put(d.h.tag_user_mute_post_id, sparseArray.get(d.h.tag_user_mute_post_id));
            sparseArray4.put(d.h.tag_user_mute_thread_id, sparseArray.get(d.h.tag_user_mute_thread_id));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.eRb != null && (c.this.eRb instanceof Dialog)) {
                        g.b(c.this.eRb, c.this.eXo.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        c.this.eXo.a(z, (String) sparseArray5.get(d.h.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.eRb, this.eXo.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        final SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.h.tag_del_post_id, str);
        sparseArray.put(d.h.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = d.l.del_post_confirm;
        if (i == 0) {
            i3 = d.l.del_thread_confirm;
        }
        this.eRd = new com.baidu.tbadk.core.dialog.a(this.eXo.getPageContext().getPageActivity());
        this.eRd.cc(i3);
        this.eRd.A(sparseArray);
        this.eRd.a(d.l.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (c.this.eXG != null) {
                    c.this.eXG.g(new Object[]{sparseArray.get(d.h.tag_del_post_id), sparseArray.get(d.h.tag_manage_user_identity), sparseArray.get(d.h.tag_del_post_is_self), sparseArray.get(d.h.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.eRd.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eRd.ar(true);
        this.eRd.b(this.eXo.getPageContext());
        this.eRd.tr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka(final boolean z) {
        if (this.JE != null) {
            if (!z) {
                this.JE.setEnabled(z);
            } else {
                this.JE.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.JE.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void b(b.InterfaceC0043b interfaceC0043b, boolean z) {
        String string;
        if (this.eRv != null) {
            this.eRv.dismiss();
            this.eRv = null;
        }
        if (z) {
            string = this.eXo.getResources().getString(d.l.remove_mark);
        } else {
            string = this.eXo.getResources().getString(d.l.mark);
        }
        this.eRv = new com.baidu.tbadk.core.dialog.b(this.eXo.getPageContext().getPageActivity());
        this.eRv.cf(d.l.operation);
        this.eRv.a(new String[]{this.eXo.getResources().getString(d.l.copy), string}, interfaceC0043b);
        this.eRv.d(this.eXo.getPageContext());
        this.eRv.tu();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.eXF = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.eXG = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.eXo.showToast(this.eXo.getResources().getString(d.l.delete_success));
        } else if (str != null && z2) {
            this.eXo.showToast(str);
        }
    }

    public void bk(View view) {
        if (this.ceG != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.ceG.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.JE != null) {
                    this.JE.removeHeaderView(this.ceG);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.ceG.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + k.g(this.eXo.getActivity(), d.f.ds98)));
            } else if (this.JE != null) {
                this.JE.addHeaderView(this.ceG, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void f(com.baidu.tbadk.editortools.pb.e eVar) {
        if (eVar != null && eVar.Da() != null) {
            this.dGN = eVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.eEd.addView(eVar.Da(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.eXf = bVar;
    }

    public void aVI() {
        if (this.JE != null) {
            this.eXN = this.JE.getLastVisiblePosition();
        }
    }

    public void aVJ() {
        if (this.eWR != null) {
            if ((!aVM() && this.eXE != null && this.eXE.isShown()) || u.v(this.eXI)) {
                this.eWR.ke(false);
            } else {
                this.eWR.ke(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.eWR = subPbModel;
    }

    public void aVK() {
        a(this.eXo);
        this.JE.setNextPage(this.eXB);
    }

    public void n(PostData postData) {
        int i;
        if (postData != null) {
            postData.mA(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!aVM() && this.eXE != null && this.eXE.isShown()) {
                i = (this.eXN - this.eXM) - 1;
            } else {
                i = this.eXN - this.eXM;
            }
            int u = u.u(this.eXI);
            if (i > u) {
                i = u;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(u.a(this.eXI, 0, i));
            u.b(arrayList, postData2);
            u.b(arrayList, postData);
            this.eXn.setDatas(arrayList);
            this.eXn.notifyDataSetChanged();
            this.JE.smoothScrollToPosition(this.eXN + 2);
            this.JE.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.JE.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.JE.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.eEd;
    }

    public void aBR() {
        if (this.eXC != null) {
            g.a(this.eXC, this.eXo.getPageContext().getPageActivity());
        }
        if (this.eRv != null) {
            this.eRv.dismiss();
        }
        if (this.eRd != null) {
            this.eRd.dismiss();
        }
        if (this.eRb != null) {
            g.b(this.eRb, this.eXo.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.eJo != null) {
            this.eJo.dismiss();
        }
    }

    public void aVL() {
        this.JE.setNextPage(this.eXB);
        this.eXB.wW();
    }

    public void iS(boolean z) {
        this.eHo = z;
    }

    public void setIsFromPb(boolean z) {
        this.eXg = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(n nVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (nVar != null) {
            if (this.eXg && this.eXm != null) {
                this.eXn.kd(true);
                this.eXm.setVisibility(8);
                this.JE.removeHeaderView(this.eXm);
                this.eXM = 1;
            }
            this.eWa = nVar;
            this.eXn.U(this.eWa.MF());
            if (this.eXm != null) {
                this.eXm.setVisibility(0);
            }
            if (this.eXp != null) {
                this.eXp.setVisibility(0);
            }
            if (nVar.aQy() != null) {
                this.eXH = nVar.aQy().getId();
                this.aQG = nVar.aQy().btg();
                if (this.aQG > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.eXo.getResources().getString(d.l.subpb_floor_reply_count), com.baidu.tbadk.core.util.al.z(nVar.getTotalCount())));
                    this.eXK.setText(d.l.add_floor_reply_tip);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.eXo.aVD()) {
                    str = "PB";
                }
                if (nVar.aQy().sa() != null) {
                    this.eXA.a(this.eXo.getPageContext(), nVar.aQy().sa(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", nVar.aQE().getId(), nVar.aQE().getName(), nVar.MF().getId(), str));
                } else {
                    this.eXA.a(null, null, null);
                }
            }
            if (nVar.hasMore()) {
                this.eXB.wW();
                this.eXn.setHasMoreData(true);
            } else {
                this.eXB.wX();
                this.eXn.setHasMoreData(false);
            }
            this.eXI = nVar.aQC();
            if (u.v(this.eXI)) {
                this.JE.setNextPage(null);
                if (this.eXg) {
                    this.eXq.setVisibility(0);
                }
            } else {
                this.JE.setNextPage(this.eXB);
                if (this.eXg) {
                    this.eXq.setVisibility(8);
                }
            }
            if (this.eXI == null || this.eXI.size() <= eXl) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.eXI.size() - eXl;
                pJ(size);
                int firstVisiblePosition = this.JE.getFirstVisiblePosition() - size;
                View childAt = this.JE.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.eXn.setDatas(this.eXI);
            boolean z2 = false;
            if (nVar.MF() != null && nVar.MF().getAuthor() != null && (userId = nVar.MF().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.eXn.C(i, z2);
            this.eXn.notifyDataSetChanged();
            a(nVar.aQy(), nVar.axT(), nVar.nL(), i, z);
            if (i4 > 0) {
                this.JE.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void pJ(int i) {
        if (this.eXI != null) {
            if (this.eXI.size() <= i) {
                this.eXI.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.eXI.iterator();
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

    public boolean aVM() {
        return this.eXn.bPR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.eXg) {
            this.eGA = postData;
            if (!StringUtils.isNull(postData.btm())) {
                this.eXy.setVisibility(0);
                this.eXy.c(postData.btm(), 10, true);
            } else {
                this.eXy.setVisibility(8);
            }
            h bto = postData.bto();
            if (bto != null && bto.gjo) {
                this.eXz.setVisibility(0);
            } else {
                this.eXz.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.eXm.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.eXm.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.eXw.setText((CharSequence) null);
            this.apH.setText((CharSequence) null);
            this.eQx.setVisibility(8);
            if (!this.eXg) {
                b(postData.getAuthor());
                if (z) {
                    this.eQx.setVisibility(0);
                    ai.i(this.eQx, d.e.cp_link_tip_a);
                }
            }
            this.eHL.setText(com.baidu.tbadk.core.util.al.r(postData.getTime()));
            if (this.eHo) {
                int i2 = d.g.img_default_100;
            } else {
                int i3 = d.g.icon_click;
            }
            this.eXw.setText(String.format(this.eXo.getPageContext().getString(d.l.is_floor), Integer.valueOf(postData.btg())));
            postData.getAuthor().getUserTbVipInfoData();
            boolean a = a(this.eXx, postData.aBw());
            if (StringUtils.isNull(postData.btm()) && !a && postData.Iv() != null) {
                this.bIj.setVisibility(0);
                this.bIj.setTag(postData.Iv());
                return;
            }
            this.bIj.setVisibility(8);
        }
    }

    private void b(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.j.aS(metaData.getSealPrefix()) + 2 : 0) + com.baidu.tbadk.util.v.gT(name_show) > 14) {
                name_show = com.baidu.tbadk.util.v.d(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.apH.setText(ae(metaData.getSealPrefix(), name_show));
            } else {
                this.apH.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.eXu != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.eXu.setVisibility(8);
                } else {
                    this.eXu.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.Rq = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.eXu.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.eQH.setVisibility(0);
                this.eXt.setVisibility(8);
                this.eQH.setUserId(metaData.getUserId());
                this.eQH.setUserName(metaData.getUserName());
                this.eQH.c(metaData.getPortrait(), 28, false);
                ai.i(this.apH, d.e.cp_cont_r);
            } else {
                this.eQH.setVisibility(8);
                this.eXt.setVisibility(0);
                this.eXt.setUserId(metaData.getUserId());
                this.eXt.setUserName(metaData.getUserName());
                this.eXt.setDefaultResource(d.g.transparent_bg);
                this.eXt.setDefaultErrorResource(d.g.icon_default_avatar100);
                this.eXt.c(metaData.getPortrait(), 28, false);
                ai.i(this.apH, d.e.cp_cont_c);
            }
            this.eXs.setTag(d.h.tag_user_id, metaData.getUserId());
            this.eXs.setTag(d.h.tag_user_name, metaData.getUserName());
            this.eXs.setTag(d.h.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.Io() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.Io().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.Iu());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.ch(true);
                        textView.setMovementMethod(com.baidu.tieba.view.b.bxm());
                        continue;
                    case 17:
                        String str = next.Iy().mGifInfo.mSharpText;
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
        if (!tbRichTextData.IE()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.Iu() == null || tbRichTextData.Iu().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.Iu());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eXo.getPageContext().getString(d.l.refresh_view_title_text), this.Sm));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.eXo.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.eXp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.g.pic_emotion07, k.g(pageActivity, d.f.ds300), k.g(pageActivity, d.f.ds480), k.g(pageActivity, d.f.ds360)), dVar, a);
        }
        this.eXp.setVisibility(0);
        this.JE.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.dGN.DY();
        ai.k(this.mNoDataView, d.e.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.eXo.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void gj(int i) {
        b(NoDataViewFactory.d.C(i, d.l.refresh_view_title_text));
        if (this.eXf != null) {
            this.eXf.bi(this.eEd);
        }
        this.eXK.setVisibility(8);
    }

    public void kq(String str) {
        b(NoDataViewFactory.d.ad(str, this.eXo.getPageContext().getString(d.l.refresh_view_title_text)));
        if (this.eXf != null) {
            this.eXf.bi(this.eEd);
        }
        this.eXK.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.JE.setVisibility(0);
            this.eXK.setVisibility(0);
            this.eEd.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
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
                String userId2 = postData.getAuthor().getUserId();
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
            if (this.eWa != null && this.eWa.MF() != null && this.eWa.MF().getAuthor() != null && postData.getAuthor() != null) {
                String userId3 = this.eWa.MF().getAuthor().getUserId();
                String userId4 = postData.getAuthor().getUserId();
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
                    userId = postData.getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.btg() != 1 ? 0 : 1;
                    if (ap.k(postData)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(d.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                        sparseArray.put(d.h.tag_forbid_user_post_id, postData.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(d.h.tag_forbid_user_name, "");
                        z7 = false;
                    }
                    if (!z4) {
                        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(d.h.tag_del_post_is_self, true);
                        sparseArray.put(d.h.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(d.h.tag_del_post_id, postData.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(d.h.tag_del_post_is_self, false);
                        sparseArray.put(d.h.tag_del_post_type, 0);
                        sparseArray.put(d.h.tag_del_post_id, "");
                    }
                    sparseArray.put(d.h.tag_should_manage_visible, Boolean.valueOf(z7));
                    sparseArray.put(d.h.tag_forbid_user_post_id, postData.getId());
                    if (!z6) {
                        sparseArray.put(d.h.tag_should_manage_visible, true);
                        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(d.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                    } else {
                        sparseArray.put(d.h.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(d.h.tag_user_mute_visible, true);
                        sparseArray.put(d.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.getAuthor() != null) {
                            sparseArray.put(d.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                            sparseArray.put(d.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                        }
                        if (this.eWa.MF() != null) {
                            sparseArray.put(d.h.tag_user_mute_thread_id, this.eWa.MF().getId());
                        }
                        sparseArray.put(d.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.h.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(d.h.tag_should_delete_visible, true);
                        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(d.h.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(d.h.tag_del_post_id, postData.getId());
                        return;
                    }
                    sparseArray.put(d.h.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = postData.getAuthor().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.btg() != 1) {
            }
            if (ap.k(postData)) {
            }
            if (!z6) {
            }
            if (!z4) {
            }
            sparseArray.put(d.h.tag_should_manage_visible, Boolean.valueOf(z7));
            sparseArray.put(d.h.tag_forbid_user_post_id, postData.getId());
            if (!z6) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public void kb(boolean z) {
        if (this.eJo != null && this.eJo.aSM() != null) {
            if (z) {
                this.eJo.aSM().setText(d.l.remove_mark);
            } else {
                this.eJo.aSM().setText(d.l.mark);
            }
            this.eJo.refreshUI();
        }
    }

    public View aVN() {
        return this.eXE;
    }

    public void onChangeSkinType(int i) {
        this.eXo.getLayoutMode().ah(i == 1);
        this.eXo.getLayoutMode().t(this.eEd);
        this.eXo.getLayoutMode().t(this.eXm);
        this.mNavigationBar.onChangeSkinType(this.eXo.getPageContext(), i);
        if (this.eXr != null) {
            ai.i(this.eXr, d.e.goto_see_subject_color);
        }
        ai.i(this.eXq, d.e.cp_cont_d);
        this.cgs.onChangeSkinType(this.eXo.getPageContext(), i);
        this.eXo.getLayoutMode().t(this.eXE);
        ai.i(this.eXx, d.e.cp_cont_b);
        this.eXx.setLinkTextColor(ai.getColor(d.e.cp_link_tip_c));
        if (this.dGN != null && this.dGN.Da() != null) {
            this.dGN.Da().onChangeSkinType(i);
        }
        this.eXB.dp(i);
        this.bIj.bix();
        ai.i(this.eXK, d.e.cp_cont_d);
        ai.j(this.eXK, d.g.pb_ecomm_comment_bg);
        ai.i(this.eQx, d.e.cp_link_tip_a);
        ai.i(this.apH, d.e.cp_cont_c);
        this.eXK.setAlpha(0.95f);
        if (this.eXn != null) {
            this.eXn.notifyDataSetChanged();
        }
    }

    public void aVO() {
        this.mProgress.setVisibility(0);
    }

    public void aVP() {
        this.JE.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.eXB.wX();
    }

    public void adV() {
        this.JE.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.eXB.adV();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cLH = onLongClickListener;
        this.eXm.setOnLongClickListener(this.cLH);
    }

    public View aVQ() {
        return this.eXm;
    }

    public TextView aVR() {
        return this.eXK;
    }

    public void pI(String str) {
        int pJ = this.eXn.pJ(str);
        if (pJ > -1) {
            this.eXn.pK(pJ);
            if (pJ > 2) {
                this.JE.setSelection(pJ - 2);
            } else {
                this.JE.setSelection(pJ);
            }
            this.JE.invalidate();
        }
    }

    public View aVS() {
        return this.eXr;
    }

    public View aVT() {
        return this.eXy;
    }

    public MorePopupWindow aVU() {
        return this.eXC;
    }

    public void Rr() {
        if (this.box == null) {
            this.box = new com.baidu.tbadk.core.view.a(this.eXo.getPageContext());
        }
        this.box.aH(true);
    }

    public void Rs() {
        if (this.box != null) {
            this.box.aH(false);
        }
    }

    public TextView aVV() {
        return this.eXx;
    }

    public void setOnLinkImageClickListener(TbRichTextView.f fVar) {
        this.eWV = fVar;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.eWW = eVar;
    }

    public v aVW() {
        return this.eJo;
    }

    public void ahy() {
    }

    public void ahz() {
    }

    public void onActivityDestroy() {
    }

    public void aVX() {
        if (this.eXo.Zx()) {
        }
    }

    public View aVY() {
        return this.eXs;
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.g.pic_smalldot_title));
            return m.a((Context) this.eXo.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
