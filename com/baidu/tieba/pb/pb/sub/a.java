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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.h;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.pb.main.ad;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.b;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.i;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class a implements KeyboardEventLayout.a {
    private static final int ktA = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener aLl;
    private NoNetworkView eDk;
    private LinearLayout eDl;
    private BdTypeListView fml;
    private com.baidu.tbadk.core.view.a gXx;
    private TextView hRg;
    private View hpn;
    private e ieU;
    private n kse;
    private SubPbView ktB;
    private View ktC;
    private NewSubPbActivity ktD;
    private RelativeLayout ktE;
    private View ktI;
    private ThreadSkinView ktP;
    private d ktQ;
    private View ktR;
    private View ktT;
    private View ktV;
    private BlankView ktW;
    private com.baidu.tbadk.core.dialog.b ktY;
    private SubPbModel ktd;
    private ad ktg;
    private ArrayList<PostData> kub;
    private RelativeLayout kuc;
    private ImageView kud;
    private ImageView kue;
    private c kuh;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener dDD = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView ktF = null;
    private LinearLayout ktG = null;
    private HeadImageView ktH = null;
    private TextView dEL = null;
    private ImageView ktJ = null;
    private TextView kps = null;
    private TextView ktK = null;
    private TextView ktL = null;
    private EllipsizeRichTextView ktM = null;
    private TbImageView ktN = null;
    private PlayVoiceBntNew aiw = null;
    private TextView ktO = null;
    private MorePopupWindow ktS = null;
    private com.baidu.tbadk.core.dialog.b ktU = null;
    private Dialog ktX = null;
    private com.baidu.tbadk.core.dialog.a kmw = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a ktZ = null;
    private NewSubPbActivity.a kua = null;
    private h jhW = null;
    private int eNM = 0;
    private int kuf = 2;
    private int kug = 0;
    private boolean eud = true;
    private com.baidu.tieba.pb.a.c eor = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.a.6
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.nH(false);
            a.this.nH(true);
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
    protected AdapterView.OnItemLongClickListener kui = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.3
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) w.getItem(a.this.kub, i);
            if (view != null && view.getTag() != null) {
                if (a.this.ktg == null) {
                    a.this.ktg = new ad(a.this.ktD.getPageContext(), a.this.aLl);
                }
                a.this.ktg.showDialog();
                SparseArray<Object> sparseArray = null;
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
                if (sparseArray == null) {
                    return true;
                }
                boolean z = a.this.rH(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                a.this.ktg.a(sparseArray, a.this.ktd.cHd(), z);
                if (z) {
                    a.this.ktg.cLb().setVisibility(0);
                    a.this.ktg.cLb().setTag(postData.getId());
                } else {
                    a.this.ktg.cLb().setVisibility(8);
                }
                a.this.ktg.cKZ().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener kuj = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.ktD != null && be.checkUpIsLogin(a.this.ktD.getPageContext().getPageActivity())) {
                if ((a.this.ktD.jhL == null || a.this.ktd == null || a.this.ktd.bXe() == null || a.this.ktD.jhL.lp(a.this.ktd.bXe().replyPrivateFlag)) && a.this.ktd != null && a.this.jhW != null) {
                    a.this.cNW();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.cNY();
                        a.this.ktd.cOx();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.jhW.setReplyId(str2);
                            a.this.jhW.yJ(str);
                        }
                    }
                    a.this.cNX();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.ktB = null;
        this.ktC = null;
        this.fml = null;
        this.ktD = null;
        this.eDk = null;
        this.ktE = null;
        this.ktI = null;
        this.ktQ = null;
        this.ktV = null;
        this.aLl = null;
        this.mProgress = null;
        this.hRg = null;
        this.kuc = null;
        this.kud = null;
        this.kue = null;
        this.ktD = newSubPbActivity;
        this.aLl = onClickListener;
        this.ktB = (SubPbView) LayoutInflater.from(this.ktD.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.ktC = LayoutInflater.from(this.ktD.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.eDl = (LinearLayout) this.ktB.findViewById(R.id.navigation_bar_group);
        this.kuc = (RelativeLayout) this.ktB.findViewById(R.id.subpb_editor_tool_comment);
        this.hRg = (TextView) this.ktB.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.hRg.setOnClickListener(this.aLl);
        this.kud = (ImageView) this.ktB.findViewById(R.id.subpb_editor_tool_more_img);
        this.kue = (ImageView) this.ktB.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.kue.setOnClickListener(this.aLl);
        this.kud.setOnClickListener(this.aLl);
        this.eDk = (NoNetworkView) this.ktB.findViewById(R.id.view_no_network);
        ccL();
        bym();
        this.ktE = (RelativeLayout) this.ktB.findViewById(R.id.sub_pb_body_layout);
        this.fml = (BdTypeListView) this.ktB.findViewById(R.id.new_sub_pb_list);
        this.ktP = (ThreadSkinView) LayoutInflater.from(this.ktD.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.fml.addHeaderView(this.ktP);
        this.fml.addHeaderView(this.ktC);
        this.hpn = new TextView(newSubPbActivity.getActivity());
        this.hpn.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.fml.addHeaderView(this.hpn, 0);
        this.ktB.setTopView(this.hpn);
        this.ktB.setNavigationView(this.eDl);
        this.ktB.setListView(this.fml);
        this.ktB.setContentView(this.ktE);
        this.ktQ = new d(this.ktD.getPageContext());
        this.ktQ.setLineGone();
        this.ktV = this.ktQ.getView();
        this.fml.setNextPage(this.ktQ);
        this.ktQ.setOnClickListener(this.aLl);
        this.fml.setOnItemClickListener(this.kuj);
        this.fml.setOnItemLongClickListener(this.kui);
        this.fml.setOnTouchListener(this.eor);
        this.mProgress = (ProgressBar) this.ktB.findViewById(R.id.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.ktC != null) {
            this.ktC.setVisibility(4);
        }
        this.ktI = com.baidu.tbadk.ala.b.aOf().p(this.ktD.getActivity(), 4);
        if (this.ktI != null) {
            this.ktI.setVisibility(8);
            this.ktG.addView(this.ktI, 3);
        }
        this.kuh = new c(this.ktD, this.fml);
        this.kuh.setFromCDN(this.mIsFromCDN);
        this.kuh.z(this.aLl);
        this.kuh.Dz();
    }

    public ListView getListView() {
        return this.fml;
    }

    public void bym() {
        this.ktG = (LinearLayout) this.ktC.findViewById(R.id.subpb_head_user_info_root);
        this.ktG.setOnClickListener(this.aLl);
        this.ktH = (HeadImageView) this.ktC.findViewById(R.id.photo);
        this.ktH.setRadius(l.getDimens(this.ktD.getActivity(), R.dimen.tbds45));
        this.ktH.setClickable(false);
        this.dEL = (TextView) this.ktC.findViewById(R.id.user_name);
        this.ktJ = (ImageView) this.ktC.findViewById(R.id.user_rank);
        this.ktJ.setVisibility(8);
        this.kps = (TextView) this.ktC.findViewById(R.id.floor_owner);
        this.ktF = (TextView) this.ktC.findViewById(R.id.see_subject);
        this.ktF.setOnClickListener(this.aLl);
        this.ktK = (TextView) this.ktC.findViewById(R.id.floor);
        this.ktL = (TextView) this.ktC.findViewById(R.id.time);
        this.ktM = (EllipsizeRichTextView) this.ktC.findViewById(R.id.content_text);
        this.ktM.setOnClickListener(this.aLl);
        an.setViewTextColor(this.ktM, (int) R.color.cp_cont_b);
        this.ktM.setLinkTextColor(an.getColor(R.color.cp_link_tip_c));
        this.ktM.setLineSpacing(0.0f, 1.25f);
        this.ktN = (TbImageView) this.ktC.findViewById(R.id.sub_pb_image);
        this.ktN.setOnClickListener(this.aLl);
        this.ktO = (TextView) this.ktC.findViewById(R.id.advert);
        this.aiw = (PlayVoiceBntNew) this.ktC.findViewById(R.id.voice_btn);
        this.ktC.setOnTouchListener(this.eor);
        this.ktC.setOnClickListener(this.aLl);
    }

    public void a(b.a aVar, boolean z) {
        if (this.ktY != null) {
            this.ktY.dismiss();
            this.ktY = null;
        }
        this.ktY = new com.baidu.tbadk.core.dialog.b(this.ktD.getPageContext().getPageActivity());
        if (z) {
            this.ktY.a(new String[]{this.ktD.getPageContext().getString(R.string.save_to_emotion)}, aVar);
        } else {
            this.ktY.a(new String[]{this.ktD.getPageContext().getString(R.string.save_to_emotion), this.ktD.getPageContext().getString(R.string.save_to_local)}, aVar);
        }
        this.ktY.d(this.ktD.getPageContext());
        this.ktY.aUO();
    }

    public void cO(View view) {
        this.ktR = view;
    }

    public void ccL() {
        int dimens = l.getDimens(this.ktD.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = l.getDimens(this.ktD.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.ktB.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ktW != null) {
                    a.this.ktB.onFinish();
                } else {
                    a.this.ktD.finish();
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

    public void cJ(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.ktX == null) {
            this.ktX = new Dialog(this.ktD.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.ktX.setCanceledOnTouchOutside(true);
            this.ktX.setCancelable(true);
            this.ktT = LayoutInflater.from(this.ktD.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.ktD.getLayoutMode().onModeChanged(this.ktT);
            this.ktX.setContentView(this.ktT);
            WindowManager.LayoutParams attributes = this.ktX.getWindow().getAttributes();
            attributes.width = (int) (l.getEquipmentWidth(this.ktD.getPageContext().getPageActivity()) * 0.9d);
            this.ktX.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.ktX.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.ktX.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.ktX.findViewById(R.id.disable_reply_btn);
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
                    if (a.this.ktX != null && (a.this.ktX instanceof Dialog)) {
                        g.b(a.this.ktX, a.this.ktD.getPageContext());
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
                    if (a.this.ktX != null && (a.this.ktX instanceof Dialog)) {
                        g.b(a.this.ktX, a.this.ktD.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.ktZ != null) {
                        a.this.ktZ.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
                    if (a.this.ktX != null && (a.this.ktX instanceof Dialog)) {
                        g.b(a.this.ktX, a.this.ktD.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.ktD.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.ktX, this.ktD.getPageContext());
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
        this.kmw = new com.baidu.tbadk.core.dialog.a(this.ktD.getPageContext().getPageActivity());
        this.kmw.kT(i3);
        this.kmw.setYesButtonTag(sparseArray);
        this.kmw.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.kua != null) {
                    a.this.kua.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.kmw.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kmw.hf(true);
        this.kmw.b(this.ktD.getPageContext());
        if (z) {
            this.kmw.aUN();
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData bXe;
        if (this.ktD != null && sparseArray != null && this.ktC != null) {
            if (this.ieU == null) {
                this.ieU = new e(this.ktD.getPageContext(), this.ktC);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.ktd != null && (bXe = this.ktd.bXe()) != null && bXe.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bXe.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            ap apVar = new ap();
            apVar.setFeedBackReasonMap(sparseArray2);
            this.ieU.setDefaultReasonArray(new String[]{this.ktD.getString(R.string.delete_thread_reason_1), this.ktD.getString(R.string.delete_thread_reason_2), this.ktD.getString(R.string.delete_thread_reason_3), this.ktD.getString(R.string.delete_thread_reason_4), this.ktD.getString(R.string.delete_thread_reason_5)});
            this.ieU.setData(apVar);
            this.ieU.zC("4");
            this.ieU.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void T(JSONArray jSONArray) {
                    String O = ar.O(jSONArray);
                    if (a.this.kua != null) {
                        a.this.kua.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), O});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nH(final boolean z) {
        if (this.fml != null) {
            if (!z) {
                this.fml.setEnabled(z);
            } else {
                this.fml.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.fml.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.ktZ = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.kua = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.ktD.showToast(this.ktD.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.ktD.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.bfa() != null) {
            this.jhW = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.ktE.addView(hVar.bfa(), layoutParams);
            this.jhW.a(new w.a() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                @Override // com.baidu.tieba.tbadkCore.w.a
                public void a(WriteData writeData) {
                    a.this.cOr();
                }
            });
        }
    }

    public void cNW() {
        if (this.fml != null) {
            this.kug = this.fml.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rH(boolean z) {
        if (this.ktd == null || this.ktd.cOu() == null) {
            return false;
        }
        if (this.ktd.cHd() != 0) {
            return false;
        }
        return (this.kse == null || this.kse.aPS() == null || this.kse.aPS().aSp() == null || !TextUtils.equals(this.kse.aPS().aSp().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void cNX() {
        if (this.ktd != null) {
            if ((!cOa() && this.ktV != null && this.ktV.isShown()) || com.baidu.tbadk.core.util.w.isEmpty(this.kub)) {
                this.ktd.sJ(false);
            } else {
                this.ktd.sJ(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.ktd = subPbModel;
    }

    public void sG(boolean z) {
        if (this.ktd != null && this.ktd.cNU() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.ktW = new BlankView(this.ktD.getPageContext().getPageActivity());
            this.eDl.addView(this.ktW, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.ktW.setVisibility(0);
            this.ktW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ktD.finish();
                }
            });
            this.ktB.setBlankView(this.ktW);
        }
    }

    public void cNY() {
        b(this.ktD);
        this.fml.setNextPage(this.ktQ);
    }

    public void u(PostData postData) {
        int i;
        if (postData != null) {
            postData.uI(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!cOa() && this.ktV != null && this.ktV.isShown()) {
                i = (this.kug - this.kuf) - 1;
            } else {
                i = this.kug - this.kuf;
            }
            int count = com.baidu.tbadk.core.util.w.getCount(this.kub);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(com.baidu.tbadk.core.util.w.subList(this.kub, 0, i));
            com.baidu.tbadk.core.util.w.add(arrayList, postData2);
            com.baidu.tbadk.core.util.w.add(arrayList, postData);
            this.fml.smoothScrollToPosition(this.kug + 2);
            this.fml.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fml.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.fml.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.ktB;
    }

    public void cMC() {
        if (this.ktS != null) {
            g.dismissPopupWindow(this.ktS, this.ktD.getPageContext().getPageActivity());
        }
        if (this.ktU != null) {
            this.ktU.dismiss();
        }
        if (this.kmw != null) {
            this.kmw.dismiss();
        }
        if (this.ktX != null) {
            g.b(this.ktX, this.ktD.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.ktg != null) {
            this.ktg.dismiss();
        }
    }

    public void cNZ() {
        this.fml.setNextPage(this.ktQ);
        this.ktQ.startLoadData();
    }

    public void setIsFromPb(boolean z) {
        this.eud = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v37, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(n nVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (nVar != null) {
            if (this.eud && this.ktC != null) {
                this.ktC.setVisibility(8);
                this.fml.removeHeaderView(this.ktC);
                this.kuf = 1;
            }
            this.kse = nVar;
            if (this.kse.cHJ() != null) {
                this.kse.cHJ().lGK = true;
            }
            if (this.ktC != null) {
                this.ktC.setVisibility(0);
            }
            if (nVar.aPS() != null && nVar.aPS().aQZ()) {
                this.ktF.setText(R.string.view_original);
            } else {
                this.ktF.setText(R.string.view_subject);
            }
            if (nVar.cHJ() != null) {
                this.eNM = nVar.cHJ().dhZ();
                if (this.eNM > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.ktD.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.eNM)));
                    if (this.ktD != null) {
                        this.hRg.setText(this.ktD.cLQ());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.ktD.getResources().getString(R.string.local_floor_reply));
                }
                String str = this.ktD.cNU() ? "PB" : null;
                if (nVar.cHJ().aSL() != null) {
                    this.ktP.setData(this.ktD.getPageContext(), nVar.cHJ().aSL(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", nVar.bfV().getId(), nVar.bfV().getName(), nVar.aPS().getId(), str));
                } else {
                    this.ktP.setData(null, null, null);
                }
            }
            if (nVar.hasMore()) {
                this.ktQ.startLoadData();
                this.kuh.setHasMoreData(true);
            } else {
                this.ktQ.endLoadData();
                this.kuh.setHasMoreData(false);
            }
            this.kub = nVar.cHN();
            if (this.kub == null || this.kub.size() <= ktA) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.kub.size() - ktA;
                BM(size);
                int firstVisiblePosition = this.fml.getFirstVisiblePosition() - size;
                View childAt = this.fml.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.kub);
            if (com.baidu.tbadk.core.util.w.isEmpty(this.kub)) {
                this.fml.setNextPage(null);
                if (this.eud) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.fml.setNextPage(this.ktQ);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(nVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.eud) {
                arrayList.add(0, nVar.cHJ());
            }
            this.kuh.b(this.kse.aPS(), arrayList);
            a(nVar, nVar.cHJ(), nVar.csJ(), nVar.aOo(), i, z);
            if (i4 > 0) {
                this.fml.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void BM(int i) {
        if (this.kub != null) {
            if (this.kub.size() <= i) {
                this.kub.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.kub.iterator();
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

    public boolean cOa() {
        return this.kuh.apb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(n nVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.eud) {
            if (!StringUtils.isNull(postData.dig())) {
                this.ktN.setVisibility(0);
                this.ktN.startLoad(postData.dig(), 10, true);
            } else {
                this.ktN.setVisibility(8);
            }
            i dii = postData.dii();
            if (dii != null && dii.lFt) {
                this.ktO.setVisibility(0);
            } else {
                this.ktO.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.ktC.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.ktC.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.ktK.setText((CharSequence) null);
            this.dEL.setText((CharSequence) null);
            this.kps.setVisibility(8);
            if (!this.eud) {
                c(postData.aSp());
                if (z) {
                    this.kps.setVisibility(0);
                    an.setViewTextColor(this.kps, (int) R.color.cp_link_tip_a);
                }
            }
            this.ktL.setText(ar.getFormatTime(postData.getTime()));
            String format = String.format(this.ktD.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.dhZ()));
            if (nVar.aPS() != null && nVar.aPS().aQZ()) {
                this.ktK.setText((CharSequence) null);
            } else {
                this.ktK.setText(format);
            }
            postData.aSp().getUserTbVipInfoData();
            boolean a = a(this.ktM, postData.dib());
            if (StringUtils.isNull(postData.dig()) && !a && postData.bkX() != null) {
                this.aiw.setVisibility(0);
                this.aiw.setTag(postData.bkX());
                return;
            }
            this.aiw.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        String str;
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.byteLength(metaData.getSealPrefix()) + 2 : 0) + ae.getTextLength(name_show) > 14) {
                str = ae.subString(name_show, 0, 14);
                if (str.length() != name_show.length()) {
                    str = str + StringHelper.STRING_MORE;
                }
            } else {
                str = name_show;
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.dEL.setText(dn(metaData.getSealPrefix(), str));
            } else {
                this.dEL.setText(str);
            }
            if (metaData.getAlaUserData() != null && this.ktI != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.ktI.setVisibility(8);
                } else {
                    this.ktI.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.dCt = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.ktI.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                an.setViewTextColor(this.dEL, (int) R.color.cp_cont_r);
            } else {
                an.setViewTextColor(this.dEL, (int) R.color.cp_cont_c);
            }
            this.ktH.setVisibility(0);
            this.ktH.setUserId(metaData.getUserId());
            this.ktH.setUserName(metaData.getUserName());
            this.ktH.setDefaultResource(R.drawable.transparent_bg);
            UtilHelper.showHeadImageViewBigV(this.ktH, metaData);
            this.ktH.startLoad(metaData.getAvater(), 28, false);
            this.ktG.setTag(R.id.tag_user_id, metaData.getUserId());
            this.ktG.setTag(R.id.tag_user_name, metaData.getUserName());
            this.ktG.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.bkP() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.bkP().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.n(next.bkW());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.iU(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.dqu());
                        continue;
                    case 17:
                        String str = next.bla().mGifInfo.mSharpText;
                        if (str == null) {
                            continue;
                        } else if (str.startsWith("#(") && str.endsWith(")")) {
                            tbRichTextData.n("[" + str.substring(2, str.length() - 1) + "]");
                            break;
                        }
                        break;
                }
            }
        }
        if (!tbRichTextData.blf()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.bkW() == null || tbRichTextData.bkW().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.bkW());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.ktD.getPageContext().getString(R.string.refresh_view_button_text), this.dDD));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.ktD.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.ktE, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, l.getDimens(pageActivity, R.dimen.ds250)), dVar, a);
        }
        this.fml.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.jhW.bgb();
        an.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.ktD.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void ym(int i) {
        b(NoDataViewFactory.d.dm(null, this.ktD.getResources().getString(R.string.refresh_view_title_text)));
        this.kuc.setVisibility(8);
    }

    public void DI(String str) {
        b(NoDataViewFactory.d.dm(str, this.ktD.getPageContext().getString(R.string.refresh_view_title_text)));
        this.kuc.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.fml.setVisibility(0);
            this.kuc.setVisibility(0);
            this.ktB.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.dDD = onClickListener;
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
                String userId2 = postData.aSp().getUserId();
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z5 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z5 = false;
                }
            }
            if (this.kse != null && this.kse.aPS() != null && this.kse.aPS().aSp() != null && postData.aSp() != null) {
                String userId3 = this.kse.aPS().aSp().getUserId();
                String userId4 = postData.aSp().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    userId = postData.aSp().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z3 = true;
                    }
                    if (postData.dhZ() == 1) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (!z5) {
                        z4 = true;
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.aSp() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aSp().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aSp().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aSp().getPortrait());
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
                        if (postData.aSp() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aSp().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aSp().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aSp().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aSp() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aSp().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aSp().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aSp().getName_show());
                        }
                        if (this.kse.aPS() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.kse.aPS().getId());
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
            userId = postData.aSp().getUserId();
            if (userId != null) {
                z2 = true;
                z3 = true;
            }
            if (postData.dhZ() == 1) {
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

    public void sH(boolean z) {
        if (this.ktg != null && this.ktg.cKZ() != null) {
            if (z) {
                this.ktg.cKZ().setText(R.string.remove_mark);
            } else {
                this.ktg.cKZ().setText(R.string.mark);
            }
        }
    }

    public View cOb() {
        return this.ktV;
    }

    public void onChangeSkinType(int i) {
        an.setBackgroundColor(this.ktB, R.color.cp_mask_b_alpha66);
        an.setBackgroundColor(this.ktE, R.color.cp_bg_line_d);
        this.ktD.getLayoutMode().setNightMode(i == 1);
        this.ktD.getLayoutMode().onModeChanged(this.ktB);
        this.ktD.getLayoutMode().onModeChanged(this.ktC);
        this.mNavigationBar.onChangeSkinType(this.ktD.getPageContext(), i);
        if (this.ktF != null) {
            an.setViewTextColor(this.ktF, (int) R.color.goto_see_subject_color);
        }
        this.eDk.onChangeSkinType(this.ktD.getPageContext(), i);
        this.ktD.getLayoutMode().onModeChanged(this.ktV);
        an.setViewTextColor(this.ktM, (int) R.color.cp_cont_b);
        this.ktM.setLinkTextColor(an.getColor(R.color.cp_link_tip_c));
        if (this.jhW != null && this.jhW.bfa() != null) {
            this.jhW.bfa().onChangeSkinType(i);
        }
        this.ktQ.changeSkin(i);
        this.aiw.aYi();
        an.setViewTextColor(this.hRg, (int) R.color.cp_cont_e);
        an.setViewTextColor(this.kps, (int) R.color.cp_link_tip_a);
        an.setViewTextColor(this.dEL, (int) R.color.cp_cont_c);
        this.hRg.setAlpha(0.95f);
        if (this.ktR != null) {
            com.baidu.tbadk.r.a.a(this.ktD.getPageContext(), this.ktR);
        }
        if (this.kuh != null) {
            this.kuh.notifyDataSetChanged();
        }
        this.ktD.getLayoutMode().onModeChanged(this.ktT);
    }

    public void cOc() {
        this.mProgress.setVisibility(0);
    }

    public void cOd() {
        this.fml.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.ktQ.endLoadData();
    }

    public void bVc() {
        this.fml.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.ktQ.bVc();
    }

    public boolean cOe() {
        return this.ktB.cOe();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.kuh.c(onLongClickListener);
    }

    public View cOf() {
        return this.ktC;
    }

    public TextView ccQ() {
        return this.hRg;
    }

    public ImageView cOg() {
        return this.kud;
    }

    public ImageView cOh() {
        return this.kue;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void BN(int i) {
    }

    public View cOi() {
        return this.ktF;
    }

    public View cOj() {
        return this.ktN;
    }

    public MorePopupWindow cOk() {
        return this.ktS;
    }

    public void showLoadingDialog() {
        if (this.gXx == null) {
            this.gXx = new com.baidu.tbadk.core.view.a(this.ktD.getPageContext());
        }
        this.gXx.setDialogVisiable(true);
    }

    public void bJn() {
        if (this.gXx != null) {
            this.gXx.setDialogVisiable(false);
        }
    }

    public TextView cOl() {
        return this.ktM;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.kuh.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.kuh != null) {
            this.kuh.notifyDataSetChanged();
        }
    }

    public ad cOm() {
        return this.ktg;
    }

    public void cfa() {
    }

    public void cfb() {
    }

    public void cdm() {
        this.ktB.onDestroy();
    }

    public void cOn() {
        if (this.ktD.isPaused()) {
        }
    }

    public View cOo() {
        return this.ktG;
    }

    private SpannableStringBuilder dn(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a((Context) this.ktD.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int cOp() {
        if (this.jhW == null || this.jhW.bfa() == null) {
            return 0;
        }
        return this.jhW.bfa().getHeight();
    }

    public int cOq() {
        if (this.ktW == null) {
            return 0;
        }
        return this.ktW.getHeight();
    }

    public void cOr() {
        if (this.hRg != null && this.jhW != null) {
            if (this.jhW.bgg()) {
                this.hRg.setText(R.string.draft_to_send);
            } else {
                this.hRg.setText(this.ktD.cLQ());
            }
        }
    }
}
