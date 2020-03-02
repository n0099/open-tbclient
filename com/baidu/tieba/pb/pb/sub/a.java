package com.baidu.tieba.pb.pb.sub;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
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
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.h;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.card.l;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.pb.pb.main.w;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.b;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.i;
import com.baidu.tieba.tbadkCore.v;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class a implements KeyboardEventLayout.a {
    private static final int iUT = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener akt;
    private BdTypeListView ekb;
    private com.baidu.tbadk.core.view.a fPV;
    private TextView gDL;
    private e gQj;
    private View gdV;
    private NoNetworkView gkd;
    private l iTE;
    private w iUC;
    private SubPbView iUU;
    private LinearLayout iUV;
    private View iUW;
    private NewSubPbActivity iUX;
    private RelativeLayout iUY;
    private SubPbModel iUz;
    private c iVB;
    private View iVc;
    private ThreadSkinView iVj;
    private d iVk;
    private View iVl;
    private View iVn;
    private View iVp;
    private BlankView iVq;
    private com.baidu.tbadk.core.dialog.b iVs;
    private ArrayList<PostData> iVv;
    private RelativeLayout iVw;
    private ImageView iVx;
    private ImageView iVy;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener cKZ = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView iUZ = null;
    private LinearLayout iVa = null;
    private HeadImageView iVb = null;
    private ClickableHeaderImageView iRe = null;
    private TextView cbK = null;
    private ImageView iVd = null;
    private TextView iQX = null;
    private TextView iVe = null;
    private TextView iVf = null;
    private EllipsizeRichTextView iVg = null;
    private TbImageView iVh = null;
    private PlayVoiceBntNew NY = null;
    private TextView iVi = null;
    private MorePopupWindow iVm = null;
    private com.baidu.tbadk.core.dialog.b iVo = null;
    private Dialog iVr = null;
    private com.baidu.tbadk.core.dialog.a iOh = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a iVt = null;
    private NewSubPbActivity.a iVu = null;
    private h hPH = null;
    private int dOn = 0;
    private int iVz = 2;
    private int iVA = 0;
    private boolean dwW = true;
    private com.baidu.tieba.pb.a.c dqK = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.a.6
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.lR(false);
            a.this.lR(true);
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
            return true;
        }
    });
    protected AdapterView.OnItemLongClickListener iVC = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.3
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.getItem(a.this.iVv, i);
            if (view != null && view.getTag() != null) {
                if (a.this.iUC == null) {
                    a.this.iUC = new w(a.this.iUX.getPageContext(), a.this.akt);
                }
                a.this.iUC.showDialog();
                SparseArray<Object> sparseArray = null;
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
                if (sparseArray == null) {
                    return true;
                }
                boolean z = a.this.pL(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                a.this.iUC.a(sparseArray, a.this.iUz.ckG(), z);
                if (z) {
                    a.this.iUC.coy().setVisibility(0);
                    a.this.iUC.coy().setTag(postData.getId());
                } else {
                    a.this.iUC.coy().setVisibility(8);
                }
                a.this.iUC.cow().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener iVD = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.iUX != null && bc.checkUpIsLogin(a.this.iUX.getPageContext().getPageActivity())) {
                if ((a.this.iUX.hPy == null || a.this.iUz == null || a.this.iUz.bCY() == null || a.this.iUX.hPy.ks(a.this.iUz.bCY().replyPrivateFlag)) && a.this.iUz != null && a.this.hPH != null) {
                    a.this.crr();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.crt();
                        a.this.iUz.crR();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.hPH.setReplyId(str2);
                            a.this.hPH.vs(str);
                        }
                    }
                    a.this.crs();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.iUU = null;
        this.iUW = null;
        this.ekb = null;
        this.iUX = null;
        this.gkd = null;
        this.iUY = null;
        this.iVc = null;
        this.iVk = null;
        this.iVp = null;
        this.akt = null;
        this.mProgress = null;
        this.gDL = null;
        this.iVw = null;
        this.iVx = null;
        this.iVy = null;
        this.iUX = newSubPbActivity;
        this.akt = onClickListener;
        this.iUU = (SubPbView) LayoutInflater.from(this.iUX.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.iUW = LayoutInflater.from(this.iUX.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.iUV = (LinearLayout) this.iUU.findViewById(R.id.navigation_bar_group);
        this.iVw = (RelativeLayout) this.iUU.findViewById(R.id.subpb_editor_tool_comment);
        this.gDL = (TextView) this.iUU.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.gDL.setOnClickListener(this.akt);
        this.iVx = (ImageView) this.iUU.findViewById(R.id.subpb_editor_tool_more_img);
        this.iVy = (ImageView) this.iUU.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.iVy.setOnClickListener(this.akt);
        this.iVx.setOnClickListener(this.akt);
        this.gkd = (NoNetworkView) this.iUU.findViewById(R.id.view_no_network);
        bIj();
        bgc();
        this.iUY = (RelativeLayout) this.iUU.findViewById(R.id.sub_pb_body_layout);
        this.ekb = (BdTypeListView) this.iUU.findViewById(R.id.new_sub_pb_list);
        this.iVj = (ThreadSkinView) LayoutInflater.from(this.iUX.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.ekb.addHeaderView(this.iVj);
        this.ekb.addHeaderView(this.iUW);
        this.gdV = new TextView(newSubPbActivity.getActivity());
        this.gdV.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.ekb.addHeaderView(this.gdV, 0);
        this.iUU.setTopView(this.gdV);
        this.iUU.setNavigationView(this.iUV);
        this.iUU.setListView(this.ekb);
        this.iUU.setContentView(this.iUY);
        this.iVk = new d(this.iUX.getPageContext());
        this.iVk.setLineGone();
        this.iVp = this.iVk.getView();
        this.ekb.setNextPage(this.iVk);
        this.iVk.setOnClickListener(this.akt);
        this.ekb.setOnItemClickListener(this.iVD);
        this.ekb.setOnItemLongClickListener(this.iVC);
        this.ekb.setOnTouchListener(this.dqK);
        this.mProgress = (ProgressBar) this.iUU.findViewById(R.id.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.iUW != null) {
            this.iUW.setVisibility(4);
        }
        this.iVc = com.baidu.tbadk.ala.b.ayB().u(this.iUX.getActivity(), 4);
        if (this.iVc != null) {
            this.iVc.setVisibility(8);
            this.iVa.addView(this.iVc, 3);
        }
        this.iVB = new c(this.iUX, this.ekb);
        this.iVB.setFromCDN(this.mIsFromCDN);
        this.iVB.y(this.akt);
        this.iVB.wM();
    }

    public ListView getListView() {
        return this.ekb;
    }

    public void bgc() {
        this.iVa = (LinearLayout) this.iUW.findViewById(R.id.subpb_head_user_info_root);
        this.iVa.setOnClickListener(this.akt);
        this.iVb = (HeadImageView) this.iUW.findViewById(R.id.photo);
        this.iVb.setRadius(com.baidu.adp.lib.util.l.getDimens(this.iUX.getActivity(), R.dimen.ds30));
        this.iVb.setClickable(false);
        this.iRe = (ClickableHeaderImageView) this.iUW.findViewById(R.id.god_user_photo);
        this.iRe.setGodIconMargin(0);
        this.iRe.setGodIconWidth(R.dimen.ds24);
        this.iRe.setRadius(com.baidu.adp.lib.util.l.getDimens(this.iUX.getActivity(), R.dimen.ds30));
        this.iRe.setClickable(false);
        this.cbK = (TextView) this.iUW.findViewById(R.id.user_name);
        this.iVd = (ImageView) this.iUW.findViewById(R.id.user_rank);
        this.iVd.setVisibility(8);
        this.iQX = (TextView) this.iUW.findViewById(R.id.floor_owner);
        this.iUZ = (TextView) this.iUW.findViewById(R.id.see_subject);
        this.iUZ.setOnClickListener(this.akt);
        this.iVe = (TextView) this.iUW.findViewById(R.id.floor);
        this.iVf = (TextView) this.iUW.findViewById(R.id.time);
        this.iVg = (EllipsizeRichTextView) this.iUW.findViewById(R.id.content_text);
        this.iVg.setOnClickListener(this.akt);
        am.setViewTextColor(this.iVg, (int) R.color.cp_cont_b);
        this.iVg.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        this.iVg.setLineSpacing(0.0f, 1.25f);
        this.iVh = (TbImageView) this.iUW.findViewById(R.id.sub_pb_image);
        this.iVh.setOnClickListener(this.akt);
        this.iVi = (TextView) this.iUW.findViewById(R.id.advert);
        this.NY = (PlayVoiceBntNew) this.iUW.findViewById(R.id.voice_btn);
        this.iUW.setOnTouchListener(this.dqK);
        this.iUW.setOnClickListener(this.akt);
    }

    public void a(b.a aVar, boolean z) {
        if (this.iVs != null) {
            this.iVs.dismiss();
            this.iVs = null;
        }
        this.iVs = new com.baidu.tbadk.core.dialog.b(this.iUX.getPageContext().getPageActivity());
        if (z) {
            this.iVs.a(new String[]{this.iUX.getPageContext().getString(R.string.save_to_emotion)}, aVar);
        } else {
            this.iVs.a(new String[]{this.iUX.getPageContext().getString(R.string.save_to_emotion), this.iUX.getPageContext().getString(R.string.save_to_local)}, aVar);
        }
        this.iVs.d(this.iUX.getPageContext());
        this.iVs.aED();
    }

    public void cE(View view) {
        this.iVl = view;
    }

    public void bIj() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.iUX.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.iUX.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.iUU.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iVq != null) {
                    a.this.iUU.onFinish();
                } else {
                    a.this.iUX.finish();
                }
            }
        });
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            layoutParams.leftMargin = dimens2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = dimens;
            layoutParams2.height = dimens;
            this.mBack.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.hideBottomLine();
    }

    public void cA(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.iVr == null) {
            this.iVr = new Dialog(this.iUX.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.iVr.setCanceledOnTouchOutside(true);
            this.iVr.setCancelable(true);
            this.iVn = LayoutInflater.from(this.iUX.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.iUX.getLayoutMode().onModeChanged(this.iVn);
            this.iVr.setContentView(this.iVn);
            WindowManager.LayoutParams attributes = this.iVr.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.iUX.getPageContext().getPageActivity()) * 0.9d);
            this.iVr.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.iVr.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.iVr.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.iVr.findViewById(R.id.disable_reply_btn);
        int i = -1;
        if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
            i = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
        }
        if ("".equals(sparseArray.get(R.id.tag_del_post_id)) || i == 2) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.iVr != null && (a.this.iVr instanceof Dialog)) {
                        g.b(a.this.iVr, a.this.iUX.getPageContext());
                    }
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null) {
                        a.this.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(R.id.tag_forbid_user_name)) && "".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.iVr != null && (a.this.iVr instanceof Dialog)) {
                        g.b(a.this.iVr, a.this.iUX.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.iVt != null) {
                        a.this.iVt.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
                    }
                }
            });
        }
        if (!((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(R.string.un_mute);
            } else {
                textView3.setText(R.string.mute);
            }
            sparseArray4.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
            sparseArray4.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
            sparseArray4.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
            sparseArray4.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
            sparseArray4.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
            sparseArray4.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.iVr != null && (a.this.iVr instanceof Dialog)) {
                        g.b(a.this.iVr, a.this.iUX.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.iUX.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.iVr, this.iUX.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        final SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = R.string.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = R.string.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = R.string.report_thread_confirm;
            } else {
                i3 = R.string.del_thread_confirm;
            }
        }
        this.iOh = new com.baidu.tbadk.core.dialog.a(this.iUX.getPageContext().getPageActivity());
        this.iOh.jW(i3);
        this.iOh.setYesButtonTag(sparseArray);
        this.iOh.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.iVu != null) {
                    a.this.iVu.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.iOh.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.iOh.fG(true);
        this.iOh.b(this.iUX.getPageContext());
        if (z) {
            this.iOh.aEC();
        } else {
            d(sparseArray);
        }
    }

    private void d(final SparseArray<Object> sparseArray) {
        AntiData bCY;
        if (this.iUX != null && sparseArray != null && this.iUW != null) {
            if (this.gQj == null) {
                this.gQj = new e(this.iUX.getPageContext(), this.iUW);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.iUz != null && (bCY = this.iUz.bCY()) != null && bCY.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bCY.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray2);
            this.gQj.setDefaultReasonArray(new String[]{this.iUX.getString(R.string.delete_thread_reason_1), this.iUX.getString(R.string.delete_thread_reason_2), this.iUX.getString(R.string.delete_thread_reason_3), this.iUX.getString(R.string.delete_thread_reason_4), this.iUX.getString(R.string.delete_thread_reason_5)});
            this.gQj.setData(alVar);
            this.gQj.wm("4");
            this.gQj.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void S(JSONArray jSONArray) {
                    String O = aq.O(jSONArray);
                    if (a.this.iVu != null) {
                        a.this.iVu.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), O});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lR(final boolean z) {
        if (this.ekb != null) {
            if (!z) {
                this.ekb.setEnabled(z);
            } else {
                this.ekb.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.ekb.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.iVt = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.iVu = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.iUX.showToast(this.iUX.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.iUX.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.aOt() != null) {
            this.hPH = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.iUY.addView(hVar.aOt(), layoutParams);
            this.hPH.a(new v.a() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                @Override // com.baidu.tieba.tbadkCore.v.a
                public void a(WriteData writeData) {
                    a.this.crL();
                }
            });
        }
    }

    public void crr() {
        if (this.ekb != null) {
            this.iVA = this.ekb.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pL(boolean z) {
        if (this.iUz == null || this.iUz.crO() == null) {
            return false;
        }
        if (this.iUz.ckG() != 0) {
            return false;
        }
        return (this.iTE == null || this.iTE.aAg() == null || this.iTE.aAg().aCo() == null || !TextUtils.equals(this.iTE.aAg().aCo().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void crs() {
        if (this.iUz != null) {
            if ((!crv() && this.iVp != null && this.iVp.isShown()) || com.baidu.tbadk.core.util.v.isEmpty(this.iVv)) {
                this.iUz.qN(false);
            } else {
                this.iUz.qN(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.iUz = subPbModel;
    }

    public void qK(boolean z) {
        if (this.iUz != null && this.iUz.crp() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.iVq = new BlankView(this.iUX.getPageContext().getPageActivity());
            this.iUV.addView(this.iVq, 0, new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.iVq.setVisibility(0);
            this.iVq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.iUX.finish();
                }
            });
            this.iUU.setBlankView(this.iVq);
        }
    }

    public void crt() {
        b(this.iUX);
        this.ekb.setNextPage(this.iVk);
    }

    public void r(PostData postData) {
        int i;
        if (postData != null) {
            postData.sN(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!crv() && this.iVp != null && this.iVp.isShown()) {
                i = (this.iVA - this.iVz) - 1;
            } else {
                i = this.iVA - this.iVz;
            }
            int count = com.baidu.tbadk.core.util.v.getCount(this.iVv);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(com.baidu.tbadk.core.util.v.subList(this.iVv, 0, i));
            com.baidu.tbadk.core.util.v.add(arrayList, postData2);
            com.baidu.tbadk.core.util.v.add(arrayList, postData);
            this.ekb.smoothScrollToPosition(this.iVA + 2);
            this.ekb.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.ekb.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.ekb.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.iUU;
    }

    public void cpY() {
        if (this.iVm != null) {
            g.dismissPopupWindow(this.iVm, this.iUX.getPageContext().getPageActivity());
        }
        if (this.iVo != null) {
            this.iVo.dismiss();
        }
        if (this.iOh != null) {
            this.iOh.dismiss();
        }
        if (this.iVr != null) {
            g.b(this.iVr, this.iUX.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.iUC != null) {
            this.iUC.dismiss();
        }
    }

    public void cru() {
        this.ekb.setNextPage(this.iVk);
        this.iVk.startLoadData();
    }

    public void setIsFromPb(boolean z) {
        this.dwW = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v35, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(l lVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (lVar != null) {
            if (this.dwW && this.iUW != null) {
                this.iUW.setVisibility(8);
                this.ekb.removeHeaderView(this.iUW);
                this.iVz = 1;
            }
            this.iTE = lVar;
            if (this.iUW != null) {
                this.iUW.setVisibility(0);
            }
            if (lVar.aAg() != null && lVar.aAg().aEi()) {
                this.iUZ.setText(R.string.view_original);
            } else {
                this.iUZ.setText(R.string.view_subject);
            }
            if (lVar.clf() != null) {
                this.dOn = lVar.clf().cLa();
                if (this.dOn > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.iUX.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.dOn)));
                    if (this.iUX != null) {
                        this.gDL.setText(this.iUX.cpm());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.iUX.getResources().getString(R.string.local_floor_reply));
                }
                String str = this.iUX.crp() ? "PB" : null;
                if (lVar.clf().aCJ() != null) {
                    this.iVj.setData(this.iUX.getPageContext(), lVar.clf().aCJ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", lVar.aPm().getId(), lVar.aPm().getName(), lVar.aAg().getId(), str));
                } else {
                    this.iVj.setData(null, null, null);
                }
            }
            if (lVar.hasMore()) {
                this.iVk.startLoadData();
                this.iVB.setHasMoreData(true);
            } else {
                this.iVk.endLoadData();
                this.iVB.setHasMoreData(false);
            }
            this.iVv = lVar.clj();
            if (this.iVv == null || this.iVv.size() <= iUT) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.iVv.size() - iUT;
                zo(size);
                int firstVisiblePosition = this.ekb.getFirstVisiblePosition() - size;
                View childAt = this.ekb.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.iVv);
            if (com.baidu.tbadk.core.util.v.isEmpty(this.iVv)) {
                this.ekb.setNextPage(null);
                if (this.dwW) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.ekb.setNextPage(this.iVk);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(lVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.dwW) {
                arrayList.add(0, lVar.clf());
            }
            this.iVB.b(this.iTE.aAg(), arrayList);
            a(lVar, lVar.clf(), lVar.bXu(), lVar.ayL(), i, z);
            if (i4 > 0) {
                this.ekb.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void zo(int i) {
        if (this.iVv != null) {
            if (this.iVv.size() <= i) {
                this.iVv.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.iVv.iterator();
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

    public boolean crv() {
        return this.iVB.aca();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.dwW) {
            if (!StringUtils.isNull(postData.cLh())) {
                this.iVh.setVisibility(0);
                this.iVh.startLoad(postData.cLh(), 10, true);
            } else {
                this.iVh.setVisibility(8);
            }
            i cLj = postData.cLj();
            if (cLj != null && cLj.kgb) {
                this.iVi.setVisibility(0);
            } else {
                this.iVi.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.iUW.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.iUW.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.iVe.setText((CharSequence) null);
            this.cbK.setText((CharSequence) null);
            this.iQX.setVisibility(8);
            if (!this.dwW) {
                c(postData.aCo());
                if (z) {
                    this.iQX.setVisibility(0);
                    am.setViewTextColor(this.iQX, (int) R.color.cp_link_tip_a);
                }
            }
            this.iVf.setText(aq.getFormatTime(postData.getTime()));
            String format = String.format(this.iUX.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.cLa()));
            if (lVar.aAg() != null && lVar.aAg().aEi()) {
                this.iVe.setText((CharSequence) null);
            } else {
                this.iVe.setText(format);
            }
            postData.aCo().getUserTbVipInfoData();
            boolean a = a(this.iVg, postData.cLc());
            if (StringUtils.isNull(postData.cLh()) && !a && postData.aUa() != null) {
                this.NY.setVisibility(0);
                this.NY.setTag(postData.aUa());
                return;
            }
            this.NY.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        String str;
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.byteLength(metaData.getSealPrefix()) + 2 : 0) + ad.getTextLength(name_show) > 14) {
                str = ad.subString(name_show, 0, 14);
                if (str.length() != name_show.length()) {
                    str = str + StringHelper.STRING_MORE;
                }
            } else {
                str = name_show;
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.cbK.setText(cB(metaData.getSealPrefix(), str));
            } else {
                this.cbK.setText(str);
            }
            if (metaData.getAlaUserData() != null && this.iVc != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.iVc.setVisibility(8);
                } else {
                    this.iVc.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.cJR = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.iVc.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.iRe.setVisibility(0);
                this.iVb.setVisibility(8);
                this.iRe.setUserId(metaData.getUserId());
                this.iRe.setUserName(metaData.getUserName());
                this.iRe.startLoad(metaData.getAvater(), 28, false);
                am.setViewTextColor(this.cbK, (int) R.color.cp_cont_r);
            } else {
                this.iRe.setVisibility(8);
                this.iVb.setVisibility(0);
                this.iVb.setUserId(metaData.getUserId());
                this.iVb.setUserName(metaData.getUserName());
                this.iVb.setDefaultResource(R.drawable.transparent_bg);
                this.iVb.setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.iVb.startLoad(metaData.getAvater(), 28, false);
                am.setViewTextColor(this.cbK, (int) R.color.cp_cont_c);
            }
            this.iVa.setTag(R.id.tag_user_id, metaData.getUserId());
            this.iVa.setTag(R.id.tag_user_name, metaData.getUserName());
            this.iVa.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.aTS() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.aTS().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.j(next.aTZ());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.hm(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.cTu());
                        continue;
                    case 17:
                        String str = next.aUd().mGifInfo.mSharpText;
                        if (str == null) {
                            continue;
                        } else if (str.startsWith("#(") && str.endsWith(")")) {
                            tbRichTextData.j("[" + str.substring(2, str.length() - 1) + "]");
                            break;
                        }
                        break;
                }
            }
        }
        if (!tbRichTextData.aUh()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.aTZ() == null || tbRichTextData.aTZ().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.aTZ());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.iUX.getPageContext().getString(R.string.refresh_view_button_text), this.cKZ));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.iUX.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.iUY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds250)), dVar, a);
        }
        this.ekb.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.hPH.aPs();
        am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.iUX.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void wo(int i) {
        b(NoDataViewFactory.d.cA(null, this.iUX.getResources().getString(R.string.refresh_view_title_text)));
        this.iVw.setVisibility(8);
    }

    public void zM(String str) {
        b(NoDataViewFactory.d.cA(str, this.iUX.getPageContext().getString(R.string.refresh_view_title_text)));
        this.iVw.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.ekb.setVisibility(0);
            this.iVw.setVisibility(0);
            this.iUU.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.cKZ = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x028c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PostData postData, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        String userId;
        int i2;
        boolean z4;
        if (postData != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            boolean z5 = false;
            boolean z6 = false;
            if (i != 0) {
                if (i != 3) {
                    z5 = true;
                    z6 = true;
                }
                String userId2 = postData.aCo().getUserId();
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z5 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z5 = false;
                }
            }
            if (this.iTE != null && this.iTE.aAg() != null && this.iTE.aAg().aCo() != null && postData.aCo() != null) {
                String userId3 = this.iTE.aAg().aCo().getUserId();
                String userId4 = postData.aCo().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    userId = postData.aCo().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z3 = true;
                    }
                    if (postData.cLa() == 1) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (!z5) {
                        z4 = true;
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.aCo() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aCo().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aCo().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aCo().getPortrait());
                        }
                    } else {
                        z4 = false;
                        sparseArray.put(R.id.tag_forbid_user_name, "");
                        sparseArray.put(R.id.tag_forbid_user_name_show, "");
                        sparseArray.put(R.id.tag_forbid_user_portrait, "");
                    }
                    if (!z2) {
                        z4 = true;
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_is_self, true);
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(R.id.tag_del_post_is_self, false);
                        sparseArray.put(R.id.tag_del_post_type, 0);
                        sparseArray.put(R.id.tag_del_post_id, "");
                    }
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z4));
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z5) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        if (postData.aCo() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aCo().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aCo().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aCo().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aCo() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aCo().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aCo().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aCo().getName_show());
                        }
                        if (this.iTE.aAg() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.iTE.aAg().getId());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(R.id.tag_should_delete_visible, true);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.getId());
                        return;
                    }
                    sparseArray.put(R.id.tag_should_delete_visible, false);
                    return;
                }
            }
            z = false;
            z2 = z6;
            z3 = false;
            userId = postData.aCo().getUserId();
            if (userId != null) {
                z2 = true;
                z3 = true;
            }
            if (postData.cLa() == 1) {
            }
            if (!z5) {
            }
            if (!z2) {
            }
            sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z4));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (!z5) {
            }
            if (!z) {
            }
            if (!z2) {
            }
        }
    }

    public void qL(boolean z) {
        if (this.iUC != null && this.iUC.cow() != null) {
            if (z) {
                this.iUC.cow().setText(R.string.remove_mark);
            } else {
                this.iUC.cow().setText(R.string.mark);
            }
        }
    }

    public View crw() {
        return this.iVp;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.iUU, R.color.cp_mask_b_alpha66);
        am.setBackgroundColor(this.iUY, R.color.cp_bg_line_d);
        this.iUX.getLayoutMode().setNightMode(i == 1);
        this.iUX.getLayoutMode().onModeChanged(this.iUU);
        this.iUX.getLayoutMode().onModeChanged(this.iUW);
        this.mNavigationBar.onChangeSkinType(this.iUX.getPageContext(), i);
        if (this.iUZ != null) {
            am.setViewTextColor(this.iUZ, (int) R.color.goto_see_subject_color);
        }
        this.gkd.onChangeSkinType(this.iUX.getPageContext(), i);
        this.iUX.getLayoutMode().onModeChanged(this.iVp);
        am.setViewTextColor(this.iVg, (int) R.color.cp_cont_b);
        this.iVg.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        if (this.hPH != null && this.hPH.aOt() != null) {
            this.hPH.aOt().onChangeSkinType(i);
        }
        this.iVk.changeSkin(i);
        this.NY.bHs();
        am.setViewTextColor(this.gDL, (int) R.color.cp_cont_e);
        am.setViewTextColor(this.iQX, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.cbK, (int) R.color.cp_cont_c);
        this.gDL.setAlpha(0.95f);
        if (this.iVl != null) {
            com.baidu.tbadk.q.a.a(this.iUX.getPageContext(), this.iVl);
        }
        if (this.iVB != null) {
            this.iVB.notifyDataSetChanged();
        }
        this.iUX.getLayoutMode().onModeChanged(this.iVn);
    }

    public void crx() {
        this.mProgress.setVisibility(0);
    }

    public void cry() {
        this.ekb.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.iVk.endLoadData();
    }

    public void bBc() {
        this.ekb.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.iVk.bBc();
    }

    public boolean crz() {
        return this.iUU.crz();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.iVB.setLongClickListener(onLongClickListener);
    }

    public View crA() {
        return this.iUW;
    }

    public TextView bIo() {
        return this.gDL;
    }

    public ImageView crB() {
        return this.iVx;
    }

    public ImageView crC() {
        return this.iVy;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void zp(int i) {
    }

    public View crD() {
        return this.iUZ;
    }

    public View crE() {
        return this.iVh;
    }

    public MorePopupWindow crF() {
        return this.iVm;
    }

    public void showLoadingDialog() {
        if (this.fPV == null) {
            this.fPV = new com.baidu.tbadk.core.view.a(this.iUX.getPageContext());
        }
        this.fPV.setDialogVisiable(true);
    }

    public void bqr() {
        if (this.fPV != null) {
            this.fPV.setDialogVisiable(false);
        }
    }

    public TextView crG() {
        return this.iVg;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.iVB.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.iVB != null) {
            this.iVB.notifyDataSetChanged();
        }
    }

    public w crH() {
        return this.iUC;
    }

    public void bKp() {
    }

    public void bKq() {
    }

    public void aiI() {
        this.iUU.onDestroy();
    }

    public void crI() {
        if (this.iUX.isPaused()) {
        }
    }

    public View crJ() {
        return this.iVa;
    }

    private SpannableStringBuilder cB(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.l.a((Context) this.iUX.getActivity(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int crK() {
        if (this.hPH == null || this.hPH.aOt() == null) {
            return 0;
        }
        return this.hPH.aOt().getHeight();
    }

    public void crL() {
        if (this.gDL != null && this.hPH != null) {
            if (this.hPH.aPx()) {
                this.gDL.setText(R.string.draft_to_send);
            } else {
                this.gDL.setText(this.iUX.cpm());
            }
        }
    }
}
