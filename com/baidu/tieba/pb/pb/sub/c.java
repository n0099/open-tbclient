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
    private static final int eQI = TbadkCoreApplication.getInst().getListItemRule().xM();
    private BdListView HO;
    private com.baidu.tbadk.core.view.a bqO;
    private View cii;
    private NoNetworkView cmO;
    private u eBJ;
    private m ePj;
    private b eQC;
    private View eQJ;
    private d eQK;
    private NewSubPbActivity eQL;
    private RelativeLayout eQM;
    private TextView eQN;
    private View eQR;
    private ThreadSkinView eQX;
    private e eQY;
    private SubPbModel eQo;
    private View eRb;
    private ArrayList<PostData> eRf;
    private String eRg;
    private TextView eRh;
    private RelativeLayout eRi;
    private ImageView eRj;
    private ImageView eRk;
    private RelativeLayout eww;
    private View.OnClickListener ezS;
    private ProgressBar mProgress;
    private int maxImageWidth;
    private f mNoDataView = null;
    private TbRichTextView.f eQt = null;
    private View.OnClickListener Ro = null;
    private TbRichTextView.g eQs = null;
    private NavigationBar mNavigationBar = null;
    private View apM = null;
    private TextView eQO = null;
    private LinearLayout eQP = null;
    private HeadImageView eQQ = null;
    private ClickableHeaderImageView eJn = null;
    private TextView aoi = null;
    private ImageView eQS = null;
    private TextView eJd = null;
    private TextView eQT = null;
    private TextView eAk = null;
    private EllipsizeRichTextView eQU = null;
    private TbImageView eQV = null;
    private PlayVoiceBntNew bLf = null;
    private TextView eQW = null;
    private MorePopupWindow eQZ = null;
    private ah eRa = null;
    private com.baidu.tbadk.core.dialog.b eJV = null;
    private Dialog eJK = null;
    private com.baidu.tbadk.core.dialog.a eJM = null;
    private boolean ezM = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener axo = null;
    private NewSubPbActivity.a eRc = null;
    private NewSubPbActivity.a eRd = null;
    private ArrayList<IconData> ezQ = null;
    private ArrayList<IconData> duX = null;
    private com.baidu.tbadk.editortools.pb.e dKr = null;
    private String eRe = null;
    private int aRc = 0;
    private PostData eyY = null;
    private int eRl = 0;
    private int eRm = 2;
    private int eRn = 0;
    private boolean eQD = true;
    protected HashMap<Long, HashSet<String>> eRo = new HashMap<>();
    protected final a.InterfaceC0109a eRp = new a.InterfaceC0109a() { // from class: com.baidu.tieba.pb.pb.sub.c.1
        @Override // com.baidu.tieba.pb.a.InterfaceC0109a
        public void d(String str, String str2, String str3, String str4, String str5) {
            if (c.this.ePj != null && c.this.eyY != null && c.this.ePj.aNM() != null && c.this.ePj.Nd() != null && c.this.eyY.bry() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                com.baidu.tieba.pb.a.a(c.this.eyY.bry().getTemplateId(), c.this.eyY.bry().bqX(), str, "PB", str2, str3, "tpoint", str4, str5, c.this.ePj.aNM().getId(), c.this.ePj.aNM().getName(), c.this.ePj.Nd().getTid());
            }
        }
    };
    private View.OnClickListener ezR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(d.h.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(d.h.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (!com.baidu.tieba.c.a.Xj() || !com.baidu.tieba.c.a.a(c.this.eQL.getBaseContext(), c.this.eQL.getThreadId(), c.this.eQL.getPostId(), c.this.eQL.aNh())) {
                        if (booleanValue2) {
                            sparseArray.put(d.h.tag_from, 1);
                            c.this.eQL.c(sparseArray);
                            return;
                        }
                        c.this.bk(view);
                    }
                } else if (booleanValue2) {
                    sparseArray.put(d.h.tag_from, 0);
                    c.this.eQL.c(sparseArray);
                } else if (booleanValue3) {
                    c.this.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aSk = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.c.6
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            c.this.jO(false);
            c.this.bo(view);
            c.this.jO(true);
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
    protected AdapterView.OnItemClickListener eRq = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ax.aT(c.this.eQL.getPageContext().getPageActivity())) {
                if (c.this.eQC != null) {
                    c.this.eQC.aSR();
                }
                c.this.aTe();
                if (view == null || !(view.getTag() instanceof d.a)) {
                    PostData postData = (PostData) v.c(c.this.eRf, i);
                    if (postData == null) {
                        c.this.eRg = null;
                    } else {
                        c.this.eRg = postData.getId();
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(d.h.tag_photo_username);
                        String str2 = (String) sparseArray.get(d.h.tag_photo_userid);
                        if (str != null) {
                            c.this.dKr.setReplyId(str2);
                            c.this.dKr.fW(str);
                        }
                    }
                    c.this.aTf();
                    return;
                }
                c.this.aTg();
                c.this.eQo.aTC();
            }
        }
    };
    protected AdapterView.OnItemLongClickListener mOnItemLongClickListener = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.4
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (c.this.axo != null) {
                c.this.axo.onLongClick(view);
                return false;
            }
            return false;
        }
    };

    public c(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.eww = null;
        this.eQJ = null;
        this.HO = null;
        this.eQK = null;
        this.eQL = null;
        this.cmO = null;
        this.eQM = null;
        this.eQN = null;
        this.eQR = null;
        this.eQY = null;
        this.eRb = null;
        this.ezS = null;
        this.mProgress = null;
        this.eRh = null;
        this.eRi = null;
        this.eRj = null;
        this.eRk = null;
        this.eQL = newSubPbActivity;
        this.ezS = onClickListener;
        this.eww = (RelativeLayout) LayoutInflater.from(this.eQL.getPageContext().getPageActivity()).inflate(d.j.new_sub_pb_layout, (ViewGroup) null);
        this.eQJ = LayoutInflater.from(this.eQL.getPageContext().getPageActivity()).inflate(d.j.new_sub_pb_head, (ViewGroup) null);
        this.eQN = (TextView) this.eww.findViewById(d.h.no_reply_list_view);
        this.eRi = (RelativeLayout) this.eww.findViewById(d.h.subpb_editor_tool_comment);
        this.eRh = (TextView) this.eww.findViewById(d.h.subpb_editor_tool_comment_reply_text);
        this.eRh.setOnClickListener(this.ezS);
        this.eRj = (ImageView) this.eww.findViewById(d.h.subpb_editor_tool_more_img);
        this.eRk = (ImageView) this.eww.findViewById(d.h.subpb_editor_tool_emotion_img);
        this.eRk.setOnClickListener(this.ezS);
        this.eRj.setOnClickListener(this.ezS);
        this.cmO = (NoNetworkView) this.eww.findViewById(d.h.view_no_network);
        this.maxImageWidth = l.ad(this.eQL.getBaseContext()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds60);
        aTd();
        aTa();
        this.eQM = (RelativeLayout) this.eww.findViewById(d.h.sub_pb_body_layout);
        this.HO = (BdListView) this.eww.findViewById(d.h.new_sub_pb_list);
        this.eQX = (ThreadSkinView) LayoutInflater.from(this.eQL.getPageContext().getPageActivity()).inflate(d.j.thread_skin_layout, (ViewGroup) null);
        this.HO.addHeaderView(this.eQX);
        this.HO.addHeaderView(this.eQJ);
        this.cii = BdListViewHelper.a(this.eQL.getActivity(), this.HO, BdListViewHelper.HeadType.DEFAULT);
        this.eQK = new d(this.eQL.getPageContext().getPageActivity());
        this.eQK.E(this.ezR);
        this.eQK.setIsFromCDN(this.mIsFromCDN);
        this.eQK.jQ(true);
        this.HO.setAdapter((ListAdapter) this.eQK);
        this.eQY = new e(this.eQL.getPageContext());
        this.eRb = this.eQY.getView();
        this.HO.setNextPage(this.eQY);
        this.eQY.setOnClickListener(this.ezS);
        this.HO.setOnItemClickListener(this.eRq);
        this.HO.setOnTouchListener(this.aSk);
        this.mProgress = (ProgressBar) this.eww.findViewById(d.h.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.eQJ != null) {
            this.eQJ.setVisibility(4);
        }
        if (this.eQM != null) {
            this.eQM.setVisibility(4);
        }
        this.eQR = com.baidu.tbadk.ala.b.nr().g(this.eQL.getActivity(), 4);
        if (this.eQR != null) {
            this.eQR.setVisibility(8);
            this.eQP.addView(this.eQR, 3);
        }
    }

    public ListView getListView() {
        return this.HO;
    }

    public void aTa() {
        this.eQP = (LinearLayout) this.eQJ.findViewById(d.h.subpb_head_user_info_root);
        this.eQP.setOnClickListener(this.ezS);
        this.eQQ = (HeadImageView) this.eQJ.findViewById(d.h.photo);
        this.eQQ.setRadius(l.f(this.eQL.getActivity(), d.f.ds30));
        this.eQQ.setClickable(false);
        this.eJn = (ClickableHeaderImageView) this.eQJ.findViewById(d.h.god_user_photo);
        this.eJn.setGodIconMargin(0);
        this.eJn.setGodIconWidth(d.f.ds24);
        this.eJn.setRadius(l.f(this.eQL.getActivity(), d.f.ds30));
        this.eJn.setClickable(false);
        this.aoi = (TextView) this.eQJ.findViewById(d.h.user_name);
        this.eQS = (ImageView) this.eQJ.findViewById(d.h.user_rank);
        this.eQS.setVisibility(8);
        this.eJd = (TextView) this.eQJ.findViewById(d.h.floor_owner);
        this.eQO = (TextView) this.eQJ.findViewById(d.h.see_subject);
        this.eQO.setOnClickListener(this.ezS);
        this.eQT = (TextView) this.eQJ.findViewById(d.h.floor);
        this.eAk = (TextView) this.eQJ.findViewById(d.h.time);
        this.eQU = (EllipsizeRichTextView) this.eQJ.findViewById(d.h.content_text);
        this.eQU.setOnClickListener(this.ezS);
        aj.i(this.eQU, d.e.cp_cont_b);
        this.eQU.setLinkTextColor(aj.getColor(d.e.cp_link_tip_c));
        this.eQU.setLineSpacing(0.0f, 1.25f);
        this.eQV = (TbImageView) this.eQJ.findViewById(d.h.sub_pb_image);
        this.eQV.setOnClickListener(this.ezS);
        this.eQW = (TextView) this.eQJ.findViewById(d.h.advert);
        this.bLf = (PlayVoiceBntNew) this.eQJ.findViewById(d.h.voice_btn);
        this.eQJ.setOnTouchListener(this.aSk);
        this.eQJ.setOnClickListener(this.ezS);
    }

    public void jN(boolean z) {
        if (this.cii != null && this.cii.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cii.getLayoutParams();
            if (z) {
                aTb();
                layoutParams.height = l.f(this.eQL.getPageContext().getPageActivity(), d.f.ds98);
            } else {
                layoutParams.height = l.f(this.eQL.getPageContext().getPageActivity(), d.f.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.cii.setLayoutParams(layoutParams);
        }
    }

    private void aTb() {
        this.mNavigationBar.setmBackImageViewBg(d.g.subpb_navigationbar_close, d.g.subpb_navigationbar_close);
    }

    public View aTc() {
        return this.cii;
    }

    public void aTd() {
        this.mNavigationBar = (NavigationBar) this.eww.findViewById(d.h.view_navigation_bar);
        this.apM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.apM.getLayoutParams();
            int f = l.f(this.eQL.getPageContext().getPageActivity(), d.f.ds30);
            layoutParams.height = f;
            layoutParams.width = f;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.apM != null && (this.apM.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.apM.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.apM.setPadding(l.f(this.eQL.getPageContext().getPageActivity(), d.f.ds32), this.apM.getPaddingTop(), this.apM.getPaddingRight(), this.apM.getPaddingBottom());
            this.apM.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.g.subpb_navigationbar_back, d.g.subpb_navigationbar_back);
    }

    public NavigationBar ahe() {
        return this.mNavigationBar;
    }

    public void bk(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.eJK == null) {
            this.eJK = new Dialog(this.eQL.getPageContext().getPageActivity(), d.m.common_alert_dialog);
            this.eJK.setCanceledOnTouchOutside(true);
            this.eJK.setCancelable(true);
            View inflate = LayoutInflater.from(this.eQL.getPageContext().getPageActivity()).inflate(d.j.forum_manage_dialog, (ViewGroup) null);
            this.eQL.getLayoutMode().t(inflate);
            this.eJK.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.eJK.getWindow().getAttributes();
            attributes.width = (int) (l.ad(this.eQL.getPageContext().getPageActivity()) * 0.9d);
            this.eJK.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.eJK.findViewById(d.h.del_post_btn);
        TextView textView2 = (TextView) this.eJK.findViewById(d.h.forbid_user_btn);
        TextView textView3 = (TextView) this.eJK.findViewById(d.h.disable_reply_btn);
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
                    if (c.this.eJK != null && (c.this.eJK instanceof Dialog)) {
                        g.b(c.this.eJK, c.this.eQL.getPageContext());
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
                    if (c.this.eJK != null && (c.this.eJK instanceof Dialog)) {
                        g.b(c.this.eJK, c.this.eQL.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && c.this.eRc != null) {
                        c.this.eRc.f(new Object[]{sparseArray4.get(d.h.tag_manage_user_identity), sparseArray4.get(d.h.tag_forbid_user_name), sparseArray4.get(d.h.tag_forbid_user_post_id)});
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
                    if (c.this.eJK != null && (c.this.eJK instanceof Dialog)) {
                        g.b(c.this.eJK, c.this.eQL.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        c.this.eQL.a(z, (String) sparseArray5.get(d.h.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.eJK, this.eQL.getPageContext());
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
        this.eJM = new com.baidu.tbadk.core.dialog.a(this.eQL.getPageContext().getPageActivity());
        this.eJM.cc(i3);
        this.eJM.z(sparseArray);
        this.eJM.a(d.l.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (c.this.eRd != null) {
                    c.this.eRd.f(new Object[]{sparseArray.get(d.h.tag_del_post_id), sparseArray.get(d.h.tag_manage_user_identity), sparseArray.get(d.h.tag_del_post_is_self), sparseArray.get(d.h.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.eJM.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eJM.aq(true);
        this.eJM.b(this.eQL.getPageContext());
        this.eJM.tb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jO(final boolean z) {
        if (this.HO != null) {
            if (!z) {
                this.HO.setEnabled(z);
            } else {
                this.HO.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.HO.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void b(b.InterfaceC0047b interfaceC0047b, boolean z) {
        String string;
        if (this.eJV != null) {
            this.eJV.dismiss();
            this.eJV = null;
        }
        if (z) {
            string = this.eQL.getResources().getString(d.l.remove_mark);
        } else {
            string = this.eQL.getResources().getString(d.l.mark);
        }
        this.eJV = new com.baidu.tbadk.core.dialog.b(this.eQL.getPageContext().getPageActivity());
        this.eJV.cf(d.l.operation);
        this.eJV.a(new String[]{this.eQL.getResources().getString(d.l.copy), string}, interfaceC0047b);
        this.eJV.d(this.eQL.getPageContext());
        this.eJV.te();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.eRc = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.eRd = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.eQL.showToast(this.eQL.getResources().getString(d.l.delete_success));
        } else if (str != null && z2) {
            this.eQL.showToast(str);
        }
    }

    public void bo(View view) {
        if (this.cii != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cii.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.HO != null) {
                    this.HO.removeHeaderView(this.cii);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.cii.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.f(this.eQL.getActivity(), d.f.ds98)));
            } else if (this.HO != null) {
                this.HO.addHeaderView(this.cii, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void f(com.baidu.tbadk.editortools.pb.e eVar) {
        if (eVar != null && eVar.Ct() != null) {
            this.dKr = eVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.eww.addView(eVar.Ct(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.eQC = bVar;
    }

    public void aTe() {
        if (this.HO != null) {
            this.eRn = this.HO.getLastVisiblePosition();
        }
    }

    public void aTf() {
        if (this.eQo != null) {
            if ((!aTi() && this.eRb != null && this.eRb.isShown()) || v.u(this.eRf)) {
                this.eQo.jT(false);
            } else {
                this.eQo.jT(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.eQo = subPbModel;
    }

    public void aTg() {
        a(this.eQL);
        this.HO.setNextPage(this.eQY);
    }

    public void o(PostData postData) {
        int i;
        if (postData != null) {
            postData.mA(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!aTi() && this.eRb != null && this.eRb.isShown()) {
                i = (this.eRn - this.eRm) - 1;
            } else {
                i = this.eRn - this.eRm;
            }
            int t = v.t(this.eRf);
            if (i > t) {
                i = t;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(v.a(this.eRf, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.eQK.setDatas(arrayList);
            this.eQK.notifyDataSetChanged();
            this.HO.smoothScrollToPosition(this.eRn + 2);
            this.HO.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.HO.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.HO.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.eww;
    }

    public void aCv() {
        if (this.eQZ != null) {
            g.a(this.eQZ, this.eQL.getPageContext().getPageActivity());
        }
        if (this.eJV != null) {
            this.eJV.dismiss();
        }
        if (this.eJM != null) {
            this.eJM.dismiss();
        }
        if (this.eJK != null) {
            g.b(this.eJK, this.eQL.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.eBJ != null) {
            this.eBJ.dismiss();
        }
    }

    public void aTh() {
        this.HO.setNextPage(this.eQY);
        this.eQY.wm();
    }

    public void iD(boolean z) {
        this.ezM = z;
    }

    public void setIsFromPb(boolean z) {
        this.eQD = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(m mVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (mVar != null) {
            if (this.eQD && this.eQJ != null) {
                this.eQK.jR(true);
                this.eQJ.setVisibility(8);
                this.HO.removeHeaderView(this.eQJ);
                this.eRm = 1;
            }
            this.ePj = mVar;
            this.eQK.U(this.ePj.Nd());
            if (this.eQJ != null) {
                this.eQJ.setVisibility(0);
            }
            if (this.eQM != null) {
                this.eQM.setVisibility(0);
            }
            if (mVar.aNF() != null) {
                this.eRe = mVar.aNF().getId();
                this.aRc = mVar.aNF().brq();
                if (this.aRc > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.eQL.getResources().getString(d.l.subpb_floor_reply_count), am.y(mVar.getTotalCount())));
                    this.eRh.setText(d.l.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.eQL.aSZ()) {
                    str = "PB";
                }
                if (mVar.aNF().rJ() != null) {
                    this.eQX.a(this.eQL.getPageContext(), mVar.aNF().rJ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", mVar.aNM().getId(), mVar.aNM().getName(), mVar.Nd().getId(), str));
                } else {
                    this.eQX.a(null, null, null);
                }
            }
            if (mVar.hasMore()) {
                this.eQY.wm();
                this.eQK.setHasMoreData(true);
            } else {
                this.eQY.wn();
                this.eQK.setHasMoreData(false);
            }
            this.eRf = mVar.aNJ();
            if (v.u(this.eRf)) {
                this.HO.setNextPage(null);
                if (this.eQD) {
                    this.eQN.setVisibility(0);
                }
            } else {
                this.HO.setNextPage(this.eQY);
                if (this.eQD) {
                    this.eQN.setVisibility(8);
                }
            }
            if (this.eRf == null || this.eRf.size() <= eQI) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.eRf.size() - eQI;
                pI(size);
                int firstVisiblePosition = this.HO.getFirstVisiblePosition() - size;
                View childAt = this.HO.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.eQK.setDatas(this.eRf);
            boolean z2 = false;
            if (mVar.Nd() != null && mVar.Nd().getAuthor() != null && (userId = mVar.Nd().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.eQK.x(i, z2);
            this.eQK.notifyDataSetChanged();
            a(mVar.aNF(), mVar.ayv(), mVar.nz(), i, z);
            if (i4 > 0) {
                this.HO.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void pI(int i) {
        if (this.eRf != null) {
            if (this.eRf.size() <= i) {
                this.eRf.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.eRf.iterator();
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

    public boolean aTi() {
        return this.eQK.bTc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.eQD) {
            this.eyY = postData;
            if (!StringUtils.isNull(postData.brw())) {
                this.eQV.setVisibility(0);
                this.eQV.c(postData.brw(), 10, true);
            } else {
                this.eQV.setVisibility(8);
            }
            h bry = postData.bry();
            if (bry != null && bry.ggc) {
                this.eQW.setVisibility(0);
            } else {
                this.eQW.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.eQJ.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.eQJ.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.eQT.setText((CharSequence) null);
            this.aoi.setText((CharSequence) null);
            this.eJd.setVisibility(8);
            if (!this.eQD) {
                c(postData.getAuthor());
                if (z) {
                    this.eJd.setVisibility(0);
                    aj.i(this.eJd, d.e.cp_link_tip_a);
                }
            }
            this.eAk.setText(am.r(postData.getTime()));
            if (this.ezM) {
                int i2 = d.g.img_default_100;
            } else {
                int i3 = d.g.icon_click;
            }
            this.eQT.setText(String.format(this.eQL.getPageContext().getString(d.l.is_floor), Integer.valueOf(postData.brq())));
            postData.getAuthor().getUserTbVipInfoData();
            boolean a = a(this.eQU, postData.aBY());
            if (StringUtils.isNull(postData.brw()) && !a && postData.IF() != null) {
                this.bLf.setVisibility(0);
                this.bLf.setTag(postData.IF());
                return;
            }
            this.bLf.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.aP(metaData.getSealPrefix()) + 2 : 0) + com.baidu.tbadk.util.u.gO(name_show) > 14) {
                name_show = com.baidu.tbadk.util.u.e(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.aoi.setText(ag(metaData.getSealPrefix(), name_show));
            } else {
                this.aoi.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.eQR != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.eQR.setVisibility(8);
                } else {
                    this.eQR.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.Qv = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.eQR.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.eJn.setVisibility(0);
                this.eQQ.setVisibility(8);
                this.eJn.setUserId(metaData.getUserId());
                this.eJn.setUserName(metaData.getUserName());
                this.eJn.c(metaData.getPortrait(), 28, false);
                aj.i(this.aoi, d.e.cp_cont_r);
            } else {
                this.eJn.setVisibility(8);
                this.eQQ.setVisibility(0);
                this.eQQ.setUserId(metaData.getUserId());
                this.eQQ.setUserName(metaData.getUserName());
                this.eQQ.setDefaultResource(d.g.transparent_bg);
                this.eQQ.setDefaultErrorResource(d.g.icon_default_avatar100);
                this.eQQ.c(metaData.getPortrait(), 28, false);
                aj.i(this.aoi, d.e.cp_cont_c);
            }
            this.eQP.setTag(d.h.tag_user_id, metaData.getUserId());
            this.eQP.setTag(d.h.tag_user_name, metaData.getUserName());
            this.eQP.setTag(d.h.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.Ix() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.Ix().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.IE());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.cg(true);
                        textView.setMovementMethod(com.baidu.tieba.view.b.bxO());
                        continue;
                    case 17:
                        String str = next.II().mGifInfo.mSharpText;
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
        if (!tbRichTextData.IN()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.IE() == null || tbRichTextData.IE().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.IE());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eQL.getPageContext().getString(d.l.refresh_view_title_text), this.Ro));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.eQL.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.eQM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.g.pic_emotion07, l.f(pageActivity, d.f.ds300), l.f(pageActivity, d.f.ds480), l.f(pageActivity, d.f.ds360)), dVar, a);
        }
        this.eQM.setVisibility(0);
        this.HO.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.dKr.Dr();
        aj.k(this.mNoDataView, d.e.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.eQL.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void gz(int i) {
        b(NoDataViewFactory.d.D(i, d.l.refresh_view_title_text));
        if (this.eQC != null) {
            this.eQC.bm(this.eww);
        }
        this.eRi.setVisibility(8);
    }

    public void kF(String str) {
        b(NoDataViewFactory.d.af(str, this.eQL.getPageContext().getString(d.l.refresh_view_title_text)));
        if (this.eQC != null) {
            this.eQC.bm(this.eww);
        }
        this.eRi.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.HO.setVisibility(0);
            this.eRi.setVisibility(0);
            this.eww.setOnTouchListener(null);
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
            if (this.ePj != null && this.ePj.Nd() != null && this.ePj.Nd().getAuthor() != null && postData.getAuthor() != null) {
                String userId3 = this.ePj.Nd().getAuthor().getUserId();
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
                    int i2 = postData.brq() != 1 ? 0 : 1;
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
                        if (this.ePj.Nd() != null) {
                            sparseArray.put(d.h.tag_user_mute_thread_id, this.ePj.Nd().getId());
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
            if (postData.brq() != 1) {
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

    public void jP(boolean z) {
        if (this.eBJ != null && this.eBJ.aQc() != null) {
            if (z) {
                this.eBJ.aQc().setText(d.l.remove_mark);
            } else {
                this.eBJ.aQc().setText(d.l.mark);
            }
            this.eBJ.refreshUI();
        }
    }

    public View aTj() {
        return this.eRb;
    }

    public void onChangeSkinType(int i) {
        this.eQL.getLayoutMode().ah(i == 1);
        this.eQL.getLayoutMode().t(this.eww);
        this.eQL.getLayoutMode().t(this.eQJ);
        this.mNavigationBar.onChangeSkinType(this.eQL.getPageContext(), i);
        if (this.eQO != null) {
            aj.i(this.eQO, d.e.goto_see_subject_color);
        }
        aj.i(this.eQN, d.e.cp_cont_d);
        this.cmO.onChangeSkinType(this.eQL.getPageContext(), i);
        this.eQL.getLayoutMode().t(this.eRb);
        aj.i(this.eQU, d.e.cp_cont_b);
        this.eQU.setLinkTextColor(aj.getColor(d.e.cp_link_tip_c));
        if (this.dKr != null && this.dKr.Ct() != null) {
            this.dKr.Ct().onChangeSkinType(i);
        }
        this.eQY.dy(i);
        this.bLf.bgc();
        aj.i(this.eRh, d.e.cp_cont_e);
        aj.i(this.eJd, d.e.cp_link_tip_a);
        aj.i(this.aoi, d.e.cp_cont_c);
        this.eRh.setAlpha(0.95f);
        if (this.eQK != null) {
            this.eQK.notifyDataSetChanged();
        }
    }

    public void aTk() {
        this.mProgress.setVisibility(0);
    }

    public void aTl() {
        this.HO.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.eQY.wn();
    }

    public void aeI() {
        this.HO.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.eQY.aeI();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axo = onLongClickListener;
        this.eQJ.setOnLongClickListener(this.axo);
    }

    public View aTm() {
        return this.eQJ;
    }

    public TextView aTn() {
        return this.eRh;
    }

    public ImageView aTo() {
        return this.eRj;
    }

    public ImageView aTp() {
        return this.eRk;
    }

    public void pj(String str) {
        int pk = this.eQK.pk(str);
        if (pk > -1) {
            this.eQK.pJ(pk);
            if (pk > 2) {
                this.HO.setSelection(pk - 2);
            } else {
                this.HO.setSelection(pk);
            }
            this.HO.invalidate();
        }
    }

    public View aTq() {
        return this.eQO;
    }

    public View aTr() {
        return this.eQV;
    }

    public MorePopupWindow aTs() {
        return this.eQZ;
    }

    public void showLoadingDialog() {
        if (this.bqO == null) {
            this.bqO = new com.baidu.tbadk.core.view.a(this.eQL.getPageContext());
        }
        this.bqO.aG(true);
    }

    public void Sr() {
        if (this.bqO != null) {
            this.bqO.aG(false);
        }
    }

    public TextView aTt() {
        return this.eQU;
    }

    public void setOnLinkImageClickListener(TbRichTextView.g gVar) {
        this.eQs = gVar;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.eQt = fVar;
    }

    public u aTu() {
        return this.eBJ;
    }

    public void ajq() {
    }

    public void ajr() {
    }

    public void onActivityDestroy() {
    }

    public void aTv() {
        if (this.eQL.aar()) {
        }
    }

    public View aTw() {
        return this.eQP;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.g.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.eQL.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
