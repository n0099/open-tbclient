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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
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
import com.baidu.tbadk.editortools.pb.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.main.am;
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.c;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.i;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class b implements KeyboardEventLayout.a {
    private static final int icS = TbadkCoreApplication.getInst().getListItemRule().amK();
    private RelativeLayout dNV;
    private com.baidu.tbadk.core.view.b eOg;
    private TextView fLH;
    private com.baidu.tieba.NEGFeedBack.e fXS;
    private View fio;
    private NoNetworkView frZ;
    private k ibw;
    private a icK;
    private View icT;
    private NewSubPbActivity icU;
    private RelativeLayout icV;
    private View icZ;
    private SubPbModel icw;
    private y icz;
    private ImageView idA;
    private d idE;
    private ThreadSkinView idg;
    private e idh;
    private View idi;
    private View idk;
    private View ido;
    private com.baidu.tbadk.core.dialog.b idq;
    private ArrayList<PostData> idw;
    private String idx;
    private RelativeLayout idy;
    private ImageView idz;
    private View.OnClickListener mCommonClickListener;
    private BdTypeListView mListView;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener bCL = null;
    private TbRichTextView.i icB = null;
    private NavigationBar mNavigationBar = null;
    private View cgb = null;
    private TextView icW = null;
    private LinearLayout icX = null;
    private HeadImageView icY = null;
    private ClickableHeaderImageView hWQ = null;
    private TextView cdZ = null;
    private ImageView ida = null;
    private TextView hWI = null;
    private TextView idb = null;
    private TextView idc = null;
    private EllipsizeRichTextView idd = null;
    private TbImageView ide = null;
    private PlayVoiceBntNew Ym = null;
    private TextView idf = null;
    private MorePopupWindow idj = null;
    private am idm = null;
    private com.baidu.tbadk.core.dialog.b idn = null;
    private Dialog idp = null;
    private com.baidu.tbadk.core.dialog.a hXq = null;
    private boolean hPK = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener cpT = null;
    private NewSubPbActivity.a idr = null;
    private NewSubPbActivity.a idu = null;
    private g gYS = null;
    private String idv = null;
    private int cMY = 0;
    private PostData hLl = null;
    private int idB = 0;
    private int idC = 2;
    private int idD = 0;
    private boolean cts = true;
    private View.OnClickListener hPT = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 1);
                        b.this.icU.c(sparseArray);
                        return;
                    }
                    b.this.cE(view);
                } else if (booleanValue2) {
                    sparseArray.put(R.id.tag_from, 0);
                    b.this.icU.c(sparseArray);
                } else if (booleanValue3) {
                    b.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c cmw = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.b.4
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            b.this.kE(false);
            b.this.bW(view);
            b.this.kE(true);
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean d(View view, MotionEvent motionEvent) {
            return true;
        }
    });
    protected AdapterView.OnItemLongClickListener idF = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.c(b.this.idw, i);
            if (view == null || view.getTag() == null) {
                return false;
            }
            if (b.this.icz == null) {
                b.this.icz = new y(b.this.icU.getPageContext(), b.this.mCommonClickListener);
            }
            b.this.icz.showDialog();
            SparseArray<Object> sparseArray = null;
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray == null) {
                return true;
            }
            boolean or = b.this.or(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) & TbadkCoreApplication.isLogin();
            b.this.icz.a(sparseArray, b.this.icw.bTK(), or);
            if (or) {
                b.this.icz.bXr().setVisibility(0);
                b.this.icz.bXr().setTag(postData.getId());
            } else {
                b.this.icz.bXr().setVisibility(8);
            }
            b.this.icz.bXp().setVisibility(8);
            return false;
        }
    };
    protected AdapterView.OnItemClickListener idG = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (bc.cF(b.this.icU.getPageContext().getPageActivity())) {
                if (b.this.icU.gYK == null || b.this.icw == null || b.this.icw.blT() == null || b.this.icU.gYK.m19if(b.this.icw.blT().replyPrivateFlag)) {
                    if (b.this.icK != null) {
                        b.this.icK.bqW();
                    }
                    b.this.bZW();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) v.c(b.this.idw, i);
                        if (postData == null) {
                            b.this.idx = null;
                        } else {
                            b.this.idx = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(R.id.tag_photo_username);
                            String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                            if (str != null) {
                                b.this.gYS.setReplyId(str2);
                                b.this.gYS.qI(str);
                            }
                        }
                        b.this.bZX();
                        return;
                    }
                    b.this.bZY();
                    b.this.icw.cau();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.dNV = null;
        this.icT = null;
        this.mListView = null;
        this.icU = null;
        this.frZ = null;
        this.icV = null;
        this.icZ = null;
        this.idh = null;
        this.ido = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.fLH = null;
        this.idy = null;
        this.idz = null;
        this.idA = null;
        this.icU = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dNV = (RelativeLayout) LayoutInflater.from(this.icU.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.icT = LayoutInflater.from(this.icU.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.idy = (RelativeLayout) this.dNV.findViewById(R.id.subpb_editor_tool_comment);
        this.fLH = (TextView) this.dNV.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.fLH.setOnClickListener(this.mCommonClickListener);
        this.idz = (ImageView) this.dNV.findViewById(R.id.subpb_editor_tool_more_img);
        this.idA = (ImageView) this.dNV.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.idA.setOnClickListener(this.mCommonClickListener);
        this.idz.setOnClickListener(this.mCommonClickListener);
        this.frZ = (NoNetworkView) this.dNV.findViewById(R.id.view_no_network);
        bre();
        bkI();
        this.icV = (RelativeLayout) this.dNV.findViewById(R.id.sub_pb_body_layout);
        this.mListView = (BdTypeListView) this.dNV.findViewById(R.id.new_sub_pb_list);
        this.idg = (ThreadSkinView) LayoutInflater.from(this.icU.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.mListView.addHeaderView(this.idg);
        this.mListView.addHeaderView(this.icT);
        this.fio = BdListViewHelper.a(this.icU.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.idh = new e(this.icU.getPageContext());
        this.idh.akO();
        this.ido = this.idh.getView();
        this.mListView.setNextPage(this.idh);
        this.idh.setOnClickListener(this.mCommonClickListener);
        this.mListView.setOnItemClickListener(this.idG);
        this.mListView.setOnItemLongClickListener(this.idF);
        this.mListView.setOnTouchListener(this.cmw);
        this.mProgress = (ProgressBar) this.dNV.findViewById(R.id.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.icT != null) {
            this.icT.setVisibility(4);
        }
        if (this.icV != null) {
            this.icV.setVisibility(4);
        }
        this.icZ = com.baidu.tbadk.ala.b.aao().n(this.icU.getActivity(), 4);
        if (this.icZ != null) {
            this.icZ.setVisibility(8);
            this.icX.addView(this.icZ, 3);
        }
        this.idE = new d(this.icU, this.mListView);
        this.idE.setFromCDN(this.mIsFromCDN);
        this.idE.v(this.mCommonClickListener);
        this.idE.initAdapters();
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void bkI() {
        this.icX = (LinearLayout) this.icT.findViewById(R.id.subpb_head_user_info_root);
        this.icX.setOnClickListener(this.mCommonClickListener);
        this.icY = (HeadImageView) this.icT.findViewById(R.id.photo);
        this.icY.setRadius(l.g(this.icU.getActivity(), R.dimen.ds30));
        this.icY.setClickable(false);
        this.hWQ = (ClickableHeaderImageView) this.icT.findViewById(R.id.god_user_photo);
        this.hWQ.setGodIconMargin(0);
        this.hWQ.setGodIconWidth(R.dimen.ds24);
        this.hWQ.setRadius(l.g(this.icU.getActivity(), R.dimen.ds30));
        this.hWQ.setClickable(false);
        this.cdZ = (TextView) this.icT.findViewById(R.id.user_name);
        this.ida = (ImageView) this.icT.findViewById(R.id.user_rank);
        this.ida.setVisibility(8);
        this.hWI = (TextView) this.icT.findViewById(R.id.floor_owner);
        this.icW = (TextView) this.icT.findViewById(R.id.see_subject);
        this.icW.setOnClickListener(this.mCommonClickListener);
        this.idb = (TextView) this.icT.findViewById(R.id.floor);
        this.idc = (TextView) this.icT.findViewById(R.id.time);
        this.idd = (EllipsizeRichTextView) this.icT.findViewById(R.id.content_text);
        this.idd.setOnClickListener(this.mCommonClickListener);
        com.baidu.tbadk.core.util.am.j(this.idd, R.color.cp_cont_b);
        this.idd.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
        this.idd.setLineSpacing(0.0f, 1.25f);
        this.ide = (TbImageView) this.icT.findViewById(R.id.sub_pb_image);
        this.ide.setOnClickListener(this.mCommonClickListener);
        this.idf = (TextView) this.icT.findViewById(R.id.advert);
        this.Ym = (PlayVoiceBntNew) this.icT.findViewById(R.id.voice_btn);
        this.icT.setOnTouchListener(this.cmw);
        this.icT.setOnClickListener(this.mCommonClickListener);
    }

    public void kG(boolean z) {
        if (this.fio != null && this.fio.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fio.getLayoutParams();
            if (z) {
                bri();
                layoutParams.height = l.g(this.icU.getPageContext().getPageActivity(), R.dimen.ds88);
            } else {
                layoutParams.height = l.g(this.icU.getPageContext().getPageActivity(), R.dimen.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.fio.setLayoutParams(layoutParams);
        }
    }

    private void bri() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.ajv().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void a(b.a aVar, boolean z) {
        if (this.idq != null) {
            this.idq.dismiss();
            this.idq = null;
        }
        this.idq = new com.baidu.tbadk.core.dialog.b(this.icU.getPageContext().getPageActivity());
        if (z) {
            this.idq.a(new String[]{this.icU.getPageContext().getString(R.string.save_to_emotion)}, aVar);
        } else {
            this.idq.a(new String[]{this.icU.getPageContext().getString(R.string.save_to_emotion), this.icU.getPageContext().getString(R.string.save_to_local)}, aVar);
        }
        this.idq.d(this.icU.getPageContext());
        this.idq.agR();
    }

    public void cJ(View view) {
        this.idi = view;
    }

    public View bgK() {
        return this.fio;
    }

    public void bre() {
        int g = l.g(this.icU.getPageContext().getPageActivity(), R.dimen.ds88);
        int g2 = l.g(this.icU.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.dNV.findViewById(R.id.view_navigation_bar);
        this.cgb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cgb.getLayoutParams();
            layoutParams.height = g;
            layoutParams.width = g;
            layoutParams.leftMargin = g2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.cgb != null && (this.cgb.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cgb.getLayoutParams();
            layoutParams2.width = g;
            layoutParams2.height = g;
            this.cgb.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.ajv().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mNavigationBar.hideBottomLine();
    }

    public NavigationBar aLN() {
        return this.mNavigationBar;
    }

    public void cE(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.idp == null) {
            this.idp = new Dialog(this.icU.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.idp.setCanceledOnTouchOutside(true);
            this.idp.setCancelable(true);
            this.idk = LayoutInflater.from(this.icU.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.icU.getLayoutMode().onModeChanged(this.idk);
            this.idp.setContentView(this.idk);
            WindowManager.LayoutParams attributes = this.idp.getWindow().getAttributes();
            attributes.width = (int) (l.af(this.icU.getPageContext().getPageActivity()) * 0.9d);
            this.idp.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.idp.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.idp.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.idp.findViewById(R.id.disable_reply_btn);
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
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.idp != null && (b.this.idp instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.idp, b.this.icU.getPageContext());
                    }
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null) {
                        b.this.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.idp != null && (b.this.idp instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.idp, b.this.icU.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.idr != null) {
                        b.this.idr.m(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.idp != null && (b.this.idp instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.idp, b.this.icU.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.icU.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.idp, this.icU.getPageContext());
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
        this.hXq = new com.baidu.tbadk.core.dialog.a(this.icU.getPageContext().getPageActivity());
        this.hXq.hv(i3);
        this.hXq.ab(sparseArray);
        this.hXq.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.idu != null) {
                    b.this.idu.m(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.hXq.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hXq.dQ(true);
        this.hXq.b(this.icU.getPageContext());
        if (z) {
            this.hXq.agO();
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData blT;
        if (this.icU != null && sparseArray != null && this.icT != null) {
            if (this.fXS == null) {
                this.fXS = new com.baidu.tieba.NEGFeedBack.e(this.icU.getPageContext(), this.icT);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.icw != null && (blT = this.icw.blT()) != null && blT.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = blT.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            aj ajVar = new aj();
            ajVar.b(sparseArray2);
            this.fXS.setDefaultReasonArray(new String[]{this.icU.getString(R.string.delete_thread_reason_1), this.icU.getString(R.string.delete_thread_reason_2), this.icU.getString(R.string.delete_thread_reason_3), this.icU.getString(R.string.delete_thread_reason_4), this.icU.getString(R.string.delete_thread_reason_5)});
            this.fXS.setData(ajVar);
            this.fXS.rU("4");
            this.fXS.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.b.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void C(JSONArray jSONArray) {
                    String y = aq.y(jSONArray);
                    if (b.this.idu != null) {
                        b.this.idu.m(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), y});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kE(final boolean z) {
        if (this.mListView != null) {
            if (!z) {
                this.mListView.setEnabled(z);
            } else {
                this.mListView.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.b.11
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mListView.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.idr = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.idu = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.icU.showToast(this.icU.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.icU.showToast(str);
        }
    }

    public void bW(View view) {
        if (this.fio != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.fio.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.fio);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.fio.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.icU.getActivity(), R.dimen.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.fio, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.asm() != null) {
            this.gYS = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dNV.addView(gVar.asm(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.icK = aVar;
    }

    public void bZW() {
        if (this.mListView != null) {
            this.idD = this.mListView.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean or(boolean z) {
        if (this.icw == null || this.icw.car() == null) {
            return false;
        }
        if (this.icw.bTK() != 0) {
            return false;
        }
        return (this.ibw == null || this.ibw.acC() == null || this.ibw.acC().aeC() == null || !TextUtils.equals(this.ibw.acC().aeC().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void bZX() {
        if (this.icw != null) {
            if ((!caa() && this.ido != null && this.ido.isShown()) || v.aa(this.idw)) {
                this.icw.pw(false);
            } else {
                this.icw.pw(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.icw = subPbModel;
    }

    public void bZY() {
        b(this.icU);
        this.mListView.setNextPage(this.idh);
    }

    public void p(PostData postData) {
        int i;
        if (postData != null) {
            postData.rg(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!caa() && this.ido != null && this.ido.isShown()) {
                i = (this.idD - this.idC) - 1;
            } else {
                i = this.idD - this.idC;
            }
            int Z = v.Z(this.idw);
            if (i > Z) {
                i = Z;
            }
            ArrayList arrayList = new ArrayList(v.c(this.idw, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.mListView.smoothScrollToPosition(this.idD + 2);
            this.mListView.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.dNV;
    }

    public void bYL() {
        if (this.idj != null) {
            com.baidu.adp.lib.g.g.a(this.idj, this.icU.getPageContext().getPageActivity());
        }
        if (this.idn != null) {
            this.idn.dismiss();
        }
        if (this.hXq != null) {
            this.hXq.dismiss();
        }
        if (this.idp != null) {
            com.baidu.adp.lib.g.g.b(this.idp, this.icU.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.icz != null) {
            this.icz.dismiss();
        }
    }

    public void bZZ() {
        this.mListView.setNextPage(this.idh);
        this.idh.akR();
    }

    public void ok(boolean z) {
        this.hPK = z;
    }

    public void setIsFromPb(boolean z) {
        this.cts = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v36, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(k kVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (kVar != null) {
            if (this.cts && this.icT != null) {
                this.icT.setVisibility(8);
                this.mListView.removeHeaderView(this.icT);
                this.idC = 1;
            }
            this.ibw = kVar;
            if (this.icT != null) {
                this.icT.setVisibility(0);
            }
            if (this.icV != null) {
                this.icV.setVisibility(0);
            }
            if (kVar.bUh() != null) {
                this.idv = kVar.bUh().getId();
                this.cMY = kVar.bUh().cqz();
                if (this.cMY > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.icU.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.cMY)));
                    if (this.icU != null) {
                        this.fLH.setText(this.icU.bYa());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = this.icU.bZU() ? "PB" : null;
                if (kVar.bUh().aeX() != null) {
                    this.idg.setData(this.icU.getPageContext(), kVar.bUh().aeX(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", kVar.bUn().getId(), kVar.bUn().getName(), kVar.acC().getId(), str));
                } else {
                    this.idg.setData(null, null, null);
                }
            }
            if (kVar.hasMore()) {
                this.idh.akR();
                this.idE.setHasMoreData(true);
            } else {
                this.idh.akS();
                this.idE.setHasMoreData(false);
            }
            this.idw = kVar.bUl();
            if (this.idw == null || this.idw.size() <= icS) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.idw.size() - icS;
                ys(size);
                int firstVisiblePosition = this.mListView.getFirstVisiblePosition() - size;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.idw);
            if (v.aa(this.idw)) {
                this.mListView.setNextPage(null);
                if (this.cts) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.mListView.setNextPage(this.idh);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(kVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.cts) {
                arrayList.add(0, kVar.bUh());
            }
            this.idE.b(this.ibw.acC(), arrayList);
            a(kVar.bUh(), kVar.bGN(), kVar.aaF(), i, z);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void ys(int i) {
        if (this.idw != null) {
            if (this.idw.size() <= i) {
                this.idw.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.idw.iterator();
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

    public boolean caa() {
        return this.idE.KF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.cts) {
            this.hLl = postData;
            if (!StringUtils.isNull(postData.cqG())) {
                this.ide.setVisibility(0);
                this.ide.startLoad(postData.cqG(), 10, true);
            } else {
                this.ide.setVisibility(8);
            }
            i cqI = postData.cqI();
            if (cqI != null && cqI.jih) {
                this.idf.setVisibility(0);
            } else {
                this.idf.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.icT.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.icT.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.idb.setText((CharSequence) null);
            this.cdZ.setText((CharSequence) null);
            this.hWI.setVisibility(8);
            if (!this.cts) {
                c(postData.aeC());
                if (z) {
                    this.hWI.setVisibility(0);
                    com.baidu.tbadk.core.util.am.j(this.hWI, R.color.cp_link_tip_a);
                }
            }
            this.idc.setText(aq.aD(postData.getTime()));
            this.idb.setText(String.format(this.icU.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.cqz())));
            postData.aeC().getUserTbVipInfoData();
            boolean a = a(this.idd, postData.cqB());
            if (StringUtils.isNull(postData.cqG()) && !a && postData.azi() != null) {
                this.Ym.setVisibility(0);
                this.Ym.setTag(postData.azi());
                return;
            }
            this.Ym.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.k.bk(metaData.getSealPrefix()) + 2 : 0) + aa.ry(name_show) > 14) {
                name_show = aa.p(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.cdZ.setText(bY(metaData.getSealPrefix(), name_show));
            } else {
                this.cdZ.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.icZ != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.icZ.setVisibility(8);
                } else {
                    this.icZ.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bBl = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.icZ.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.hWQ.setVisibility(0);
                this.icY.setVisibility(8);
                this.hWQ.setUserId(metaData.getUserId());
                this.hWQ.setUserName(metaData.getUserName());
                this.hWQ.startLoad(metaData.getPortrait(), 28, false);
                com.baidu.tbadk.core.util.am.j(this.cdZ, R.color.cp_cont_r);
            } else {
                this.hWQ.setVisibility(8);
                this.icY.setVisibility(0);
                this.icY.setUserId(metaData.getUserId());
                this.icY.setUserName(metaData.getUserName());
                this.icY.setDefaultResource(R.drawable.transparent_bg);
                this.icY.setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.icY.startLoad(metaData.getPortrait(), 28, false);
                com.baidu.tbadk.core.util.am.j(this.cdZ, R.color.cp_cont_c);
            }
            this.icX.setTag(R.id.tag_user_id, metaData.getUserId());
            this.icX.setTag(R.id.tag_user_name, metaData.getUserName());
            this.icX.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.ayZ() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.ayZ().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.k(next.azh());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.fY(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.czb());
                        continue;
                    case 17:
                        String str = next.azl().mGifInfo.mSharpText;
                        if (str == null) {
                            continue;
                        } else if (str.startsWith("#(") && str.endsWith(")")) {
                            tbRichTextData.k("[" + str.substring(2, str.length() - 1) + "]");
                            break;
                        }
                        break;
                }
            }
        }
        if (!tbRichTextData.azq()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.azh() == null || tbRichTextData.azh().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.azh());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.icU.getPageContext().getString(R.string.refresh_view_title_text), this.bCL));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.icU.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.icV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, R.drawable.new_pic_emotion_07, l.g(pageActivity, R.dimen.ds250), l.g(pageActivity, R.dimen.ds480), l.g(pageActivity, R.dimen.ds360)), dVar, a);
        }
        this.icV.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.gYS.atj();
        com.baidu.tbadk.core.util.am.l(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.icU.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void pb(int i) {
        b(NoDataViewFactory.d.ag(i, R.string.refresh_view_title_text));
        if (this.icK != null) {
            this.icK.cH(this.dNV);
        }
        this.idy.setVisibility(8);
    }

    public void vP(String str) {
        b(NoDataViewFactory.d.bX(str, this.icU.getPageContext().getString(R.string.refresh_view_title_text)));
        if (this.icK != null) {
            this.icK.cH(this.dNV);
        }
        this.idy.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            this.idy.setVisibility(0);
            this.dNV.setOnTouchListener(null);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.bCL = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0296  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PostData postData, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        String userId;
        boolean z4;
        boolean z5;
        if (postData != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            boolean z6 = false;
            boolean z7 = false;
            if (i != 0) {
                if (i != 3) {
                    z6 = true;
                    z7 = true;
                }
                String userId2 = postData.aeC().getUserId();
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z6 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z6 = false;
                }
            }
            if (this.ibw != null && this.ibw.acC() != null && this.ibw.acC().aeC() != null && postData.aeC() != null) {
                String userId3 = this.ibw.acC().aeC().getUserId();
                String userId4 = postData.aeC().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    userId = postData.aeC().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z3 = true;
                    }
                    int i2 = 1;
                    if (postData.cqz() == 1) {
                        i2 = 0;
                    }
                    if (ap.m(postData)) {
                        z4 = z6;
                    } else {
                        z2 = false;
                        z = false;
                        z4 = false;
                    }
                    if (!z4) {
                        z5 = true;
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.aeC() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aeC().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aeC().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aeC().getPortrait());
                        }
                    } else {
                        z5 = false;
                        sparseArray.put(R.id.tag_forbid_user_name, "");
                        sparseArray.put(R.id.tag_forbid_user_name_show, "");
                        sparseArray.put(R.id.tag_forbid_user_portrait, "");
                    }
                    if (!z2) {
                        z5 = true;
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_is_self, true);
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(R.id.tag_del_post_is_self, false);
                        sparseArray.put(R.id.tag_del_post_type, 0);
                        sparseArray.put(R.id.tag_del_post_id, "");
                    }
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z4) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        if (postData.aeC() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aeC().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aeC().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aeC().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aeC() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aeC().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aeC().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aeC().getName_show());
                        }
                        if (this.ibw.acC() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.ibw.acC().getId());
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
            z2 = z7;
            z3 = false;
            userId = postData.aeC().getUserId();
            if (userId != null) {
                z2 = true;
                z3 = true;
            }
            int i22 = 1;
            if (postData.cqz() == 1) {
            }
            if (ap.m(postData)) {
            }
            if (!z4) {
            }
            if (!z2) {
            }
            sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (!z4) {
            }
            if (!z) {
            }
            if (!z2) {
            }
        }
    }

    public void pu(boolean z) {
        if (this.icz != null && this.icz.bXp() != null) {
            if (z) {
                this.icz.bXp().setText(R.string.remove_mark);
            } else {
                this.icz.bXp().setText(R.string.mark);
            }
        }
    }

    public View cab() {
        return this.ido;
    }

    public void onChangeSkinType(int i) {
        this.icU.getLayoutMode().setNightMode(i == 1);
        this.icU.getLayoutMode().onModeChanged(this.dNV);
        this.icU.getLayoutMode().onModeChanged(this.icT);
        this.mNavigationBar.onChangeSkinType(this.icU.getPageContext(), i);
        if (this.icW != null) {
            com.baidu.tbadk.core.util.am.j(this.icW, R.color.goto_see_subject_color);
        }
        this.frZ.onChangeSkinType(this.icU.getPageContext(), i);
        this.icU.getLayoutMode().onModeChanged(this.ido);
        com.baidu.tbadk.core.util.am.j(this.idd, R.color.cp_cont_b);
        this.idd.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
        if (this.gYS != null && this.gYS.asm() != null) {
            this.gYS.asm().onChangeSkinType(i);
        }
        this.idh.iY(i);
        this.Ym.bql();
        com.baidu.tbadk.core.util.am.j(this.fLH, R.color.cp_cont_e);
        com.baidu.tbadk.core.util.am.j(this.hWI, R.color.cp_link_tip_a);
        com.baidu.tbadk.core.util.am.j(this.cdZ, R.color.cp_cont_c);
        this.fLH.setAlpha(0.95f);
        if (this.idi != null) {
            com.baidu.tbadk.s.a.a(this.icU.getPageContext(), this.idi);
        }
        if (this.idE != null) {
            this.idE.notifyDataSetChanged();
        }
        this.icU.getLayoutMode().onModeChanged(this.idk);
    }

    public void cac() {
        this.mProgress.setVisibility(0);
    }

    public void cad() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.idh.akS();
    }

    public void bjk() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.idh.bjk();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cpT = onLongClickListener;
        this.idE.c(onLongClickListener);
    }

    public View cae() {
        return this.icT;
    }

    public TextView brj() {
        return this.fLH;
    }

    public ImageView caf() {
        return this.idz;
    }

    public ImageView cag() {
        return this.idA;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void yt(int i) {
    }

    public View cah() {
        return this.icW;
    }

    public View cai() {
        return this.ide;
    }

    public MorePopupWindow caj() {
        return this.idj;
    }

    public void showLoadingDialog() {
        if (this.eOg == null) {
            this.eOg = new com.baidu.tbadk.core.view.b(this.icU.getPageContext());
        }
        this.eOg.em(true);
    }

    public void aVf() {
        if (this.eOg != null) {
            this.eOg.em(false);
        }
    }

    public TextView cak() {
        return this.idd;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.icB = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.idE.setOnImageClickListener(hVar);
    }

    public void notifyDataSetChanged() {
        if (this.idE != null) {
            this.idE.notifyDataSetChanged();
        }
    }

    public y cal() {
        return this.icz;
    }

    public void btm() {
    }

    public void btn() {
    }

    public void aGu() {
    }

    public void cam() {
        if (this.icU.isPaused()) {
        }
    }

    public View can() {
        return this.icX;
    }

    private SpannableStringBuilder bY(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return n.a((Context) this.icU.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int cao() {
        if (this.gYS == null || this.gYS.asm() == null) {
            return 0;
        }
        return this.gYS.asm().getHeight();
    }
}
