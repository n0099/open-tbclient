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
    private static final int eWN = TbadkCoreApplication.getInst().getListItemRule().yu();
    private BdListView Hw;
    private com.baidu.tbadk.core.view.a bpr;
    private View.OnClickListener cUW;
    private View cjc;
    private NoNetworkView cmD;
    private RelativeLayout eDs;
    private v eID;
    private m eVv;
    private b eWH;
    private View eWO;
    private d eWP;
    private NewSubPbActivity eWQ;
    private RelativeLayout eWR;
    private TextView eWS;
    private View eWW;
    private SubPbModel eWt;
    private ThreadSkinView eXc;
    private e eXd;
    private View eXg;
    private ArrayList<PostData> eXk;
    private String eXl;
    private TextView eXm;
    private RelativeLayout eXn;
    private ImageView eXo;
    private ImageView eXp;
    private ProgressBar mProgress;
    private int maxImageWidth;
    private j mNoDataView = null;
    private TbRichTextView.e eWy = null;
    private View.OnClickListener Ro = null;
    private TbRichTextView.f eWx = null;
    private NavigationBar mNavigationBar = null;
    private View aqQ = null;
    private TextView eWT = null;
    private LinearLayout eWU = null;
    private HeadImageView eWV = null;
    private ClickableHeaderImageView ePL = null;
    private TextView apj = null;
    private ImageView eWX = null;
    private TextView ePB = null;
    private TextView eWY = null;
    private TextView eHa = null;
    private EllipsizeRichTextView eWZ = null;
    private TbImageView eXa = null;
    private PlayVoiceBntNew bLV = null;
    private TextView eXb = null;
    private MorePopupWindow eXe = null;
    private ai eXf = null;
    private com.baidu.tbadk.core.dialog.b eQy = null;
    private Dialog eQf = null;
    private com.baidu.tbadk.core.dialog.a eQh = null;
    private boolean eGD = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener cSS = null;
    private NewSubPbActivity.a eXh = null;
    private NewSubPbActivity.a eXi = null;
    private ArrayList<IconData> eGH = null;
    private ArrayList<IconData> dyW = null;
    private com.baidu.tbadk.editortools.pb.e dOn = null;
    private String eXj = null;
    private int aQn = 0;
    private PostData eFQ = null;
    private int eXq = 0;
    private int eXr = 2;
    private int eXs = 0;
    private boolean eWI = true;
    protected HashMap<Long, HashSet<String>> eXt = new HashMap<>();
    protected final b.a eXu = new b.a() { // from class: com.baidu.tieba.pb.pb.sub.c.1
        @Override // com.baidu.tieba.pb.b.a
        public void d(String str, String str2, String str3, String str4, String str5) {
            if (c.this.eVv != null && c.this.eFQ != null && c.this.eVv.aPX() != null && c.this.eVv.MR() != null && c.this.eFQ.bsH() != null && !"VIEW_TRUE".equals(str3) && !"VIEW_CAROUSEL".equals(str3)) {
                com.baidu.tieba.pb.b.a(c.this.eFQ.bsH().getTemplateId(), c.this.eFQ.bsH().bsh(), str, "PB", str2, str3, "tpoint", str4, str5, c.this.eVv.aPX().getId(), c.this.eVv.aPX().getName(), c.this.eVv.MR().getTid());
            }
        }
    };
    private View.OnClickListener eGI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(d.h.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(d.h.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(d.h.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.h.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (!com.baidu.tieba.c.a.WT() || !com.baidu.tieba.c.a.a(c.this.eWQ.getBaseContext(), c.this.eWQ.getThreadId(), c.this.eWQ.getPostId(), c.this.eWQ.aPt())) {
                        if (booleanValue2) {
                            sparseArray.put(d.h.tag_from, 1);
                            c.this.eWQ.c(sparseArray);
                            return;
                        }
                        c.this.bn(view);
                    }
                } else if (booleanValue2) {
                    sparseArray.put(d.h.tag_from, 0);
                    c.this.eWQ.c(sparseArray);
                } else if (booleanValue3) {
                    c.this.a(((Integer) sparseArray.get(d.h.tag_del_post_type)).intValue(), (String) sparseArray.get(d.h.tag_del_post_id), ((Integer) sparseArray.get(d.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.h.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aRw = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.c.6
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            c.this.ka(false);
            c.this.bq(view);
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
    protected AdapterView.OnItemClickListener eXv = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ax.aU(c.this.eWQ.getPageContext().getPageActivity())) {
                if (c.this.eWH != null) {
                    c.this.eWH.aUN();
                }
                c.this.aVa();
                if (view == null || !(view.getTag() instanceof d.a)) {
                    PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(c.this.eXk, i);
                    if (postData == null) {
                        c.this.eXl = null;
                    } else {
                        c.this.eXl = postData.getId();
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(d.h.tag_photo_username);
                        String str2 = (String) sparseArray.get(d.h.tag_photo_userid);
                        if (str != null) {
                            c.this.dOn.setReplyId(str2);
                            c.this.dOn.ge(str);
                        }
                    }
                    c.this.aVb();
                    return;
                }
                c.this.aVc();
                c.this.eWt.aVy();
            }
        }
    };
    protected AdapterView.OnItemLongClickListener mOnItemLongClickListener = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.4
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (c.this.cSS != null) {
                c.this.cSS.onLongClick(view);
                return false;
            }
            return false;
        }
    };

    public c(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.eDs = null;
        this.eWO = null;
        this.Hw = null;
        this.eWP = null;
        this.eWQ = null;
        this.cmD = null;
        this.eWR = null;
        this.eWS = null;
        this.eWW = null;
        this.eXd = null;
        this.eXg = null;
        this.cUW = null;
        this.mProgress = null;
        this.eXm = null;
        this.eXn = null;
        this.eXo = null;
        this.eXp = null;
        this.eWQ = newSubPbActivity;
        this.cUW = onClickListener;
        this.eDs = (RelativeLayout) LayoutInflater.from(this.eWQ.getPageContext().getPageActivity()).inflate(d.j.new_sub_pb_layout, (ViewGroup) null);
        this.eWO = LayoutInflater.from(this.eWQ.getPageContext().getPageActivity()).inflate(d.j.new_sub_pb_head, (ViewGroup) null);
        this.eWS = (TextView) this.eDs.findViewById(d.h.no_reply_list_view);
        this.eXn = (RelativeLayout) this.eDs.findViewById(d.h.subpb_editor_tool_comment);
        this.eXm = (TextView) this.eDs.findViewById(d.h.subpb_editor_tool_comment_reply_text);
        this.eXm.setOnClickListener(this.cUW);
        this.eXo = (ImageView) this.eDs.findViewById(d.h.subpb_editor_tool_more_img);
        this.eXp = (ImageView) this.eDs.findViewById(d.h.subpb_editor_tool_emotion_img);
        this.eXp.setOnClickListener(this.cUW);
        this.eXo.setOnClickListener(this.cUW);
        this.cmD = (NoNetworkView) this.eDs.findViewById(d.h.view_no_network);
        this.maxImageWidth = k.ae(this.eWQ.getBaseContext()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds60);
        aUZ();
        aUW();
        this.eWR = (RelativeLayout) this.eDs.findViewById(d.h.sub_pb_body_layout);
        this.Hw = (BdListView) this.eDs.findViewById(d.h.new_sub_pb_list);
        this.eXc = (ThreadSkinView) LayoutInflater.from(this.eWQ.getPageContext().getPageActivity()).inflate(d.j.thread_skin_layout, (ViewGroup) null);
        this.Hw.addHeaderView(this.eXc);
        this.Hw.addHeaderView(this.eWO);
        this.cjc = BdListViewHelper.a(this.eWQ.getActivity(), this.Hw, BdListViewHelper.HeadType.DEFAULT);
        this.eWP = new d(this.eWQ.getPageContext().getPageActivity());
        this.eWP.C(this.eGI);
        this.eWP.setIsFromCDN(this.mIsFromCDN);
        this.eWP.kc(true);
        this.Hw.setAdapter((ListAdapter) this.eWP);
        this.eXd = new e(this.eWQ.getPageContext());
        this.eXg = this.eXd.getView();
        this.Hw.setNextPage(this.eXd);
        this.eXd.setOnClickListener(this.cUW);
        this.Hw.setOnItemClickListener(this.eXv);
        this.Hw.setOnTouchListener(this.aRw);
        this.mProgress = (ProgressBar) this.eDs.findViewById(d.h.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.eWO != null) {
            this.eWO.setVisibility(4);
        }
        if (this.eWR != null) {
            this.eWR.setVisibility(4);
        }
        this.eWW = com.baidu.tbadk.ala.b.nw().h(this.eWQ.getActivity(), 4);
        if (this.eWW != null) {
            this.eWW.setVisibility(8);
            this.eWU.addView(this.eWW, 3);
        }
    }

    public ListView getListView() {
        return this.Hw;
    }

    public void aUW() {
        this.eWU = (LinearLayout) this.eWO.findViewById(d.h.subpb_head_user_info_root);
        this.eWU.setOnClickListener(this.cUW);
        this.eWV = (HeadImageView) this.eWO.findViewById(d.h.photo);
        this.eWV.setRadius(k.f(this.eWQ.getActivity(), d.f.ds30));
        this.eWV.setClickable(false);
        this.ePL = (ClickableHeaderImageView) this.eWO.findViewById(d.h.god_user_photo);
        this.ePL.setGodIconMargin(0);
        this.ePL.setGodIconWidth(d.f.ds24);
        this.ePL.setRadius(k.f(this.eWQ.getActivity(), d.f.ds30));
        this.ePL.setClickable(false);
        this.apj = (TextView) this.eWO.findViewById(d.h.user_name);
        this.eWX = (ImageView) this.eWO.findViewById(d.h.user_rank);
        this.eWX.setVisibility(8);
        this.ePB = (TextView) this.eWO.findViewById(d.h.floor_owner);
        this.eWT = (TextView) this.eWO.findViewById(d.h.see_subject);
        this.eWT.setOnClickListener(this.cUW);
        this.eWY = (TextView) this.eWO.findViewById(d.h.floor);
        this.eHa = (TextView) this.eWO.findViewById(d.h.time);
        this.eWZ = (EllipsizeRichTextView) this.eWO.findViewById(d.h.content_text);
        this.eWZ.setOnClickListener(this.cUW);
        aj.i(this.eWZ, d.e.cp_cont_b);
        this.eWZ.setLinkTextColor(aj.getColor(d.e.cp_link_tip_c));
        this.eWZ.setLineSpacing(0.0f, 1.25f);
        this.eXa = (TbImageView) this.eWO.findViewById(d.h.sub_pb_image);
        this.eXa.setOnClickListener(this.cUW);
        this.eXb = (TextView) this.eWO.findViewById(d.h.advert);
        this.bLV = (PlayVoiceBntNew) this.eWO.findViewById(d.h.voice_btn);
        this.eWO.setOnTouchListener(this.aRw);
        this.eWO.setOnClickListener(this.cUW);
    }

    public void jZ(boolean z) {
        if (this.cjc != null && this.cjc.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cjc.getLayoutParams();
            if (z) {
                aUX();
                layoutParams.height = k.f(this.eWQ.getPageContext().getPageActivity(), d.f.ds98);
            } else {
                layoutParams.height = k.f(this.eWQ.getPageContext().getPageActivity(), d.f.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.cjc.setLayoutParams(layoutParams);
        }
    }

    private void aUX() {
        this.mNavigationBar.setmBackImageViewBg(d.g.subpb_navigationbar_close, d.g.subpb_navigationbar_close);
    }

    public View aUY() {
        return this.cjc;
    }

    public void aUZ() {
        this.mNavigationBar = (NavigationBar) this.eDs.findViewById(d.h.view_navigation_bar);
        this.aqQ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqQ.getLayoutParams();
            int f = k.f(this.eWQ.getPageContext().getPageActivity(), d.f.ds30);
            layoutParams.height = f;
            layoutParams.width = f;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aqQ != null && (this.aqQ.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aqQ.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.aqQ.setPadding(k.f(this.eWQ.getPageContext().getPageActivity(), d.f.ds32), this.aqQ.getPaddingTop(), this.aqQ.getPaddingRight(), this.aqQ.getPaddingBottom());
            this.aqQ.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.g.subpb_navigationbar_back, d.g.subpb_navigationbar_back);
    }

    public NavigationBar ahp() {
        return this.mNavigationBar;
    }

    public void bn(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.eQf == null) {
            this.eQf = new Dialog(this.eWQ.getPageContext().getPageActivity(), d.m.common_alert_dialog);
            this.eQf.setCanceledOnTouchOutside(true);
            this.eQf.setCancelable(true);
            View inflate = LayoutInflater.from(this.eWQ.getPageContext().getPageActivity()).inflate(d.j.forum_manage_dialog, (ViewGroup) null);
            this.eWQ.getLayoutMode().t(inflate);
            this.eQf.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.eQf.getWindow().getAttributes();
            attributes.width = (int) (k.ae(this.eWQ.getPageContext().getPageActivity()) * 0.9d);
            this.eQf.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.eQf.findViewById(d.h.del_post_btn);
        TextView textView2 = (TextView) this.eQf.findViewById(d.h.forbid_user_btn);
        TextView textView3 = (TextView) this.eQf.findViewById(d.h.disable_reply_btn);
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
                    if (c.this.eQf != null && (c.this.eQf instanceof Dialog)) {
                        g.b(c.this.eQf, c.this.eWQ.getPageContext());
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
                    if (c.this.eQf != null && (c.this.eQf instanceof Dialog)) {
                        g.b(c.this.eQf, c.this.eWQ.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && c.this.eXh != null) {
                        c.this.eXh.f(new Object[]{sparseArray4.get(d.h.tag_manage_user_identity), sparseArray4.get(d.h.tag_forbid_user_name), sparseArray4.get(d.h.tag_forbid_user_post_id)});
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
                    if (c.this.eQf != null && (c.this.eQf instanceof Dialog)) {
                        g.b(c.this.eQf, c.this.eWQ.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        c.this.eWQ.a(z, (String) sparseArray5.get(d.h.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.eQf, this.eWQ.getPageContext());
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
        this.eQh = new com.baidu.tbadk.core.dialog.a(this.eWQ.getPageContext().getPageActivity());
        this.eQh.cc(i3);
        this.eQh.z(sparseArray);
        this.eQh.a(d.l.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (c.this.eXi != null) {
                    c.this.eXi.f(new Object[]{sparseArray.get(d.h.tag_del_post_id), sparseArray.get(d.h.tag_manage_user_identity), sparseArray.get(d.h.tag_del_post_is_self), sparseArray.get(d.h.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.eQh.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eQh.ar(true);
        this.eQh.b(this.eWQ.getPageContext());
        this.eQh.to();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka(final boolean z) {
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

    public void b(b.InterfaceC0046b interfaceC0046b, boolean z) {
        String string;
        if (this.eQy != null) {
            this.eQy.dismiss();
            this.eQy = null;
        }
        if (z) {
            string = this.eWQ.getResources().getString(d.l.remove_mark);
        } else {
            string = this.eWQ.getResources().getString(d.l.mark);
        }
        this.eQy = new com.baidu.tbadk.core.dialog.b(this.eWQ.getPageContext().getPageActivity());
        this.eQy.cf(d.l.operation);
        this.eQy.a(new String[]{this.eWQ.getResources().getString(d.l.copy), string}, interfaceC0046b);
        this.eQy.d(this.eWQ.getPageContext());
        this.eQy.tr();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.eXh = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.eXi = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.eWQ.showToast(this.eWQ.getResources().getString(d.l.delete_success));
        } else if (str != null && z2) {
            this.eWQ.showToast(str);
        }
    }

    public void bq(View view) {
        if (this.cjc != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cjc.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.Hw != null) {
                    this.Hw.removeHeaderView(this.cjc);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.cjc.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + k.f(this.eWQ.getActivity(), d.f.ds98)));
            } else if (this.Hw != null) {
                this.Hw.addHeaderView(this.cjc, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void f(com.baidu.tbadk.editortools.pb.e eVar) {
        if (eVar != null && eVar.CV() != null) {
            this.dOn = eVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.eDs.addView(eVar.CV(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.eWH = bVar;
    }

    public void aVa() {
        if (this.Hw != null) {
            this.eXs = this.Hw.getLastVisiblePosition();
        }
    }

    public void aVb() {
        if (this.eWt != null) {
            if ((!aVe() && this.eXg != null && this.eXg.isShown()) || com.baidu.tbadk.core.util.v.v(this.eXk)) {
                this.eWt.kf(false);
            } else {
                this.eWt.kf(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.eWt = subPbModel;
    }

    public void aVc() {
        a(this.eWQ);
        this.Hw.setNextPage(this.eXd);
    }

    public void n(PostData postData) {
        int i;
        if (postData != null) {
            postData.mH(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!aVe() && this.eXg != null && this.eXg.isShown()) {
                i = (this.eXs - this.eXr) - 1;
            } else {
                i = this.eXs - this.eXr;
            }
            int u = com.baidu.tbadk.core.util.v.u(this.eXk);
            if (i > u) {
                i = u;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(com.baidu.tbadk.core.util.v.a(this.eXk, 0, i));
            com.baidu.tbadk.core.util.v.b(arrayList, postData2);
            com.baidu.tbadk.core.util.v.b(arrayList, postData);
            this.eWP.setDatas(arrayList);
            this.eWP.notifyDataSetChanged();
            this.Hw.smoothScrollToPosition(this.eXs + 2);
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
        return this.eDs;
    }

    public void aDM() {
        if (this.eXe != null) {
            g.a(this.eXe, this.eWQ.getPageContext().getPageActivity());
        }
        if (this.eQy != null) {
            this.eQy.dismiss();
        }
        if (this.eQh != null) {
            this.eQh.dismiss();
        }
        if (this.eQf != null) {
            g.b(this.eQf, this.eWQ.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.eID != null) {
            this.eID.dismiss();
        }
    }

    public void aVd() {
        this.Hw.setNextPage(this.eXd);
        this.eXd.wV();
    }

    public void iT(boolean z) {
        this.eGD = z;
    }

    public void setIsFromPb(boolean z) {
        this.eWI = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(m mVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (mVar != null) {
            if (this.eWI && this.eWO != null) {
                this.eWP.kd(true);
                this.eWO.setVisibility(8);
                this.Hw.removeHeaderView(this.eWO);
                this.eXr = 1;
            }
            this.eVv = mVar;
            this.eWP.Z(this.eVv.MR());
            if (this.eWO != null) {
                this.eWO.setVisibility(0);
            }
            if (this.eWR != null) {
                this.eWR.setVisibility(0);
            }
            if (mVar.aPQ() != null) {
                this.eXj = mVar.aPQ().getId();
                this.aQn = mVar.aPQ().bsz();
                if (this.aQn > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.eWQ.getResources().getString(d.l.subpb_floor_reply_count), am.y(mVar.getTotalCount())));
                    this.eXm.setText(d.l.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.eWQ.aUV()) {
                    str = "PB";
                }
                if (mVar.aPQ().rW() != null) {
                    this.eXc.a(this.eWQ.getPageContext(), mVar.aPQ().rW(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", mVar.aPX().getId(), mVar.aPX().getName(), mVar.MR().getId(), str));
                } else {
                    this.eXc.a(null, null, null);
                }
            }
            if (mVar.hasMore()) {
                this.eXd.wV();
                this.eWP.setHasMoreData(true);
            } else {
                this.eXd.wW();
                this.eWP.setHasMoreData(false);
            }
            this.eXk = mVar.aPU();
            if (com.baidu.tbadk.core.util.v.v(this.eXk)) {
                this.Hw.setNextPage(null);
                if (this.eWI) {
                    this.eWS.setVisibility(0);
                }
            } else {
                this.Hw.setNextPage(this.eXd);
                if (this.eWI) {
                    this.eWS.setVisibility(8);
                }
            }
            if (this.eXk == null || this.eXk.size() <= eWN) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.eXk.size() - eWN;
                pO(size);
                int firstVisiblePosition = this.Hw.getFirstVisiblePosition() - size;
                View childAt = this.Hw.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.eWP.setDatas(this.eXk);
            boolean z2 = false;
            if (mVar.MR() != null && mVar.MR().getAuthor() != null && (userId = mVar.MR().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.eWP.z(i, z2);
            this.eWP.notifyDataSetChanged();
            a(mVar.aPQ(), mVar.azO(), mVar.nG(), i, z);
            if (i4 > 0) {
                this.Hw.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void pO(int i) {
        if (this.eXk != null) {
            if (this.eXk.size() <= i) {
                this.eXk.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.eXk.iterator();
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

    public boolean aVe() {
        return this.eWP.bTD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.eWI) {
            this.eFQ = postData;
            if (!StringUtils.isNull(postData.bsF())) {
                this.eXa.setVisibility(0);
                this.eXa.c(postData.bsF(), 10, true);
            } else {
                this.eXa.setVisibility(8);
            }
            h bsH = postData.bsH();
            if (bsH != null && bsH.giK) {
                this.eXb.setVisibility(0);
            } else {
                this.eXb.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.eWO.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.eWO.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.h.tag_clip_board, postData);
            sparseArray.put(d.h.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.eWY.setText((CharSequence) null);
            this.apj.setText((CharSequence) null);
            this.ePB.setVisibility(8);
            if (!this.eWI) {
                b(postData.getAuthor());
                if (z) {
                    this.ePB.setVisibility(0);
                    aj.i(this.ePB, d.e.cp_link_tip_a);
                }
            }
            this.eHa.setText(am.r(postData.getTime()));
            if (this.eGD) {
                int i2 = d.g.img_default_100;
            } else {
                int i3 = d.g.icon_click;
            }
            this.eWY.setText(String.format(this.eWQ.getPageContext().getString(d.l.is_floor), Integer.valueOf(postData.bsz())));
            postData.getAuthor().getUserTbVipInfoData();
            boolean a = a(this.eWZ, postData.aDr());
            if (StringUtils.isNull(postData.bsF()) && !a && postData.ID() != null) {
                this.bLV.setVisibility(0);
                this.bLV.setTag(postData.ID());
                return;
            }
            this.bLV.setVisibility(8);
        }
    }

    private void b(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.j.aP(metaData.getSealPrefix()) + 2 : 0) + com.baidu.tbadk.util.v.gS(name_show) > 14) {
                name_show = com.baidu.tbadk.util.v.e(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.apj.setText(ah(metaData.getSealPrefix(), name_show));
            } else {
                this.apj.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.eWW != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.eWW.setVisibility(8);
                } else {
                    this.eWW.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.Qs = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.eWW.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.ePL.setVisibility(0);
                this.eWV.setVisibility(8);
                this.ePL.setUserId(metaData.getUserId());
                this.ePL.setUserName(metaData.getUserName());
                this.ePL.c(metaData.getPortrait(), 28, false);
                aj.i(this.apj, d.e.cp_cont_r);
            } else {
                this.ePL.setVisibility(8);
                this.eWV.setVisibility(0);
                this.eWV.setUserId(metaData.getUserId());
                this.eWV.setUserName(metaData.getUserName());
                this.eWV.setDefaultResource(d.g.transparent_bg);
                this.eWV.setDefaultErrorResource(d.g.icon_default_avatar100);
                this.eWV.c(metaData.getPortrait(), 28, false);
                aj.i(this.apj, d.e.cp_cont_c);
            }
            this.eWU.setTag(d.h.tag_user_id, metaData.getUserId());
            this.eWU.setTag(d.h.tag_user_name, metaData.getUserName());
            this.eWU.setTag(d.h.tag_virtual_user_url, metaData.getVirtualUserUrl());
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
                        textView.setMovementMethod(com.baidu.tieba.view.b.bwG());
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
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eWQ.getPageContext().getString(d.l.refresh_view_title_text), this.Ro));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.eWQ.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.eWR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.g.pic_emotion07, k.f(pageActivity, d.f.ds300), k.f(pageActivity, d.f.ds480), k.f(pageActivity, d.f.ds360)), dVar, a);
        }
        this.eWR.setVisibility(0);
        this.Hw.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.dOn.DT();
        aj.k(this.mNoDataView, d.e.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.eWQ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void gm(int i) {
        b(NoDataViewFactory.d.B(i, d.l.refresh_view_title_text));
        if (this.eWH != null) {
            this.eWH.bo(this.eDs);
        }
        this.eXn.setVisibility(8);
    }

    public void kL(String str) {
        b(NoDataViewFactory.d.ag(str, this.eWQ.getPageContext().getString(d.l.refresh_view_title_text)));
        if (this.eWH != null) {
            this.eWH.bo(this.eDs);
        }
        this.eXn.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Hw.setVisibility(0);
            this.eXn.setVisibility(0);
            this.eDs.setOnTouchListener(null);
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
            if (this.eVv != null && this.eVv.MR() != null && this.eVv.MR().getAuthor() != null && postData.getAuthor() != null) {
                String userId3 = this.eVv.MR().getAuthor().getUserId();
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
                    int i2 = postData.bsz() != 1 ? 0 : 1;
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
                        if (this.eVv.MR() != null) {
                            sparseArray.put(d.h.tag_user_mute_thread_id, this.eVv.MR().getId());
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
            if (postData.bsz() != 1) {
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

    public void kb(boolean z) {
        if (this.eID != null && this.eID.aSk() != null) {
            if (z) {
                this.eID.aSk().setText(d.l.remove_mark);
            } else {
                this.eID.aSk().setText(d.l.mark);
            }
            this.eID.refreshUI();
        }
    }

    public View aVf() {
        return this.eXg;
    }

    public void onChangeSkinType(int i) {
        this.eWQ.getLayoutMode().ah(i == 1);
        this.eWQ.getLayoutMode().t(this.eDs);
        this.eWQ.getLayoutMode().t(this.eWO);
        this.mNavigationBar.onChangeSkinType(this.eWQ.getPageContext(), i);
        if (this.eWT != null) {
            aj.i(this.eWT, d.e.goto_see_subject_color);
        }
        aj.i(this.eWS, d.e.cp_cont_d);
        this.cmD.onChangeSkinType(this.eWQ.getPageContext(), i);
        this.eWQ.getLayoutMode().t(this.eXg);
        aj.i(this.eWZ, d.e.cp_cont_b);
        this.eWZ.setLinkTextColor(aj.getColor(d.e.cp_link_tip_c));
        if (this.dOn != null && this.dOn.CV() != null) {
            this.dOn.CV().onChangeSkinType(i);
        }
        this.eXd.dq(i);
        this.bLV.bhC();
        aj.i(this.eXm, d.e.cp_cont_e);
        aj.i(this.ePB, d.e.cp_link_tip_a);
        aj.i(this.apj, d.e.cp_cont_c);
        this.eXm.setAlpha(0.95f);
        if (this.eWP != null) {
            this.eWP.notifyDataSetChanged();
        }
    }

    public void aVg() {
        this.mProgress.setVisibility(0);
    }

    public void aVh() {
        this.Hw.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.eXd.wW();
    }

    public void afg() {
        this.Hw.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.eXd.afg();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cSS = onLongClickListener;
        this.eWO.setOnLongClickListener(this.cSS);
    }

    public View aVi() {
        return this.eWO;
    }

    public TextView aVj() {
        return this.eXm;
    }

    public ImageView aVk() {
        return this.eXo;
    }

    public ImageView aVl() {
        return this.eXp;
    }

    public void pB(String str) {
        int pC = this.eWP.pC(str);
        if (pC > -1) {
            this.eWP.pP(pC);
            if (pC > 2) {
                this.Hw.setSelection(pC - 2);
            } else {
                this.Hw.setSelection(pC);
            }
            this.Hw.invalidate();
        }
    }

    public View aVm() {
        return this.eWT;
    }

    public View aVn() {
        return this.eXa;
    }

    public MorePopupWindow aVo() {
        return this.eXe;
    }

    public void showLoadingDialog() {
        if (this.bpr == null) {
            this.bpr = new com.baidu.tbadk.core.view.a(this.eWQ.getPageContext());
        }
        this.bpr.aH(true);
    }

    public void Sb() {
        if (this.bpr != null) {
            this.bpr.aH(false);
        }
    }

    public TextView aVp() {
        return this.eWZ;
    }

    public void setOnLinkImageClickListener(TbRichTextView.f fVar) {
        this.eWx = fVar;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.eWy = eVar;
    }

    public v aVq() {
        return this.eID;
    }

    public void ajq() {
    }

    public void ajr() {
    }

    public void onActivityDestroy() {
    }

    public void aVr() {
        if (this.eWQ.aaI()) {
        }
    }

    public View aVs() {
        return this.eWU;
    }

    private SpannableStringBuilder ah(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.g.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.eWQ.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
