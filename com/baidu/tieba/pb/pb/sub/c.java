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
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.pb.pb.main.ah;
import com.baidu.tieba.pb.pb.main.u;
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
    private static final int eQW = TbadkCoreApplication.getInst().getListItemRule().xT();
    private BdListView HN;
    private com.baidu.tbadk.core.view.a bra;
    private View ciu;
    private NoNetworkView cnb;
    private View.OnClickListener eAg;
    private u eBX;
    private m ePx;
    private SubPbModel eQC;
    private b eQQ;
    private View eQX;
    private d eQY;
    private NewSubPbActivity eQZ;
    private RelativeLayout eRa;
    private TextView eRb;
    private View eRf;
    private ThreadSkinView eRl;
    private e eRm;
    private View eRp;
    private ArrayList<PostData> eRt;
    private String eRu;
    private TextView eRv;
    private RelativeLayout eRw;
    private ImageView eRx;
    private ImageView eRy;
    private RelativeLayout ewK;
    private ProgressBar mProgress;
    private int maxImageWidth;
    private f mNoDataView = null;
    private TbRichTextView.f eQH = null;
    private View.OnClickListener RA = null;
    private TbRichTextView.g eQG = null;
    private NavigationBar mNavigationBar = null;
    private View apY = null;
    private TextView eRc = null;
    private LinearLayout eRd = null;
    private HeadImageView eRe = null;
    private ClickableHeaderImageView eJB = null;
    private TextView aou = null;
    private ImageView eRg = null;
    private TextView eJr = null;
    private TextView eRh = null;
    private TextView eAy = null;
    private EllipsizeRichTextView eRi = null;
    private TbImageView eRj = null;
    private PlayVoiceBntNew bLr = null;
    private TextView eRk = null;
    private MorePopupWindow eRn = null;
    private ah eRo = null;
    private com.baidu.tbadk.core.dialog.b eKj = null;
    private Dialog eJY = null;
    private com.baidu.tbadk.core.dialog.a eKa = null;
    private boolean eAa = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener axA = null;
    private NewSubPbActivity.a eRq = null;
    private NewSubPbActivity.a eRr = null;
    private ArrayList<IconData> eAe = null;
    private ArrayList<IconData> dvl = null;
    private com.baidu.tbadk.editortools.pb.e dKF = null;
    private String eRs = null;
    private int aRp = 0;
    private PostData ezm = null;
    private int eRz = 0;
    private int eRA = 2;
    private int eRB = 0;
    private boolean eQR = true;
    protected HashMap<Long, HashSet<String>> eRC = new HashMap<>();
    protected final a.InterfaceC0109a eRD = new a.InterfaceC0109a() { // from class: com.baidu.tieba.pb.pb.sub.c.1
        @Override // com.baidu.tieba.pb.a.InterfaceC0109a
        public void d(String str, String str2, String str3, String str4, String str5) {
            if (c.this.ePx != null && c.this.ezm != null && c.this.ePx.aNR() != null && c.this.ePx.Nj() != null && c.this.ezm.brG() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                com.baidu.tieba.pb.a.a(c.this.ezm.brG().getTemplateId(), c.this.ezm.brG().brf(), str, "PB", str2, str3, "tpoint", str4, str5, c.this.ePx.aNR().getId(), c.this.ePx.aNR().getName(), c.this.ePx.Nj().getTid());
            }
        }
    };
    private View.OnClickListener eAf = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(d.h.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(d.h.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (!com.baidu.tieba.c.a.Xn() || !com.baidu.tieba.c.a.a(c.this.eQZ.getBaseContext(), c.this.eQZ.getThreadId(), c.this.eQZ.getPostId(), c.this.eQZ.aNm())) {
                        if (booleanValue2) {
                            sparseArray.put(d.h.tag_from, 1);
                            c.this.eQZ.c(sparseArray);
                            return;
                        }
                        c.this.bk(view);
                    }
                } else if (booleanValue2) {
                    sparseArray.put(d.h.tag_from, 0);
                    c.this.eQZ.c(sparseArray);
                } else if (booleanValue3) {
                    c.this.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aSx = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.c.6
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            c.this.jP(false);
            c.this.bo(view);
            c.this.jP(true);
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
    protected AdapterView.OnItemClickListener eRE = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ax.aU(c.this.eQZ.getPageContext().getPageActivity())) {
                if (c.this.eQQ != null) {
                    c.this.eQQ.aSW();
                }
                c.this.aTj();
                if (view == null || !(view.getTag() instanceof d.a)) {
                    PostData postData = (PostData) v.c(c.this.eRt, i);
                    if (postData == null) {
                        c.this.eRu = null;
                    } else {
                        c.this.eRu = postData.getId();
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(d.h.tag_photo_username);
                        String str2 = (String) sparseArray.get(d.h.tag_photo_userid);
                        if (str != null) {
                            c.this.dKF.setReplyId(str2);
                            c.this.dKF.fX(str);
                        }
                    }
                    c.this.aTk();
                    return;
                }
                c.this.aTl();
                c.this.eQC.aTH();
            }
        }
    };
    protected AdapterView.OnItemLongClickListener mOnItemLongClickListener = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.4
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (c.this.axA != null) {
                c.this.axA.onLongClick(view);
                return false;
            }
            return false;
        }
    };

    public c(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.ewK = null;
        this.eQX = null;
        this.HN = null;
        this.eQY = null;
        this.eQZ = null;
        this.cnb = null;
        this.eRa = null;
        this.eRb = null;
        this.eRf = null;
        this.eRm = null;
        this.eRp = null;
        this.eAg = null;
        this.mProgress = null;
        this.eRv = null;
        this.eRw = null;
        this.eRx = null;
        this.eRy = null;
        this.eQZ = newSubPbActivity;
        this.eAg = onClickListener;
        this.ewK = (RelativeLayout) LayoutInflater.from(this.eQZ.getPageContext().getPageActivity()).inflate(d.j.new_sub_pb_layout, (ViewGroup) null);
        this.eQX = LayoutInflater.from(this.eQZ.getPageContext().getPageActivity()).inflate(d.j.new_sub_pb_head, (ViewGroup) null);
        this.eRb = (TextView) this.ewK.findViewById(d.h.no_reply_list_view);
        this.eRw = (RelativeLayout) this.ewK.findViewById(d.h.subpb_editor_tool_comment);
        this.eRv = (TextView) this.ewK.findViewById(d.h.subpb_editor_tool_comment_reply_text);
        this.eRv.setOnClickListener(this.eAg);
        this.eRx = (ImageView) this.ewK.findViewById(d.h.subpb_editor_tool_more_img);
        this.eRy = (ImageView) this.ewK.findViewById(d.h.subpb_editor_tool_emotion_img);
        this.eRy.setOnClickListener(this.eAg);
        this.eRx.setOnClickListener(this.eAg);
        this.cnb = (NoNetworkView) this.ewK.findViewById(d.h.view_no_network);
        this.maxImageWidth = l.ad(this.eQZ.getBaseContext()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds60);
        aTi();
        aTf();
        this.eRa = (RelativeLayout) this.ewK.findViewById(d.h.sub_pb_body_layout);
        this.HN = (BdListView) this.ewK.findViewById(d.h.new_sub_pb_list);
        this.eRl = (ThreadSkinView) LayoutInflater.from(this.eQZ.getPageContext().getPageActivity()).inflate(d.j.thread_skin_layout, (ViewGroup) null);
        this.HN.addHeaderView(this.eRl);
        this.HN.addHeaderView(this.eQX);
        this.ciu = BdListViewHelper.a(this.eQZ.getActivity(), this.HN, BdListViewHelper.HeadType.DEFAULT);
        this.eQY = new d(this.eQZ.getPageContext().getPageActivity());
        this.eQY.E(this.eAf);
        this.eQY.setIsFromCDN(this.mIsFromCDN);
        this.eQY.jR(true);
        this.HN.setAdapter((ListAdapter) this.eQY);
        this.eRm = new e(this.eQZ.getPageContext());
        this.eRp = this.eRm.getView();
        this.HN.setNextPage(this.eRm);
        this.eRm.setOnClickListener(this.eAg);
        this.HN.setOnItemClickListener(this.eRE);
        this.HN.setOnTouchListener(this.aSx);
        this.mProgress = (ProgressBar) this.ewK.findViewById(d.h.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.eQX != null) {
            this.eQX.setVisibility(4);
        }
        if (this.eRa != null) {
            this.eRa.setVisibility(4);
        }
        this.eRf = com.baidu.tbadk.ala.b.nz().h(this.eQZ.getActivity(), 4);
        if (this.eRf != null) {
            this.eRf.setVisibility(8);
            this.eRd.addView(this.eRf, 3);
        }
    }

    public ListView getListView() {
        return this.HN;
    }

    public void aTf() {
        this.eRd = (LinearLayout) this.eQX.findViewById(d.h.subpb_head_user_info_root);
        this.eRd.setOnClickListener(this.eAg);
        this.eRe = (HeadImageView) this.eQX.findViewById(d.h.photo);
        this.eRe.setRadius(l.f(this.eQZ.getActivity(), d.f.ds30));
        this.eRe.setClickable(false);
        this.eJB = (ClickableHeaderImageView) this.eQX.findViewById(d.h.god_user_photo);
        this.eJB.setGodIconMargin(0);
        this.eJB.setGodIconWidth(d.f.ds24);
        this.eJB.setRadius(l.f(this.eQZ.getActivity(), d.f.ds30));
        this.eJB.setClickable(false);
        this.aou = (TextView) this.eQX.findViewById(d.h.user_name);
        this.eRg = (ImageView) this.eQX.findViewById(d.h.user_rank);
        this.eRg.setVisibility(8);
        this.eJr = (TextView) this.eQX.findViewById(d.h.floor_owner);
        this.eRc = (TextView) this.eQX.findViewById(d.h.see_subject);
        this.eRc.setOnClickListener(this.eAg);
        this.eRh = (TextView) this.eQX.findViewById(d.h.floor);
        this.eAy = (TextView) this.eQX.findViewById(d.h.time);
        this.eRi = (EllipsizeRichTextView) this.eQX.findViewById(d.h.content_text);
        this.eRi.setOnClickListener(this.eAg);
        aj.i(this.eRi, d.e.cp_cont_b);
        this.eRi.setLinkTextColor(aj.getColor(d.e.cp_link_tip_c));
        this.eRi.setLineSpacing(0.0f, 1.25f);
        this.eRj = (TbImageView) this.eQX.findViewById(d.h.sub_pb_image);
        this.eRj.setOnClickListener(this.eAg);
        this.eRk = (TextView) this.eQX.findViewById(d.h.advert);
        this.bLr = (PlayVoiceBntNew) this.eQX.findViewById(d.h.voice_btn);
        this.eQX.setOnTouchListener(this.aSx);
        this.eQX.setOnClickListener(this.eAg);
    }

    public void jO(boolean z) {
        if (this.ciu != null && this.ciu.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.ciu.getLayoutParams();
            if (z) {
                aTg();
                layoutParams.height = l.f(this.eQZ.getPageContext().getPageActivity(), d.f.ds98);
            } else {
                layoutParams.height = l.f(this.eQZ.getPageContext().getPageActivity(), d.f.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.ciu.setLayoutParams(layoutParams);
        }
    }

    private void aTg() {
        this.mNavigationBar.setmBackImageViewBg(d.g.subpb_navigationbar_close, d.g.subpb_navigationbar_close);
    }

    public View aTh() {
        return this.ciu;
    }

    public void aTi() {
        this.mNavigationBar = (NavigationBar) this.ewK.findViewById(d.h.view_navigation_bar);
        this.apY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.apY.getLayoutParams();
            int f = l.f(this.eQZ.getPageContext().getPageActivity(), d.f.ds30);
            layoutParams.height = f;
            layoutParams.width = f;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.apY != null && (this.apY.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.apY.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.apY.setPadding(l.f(this.eQZ.getPageContext().getPageActivity(), d.f.ds32), this.apY.getPaddingTop(), this.apY.getPaddingRight(), this.apY.getPaddingBottom());
            this.apY.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.g.subpb_navigationbar_back, d.g.subpb_navigationbar_back);
    }

    public NavigationBar ahj() {
        return this.mNavigationBar;
    }

    public void bk(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.eJY == null) {
            this.eJY = new Dialog(this.eQZ.getPageContext().getPageActivity(), d.m.common_alert_dialog);
            this.eJY.setCanceledOnTouchOutside(true);
            this.eJY.setCancelable(true);
            View inflate = LayoutInflater.from(this.eQZ.getPageContext().getPageActivity()).inflate(d.j.forum_manage_dialog, (ViewGroup) null);
            this.eQZ.getLayoutMode().t(inflate);
            this.eJY.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.eJY.getWindow().getAttributes();
            attributes.width = (int) (l.ad(this.eQZ.getPageContext().getPageActivity()) * 0.9d);
            this.eJY.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.eJY.findViewById(d.h.del_post_btn);
        TextView textView2 = (TextView) this.eJY.findViewById(d.h.forbid_user_btn);
        TextView textView3 = (TextView) this.eJY.findViewById(d.h.disable_reply_btn);
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
                    if (c.this.eJY != null && (c.this.eJY instanceof Dialog)) {
                        g.b(c.this.eJY, c.this.eQZ.getPageContext());
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
                    if (c.this.eJY != null && (c.this.eJY instanceof Dialog)) {
                        g.b(c.this.eJY, c.this.eQZ.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && c.this.eRq != null) {
                        c.this.eRq.f(new Object[]{sparseArray4.get(d.h.tag_manage_user_identity), sparseArray4.get(d.h.tag_forbid_user_name), sparseArray4.get(d.h.tag_forbid_user_post_id)});
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
                    if (c.this.eJY != null && (c.this.eJY instanceof Dialog)) {
                        g.b(c.this.eJY, c.this.eQZ.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        c.this.eQZ.a(z, (String) sparseArray5.get(d.h.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.eJY, this.eQZ.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        final SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.h.tag_del_post_id, str);
        sparseArray.put(d.h.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(d.h.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(d.h.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = d.l.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = d.l.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = d.l.report_thread_confirm;
            } else {
                i3 = d.l.del_thread_confirm;
            }
        }
        this.eKa = new com.baidu.tbadk.core.dialog.a(this.eQZ.getPageContext().getPageActivity());
        this.eKa.cd(i3);
        this.eKa.z(sparseArray);
        this.eKa.a(d.l.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (c.this.eRr != null) {
                    c.this.eRr.f(new Object[]{sparseArray.get(d.h.tag_del_post_id), sparseArray.get(d.h.tag_manage_user_identity), sparseArray.get(d.h.tag_del_post_is_self), sparseArray.get(d.h.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.eKa.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eKa.ar(true);
        this.eKa.b(this.eQZ.getPageContext());
        this.eKa.ti();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jP(final boolean z) {
        if (this.HN != null) {
            if (!z) {
                this.HN.setEnabled(z);
            } else {
                this.HN.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.HN.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void b(b.InterfaceC0047b interfaceC0047b, boolean z) {
        String string;
        if (this.eKj != null) {
            this.eKj.dismiss();
            this.eKj = null;
        }
        if (z) {
            string = this.eQZ.getResources().getString(d.l.remove_mark);
        } else {
            string = this.eQZ.getResources().getString(d.l.mark);
        }
        this.eKj = new com.baidu.tbadk.core.dialog.b(this.eQZ.getPageContext().getPageActivity());
        this.eKj.cg(d.l.operation);
        this.eKj.a(new String[]{this.eQZ.getResources().getString(d.l.copy), string}, interfaceC0047b);
        this.eKj.d(this.eQZ.getPageContext());
        this.eKj.tl();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.eRq = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.eRr = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.eQZ.showToast(this.eQZ.getResources().getString(d.l.delete_success));
        } else if (str != null && z2) {
            this.eQZ.showToast(str);
        }
    }

    public void bo(View view) {
        if (this.ciu != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.ciu.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.HN != null) {
                    this.HN.removeHeaderView(this.ciu);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.ciu.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.f(this.eQZ.getActivity(), d.f.ds98)));
            } else if (this.HN != null) {
                this.HN.addHeaderView(this.ciu, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void f(com.baidu.tbadk.editortools.pb.e eVar) {
        if (eVar != null && eVar.Cz() != null) {
            this.dKF = eVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.ewK.addView(eVar.Cz(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.eQQ = bVar;
    }

    public void aTj() {
        if (this.HN != null) {
            this.eRB = this.HN.getLastVisiblePosition();
        }
    }

    public void aTk() {
        if (this.eQC != null) {
            if ((!aTn() && this.eRp != null && this.eRp.isShown()) || v.u(this.eRt)) {
                this.eQC.jU(false);
            } else {
                this.eQC.jU(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.eQC = subPbModel;
    }

    public void aTl() {
        a(this.eQZ);
        this.HN.setNextPage(this.eRm);
    }

    public void o(PostData postData) {
        int i;
        if (postData != null) {
            postData.mB(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!aTn() && this.eRp != null && this.eRp.isShown()) {
                i = (this.eRB - this.eRA) - 1;
            } else {
                i = this.eRB - this.eRA;
            }
            int t = v.t(this.eRt);
            if (i > t) {
                i = t;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(v.a(this.eRt, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.eQY.setDatas(arrayList);
            this.eQY.notifyDataSetChanged();
            this.HN.smoothScrollToPosition(this.eRB + 2);
            this.HN.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.HN.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.HN.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.ewK;
    }

    public void aCA() {
        if (this.eRn != null) {
            g.a(this.eRn, this.eQZ.getPageContext().getPageActivity());
        }
        if (this.eKj != null) {
            this.eKj.dismiss();
        }
        if (this.eKa != null) {
            this.eKa.dismiss();
        }
        if (this.eJY != null) {
            g.b(this.eJY, this.eQZ.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.eBX != null) {
            this.eBX.dismiss();
        }
    }

    public void aTm() {
        this.HN.setNextPage(this.eRm);
        this.eRm.wt();
    }

    public void iE(boolean z) {
        this.eAa = z;
    }

    public void setIsFromPb(boolean z) {
        this.eQR = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(m mVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (mVar != null) {
            if (this.eQR && this.eQX != null) {
                this.eQY.jS(true);
                this.eQX.setVisibility(8);
                this.HN.removeHeaderView(this.eQX);
                this.eRA = 1;
            }
            this.ePx = mVar;
            this.eQY.U(this.ePx.Nj());
            if (this.eQX != null) {
                this.eQX.setVisibility(0);
            }
            if (this.eRa != null) {
                this.eRa.setVisibility(0);
            }
            if (mVar.aNK() != null) {
                this.eRs = mVar.aNK().getId();
                this.aRp = mVar.aNK().bry();
                if (this.aRp > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.eQZ.getResources().getString(d.l.subpb_floor_reply_count), am.x(mVar.getTotalCount())));
                    this.eRv.setText(d.l.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.eQZ.aTe()) {
                    str = "PB";
                }
                if (mVar.aNK().rQ() != null) {
                    this.eRl.a(this.eQZ.getPageContext(), mVar.aNK().rQ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", mVar.aNR().getId(), mVar.aNR().getName(), mVar.Nj().getId(), str));
                } else {
                    this.eRl.a(null, null, null);
                }
            }
            if (mVar.hasMore()) {
                this.eRm.wt();
                this.eQY.setHasMoreData(true);
            } else {
                this.eRm.wu();
                this.eQY.setHasMoreData(false);
            }
            this.eRt = mVar.aNO();
            if (v.u(this.eRt)) {
                this.HN.setNextPage(null);
                if (this.eQR) {
                    this.eRb.setVisibility(0);
                }
            } else {
                this.HN.setNextPage(this.eRm);
                if (this.eQR) {
                    this.eRb.setVisibility(8);
                }
            }
            if (this.eRt == null || this.eRt.size() <= eQW) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.eRt.size() - eQW;
                pJ(size);
                int firstVisiblePosition = this.HN.getFirstVisiblePosition() - size;
                View childAt = this.HN.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.eQY.setDatas(this.eRt);
            boolean z2 = false;
            if (mVar.Nj() != null && mVar.Nj().getAuthor() != null && (userId = mVar.Nj().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.eQY.x(i, z2);
            this.eQY.notifyDataSetChanged();
            a(mVar.aNK(), mVar.ayA(), mVar.nG(), i, z);
            if (i4 > 0) {
                this.HN.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void pJ(int i) {
        if (this.eRt != null) {
            if (this.eRt.size() <= i) {
                this.eRt.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.eRt.iterator();
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

    public boolean aTn() {
        return this.eQY.bTo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.eQR) {
            this.ezm = postData;
            if (!StringUtils.isNull(postData.brE())) {
                this.eRj.setVisibility(0);
                this.eRj.c(postData.brE(), 10, true);
            } else {
                this.eRj.setVisibility(8);
            }
            h brG = postData.brG();
            if (brG != null && brG.ggr) {
                this.eRk.setVisibility(0);
            } else {
                this.eRk.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.eQX.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.eQX.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.eRh.setText((CharSequence) null);
            this.aou.setText((CharSequence) null);
            this.eJr.setVisibility(8);
            if (!this.eQR) {
                c(postData.getAuthor());
                if (z) {
                    this.eJr.setVisibility(0);
                    aj.i(this.eJr, d.e.cp_link_tip_a);
                }
            }
            this.eAy.setText(am.q(postData.getTime()));
            if (this.eAa) {
                int i2 = d.g.img_default_100;
            } else {
                int i3 = d.g.icon_click;
            }
            this.eRh.setText(String.format(this.eQZ.getPageContext().getString(d.l.is_floor), Integer.valueOf(postData.bry())));
            postData.getAuthor().getUserTbVipInfoData();
            boolean a = a(this.eRi, postData.aCd());
            if (StringUtils.isNull(postData.brE()) && !a && postData.IL() != null) {
                this.bLr.setVisibility(0);
                this.bLr.setTag(postData.IL());
                return;
            }
            this.bLr.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.aP(metaData.getSealPrefix()) + 2 : 0) + com.baidu.tbadk.util.u.gP(name_show) > 14) {
                name_show = com.baidu.tbadk.util.u.e(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.aou.setText(ah(metaData.getSealPrefix(), name_show));
            } else {
                this.aou.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.eRf != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.eRf.setVisibility(8);
                } else {
                    this.eRf.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.QH = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.eRf.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.eJB.setVisibility(0);
                this.eRe.setVisibility(8);
                this.eJB.setUserId(metaData.getUserId());
                this.eJB.setUserName(metaData.getUserName());
                this.eJB.c(metaData.getPortrait(), 28, false);
                aj.i(this.aou, d.e.cp_cont_r);
            } else {
                this.eJB.setVisibility(8);
                this.eRe.setVisibility(0);
                this.eRe.setUserId(metaData.getUserId());
                this.eRe.setUserName(metaData.getUserName());
                this.eRe.setDefaultResource(d.g.transparent_bg);
                this.eRe.setDefaultErrorResource(d.g.icon_default_avatar100);
                this.eRe.c(metaData.getPortrait(), 28, false);
                aj.i(this.aou, d.e.cp_cont_c);
            }
            this.eRd.setTag(d.h.tag_user_id, metaData.getUserId());
            this.eRd.setTag(d.h.tag_user_name, metaData.getUserName());
            this.eRd.setTag(d.h.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.ID() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.ID().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.IK());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.ch(true);
                        textView.setMovementMethod(com.baidu.tieba.view.b.bxX());
                        continue;
                    case 17:
                        String str = next.IO().mGifInfo.mSharpText;
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
        if (!tbRichTextData.IT()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.IK() == null || tbRichTextData.IK().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.IK());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eQZ.getPageContext().getString(d.l.refresh_view_title_text), this.RA));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.eQZ.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.eRa, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.g.pic_emotion07, l.f(pageActivity, d.f.ds300), l.f(pageActivity, d.f.ds480), l.f(pageActivity, d.f.ds360)), dVar, a);
        }
        this.eRa.setVisibility(0);
        this.HN.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.dKF.Dx();
        aj.k(this.mNoDataView, d.e.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.eQZ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void gA(int i) {
        b(NoDataViewFactory.d.D(i, d.l.refresh_view_title_text));
        if (this.eQQ != null) {
            this.eQQ.bm(this.ewK);
        }
        this.eRw.setVisibility(8);
    }

    public void kH(String str) {
        b(NoDataViewFactory.d.ag(str, this.eQZ.getPageContext().getString(d.l.refresh_view_title_text)));
        if (this.eQQ != null) {
            this.eQQ.bm(this.ewK);
        }
        this.eRw.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.HN.setVisibility(0);
            this.eRw.setVisibility(0);
            this.ewK.setOnTouchListener(null);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.RA = onClickListener;
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
            if (this.ePx != null && this.ePx.Nj() != null && this.ePx.Nj().getAuthor() != null && postData.getAuthor() != null) {
                String userId3 = this.ePx.Nj().getAuthor().getUserId();
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
                    int i2 = postData.bry() != 1 ? 0 : 1;
                    if (com.baidu.tieba.pb.pb.main.am.l(postData)) {
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
                        if (this.ePx.Nj() != null) {
                            sparseArray.put(d.h.tag_user_mute_thread_id, this.ePx.Nj().getId());
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
            if (postData.bry() != 1) {
            }
            if (com.baidu.tieba.pb.pb.main.am.l(postData)) {
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

    public void jQ(boolean z) {
        if (this.eBX != null && this.eBX.aQh() != null) {
            if (z) {
                this.eBX.aQh().setText(d.l.remove_mark);
            } else {
                this.eBX.aQh().setText(d.l.mark);
            }
            this.eBX.refreshUI();
        }
    }

    public View aTo() {
        return this.eRp;
    }

    public void onChangeSkinType(int i) {
        this.eQZ.getLayoutMode().ai(i == 1);
        this.eQZ.getLayoutMode().t(this.ewK);
        this.eQZ.getLayoutMode().t(this.eQX);
        this.mNavigationBar.onChangeSkinType(this.eQZ.getPageContext(), i);
        if (this.eRc != null) {
            aj.i(this.eRc, d.e.goto_see_subject_color);
        }
        aj.i(this.eRb, d.e.cp_cont_d);
        this.cnb.onChangeSkinType(this.eQZ.getPageContext(), i);
        this.eQZ.getLayoutMode().t(this.eRp);
        aj.i(this.eRi, d.e.cp_cont_b);
        this.eRi.setLinkTextColor(aj.getColor(d.e.cp_link_tip_c));
        if (this.dKF != null && this.dKF.Cz() != null) {
            this.dKF.Cz().onChangeSkinType(i);
        }
        this.eRm.dz(i);
        this.bLr.bgi();
        aj.i(this.eRv, d.e.cp_cont_e);
        aj.i(this.eJr, d.e.cp_link_tip_a);
        aj.i(this.aou, d.e.cp_cont_c);
        this.eRv.setAlpha(0.95f);
        if (this.eQY != null) {
            this.eQY.notifyDataSetChanged();
        }
    }

    public void aTp() {
        this.mProgress.setVisibility(0);
    }

    public void aTq() {
        this.HN.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.eRm.wu();
    }

    public void aeN() {
        this.HN.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.eRm.aeN();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axA = onLongClickListener;
        this.eQX.setOnLongClickListener(this.axA);
    }

    public View aTr() {
        return this.eQX;
    }

    public TextView aTs() {
        return this.eRv;
    }

    public ImageView aTt() {
        return this.eRx;
    }

    public ImageView aTu() {
        return this.eRy;
    }

    public void pk(String str) {
        int pl = this.eQY.pl(str);
        if (pl > -1) {
            this.eQY.pK(pl);
            if (pl > 2) {
                this.HN.setSelection(pl - 2);
            } else {
                this.HN.setSelection(pl);
            }
            this.HN.invalidate();
        }
    }

    public View aTv() {
        return this.eRc;
    }

    public View aTw() {
        return this.eRj;
    }

    public MorePopupWindow aTx() {
        return this.eRn;
    }

    public void showLoadingDialog() {
        if (this.bra == null) {
            this.bra = new com.baidu.tbadk.core.view.a(this.eQZ.getPageContext());
        }
        this.bra.aH(true);
    }

    public void Sv() {
        if (this.bra != null) {
            this.bra.aH(false);
        }
    }

    public TextView aTy() {
        return this.eRi;
    }

    public void setOnLinkImageClickListener(TbRichTextView.g gVar) {
        this.eQG = gVar;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.eQH = fVar;
    }

    public u aTz() {
        return this.eBX;
    }

    public void ajv() {
    }

    public void ajw() {
    }

    public void onActivityDestroy() {
    }

    public void aTA() {
        if (this.eQZ.aav()) {
        }
    }

    public View aTB() {
        return this.eRd;
    }

    private SpannableStringBuilder ah(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.g.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.eQZ.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
