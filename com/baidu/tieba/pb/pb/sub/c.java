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
    private static final int eUf = TbadkCoreApplication.getInst().getListItemRule().yj();
    private BdListView Ib;
    private com.baidu.tbadk.core.view.a bmO;
    private View.OnClickListener cKt;
    private View ccO;
    private NoNetworkView ceA;
    private RelativeLayout eAW;
    private v eGh;
    private n eSU;
    private SubPbModel eTL;
    private b eTZ;
    private ArrayList<PostData> eUC;
    private String eUD;
    private TextView eUE;
    private View eUg;
    private d eUh;
    private NewSubPbActivity eUi;
    private RelativeLayout eUj;
    private TextView eUk;
    private View eUo;
    private ThreadSkinView eUu;
    private e eUv;
    private View eUy;
    private ProgressBar mProgress;
    private int maxImageWidth;
    private j mNoDataView = null;
    private TbRichTextView.e eTQ = null;
    private View.OnClickListener QL = null;
    private TbRichTextView.f eTP = null;
    private NavigationBar mNavigationBar = null;
    private View apT = null;
    private TextView eUl = null;
    private LinearLayout eUm = null;
    private HeadImageView eUn = null;
    private ClickableHeaderImageView eNB = null;
    private TextView aom = null;
    private ImageView eUp = null;
    private TextView eNr = null;
    private TextView eUq = null;
    private TextView eEE = null;
    private EllipsizeRichTextView eUr = null;
    private TbImageView eUs = null;
    private PlayVoiceBntNew bGq = null;
    private TextView eUt = null;
    private MorePopupWindow eUw = null;
    private al eUx = null;
    private com.baidu.tbadk.core.dialog.b eOp = null;
    private Dialog eNV = null;
    private com.baidu.tbadk.core.dialog.a eNX = null;
    private boolean eEh = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener cIp = null;
    private NewSubPbActivity.a eUz = null;
    private NewSubPbActivity.a eUA = null;
    private ArrayList<IconData> eEl = null;
    private ArrayList<IconData> doi = null;
    private com.baidu.tbadk.editortools.pb.e dDz = null;
    private String eUB = null;
    private int aPs = 0;
    private PostData eDt = null;
    private int eUF = 0;
    private int eUG = 2;
    private int eUH = 0;
    private boolean eUa = true;
    protected HashMap<Long, HashSet<String>> eUI = new HashMap<>();
    protected final b.a eUJ = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.c.1
        @Override // com.baidu.tieba.pb.b.a
        public void d(String str, String str2, String str3, String str4, String str5) {
            if (c.this.eSU != null && c.this.eDt != null && c.this.eSU.aPM() != null && c.this.eSU.MA() != null && c.this.eDt.bsz() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                com.baidu.tieba.pb.b.a(c.this.eDt.bsz().getTemplateId(), c.this.eDt.bsz().brZ(), str, "PB", str2, str3, "tpoint", str4, str5, c.this.eSU.aPM().getId(), c.this.eSU.aPM().getName(), c.this.eSU.MA().getTid());
            }
        }
    };
    private View.OnClickListener eEm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(d.h.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(d.h.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (!com.baidu.tieba.c.a.Vh() || !com.baidu.tieba.c.a.a(c.this.eUi.getBaseContext(), c.this.eUi.getThreadId(), c.this.eUi.getPostId(), c.this.eUi.aPj())) {
                        if (booleanValue2) {
                            sparseArray.put(d.h.tag_from, 1);
                            c.this.eUi.d(sparseArray);
                            return;
                        }
                        c.this.bf(view);
                    }
                } else if (booleanValue2) {
                    sparseArray.put(d.h.tag_from, 0);
                    c.this.eUi.d(sparseArray);
                } else if (booleanValue3) {
                    c.this.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aQB = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.c.6
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
    protected AdapterView.OnItemClickListener eUK = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (aw.aN(c.this.eUi.getPageContext().getPageActivity())) {
                if (c.this.eTZ != null) {
                    c.this.eTZ.aUD();
                }
                c.this.aUQ();
                if (view == null || !(view.getTag() instanceof d.a)) {
                    PostData postData = (PostData) u.c(c.this.eUC, i);
                    if (postData == null) {
                        c.this.eUD = null;
                    } else {
                        c.this.eUD = postData.getId();
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(d.h.tag_photo_username);
                        String str2 = (String) sparseArray.get(d.h.tag_photo_userid);
                        if (str != null) {
                            c.this.dDz.setReplyId(str2);
                            c.this.dDz.ga(str);
                        }
                    }
                    c.this.aUR();
                    return;
                }
                c.this.aUS();
                c.this.eTL.aVm();
            }
        }
    };
    protected AdapterView.OnItemLongClickListener mOnItemLongClickListener = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.4
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (c.this.cIp != null) {
                c.this.cIp.onLongClick(view);
                return false;
            }
            return false;
        }
    };

    public c(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.eAW = null;
        this.eUg = null;
        this.Ib = null;
        this.eUh = null;
        this.eUi = null;
        this.ceA = null;
        this.eUj = null;
        this.eUk = null;
        this.eUo = null;
        this.eUv = null;
        this.eUy = null;
        this.cKt = null;
        this.mProgress = null;
        this.eUE = null;
        this.eUi = newSubPbActivity;
        this.cKt = onClickListener;
        this.eAW = (RelativeLayout) LayoutInflater.from(this.eUi.getPageContext().getPageActivity()).inflate(d.j.new_sub_pb_layout, (ViewGroup) null);
        this.eUg = LayoutInflater.from(this.eUi.getPageContext().getPageActivity()).inflate(d.j.new_sub_pb_head, (ViewGroup) null);
        this.eUk = (TextView) this.eAW.findViewById(d.h.no_reply_list_view);
        this.eUE = (TextView) this.eAW.findViewById(d.h.subpb_editor_tool_reply_text);
        this.eUE.setOnClickListener(this.cKt);
        this.ceA = (NoNetworkView) this.eAW.findViewById(d.h.view_no_network);
        this.maxImageWidth = k.af(this.eUi.getBaseContext()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds60);
        aUP();
        aUM();
        this.eUj = (RelativeLayout) this.eAW.findViewById(d.h.sub_pb_body_layout);
        this.Ib = (BdListView) this.eAW.findViewById(d.h.new_sub_pb_list);
        this.eUu = (ThreadSkinView) LayoutInflater.from(this.eUi.getPageContext().getPageActivity()).inflate(d.j.thread_skin_layout, (ViewGroup) null);
        this.Ib.addHeaderView(this.eUu);
        this.Ib.addHeaderView(this.eUg);
        this.ccO = BdListViewHelper.a(this.eUi.getActivity(), this.Ib, BdListViewHelper.HeadType.DEFAULT);
        this.eUh = new d(this.eUi.getPageContext().getPageActivity());
        this.eUh.I(this.eEm);
        this.eUh.setIsFromCDN(this.mIsFromCDN);
        this.eUh.jZ(true);
        this.Ib.setAdapter((ListAdapter) this.eUh);
        this.eUv = new e(this.eUi.getPageContext());
        this.eUy = this.eUv.getView();
        this.Ib.setNextPage(this.eUv);
        this.eUv.setOnClickListener(this.cKt);
        this.Ib.setOnItemClickListener(this.eUK);
        this.Ib.setOnTouchListener(this.aQB);
        this.mProgress = (ProgressBar) this.eAW.findViewById(d.h.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.eUg != null) {
            this.eUg.setVisibility(4);
        }
        if (this.eUj != null) {
            this.eUj.setVisibility(4);
        }
        this.eUo = com.baidu.tbadk.ala.b.ns().h(this.eUi.getActivity(), 4);
        if (this.eUo != null) {
            this.eUo.setVisibility(8);
            this.eUm.addView(this.eUo, 3);
        }
    }

    public ListView getListView() {
        return this.Ib;
    }

    public void aUM() {
        this.eUm = (LinearLayout) this.eUg.findViewById(d.h.subpb_head_user_info_root);
        this.eUm.setOnClickListener(this.cKt);
        this.eUn = (HeadImageView) this.eUg.findViewById(d.h.photo);
        this.eUn.setRadius(k.g(this.eUi.getActivity(), d.f.ds30));
        this.eUn.setClickable(false);
        this.eNB = (ClickableHeaderImageView) this.eUg.findViewById(d.h.god_user_photo);
        this.eNB.setGodIconMargin(0);
        this.eNB.setGodIconWidth(d.f.ds24);
        this.eNB.setRadius(k.g(this.eUi.getActivity(), d.f.ds30));
        this.eNB.setClickable(false);
        this.aom = (TextView) this.eUg.findViewById(d.h.user_name);
        this.eUp = (ImageView) this.eUg.findViewById(d.h.user_rank);
        this.eUp.setVisibility(8);
        this.eNr = (TextView) this.eUg.findViewById(d.h.floor_owner);
        this.eUl = (TextView) this.eUg.findViewById(d.h.see_subject);
        this.eUl.setOnClickListener(this.cKt);
        this.eUq = (TextView) this.eUg.findViewById(d.h.floor);
        this.eEE = (TextView) this.eUg.findViewById(d.h.time);
        this.eUr = (EllipsizeRichTextView) this.eUg.findViewById(d.h.content_text);
        this.eUr.setOnClickListener(this.cKt);
        ai.i(this.eUr, d.e.cp_cont_b);
        this.eUr.setLinkTextColor(ai.getColor(d.e.cp_link_tip_c));
        this.eUr.setLineSpacing(0.0f, 1.25f);
        this.eUs = (TbImageView) this.eUg.findViewById(d.h.sub_pb_image);
        this.eUs.setOnClickListener(this.cKt);
        this.eUt = (TextView) this.eUg.findViewById(d.h.advert);
        this.bGq = (PlayVoiceBntNew) this.eUg.findViewById(d.h.voice_btn);
        this.eUg.setOnTouchListener(this.aQB);
        this.eUg.setOnClickListener(this.cKt);
    }

    public void jW(boolean z) {
        if (this.ccO != null && this.ccO.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.ccO.getLayoutParams();
            if (z) {
                aUN();
                layoutParams.height = k.g(this.eUi.getPageContext().getPageActivity(), d.f.ds98);
            } else {
                layoutParams.height = k.g(this.eUi.getPageContext().getPageActivity(), d.f.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.ccO.setLayoutParams(layoutParams);
        }
    }

    private void aUN() {
        this.mNavigationBar.setmBackImageViewBg(d.g.subpb_navigationbar_close, d.g.subpb_navigationbar_close);
    }

    public View aUO() {
        return this.ccO;
    }

    public void aUP() {
        this.mNavigationBar = (NavigationBar) this.eAW.findViewById(d.h.view_navigation_bar);
        this.apT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.apT.getLayoutParams();
            int g = k.g(this.eUi.getPageContext().getPageActivity(), d.f.ds30);
            layoutParams.height = g;
            layoutParams.width = g;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.apT != null && (this.apT.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.apT.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.apT.setPadding(k.g(this.eUi.getPageContext().getPageActivity(), d.f.ds32), this.apT.getPaddingTop(), this.apT.getPaddingRight(), this.apT.getPaddingBottom());
            this.apT.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.g.subpb_navigationbar_back, d.g.subpb_navigationbar_back);
    }

    public NavigationBar afl() {
        return this.mNavigationBar;
    }

    public void bf(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.eNV == null) {
            this.eNV = new Dialog(this.eUi.getPageContext().getPageActivity(), d.m.common_alert_dialog);
            this.eNV.setCanceledOnTouchOutside(true);
            this.eNV.setCancelable(true);
            View inflate = LayoutInflater.from(this.eUi.getPageContext().getPageActivity()).inflate(d.j.forum_manage_dialog, (ViewGroup) null);
            this.eUi.getLayoutMode().t(inflate);
            this.eNV.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.eNV.getWindow().getAttributes();
            attributes.width = (int) (k.af(this.eUi.getPageContext().getPageActivity()) * 0.9d);
            this.eNV.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.eNV.findViewById(d.h.del_post_btn);
        TextView textView2 = (TextView) this.eNV.findViewById(d.h.forbid_user_btn);
        TextView textView3 = (TextView) this.eNV.findViewById(d.h.disable_reply_btn);
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
                    if (c.this.eNV != null && (c.this.eNV instanceof Dialog)) {
                        g.b(c.this.eNV, c.this.eUi.getPageContext());
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
                    if (c.this.eNV != null && (c.this.eNV instanceof Dialog)) {
                        g.b(c.this.eNV, c.this.eUi.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && c.this.eUz != null) {
                        c.this.eUz.g(new Object[]{sparseArray4.get(d.h.tag_manage_user_identity), sparseArray4.get(d.h.tag_forbid_user_name), sparseArray4.get(d.h.tag_forbid_user_post_id)});
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
                    if (c.this.eNV != null && (c.this.eNV instanceof Dialog)) {
                        g.b(c.this.eNV, c.this.eUi.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        c.this.eUi.a(z, (String) sparseArray5.get(d.h.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.eNV, this.eUi.getPageContext());
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
        this.eNX = new com.baidu.tbadk.core.dialog.a(this.eUi.getPageContext().getPageActivity());
        this.eNX.ca(i3);
        this.eNX.A(sparseArray);
        this.eNX.a(d.l.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (c.this.eUA != null) {
                    c.this.eUA.g(new Object[]{sparseArray.get(d.h.tag_del_post_id), sparseArray.get(d.h.tag_manage_user_identity), sparseArray.get(d.h.tag_del_post_is_self), sparseArray.get(d.h.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.eNX.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eNX.ar(true);
        this.eNX.b(this.eUi.getPageContext());
        this.eNX.th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jX(final boolean z) {
        if (this.Ib != null) {
            if (!z) {
                this.Ib.setEnabled(z);
            } else {
                this.Ib.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.Ib.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void b(b.InterfaceC0043b interfaceC0043b, boolean z) {
        String string;
        if (this.eOp != null) {
            this.eOp.dismiss();
            this.eOp = null;
        }
        if (z) {
            string = this.eUi.getResources().getString(d.l.remove_mark);
        } else {
            string = this.eUi.getResources().getString(d.l.mark);
        }
        this.eOp = new com.baidu.tbadk.core.dialog.b(this.eUi.getPageContext().getPageActivity());
        this.eOp.cd(d.l.operation);
        this.eOp.a(new String[]{this.eUi.getResources().getString(d.l.copy), string}, interfaceC0043b);
        this.eOp.d(this.eUi.getPageContext());
        this.eOp.tk();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.eUz = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.eUA = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.eUi.showToast(this.eUi.getResources().getString(d.l.delete_success));
        } else if (str != null && z2) {
            this.eUi.showToast(str);
        }
    }

    public void bi(View view) {
        if (this.ccO != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.ccO.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.Ib != null) {
                    this.Ib.removeHeaderView(this.ccO);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.ccO.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + k.g(this.eUi.getActivity(), d.f.ds98)));
            } else if (this.Ib != null) {
                this.Ib.addHeaderView(this.ccO, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void f(com.baidu.tbadk.editortools.pb.e eVar) {
        if (eVar != null && eVar.CS() != null) {
            this.dDz = eVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.eAW.addView(eVar.CS(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.eTZ = bVar;
    }

    public void aUQ() {
        if (this.Ib != null) {
            this.eUH = this.Ib.getLastVisiblePosition();
        }
    }

    public void aUR() {
        if (this.eTL != null) {
            if ((!aUU() && this.eUy != null && this.eUy.isShown()) || u.v(this.eUC)) {
                this.eTL.kb(false);
            } else {
                this.eTL.kb(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.eTL = subPbModel;
    }

    public void aUS() {
        a(this.eUi);
        this.Ib.setNextPage(this.eUv);
    }

    public void n(PostData postData) {
        int i;
        if (postData != null) {
            postData.mx(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!aUU() && this.eUy != null && this.eUy.isShown()) {
                i = (this.eUH - this.eUG) - 1;
            } else {
                i = this.eUH - this.eUG;
            }
            int u = u.u(this.eUC);
            if (i > u) {
                i = u;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(u.a(this.eUC, 0, i));
            u.b(arrayList, postData2);
            u.b(arrayList, postData);
            this.eUh.setDatas(arrayList);
            this.eUh.notifyDataSetChanged();
            this.Ib.smoothScrollToPosition(this.eUH + 2);
            this.Ib.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Ib.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.Ib.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.eAW;
    }

    public void aAZ() {
        if (this.eUw != null) {
            g.a(this.eUw, this.eUi.getPageContext().getPageActivity());
        }
        if (this.eOp != null) {
            this.eOp.dismiss();
        }
        if (this.eNX != null) {
            this.eNX.dismiss();
        }
        if (this.eNV != null) {
            g.b(this.eNV, this.eUi.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.eGh != null) {
            this.eGh.dismiss();
        }
    }

    public void aUT() {
        this.Ib.setNextPage(this.eUv);
        this.eUv.wN();
    }

    public void iP(boolean z) {
        this.eEh = z;
    }

    public void setIsFromPb(boolean z) {
        this.eUa = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(n nVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (nVar != null) {
            if (this.eUa && this.eUg != null) {
                this.eUh.ka(true);
                this.eUg.setVisibility(8);
                this.Ib.removeHeaderView(this.eUg);
                this.eUG = 1;
            }
            this.eSU = nVar;
            this.eUh.U(this.eSU.MA());
            if (this.eUg != null) {
                this.eUg.setVisibility(0);
            }
            if (this.eUj != null) {
                this.eUj.setVisibility(0);
            }
            if (nVar.aPG() != null) {
                this.eUB = nVar.aPG().getId();
                this.aPs = nVar.aPG().bsr();
                if (this.aPs > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.eUi.getResources().getString(d.l.subpb_floor_reply_count), com.baidu.tbadk.core.util.al.z(nVar.getTotalCount())));
                    this.eUE.setText(d.l.add_floor_reply_tip);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.eUi.aUL()) {
                    str = "PB";
                }
                if (nVar.aPG().rQ() != null) {
                    this.eUu.a(this.eUi.getPageContext(), nVar.aPG().rQ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", nVar.aPM().getId(), nVar.aPM().getName(), nVar.MA().getId(), str));
                } else {
                    this.eUu.a(null, null, null);
                }
            }
            if (nVar.hasMore()) {
                this.eUv.wN();
                this.eUh.setHasMoreData(true);
            } else {
                this.eUv.wO();
                this.eUh.setHasMoreData(false);
            }
            this.eUC = nVar.aPK();
            if (u.v(this.eUC)) {
                this.Ib.setNextPage(null);
                if (this.eUa) {
                    this.eUk.setVisibility(0);
                }
            } else {
                this.Ib.setNextPage(this.eUv);
                if (this.eUa) {
                    this.eUk.setVisibility(8);
                }
            }
            if (this.eUC == null || this.eUC.size() <= eUf) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.eUC.size() - eUf;
                pz(size);
                int firstVisiblePosition = this.Ib.getFirstVisiblePosition() - size;
                View childAt = this.Ib.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.eUh.setDatas(this.eUC);
            boolean z2 = false;
            if (nVar.MA() != null && nVar.MA().getAuthor() != null && (userId = nVar.MA().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.eUh.B(i, z2);
            this.eUh.notifyDataSetChanged();
            a(nVar.aPG(), nVar.axb(), nVar.nB(), i, z);
            if (i4 > 0) {
                this.Ib.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void pz(int i) {
        if (this.eUC != null) {
            if (this.eUC.size() <= i) {
                this.eUC.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.eUC.iterator();
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

    public boolean aUU() {
        return this.eUh.bNY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.eUa) {
            this.eDt = postData;
            if (!StringUtils.isNull(postData.bsx())) {
                this.eUs.setVisibility(0);
                this.eUs.c(postData.bsx(), 10, true);
            } else {
                this.eUs.setVisibility(8);
            }
            h bsz = postData.bsz();
            if (bsz != null && bsz.ggk) {
                this.eUt.setVisibility(0);
            } else {
                this.eUt.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.eUg.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.eUg.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.eUq.setText((CharSequence) null);
            this.aom.setText((CharSequence) null);
            this.eNr.setVisibility(8);
            if (!this.eUa) {
                b(postData.getAuthor());
                if (z) {
                    this.eNr.setVisibility(0);
                    ai.i(this.eNr, d.e.cp_link_tip_a);
                }
            }
            this.eEE.setText(com.baidu.tbadk.core.util.al.r(postData.getTime()));
            if (this.eEh) {
                int i2 = d.g.img_default_100;
            } else {
                int i3 = d.g.icon_click;
            }
            this.eUq.setText(String.format(this.eUi.getPageContext().getString(d.l.is_floor), Integer.valueOf(postData.bsr())));
            postData.getAuthor().getUserTbVipInfoData();
            boolean a = a(this.eUr, postData.aAE());
            if (StringUtils.isNull(postData.bsx()) && !a && postData.Io() != null) {
                this.bGq.setVisibility(0);
                this.bGq.setTag(postData.Io());
                return;
            }
            this.bGq.setVisibility(8);
        }
    }

    private void b(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.j.aM(metaData.getSealPrefix()) + 2 : 0) + com.baidu.tbadk.util.v.gO(name_show) > 14) {
                name_show = com.baidu.tbadk.util.v.d(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.aom.setText(ae(metaData.getSealPrefix(), name_show));
            } else {
                this.aom.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.eUo != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.eUo.setVisibility(8);
                } else {
                    this.eUo.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.PQ = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.eUo.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.eNB.setVisibility(0);
                this.eUn.setVisibility(8);
                this.eNB.setUserId(metaData.getUserId());
                this.eNB.setUserName(metaData.getUserName());
                this.eNB.c(metaData.getPortrait(), 28, false);
                ai.i(this.aom, d.e.cp_cont_r);
            } else {
                this.eNB.setVisibility(8);
                this.eUn.setVisibility(0);
                this.eUn.setUserId(metaData.getUserId());
                this.eUn.setUserName(metaData.getUserName());
                this.eUn.setDefaultResource(d.g.transparent_bg);
                this.eUn.setDefaultErrorResource(d.g.icon_default_avatar100);
                this.eUn.c(metaData.getPortrait(), 28, false);
                ai.i(this.aom, d.e.cp_cont_c);
            }
            this.eUm.setTag(d.h.tag_user_id, metaData.getUserId());
            this.eUm.setTag(d.h.tag_user_name, metaData.getUserName());
            this.eUm.setTag(d.h.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.Ig() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.Ig().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.In());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.ch(true);
                        textView.setMovementMethod(com.baidu.tieba.view.b.bwx());
                        continue;
                    case 17:
                        String str = next.Ir().mGifInfo.mSharpText;
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
        if (!tbRichTextData.Ix()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.In() == null || tbRichTextData.In().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.In());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eUi.getPageContext().getString(d.l.refresh_view_title_text), this.QL));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.eUi.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.eUj, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.g.pic_emotion07, k.g(pageActivity, d.f.ds300), k.g(pageActivity, d.f.ds480), k.g(pageActivity, d.f.ds360)), dVar, a);
        }
        this.eUj.setVisibility(0);
        this.Ib.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.dDz.DQ();
        ai.k(this.mNoDataView, d.e.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.eUi.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void gh(int i) {
        b(NoDataViewFactory.d.B(i, d.l.refresh_view_title_text));
        if (this.eTZ != null) {
            this.eTZ.bg(this.eAW);
        }
        this.eUE.setVisibility(8);
    }

    public void pA(String str) {
        b(NoDataViewFactory.d.ad(str, this.eUi.getPageContext().getString(d.l.refresh_view_title_text)));
        if (this.eTZ != null) {
            this.eTZ.bg(this.eAW);
        }
        this.eUE.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Ib.setVisibility(0);
            this.eUE.setVisibility(0);
            this.eAW.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.QL = onClickListener;
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
            if (this.eSU != null && this.eSU.MA() != null && this.eSU.MA().getAuthor() != null && postData.getAuthor() != null) {
                String userId3 = this.eSU.MA().getAuthor().getUserId();
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
                    int i2 = postData.bsr() != 1 ? 0 : 1;
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
                        if (this.eSU.MA() != null) {
                            sparseArray.put(d.h.tag_user_mute_thread_id, this.eSU.MA().getId());
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
            if (postData.bsr() != 1) {
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
        if (this.eGh != null && this.eGh.aRU() != null) {
            if (z) {
                this.eGh.aRU().setText(d.l.remove_mark);
            } else {
                this.eGh.aRU().setText(d.l.mark);
            }
            this.eGh.refreshUI();
        }
    }

    public View aUV() {
        return this.eUy;
    }

    public void onChangeSkinType(int i) {
        this.eUi.getLayoutMode().ah(i == 1);
        this.eUi.getLayoutMode().t(this.eAW);
        this.eUi.getLayoutMode().t(this.eUg);
        this.mNavigationBar.onChangeSkinType(this.eUi.getPageContext(), i);
        if (this.eUl != null) {
            ai.i(this.eUl, d.e.goto_see_subject_color);
        }
        ai.i(this.eUk, d.e.cp_cont_d);
        this.ceA.onChangeSkinType(this.eUi.getPageContext(), i);
        this.eUi.getLayoutMode().t(this.eUy);
        ai.i(this.eUr, d.e.cp_cont_b);
        this.eUr.setLinkTextColor(ai.getColor(d.e.cp_link_tip_c));
        if (this.dDz != null && this.dDz.CS() != null) {
            this.dDz.CS().onChangeSkinType(i);
        }
        this.eUv.dn(i);
        this.bGq.bhH();
        ai.i(this.eUE, d.e.cp_cont_d);
        ai.j(this.eUE, d.g.pb_ecomm_comment_bg);
        ai.i(this.eNr, d.e.cp_link_tip_a);
        ai.i(this.aom, d.e.cp_cont_c);
        this.eUE.setAlpha(0.95f);
        if (this.eUh != null) {
            this.eUh.notifyDataSetChanged();
        }
    }

    public void aUW() {
        this.mProgress.setVisibility(0);
    }

    public void aUX() {
        this.Ib.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.eUv.wO();
    }

    public void adv() {
        this.Ib.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.eUv.adv();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cIp = onLongClickListener;
        this.eUg.setOnLongClickListener(this.cIp);
    }

    public View aUY() {
        return this.eUg;
    }

    public TextView aUZ() {
        return this.eUE;
    }

    public void pB(String str) {
        int pC = this.eUh.pC(str);
        if (pC > -1) {
            this.eUh.pA(pC);
            if (pC > 2) {
                this.Ib.setSelection(pC - 2);
            } else {
                this.Ib.setSelection(pC);
            }
            this.Ib.invalidate();
        }
    }

    public View aVa() {
        return this.eUl;
    }

    public View aVb() {
        return this.eUs;
    }

    public MorePopupWindow aVc() {
        return this.eUw;
    }

    public void QS() {
        if (this.bmO == null) {
            this.bmO = new com.baidu.tbadk.core.view.a(this.eUi.getPageContext());
        }
        this.bmO.aH(true);
    }

    public void QT() {
        if (this.bmO != null) {
            this.bmO.aH(false);
        }
    }

    public TextView aVd() {
        return this.eUr;
    }

    public void setOnLinkImageClickListener(TbRichTextView.f fVar) {
        this.eTP = fVar;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.eTQ = eVar;
    }

    public v aVe() {
        return this.eGh;
    }

    public void agW() {
    }

    public void agX() {
    }

    public void onActivityDestroy() {
    }

    public void aVf() {
        if (this.eUi.YX()) {
        }
    }

    public View aVg() {
        return this.eUm;
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.g.pic_smalldot_title));
            return m.a((Context) this.eUi.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
