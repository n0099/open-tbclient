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
    private static final int iUR = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener akt;
    private BdTypeListView eka;
    private com.baidu.tbadk.core.view.a fPT;
    private TextView gDJ;
    private e gQh;
    private View gdT;
    private NoNetworkView gkb;
    private l iTC;
    private w iUA;
    private SubPbView iUS;
    private LinearLayout iUT;
    private View iUU;
    private NewSubPbActivity iUV;
    private RelativeLayout iUW;
    private SubPbModel iUx;
    private View iVa;
    private ThreadSkinView iVh;
    private d iVi;
    private View iVj;
    private View iVl;
    private View iVn;
    private BlankView iVo;
    private com.baidu.tbadk.core.dialog.b iVq;
    private ArrayList<PostData> iVt;
    private RelativeLayout iVu;
    private ImageView iVv;
    private ImageView iVw;
    private c iVz;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener cKY = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView iUX = null;
    private LinearLayout iUY = null;
    private HeadImageView iUZ = null;
    private ClickableHeaderImageView iRc = null;
    private TextView cbJ = null;
    private ImageView iVb = null;
    private TextView iQV = null;
    private TextView iVc = null;
    private TextView iVd = null;
    private EllipsizeRichTextView iVe = null;
    private TbImageView iVf = null;
    private PlayVoiceBntNew NY = null;
    private TextView iVg = null;
    private MorePopupWindow iVk = null;
    private com.baidu.tbadk.core.dialog.b iVm = null;
    private Dialog iVp = null;
    private com.baidu.tbadk.core.dialog.a iOf = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a iVr = null;
    private NewSubPbActivity.a iVs = null;
    private h hPF = null;
    private int dOm = 0;
    private int iVx = 2;
    private int iVy = 0;
    private boolean dwV = true;
    private com.baidu.tieba.pb.a.c dqJ = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.a.6
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
    protected AdapterView.OnItemLongClickListener iVA = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.3
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.getItem(a.this.iVt, i);
            if (view != null && view.getTag() != null) {
                if (a.this.iUA == null) {
                    a.this.iUA = new w(a.this.iUV.getPageContext(), a.this.akt);
                }
                a.this.iUA.showDialog();
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
                a.this.iUA.a(sparseArray, a.this.iUx.ckE(), z);
                if (z) {
                    a.this.iUA.cow().setVisibility(0);
                    a.this.iUA.cow().setTag(postData.getId());
                } else {
                    a.this.iUA.cow().setVisibility(8);
                }
                a.this.iUA.cou().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener iVB = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.iUV != null && bc.checkUpIsLogin(a.this.iUV.getPageContext().getPageActivity())) {
                if ((a.this.iUV.hPw == null || a.this.iUx == null || a.this.iUx.bCW() == null || a.this.iUV.hPw.ks(a.this.iUx.bCW().replyPrivateFlag)) && a.this.iUx != null && a.this.hPF != null) {
                    a.this.crp();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.crr();
                        a.this.iUx.crP();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.hPF.setReplyId(str2);
                            a.this.hPF.vs(str);
                        }
                    }
                    a.this.crq();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.iUS = null;
        this.iUU = null;
        this.eka = null;
        this.iUV = null;
        this.gkb = null;
        this.iUW = null;
        this.iVa = null;
        this.iVi = null;
        this.iVn = null;
        this.akt = null;
        this.mProgress = null;
        this.gDJ = null;
        this.iVu = null;
        this.iVv = null;
        this.iVw = null;
        this.iUV = newSubPbActivity;
        this.akt = onClickListener;
        this.iUS = (SubPbView) LayoutInflater.from(this.iUV.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.iUU = LayoutInflater.from(this.iUV.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.iUT = (LinearLayout) this.iUS.findViewById(R.id.navigation_bar_group);
        this.iVu = (RelativeLayout) this.iUS.findViewById(R.id.subpb_editor_tool_comment);
        this.gDJ = (TextView) this.iUS.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.gDJ.setOnClickListener(this.akt);
        this.iVv = (ImageView) this.iUS.findViewById(R.id.subpb_editor_tool_more_img);
        this.iVw = (ImageView) this.iUS.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.iVw.setOnClickListener(this.akt);
        this.iVv.setOnClickListener(this.akt);
        this.gkb = (NoNetworkView) this.iUS.findViewById(R.id.view_no_network);
        bIh();
        bga();
        this.iUW = (RelativeLayout) this.iUS.findViewById(R.id.sub_pb_body_layout);
        this.eka = (BdTypeListView) this.iUS.findViewById(R.id.new_sub_pb_list);
        this.iVh = (ThreadSkinView) LayoutInflater.from(this.iUV.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.eka.addHeaderView(this.iVh);
        this.eka.addHeaderView(this.iUU);
        this.gdT = new TextView(newSubPbActivity.getActivity());
        this.gdT.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.eka.addHeaderView(this.gdT, 0);
        this.iUS.setTopView(this.gdT);
        this.iUS.setNavigationView(this.iUT);
        this.iUS.setListView(this.eka);
        this.iUS.setContentView(this.iUW);
        this.iVi = new d(this.iUV.getPageContext());
        this.iVi.setLineGone();
        this.iVn = this.iVi.getView();
        this.eka.setNextPage(this.iVi);
        this.iVi.setOnClickListener(this.akt);
        this.eka.setOnItemClickListener(this.iVB);
        this.eka.setOnItemLongClickListener(this.iVA);
        this.eka.setOnTouchListener(this.dqJ);
        this.mProgress = (ProgressBar) this.iUS.findViewById(R.id.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.iUU != null) {
            this.iUU.setVisibility(4);
        }
        this.iVa = com.baidu.tbadk.ala.b.ayz().u(this.iUV.getActivity(), 4);
        if (this.iVa != null) {
            this.iVa.setVisibility(8);
            this.iUY.addView(this.iVa, 3);
        }
        this.iVz = new c(this.iUV, this.eka);
        this.iVz.setFromCDN(this.mIsFromCDN);
        this.iVz.y(this.akt);
        this.iVz.wM();
    }

    public ListView getListView() {
        return this.eka;
    }

    public void bga() {
        this.iUY = (LinearLayout) this.iUU.findViewById(R.id.subpb_head_user_info_root);
        this.iUY.setOnClickListener(this.akt);
        this.iUZ = (HeadImageView) this.iUU.findViewById(R.id.photo);
        this.iUZ.setRadius(com.baidu.adp.lib.util.l.getDimens(this.iUV.getActivity(), R.dimen.ds30));
        this.iUZ.setClickable(false);
        this.iRc = (ClickableHeaderImageView) this.iUU.findViewById(R.id.god_user_photo);
        this.iRc.setGodIconMargin(0);
        this.iRc.setGodIconWidth(R.dimen.ds24);
        this.iRc.setRadius(com.baidu.adp.lib.util.l.getDimens(this.iUV.getActivity(), R.dimen.ds30));
        this.iRc.setClickable(false);
        this.cbJ = (TextView) this.iUU.findViewById(R.id.user_name);
        this.iVb = (ImageView) this.iUU.findViewById(R.id.user_rank);
        this.iVb.setVisibility(8);
        this.iQV = (TextView) this.iUU.findViewById(R.id.floor_owner);
        this.iUX = (TextView) this.iUU.findViewById(R.id.see_subject);
        this.iUX.setOnClickListener(this.akt);
        this.iVc = (TextView) this.iUU.findViewById(R.id.floor);
        this.iVd = (TextView) this.iUU.findViewById(R.id.time);
        this.iVe = (EllipsizeRichTextView) this.iUU.findViewById(R.id.content_text);
        this.iVe.setOnClickListener(this.akt);
        am.setViewTextColor(this.iVe, (int) R.color.cp_cont_b);
        this.iVe.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        this.iVe.setLineSpacing(0.0f, 1.25f);
        this.iVf = (TbImageView) this.iUU.findViewById(R.id.sub_pb_image);
        this.iVf.setOnClickListener(this.akt);
        this.iVg = (TextView) this.iUU.findViewById(R.id.advert);
        this.NY = (PlayVoiceBntNew) this.iUU.findViewById(R.id.voice_btn);
        this.iUU.setOnTouchListener(this.dqJ);
        this.iUU.setOnClickListener(this.akt);
    }

    public void a(b.a aVar, boolean z) {
        if (this.iVq != null) {
            this.iVq.dismiss();
            this.iVq = null;
        }
        this.iVq = new com.baidu.tbadk.core.dialog.b(this.iUV.getPageContext().getPageActivity());
        if (z) {
            this.iVq.a(new String[]{this.iUV.getPageContext().getString(R.string.save_to_emotion)}, aVar);
        } else {
            this.iVq.a(new String[]{this.iUV.getPageContext().getString(R.string.save_to_emotion), this.iUV.getPageContext().getString(R.string.save_to_local)}, aVar);
        }
        this.iVq.d(this.iUV.getPageContext());
        this.iVq.aEB();
    }

    public void cE(View view) {
        this.iVj = view;
    }

    public void bIh() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.iUV.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.iUV.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.iUS.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iVo != null) {
                    a.this.iUS.onFinish();
                } else {
                    a.this.iUV.finish();
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
        if (this.iVp == null) {
            this.iVp = new Dialog(this.iUV.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.iVp.setCanceledOnTouchOutside(true);
            this.iVp.setCancelable(true);
            this.iVl = LayoutInflater.from(this.iUV.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.iUV.getLayoutMode().onModeChanged(this.iVl);
            this.iVp.setContentView(this.iVl);
            WindowManager.LayoutParams attributes = this.iVp.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.iUV.getPageContext().getPageActivity()) * 0.9d);
            this.iVp.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.iVp.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.iVp.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.iVp.findViewById(R.id.disable_reply_btn);
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
                    if (a.this.iVp != null && (a.this.iVp instanceof Dialog)) {
                        g.b(a.this.iVp, a.this.iUV.getPageContext());
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
                    if (a.this.iVp != null && (a.this.iVp instanceof Dialog)) {
                        g.b(a.this.iVp, a.this.iUV.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.iVr != null) {
                        a.this.iVr.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
                    if (a.this.iVp != null && (a.this.iVp instanceof Dialog)) {
                        g.b(a.this.iVp, a.this.iUV.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.iUV.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.iVp, this.iUV.getPageContext());
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
        this.iOf = new com.baidu.tbadk.core.dialog.a(this.iUV.getPageContext().getPageActivity());
        this.iOf.jW(i3);
        this.iOf.setYesButtonTag(sparseArray);
        this.iOf.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.iVs != null) {
                    a.this.iVs.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.iOf.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.iOf.fG(true);
        this.iOf.b(this.iUV.getPageContext());
        if (z) {
            this.iOf.aEA();
        } else {
            d(sparseArray);
        }
    }

    private void d(final SparseArray<Object> sparseArray) {
        AntiData bCW;
        if (this.iUV != null && sparseArray != null && this.iUU != null) {
            if (this.gQh == null) {
                this.gQh = new e(this.iUV.getPageContext(), this.iUU);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.iUx != null && (bCW = this.iUx.bCW()) != null && bCW.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bCW.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray2);
            this.gQh.setDefaultReasonArray(new String[]{this.iUV.getString(R.string.delete_thread_reason_1), this.iUV.getString(R.string.delete_thread_reason_2), this.iUV.getString(R.string.delete_thread_reason_3), this.iUV.getString(R.string.delete_thread_reason_4), this.iUV.getString(R.string.delete_thread_reason_5)});
            this.gQh.setData(alVar);
            this.gQh.wm("4");
            this.gQh.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void S(JSONArray jSONArray) {
                    String O = aq.O(jSONArray);
                    if (a.this.iVs != null) {
                        a.this.iVs.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), O});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lR(final boolean z) {
        if (this.eka != null) {
            if (!z) {
                this.eka.setEnabled(z);
            } else {
                this.eka.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.eka.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.iVr = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.iVs = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.iUV.showToast(this.iUV.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.iUV.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.aOr() != null) {
            this.hPF = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.iUW.addView(hVar.aOr(), layoutParams);
            this.hPF.a(new v.a() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                @Override // com.baidu.tieba.tbadkCore.v.a
                public void a(WriteData writeData) {
                    a.this.crJ();
                }
            });
        }
    }

    public void crp() {
        if (this.eka != null) {
            this.iVy = this.eka.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pL(boolean z) {
        if (this.iUx == null || this.iUx.crM() == null) {
            return false;
        }
        if (this.iUx.ckE() != 0) {
            return false;
        }
        return (this.iTC == null || this.iTC.aAe() == null || this.iTC.aAe().aCm() == null || !TextUtils.equals(this.iTC.aAe().aCm().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void crq() {
        if (this.iUx != null) {
            if ((!crt() && this.iVn != null && this.iVn.isShown()) || com.baidu.tbadk.core.util.v.isEmpty(this.iVt)) {
                this.iUx.qN(false);
            } else {
                this.iUx.qN(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.iUx = subPbModel;
    }

    public void qK(boolean z) {
        if (this.iUx != null && this.iUx.crn() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.iVo = new BlankView(this.iUV.getPageContext().getPageActivity());
            this.iUT.addView(this.iVo, 0, new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.iVo.setVisibility(0);
            this.iVo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.iUV.finish();
                }
            });
            this.iUS.setBlankView(this.iVo);
        }
    }

    public void crr() {
        b(this.iUV);
        this.eka.setNextPage(this.iVi);
    }

    public void r(PostData postData) {
        int i;
        if (postData != null) {
            postData.sN(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!crt() && this.iVn != null && this.iVn.isShown()) {
                i = (this.iVy - this.iVx) - 1;
            } else {
                i = this.iVy - this.iVx;
            }
            int count = com.baidu.tbadk.core.util.v.getCount(this.iVt);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(com.baidu.tbadk.core.util.v.subList(this.iVt, 0, i));
            com.baidu.tbadk.core.util.v.add(arrayList, postData2);
            com.baidu.tbadk.core.util.v.add(arrayList, postData);
            this.eka.smoothScrollToPosition(this.iVy + 2);
            this.eka.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.eka.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.eka.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.iUS;
    }

    public void cpW() {
        if (this.iVk != null) {
            g.dismissPopupWindow(this.iVk, this.iUV.getPageContext().getPageActivity());
        }
        if (this.iVm != null) {
            this.iVm.dismiss();
        }
        if (this.iOf != null) {
            this.iOf.dismiss();
        }
        if (this.iVp != null) {
            g.b(this.iVp, this.iUV.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.iUA != null) {
            this.iUA.dismiss();
        }
    }

    public void crs() {
        this.eka.setNextPage(this.iVi);
        this.iVi.startLoadData();
    }

    public void setIsFromPb(boolean z) {
        this.dwV = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v35, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(l lVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (lVar != null) {
            if (this.dwV && this.iUU != null) {
                this.iUU.setVisibility(8);
                this.eka.removeHeaderView(this.iUU);
                this.iVx = 1;
            }
            this.iTC = lVar;
            if (this.iUU != null) {
                this.iUU.setVisibility(0);
            }
            if (lVar.aAe() != null && lVar.aAe().aEg()) {
                this.iUX.setText(R.string.view_original);
            } else {
                this.iUX.setText(R.string.view_subject);
            }
            if (lVar.cld() != null) {
                this.dOm = lVar.cld().cKY();
                if (this.dOm > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.iUV.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.dOm)));
                    if (this.iUV != null) {
                        this.gDJ.setText(this.iUV.cpk());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.iUV.getResources().getString(R.string.local_floor_reply));
                }
                String str = this.iUV.crn() ? "PB" : null;
                if (lVar.cld().aCH() != null) {
                    this.iVh.setData(this.iUV.getPageContext(), lVar.cld().aCH(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", lVar.aPk().getId(), lVar.aPk().getName(), lVar.aAe().getId(), str));
                } else {
                    this.iVh.setData(null, null, null);
                }
            }
            if (lVar.hasMore()) {
                this.iVi.startLoadData();
                this.iVz.setHasMoreData(true);
            } else {
                this.iVi.endLoadData();
                this.iVz.setHasMoreData(false);
            }
            this.iVt = lVar.clh();
            if (this.iVt == null || this.iVt.size() <= iUR) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.iVt.size() - iUR;
                zo(size);
                int firstVisiblePosition = this.eka.getFirstVisiblePosition() - size;
                View childAt = this.eka.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.iVt);
            if (com.baidu.tbadk.core.util.v.isEmpty(this.iVt)) {
                this.eka.setNextPage(null);
                if (this.dwV) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.eka.setNextPage(this.iVi);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(lVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.dwV) {
                arrayList.add(0, lVar.cld());
            }
            this.iVz.b(this.iTC.aAe(), arrayList);
            a(lVar, lVar.cld(), lVar.bXs(), lVar.ayJ(), i, z);
            if (i4 > 0) {
                this.eka.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void zo(int i) {
        if (this.iVt != null) {
            if (this.iVt.size() <= i) {
                this.iVt.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.iVt.iterator();
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

    public boolean crt() {
        return this.iVz.abY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.dwV) {
            if (!StringUtils.isNull(postData.cLf())) {
                this.iVf.setVisibility(0);
                this.iVf.startLoad(postData.cLf(), 10, true);
            } else {
                this.iVf.setVisibility(8);
            }
            i cLh = postData.cLh();
            if (cLh != null && cLh.kfZ) {
                this.iVg.setVisibility(0);
            } else {
                this.iVg.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.iUU.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.iUU.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.iVc.setText((CharSequence) null);
            this.cbJ.setText((CharSequence) null);
            this.iQV.setVisibility(8);
            if (!this.dwV) {
                c(postData.aCm());
                if (z) {
                    this.iQV.setVisibility(0);
                    am.setViewTextColor(this.iQV, (int) R.color.cp_link_tip_a);
                }
            }
            this.iVd.setText(aq.getFormatTime(postData.getTime()));
            String format = String.format(this.iUV.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.cKY()));
            if (lVar.aAe() != null && lVar.aAe().aEg()) {
                this.iVc.setText((CharSequence) null);
            } else {
                this.iVc.setText(format);
            }
            postData.aCm().getUserTbVipInfoData();
            boolean a = a(this.iVe, postData.cLa());
            if (StringUtils.isNull(postData.cLf()) && !a && postData.aTY() != null) {
                this.NY.setVisibility(0);
                this.NY.setTag(postData.aTY());
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
                this.cbJ.setText(cB(metaData.getSealPrefix(), str));
            } else {
                this.cbJ.setText(str);
            }
            if (metaData.getAlaUserData() != null && this.iVa != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.iVa.setVisibility(8);
                } else {
                    this.iVa.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.cJQ = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.iVa.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.iRc.setVisibility(0);
                this.iUZ.setVisibility(8);
                this.iRc.setUserId(metaData.getUserId());
                this.iRc.setUserName(metaData.getUserName());
                this.iRc.startLoad(metaData.getAvater(), 28, false);
                am.setViewTextColor(this.cbJ, (int) R.color.cp_cont_r);
            } else {
                this.iRc.setVisibility(8);
                this.iUZ.setVisibility(0);
                this.iUZ.setUserId(metaData.getUserId());
                this.iUZ.setUserName(metaData.getUserName());
                this.iUZ.setDefaultResource(R.drawable.transparent_bg);
                this.iUZ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.iUZ.startLoad(metaData.getAvater(), 28, false);
                am.setViewTextColor(this.cbJ, (int) R.color.cp_cont_c);
            }
            this.iUY.setTag(R.id.tag_user_id, metaData.getUserId());
            this.iUY.setTag(R.id.tag_user_name, metaData.getUserName());
            this.iUY.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.aTQ() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.aTQ().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.j(next.aTX());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.hm(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.cTs());
                        continue;
                    case 17:
                        String str = next.aUb().mGifInfo.mSharpText;
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
        if (!tbRichTextData.aUf()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.aTX() == null || tbRichTextData.aTX().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.aTX());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.iUV.getPageContext().getString(R.string.refresh_view_button_text), this.cKY));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.iUV.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.iUW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds250)), dVar, a);
        }
        this.eka.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.hPF.aPq();
        am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.iUV.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void wo(int i) {
        b(NoDataViewFactory.d.cA(null, this.iUV.getResources().getString(R.string.refresh_view_title_text)));
        this.iVu.setVisibility(8);
    }

    public void zM(String str) {
        b(NoDataViewFactory.d.cA(str, this.iUV.getPageContext().getString(R.string.refresh_view_title_text)));
        this.iVu.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.eka.setVisibility(0);
            this.iVu.setVisibility(0);
            this.iUS.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.cKY = onClickListener;
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
                String userId2 = postData.aCm().getUserId();
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z5 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z5 = false;
                }
            }
            if (this.iTC != null && this.iTC.aAe() != null && this.iTC.aAe().aCm() != null && postData.aCm() != null) {
                String userId3 = this.iTC.aAe().aCm().getUserId();
                String userId4 = postData.aCm().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    userId = postData.aCm().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z3 = true;
                    }
                    if (postData.cKY() == 1) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (!z5) {
                        z4 = true;
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.aCm() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aCm().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aCm().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aCm().getPortrait());
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
                        if (postData.aCm() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aCm().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aCm().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aCm().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aCm() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aCm().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aCm().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aCm().getName_show());
                        }
                        if (this.iTC.aAe() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.iTC.aAe().getId());
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
            userId = postData.aCm().getUserId();
            if (userId != null) {
                z2 = true;
                z3 = true;
            }
            if (postData.cKY() == 1) {
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
        if (this.iUA != null && this.iUA.cou() != null) {
            if (z) {
                this.iUA.cou().setText(R.string.remove_mark);
            } else {
                this.iUA.cou().setText(R.string.mark);
            }
        }
    }

    public View cru() {
        return this.iVn;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.iUS, R.color.cp_mask_b_alpha66);
        am.setBackgroundColor(this.iUW, R.color.cp_bg_line_d);
        this.iUV.getLayoutMode().setNightMode(i == 1);
        this.iUV.getLayoutMode().onModeChanged(this.iUS);
        this.iUV.getLayoutMode().onModeChanged(this.iUU);
        this.mNavigationBar.onChangeSkinType(this.iUV.getPageContext(), i);
        if (this.iUX != null) {
            am.setViewTextColor(this.iUX, (int) R.color.goto_see_subject_color);
        }
        this.gkb.onChangeSkinType(this.iUV.getPageContext(), i);
        this.iUV.getLayoutMode().onModeChanged(this.iVn);
        am.setViewTextColor(this.iVe, (int) R.color.cp_cont_b);
        this.iVe.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        if (this.hPF != null && this.hPF.aOr() != null) {
            this.hPF.aOr().onChangeSkinType(i);
        }
        this.iVi.changeSkin(i);
        this.NY.bHq();
        am.setViewTextColor(this.gDJ, (int) R.color.cp_cont_e);
        am.setViewTextColor(this.iQV, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.cbJ, (int) R.color.cp_cont_c);
        this.gDJ.setAlpha(0.95f);
        if (this.iVj != null) {
            com.baidu.tbadk.q.a.a(this.iUV.getPageContext(), this.iVj);
        }
        if (this.iVz != null) {
            this.iVz.notifyDataSetChanged();
        }
        this.iUV.getLayoutMode().onModeChanged(this.iVl);
    }

    public void crv() {
        this.mProgress.setVisibility(0);
    }

    public void crw() {
        this.eka.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.iVi.endLoadData();
    }

    public void bBa() {
        this.eka.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.iVi.bBa();
    }

    public boolean crx() {
        return this.iUS.crx();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.iVz.setLongClickListener(onLongClickListener);
    }

    public View cry() {
        return this.iUU;
    }

    public TextView bIm() {
        return this.gDJ;
    }

    public ImageView crz() {
        return this.iVv;
    }

    public ImageView crA() {
        return this.iVw;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void zp(int i) {
    }

    public View crB() {
        return this.iUX;
    }

    public View crC() {
        return this.iVf;
    }

    public MorePopupWindow crD() {
        return this.iVk;
    }

    public void showLoadingDialog() {
        if (this.fPT == null) {
            this.fPT = new com.baidu.tbadk.core.view.a(this.iUV.getPageContext());
        }
        this.fPT.setDialogVisiable(true);
    }

    public void bqp() {
        if (this.fPT != null) {
            this.fPT.setDialogVisiable(false);
        }
    }

    public TextView crE() {
        return this.iVe;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.iVz.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.iVz != null) {
            this.iVz.notifyDataSetChanged();
        }
    }

    public w crF() {
        return this.iUA;
    }

    public void bKn() {
    }

    public void bKo() {
    }

    public void aiG() {
        this.iUS.onDestroy();
    }

    public void crG() {
        if (this.iUV.isPaused()) {
        }
    }

    public View crH() {
        return this.iUY;
    }

    private SpannableStringBuilder cB(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.l.a((Context) this.iUV.getActivity(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int crI() {
        if (this.hPF == null || this.hPF.aOr() == null) {
            return 0;
        }
        return this.hPF.aOr().getHeight();
    }

    public void crJ() {
        if (this.gDJ != null && this.hPF != null) {
            if (this.hPF.aPv()) {
                this.gDJ.setText(R.string.draft_to_send);
            } else {
                this.gDJ.setText(this.iUV.cpk());
            }
        }
    }
}
