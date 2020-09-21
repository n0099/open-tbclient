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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.h;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.main.ah;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.b;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.i;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes21.dex */
public class a implements KeyboardEventLayout.a {
    private static final int laL = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener aTZ;
    private NoNetworkView eWZ;
    private LinearLayout eXa;
    private f.c evf;
    private BdTypeListView fGf;
    private View hPv;
    private com.baidu.tbadk.core.view.a hxf;
    private e iGA;
    private TextView isw;
    private com.baidu.tieba.pb.view.d kTD;
    private View kTW;
    private LinearLayout kTY;
    private HeadImageView kTZ;
    private p kZs;
    private SubPbView laM;
    private View laN;
    private NewSubPbActivity laO;
    private RelativeLayout laP;
    private View laT;
    private SubPbModel lai;
    private ah lal;
    private ThreadSkinView lba;
    private d lbb;
    private View lbc;
    private View lbe;
    private View lbg;
    private BlankView lbh;
    private com.baidu.tbadk.core.dialog.b lbj;
    private ArrayList<PostData> lbm;
    private RelativeLayout lbn;
    private ImageView lbo;
    private ImageView lbp;
    private c lbs;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener dUW = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView laQ = null;
    private LinearLayout laR = null;
    private HeadImageView laS = null;
    private TextView dWe = null;
    private ImageView laU = null;
    private TextView kWE = null;
    private TextView laV = null;
    private TextView laW = null;
    private EllipsizeRichTextView laX = null;
    private TbImageView laY = null;
    private PlayVoiceBntNew akd = null;
    private TextView laZ = null;
    private MorePopupWindow lbd = null;
    private com.baidu.tbadk.core.dialog.b lbf = null;
    private Dialog lbi = null;
    private com.baidu.tbadk.core.dialog.a kTH = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a lbk = null;
    private NewSubPbActivity.a lbl = null;
    private h jOl = null;
    private int fhJ = 0;
    private int lbq = 2;
    private int lbr = 0;
    private boolean eNo = true;
    private boolean kJC = com.baidu.tbadk.a.d.baU();
    private com.baidu.tieba.pb.a.c eHq = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.a.7
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.oY(false);
            a.this.oY(true);
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
    protected AdapterView.OnItemLongClickListener lbt = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.3
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            SparseArray<Object> sparseArray;
            boolean z = true;
            PostData postData = (PostData) y.getItem(a.this.lbm, i);
            if (view != null && view.getTag() != null) {
                if (a.this.lal == null) {
                    a.this.lal = new ah(a.this.laO.getPageContext(), a.this.aTZ);
                }
                a.this.lal.NY();
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null) {
                    return true;
                }
                PostData postData2 = sparseArray.get(R.id.tag_clip_board) instanceof PostData ? (PostData) sparseArray.get(R.id.tag_clip_board) : null;
                boolean z2 = a.this.tc(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                ah ahVar = a.this.lal;
                int cZg = a.this.lai.cZg();
                if (!a.this.kJC || postData2 == null || !postData2.mpy) {
                    z = false;
                }
                ahVar.a(sparseArray, cZg, z2, z);
                if (z2) {
                    a.this.lal.ddg().setVisibility(0);
                    a.this.lal.ddg().setTag(postData.getId());
                } else {
                    a.this.lal.ddg().setVisibility(8);
                }
                a.this.lal.dde().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener lbu = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.laO != null && bg.checkUpIsLogin(a.this.laO.getPageContext().getPageActivity())) {
                if ((a.this.laO.jOf == null || a.this.lai == null || a.this.lai.coh() == null || a.this.laO.jOf.ob(a.this.lai.coh().replyPrivateFlag)) && a.this.lai != null && a.this.jOl != null) {
                    a.this.dge();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.dgg();
                        a.this.lai.dgF();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.jOl.setReplyId(str2);
                            a.this.jOl.CC(str);
                        }
                    }
                    a.this.dgf();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.laM = null;
        this.laN = null;
        this.fGf = null;
        this.kTD = null;
        this.laO = null;
        this.eWZ = null;
        this.laP = null;
        this.laT = null;
        this.lbb = null;
        this.lbg = null;
        this.aTZ = null;
        this.mProgress = null;
        this.isw = null;
        this.lbn = null;
        this.lbo = null;
        this.lbp = null;
        this.laO = newSubPbActivity;
        this.aTZ = onClickListener;
        this.laM = (SubPbView) LayoutInflater.from(this.laO.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.laN = LayoutInflater.from(this.laO.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.eXa = (LinearLayout) this.laM.findViewById(R.id.navigation_bar_group);
        this.lbn = (RelativeLayout) this.laM.findViewById(R.id.subpb_editor_tool_comment);
        this.isw = (TextView) this.laM.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.isw.setOnClickListener(this.aTZ);
        this.lbo = (ImageView) this.laM.findViewById(R.id.subpb_editor_tool_more_img);
        this.lbp = (ImageView) this.laM.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.lbp.setOnClickListener(this.aTZ);
        this.lbo.setOnClickListener(this.aTZ);
        this.eWZ = (NoNetworkView) this.laM.findViewById(R.id.view_no_network);
        cuc();
        bMf();
        this.laP = (RelativeLayout) this.laM.findViewById(R.id.sub_pb_body_layout);
        this.fGf = (BdTypeListView) this.laM.findViewById(R.id.new_sub_pb_list);
        this.lba = (ThreadSkinView) LayoutInflater.from(this.laO.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.fGf.addHeaderView(this.lba);
        this.fGf.addHeaderView(this.laN);
        this.hPv = new TextView(newSubPbActivity.getActivity());
        this.hPv.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.fGf.addHeaderView(this.hPv, 0);
        this.laM.setTopView(this.hPv);
        this.laM.setNavigationView(this.eXa);
        this.laM.setListView(this.fGf);
        this.laM.setContentView(this.laP);
        this.lbb = new d(this.laO.getPageContext());
        this.lbb.setLineGone();
        this.lbg = this.lbb.getView();
        this.fGf.setNextPage(this.lbb);
        this.lbb.setOnClickListener(this.aTZ);
        this.fGf.setOnItemClickListener(this.lbu);
        this.fGf.setOnItemLongClickListener(this.lbt);
        this.fGf.setOnTouchListener(this.eHq);
        this.kTD = new com.baidu.tieba.pb.view.d(newSubPbActivity.getPageContext());
        this.kTD.createView();
        this.kTD.setListPullRefreshListener(this.evf);
        this.kTD.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mProgress = (ProgressBar) this.laM.findViewById(R.id.progress);
        this.kTW = this.laM.findViewById(R.id.view_comment_top_line);
        this.kTY = (LinearLayout) this.laM.findViewById(R.id.pb_editer_tool_comment_layout);
        this.kTZ = (HeadImageView) this.laM.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.kTZ.setVisibility(0);
        this.kTZ.setIsRound(true);
        this.kTZ.setBorderWidth(l.getDimens(this.laO, R.dimen.tbds1));
        this.kTZ.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.kTZ.setPlaceHolder(1);
        this.kTZ.setDefaultResource(R.color.cp_bg_line_e);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.kTZ.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.laN != null) {
            this.laN.setVisibility(4);
        }
        this.laT = com.baidu.tbadk.ala.b.bbl().q(this.laO.getActivity(), 4);
        if (this.laT != null) {
            this.laT.setVisibility(8);
            this.laR.addView(this.laT, 3);
        }
        this.lbs = new c(this.laO, this.fGf);
        this.lbs.setFromCDN(this.mIsFromCDN);
        this.lbs.A(this.aTZ);
        this.lbs.JZ();
    }

    public ListView getListView() {
        return this.fGf;
    }

    public void bMf() {
        this.laR = (LinearLayout) this.laN.findViewById(R.id.subpb_head_user_info_root);
        this.laR.setOnClickListener(this.aTZ);
        this.laS = (HeadImageView) this.laN.findViewById(R.id.photo);
        this.laS.setRadius(l.getDimens(this.laO.getActivity(), R.dimen.tbds45));
        this.laS.setClickable(false);
        this.dWe = (TextView) this.laN.findViewById(R.id.user_name);
        this.laU = (ImageView) this.laN.findViewById(R.id.user_rank);
        this.laU.setVisibility(8);
        this.kWE = (TextView) this.laN.findViewById(R.id.floor_owner);
        this.laQ = (TextView) this.laN.findViewById(R.id.see_subject);
        this.laQ.setOnClickListener(this.aTZ);
        this.laV = (TextView) this.laN.findViewById(R.id.floor);
        this.laW = (TextView) this.laN.findViewById(R.id.time);
        this.laX = (EllipsizeRichTextView) this.laN.findViewById(R.id.content_text);
        this.laX.setOnClickListener(this.aTZ);
        ap.setViewTextColor(this.laX, R.color.cp_cont_b);
        this.laX.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        this.laX.setLineSpacing(0.0f, 1.25f);
        this.laY = (TbImageView) this.laN.findViewById(R.id.sub_pb_image);
        this.laY.setOnClickListener(this.aTZ);
        this.laZ = (TextView) this.laN.findViewById(R.id.advert);
        this.akd = (PlayVoiceBntNew) this.laN.findViewById(R.id.voice_btn);
        this.laN.setOnTouchListener(this.eHq);
        this.laN.setOnClickListener(this.aTZ);
    }

    public void a(b.InterfaceC0533b interfaceC0533b, boolean z) {
        if (this.lbj != null) {
            this.lbj.dismiss();
            this.lbj = null;
        }
        this.lbj = new com.baidu.tbadk.core.dialog.b(this.laO.getPageContext().getPageActivity());
        if (z) {
            this.lbj.a(new String[]{this.laO.getPageContext().getString(R.string.save_to_emotion)}, interfaceC0533b);
        } else {
            this.lbj.a(new String[]{this.laO.getPageContext().getString(R.string.save_to_emotion), this.laO.getPageContext().getString(R.string.save_to_local)}, interfaceC0533b);
        }
        this.lbj.d(this.laO.getPageContext());
        this.lbj.bic();
    }

    public void dg(View view) {
        this.lbc = view;
    }

    public void cuc() {
        int dimens = l.getDimens(this.laO.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = l.getDimens(this.laO.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.laM.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lbh != null) {
                    a.this.laM.onFinish();
                } else {
                    a.this.laO.finish();
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

    public void dc(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.lbi == null) {
            this.lbi = new Dialog(this.laO.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lbi.setCanceledOnTouchOutside(true);
            this.lbi.setCancelable(true);
            this.lbe = LayoutInflater.from(this.laO.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.laO.getLayoutMode().onModeChanged(this.lbe);
            this.lbi.setContentView(this.lbe);
            WindowManager.LayoutParams attributes = this.lbi.getWindow().getAttributes();
            attributes.width = (int) (l.getEquipmentWidth(this.laO.getPageContext().getPageActivity()) * 0.9d);
            this.lbi.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.lbi.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.lbi.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.lbi.findViewById(R.id.disable_reply_btn);
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
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lbi != null && (a.this.lbi instanceof Dialog)) {
                        g.b(a.this.lbi, a.this.laO.getPageContext());
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
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lbi != null && (a.this.lbi instanceof Dialog)) {
                        g.b(a.this.lbi, a.this.laO.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.lbk != null) {
                        a.this.lbk.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lbi != null && (a.this.lbi instanceof Dialog)) {
                        g.b(a.this.lbi, a.this.laO.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.laO.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.lbi, this.laO.getPageContext());
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
        this.kTH = new com.baidu.tbadk.core.dialog.a(this.laO.getPageContext().getPageActivity());
        this.kTH.nE(i3);
        this.kTH.setYesButtonTag(sparseArray);
        this.kTH.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.lbl != null) {
                    a.this.lbl.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.kTH.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kTH.id(true);
        this.kTH.b(this.laO.getPageContext());
        if (z) {
            this.kTH.bia();
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData coh;
        if (this.laO != null && sparseArray != null && this.laN != null) {
            if (this.iGA == null) {
                this.iGA = new e(this.laO.getPageContext(), this.laN);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.lai != null && (coh = this.lai.coh()) != null && coh.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = coh.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            ar arVar = new ar();
            arVar.setFeedBackReasonMap(sparseArray2);
            this.iGA.setDefaultReasonArray(new String[]{this.laO.getString(R.string.delete_thread_reason_1), this.laO.getString(R.string.delete_thread_reason_2), this.laO.getString(R.string.delete_thread_reason_3), this.laO.getString(R.string.delete_thread_reason_4), this.laO.getString(R.string.delete_thread_reason_5)});
            this.iGA.setData(arVar);
            this.iGA.DC("4");
            this.iGA.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.a.13
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray) {
                    String R = at.R(jSONArray);
                    if (a.this.lbl != null) {
                        a.this.lbl.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), R});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oY(final boolean z) {
        if (this.fGf != null) {
            if (!z) {
                this.fGf.setEnabled(z);
            } else {
                this.fGf.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.14
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.fGf.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.lbk = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.lbl = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.laO.showToast(this.laO.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.laO.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.bsv() != null) {
            this.jOl = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.laP.addView(hVar.bsv(), layoutParams);
            this.jOl.a(new x.a() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    a.this.dgz();
                }
            });
        }
    }

    public void dge() {
        if (this.fGf != null) {
            this.lbr = this.fGf.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tc(boolean z) {
        if (this.lai == null || this.lai.dgC() == null) {
            return false;
        }
        if (this.lai.cZg() != 0) {
            return false;
        }
        return (this.kZs == null || this.kZs.bcY() == null || this.kZs.bcY().bfy() == null || !TextUtils.equals(this.kZs.bcY().bfy().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void dgf() {
        if (this.lai != null) {
            if ((!dgi() && this.lbg != null && this.lbg.isShown()) || y.isEmpty(this.lbm)) {
                this.lai.ui(false);
            } else {
                this.lai.ui(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.lai = subPbModel;
    }

    public void uf(boolean z) {
        if (this.lai != null && this.lai.dgc() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.lbh = new BlankView(this.laO.getPageContext().getPageActivity());
            this.eXa.addView(this.lbh, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.lbh.setVisibility(0);
            this.lbh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.laO.finish();
                }
            });
            this.laM.setBlankView(this.lbh);
        }
    }

    public void dgg() {
        b(this.laO);
        this.fGf.setNextPage(this.lbb);
    }

    public void u(PostData postData) {
        int i;
        if (postData != null) {
            postData.wm(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!dgi() && this.lbg != null && this.lbg.isShown()) {
                i = (this.lbr - this.lbq) - 1;
            } else {
                i = this.lbr - this.lbq;
            }
            int count = y.getCount(this.lbm);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(y.subList(this.lbm, 0, i));
            y.add(arrayList, postData2);
            y.add(arrayList, postData);
            this.fGf.smoothScrollToPosition(this.lbr + 2);
            this.fGf.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fGf.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.fGf.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.laM;
    }

    public void deI() {
        if (this.lbd != null) {
            g.dismissPopupWindow(this.lbd, this.laO.getPageContext().getPageActivity());
        }
        if (this.lbf != null) {
            this.lbf.dismiss();
        }
        if (this.kTH != null) {
            this.kTH.dismiss();
        }
        if (this.lbi != null) {
            g.b(this.lbi, this.laO.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.lal != null) {
            this.lal.dismiss();
        }
    }

    public void dgh() {
        this.fGf.setNextPage(this.lbb);
        this.lbb.startLoadData();
    }

    public void setIsFromPb(boolean z) {
        this.eNo = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v68, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(p pVar, int i, boolean z, boolean z2) {
        int i2;
        int i3;
        int i4;
        if (pVar != null) {
            if (this.eNo && this.laN != null) {
                this.laN.setVisibility(8);
                this.fGf.removeHeaderView(this.laN);
                this.lbq = 1;
            }
            this.kZs = pVar;
            if (this.kZs.cZH() != null) {
                this.kZs.cZH().mpy = true;
            }
            if (this.laN != null) {
                this.laN.setVisibility(0);
            }
            if (pVar.bcY() != null && pVar.bcY().bei()) {
                this.laQ.setText(R.string.view_original);
            } else {
                this.laQ.setText(R.string.view_subject);
            }
            if (pVar.cZH() != null) {
                this.fhJ = pVar.cZH().dAD();
                if (this.fhJ > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.laO.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.fhJ)));
                    if (this.laO != null) {
                        this.isw.setText(this.laO.ddW());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.laO.getResources().getString(R.string.local_floor_reply));
                }
                String str = null;
                if (this.laO.dgc()) {
                    str = "PB";
                }
                if (pVar.cZH().bfU() != null) {
                    this.lba.setData(this.laO.getPageContext(), pVar.cZH().bfU(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", pVar.btx().getId(), pVar.btx().getName(), pVar.bcY().getId(), str));
                } else {
                    this.lba.setData(null, null, null);
                }
            }
            if (pVar.hasMore()) {
                this.lbb.startLoadData();
                this.lbs.setHasMoreData(true);
            } else {
                this.lbb.endLoadData();
                this.lbs.setHasMoreData(false);
            }
            this.lbm = pVar.cZP();
            if (this.lbm == null || this.lbm.size() <= laL) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.lbm.size() - laL;
                Fh(size);
                int firstVisiblePosition = this.fGf.getFirstVisiblePosition() - size;
                View childAt = this.fGf.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.lbm);
            if (y.isEmpty(this.lbm)) {
                this.fGf.setNextPage(null);
                if (this.eNo) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.fGf.setNextPage(this.lbb);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(pVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.eNo) {
                arrayList.add(0, pVar.cZH());
            }
            this.lbs.a(this.kZs.bcY(), arrayList);
            a(pVar, pVar.cZH(), pVar.cLj(), pVar.bbu(), i, z);
            if (i4 > 0) {
                this.fGf.setSelectionFromTop(i3, i2);
            } else if (z2 && !at.isEmpty(this.laO.dgd().dce())) {
                String dce = this.laO.dgd().dce();
                int i5 = 0;
                while (true) {
                    final int i6 = i5;
                    if (i6 < arrayList.size()) {
                        if (!(arrayList.get(i6) instanceof PostData) || !dce.equals(((PostData) arrayList.get(i6)).getId())) {
                            i5 = i6 + 1;
                        } else {
                            this.fGf.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    int headerViewsCount = i6 + a.this.fGf.getHeaderViewsCount();
                                    if (headerViewsCount >= 1) {
                                        headerViewsCount--;
                                    }
                                    a.this.fGf.setSelection(headerViewsCount);
                                }
                            });
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (this.kZs.cZM() > 1) {
                this.fGf.setPullRefresh(this.kTD);
                this.laM.setEnableDragExit(false);
                return;
            }
            this.fGf.setPullRefresh(null);
            this.laM.setEnableDragExit(true);
        }
    }

    private void Fh(int i) {
        if (this.lbm != null) {
            if (this.lbm.size() <= i) {
                this.lbm.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.lbm.iterator();
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

    public boolean dgi() {
        return this.lbs.azG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.eNo) {
            if (!StringUtils.isNull(postData.dAK())) {
                this.laY.setVisibility(0);
                this.laY.startLoad(postData.dAK(), 10, true);
            } else {
                this.laY.setVisibility(8);
            }
            i dAM = postData.dAM();
            if (dAM != null && dAM.moi) {
                this.laZ.setVisibility(0);
            } else {
                this.laZ.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.laN.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.laN.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.laV.setText((CharSequence) null);
            this.dWe.setText((CharSequence) null);
            this.kWE.setVisibility(8);
            if (!this.eNo) {
                c(postData.bfy());
                if (z) {
                    this.kWE.setVisibility(0);
                    ap.setViewTextColor(this.kWE, R.color.cp_link_tip_a);
                }
            }
            this.laW.setText(at.getFormatTime(postData.getTime()));
            String format = String.format(this.laO.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.dAD()));
            if (pVar.bcY() != null && pVar.bcY().bei()) {
                this.laV.setText((CharSequence) null);
            } else {
                this.laV.setText(format);
            }
            postData.bfy().getUserTbVipInfoData();
            boolean a = a(this.laX, postData.dAF());
            if (StringUtils.isNull(postData.dAK()) && !a && postData.byO() != null) {
                this.akd.setVisibility(0);
                this.akd.setTag(postData.byO());
                return;
            }
            this.akd.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        String str;
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.byteLength(metaData.getSealPrefix()) + 2 : 0) + af.getTextLength(name_show) > 14) {
                str = af.subString(name_show, 0, 14);
                if (str.length() != name_show.length()) {
                    str = str + StringHelper.STRING_MORE;
                }
            } else {
                str = name_show;
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.dWe.setText(dH(metaData.getSealPrefix(), str));
            } else {
                this.dWe.setText(str);
            }
            if (metaData.getAlaUserData() != null && this.laT != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.laT.setVisibility(8);
                } else {
                    this.laT.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.dTL = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.laT.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                ap.setViewTextColor(this.dWe, R.color.cp_cont_r);
            } else {
                ap.setViewTextColor(this.dWe, R.color.cp_cont_c);
            }
            this.laS.setVisibility(0);
            this.laS.setUserId(metaData.getUserId());
            this.laS.setUserName(metaData.getUserName());
            this.laS.setDefaultResource(R.drawable.transparent_bg);
            UtilHelper.showHeadImageViewBigV(this.laS, metaData);
            this.laS.startLoad(metaData.getAvater(), 28, false);
            this.laR.setTag(R.id.tag_user_id, metaData.getUserId());
            this.laR.setTag(R.id.tag_user_name, metaData.getUserName());
            this.laR.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.byG() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.byG().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.n(next.byN());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.ka(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.dJc());
                        continue;
                    case 17:
                        String str = next.byR().mGifInfo.mSharpText;
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
        if (!tbRichTextData.byW()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.byN() == null || tbRichTextData.byN().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.byN());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.laO.getPageContext().getString(R.string.refresh_view_button_text), this.dUW));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.laO.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.laP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, l.getDimens(pageActivity, R.dimen.ds250)), dVar, a);
        }
        this.fGf.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.jOl.btD();
        ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.laO.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void BE(int i) {
        b(NoDataViewFactory.d.dG(null, this.laO.getResources().getString(R.string.refresh_view_title_text)));
        this.lbn.setVisibility(8);
    }

    public void Hq(String str) {
        b(NoDataViewFactory.d.dG(str, this.laO.getPageContext().getString(R.string.refresh_view_title_text)));
        this.lbn.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.fGf.setVisibility(0);
            this.lbn.setVisibility(0);
            this.laM.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.dUW = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x025a  */
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
        if (postData != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            if (i != 0) {
                if (i != 3) {
                    z = true;
                    z2 = true;
                } else {
                    z = false;
                    z2 = false;
                }
                String userId2 = postData.bfy().getUserId();
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z2 = false;
                }
            } else {
                z = false;
                z2 = false;
            }
            if (this.kZs != null && this.kZs.bcY() != null && this.kZs.bcY().bfy() != null && postData.bfy() != null) {
                String userId3 = this.kZs.bcY().bfy().getUserId();
                String userId4 = postData.bfy().getUserId();
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
                    userId = postData.bfy().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.dAD() != 1 ? 0 : 1;
                    if (!z2) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.bfy() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.bfy().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.bfy().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.bfy().getPortrait());
                            z6 = true;
                        } else {
                            z6 = true;
                        }
                    } else {
                        sparseArray.put(R.id.tag_forbid_user_name, "");
                        sparseArray.put(R.id.tag_forbid_user_name_show, "");
                        sparseArray.put(R.id.tag_forbid_user_portrait, "");
                        z6 = false;
                    }
                    if (!z4) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_is_self, true);
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.getId());
                        z6 = true;
                    } else {
                        sparseArray.put(R.id.tag_del_post_is_self, false);
                        sparseArray.put(R.id.tag_del_post_type, 0);
                        sparseArray.put(R.id.tag_del_post_id, "");
                    }
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z6));
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z2) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        if (postData.bfy() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.bfy().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.bfy().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.bfy().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.bfy() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bfy().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.bfy().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bfy().getName_show());
                        }
                        if (this.kZs.bcY() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.kZs.bcY().getId());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(R.id.tag_should_delete_visible, true);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.getId());
                        return;
                    }
                    sparseArray.put(R.id.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = postData.bfy().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.dAD() != 1) {
            }
            if (!z2) {
            }
            if (!z4) {
            }
            sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z6));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (!z2) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public void ug(boolean z) {
        if (this.lal != null && this.lal.dde() != null) {
            if (z) {
                this.lal.dde().setText(R.string.remove_mark);
            } else {
                this.lal.dde().setText(R.string.mark);
            }
        }
    }

    public View dgj() {
        return this.lbg;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.laM, R.color.cp_mask_b_alpha66);
        ap.setBackgroundColor(this.laP, R.color.cp_bg_line_d);
        this.laO.getLayoutMode().setNightMode(i == 1);
        this.laO.getLayoutMode().onModeChanged(this.laM);
        this.laO.getLayoutMode().onModeChanged(this.laN);
        this.mNavigationBar.onChangeSkinType(this.laO.getPageContext(), i);
        if (this.laQ != null) {
            ap.setViewTextColor(this.laQ, R.color.goto_see_subject_color);
        }
        this.eWZ.onChangeSkinType(this.laO.getPageContext(), i);
        this.laO.getLayoutMode().onModeChanged(this.lbg);
        ap.setViewTextColor(this.laX, R.color.cp_cont_b);
        this.laX.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        if (this.jOl != null && this.jOl.bsv() != null) {
            this.jOl.bsv().onChangeSkinType(i);
        }
        this.lbb.changeSkin(i);
        this.akd.changeSkin();
        ap.setViewTextColor(this.isw, R.color.cp_cont_e);
        ap.setViewTextColor(this.kWE, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.dWe, R.color.cp_cont_c);
        this.isw.setAlpha(0.95f);
        if (this.lbc != null) {
            com.baidu.tbadk.r.a.a(this.laO.getPageContext(), this.lbc);
        }
        if (this.lbs != null) {
            this.lbs.notifyDataSetChanged();
        }
        this.laO.getLayoutMode().onModeChanged(this.lbe);
        ap.setBackgroundResource(this.kTW, R.drawable.bottom_shadow);
        this.kTZ.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.kTY.setBackgroundDrawable(ap.aO(l.getDimens(this.laO, R.dimen.tbds47), ap.getColor(R.color.cp_bg_line_j)));
    }

    public void dgk() {
        this.mProgress.setVisibility(0);
    }

    public void dgl() {
        this.fGf.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.lbb.endLoadData();
    }

    public void cmf() {
        this.fGf.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.lbb.cmf();
    }

    public boolean dgm() {
        return this.laM.dgm();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.lbs.c(onLongClickListener);
    }

    public View dgn() {
        return this.laN;
    }

    public TextView cuh() {
        return this.isw;
    }

    public ImageView dgo() {
        return this.lbo;
    }

    public ImageView dgp() {
        return this.lbp;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void Fi(int i) {
    }

    public View dgq() {
        return this.laQ;
    }

    public View dgr() {
        return this.laY;
    }

    public MorePopupWindow dgs() {
        return this.lbd;
    }

    public void showLoadingDialog() {
        if (this.hxf == null) {
            this.hxf = new com.baidu.tbadk.core.view.a(this.laO.getPageContext());
        }
        this.hxf.setDialogVisiable(true);
    }

    public void bXZ() {
        if (this.hxf != null) {
            this.hxf.setDialogVisiable(false);
        }
    }

    public TextView dgt() {
        return this.laX;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lbs.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.lbs != null) {
            this.lbs.notifyDataSetChanged();
        }
    }

    public ah dgu() {
        return this.lal;
    }

    public void cwv() {
    }

    public void cww() {
    }

    public void cuG() {
        this.laM.onDestroy();
    }

    public void dgv() {
        if (this.laO.isPaused()) {
        }
    }

    public View dgw() {
        return this.laR;
    }

    private SpannableStringBuilder dH(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a((Context) this.laO.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int dgx() {
        if (this.jOl == null || this.jOl.bsv() == null) {
            return 0;
        }
        return this.jOl.bsv().getHeight();
    }

    public int dgy() {
        if (this.lbh == null) {
            return 0;
        }
        return this.lbh.getHeight();
    }

    public void dgz() {
        if (this.isw != null && this.jOl != null) {
            if (this.jOl.btI()) {
                this.isw.setText(R.string.draft_to_send);
            } else {
                this.isw.setText(this.laO.ddW());
            }
        }
    }

    public void tr(boolean z) {
        if (this.kTZ != null) {
            this.kTZ.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.evf = cVar;
        if (this.kTD != null) {
            this.kTD.setListPullRefreshListener(cVar);
        }
    }
}
