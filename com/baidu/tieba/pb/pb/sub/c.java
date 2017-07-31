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
    private static final int eVs = TbadkCoreApplication.getInst().getListItemRule().yr();
    private BdListView JC;
    private com.baidu.tbadk.core.view.a bnY;
    private View.OnClickListener cLO;
    private View cdU;
    private NoNetworkView cfG;
    private RelativeLayout eCj;
    private v eHu;
    private SubPbModel eUY;
    private n eUh;
    private View eVB;
    private ThreadSkinView eVH;
    private e eVI;
    private View eVL;
    private ArrayList<PostData> eVP;
    private String eVQ;
    private TextView eVR;
    private b eVm;
    private View eVt;
    private d eVu;
    private NewSubPbActivity eVv;
    private RelativeLayout eVw;
    private TextView eVx;
    private ProgressBar mProgress;
    private int maxImageWidth;
    private j mNoDataView = null;
    private TbRichTextView.e eVd = null;
    private View.OnClickListener Sk = null;
    private TbRichTextView.f eVc = null;
    private NavigationBar mNavigationBar = null;
    private View arm = null;
    private TextView eVy = null;
    private LinearLayout eVz = null;
    private HeadImageView eVA = null;
    private ClickableHeaderImageView eOO = null;
    private TextView apG = null;
    private ImageView eVC = null;
    private TextView eOE = null;
    private TextView eVD = null;
    private TextView eFR = null;
    private EllipsizeRichTextView eVE = null;
    private TbImageView eVF = null;
    private PlayVoiceBntNew bHA = null;
    private TextView eVG = null;
    private MorePopupWindow eVJ = null;
    private al eVK = null;
    private com.baidu.tbadk.core.dialog.b ePC = null;
    private Dialog ePi = null;
    private com.baidu.tbadk.core.dialog.a ePk = null;
    private boolean eFu = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener cJK = null;
    private NewSubPbActivity.a eVM = null;
    private NewSubPbActivity.a eVN = null;
    private ArrayList<IconData> eFy = null;
    private ArrayList<IconData> dpA = null;
    private com.baidu.tbadk.editortools.pb.e dEQ = null;
    private String eVO = null;
    private int aQF = 0;
    private PostData eEG = null;
    private int eVS = 0;
    private int eVT = 2;
    private int eVU = 0;
    private boolean eVn = true;
    protected HashMap<Long, HashSet<String>> eVV = new HashMap<>();
    protected final b.a eVW = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.c.1
        @Override // com.baidu.tieba.pb.b.a
        public void d(String str, String str2, String str3, String str4, String str5) {
            if (c.this.eUh != null && c.this.eEG != null && c.this.eUh.aPX() != null && c.this.eUh.MF() != null && c.this.eEG.bsG() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                com.baidu.tieba.pb.b.a(c.this.eEG.bsG().getTemplateId(), c.this.eEG.bsG().bsg(), str, "PB", str2, str3, "tpoint", str4, str5, c.this.eUh.aPX().getId(), c.this.eUh.aPX().getName(), c.this.eUh.MF().getTid());
            }
        }
    };
    private View.OnClickListener eFz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(d.h.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(d.h.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (!com.baidu.tieba.c.a.Vm() || !com.baidu.tieba.c.a.a(c.this.eVv.getBaseContext(), c.this.eVv.getThreadId(), c.this.eVv.getPostId(), c.this.eVv.aPu())) {
                        if (booleanValue2) {
                            sparseArray.put(d.h.tag_from, 1);
                            c.this.eVv.d(sparseArray);
                            return;
                        }
                        c.this.bf(view);
                    }
                } else if (booleanValue2) {
                    sparseArray.put(d.h.tag_from, 0);
                    c.this.eVv.d(sparseArray);
                } else if (booleanValue3) {
                    c.this.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aRN = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.c.6
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            c.this.jX(false);
            c.this.bi(view);
            c.this.jX(true);
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
    protected AdapterView.OnItemClickListener eVX = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (aw.aO(c.this.eVv.getPageContext().getPageActivity())) {
                if (c.this.eVm != null) {
                    c.this.eVm.aUO();
                }
                c.this.aVb();
                if (view == null || !(view.getTag() instanceof d.a)) {
                    PostData postData = (PostData) u.c(c.this.eVP, i);
                    if (postData == null) {
                        c.this.eVQ = null;
                    } else {
                        c.this.eVQ = postData.getId();
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(d.h.tag_photo_username);
                        String str2 = (String) sparseArray.get(d.h.tag_photo_userid);
                        if (str != null) {
                            c.this.dEQ.setReplyId(str2);
                            c.this.dEQ.gg(str);
                        }
                    }
                    c.this.aVc();
                    return;
                }
                c.this.aVd();
                c.this.eUY.aVx();
            }
        }
    };
    protected AdapterView.OnItemLongClickListener mOnItemLongClickListener = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.4
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (c.this.cJK != null) {
                c.this.cJK.onLongClick(view);
                return false;
            }
            return false;
        }
    };

    public c(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.eCj = null;
        this.eVt = null;
        this.JC = null;
        this.eVu = null;
        this.eVv = null;
        this.cfG = null;
        this.eVw = null;
        this.eVx = null;
        this.eVB = null;
        this.eVI = null;
        this.eVL = null;
        this.cLO = null;
        this.mProgress = null;
        this.eVR = null;
        this.eVv = newSubPbActivity;
        this.cLO = onClickListener;
        this.eCj = (RelativeLayout) LayoutInflater.from(this.eVv.getPageContext().getPageActivity()).inflate(d.j.new_sub_pb_layout, (ViewGroup) null);
        this.eVt = LayoutInflater.from(this.eVv.getPageContext().getPageActivity()).inflate(d.j.new_sub_pb_head, (ViewGroup) null);
        this.eVx = (TextView) this.eCj.findViewById(d.h.no_reply_list_view);
        this.eVR = (TextView) this.eCj.findViewById(d.h.subpb_editor_tool_reply_text);
        this.eVR.setOnClickListener(this.cLO);
        this.cfG = (NoNetworkView) this.eCj.findViewById(d.h.view_no_network);
        this.maxImageWidth = k.ag(this.eVv.getBaseContext()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds60);
        aVa();
        aUX();
        this.eVw = (RelativeLayout) this.eCj.findViewById(d.h.sub_pb_body_layout);
        this.JC = (BdListView) this.eCj.findViewById(d.h.new_sub_pb_list);
        this.eVH = (ThreadSkinView) LayoutInflater.from(this.eVv.getPageContext().getPageActivity()).inflate(d.j.thread_skin_layout, (ViewGroup) null);
        this.JC.addHeaderView(this.eVH);
        this.JC.addHeaderView(this.eVt);
        this.cdU = BdListViewHelper.a(this.eVv.getActivity(), this.JC, BdListViewHelper.HeadType.DEFAULT);
        this.eVu = new d(this.eVv.getPageContext().getPageActivity());
        this.eVu.I(this.eFz);
        this.eVu.setIsFromCDN(this.mIsFromCDN);
        this.eVu.jZ(true);
        this.JC.setAdapter((ListAdapter) this.eVu);
        this.eVI = new e(this.eVv.getPageContext());
        this.eVL = this.eVI.getView();
        this.JC.setNextPage(this.eVI);
        this.eVI.setOnClickListener(this.cLO);
        this.JC.setOnItemClickListener(this.eVX);
        this.JC.setOnTouchListener(this.aRN);
        this.mProgress = (ProgressBar) this.eCj.findViewById(d.h.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.eVt != null) {
            this.eVt.setVisibility(4);
        }
        if (this.eVw != null) {
            this.eVw.setVisibility(4);
        }
        this.eVB = com.baidu.tbadk.ala.b.nC().h(this.eVv.getActivity(), 4);
        if (this.eVB != null) {
            this.eVB.setVisibility(8);
            this.eVz.addView(this.eVB, 3);
        }
    }

    public ListView getListView() {
        return this.JC;
    }

    public void aUX() {
        this.eVz = (LinearLayout) this.eVt.findViewById(d.h.subpb_head_user_info_root);
        this.eVz.setOnClickListener(this.cLO);
        this.eVA = (HeadImageView) this.eVt.findViewById(d.h.photo);
        this.eVA.setRadius(k.g(this.eVv.getActivity(), d.f.ds30));
        this.eVA.setClickable(false);
        this.eOO = (ClickableHeaderImageView) this.eVt.findViewById(d.h.god_user_photo);
        this.eOO.setGodIconMargin(0);
        this.eOO.setGodIconWidth(d.f.ds24);
        this.eOO.setRadius(k.g(this.eVv.getActivity(), d.f.ds30));
        this.eOO.setClickable(false);
        this.apG = (TextView) this.eVt.findViewById(d.h.user_name);
        this.eVC = (ImageView) this.eVt.findViewById(d.h.user_rank);
        this.eVC.setVisibility(8);
        this.eOE = (TextView) this.eVt.findViewById(d.h.floor_owner);
        this.eVy = (TextView) this.eVt.findViewById(d.h.see_subject);
        this.eVy.setOnClickListener(this.cLO);
        this.eVD = (TextView) this.eVt.findViewById(d.h.floor);
        this.eFR = (TextView) this.eVt.findViewById(d.h.time);
        this.eVE = (EllipsizeRichTextView) this.eVt.findViewById(d.h.content_text);
        this.eVE.setOnClickListener(this.cLO);
        ai.i(this.eVE, d.e.cp_cont_b);
        this.eVE.setLinkTextColor(ai.getColor(d.e.cp_link_tip_c));
        this.eVE.setLineSpacing(0.0f, 1.25f);
        this.eVF = (TbImageView) this.eVt.findViewById(d.h.sub_pb_image);
        this.eVF.setOnClickListener(this.cLO);
        this.eVG = (TextView) this.eVt.findViewById(d.h.advert);
        this.bHA = (PlayVoiceBntNew) this.eVt.findViewById(d.h.voice_btn);
        this.eVt.setOnTouchListener(this.aRN);
        this.eVt.setOnClickListener(this.cLO);
    }

    public void jW(boolean z) {
        if (this.cdU != null && this.cdU.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cdU.getLayoutParams();
            if (z) {
                aUY();
                layoutParams.height = k.g(this.eVv.getPageContext().getPageActivity(), d.f.ds98);
            } else {
                layoutParams.height = k.g(this.eVv.getPageContext().getPageActivity(), d.f.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.cdU.setLayoutParams(layoutParams);
        }
    }

    private void aUY() {
        this.mNavigationBar.setmBackImageViewBg(d.g.subpb_navigationbar_close, d.g.subpb_navigationbar_close);
    }

    public View aUZ() {
        return this.cdU;
    }

    public void aVa() {
        this.mNavigationBar = (NavigationBar) this.eCj.findViewById(d.h.view_navigation_bar);
        this.arm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.arm.getLayoutParams();
            int g = k.g(this.eVv.getPageContext().getPageActivity(), d.f.ds30);
            layoutParams.height = g;
            layoutParams.width = g;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.arm != null && (this.arm.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.arm.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.arm.setPadding(k.g(this.eVv.getPageContext().getPageActivity(), d.f.ds32), this.arm.getPaddingTop(), this.arm.getPaddingRight(), this.arm.getPaddingBottom());
            this.arm.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.g.subpb_navigationbar_back, d.g.subpb_navigationbar_back);
    }

    public NavigationBar afq() {
        return this.mNavigationBar;
    }

    public void bf(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.ePi == null) {
            this.ePi = new Dialog(this.eVv.getPageContext().getPageActivity(), d.m.common_alert_dialog);
            this.ePi.setCanceledOnTouchOutside(true);
            this.ePi.setCancelable(true);
            View inflate = LayoutInflater.from(this.eVv.getPageContext().getPageActivity()).inflate(d.j.forum_manage_dialog, (ViewGroup) null);
            this.eVv.getLayoutMode().t(inflate);
            this.ePi.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.ePi.getWindow().getAttributes();
            attributes.width = (int) (k.ag(this.eVv.getPageContext().getPageActivity()) * 0.9d);
            this.ePi.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.ePi.findViewById(d.h.del_post_btn);
        TextView textView2 = (TextView) this.ePi.findViewById(d.h.forbid_user_btn);
        TextView textView3 = (TextView) this.ePi.findViewById(d.h.disable_reply_btn);
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
                    if (c.this.ePi != null && (c.this.ePi instanceof Dialog)) {
                        g.b(c.this.ePi, c.this.eVv.getPageContext());
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
                    if (c.this.ePi != null && (c.this.ePi instanceof Dialog)) {
                        g.b(c.this.ePi, c.this.eVv.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && c.this.eVM != null) {
                        c.this.eVM.g(new Object[]{sparseArray4.get(d.h.tag_manage_user_identity), sparseArray4.get(d.h.tag_forbid_user_name), sparseArray4.get(d.h.tag_forbid_user_post_id)});
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
                    if (c.this.ePi != null && (c.this.ePi instanceof Dialog)) {
                        g.b(c.this.ePi, c.this.eVv.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        c.this.eVv.a(z, (String) sparseArray5.get(d.h.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.ePi, this.eVv.getPageContext());
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
        this.ePk = new com.baidu.tbadk.core.dialog.a(this.eVv.getPageContext().getPageActivity());
        this.ePk.cc(i3);
        this.ePk.A(sparseArray);
        this.ePk.a(d.l.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (c.this.eVN != null) {
                    c.this.eVN.g(new Object[]{sparseArray.get(d.h.tag_del_post_id), sparseArray.get(d.h.tag_manage_user_identity), sparseArray.get(d.h.tag_del_post_is_self), sparseArray.get(d.h.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.ePk.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.ePk.ar(true);
        this.ePk.b(this.eVv.getPageContext());
        this.ePk.tr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jX(final boolean z) {
        if (this.JC != null) {
            if (!z) {
                this.JC.setEnabled(z);
            } else {
                this.JC.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.JC.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void b(b.InterfaceC0043b interfaceC0043b, boolean z) {
        String string;
        if (this.ePC != null) {
            this.ePC.dismiss();
            this.ePC = null;
        }
        if (z) {
            string = this.eVv.getResources().getString(d.l.remove_mark);
        } else {
            string = this.eVv.getResources().getString(d.l.mark);
        }
        this.ePC = new com.baidu.tbadk.core.dialog.b(this.eVv.getPageContext().getPageActivity());
        this.ePC.cf(d.l.operation);
        this.ePC.a(new String[]{this.eVv.getResources().getString(d.l.copy), string}, interfaceC0043b);
        this.ePC.d(this.eVv.getPageContext());
        this.ePC.tu();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.eVM = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.eVN = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.eVv.showToast(this.eVv.getResources().getString(d.l.delete_success));
        } else if (str != null && z2) {
            this.eVv.showToast(str);
        }
    }

    public void bi(View view) {
        if (this.cdU != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cdU.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.JC != null) {
                    this.JC.removeHeaderView(this.cdU);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.cdU.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + k.g(this.eVv.getActivity(), d.f.ds98)));
            } else if (this.JC != null) {
                this.JC.addHeaderView(this.cdU, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void f(com.baidu.tbadk.editortools.pb.e eVar) {
        if (eVar != null && eVar.Da() != null) {
            this.dEQ = eVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.eCj.addView(eVar.Da(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.eVm = bVar;
    }

    public void aVb() {
        if (this.JC != null) {
            this.eVU = this.JC.getLastVisiblePosition();
        }
    }

    public void aVc() {
        if (this.eUY != null) {
            if ((!aVf() && this.eVL != null && this.eVL.isShown()) || u.v(this.eVP)) {
                this.eUY.kb(false);
            } else {
                this.eUY.kb(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.eUY = subPbModel;
    }

    public void aVd() {
        a(this.eVv);
        this.JC.setNextPage(this.eVI);
    }

    public void n(PostData postData) {
        int i;
        if (postData != null) {
            postData.mx(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!aVf() && this.eVL != null && this.eVL.isShown()) {
                i = (this.eVU - this.eVT) - 1;
            } else {
                i = this.eVU - this.eVT;
            }
            int u = u.u(this.eVP);
            if (i > u) {
                i = u;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(u.a(this.eVP, 0, i));
            u.b(arrayList, postData2);
            u.b(arrayList, postData);
            this.eVu.setDatas(arrayList);
            this.eVu.notifyDataSetChanged();
            this.JC.smoothScrollToPosition(this.eVU + 2);
            this.JC.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.JC.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.JC.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.eCj;
    }

    public void aBk() {
        if (this.eVJ != null) {
            g.a(this.eVJ, this.eVv.getPageContext().getPageActivity());
        }
        if (this.ePC != null) {
            this.ePC.dismiss();
        }
        if (this.ePk != null) {
            this.ePk.dismiss();
        }
        if (this.ePi != null) {
            g.b(this.ePi, this.eVv.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.eHu != null) {
            this.eHu.dismiss();
        }
    }

    public void aVe() {
        this.JC.setNextPage(this.eVI);
        this.eVI.wW();
    }

    public void iP(boolean z) {
        this.eFu = z;
    }

    public void setIsFromPb(boolean z) {
        this.eVn = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(n nVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (nVar != null) {
            if (this.eVn && this.eVt != null) {
                this.eVu.ka(true);
                this.eVt.setVisibility(8);
                this.JC.removeHeaderView(this.eVt);
                this.eVT = 1;
            }
            this.eUh = nVar;
            this.eVu.U(this.eUh.MF());
            if (this.eVt != null) {
                this.eVt.setVisibility(0);
            }
            if (this.eVw != null) {
                this.eVw.setVisibility(0);
            }
            if (nVar.aPR() != null) {
                this.eVO = nVar.aPR().getId();
                this.aQF = nVar.aPR().bsy();
                if (this.aQF > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.eVv.getResources().getString(d.l.subpb_floor_reply_count), com.baidu.tbadk.core.util.al.z(nVar.getTotalCount())));
                    this.eVR.setText(d.l.add_floor_reply_tip);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.eVv.aUW()) {
                    str = "PB";
                }
                if (nVar.aPR().sa() != null) {
                    this.eVH.a(this.eVv.getPageContext(), nVar.aPR().sa(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", nVar.aPX().getId(), nVar.aPX().getName(), nVar.MF().getId(), str));
                } else {
                    this.eVH.a(null, null, null);
                }
            }
            if (nVar.hasMore()) {
                this.eVI.wW();
                this.eVu.setHasMoreData(true);
            } else {
                this.eVI.wX();
                this.eVu.setHasMoreData(false);
            }
            this.eVP = nVar.aPV();
            if (u.v(this.eVP)) {
                this.JC.setNextPage(null);
                if (this.eVn) {
                    this.eVx.setVisibility(0);
                }
            } else {
                this.JC.setNextPage(this.eVI);
                if (this.eVn) {
                    this.eVx.setVisibility(8);
                }
            }
            if (this.eVP == null || this.eVP.size() <= eVs) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.eVP.size() - eVs;
                pz(size);
                int firstVisiblePosition = this.JC.getFirstVisiblePosition() - size;
                View childAt = this.JC.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.eVu.setDatas(this.eVP);
            boolean z2 = false;
            if (nVar.MF() != null && nVar.MF().getAuthor() != null && (userId = nVar.MF().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.eVu.C(i, z2);
            this.eVu.notifyDataSetChanged();
            a(nVar.aPR(), nVar.axm(), nVar.nL(), i, z);
            if (i4 > 0) {
                this.JC.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void pz(int i) {
        if (this.eVP != null) {
            if (this.eVP.size() <= i) {
                this.eVP.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.eVP.iterator();
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

    public boolean aVf() {
        return this.eVu.bPi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.eVn) {
            this.eEG = postData;
            if (!StringUtils.isNull(postData.bsE())) {
                this.eVF.setVisibility(0);
                this.eVF.c(postData.bsE(), 10, true);
            } else {
                this.eVF.setVisibility(8);
            }
            h bsG = postData.bsG();
            if (bsG != null && bsG.ghv) {
                this.eVG.setVisibility(0);
            } else {
                this.eVG.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.eVt.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.eVt.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.eVD.setText((CharSequence) null);
            this.apG.setText((CharSequence) null);
            this.eOE.setVisibility(8);
            if (!this.eVn) {
                b(postData.getAuthor());
                if (z) {
                    this.eOE.setVisibility(0);
                    ai.i(this.eOE, d.e.cp_link_tip_a);
                }
            }
            this.eFR.setText(com.baidu.tbadk.core.util.al.r(postData.getTime()));
            if (this.eFu) {
                int i2 = d.g.img_default_100;
            } else {
                int i3 = d.g.icon_click;
            }
            this.eVD.setText(String.format(this.eVv.getPageContext().getString(d.l.is_floor), Integer.valueOf(postData.bsy())));
            postData.getAuthor().getUserTbVipInfoData();
            boolean a = a(this.eVE, postData.aAP());
            if (StringUtils.isNull(postData.bsE()) && !a && postData.Iv() != null) {
                this.bHA.setVisibility(0);
                this.bHA.setTag(postData.Iv());
                return;
            }
            this.bHA.setVisibility(8);
        }
    }

    private void b(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.j.aS(metaData.getSealPrefix()) + 2 : 0) + com.baidu.tbadk.util.v.gT(name_show) > 14) {
                name_show = com.baidu.tbadk.util.v.d(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.apG.setText(ae(metaData.getSealPrefix(), name_show));
            } else {
                this.apG.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.eVB != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.eVB.setVisibility(8);
                } else {
                    this.eVB.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.Ro = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.eVB.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.eOO.setVisibility(0);
                this.eVA.setVisibility(8);
                this.eOO.setUserId(metaData.getUserId());
                this.eOO.setUserName(metaData.getUserName());
                this.eOO.c(metaData.getPortrait(), 28, false);
                ai.i(this.apG, d.e.cp_cont_r);
            } else {
                this.eOO.setVisibility(8);
                this.eVA.setVisibility(0);
                this.eVA.setUserId(metaData.getUserId());
                this.eVA.setUserName(metaData.getUserName());
                this.eVA.setDefaultResource(d.g.transparent_bg);
                this.eVA.setDefaultErrorResource(d.g.icon_default_avatar100);
                this.eVA.c(metaData.getPortrait(), 28, false);
                ai.i(this.apG, d.e.cp_cont_c);
            }
            this.eVz.setTag(d.h.tag_user_id, metaData.getUserId());
            this.eVz.setTag(d.h.tag_user_name, metaData.getUserName());
            this.eVz.setTag(d.h.tag_virtual_user_url, metaData.getVirtualUserUrl());
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
                        textView.setMovementMethod(com.baidu.tieba.view.b.bwE());
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
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eVv.getPageContext().getString(d.l.refresh_view_title_text), this.Sk));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.eVv.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.eVw, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.g.pic_emotion07, k.g(pageActivity, d.f.ds300), k.g(pageActivity, d.f.ds480), k.g(pageActivity, d.f.ds360)), dVar, a);
        }
        this.eVw.setVisibility(0);
        this.JC.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.dEQ.DY();
        ai.k(this.mNoDataView, d.e.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.eVv.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void gj(int i) {
        b(NoDataViewFactory.d.C(i, d.l.refresh_view_title_text));
        if (this.eVm != null) {
            this.eVm.bg(this.eCj);
        }
        this.eVR.setVisibility(8);
    }

    public void pF(String str) {
        b(NoDataViewFactory.d.ad(str, this.eVv.getPageContext().getString(d.l.refresh_view_title_text)));
        if (this.eVm != null) {
            this.eVm.bg(this.eCj);
        }
        this.eVR.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.JC.setVisibility(0);
            this.eVR.setVisibility(0);
            this.eCj.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.Sk = onClickListener;
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
            if (this.eUh != null && this.eUh.MF() != null && this.eUh.MF().getAuthor() != null && postData.getAuthor() != null) {
                String userId3 = this.eUh.MF().getAuthor().getUserId();
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
                    int i2 = postData.bsy() != 1 ? 0 : 1;
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
                        if (this.eUh.MF() != null) {
                            sparseArray.put(d.h.tag_user_mute_thread_id, this.eUh.MF().getId());
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
            if (postData.bsy() != 1) {
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

    public void jY(boolean z) {
        if (this.eHu != null && this.eHu.aSf() != null) {
            if (z) {
                this.eHu.aSf().setText(d.l.remove_mark);
            } else {
                this.eHu.aSf().setText(d.l.mark);
            }
            this.eHu.refreshUI();
        }
    }

    public View aVg() {
        return this.eVL;
    }

    public void onChangeSkinType(int i) {
        this.eVv.getLayoutMode().ah(i == 1);
        this.eVv.getLayoutMode().t(this.eCj);
        this.eVv.getLayoutMode().t(this.eVt);
        this.mNavigationBar.onChangeSkinType(this.eVv.getPageContext(), i);
        if (this.eVy != null) {
            ai.i(this.eVy, d.e.goto_see_subject_color);
        }
        ai.i(this.eVx, d.e.cp_cont_d);
        this.cfG.onChangeSkinType(this.eVv.getPageContext(), i);
        this.eVv.getLayoutMode().t(this.eVL);
        ai.i(this.eVE, d.e.cp_cont_b);
        this.eVE.setLinkTextColor(ai.getColor(d.e.cp_link_tip_c));
        if (this.dEQ != null && this.dEQ.Da() != null) {
            this.dEQ.Da().onChangeSkinType(i);
        }
        this.eVI.dp(i);
        this.bHA.bhR();
        ai.i(this.eVR, d.e.cp_cont_d);
        ai.j(this.eVR, d.g.pb_ecomm_comment_bg);
        ai.i(this.eOE, d.e.cp_link_tip_a);
        ai.i(this.apG, d.e.cp_cont_c);
        this.eVR.setAlpha(0.95f);
        if (this.eVu != null) {
            this.eVu.notifyDataSetChanged();
        }
    }

    public void aVh() {
        this.mProgress.setVisibility(0);
    }

    public void aVi() {
        this.JC.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.eVI.wX();
    }

    public void adA() {
        this.JC.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.eVI.adA();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cJK = onLongClickListener;
        this.eVt.setOnLongClickListener(this.cJK);
    }

    public View aVj() {
        return this.eVt;
    }

    public TextView aVk() {
        return this.eVR;
    }

    public void pG(String str) {
        int pH = this.eVu.pH(str);
        if (pH > -1) {
            this.eVu.pA(pH);
            if (pH > 2) {
                this.JC.setSelection(pH - 2);
            } else {
                this.JC.setSelection(pH);
            }
            this.JC.invalidate();
        }
    }

    public View aVl() {
        return this.eVy;
    }

    public View aVm() {
        return this.eVF;
    }

    public MorePopupWindow aVn() {
        return this.eVJ;
    }

    public void QX() {
        if (this.bnY == null) {
            this.bnY = new com.baidu.tbadk.core.view.a(this.eVv.getPageContext());
        }
        this.bnY.aH(true);
    }

    public void QY() {
        if (this.bnY != null) {
            this.bnY.aH(false);
        }
    }

    public TextView aVo() {
        return this.eVE;
    }

    public void setOnLinkImageClickListener(TbRichTextView.f fVar) {
        this.eVc = fVar;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.eVd = eVar;
    }

    public v aVp() {
        return this.eHu;
    }

    public void ahd() {
    }

    public void ahe() {
    }

    public void onActivityDestroy() {
    }

    public void aVq() {
        if (this.eVv.Zc()) {
        }
    }

    public View aVr() {
        return this.eVz;
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.g.pic_smalldot_title));
            return m.a((Context) this.eVv.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
