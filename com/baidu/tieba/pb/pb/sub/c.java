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
    private static final int eXn = TbadkCoreApplication.getInst().getListItemRule().yr();
    private BdListView JE;
    private com.baidu.tbadk.core.view.a boz;
    private View.OnClickListener cNL;
    private View ceH;
    private NoNetworkView cgt;
    private RelativeLayout eEf;
    private v eJq;
    private SubPbModel eWT;
    private n eWc;
    private ThreadSkinView eXC;
    private e eXD;
    private View eXG;
    private ArrayList<PostData> eXK;
    private String eXL;
    private TextView eXM;
    private b eXh;
    private View eXo;
    private d eXp;
    private NewSubPbActivity eXq;
    private RelativeLayout eXr;
    private TextView eXs;
    private View eXw;
    private ProgressBar mProgress;
    private int maxImageWidth;
    private j mNoDataView = null;
    private TbRichTextView.e eWY = null;
    private View.OnClickListener Sn = null;
    private TbRichTextView.f eWX = null;
    private NavigationBar mNavigationBar = null;
    private View arn = null;
    private TextView eXt = null;
    private LinearLayout eXu = null;
    private HeadImageView eXv = null;
    private ClickableHeaderImageView eQJ = null;
    private TextView apH = null;
    private ImageView eXx = null;
    private TextView eQz = null;
    private TextView eXy = null;
    private TextView eHN = null;
    private EllipsizeRichTextView eXz = null;
    private TbImageView eXA = null;
    private PlayVoiceBntNew bIk = null;
    private TextView eXB = null;
    private MorePopupWindow eXE = null;
    private al eXF = null;
    private com.baidu.tbadk.core.dialog.b eRx = null;
    private Dialog eRd = null;
    private com.baidu.tbadk.core.dialog.a eRf = null;
    private boolean eHq = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener cLH = null;
    private NewSubPbActivity.a eXH = null;
    private NewSubPbActivity.a eXI = null;
    private ArrayList<IconData> eHu = null;
    private ArrayList<IconData> drx = null;
    private com.baidu.tbadk.editortools.pb.e dGN = null;
    private String eXJ = null;
    private int aQH = 0;
    private PostData eGC = null;
    private int eXN = 0;
    private int eXO = 2;
    private int eXP = 0;
    private boolean eXi = true;
    protected HashMap<Long, HashSet<String>> eXQ = new HashMap<>();
    protected final b.a eXR = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.c.1
        @Override // com.baidu.tieba.pb.b.a
        public void d(String str, String str2, String str3, String str4, String str5) {
            if (c.this.eWc != null && c.this.eGC != null && c.this.eWc.aQz() != null && c.this.eWc.MF() != null && c.this.eGC.bth() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                com.baidu.tieba.pb.b.a(c.this.eGC.bth().getTemplateId(), c.this.eGC.bth().bsH(), str, "PB", str2, str3, "tpoint", str4, str5, c.this.eWc.aQz().getId(), c.this.eWc.aQz().getName(), c.this.eWc.MF().getTid());
            }
        }
    };
    private View.OnClickListener eHv = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(d.h.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(d.h.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (!com.baidu.tieba.c.a.VF() || !com.baidu.tieba.c.a.a(c.this.eXq.getBaseContext(), c.this.eXq.getThreadId(), c.this.eXq.getPostId(), c.this.eXq.aPW())) {
                        if (booleanValue2) {
                            sparseArray.put(d.h.tag_from, 1);
                            c.this.eXq.d(sparseArray);
                            return;
                        }
                        c.this.bg(view);
                    }
                } else if (booleanValue2) {
                    sparseArray.put(d.h.tag_from, 0);
                    c.this.eXq.d(sparseArray);
                } else if (booleanValue3) {
                    c.this.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aRP = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.c.6
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            c.this.ka(false);
            c.this.bj(view);
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
    protected AdapterView.OnItemClickListener eXS = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (aw.aO(c.this.eXq.getPageContext().getPageActivity())) {
                if (c.this.eXh != null) {
                    c.this.eXh.aVq();
                }
                c.this.aVD();
                if (view == null || !(view.getTag() instanceof d.a)) {
                    PostData postData = (PostData) u.c(c.this.eXK, i);
                    if (postData == null) {
                        c.this.eXL = null;
                    } else {
                        c.this.eXL = postData.getId();
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(d.h.tag_photo_username);
                        String str2 = (String) sparseArray.get(d.h.tag_photo_userid);
                        if (str != null) {
                            c.this.dGN.setReplyId(str2);
                            c.this.dGN.gk(str);
                        }
                    }
                    c.this.aVE();
                    return;
                }
                c.this.aVF();
                c.this.eWT.aVZ();
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
        this.eEf = null;
        this.eXo = null;
        this.JE = null;
        this.eXp = null;
        this.eXq = null;
        this.cgt = null;
        this.eXr = null;
        this.eXs = null;
        this.eXw = null;
        this.eXD = null;
        this.eXG = null;
        this.cNL = null;
        this.mProgress = null;
        this.eXM = null;
        this.eXq = newSubPbActivity;
        this.cNL = onClickListener;
        this.eEf = (RelativeLayout) LayoutInflater.from(this.eXq.getPageContext().getPageActivity()).inflate(d.j.new_sub_pb_layout, (ViewGroup) null);
        this.eXo = LayoutInflater.from(this.eXq.getPageContext().getPageActivity()).inflate(d.j.new_sub_pb_head, (ViewGroup) null);
        this.eXs = (TextView) this.eEf.findViewById(d.h.no_reply_list_view);
        this.eXM = (TextView) this.eEf.findViewById(d.h.subpb_editor_tool_reply_text);
        this.eXM.setOnClickListener(this.cNL);
        this.cgt = (NoNetworkView) this.eEf.findViewById(d.h.view_no_network);
        this.maxImageWidth = k.ag(this.eXq.getBaseContext()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds60);
        aVC();
        aVz();
        this.eXr = (RelativeLayout) this.eEf.findViewById(d.h.sub_pb_body_layout);
        this.JE = (BdListView) this.eEf.findViewById(d.h.new_sub_pb_list);
        this.eXC = (ThreadSkinView) LayoutInflater.from(this.eXq.getPageContext().getPageActivity()).inflate(d.j.thread_skin_layout, (ViewGroup) null);
        this.JE.addHeaderView(this.eXC);
        this.JE.addHeaderView(this.eXo);
        this.ceH = BdListViewHelper.a(this.eXq.getActivity(), this.JE, BdListViewHelper.HeadType.DEFAULT);
        this.eXp = new d(this.eXq.getPageContext().getPageActivity());
        this.eXp.E(this.eHv);
        this.eXp.setIsFromCDN(this.mIsFromCDN);
        this.eXp.kc(true);
        this.JE.setAdapter((ListAdapter) this.eXp);
        this.eXD = new e(this.eXq.getPageContext());
        this.eXG = this.eXD.getView();
        this.JE.setNextPage(this.eXD);
        this.eXD.setOnClickListener(this.cNL);
        this.JE.setOnItemClickListener(this.eXS);
        this.JE.setOnTouchListener(this.aRP);
        this.mProgress = (ProgressBar) this.eEf.findViewById(d.h.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.eXo != null) {
            this.eXo.setVisibility(4);
        }
        if (this.eXr != null) {
            this.eXr.setVisibility(4);
        }
        this.eXw = com.baidu.tbadk.ala.b.nD().h(this.eXq.getActivity(), 4);
        if (this.eXw != null) {
            this.eXw.setVisibility(8);
            this.eXu.addView(this.eXw, 3);
        }
    }

    public ListView getListView() {
        return this.JE;
    }

    public void aVz() {
        this.eXu = (LinearLayout) this.eXo.findViewById(d.h.subpb_head_user_info_root);
        this.eXu.setOnClickListener(this.cNL);
        this.eXv = (HeadImageView) this.eXo.findViewById(d.h.photo);
        this.eXv.setRadius(k.g(this.eXq.getActivity(), d.f.ds30));
        this.eXv.setClickable(false);
        this.eQJ = (ClickableHeaderImageView) this.eXo.findViewById(d.h.god_user_photo);
        this.eQJ.setGodIconMargin(0);
        this.eQJ.setGodIconWidth(d.f.ds24);
        this.eQJ.setRadius(k.g(this.eXq.getActivity(), d.f.ds30));
        this.eQJ.setClickable(false);
        this.apH = (TextView) this.eXo.findViewById(d.h.user_name);
        this.eXx = (ImageView) this.eXo.findViewById(d.h.user_rank);
        this.eXx.setVisibility(8);
        this.eQz = (TextView) this.eXo.findViewById(d.h.floor_owner);
        this.eXt = (TextView) this.eXo.findViewById(d.h.see_subject);
        this.eXt.setOnClickListener(this.cNL);
        this.eXy = (TextView) this.eXo.findViewById(d.h.floor);
        this.eHN = (TextView) this.eXo.findViewById(d.h.time);
        this.eXz = (EllipsizeRichTextView) this.eXo.findViewById(d.h.content_text);
        this.eXz.setOnClickListener(this.cNL);
        ai.i(this.eXz, d.e.cp_cont_b);
        this.eXz.setLinkTextColor(ai.getColor(d.e.cp_link_tip_c));
        this.eXz.setLineSpacing(0.0f, 1.25f);
        this.eXA = (TbImageView) this.eXo.findViewById(d.h.sub_pb_image);
        this.eXA.setOnClickListener(this.cNL);
        this.eXB = (TextView) this.eXo.findViewById(d.h.advert);
        this.bIk = (PlayVoiceBntNew) this.eXo.findViewById(d.h.voice_btn);
        this.eXo.setOnTouchListener(this.aRP);
        this.eXo.setOnClickListener(this.cNL);
    }

    public void jZ(boolean z) {
        if (this.ceH != null && this.ceH.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.ceH.getLayoutParams();
            if (z) {
                aVA();
                layoutParams.height = k.g(this.eXq.getPageContext().getPageActivity(), d.f.ds98);
            } else {
                layoutParams.height = k.g(this.eXq.getPageContext().getPageActivity(), d.f.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.ceH.setLayoutParams(layoutParams);
        }
    }

    private void aVA() {
        this.mNavigationBar.setmBackImageViewBg(d.g.subpb_navigationbar_close, d.g.subpb_navigationbar_close);
    }

    public View aVB() {
        return this.ceH;
    }

    public void aVC() {
        this.mNavigationBar = (NavigationBar) this.eEf.findViewById(d.h.view_navigation_bar);
        this.arn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.arn.getLayoutParams();
            int g = k.g(this.eXq.getPageContext().getPageActivity(), d.f.ds30);
            layoutParams.height = g;
            layoutParams.width = g;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.arn != null && (this.arn.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.arn.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.arn.setPadding(k.g(this.eXq.getPageContext().getPageActivity(), d.f.ds32), this.arn.getPaddingTop(), this.arn.getPaddingRight(), this.arn.getPaddingBottom());
            this.arn.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.g.subpb_navigationbar_back, d.g.subpb_navigationbar_back);
    }

    public NavigationBar afG() {
        return this.mNavigationBar;
    }

    public void bg(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.eRd == null) {
            this.eRd = new Dialog(this.eXq.getPageContext().getPageActivity(), d.m.common_alert_dialog);
            this.eRd.setCanceledOnTouchOutside(true);
            this.eRd.setCancelable(true);
            View inflate = LayoutInflater.from(this.eXq.getPageContext().getPageActivity()).inflate(d.j.forum_manage_dialog, (ViewGroup) null);
            this.eXq.getLayoutMode().t(inflate);
            this.eRd.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.eRd.getWindow().getAttributes();
            attributes.width = (int) (k.ag(this.eXq.getPageContext().getPageActivity()) * 0.9d);
            this.eRd.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.eRd.findViewById(d.h.del_post_btn);
        TextView textView2 = (TextView) this.eRd.findViewById(d.h.forbid_user_btn);
        TextView textView3 = (TextView) this.eRd.findViewById(d.h.disable_reply_btn);
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
                    if (c.this.eRd != null && (c.this.eRd instanceof Dialog)) {
                        g.b(c.this.eRd, c.this.eXq.getPageContext());
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
                    if (c.this.eRd != null && (c.this.eRd instanceof Dialog)) {
                        g.b(c.this.eRd, c.this.eXq.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && c.this.eXH != null) {
                        c.this.eXH.g(new Object[]{sparseArray4.get(d.h.tag_manage_user_identity), sparseArray4.get(d.h.tag_forbid_user_name), sparseArray4.get(d.h.tag_forbid_user_post_id)});
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
                    if (c.this.eRd != null && (c.this.eRd instanceof Dialog)) {
                        g.b(c.this.eRd, c.this.eXq.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        c.this.eXq.a(z, (String) sparseArray5.get(d.h.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.eRd, this.eXq.getPageContext());
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
        this.eRf = new com.baidu.tbadk.core.dialog.a(this.eXq.getPageContext().getPageActivity());
        this.eRf.cc(i3);
        this.eRf.A(sparseArray);
        this.eRf.a(d.l.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (c.this.eXI != null) {
                    c.this.eXI.g(new Object[]{sparseArray.get(d.h.tag_del_post_id), sparseArray.get(d.h.tag_manage_user_identity), sparseArray.get(d.h.tag_del_post_is_self), sparseArray.get(d.h.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.eRf.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eRf.ar(true);
        this.eRf.b(this.eXq.getPageContext());
        this.eRf.ts();
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
        if (this.eRx != null) {
            this.eRx.dismiss();
            this.eRx = null;
        }
        if (z) {
            string = this.eXq.getResources().getString(d.l.remove_mark);
        } else {
            string = this.eXq.getResources().getString(d.l.mark);
        }
        this.eRx = new com.baidu.tbadk.core.dialog.b(this.eXq.getPageContext().getPageActivity());
        this.eRx.cf(d.l.operation);
        this.eRx.a(new String[]{this.eXq.getResources().getString(d.l.copy), string}, interfaceC0043b);
        this.eRx.d(this.eXq.getPageContext());
        this.eRx.tv();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.eXH = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.eXI = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.eXq.showToast(this.eXq.getResources().getString(d.l.delete_success));
        } else if (str != null && z2) {
            this.eXq.showToast(str);
        }
    }

    public void bj(View view) {
        if (this.ceH != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.ceH.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.JE != null) {
                    this.JE.removeHeaderView(this.ceH);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.ceH.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + k.g(this.eXq.getActivity(), d.f.ds98)));
            } else if (this.JE != null) {
                this.JE.addHeaderView(this.ceH, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void f(com.baidu.tbadk.editortools.pb.e eVar) {
        if (eVar != null && eVar.Da() != null) {
            this.dGN = eVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.eEf.addView(eVar.Da(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.eXh = bVar;
    }

    public void aVD() {
        if (this.JE != null) {
            this.eXP = this.JE.getLastVisiblePosition();
        }
    }

    public void aVE() {
        if (this.eWT != null) {
            if ((!aVH() && this.eXG != null && this.eXG.isShown()) || u.v(this.eXK)) {
                this.eWT.ke(false);
            } else {
                this.eWT.ke(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.eWT = subPbModel;
    }

    public void aVF() {
        a(this.eXq);
        this.JE.setNextPage(this.eXD);
    }

    public void n(PostData postData) {
        int i;
        if (postData != null) {
            postData.mA(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!aVH() && this.eXG != null && this.eXG.isShown()) {
                i = (this.eXP - this.eXO) - 1;
            } else {
                i = this.eXP - this.eXO;
            }
            int u = u.u(this.eXK);
            if (i > u) {
                i = u;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(u.a(this.eXK, 0, i));
            u.b(arrayList, postData2);
            u.b(arrayList, postData);
            this.eXp.setDatas(arrayList);
            this.eXp.notifyDataSetChanged();
            this.JE.smoothScrollToPosition(this.eXP + 2);
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
        return this.eEf;
    }

    public void aBM() {
        if (this.eXE != null) {
            g.a(this.eXE, this.eXq.getPageContext().getPageActivity());
        }
        if (this.eRx != null) {
            this.eRx.dismiss();
        }
        if (this.eRf != null) {
            this.eRf.dismiss();
        }
        if (this.eRd != null) {
            g.b(this.eRd, this.eXq.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.eJq != null) {
            this.eJq.dismiss();
        }
    }

    public void aVG() {
        this.JE.setNextPage(this.eXD);
        this.eXD.wX();
    }

    public void iS(boolean z) {
        this.eHq = z;
    }

    public void setIsFromPb(boolean z) {
        this.eXi = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(n nVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (nVar != null) {
            if (this.eXi && this.eXo != null) {
                this.eXp.kd(true);
                this.eXo.setVisibility(8);
                this.JE.removeHeaderView(this.eXo);
                this.eXO = 1;
            }
            this.eWc = nVar;
            this.eXp.U(this.eWc.MF());
            if (this.eXo != null) {
                this.eXo.setVisibility(0);
            }
            if (this.eXr != null) {
                this.eXr.setVisibility(0);
            }
            if (nVar.aQt() != null) {
                this.eXJ = nVar.aQt().getId();
                this.aQH = nVar.aQt().bsZ();
                if (this.aQH > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.eXq.getResources().getString(d.l.subpb_floor_reply_count), com.baidu.tbadk.core.util.al.z(nVar.getTotalCount())));
                    this.eXM.setText(d.l.add_floor_reply_tip);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.eXq.aVy()) {
                    str = "PB";
                }
                if (nVar.aQt().sb() != null) {
                    this.eXC.a(this.eXq.getPageContext(), nVar.aQt().sb(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", nVar.aQz().getId(), nVar.aQz().getName(), nVar.MF().getId(), str));
                } else {
                    this.eXC.a(null, null, null);
                }
            }
            if (nVar.hasMore()) {
                this.eXD.wX();
                this.eXp.setHasMoreData(true);
            } else {
                this.eXD.wY();
                this.eXp.setHasMoreData(false);
            }
            this.eXK = nVar.aQx();
            if (u.v(this.eXK)) {
                this.JE.setNextPage(null);
                if (this.eXi) {
                    this.eXs.setVisibility(0);
                }
            } else {
                this.JE.setNextPage(this.eXD);
                if (this.eXi) {
                    this.eXs.setVisibility(8);
                }
            }
            if (this.eXK == null || this.eXK.size() <= eXn) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.eXK.size() - eXn;
                pJ(size);
                int firstVisiblePosition = this.JE.getFirstVisiblePosition() - size;
                View childAt = this.JE.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.eXp.setDatas(this.eXK);
            boolean z2 = false;
            if (nVar.MF() != null && nVar.MF().getAuthor() != null && (userId = nVar.MF().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.eXp.C(i, z2);
            this.eXp.notifyDataSetChanged();
            a(nVar.aQt(), nVar.axO(), nVar.nM(), i, z);
            if (i4 > 0) {
                this.JE.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void pJ(int i) {
        if (this.eXK != null) {
            if (this.eXK.size() <= i) {
                this.eXK.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.eXK.iterator();
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

    public boolean aVH() {
        return this.eXp.bPS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.eXi) {
            this.eGC = postData;
            if (!StringUtils.isNull(postData.btf())) {
                this.eXA.setVisibility(0);
                this.eXA.c(postData.btf(), 10, true);
            } else {
                this.eXA.setVisibility(8);
            }
            h bth = postData.bth();
            if (bth != null && bth.gjo) {
                this.eXB.setVisibility(0);
            } else {
                this.eXB.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.eXo.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.eXo.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.eXy.setText((CharSequence) null);
            this.apH.setText((CharSequence) null);
            this.eQz.setVisibility(8);
            if (!this.eXi) {
                b(postData.getAuthor());
                if (z) {
                    this.eQz.setVisibility(0);
                    ai.i(this.eQz, d.e.cp_link_tip_a);
                }
            }
            this.eHN.setText(com.baidu.tbadk.core.util.al.r(postData.getTime()));
            if (this.eHq) {
                int i2 = d.g.img_default_100;
            } else {
                int i3 = d.g.icon_click;
            }
            this.eXy.setText(String.format(this.eXq.getPageContext().getString(d.l.is_floor), Integer.valueOf(postData.bsZ())));
            postData.getAuthor().getUserTbVipInfoData();
            boolean a = a(this.eXz, postData.aBr());
            if (StringUtils.isNull(postData.btf()) && !a && postData.Iv() != null) {
                this.bIk.setVisibility(0);
                this.bIk.setTag(postData.Iv());
                return;
            }
            this.bIk.setVisibility(8);
        }
    }

    private void b(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.j.aT(metaData.getSealPrefix()) + 2 : 0) + com.baidu.tbadk.util.v.gW(name_show) > 14) {
                name_show = com.baidu.tbadk.util.v.e(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.apH.setText(ae(metaData.getSealPrefix(), name_show));
            } else {
                this.apH.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.eXw != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.eXw.setVisibility(8);
                } else {
                    this.eXw.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.Rq = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.eXw.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.eQJ.setVisibility(0);
                this.eXv.setVisibility(8);
                this.eQJ.setUserId(metaData.getUserId());
                this.eQJ.setUserName(metaData.getUserName());
                this.eQJ.c(metaData.getPortrait(), 28, false);
                ai.i(this.apH, d.e.cp_cont_r);
            } else {
                this.eQJ.setVisibility(8);
                this.eXv.setVisibility(0);
                this.eXv.setUserId(metaData.getUserId());
                this.eXv.setUserName(metaData.getUserName());
                this.eXv.setDefaultResource(d.g.transparent_bg);
                this.eXv.setDefaultErrorResource(d.g.icon_default_avatar100);
                this.eXv.c(metaData.getPortrait(), 28, false);
                ai.i(this.apH, d.e.cp_cont_c);
            }
            this.eXu.setTag(d.h.tag_user_id, metaData.getUserId());
            this.eXu.setTag(d.h.tag_user_name, metaData.getUserName());
            this.eXu.setTag(d.h.tag_virtual_user_url, metaData.getVirtualUserUrl());
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
                        textView.setMovementMethod(com.baidu.tieba.view.b.bxf());
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
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eXq.getPageContext().getString(d.l.refresh_view_title_text), this.Sn));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.eXq.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.eXr, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.g.pic_emotion07, k.g(pageActivity, d.f.ds300), k.g(pageActivity, d.f.ds480), k.g(pageActivity, d.f.ds360)), dVar, a);
        }
        this.eXr.setVisibility(0);
        this.JE.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.dGN.DY();
        ai.k(this.mNoDataView, d.e.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.eXq.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void gj(int i) {
        b(NoDataViewFactory.d.C(i, d.l.refresh_view_title_text));
        if (this.eXh != null) {
            this.eXh.bh(this.eEf);
        }
        this.eXM.setVisibility(8);
    }

    public void kt(String str) {
        b(NoDataViewFactory.d.ad(str, this.eXq.getPageContext().getString(d.l.refresh_view_title_text)));
        if (this.eXh != null) {
            this.eXh.bh(this.eEf);
        }
        this.eXM.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.JE.setVisibility(0);
            this.eXM.setVisibility(0);
            this.eEf.setOnTouchListener(null);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.Sn = onClickListener;
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
            if (this.eWc != null && this.eWc.MF() != null && this.eWc.MF().getAuthor() != null && postData.getAuthor() != null) {
                String userId3 = this.eWc.MF().getAuthor().getUserId();
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
                    int i2 = postData.bsZ() != 1 ? 0 : 1;
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
                        if (this.eWc.MF() != null) {
                            sparseArray.put(d.h.tag_user_mute_thread_id, this.eWc.MF().getId());
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
            if (postData.bsZ() != 1) {
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
        if (this.eJq != null && this.eJq.aSH() != null) {
            if (z) {
                this.eJq.aSH().setText(d.l.remove_mark);
            } else {
                this.eJq.aSH().setText(d.l.mark);
            }
            this.eJq.refreshUI();
        }
    }

    public View aVI() {
        return this.eXG;
    }

    public void onChangeSkinType(int i) {
        this.eXq.getLayoutMode().ah(i == 1);
        this.eXq.getLayoutMode().t(this.eEf);
        this.eXq.getLayoutMode().t(this.eXo);
        this.mNavigationBar.onChangeSkinType(this.eXq.getPageContext(), i);
        if (this.eXt != null) {
            ai.i(this.eXt, d.e.goto_see_subject_color);
        }
        ai.i(this.eXs, d.e.cp_cont_d);
        this.cgt.onChangeSkinType(this.eXq.getPageContext(), i);
        this.eXq.getLayoutMode().t(this.eXG);
        ai.i(this.eXz, d.e.cp_cont_b);
        this.eXz.setLinkTextColor(ai.getColor(d.e.cp_link_tip_c));
        if (this.dGN != null && this.dGN.Da() != null) {
            this.dGN.Da().onChangeSkinType(i);
        }
        this.eXD.dp(i);
        this.bIk.bis();
        ai.i(this.eXM, d.e.cp_cont_d);
        ai.j(this.eXM, d.g.pb_ecomm_comment_bg);
        ai.i(this.eQz, d.e.cp_link_tip_a);
        ai.i(this.apH, d.e.cp_cont_c);
        this.eXM.setAlpha(0.95f);
        if (this.eXp != null) {
            this.eXp.notifyDataSetChanged();
        }
    }

    public void aVJ() {
        this.mProgress.setVisibility(0);
    }

    public void aVK() {
        this.JE.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.eXD.wY();
    }

    public void adR() {
        this.JE.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.eXD.adR();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cLH = onLongClickListener;
        this.eXo.setOnLongClickListener(this.cLH);
    }

    public View aVL() {
        return this.eXo;
    }

    public TextView aVM() {
        return this.eXM;
    }

    public void pN(String str) {
        int pO = this.eXp.pO(str);
        if (pO > -1) {
            this.eXp.pK(pO);
            if (pO > 2) {
                this.JE.setSelection(pO - 2);
            } else {
                this.JE.setSelection(pO);
            }
            this.JE.invalidate();
        }
    }

    public View aVN() {
        return this.eXt;
    }

    public View aVO() {
        return this.eXA;
    }

    public MorePopupWindow aVP() {
        return this.eXE;
    }

    public void showLoadingDialog() {
        if (this.boz == null) {
            this.boz = new com.baidu.tbadk.core.view.a(this.eXq.getPageContext());
        }
        this.boz.aH(true);
    }

    public void Rq() {
        if (this.boz != null) {
            this.boz.aH(false);
        }
    }

    public TextView aVQ() {
        return this.eXz;
    }

    public void setOnLinkImageClickListener(TbRichTextView.f fVar) {
        this.eWX = fVar;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.eWY = eVar;
    }

    public v aVR() {
        return this.eJq;
    }

    public void ahs() {
    }

    public void aht() {
    }

    public void onActivityDestroy() {
    }

    public void aVS() {
        if (this.eXq.Zu()) {
        }
    }

    public View aVT() {
        return this.eXu;
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.g.pic_smalldot_title));
            return m.a((Context) this.eXq.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
