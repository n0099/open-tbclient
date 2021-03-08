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
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
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
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.f;
import com.baidu.tieba.NEGFeedBack.i;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.q;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.b;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.pb.view.e;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class a implements KeyboardEventLayout.a {
    private static final int miR = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener bdi;
    private ImageView eJc;
    private NoNetworkView fNp;
    private LinearLayout fNq;
    private f.c fkY;
    private BdTypeListView gAY;
    private com.baidu.tbadk.core.view.a iFD;
    private View iXG;
    private TextView jDr;
    private com.baidu.tieba.NEGFeedBack.f jSR;
    private MaskView lSi;
    private ProgressBar mProgress;
    private View mbO;
    private LinearLayout mbQ;
    private HeadImageView mbR;
    private e mbu;
    private i mcO;
    private q mhx;
    private SubPbView miS;
    private View miT;
    private NewSubPbActivity miU;
    private RelativeLayout miV;
    private View miZ;
    private SubPbModel mio;
    private aa mir;
    private ThreadSkinView mjg;
    private d mjh;
    private View mji;
    private View mjk;
    private View mjm;
    private BlankView mjn;
    private com.baidu.tbadk.core.dialog.b mjp;
    private ArrayList<PostData> mjs;
    private RelativeLayout mjt;
    private ImageView mju;
    private ImageView mjv;
    private c mjy;
    private NoDataView mNoDataView = null;
    private View.OnClickListener eJh = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView miW = null;
    private LinearLayout miX = null;
    private HeadImageView miY = null;
    private TextView eKp = null;
    private ImageView mja = null;
    private TextView meE = null;
    private TextView mjb = null;
    private TextView mjc = null;
    private EllipsizeRichTextView mjd = null;
    private TbImageView mje = null;
    private PlayVoiceBntNew amu = null;
    private TextView mjf = null;
    private MorePopupWindow mjj = null;
    private com.baidu.tbadk.core.dialog.b mjl = null;
    private Dialog mjo = null;
    private com.baidu.tbadk.core.dialog.a mbz = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a mjq = null;
    private NewSubPbActivity.a mjr = null;
    private h kUH = null;
    private int fYm = 0;
    private int mjw = 2;
    private int mjx = 0;
    private boolean fDj = true;
    private boolean lTP = com.baidu.tbadk.a.d.bja();
    private com.baidu.tieba.pb.a.c fxj = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.a.8
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.rm(false);
            a.this.rm(true);
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
    protected AdapterView.OnItemLongClickListener mjz = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            SparseArray<Object> sparseArray;
            boolean z = true;
            PostData postData = (PostData) y.getItem(a.this.mjs, i);
            if (view != null && view.getTag() != null) {
                if (a.this.mir == null) {
                    a.this.mir = new aa(a.this.miU.getPageContext(), a.this.bdi);
                }
                a.this.mir.QH();
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
                boolean z2 = a.this.va(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                aa aaVar = a.this.mir;
                int dlE = a.this.mio.dlE();
                if (!a.this.lTP || postData2 == null || !postData2.nAa) {
                    z = false;
                }
                aaVar.a(sparseArray, dlE, z2, z);
                if (z2) {
                    a.this.mir.dpM().setVisibility(0);
                    a.this.mir.dpM().setTag(postData.getId());
                } else {
                    a.this.mir.dpM().setVisibility(8);
                }
                a.this.mir.dpK().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener mjA = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.miU != null && bh.checkUpIsLogin(a.this.miU.getPageContext().getPageActivity())) {
                if ((a.this.miU.kUB == null || a.this.mio == null || a.this.mio.cBF() == null || a.this.miU.kUB.oy(a.this.mio.cBF().replyPrivateFlag)) && a.this.mio != null && a.this.kUH != null) {
                    a.this.dsR();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.dsT();
                        a.this.mio.dts();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.kUH.setReplyId(str2);
                            a.this.kUH.Dj(str);
                        }
                    }
                    a.this.dsS();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.miS = null;
        this.miT = null;
        this.gAY = null;
        this.mbu = null;
        this.miU = null;
        this.fNp = null;
        this.miV = null;
        this.miZ = null;
        this.mjh = null;
        this.mjm = null;
        this.bdi = null;
        this.mProgress = null;
        this.jDr = null;
        this.mjt = null;
        this.mju = null;
        this.mjv = null;
        this.miU = newSubPbActivity;
        this.bdi = onClickListener;
        this.miS = (SubPbView) LayoutInflater.from(this.miU.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.miT = LayoutInflater.from(this.miU.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.fNq = (LinearLayout) this.miS.findViewById(R.id.navigation_bar_group);
        this.mjt = (RelativeLayout) this.miS.findViewById(R.id.subpb_editor_tool_comment);
        this.jDr = (TextView) this.miS.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.jDr.setOnClickListener(this.bdi);
        this.mju = (ImageView) this.miS.findViewById(R.id.subpb_editor_tool_more_img);
        this.mjv = (ImageView) this.miS.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.mjv.setOnClickListener(this.bdi);
        this.mju.setOnClickListener(this.bdi);
        this.fNp = (NoNetworkView) this.miS.findViewById(R.id.view_no_network);
        cIG();
        bWC();
        this.miV = (RelativeLayout) this.miS.findViewById(R.id.sub_pb_body_layout);
        this.gAY = (BdTypeListView) this.miS.findViewById(R.id.new_sub_pb_list);
        this.mjg = (ThreadSkinView) LayoutInflater.from(this.miU.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.gAY.addHeaderView(this.mjg);
        this.gAY.addHeaderView(this.miT);
        this.iXG = new TextView(newSubPbActivity.getActivity());
        this.iXG.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.gAY.addHeaderView(this.iXG, 0);
        this.miS.setTopView(this.iXG);
        this.miS.setNavigationView(this.fNq);
        this.miS.setListView(this.gAY);
        this.miS.setContentView(this.miV);
        this.mjh = new d(this.miU.getPageContext());
        this.mjh.setLineGone();
        this.mjm = this.mjh.getView();
        this.gAY.setNextPage(this.mjh);
        this.mjh.setOnClickListener(this.bdi);
        this.gAY.setOnItemClickListener(this.mjA);
        this.gAY.setOnItemLongClickListener(this.mjz);
        this.gAY.setOnTouchListener(this.fxj);
        this.mbu = new e(newSubPbActivity.getPageContext());
        this.mbu.createView();
        this.mbu.setListPullRefreshListener(this.fkY);
        this.mbu.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mProgress = (ProgressBar) this.miS.findViewById(R.id.progress);
        this.lSi = (MaskView) this.miS.findViewById(R.id.mask_view);
        this.mbO = this.miS.findViewById(R.id.view_comment_top_line);
        this.mbQ = (LinearLayout) this.miS.findViewById(R.id.pb_editer_tool_comment_layout);
        this.mbR = (HeadImageView) this.miS.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.mbR.setVisibility(0);
        this.mbR.setIsRound(true);
        this.mbR.setBorderWidth(l.getDimens(this.miU, R.dimen.L_X01));
        this.mbR.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.mbR.setDefaultBgResource(0);
        this.mbR.setDefaultResource(R.color.CAM_X0205);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.mbR.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.miT != null) {
            this.miT.setVisibility(4);
        }
        this.miZ = com.baidu.tbadk.ala.b.bjS().A(this.miU.getActivity(), 4);
        if (this.miZ != null) {
            this.miZ.setVisibility(8);
            this.miX.addView(this.miZ, 3);
        }
        this.mjy = new c(this.miU, this.gAY);
        this.mjy.setFromCDN(this.mIsFromCDN);
        this.mjy.C(this.bdi);
        this.mjy.Kz();
    }

    public ListView getListView() {
        return this.gAY;
    }

    public void bWC() {
        this.miX = (LinearLayout) this.miT.findViewById(R.id.subpb_head_user_info_root);
        this.miX.setOnClickListener(this.bdi);
        this.miY = (HeadImageView) this.miT.findViewById(R.id.photo);
        this.miY.setRadius(l.getDimens(this.miU.getActivity(), R.dimen.tbds45));
        this.miY.setClickable(false);
        this.eKp = (TextView) this.miT.findViewById(R.id.user_name);
        this.mja = (ImageView) this.miT.findViewById(R.id.user_rank);
        this.mja.setVisibility(8);
        this.meE = (TextView) this.miT.findViewById(R.id.floor_owner);
        this.miW = (TextView) this.miT.findViewById(R.id.see_subject);
        this.miW.setOnClickListener(this.bdi);
        this.mjb = (TextView) this.miT.findViewById(R.id.floor);
        this.mjc = (TextView) this.miT.findViewById(R.id.time);
        this.mjd = (EllipsizeRichTextView) this.miT.findViewById(R.id.content_text);
        this.mjd.setOnClickListener(this.bdi);
        ap.setViewTextColor(this.mjd, R.color.CAM_X0105);
        this.mjd.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        this.mjd.setLineSpacing(0.0f, 1.25f);
        this.mje = (TbImageView) this.miT.findViewById(R.id.sub_pb_image);
        this.mje.setOnClickListener(this.bdi);
        this.mjf = (TextView) this.miT.findViewById(R.id.advert);
        this.amu = (PlayVoiceBntNew) this.miT.findViewById(R.id.voice_btn);
        this.miT.setOnTouchListener(this.fxj);
        this.miT.setOnClickListener(this.bdi);
    }

    public void a(b.InterfaceC0564b interfaceC0564b, boolean z) {
        if (this.mjp != null) {
            this.mjp.dismiss();
            this.mjp = null;
        }
        this.mjp = new com.baidu.tbadk.core.dialog.b(this.miU.getPageContext().getPageActivity());
        if (z) {
            this.mjp.a(new String[]{this.miU.getPageContext().getString(R.string.save_to_emotion)}, interfaceC0564b);
        } else {
            this.mjp.a(new String[]{this.miU.getPageContext().getString(R.string.save_to_emotion), this.miU.getPageContext().getString(R.string.save_to_local)}, interfaceC0564b);
        }
        this.mjp.d(this.miU.getPageContext());
        this.mjp.bqB();
    }

    public void dP(View view) {
        this.mji = view;
    }

    public void cIG() {
        int dimens = l.getDimens(this.miU.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = l.getDimens(this.miU.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.miS.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mjn != null) {
                    a.this.miS.onFinish();
                } else {
                    a.this.miU.finish();
                }
            }
        });
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        this.eJc = backImageView;
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

    public void dL(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.mjo == null) {
            this.mjo = new Dialog(this.miU.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.mjo.setCanceledOnTouchOutside(true);
            this.mjo.setCancelable(true);
            this.mjk = LayoutInflater.from(this.miU.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.miU.getLayoutMode().onModeChanged(this.mjk);
            this.mjo.setContentView(this.mjk);
            WindowManager.LayoutParams attributes = this.mjo.getWindow().getAttributes();
            attributes.width = (int) (l.getEquipmentWidth(this.miU.getPageContext().getPageActivity()) * 0.9d);
            this.mjo.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.mjo.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.mjo.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.mjo.findViewById(R.id.disable_reply_btn);
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
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.mjo != null && (a.this.mjo instanceof Dialog)) {
                        g.b(a.this.mjo, a.this.miU.getPageContext());
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
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.mjo != null && (a.this.mjo instanceof Dialog)) {
                        g.b(a.this.mjo, a.this.miU.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.mjq != null) {
                        a.this.mjq.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.mjo != null && (a.this.mjo instanceof Dialog)) {
                        g.b(a.this.mjo, a.this.miU.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.miU.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.mjo, this.miU.getPageContext());
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
        this.mbz = new com.baidu.tbadk.core.dialog.a(this.miU.getPageContext().getPageActivity());
        this.mbz.ny(i3);
        this.mbz.setYesButtonTag(sparseArray);
        this.mbz.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.mjr != null) {
                    a.this.mjr.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.mbz.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.mbz.jF(true);
        this.mbz.b(this.miU.getPageContext());
        if (z) {
            this.mbz.bqz();
        } else if (1 == this.mio.dtK()) {
            com.baidu.tieba.NEGFeedBack.h hVar = new com.baidu.tieba.NEGFeedBack.h(this.mio.dtK(), this.mio.dtJ(), this.mio.bKC());
            hVar.eg(this.mhx.bCn().getId(), this.mhx.bCn().getName());
            hVar.setForumHeadUrl(this.mio.bKF());
            hVar.setUserLevel(this.mio.bKG());
            UserData userData = new UserData();
            userData.setIsManager(this.mio.getIsManager());
            a(sparseArray, hVar, userData);
        } else {
            f(sparseArray);
        }
    }

    private void f(final SparseArray<Object> sparseArray) {
        AntiData cBF;
        if (this.miU != null && sparseArray != null && this.miT != null) {
            if (this.jSR == null) {
                this.jSR = new com.baidu.tieba.NEGFeedBack.f(this.miU.getPageContext(), this.miT);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.mio != null && (cBF = this.mio.cBF()) != null && cBF.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBF.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            av avVar = new av();
            avVar.setFeedBackReasonMap(sparseArray2);
            this.jSR.setDefaultReasonArray(new String[]{this.miU.getString(R.string.delete_thread_reason_1), this.miU.getString(R.string.delete_thread_reason_2), this.miU.getString(R.string.delete_thread_reason_3), this.miU.getString(R.string.delete_thread_reason_4), this.miU.getString(R.string.delete_thread_reason_5)});
            this.jSR.setData(avVar);
            this.jSR.Ey("4");
            this.jSR.a(new f.b() { // from class: com.baidu.tieba.pb.pb.sub.a.14
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void W(JSONArray jSONArray) {
                    String R = au.R(jSONArray);
                    if (a.this.mjr != null) {
                        a.this.mjr.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), R});
                    }
                }
            });
        }
    }

    private void a(final SparseArray<Object> sparseArray, com.baidu.tieba.NEGFeedBack.h hVar, UserData userData) {
        AntiData cBF;
        if (this.miU != null && sparseArray != null && this.miT != null) {
            if (this.mcO == null) {
                this.mcO = new i(this.miU.getPageContext(), this.miT, hVar, userData);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.mio != null && (cBF = this.mio.cBF()) != null && cBF.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBF.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            av avVar = new av();
            avVar.setFeedBackReasonMap(sparseArray2);
            this.mcO.setDefaultReasonArray(new String[]{this.miU.getString(R.string.delete_thread_reason_1), this.miU.getString(R.string.delete_thread_reason_2), this.miU.getString(R.string.delete_thread_reason_3), this.miU.getString(R.string.delete_thread_reason_4), this.miU.getString(R.string.delete_thread_reason_5)});
            this.mcO.setData(avVar);
            this.mcO.Ey("4");
            this.mcO.a(new i.b() { // from class: com.baidu.tieba.pb.pb.sub.a.15
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void W(JSONArray jSONArray) {
                    String R = au.R(jSONArray);
                    if (a.this.mjr != null) {
                        a.this.mjr.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), R});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rm(final boolean z) {
        if (this.gAY != null) {
            if (!z) {
                this.gAY.setEnabled(z);
            } else {
                this.gAY.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gAY.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.mjq = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.mjr = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.miU.showToast(this.miU.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.miU.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.bBk() != null) {
            this.kUH = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.miV.addView(hVar.bBk(), layoutParams);
            this.kUH.a(new y.a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void b(WriteData writeData) {
                    a.this.dtm();
                }
            });
        }
    }

    public void dsR() {
        if (this.gAY != null) {
            this.mjx = this.gAY.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean va(boolean z) {
        if (this.mio == null || this.mio.dtp() == null) {
            return false;
        }
        if (this.mio.dlE() != 0) {
            return false;
        }
        return (this.mhx == null || this.mhx.blp() == null || this.mhx.blp().bnS() == null || !TextUtils.equals(this.mhx.blp().bnS().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void dsS() {
        if (this.mio != null) {
            if ((!dsV() && this.mjm != null && this.mjm.isShown()) || com.baidu.tbadk.core.util.y.isEmpty(this.mjs)) {
                this.mio.wi(false);
            } else {
                this.mio.wi(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.mio = subPbModel;
    }

    public void wf(boolean z) {
        if (this.mio != null && this.mio.dsP() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.mjn = new BlankView(this.miU.getPageContext().getPageActivity());
            this.fNq.addView(this.mjn, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.mjn.setVisibility(0);
            this.mjn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.miU.finish();
                }
            });
            this.miS.setBlankView(this.mjn);
        }
    }

    public void dsT() {
        b(this.miU);
        this.gAY.setNextPage(this.mjh);
    }

    public void v(PostData postData) {
        int i;
        if (postData != null) {
            postData.yu(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!dsV() && this.mjm != null && this.mjm.isShown()) {
                i = (this.mjx - this.mjw) - 1;
            } else {
                i = this.mjx - this.mjw;
            }
            int count = com.baidu.tbadk.core.util.y.getCount(this.mjs);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(com.baidu.tbadk.core.util.y.subList(this.mjs, 0, i));
            com.baidu.tbadk.core.util.y.add(arrayList, postData2);
            com.baidu.tbadk.core.util.y.add(arrayList, postData);
            this.gAY.smoothScrollToPosition(this.mjx + 2);
            this.gAY.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gAY.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.gAY.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.miS;
    }

    public void drt() {
        if (this.mjj != null) {
            g.dismissPopupWindow(this.mjj, this.miU.getPageContext().getPageActivity());
        }
        if (this.mjl != null) {
            this.mjl.dismiss();
        }
        if (this.mbz != null) {
            this.mbz.dismiss();
        }
        if (this.mjo != null) {
            g.b(this.mjo, this.miU.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.mir != null) {
            this.mir.dismiss();
        }
    }

    public void dsU() {
        this.gAY.setNextPage(this.mjh);
        this.mjh.startLoadData();
    }

    public void setIsFromPb(boolean z) {
        this.fDj = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v77, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(q qVar, int i, boolean z, boolean z2) {
        int i2;
        int i3;
        int i4;
        if (qVar != null) {
            if (this.fDj && this.miT != null) {
                this.miT.setVisibility(8);
                this.gAY.removeHeaderView(this.miT);
                this.mjw = 1;
            }
            this.mhx = qVar;
            if (this.mhx.dmh() != null) {
                this.mhx.dmh().nAa = true;
            }
            if (this.miT != null) {
                this.miT.setVisibility(0);
            }
            if (qVar.blp() != null && qVar.blp().bmB()) {
                this.miW.setText(R.string.view_original);
            } else {
                this.miW.setText(R.string.view_subject);
            }
            if (qVar.dmh() != null) {
                this.fYm = qVar.dmh().dNO();
                if (this.fYm > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.miU.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.fYm)));
                    if (this.miU != null) {
                        this.jDr.setText(this.miU.dqD());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.miU.getResources().getString(R.string.local_floor_reply));
                }
                String str = null;
                if (this.miU.dsP()) {
                    str = "PB";
                }
                if (qVar.dmh().bon() != null) {
                    this.mjg.setData(this.miU.getPageContext(), qVar.dmh().bon(), com.baidu.tieba.tbadkCore.d.a.i("PB", "c0132", qVar.bCn().getId(), qVar.bCn().getName(), qVar.blp().getId(), str));
                } else {
                    this.mjg.setData(null, null, null);
                }
            }
            if (qVar.hasMore()) {
                this.mjh.startLoadData();
                this.mjy.setHasMoreData(true);
            } else {
                this.mjh.endLoadData();
                this.mjy.setHasMoreData(false);
            }
            this.mjs = qVar.dmq();
            if (this.mjs == null || this.mjs.size() <= miR) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.mjs.size() - miR;
                Gr(size);
                int firstVisiblePosition = this.gAY.getFirstVisiblePosition() - size;
                View childAt = this.gAY.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.mjs);
            if (com.baidu.tbadk.core.util.y.isEmpty(this.mjs)) {
                this.gAY.setNextPage(null);
                if (this.fDj) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.a.a());
                }
            } else {
                this.gAY.setNextPage(this.mjh);
            }
            com.baidu.tieba.pb.pb.sub.a.b bVar = new com.baidu.tieba.pb.pb.sub.a.b();
            bVar.setReplyNum(qVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.fDj) {
                arrayList.add(0, qVar.dmh());
            }
            if (this.miU != null && this.miU.dsQ() != null) {
                this.lSi.setVisibility(this.miU.dsQ().dtL() ? 0 : 8);
            }
            this.mjy.a(this.mhx.blp(), arrayList);
            a(qVar, qVar.dmh(), qVar.Xj(), qVar.bkb(), i, z);
            if (i4 > 0) {
                this.gAY.setSelectionFromTop(i3, i2);
            } else if (z2 && !au.isEmpty(this.miU.dsQ().doI())) {
                String doI = this.miU.dsQ().doI();
                int i5 = 0;
                while (true) {
                    final int i6 = i5;
                    if (i6 < arrayList.size()) {
                        if (!(arrayList.get(i6) instanceof PostData) || !doI.equals(((PostData) arrayList.get(i6)).getId())) {
                            i5 = i6 + 1;
                        } else {
                            this.gAY.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.7
                                @Override // java.lang.Runnable
                                public void run() {
                                    int headerViewsCount = i6 + a.this.gAY.getHeaderViewsCount();
                                    if (headerViewsCount >= 1) {
                                        headerViewsCount--;
                                    }
                                    a.this.gAY.setSelection(headerViewsCount);
                                }
                            });
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (this.mhx.dmn() > 1) {
                this.gAY.setPullRefresh(this.mbu);
                this.miS.setEnableDragExit(false);
                return;
            }
            this.gAY.setPullRefresh(null);
            this.miS.setEnableDragExit(true);
        }
    }

    private void Gr(int i) {
        if (this.mjs != null) {
            if (this.mjs.size() <= i) {
                this.mjs.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.mjs.iterator();
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

    public boolean dsV() {
        return this.mjy.aHw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(q qVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.fDj) {
            if (!StringUtils.isNull(postData.dNV())) {
                this.mje.setVisibility(0);
                this.mje.startLoad(postData.dNV(), 10, true);
            } else {
                this.mje.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.i dNX = postData.dNX();
            if (dNX != null && dNX.nyF) {
                this.mjf.setVisibility(0);
            } else {
                this.mjf.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.miT.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.miT.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.mjb.setText((CharSequence) null);
            this.eKp.setText((CharSequence) null);
            this.meE.setVisibility(8);
            if (!this.fDj) {
                c(postData.bnS());
                if (z) {
                    this.meE.setVisibility(0);
                    ap.setViewTextColor(this.meE, R.color.CAM_X0302);
                }
            }
            this.mjc.setText(au.getFormatTime(postData.getTime()));
            String format = String.format(this.miU.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.dNO()));
            if (qVar.blp() != null && qVar.blp().bmB()) {
                this.mjb.setText((CharSequence) null);
            } else {
                this.mjb.setText(format);
            }
            postData.bnS().getUserTbVipInfoData();
            boolean a2 = a(this.mjd, postData.dNQ());
            if (StringUtils.isNull(postData.dNV()) && !a2 && postData.bHL() != null) {
                this.amu.setVisibility(0);
                this.amu.setTag(postData.bHL());
                return;
            }
            this.amu.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        String str;
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.byteLength(metaData.getSealPrefix()) + 2 : 0) + ag.getTextLength(name_show) > 14) {
                str = ag.subString(name_show, 0, 14);
                if (str.length() != name_show.length()) {
                    str = str + StringHelper.STRING_MORE;
                }
            } else {
                str = name_show;
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.eKp.setText(dT(metaData.getSealPrefix(), str));
            } else {
                this.eKp.setText(str);
            }
            if (metaData.getAlaUserData() != null && this.miZ != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.miZ.setVisibility(8);
                } else {
                    this.miZ.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.eIb = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.miZ.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                ap.setViewTextColor(this.eKp, R.color.cp_cont_r);
            } else {
                ap.setViewTextColor(this.eKp, R.color.CAM_X0108);
            }
            this.miY.setVisibility(0);
            this.miY.setUserId(metaData.getUserId());
            this.miY.setUserName(metaData.getUserName());
            this.miY.setDefaultResource(R.drawable.transparent_bg);
            UtilHelper.showHeadImageViewBigV(this.miY, metaData);
            this.miY.startLoad(metaData.getAvater(), 28, false);
            this.miX.setTag(R.id.tag_user_id, metaData.getUserId());
            this.miX.setTag(R.id.tag_user_name, metaData.getUserName());
            this.miX.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.bHD() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.bHD().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.p(next.bHK());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.lL(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.dWg());
                        continue;
                    case 17:
                        String str = next.bHO().mGifInfo.mSharpText;
                        if (str == null) {
                            continue;
                        } else if (str.startsWith("#(") && str.endsWith(")")) {
                            tbRichTextData.p("[" + str.substring(2, str.length() - 1) + "]");
                            break;
                        }
                        break;
                }
            }
        }
        if (!tbRichTextData.bHS()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.bHK() == null || tbRichTextData.bHK().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.bHK());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a2 = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.miU.getPageContext().getString(R.string.refresh_view_button_text), this.eJh));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.miU.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.miV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, l.getDimens(pageActivity, R.dimen.ds250)), dVar, a2);
        }
        this.gAY.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.kUH.bCt();
        ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.miU.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void Db(int i) {
        b(NoDataViewFactory.d.dS(null, this.miU.getResources().getString(R.string.refresh_view_title_text)));
        this.mjt.setVisibility(8);
    }

    public void aY(String str, boolean z) {
        if (z) {
            b(NoDataViewFactory.d.dS("", str));
        } else {
            b(NoDataViewFactory.d.dS(str, this.miU.getPageContext().getString(R.string.refresh_view_title_text)));
        }
        this.mjt.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.gAY.setVisibility(0);
            this.mjt.setVisibility(0);
            this.miS.setOnTouchListener(null);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        this.eJh = onClickListener;
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
        String userId;
        boolean z5;
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
                String userId2 = postData.bnS().getUserId();
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
            if (this.mhx != null && this.mhx.blp() != null && this.mhx.blp().bnS() != null && postData.bnS() != null) {
                String userId3 = this.mhx.blp().bnS().getUserId();
                String userId4 = postData.bnS().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z3 = false;
                        z4 = true;
                        z = true;
                    } else {
                        z3 = true;
                        z4 = false;
                        z = true;
                    }
                    userId = postData.bnS().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z3 = true;
                        z = true;
                    }
                    int i2 = postData.dNO() != 1 ? 0 : 1;
                    if (!z2) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.bnS() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.bnS().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.bnS().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.bnS().getPortrait());
                            z5 = true;
                        } else {
                            z5 = true;
                        }
                    } else {
                        sparseArray.put(R.id.tag_forbid_user_name, "");
                        sparseArray.put(R.id.tag_forbid_user_name_show, "");
                        sparseArray.put(R.id.tag_forbid_user_portrait, "");
                        z5 = false;
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_is_self, true);
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.getId());
                        z5 = true;
                    } else {
                        sparseArray.put(R.id.tag_del_post_is_self, false);
                        sparseArray.put(R.id.tag_del_post_type, 0);
                        sparseArray.put(R.id.tag_del_post_id, "");
                    }
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z2) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        if (postData.bnS() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.bnS().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.bnS().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.bnS().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.bnS() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bnS().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.bnS().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bnS().getName_show());
                        }
                        if (this.mhx.blp() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.mhx.blp().getId());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z) {
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
            z3 = false;
            z4 = false;
            userId = postData.bnS().getUserId();
            if (userId != null) {
                z3 = true;
                z = true;
            }
            if (postData.dNO() != 1) {
            }
            if (!z2) {
            }
            if (!z) {
            }
            sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (!z2) {
            }
            if (!z4) {
            }
            if (!z) {
            }
        }
    }

    public void wg(boolean z) {
        if (this.mir != null && this.mir.dpK() != null) {
            if (z) {
                this.mir.dpK().setText(R.string.remove_mark);
            } else {
                this.mir.dpK().setText(R.string.mark);
            }
        }
    }

    public View dsW() {
        return this.mjm;
    }

    public void onChangeSkinType(int i) {
        this.miU.getLayoutMode().setNightMode(i == 1);
        this.miU.getLayoutMode().onModeChanged(this.miS);
        this.miU.getLayoutMode().onModeChanged(this.miT);
        ap.setBackgroundColor(this.miS, R.color.CAM_X0201);
        ap.setBackgroundColor(this.miV, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.miU.getPageContext(), i);
        WebPManager.a(this.eJc, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        if (this.miW != null) {
            ap.setViewTextColor(this.miW, R.color.goto_see_subject_color);
        }
        this.fNp.onChangeSkinType(this.miU.getPageContext(), i);
        this.miU.getLayoutMode().onModeChanged(this.mjm);
        ap.setViewTextColor(this.mjd, R.color.CAM_X0105);
        this.mjd.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        if (this.kUH != null && this.kUH.bBk() != null) {
            this.kUH.bBk().onChangeSkinType(i);
        }
        this.mjh.changeSkin(i);
        this.amu.bur();
        ap.setViewTextColor(this.jDr, R.color.CAM_X0110);
        ap.setViewTextColor(this.meE, R.color.CAM_X0302);
        ap.setViewTextColor(this.eKp, R.color.CAM_X0108);
        this.jDr.setAlpha(0.95f);
        if (this.mji != null) {
            com.baidu.tbadk.r.a.a(this.miU.getPageContext(), this.mji);
        }
        if (this.mjy != null) {
            this.mjy.notifyDataSetChanged();
        }
        this.miU.getLayoutMode().onModeChanged(this.mjk);
        ap.setBackgroundColor(this.mbO, R.color.CAM_X0203);
        this.mbR.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.mbQ.setBackgroundDrawable(ap.aL(l.getDimens(this.miU, R.dimen.tbds47), ap.getColor(R.color.CAM_X0209)));
    }

    public void dsX() {
        this.mProgress.setVisibility(0);
    }

    public void dsY() {
        this.gAY.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.mjh.endLoadData();
    }

    public void czE() {
        this.gAY.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.mjh.czE();
    }

    public boolean dsZ() {
        return this.miS.dsZ();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mjy.c(onLongClickListener);
    }

    public View dta() {
        return this.miT;
    }

    public TextView cIL() {
        return this.jDr;
    }

    public ImageView dtb() {
        return this.mju;
    }

    public ImageView dtc() {
        return this.mjv;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void Gs(int i) {
    }

    public View dtd() {
        return this.miW;
    }

    public View dte() {
        return this.mje;
    }

    public MorePopupWindow dtf() {
        return this.mjj;
    }

    public void showLoadingDialog() {
        if (this.iFD == null) {
            this.iFD = new com.baidu.tbadk.core.view.a(this.miU.getPageContext());
        }
        this.iFD.setDialogVisiable(true);
    }

    public void ckD() {
        if (this.iFD != null) {
            this.iFD.setDialogVisiable(false);
        }
    }

    public TextView dtg() {
        return this.mjd;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.mjy.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.mjy != null) {
            this.mjy.notifyDataSetChanged();
        }
    }

    public aa dth() {
        return this.mir;
    }

    public void cLe() {
    }

    public void cLf() {
    }

    public void cJm() {
        if (this.miS != null) {
            this.miS.onDestroy();
        }
        if (this.kUH != null) {
            this.kUH.onDestory();
        }
    }

    public void dti() {
        if (this.miU.isPaused()) {
        }
    }

    public View dtj() {
        return this.miX;
    }

    private SpannableStringBuilder dT(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a((Context) this.miU.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int dtk() {
        if (this.kUH == null || this.kUH.bBk() == null) {
            return 0;
        }
        return this.kUH.bBk().getHeight();
    }

    public int dtl() {
        if (this.mjn == null) {
            return 0;
        }
        return this.mjn.getHeight();
    }

    public void dtm() {
        if (this.jDr != null && this.kUH != null) {
            if (this.kUH.bCy()) {
                this.jDr.setText(R.string.draft_to_send);
            } else {
                this.jDr.setText(this.miU.dqD());
            }
        }
    }

    public void vp(boolean z) {
        if (this.mbR != null) {
            this.mbR.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.fkY = cVar;
        if (this.mbu != null) {
            this.mbu.setListPullRefreshListener(cVar);
        }
    }
}
