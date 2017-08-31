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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ax;
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
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.pb.pb.main.ai;
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
    private static final int eVT = TbadkCoreApplication.getInst().getListItemRule().yu();
    private BdListView Hw;
    private com.baidu.tbadk.core.view.a bpe;
    private View.OnClickListener cUc;
    private View cik;
    private NoNetworkView clK;
    private RelativeLayout eCy;
    private v eHJ;
    private m eUB;
    private b eVN;
    private View eVU;
    private d eVV;
    private NewSubPbActivity eVW;
    private RelativeLayout eVX;
    private TextView eVY;
    private SubPbModel eVz;
    private View eWc;
    private ThreadSkinView eWi;
    private e eWj;
    private View eWm;
    private ArrayList<PostData> eWq;
    private String eWr;
    private TextView eWs;
    private RelativeLayout eWt;
    private ImageView eWu;
    private ImageView eWv;
    private ProgressBar mProgress;
    private int maxImageWidth;
    private j mNoDataView = null;
    private TbRichTextView.e eVE = null;
    private View.OnClickListener Ro = null;
    private TbRichTextView.f eVD = null;
    private NavigationBar mNavigationBar = null;
    private View aqT = null;
    private TextView eVZ = null;
    private LinearLayout eWa = null;
    private HeadImageView eWb = null;
    private ClickableHeaderImageView eOR = null;
    private TextView apl = null;
    private ImageView eWd = null;
    private TextView eOH = null;
    private TextView eWe = null;
    private TextView eGg = null;
    private EllipsizeRichTextView eWf = null;
    private TbImageView eWg = null;
    private PlayVoiceBntNew bLe = null;
    private TextView eWh = null;
    private MorePopupWindow eWk = null;
    private ai eWl = null;
    private com.baidu.tbadk.core.dialog.b ePE = null;
    private Dialog ePl = null;
    private com.baidu.tbadk.core.dialog.a ePn = null;
    private boolean eFJ = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener cRY = null;
    private NewSubPbActivity.a eWn = null;
    private NewSubPbActivity.a eWo = null;
    private ArrayList<IconData> eFN = null;
    private ArrayList<IconData> dyb = null;
    private com.baidu.tbadk.editortools.pb.e dNt = null;
    private String eWp = null;
    private int aQq = 0;
    private PostData eEW = null;
    private int eWw = 0;
    private int eWx = 2;
    private int eWy = 0;
    private boolean eVO = true;
    protected HashMap<Long, HashSet<String>> eWz = new HashMap<>();
    protected final b.a eWA = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.c.1
        @Override // com.baidu.tieba.pb.b.a
        public void d(String str, String str2, String str3, String str4, String str5) {
            if (c.this.eUB != null && c.this.eEW != null && c.this.eUB.aPM() != null && c.this.eUB.MR() != null && c.this.eEW.bsw() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                com.baidu.tieba.pb.b.a(c.this.eEW.bsw().getTemplateId(), c.this.eEW.bsw().brW(), str, "PB", str2, str3, "tpoint", str4, str5, c.this.eUB.aPM().getId(), c.this.eUB.aPM().getName(), c.this.eUB.MR().getTid());
            }
        }
    };
    private View.OnClickListener eFO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(d.h.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(d.h.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (!com.baidu.tieba.c.a.WI() || !com.baidu.tieba.c.a.a(c.this.eVW.getBaseContext(), c.this.eVW.getThreadId(), c.this.eVW.getPostId(), c.this.eVW.aPi())) {
                        if (booleanValue2) {
                            sparseArray.put(d.h.tag_from, 1);
                            c.this.eVW.c(sparseArray);
                            return;
                        }
                        c.this.bn(view);
                    }
                } else if (booleanValue2) {
                    sparseArray.put(d.h.tag_from, 0);
                    c.this.eVW.c(sparseArray);
                } else if (booleanValue3) {
                    c.this.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aRz = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.c.6
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            c.this.jZ(false);
            c.this.bq(view);
            c.this.jZ(true);
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
    protected AdapterView.OnItemClickListener eWB = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ax.aT(c.this.eVW.getPageContext().getPageActivity())) {
                if (c.this.eVN != null) {
                    c.this.eVN.aUC();
                }
                c.this.aUP();
                if (view == null || !(view.getTag() instanceof d.a)) {
                    PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(c.this.eWq, i);
                    if (postData == null) {
                        c.this.eWr = null;
                    } else {
                        c.this.eWr = postData.getId();
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(d.h.tag_photo_username);
                        String str2 = (String) sparseArray.get(d.h.tag_photo_userid);
                        if (str != null) {
                            c.this.dNt.setReplyId(str2);
                            c.this.dNt.ge(str);
                        }
                    }
                    c.this.aUQ();
                    return;
                }
                c.this.aUR();
                c.this.eVz.aVn();
            }
        }
    };
    protected AdapterView.OnItemLongClickListener mOnItemLongClickListener = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.4
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (c.this.cRY != null) {
                c.this.cRY.onLongClick(view);
                return false;
            }
            return false;
        }
    };

    public c(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.eCy = null;
        this.eVU = null;
        this.Hw = null;
        this.eVV = null;
        this.eVW = null;
        this.clK = null;
        this.eVX = null;
        this.eVY = null;
        this.eWc = null;
        this.eWj = null;
        this.eWm = null;
        this.cUc = null;
        this.mProgress = null;
        this.eWs = null;
        this.eWt = null;
        this.eWu = null;
        this.eWv = null;
        this.eVW = newSubPbActivity;
        this.cUc = onClickListener;
        this.eCy = (RelativeLayout) LayoutInflater.from(this.eVW.getPageContext().getPageActivity()).inflate(d.j.new_sub_pb_layout, (ViewGroup) null);
        this.eVU = LayoutInflater.from(this.eVW.getPageContext().getPageActivity()).inflate(d.j.new_sub_pb_head, (ViewGroup) null);
        this.eVY = (TextView) this.eCy.findViewById(d.h.no_reply_list_view);
        this.eWt = (RelativeLayout) this.eCy.findViewById(d.h.subpb_editor_tool_comment);
        this.eWs = (TextView) this.eCy.findViewById(d.h.subpb_editor_tool_comment_reply_text);
        this.eWs.setOnClickListener(this.cUc);
        this.eWu = (ImageView) this.eCy.findViewById(d.h.subpb_editor_tool_more_img);
        this.eWv = (ImageView) this.eCy.findViewById(d.h.subpb_editor_tool_emotion_img);
        this.eWv.setOnClickListener(this.cUc);
        this.eWu.setOnClickListener(this.cUc);
        this.clK = (NoNetworkView) this.eCy.findViewById(d.h.view_no_network);
        this.maxImageWidth = k.ad(this.eVW.getBaseContext()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds60);
        aUO();
        aUL();
        this.eVX = (RelativeLayout) this.eCy.findViewById(d.h.sub_pb_body_layout);
        this.Hw = (BdListView) this.eCy.findViewById(d.h.new_sub_pb_list);
        this.eWi = (ThreadSkinView) LayoutInflater.from(this.eVW.getPageContext().getPageActivity()).inflate(d.j.thread_skin_layout, (ViewGroup) null);
        this.Hw.addHeaderView(this.eWi);
        this.Hw.addHeaderView(this.eVU);
        this.cik = BdListViewHelper.a(this.eVW.getActivity(), this.Hw, BdListViewHelper.HeadType.DEFAULT);
        this.eVV = new d(this.eVW.getPageContext().getPageActivity());
        this.eVV.C(this.eFO);
        this.eVV.setIsFromCDN(this.mIsFromCDN);
        this.eVV.kb(true);
        this.Hw.setAdapter((ListAdapter) this.eVV);
        this.eWj = new e(this.eVW.getPageContext());
        this.eWm = this.eWj.getView();
        this.Hw.setNextPage(this.eWj);
        this.eWj.setOnClickListener(this.cUc);
        this.Hw.setOnItemClickListener(this.eWB);
        this.Hw.setOnTouchListener(this.aRz);
        this.mProgress = (ProgressBar) this.eCy.findViewById(d.h.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.eVU != null) {
            this.eVU.setVisibility(4);
        }
        if (this.eVX != null) {
            this.eVX.setVisibility(4);
        }
        this.eWc = com.baidu.tbadk.ala.b.nw().i(this.eVW.getActivity(), 4);
        if (this.eWc != null) {
            this.eWc.setVisibility(8);
            this.eWa.addView(this.eWc, 3);
        }
    }

    public ListView getListView() {
        return this.Hw;
    }

    public void aUL() {
        this.eWa = (LinearLayout) this.eVU.findViewById(d.h.subpb_head_user_info_root);
        this.eWa.setOnClickListener(this.cUc);
        this.eWb = (HeadImageView) this.eVU.findViewById(d.h.photo);
        this.eWb.setRadius(k.g(this.eVW.getActivity(), d.f.ds30));
        this.eWb.setClickable(false);
        this.eOR = (ClickableHeaderImageView) this.eVU.findViewById(d.h.god_user_photo);
        this.eOR.setGodIconMargin(0);
        this.eOR.setGodIconWidth(d.f.ds24);
        this.eOR.setRadius(k.g(this.eVW.getActivity(), d.f.ds30));
        this.eOR.setClickable(false);
        this.apl = (TextView) this.eVU.findViewById(d.h.user_name);
        this.eWd = (ImageView) this.eVU.findViewById(d.h.user_rank);
        this.eWd.setVisibility(8);
        this.eOH = (TextView) this.eVU.findViewById(d.h.floor_owner);
        this.eVZ = (TextView) this.eVU.findViewById(d.h.see_subject);
        this.eVZ.setOnClickListener(this.cUc);
        this.eWe = (TextView) this.eVU.findViewById(d.h.floor);
        this.eGg = (TextView) this.eVU.findViewById(d.h.time);
        this.eWf = (EllipsizeRichTextView) this.eVU.findViewById(d.h.content_text);
        this.eWf.setOnClickListener(this.cUc);
        aj.i(this.eWf, d.e.cp_cont_b);
        this.eWf.setLinkTextColor(aj.getColor(d.e.cp_link_tip_c));
        this.eWf.setLineSpacing(0.0f, 1.25f);
        this.eWg = (TbImageView) this.eVU.findViewById(d.h.sub_pb_image);
        this.eWg.setOnClickListener(this.cUc);
        this.eWh = (TextView) this.eVU.findViewById(d.h.advert);
        this.bLe = (PlayVoiceBntNew) this.eVU.findViewById(d.h.voice_btn);
        this.eVU.setOnTouchListener(this.aRz);
        this.eVU.setOnClickListener(this.cUc);
    }

    public void jY(boolean z) {
        if (this.cik != null && this.cik.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cik.getLayoutParams();
            if (z) {
                aUM();
                layoutParams.height = k.g(this.eVW.getPageContext().getPageActivity(), d.f.ds98);
            } else {
                layoutParams.height = k.g(this.eVW.getPageContext().getPageActivity(), d.f.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.cik.setLayoutParams(layoutParams);
        }
    }

    private void aUM() {
        this.mNavigationBar.setmBackImageViewBg(d.g.subpb_navigationbar_close, d.g.subpb_navigationbar_close);
    }

    public View aUN() {
        return this.cik;
    }

    public void aUO() {
        this.mNavigationBar = (NavigationBar) this.eCy.findViewById(d.h.view_navigation_bar);
        this.aqT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqT.getLayoutParams();
            int g = k.g(this.eVW.getPageContext().getPageActivity(), d.f.ds30);
            layoutParams.height = g;
            layoutParams.width = g;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aqT != null && (this.aqT.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aqT.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.aqT.setPadding(k.g(this.eVW.getPageContext().getPageActivity(), d.f.ds32), this.aqT.getPaddingTop(), this.aqT.getPaddingRight(), this.aqT.getPaddingBottom());
            this.aqT.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.g.subpb_navigationbar_back, d.g.subpb_navigationbar_back);
    }

    public NavigationBar ahe() {
        return this.mNavigationBar;
    }

    public void bn(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.ePl == null) {
            this.ePl = new Dialog(this.eVW.getPageContext().getPageActivity(), d.m.common_alert_dialog);
            this.ePl.setCanceledOnTouchOutside(true);
            this.ePl.setCancelable(true);
            View inflate = LayoutInflater.from(this.eVW.getPageContext().getPageActivity()).inflate(d.j.forum_manage_dialog, (ViewGroup) null);
            this.eVW.getLayoutMode().t(inflate);
            this.ePl.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.ePl.getWindow().getAttributes();
            attributes.width = (int) (k.ad(this.eVW.getPageContext().getPageActivity()) * 0.9d);
            this.ePl.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.ePl.findViewById(d.h.del_post_btn);
        TextView textView2 = (TextView) this.ePl.findViewById(d.h.forbid_user_btn);
        TextView textView3 = (TextView) this.ePl.findViewById(d.h.disable_reply_btn);
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
                    if (c.this.ePl != null && (c.this.ePl instanceof Dialog)) {
                        g.b(c.this.ePl, c.this.eVW.getPageContext());
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
                    if (c.this.ePl != null && (c.this.ePl instanceof Dialog)) {
                        g.b(c.this.ePl, c.this.eVW.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && c.this.eWn != null) {
                        c.this.eWn.f(new Object[]{sparseArray4.get(d.h.tag_manage_user_identity), sparseArray4.get(d.h.tag_forbid_user_name), sparseArray4.get(d.h.tag_forbid_user_post_id)});
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
                    if (c.this.ePl != null && (c.this.ePl instanceof Dialog)) {
                        g.b(c.this.ePl, c.this.eVW.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        c.this.eVW.a(z, (String) sparseArray5.get(d.h.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.ePl, this.eVW.getPageContext());
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
        this.ePn = new com.baidu.tbadk.core.dialog.a(this.eVW.getPageContext().getPageActivity());
        this.ePn.cc(i3);
        this.ePn.z(sparseArray);
        this.ePn.a(d.l.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (c.this.eWo != null) {
                    c.this.eWo.f(new Object[]{sparseArray.get(d.h.tag_del_post_id), sparseArray.get(d.h.tag_manage_user_identity), sparseArray.get(d.h.tag_del_post_is_self), sparseArray.get(d.h.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.ePn.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.ePn.ar(true);
        this.ePn.b(this.eVW.getPageContext());
        this.ePn.to();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jZ(final boolean z) {
        if (this.Hw != null) {
            if (!z) {
                this.Hw.setEnabled(z);
            } else {
                this.Hw.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.Hw.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void b(b.InterfaceC0047b interfaceC0047b, boolean z) {
        String string;
        if (this.ePE != null) {
            this.ePE.dismiss();
            this.ePE = null;
        }
        if (z) {
            string = this.eVW.getResources().getString(d.l.remove_mark);
        } else {
            string = this.eVW.getResources().getString(d.l.mark);
        }
        this.ePE = new com.baidu.tbadk.core.dialog.b(this.eVW.getPageContext().getPageActivity());
        this.ePE.cf(d.l.operation);
        this.ePE.a(new String[]{this.eVW.getResources().getString(d.l.copy), string}, interfaceC0047b);
        this.ePE.d(this.eVW.getPageContext());
        this.ePE.tr();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.eWn = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.eWo = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.eVW.showToast(this.eVW.getResources().getString(d.l.delete_success));
        } else if (str != null && z2) {
            this.eVW.showToast(str);
        }
    }

    public void bq(View view) {
        if (this.cik != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cik.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.Hw != null) {
                    this.Hw.removeHeaderView(this.cik);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.cik.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + k.g(this.eVW.getActivity(), d.f.ds98)));
            } else if (this.Hw != null) {
                this.Hw.addHeaderView(this.cik, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void f(com.baidu.tbadk.editortools.pb.e eVar) {
        if (eVar != null && eVar.CV() != null) {
            this.dNt = eVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.eCy.addView(eVar.CV(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.eVN = bVar;
    }

    public void aUP() {
        if (this.Hw != null) {
            this.eWy = this.Hw.getLastVisiblePosition();
        }
    }

    public void aUQ() {
        if (this.eVz != null) {
            if ((!aUT() && this.eWm != null && this.eWm.isShown()) || com.baidu.tbadk.core.util.v.v(this.eWq)) {
                this.eVz.ke(false);
            } else {
                this.eVz.ke(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.eVz = subPbModel;
    }

    public void aUR() {
        a(this.eVW);
        this.Hw.setNextPage(this.eWj);
    }

    public void n(PostData postData) {
        int i;
        if (postData != null) {
            postData.mG(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!aUT() && this.eWm != null && this.eWm.isShown()) {
                i = (this.eWy - this.eWx) - 1;
            } else {
                i = this.eWy - this.eWx;
            }
            int u = com.baidu.tbadk.core.util.v.u(this.eWq);
            if (i > u) {
                i = u;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(com.baidu.tbadk.core.util.v.a(this.eWq, 0, i));
            com.baidu.tbadk.core.util.v.b(arrayList, postData2);
            com.baidu.tbadk.core.util.v.b(arrayList, postData);
            this.eVV.setDatas(arrayList);
            this.eVV.notifyDataSetChanged();
            this.Hw.smoothScrollToPosition(this.eWy + 2);
            this.Hw.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Hw.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.Hw.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.eCy;
    }

    public void aDB() {
        if (this.eWk != null) {
            g.a(this.eWk, this.eVW.getPageContext().getPageActivity());
        }
        if (this.ePE != null) {
            this.ePE.dismiss();
        }
        if (this.ePn != null) {
            this.ePn.dismiss();
        }
        if (this.ePl != null) {
            g.b(this.ePl, this.eVW.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.eHJ != null) {
            this.eHJ.dismiss();
        }
    }

    public void aUS() {
        this.Hw.setNextPage(this.eWj);
        this.eWj.wV();
    }

    public void iS(boolean z) {
        this.eFJ = z;
    }

    public void setIsFromPb(boolean z) {
        this.eVO = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(m mVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (mVar != null) {
            if (this.eVO && this.eVU != null) {
                this.eVV.kc(true);
                this.eVU.setVisibility(8);
                this.Hw.removeHeaderView(this.eVU);
                this.eWx = 1;
            }
            this.eUB = mVar;
            this.eVV.Z(this.eUB.MR());
            if (this.eVU != null) {
                this.eVU.setVisibility(0);
            }
            if (this.eVX != null) {
                this.eVX.setVisibility(0);
            }
            if (mVar.aPF() != null) {
                this.eWp = mVar.aPF().getId();
                this.aQq = mVar.aPF().bso();
                if (this.aQq > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.eVW.getResources().getString(d.l.subpb_floor_reply_count), am.y(mVar.getTotalCount())));
                    this.eWs.setText(d.l.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.eVW.aUK()) {
                    str = "PB";
                }
                if (mVar.aPF().rW() != null) {
                    this.eWi.a(this.eVW.getPageContext(), mVar.aPF().rW(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", mVar.aPM().getId(), mVar.aPM().getName(), mVar.MR().getId(), str));
                } else {
                    this.eWi.a(null, null, null);
                }
            }
            if (mVar.hasMore()) {
                this.eWj.wV();
                this.eVV.setHasMoreData(true);
            } else {
                this.eWj.wW();
                this.eVV.setHasMoreData(false);
            }
            this.eWq = mVar.aPJ();
            if (com.baidu.tbadk.core.util.v.v(this.eWq)) {
                this.Hw.setNextPage(null);
                if (this.eVO) {
                    this.eVY.setVisibility(0);
                }
            } else {
                this.Hw.setNextPage(this.eWj);
                if (this.eVO) {
                    this.eVY.setVisibility(8);
                }
            }
            if (this.eWq == null || this.eWq.size() <= eVT) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.eWq.size() - eVT;
                pM(size);
                int firstVisiblePosition = this.Hw.getFirstVisiblePosition() - size;
                View childAt = this.Hw.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.eVV.setDatas(this.eWq);
            boolean z2 = false;
            if (mVar.MR() != null && mVar.MR().getAuthor() != null && (userId = mVar.MR().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.eVV.z(i, z2);
            this.eVV.notifyDataSetChanged();
            a(mVar.aPF(), mVar.azD(), mVar.nG(), i, z);
            if (i4 > 0) {
                this.Hw.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void pM(int i) {
        if (this.eWq != null) {
            if (this.eWq.size() <= i) {
                this.eWq.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.eWq.iterator();
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

    public boolean aUT() {
        return this.eVV.bSL;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.eVO) {
            this.eEW = postData;
            if (!StringUtils.isNull(postData.bsu())) {
                this.eWg.setVisibility(0);
                this.eWg.c(postData.bsu(), 10, true);
            } else {
                this.eWg.setVisibility(8);
            }
            h bsw = postData.bsw();
            if (bsw != null && bsw.ghP) {
                this.eWh.setVisibility(0);
            } else {
                this.eWh.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.eVU.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.eVU.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.eWe.setText((CharSequence) null);
            this.apl.setText((CharSequence) null);
            this.eOH.setVisibility(8);
            if (!this.eVO) {
                b(postData.getAuthor());
                if (z) {
                    this.eOH.setVisibility(0);
                    aj.i(this.eOH, d.e.cp_link_tip_a);
                }
            }
            this.eGg.setText(am.r(postData.getTime()));
            if (this.eFJ) {
                int i2 = d.g.img_default_100;
            } else {
                int i3 = d.g.icon_click;
            }
            this.eWe.setText(String.format(this.eVW.getPageContext().getString(d.l.is_floor), Integer.valueOf(postData.bso())));
            postData.getAuthor().getUserTbVipInfoData();
            boolean a = a(this.eWf, postData.aDg());
            if (StringUtils.isNull(postData.bsu()) && !a && postData.ID() != null) {
                this.bLe.setVisibility(0);
                this.bLe.setTag(postData.ID());
                return;
            }
            this.bLe.setVisibility(8);
        }
    }

    private void b(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.j.aP(metaData.getSealPrefix()) + 2 : 0) + com.baidu.tbadk.util.v.gS(name_show) > 14) {
                name_show = com.baidu.tbadk.util.v.e(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.apl.setText(ah(metaData.getSealPrefix(), name_show));
            } else {
                this.apl.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.eWc != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.eWc.setVisibility(8);
                } else {
                    this.eWc.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.Qs = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.eWc.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.eOR.setVisibility(0);
                this.eWb.setVisibility(8);
                this.eOR.setUserId(metaData.getUserId());
                this.eOR.setUserName(metaData.getUserName());
                this.eOR.c(metaData.getPortrait(), 28, false);
                aj.i(this.apl, d.e.cp_cont_r);
            } else {
                this.eOR.setVisibility(8);
                this.eWb.setVisibility(0);
                this.eWb.setUserId(metaData.getUserId());
                this.eWb.setUserName(metaData.getUserName());
                this.eWb.setDefaultResource(d.g.transparent_bg);
                this.eWb.setDefaultErrorResource(d.g.icon_default_avatar100);
                this.eWb.c(metaData.getPortrait(), 28, false);
                aj.i(this.apl, d.e.cp_cont_c);
            }
            this.eWa.setTag(d.h.tag_user_id, metaData.getUserId());
            this.eWa.setTag(d.h.tag_user_name, metaData.getUserName());
            this.eWa.setTag(d.h.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.Iv() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.Iv().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.IC());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.ci(true);
                        textView.setMovementMethod(com.baidu.tieba.view.b.bwv());
                        continue;
                    case 17:
                        String str = next.IG().mGifInfo.mSharpText;
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
        if (!tbRichTextData.IM()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.IC() == null || tbRichTextData.IC().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.IC());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eVW.getPageContext().getString(d.l.refresh_view_title_text), this.Ro));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.eVW.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.eVX, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.g.pic_emotion07, k.g(pageActivity, d.f.ds300), k.g(pageActivity, d.f.ds480), k.g(pageActivity, d.f.ds360)), dVar, a);
        }
        this.eVX.setVisibility(0);
        this.Hw.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.dNt.DT();
        aj.k(this.mNoDataView, d.e.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.eVW.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void gm(int i) {
        b(NoDataViewFactory.d.B(i, d.l.refresh_view_title_text));
        if (this.eVN != null) {
            this.eVN.bo(this.eCy);
        }
        this.eWt.setVisibility(8);
    }

    public void kJ(String str) {
        b(NoDataViewFactory.d.ag(str, this.eVW.getPageContext().getString(d.l.refresh_view_title_text)));
        if (this.eVN != null) {
            this.eVN.bo(this.eCy);
        }
        this.eWt.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Hw.setVisibility(0);
            this.eWt.setVisibility(0);
            this.eCy.setOnTouchListener(null);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.Ro = onClickListener;
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
            if (this.eUB != null && this.eUB.MR() != null && this.eUB.MR().getAuthor() != null && postData.getAuthor() != null) {
                String userId3 = this.eUB.MR().getAuthor().getUserId();
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
                    int i2 = postData.bso() != 1 ? 0 : 1;
                    if (com.baidu.tieba.pb.pb.main.am.k(postData)) {
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
                        if (this.eUB.MR() != null) {
                            sparseArray.put(d.h.tag_user_mute_thread_id, this.eUB.MR().getId());
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
            if (postData.bso() != 1) {
            }
            if (com.baidu.tieba.pb.pb.main.am.k(postData)) {
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

    public void ka(boolean z) {
        if (this.eHJ != null && this.eHJ.aRZ() != null) {
            if (z) {
                this.eHJ.aRZ().setText(d.l.remove_mark);
            } else {
                this.eHJ.aRZ().setText(d.l.mark);
            }
            this.eHJ.refreshUI();
        }
    }

    public View aUU() {
        return this.eWm;
    }

    public void onChangeSkinType(int i) {
        this.eVW.getLayoutMode().ah(i == 1);
        this.eVW.getLayoutMode().t(this.eCy);
        this.eVW.getLayoutMode().t(this.eVU);
        this.mNavigationBar.onChangeSkinType(this.eVW.getPageContext(), i);
        if (this.eVZ != null) {
            aj.i(this.eVZ, d.e.goto_see_subject_color);
        }
        aj.i(this.eVY, d.e.cp_cont_d);
        this.clK.onChangeSkinType(this.eVW.getPageContext(), i);
        this.eVW.getLayoutMode().t(this.eWm);
        aj.i(this.eWf, d.e.cp_cont_b);
        this.eWf.setLinkTextColor(aj.getColor(d.e.cp_link_tip_c));
        if (this.dNt != null && this.dNt.CV() != null) {
            this.dNt.CV().onChangeSkinType(i);
        }
        this.eWj.dq(i);
        this.bLe.bhr();
        aj.i(this.eWs, d.e.cp_cont_e);
        aj.i(this.eOH, d.e.cp_link_tip_a);
        aj.i(this.apl, d.e.cp_cont_c);
        this.eWs.setAlpha(0.95f);
        if (this.eVV != null) {
            this.eVV.notifyDataSetChanged();
        }
    }

    public void aUV() {
        this.mProgress.setVisibility(0);
    }

    public void aUW() {
        this.Hw.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.eWj.wW();
    }

    public void aeV() {
        this.Hw.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.eWj.aeV();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cRY = onLongClickListener;
        this.eVU.setOnLongClickListener(this.cRY);
    }

    public View aUX() {
        return this.eVU;
    }

    public TextView aUY() {
        return this.eWs;
    }

    public ImageView aUZ() {
        return this.eWu;
    }

    public ImageView aVa() {
        return this.eWv;
    }

    public void pz(String str) {
        int pA = this.eVV.pA(str);
        if (pA > -1) {
            this.eVV.pN(pA);
            if (pA > 2) {
                this.Hw.setSelection(pA - 2);
            } else {
                this.Hw.setSelection(pA);
            }
            this.Hw.invalidate();
        }
    }

    public View aVb() {
        return this.eVZ;
    }

    public View aVc() {
        return this.eWg;
    }

    public MorePopupWindow aVd() {
        return this.eWk;
    }

    public void showLoadingDialog() {
        if (this.bpe == null) {
            this.bpe = new com.baidu.tbadk.core.view.a(this.eVW.getPageContext());
        }
        this.bpe.aH(true);
    }

    public void RV() {
        if (this.bpe != null) {
            this.bpe.aH(false);
        }
    }

    public TextView aVe() {
        return this.eWf;
    }

    public void setOnLinkImageClickListener(TbRichTextView.f fVar) {
        this.eVD = fVar;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.eVE = eVar;
    }

    public v aVf() {
        return this.eHJ;
    }

    public void ajf() {
    }

    public void ajg() {
    }

    public void onActivityDestroy() {
    }

    public void aVg() {
        if (this.eVW.aax()) {
        }
    }

    public View aVh() {
        return this.eWa;
    }

    private SpannableStringBuilder ah(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.g.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.eVW.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
