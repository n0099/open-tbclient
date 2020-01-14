package com.baidu.tieba.pb.videopb.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.d;
import com.baidu.tbadk.switchs.FansCallSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.ab;
import com.baidu.tieba.pb.pb.main.ac;
import com.baidu.tieba.pb.pb.main.au;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes7.dex */
public class a {
    private List<CustomBlueCheckRadioButton> fJv;
    private e gOh;
    private au gOz;
    private String iCs;
    private com.baidu.tieba.pb.pb.report.a iFU;
    private i iGc;
    private k iGd;
    public BdUniqueId iGs;
    private com.baidu.adp.widget.ImageView.a iGu;
    private String iGv;
    private TbRichTextMemeInfo iGw;
    private PbFragment.b iOf;
    public VideoPbFragment iYs;
    private Object mExtra;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private Runnable runnable;
    public static int iNx = 3;
    public static int iNy = 0;
    public static int iNz = 3;
    public static int iNA = 4;
    public static int iNB = 5;
    public static int iNC = 6;
    private i iMT = null;
    private com.baidu.tbadk.core.dialog.a iML = null;
    private Dialog iMM = null;
    private Dialog iMN = null;
    private View iMO = null;
    private LinearLayout iMP = null;
    private TextView iMQ = null;
    private TextView iMR = null;
    private String iMS = null;
    private ScrollView iMW = null;
    private CompoundButton.OnCheckedChangeListener fJw = null;
    private i iMK = null;
    private com.baidu.tbadk.core.view.a fNy = null;
    private com.baidu.tbadk.core.dialog.b iFB = null;
    private AlertDialog iSw = null;
    private ab iSx = null;
    PostData hfx = null;
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.12
        /* JADX WARN: Removed duplicated region for block: B:32:0x00af A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x01fe  */
        @Override // android.view.View.OnLongClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onLongClick(View view) {
            boolean z;
            boolean z2;
            g gVar;
            g gVar2;
            SparseArray sparseArray;
            if (a.this.iYs == null || !a.this.iYs.isAdded()) {
                return true;
            }
            SparseArray sparseArray2 = null;
            try {
                sparseArray2 = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray2 == null) {
                if (a.this.cw(view)) {
                    if (view instanceof TbImageView) {
                        a.this.iGu = ((TbImageView) view).getBdImage();
                        a.this.iGv = ((TbImageView) view).getUrl();
                        if (a.this.iGu == null || TextUtils.isEmpty(a.this.iGv)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.iGw = null;
                        } else {
                            a.this.iGw = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            a.this.iGu = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                a.this.iGv = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                a.this.iGw = null;
                            } else {
                                a.this.iGw = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        a.this.iGu = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            a.this.iGv = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.iGw = null;
                        } else {
                            a.this.iGw = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    }
                    if (view.getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                        } catch (ClassCastException e2) {
                            e2.printStackTrace();
                            sparseArray = sparseArray2;
                        }
                    } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                        a.this.a(a.this.iHf, a.this.iGu.isGif());
                    } else {
                        try {
                            sparseArray = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray = sparseArray2;
                        }
                    }
                    if (sparseArray != null) {
                        return true;
                    }
                    sparseArray2 = sparseArray;
                }
                sparseArray = sparseArray2;
                if (sparseArray != null) {
                }
            }
            a.this.hfx = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (a.this.hfx == null || a.this.iYs.crq() == null) {
                return true;
            }
            if (!a.this.iYs.crq().aww() || a.this.hfx.getId() == null || !a.this.hfx.getId().equals(a.this.iYs.ckc().aAg())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = a.this.iYs.ckc().getPbData() != null && a.this.iYs.ckc().getPbData().cjs();
            if (a.this.iGd == null) {
                a.this.iGd = new k(a.this.iYs.getContext());
                a.this.iGd.a(a.this.iHg);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = a.this.cw(view) && !z3;
                boolean z5 = (!a.this.cw(view) || a.this.iGu == null || a.this.iGu.isGif()) ? false : true;
                boolean z6 = false;
                boolean z7 = false;
                boolean z8 = false;
                boolean z9 = false;
                boolean z10 = false;
                String str = null;
                if (!(sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean)) {
                    z2 = false;
                } else {
                    z2 = ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue();
                }
                if (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                    z6 = ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue();
                }
                if (sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                    z7 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
                }
                if (sparseArray2.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                    z8 = ((Boolean) sparseArray2.get(R.id.tag_should_manage_visible)).booleanValue();
                }
                if (sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                    z9 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
                }
                if (sparseArray2.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                    z10 = ((Boolean) sparseArray2.get(R.id.tag_should_delete_visible)).booleanValue();
                }
                if (sparseArray2.get(R.id.tag_forbid_user_post_id) instanceof String) {
                    str = (String) sparseArray2.get(R.id.tag_forbid_user_post_id);
                }
                if (z4) {
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), a.this.iGd));
                }
                if (z5) {
                    arrayList.add(new g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), a.this.iGd));
                }
                if (!z4 && !z5) {
                    g gVar3 = new g(3, TbadkCoreApplication.getInst().getString(R.string.copy), a.this.iGd);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, a.this.hfx);
                    gVar3.mTextView.setTag(sparseArray3);
                    arrayList.add(gVar3);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), a.this.iGd);
                    } else {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.mark), a.this.iGd);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, a.this.hfx);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar2.mTextView.setTag(sparseArray4);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z8 && z7) {
                        g gVar4 = new g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), a.this.iGd);
                        SparseArray sparseArray5 = new SparseArray();
                        sparseArray5.put(R.id.tag_user_mute_visible, true);
                        sparseArray5.put(R.id.tag_is_mem, sparseArray2.get(R.id.tag_is_mem));
                        sparseArray5.put(R.id.tag_user_mute_mute_userid, sparseArray2.get(R.id.tag_user_mute_mute_userid));
                        sparseArray5.put(R.id.tag_user_mute_mute_username, sparseArray2.get(R.id.tag_user_mute_mute_username));
                        sparseArray5.put(R.id.tag_user_mute_mute_nameshow, sparseArray2.get(R.id.tag_user_mute_mute_nameshow));
                        sparseArray5.put(R.id.tag_user_mute_post_id, sparseArray2.get(R.id.tag_user_mute_post_id));
                        sparseArray5.put(R.id.tag_user_mute_thread_id, sparseArray2.get(R.id.tag_user_mute_thread_id));
                        sparseArray5.put(R.id.tag_del_post_is_self, sparseArray2.get(R.id.tag_del_post_is_self));
                        sparseArray5.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                        sparseArray5.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                        sparseArray5.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                        gVar4.mTextView.setTag(sparseArray5);
                        arrayList.add(gVar4);
                    } else {
                        if ((a.this.pI(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                            g gVar5 = new g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.iGd);
                            gVar5.mTextView.setTag(str);
                            arrayList.add(gVar5);
                        }
                    }
                    g gVar6 = null;
                    if (z8) {
                        SparseArray sparseArray6 = new SparseArray();
                        sparseArray6.put(R.id.tag_should_manage_visible, true);
                        sparseArray6.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                        sparseArray6.put(R.id.tag_forbid_user_name, sparseArray2.get(R.id.tag_forbid_user_name));
                        sparseArray6.put(R.id.tag_forbid_user_name_show, sparseArray2.get(R.id.tag_forbid_user_name_show));
                        sparseArray6.put(R.id.tag_forbid_user_portrait, sparseArray2.get(R.id.tag_forbid_user_portrait));
                        sparseArray6.put(R.id.tag_forbid_user_post_id, str);
                        if (z9) {
                            sparseArray6.put(R.id.tag_user_mute_visible, true);
                            sparseArray6.put(R.id.tag_is_mem, sparseArray2.get(R.id.tag_is_mem));
                            sparseArray6.put(R.id.tag_user_mute_mute_userid, sparseArray2.get(R.id.tag_user_mute_mute_userid));
                            sparseArray6.put(R.id.tag_user_mute_mute_username, sparseArray2.get(R.id.tag_user_mute_mute_username));
                            sparseArray6.put(R.id.tag_user_mute_mute_nameshow, sparseArray2.get(R.id.tag_user_mute_mute_nameshow));
                            sparseArray6.put(R.id.tag_user_mute_post_id, sparseArray2.get(R.id.tag_user_mute_post_id));
                            sparseArray6.put(R.id.tag_user_mute_thread_id, sparseArray2.get(R.id.tag_user_mute_thread_id));
                        } else {
                            sparseArray6.put(R.id.tag_user_mute_visible, false);
                        }
                        if (z10) {
                            sparseArray6.put(R.id.tag_should_delete_visible, true);
                            sparseArray6.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                            sparseArray6.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                            sparseArray6.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                            gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.iGd);
                            gVar6.mTextView.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), a.this.iGd);
                        gVar.mTextView.setTag(sparseArray6);
                    } else {
                        if (z10) {
                            SparseArray sparseArray7 = new SparseArray();
                            sparseArray7.put(R.id.tag_should_manage_visible, false);
                            sparseArray7.put(R.id.tag_user_mute_visible, false);
                            sparseArray7.put(R.id.tag_should_delete_visible, true);
                            sparseArray7.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                            sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                            sparseArray7.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                            sparseArray7.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                            if (a.this.iYs.ckc().getPbData().cje() == 1002 && !z6) {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.iGd);
                            } else {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.iGd);
                            }
                            gVar6.mTextView.setTag(sparseArray7);
                        }
                        gVar = null;
                    }
                    if (gVar6 != null) {
                        arrayList.add(gVar6);
                    }
                    if (gVar != null) {
                        arrayList.add(gVar);
                    }
                }
                a.this.iGd.az(arrayList);
                a.this.iGc = new i(a.this.iYs.getPageContext(), a.this.iGd);
                a.this.iGc.showDialog();
                TiebaStatic.log(new an("c13272").cp("tid", a.this.iYs.ckc().cmc()).cp("fid", a.this.iYs.ckc().getForumId()).cp("uid", a.this.iYs.ckc().getPbData().ciS().azX().getUserId()).cp("post_id", a.this.iYs.ckc().aMq()).Z("obj_source", z2 ? 2 : 1));
            }
            return true;
        }
    };
    private k.c iHg = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.17
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            int i2;
            if (a.this.iGc != null) {
                a.this.iGc.dismiss();
            }
            switch (i) {
                case 1:
                    if (a.this.iGu != null && !TextUtils.isEmpty(a.this.iGv)) {
                        if (a.this.iGw == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.iGv));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.iGv;
                            aVar.pkgId = a.this.iGw.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.iGw.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.iGu = null;
                        a.this.iGv = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.iGu != null && !TextUtils.isEmpty(a.this.iGv)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.iYs.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.iYs.getPageContext().getPageActivity())) {
                            if (a.this.gOz == null) {
                                a.this.gOz = new au(a.this.iYs.getPageContext());
                            }
                            a.this.gOz.j(a.this.iGv, a.this.iGu.getImageByte());
                            a.this.iGu = null;
                            a.this.iGv = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.hfx != null) {
                        a.this.hfx.fv(a.this.iYs.getPageContext().getPageActivity());
                        a.this.hfx = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new an("c11739").Z("obj_locate", 2));
                    if (a.this.iYs.checkUpIsLogin()) {
                        a.this.cv(view);
                        if (a.this.iYs.ckc().getPbData().ciS() != null && a.this.iYs.ckc().getPbData().ciS().azX() != null && a.this.iYs.ckc().getPbData().ciS().azX().getUserId() != null && a.this.iYs.crq() != null) {
                            int g = a.this.g(a.this.iYs.ckc().getPbData());
                            bj ciS = a.this.iYs.ckc().getPbData().ciS();
                            if (ciS.ayL()) {
                                i2 = 2;
                            } else if (ciS.aBS()) {
                                i2 = 3;
                            } else if (ciS.aBT()) {
                                i2 = 4;
                            } else {
                                i2 = ciS.aBU() ? 5 : 1;
                            }
                            TiebaStatic.log(new an("c12526").cp("tid", a.this.iYs.ckc().cmc()).Z("obj_locate", 2).cp("obj_id", a.this.iYs.ckc().getPbData().ciS().azX().getUserId()).Z("obj_type", a.this.iYs.crq().aww() ? 0 : 1).Z("obj_source", g).Z("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.iYs.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new an("c13079"));
                        a.this.FA((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new an("c11739").Z("obj_locate", 4));
                        SparseArray<Object> sparseArray = (SparseArray) tag;
                        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray.put(R.id.tag_from, 0);
                            sparseArray.put(R.id.tag_check_mute_from, 2);
                            a.this.b(sparseArray);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                    if (sparseArray2 != null && (sparseArray2.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_id) instanceof String) && (sparseArray2.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    }
                    return;
                case 7:
                    if (!j.isNetWorkAvailable()) {
                        a.this.iYs.showToast(R.string.network_not_available);
                        return;
                    }
                    SparseArray<Object> sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null) {
                        boolean booleanValue = ((Boolean) sparseArray3.get(R.id.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue3 = ((Boolean) sparseArray3.get(R.id.tag_user_mute_visible)).booleanValue();
                        if (booleanValue) {
                            if (booleanValue3) {
                                sparseArray3.put(R.id.tag_from, 1);
                                sparseArray3.put(R.id.tag_check_mute_from, 2);
                                a.this.b(sparseArray3);
                                return;
                            }
                            sparseArray3.put(R.id.tag_check_mute_from, 2);
                            a.this.cB(view);
                            return;
                        } else if (booleanValue2) {
                            a.this.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final b.a iHf = new b.a() { // from class: com.baidu.tieba.pb.videopb.b.a.21
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.iGu != null && !TextUtils.isEmpty(a.this.iGv)) {
                if (i == 0) {
                    if (a.this.iGw == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.iGv));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.iGv;
                        aVar.pkgId = a.this.iGw.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.iGw.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.iYs.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.iYs.getPageContext().getPageActivity())) {
                        if (a.this.gOz == null) {
                            a.this.gOz = new au(a.this.iYs.getPageContext());
                        }
                        a.this.gOz.j(a.this.iGv, a.this.iGu.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.iGu = null;
                a.this.iGv = null;
            }
        }
    };

    public void clj() {
        f pbData;
        bj ciS;
        if (this.iYs != null && this.iYs.ckc() != null && this.iYs.ckc().getPbData() != null && (ciS = (pbData = this.iYs.ckc().getPbData()).ciS()) != null && ciS.azX() != null) {
            this.iYs.cnN();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), ciS.azX().getUserId());
            ac acVar = new ac();
            int cje = this.iYs.ckc().getPbData().cje();
            if (cje == 1 || cje == 3) {
                acVar.iKD = true;
                acVar.iKC = true;
                acVar.iKJ = ciS.azS() == 1;
                acVar.iKI = ciS.azT() == 1;
            } else {
                acVar.iKD = false;
                acVar.iKC = false;
            }
            if (cje == 1002 && !equals) {
                acVar.iKK = true;
            }
            acVar.iKA = pJ(equals);
            acVar.iKE = clk();
            acVar.iKB = pK(equals);
            acVar.hS = this.iYs.ckc().cmd();
            acVar.iKx = true;
            acVar.iKw = pI(equals);
            acVar.iKG = cli();
            acVar.iKH = TbadkCoreApplication.getInst().getSkinType() == 1;
            acVar.iKF = true;
            acVar.isHostOnly = this.iYs.ckc().getHostMode();
            acVar.iKz = true;
            if (ciS.aAo() == null) {
                acVar.iKy = true;
            } else {
                acVar.iKy = false;
            }
            if (pbData.cjs()) {
                acVar.iKx = false;
                acVar.iKz = false;
                acVar.iKy = false;
                acVar.iKC = false;
                acVar.iKD = false;
            }
            a(acVar);
        }
    }

    public String cli() {
        f pbData;
        if (!FansCallSwitch.getIsOn()) {
            return "";
        }
        PostData E = this.iYs.E(this.iYs.ckc().getPbData());
        if (this.iYs.ckc() == null || (pbData = this.iYs.ckc().getPbData()) == null || pbData.getUserData() == null || pbData.ciS() == null || E == null || E.azX() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !E.azX().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.ciS().azD() == 0) {
            return "";
        }
        if (pbData.ciS().azD() == 0) {
            return TbadkCoreApplication.getInst().getString(R.string.fans_call);
        }
        return TbadkCoreApplication.getInst().getString(R.string.haved_fans_call);
    }

    private boolean pJ(boolean z) {
        boolean z2;
        w wVar;
        if (this.iYs == null || this.iYs.ckc() == null || this.iYs.ckc().getPbData() == null) {
            return false;
        }
        f pbData = this.iYs.ckc().getPbData();
        bj ciS = pbData.ciS();
        if (ciS != null) {
            if (ciS.ayL() || ciS.aBS()) {
                return false;
            }
            if (ciS.aBT() || ciS.aBU()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.cje() != 0) {
                return pbData.cje() != 3;
            }
            List<bf> cjm = pbData.cjm();
            if (v.getCount(cjm) > 0) {
                for (bf bfVar : cjm) {
                    if (bfVar != null && (wVar = bfVar.cML) != null && wVar.cKF && !wVar.cKG && (wVar.type == 1 || wVar.type == 2)) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            return z2;
        }
        return false;
    }

    private boolean pK(boolean z) {
        if (z || this.iYs == null || this.iYs.ckc() == null || this.iYs.ckc().getPbData() == null) {
            return false;
        }
        return ((this.iYs.ckc().getPbData().getForum() != null && this.iYs.ckc().getPbData().getForum().isBlockBawuDelete) || this.iYs.ckc().getPbData().cje() == 0 || this.iYs.ckc().getPbData().cje() == 3) ? false : true;
    }

    private boolean clk() {
        if (this.iYs == null || this.iYs.ckc() == null || !this.iYs.ckc().cmd()) {
            return false;
        }
        return this.iYs.ckc().getPageData() == null || this.iYs.ckc().getPageData().ayS() != 0;
    }

    public void a(ac acVar) {
        if (!this.iYs.getBaseFragmentActivity().isProgressBarShown()) {
            this.iSx = new ab(this.iYs, this.iYs.arL);
            this.iSw = new AlertDialog.Builder(this.iYs.getContext(), R.style.DialogTheme).create();
            this.iSw.setCanceledOnTouchOutside(true);
            com.baidu.adp.lib.f.g.showDialog(this.iSw, this.iYs.getFragmentActivity());
            Window window = this.iSw.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.iSx.getView());
            this.iSx.pW(acVar == null ? false : acVar.iKw);
            this.iSx.pX(acVar == null ? false : acVar.iKA);
            this.iSx.pY(acVar == null ? false : acVar.iKE);
            this.iSx.pZ(acVar == null ? false : acVar.iKB);
            this.iSx.qa(acVar == null ? true : acVar.iKy);
            if (acVar == null) {
                this.iSx.Y(false, false);
                this.iSx.Z(false, false);
                this.iSx.v(false, "");
            } else {
                this.iSx.Y(acVar.iKC, acVar.iKJ);
                this.iSx.Z(acVar.iKD, acVar.iKI);
                this.iSx.v(StringUtils.isNull(acVar.iKG) ? false : true, acVar.iKG);
            }
            boolean z = acVar == null ? false : acVar.hS;
            boolean z2 = acVar == null ? false : acVar.isHostOnly;
            boolean z3 = acVar == null ? false : acVar.iKz;
            boolean z4 = acVar == null ? false : acVar.iKx;
            boolean z5 = acVar == null ? false : acVar.iKH;
            boolean z6 = acVar == null ? false : acVar.iKF;
            this.iSx.X(z3, z2);
            this.iSx.aa(z4, z);
            this.iSx.ab(z6, z5);
            if (acVar != null) {
                this.iSx.iKt = acVar.iKK;
                if (acVar.iKK) {
                    this.iSx.cnp().setText(R.string.report_text);
                    this.iSx.pZ(false);
                }
            }
            cpG();
        }
    }

    private void cpG() {
        if (this.iSx != null) {
            this.iSx.cnw();
        }
    }

    public void apF() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.iSw != null) {
                        com.baidu.adp.lib.f.g.dismissDialog(a.this.iSw, a.this.iYs.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.gx().postDelayed(this.runnable, 100L);
    }

    public void cpH() {
        if (this.iSw != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.iSw, this.iYs.getPageContext().getPageActivity());
        }
    }

    public ab cpI() {
        return this.iSx;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.iYs = videoPbFragment;
        this.iGs = videoPbFragment.getUniqueId();
        this.iFU = new com.baidu.tieba.pb.pb.report.a(this.iYs.getContext());
        this.iFU.t(this.iYs.getUniqueId());
        this.iOf = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.16
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.iYs.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.iYs.ckc().getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                String str3 = "";
                if (objArr.length > 3) {
                    str3 = String.valueOf(objArr[3]);
                }
                String str4 = "";
                if (objArr.length > 4) {
                    str4 = String.valueOf(objArr[4]);
                }
                a.this.iYs.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.iYs.getPageContext().getPageActivity(), a.this.iYs.ckc().getPbData().getForum().getId(), a.this.iYs.ckc().getPbData().getForum().getName(), a.this.iYs.ckc().getPbData().ciS().getId(), valueOf, str, str3, str2, str4)));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            k(postData);
        }
    }

    protected void k(PostData postData) {
        PostData E;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.iYs.ckc().aAg())) {
                z = true;
            }
            MarkData l = this.iYs.ckc().l(postData);
            if (this.iYs.ckc().getPbData() != null && this.iYs.ckc().getPbData().cjs() && (E = this.iYs.E(this.iYs.ckc().getPbData())) != null) {
                l = this.iYs.ckc().l(E);
            }
            if (l != null) {
                this.iYs.com();
                if (this.iYs.crq() != null) {
                    this.iYs.crq().a(l);
                    if (!z) {
                        this.iYs.crq().awy();
                    } else {
                        this.iYs.crq().awx();
                    }
                }
            }
        }
    }

    public int g(f fVar) {
        if (fVar != null && fVar.ciS() != null) {
            if (fVar.ciS().getThreadType() == 0) {
                return 1;
            }
            if (fVar.ciS().getThreadType() == 54) {
                return 2;
            }
            if (fVar.ciS().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pI(boolean z) {
        if (this.iYs.ckc() == null || this.iYs.ckc().getPbData() == null) {
            return false;
        }
        return ((this.iYs.ckc().getPbData().cje() != 0) || this.iYs.ckc().getPbData().ciS() == null || this.iYs.ckc().getPbData().ciS().azX() == null || TextUtils.equals(this.iYs.ckc().getPbData().ciS().azX().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void FA(String str) {
        if (this.iYs.ckc() != null && this.iYs.ckc().getPbData() != null && this.iYs.ckc().getPbData().cjs()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.iYs.ckc().cmc(), str);
            bj ciS = this.iYs.ckc().getPbData().ciS();
            if (ciS.ayL()) {
                format = format + "&channelid=33833";
            } else if (ciS.aBR()) {
                format = format + "&channelid=33842";
            } else if (ciS.aBS()) {
                format = format + "&channelid=33840";
            }
            FB(format);
            return;
        }
        this.iFU.Ga(str);
    }

    private void FB(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.iYs.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.iGc != null && this.iGc.isShowing()) {
                this.iGc.dismiss();
                this.iGc = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.iYs.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.iGc != null) {
                            a.this.iGc.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.iGs);
                            userMuteAddAndDelCustomMessage.setTag(a.this.iGs);
                            a.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                        }
                    }
                });
                ArrayList arrayList = new ArrayList();
                int i = -1;
                if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    arrayList.add(new g(0, TbadkCoreApplication.getInst().getResources().getString(R.string.delete), kVar));
                }
                if (z) {
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getResources().getString(R.string.un_mute), kVar));
                } else {
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getResources().getString(R.string.mute), kVar));
                }
                kVar.az(arrayList);
                this.iGc = new i(this.iYs.getPageContext(), kVar);
                this.iGc.showDialog();
            }
        }
    }

    public void clF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iYs.getPageContext().getPageActivity());
        aVar.sC(this.iYs.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.19
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.iYs.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.20
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.iYs.getPageContext()).aCp();
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, (String) null);
    }

    public void a(int i, String str, int i2, boolean z, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(iNy, Integer.valueOf(iNz));
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
        this.iML = new com.baidu.tbadk.core.dialog.a(this.iYs.getActivity());
        if (StringUtils.isNull(str2)) {
            this.iML.jF(i3);
        } else {
            this.iML.setOnlyMessageShowCenter(false);
            this.iML.sC(str2);
        }
        this.iML.setYesButtonTag(sparseArray);
        this.iML.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.iYs.a(aVar, (JSONArray) null);
            }
        });
        this.iML.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.iML.fz(true);
        this.iML.b(this.iYs.getPageContext());
        if (z) {
            this.iML.aCp();
        } else {
            a(this.iML, i);
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.iYs != null && aVar != null) {
            if (this.gOh == null && this.iYs.getView() != null) {
                this.gOh = new e(this.iYs.getPageContext(), this.iYs.getView());
            }
            AntiData bBu = bBu();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bBu != null && bBu.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bBu.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray);
            this.gOh.setDefaultReasonArray(new String[]{this.iYs.getString(R.string.delete_thread_reason_1), this.iYs.getString(R.string.delete_thread_reason_2), this.iYs.getString(R.string.delete_thread_reason_3), this.iYs.getString(R.string.delete_thread_reason_4), this.iYs.getString(R.string.delete_thread_reason_5)});
            this.gOh.setData(alVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.gOh.vS(str);
            this.gOh.a(new e.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void S(JSONArray jSONArray) {
                    a.this.iYs.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData bBu() {
        if (this.iYs.ckc() == null || this.iYs.ckc().getPbData() == null) {
            return null;
        }
        return this.iYs.ckc().getPbData().getAnti();
    }

    public void cB(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        g gVar;
        g gVar2;
        k kVar = new k(this.iYs.getContext());
        kVar.setTitleText(this.iYs.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.4
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.iMK.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (a.this.iOf != null) {
                                a.this.iOf.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            a.this.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        ArrayList arrayList = new ArrayList();
        int i = -1;
        if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
            i = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
        }
        if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && i != 2) {
            int i2 = -1;
            if (sparseArray.get(R.id.tag_del_post_type) instanceof Integer) {
                i2 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
            }
            if (i2 == 0) {
                gVar2 = new g(0, this.iYs.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new g(0, this.iYs.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            g gVar3 = new g(1, this.iYs.getString(R.string.forbidden_person), kVar);
            gVar3.mTextView.setTag(sparseArray3);
            arrayList.add(gVar3);
        }
        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
            sparseArray4.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
            sparseArray4.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
            sparseArray4.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
            sparseArray4.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
            sparseArray4.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
            sparseArray4.put(R.id.tag_user_mute_msg, sparseArray.get(R.id.tag_user_mute_msg));
            if (z) {
                gVar = new g(2, this.iYs.getString(R.string.un_mute), kVar);
            } else {
                gVar = new g(2, this.iYs.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.az(arrayList);
        if (this.iMK == null) {
            this.iMK = new i(this.iYs.getPageContext(), kVar);
        } else {
            this.iMK.a(kVar);
        }
        this.iMK.showDialog();
    }

    public void clb() {
        if (this.iFB == null) {
            this.iFB = new com.baidu.tbadk.core.dialog.b(this.iYs.getPageContext().getPageActivity());
            this.iFB.a(new String[]{this.iYs.getPageContext().getString(R.string.call_phone), this.iYs.getPageContext().getString(R.string.sms_phone), this.iYs.getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.videopb.b.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.iYs.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.iCs = a.this.iCs.trim();
                        UtilHelper.callPhone(a.this.iYs.getPageContext().getPageActivity(), a.this.iCs);
                        new com.baidu.tieba.pb.pb.main.a(a.this.iYs.ckc().cmc(), a.this.iCs, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.iYs.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.iCs = a.this.iCs.trim();
                        UtilHelper.smsPhone(a.this.iYs.getPageContext().getPageActivity(), a.this.iCs);
                        new com.baidu.tieba.pb.pb.main.a(a.this.iYs.ckc().cmc(), a.this.iCs, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.iCs = a.this.iCs.trim();
                        UtilHelper.startBaiDuBar(a.this.iYs.getPageContext().getPageActivity(), a.this.iCs);
                        bVar.dismiss();
                    }
                }
            }).jK(R.style.dialog_ani_b2t).jL(17).d(this.iYs.getPageContext());
        }
    }

    public void cH(final View view) {
        String[] strArr;
        int i = 0;
        if (this.iYs != null && this.iYs.ckc() != null) {
            final i iVar = new i(this.iYs.getPageContext());
            if (this.iYs.ckc().getPbData().izJ == null || this.iYs.ckc().getPbData().izJ.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.iYs.ckc().getPbData().izJ.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.iYs.ckc().getPbData().izJ.size()) {
                        break;
                    }
                    strArr2[i2] = this.iYs.ckc().getPbData().izJ.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.iYs.ckc().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.iYs.ckc().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.iYs.ckc().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.iYs.ckc().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new an("c12097").Z("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).Z("obj_type", i4));
                    if (a.this.iYs.ckc().getPbData().izJ != null && a.this.iYs.ckc().getPbData().izJ.size() > i3) {
                        i3 = a.this.iYs.ckc().getPbData().izJ.get(i3).sort_type.intValue();
                    }
                    boolean yQ = a.this.iYs.ckc().yQ(i3);
                    view.setTag(Integer.valueOf(a.this.iYs.ckc().cmv()));
                    if (yQ) {
                        a.this.iYs.setIsLoading(true);
                    }
                }
            });
            iVar.showDialog();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iYs.getActivity());
            aVar.sB(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.sC(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.fz(false);
            aVar.b(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new an("c12528").cp("obj_id", metaData.getUserId()).Z("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new an("c12528").cp("obj_id", metaData.getUserId()).Z("obj_locate", 1));
                    aVar2.dismiss();
                    if (a.this.iYs.crB() != null) {
                        a.this.iYs.crB().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.iYs.getPageContext().getUniqueId(), a.this.iYs.ckc().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.iYs.getPageContext()).aCp();
            TiebaStatic.log(new an("c12527"));
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
        }
        if (sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(R.id.tag_user_mute_thread_id);
        }
        if (sparseArray.get(R.id.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(R.id.tag_user_mute_post_id);
        }
        if (sparseArray.get(R.id.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(R.id.tag_user_mute_msg);
        }
        if (sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String) {
            str6 = (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.iGs);
        userMuteAddAndDelCustomMessage.setTag(this.iGs);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void uZ(String str) {
        if (str == null) {
            str = "";
        }
        if (this.iYs != null && this.iYs.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iYs.getPageContext().getPageActivity());
            aVar.sC(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.iYs.getPageContext()).aCp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iYs.getBaseFragmentActivity());
        if (aq.isEmpty(str)) {
            aVar.sC(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.sC(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.iYs.getPageContext()).aCp();
    }

    public void showLoadingDialog() {
        if (this.fNy == null) {
            this.fNy = new com.baidu.tbadk.core.view.a(this.iYs.getPageContext());
        }
        this.fNy.setDialogVisiable(true);
    }

    public void boJ() {
        if (this.fNy != null) {
            this.fNy.setDialogVisiable(false);
        }
    }

    public void a(final b.a aVar, boolean z) {
        if (this.iMT != null) {
            this.iMT.dismiss();
            this.iMT = null;
        }
        k kVar = new k(this.iYs.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.iYs.ckc().getPbData() != null && this.iYs.ckc().getPbData().ciS() != null && !this.iYs.ckc().getPbData().ciS().isBjh()) {
            arrayList.add(new g(0, this.iYs.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new g(1, this.iYs.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.az(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.iMT.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.iMT = new i(this.iYs.getPageContext(), kVar);
        this.iMT.showDialog();
    }

    public void aM(ArrayList<ad> arrayList) {
        if (this.iMO == null) {
            this.iMO = LayoutInflater.from(this.iYs.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.iYs.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.iMO);
        if (this.iMN == null) {
            this.iMN = new Dialog(this.iYs.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.iMN.setCanceledOnTouchOutside(true);
            this.iMN.setCancelable(true);
            this.iMW = (ScrollView) this.iMO.findViewById(R.id.good_scroll);
            this.iMN.setContentView(this.iMO);
            WindowManager.LayoutParams attributes = this.iMN.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.iMN.getWindow().setAttributes(attributes);
            this.fJw = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.14
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.iMS = (String) compoundButton.getTag();
                        if (a.this.fJv != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.fJv) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.iMS != null && !str.equals(a.this.iMS)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.iMP = (LinearLayout) this.iMO.findViewById(R.id.good_class_group);
            this.iMR = (TextView) this.iMO.findViewById(R.id.dialog_button_cancel);
            this.iMR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.iMN instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(a.this.iMN, a.this.iYs.getPageContext());
                    }
                }
            });
            this.iMQ = (TextView) this.iMO.findViewById(R.id.dialog_button_ok);
            this.iMQ.setOnClickListener(this.iYs.crr());
        }
        this.iMP.removeAllViews();
        this.fJv = new ArrayList();
        CustomBlueCheckRadioButton dW = dW("0", this.iYs.getPageContext().getString(R.string.thread_good_class));
        this.fJv.add(dW);
        dW.setChecked(true);
        this.iMP.addView(dW);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                ad adVar = arrayList.get(i2);
                if (adVar != null && !TextUtils.isEmpty(adVar.ayt()) && adVar.ayu() > 0) {
                    CustomBlueCheckRadioButton dW2 = dW(String.valueOf(adVar.ayu()), adVar.ayt());
                    this.fJv.add(dW2);
                    View view = new View(this.iYs.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    am.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.iMP.addView(view);
                    this.iMP.addView(dW2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.iMW.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.iYs.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.iYs.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.iYs.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.iMW.setLayoutParams(layoutParams2);
            this.iMW.removeAllViews();
            if (this.iMP != null && this.iMP.getParent() == null) {
                this.iMW.addView(this.iMP);
            }
        }
        com.baidu.adp.lib.f.g.a(this.iMN, this.iYs.getPageContext());
    }

    private CustomBlueCheckRadioButton dW(String str, String str2) {
        Activity pageActivity = this.iYs.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.fJw);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public boolean cw(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.iGs;
        userMuteCheckCustomMessage.setTag(this.iGs);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void coH() {
        if (this.iML != null) {
            this.iML.dismiss();
        }
        if (this.iMM != null) {
            com.baidu.adp.lib.f.g.b(this.iMM, this.iYs.getPageContext());
        }
        if (this.iMN != null) {
            com.baidu.adp.lib.f.g.b(this.iMN, this.iYs.getPageContext());
        }
        if (this.iMK != null) {
            this.iMK.dismiss();
        }
    }

    public void csa() {
        if (this.iGc != null) {
            this.iGc.dismiss();
        }
    }

    public void coG() {
        apF();
        this.iYs.cnN();
        if (this.iGc != null) {
            this.iGc.dismiss();
        }
        coH();
    }

    public void coF() {
        apF();
        this.iYs.cnN();
        if (this.iGc != null) {
            this.iGc.dismiss();
        }
        this.iYs.bCG();
        coH();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener crt() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b csb() {
        return this.iFB;
    }

    public void setPhoneNumber(String str) {
        this.iCs = str;
    }

    public String col() {
        return this.iMS;
    }

    public View cok() {
        if (this.iMO != null) {
            return this.iMO.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
