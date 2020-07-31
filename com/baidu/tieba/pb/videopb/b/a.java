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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.c;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.d;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.aj;
import com.baidu.tieba.pb.pb.main.ak;
import com.baidu.tieba.pb.pb.main.bd;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.e;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes16.dex */
public class a {
    public static int kwj = 3;
    public static int kwk = 0;
    public static int kwl = 3;
    public static int kwm = 4;
    public static int kwn = 5;
    public static int kwo = 6;
    private bd dKK;
    private com.baidu.tbadk.core.message.a eeP;
    private e eez;
    private List<CustomBlueCheckRadioButton> gZh;
    private com.baidu.tieba.NEGFeedBack.e ikU;
    public VideoPbFragment kHB;
    private String kkf;
    public BdUniqueId koA;
    private com.baidu.adp.widget.ImageView.a koC;
    private String koD;
    private TbRichTextMemeInfo koE;
    private com.baidu.tieba.pb.pb.report.a koc;
    private i kok;
    private k kol;
    private PbFragment.b kwS;
    private Object mExtra;
    private PermissionJudgePolicy mPermissionJudgement;
    private Runnable runnable;
    private i kvB = null;
    private com.baidu.tbadk.core.dialog.a kvt = null;
    private Dialog kvu = null;
    private Dialog kvv = null;
    private View kvw = null;
    private LinearLayout kvx = null;
    private TextView kvy = null;
    private TextView kvz = null;
    private String kvA = null;
    private ScrollView kvE = null;
    private CompoundButton.OnCheckedChangeListener gZi = null;
    private i kvs = null;
    private com.baidu.tbadk.core.view.a hdc = null;
    private com.baidu.tbadk.core.dialog.b knI = null;
    private AlertDialog kBo = null;
    private aj kBp = null;
    PostData iFG = null;
    private boolean klE = d.aRO();
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.12
        /* JADX WARN: Removed duplicated region for block: B:32:0x00ac A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x01f5  */
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
            if (a.this.kHB == null || !a.this.kHB.isAdded()) {
                return true;
            }
            SparseArray sparseArray2 = null;
            try {
                sparseArray2 = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray2 == null) {
                if (a.this.cK(view)) {
                    if (view instanceof TbImageView) {
                        a.this.koC = ((TbImageView) view).getBdImage();
                        a.this.koD = ((TbImageView) view).getUrl();
                        if (a.this.koC == null || TextUtils.isEmpty(a.this.koD)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.koE = null;
                        } else {
                            a.this.koE = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            a.this.koC = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                a.this.koD = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                a.this.koE = null;
                            } else {
                                a.this.koE = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        a.this.koC = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            a.this.koD = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.koE = null;
                        } else {
                            a.this.koE = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        a.this.a(a.this.kpq, a.this.koC.isGif());
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
            a.this.iFG = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (a.this.iFG == null || a.this.kHB.cSZ() == null) {
                return true;
            }
            if (!a.this.kHB.cSZ().aSj() || a.this.iFG.getId() == null || !a.this.iFG.getId().equals(a.this.kHB.cLP().aWt())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = a.this.kHB.cLP().getPbData() != null && a.this.kHB.cLP().getPbData().cLa();
            if (a.this.kol == null) {
                a.this.kol = new k(a.this.kHB.getContext());
                a.this.kol.a(a.this.kpd);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = a.this.cK(view) && !z3;
                boolean z5 = (!a.this.cK(view) || a.this.koC == null || a.this.koC.isGif()) ? false : true;
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
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), a.this.kol));
                }
                if (z5) {
                    arrayList.add(new g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), a.this.kol));
                }
                if (!z4 && !z5) {
                    g gVar3 = new g(3, TbadkCoreApplication.getInst().getString(R.string.copy), a.this.kol);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, a.this.iFG);
                    gVar3.mTextView.setTag(sparseArray3);
                    arrayList.add(gVar3);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), a.this.kol);
                    } else {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.mark), a.this.kol);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, a.this.iFG);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar2.mTextView.setTag(sparseArray4);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin() && !a.this.klE) {
                    if (!z8 && z7) {
                        g gVar4 = new g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), a.this.kol);
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
                        if ((a.this.sm(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                            g gVar5 = new g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.kol);
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
                            gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.kol);
                            gVar6.mTextView.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), a.this.kol);
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
                            if (a.this.kHB.cLP().getPbData().cKM() == 1002 && !z6) {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.kol);
                            } else {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.kol);
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
                a.this.kol.aS(arrayList);
                a.this.kok = new i(a.this.kHB.getPageContext(), a.this.kol);
                a.this.kok.showDialog();
                TiebaStatic.log(new ap("c13272").dn("tid", a.this.kHB.cLP().cNL()).dn("fid", a.this.kHB.cLP().getForumId()).dn("uid", a.this.kHB.cLP().getPbData().cKx().aWl().getUserId()).dn("post_id", a.this.kHB.cLP().bjg()).ah("obj_source", z2 ? 2 : 1));
            }
            return true;
        }
    };
    private k.c kpd = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.17
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (a.this.kok != null) {
                a.this.kok.dismiss();
            }
            switch (i) {
                case 1:
                    if (a.this.koC != null && !TextUtils.isEmpty(a.this.koD)) {
                        if (a.this.koE == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.koD));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.koD;
                            aVar.pkgId = a.this.koE.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.koE.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.koC = null;
                        a.this.koD = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.koC != null && !TextUtils.isEmpty(a.this.koD)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.kHB.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.kHB.getPageContext().getPageActivity())) {
                            if (a.this.dKK == null) {
                                a.this.dKK = new bd(a.this.kHB.getPageContext());
                            }
                            a.this.dKK.j(a.this.koD, a.this.koC.getImageByte());
                            a.this.koC = null;
                            a.this.koD = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.iFG != null) {
                        a.this.iFG.fs(a.this.kHB.getPageContext().getPageActivity());
                        a.this.iFG = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new ap("c11739").ah("obj_locate", 2));
                    if (a.this.kHB.checkUpIsLogin()) {
                        a.this.cJ(view);
                        if (a.this.kHB.cLP().getPbData().cKx() != null && a.this.kHB.cLP().getPbData().cKx().aWl() != null && a.this.kHB.cLP().getPbData().cKx().aWl().getUserId() != null && a.this.kHB.cSZ() != null) {
                            int h = a.this.h(a.this.kHB.cLP().getPbData());
                            bv cKx = a.this.kHB.cLP().getPbData().cKx();
                            if (cKx.aUT()) {
                                i2 = 2;
                            } else if (cKx.aUU()) {
                                i2 = 3;
                            } else if (cKx.aYg()) {
                                i2 = 4;
                            } else {
                                i2 = cKx.aYh() ? 5 : 1;
                            }
                            TiebaStatic.log(new ap("c12526").dn("tid", a.this.kHB.cLP().cNL()).ah("obj_locate", 2).dn("obj_id", a.this.kHB.cLP().getPbData().cKx().aWl().getUserId()).ah("obj_type", a.this.kHB.cSZ().aSj() ? 0 : 1).ah("obj_source", h).ah("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.kHB.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new ap("c13079"));
                        a.this.KB((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new ap("c11739").ah("obj_locate", 4));
                        SparseArray<Object> sparseArray2 = (SparseArray) tag;
                        if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray2.put(R.id.tag_from, 0);
                            sparseArray2.put(R.id.tag_check_mute_from, 2);
                            a.this.c(sparseArray2);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        a.this.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    }
                    return;
                case 7:
                    if (!j.isNetWorkAvailable()) {
                        a.this.kHB.showToast(R.string.network_not_available);
                        return;
                    }
                    SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null) {
                        boolean booleanValue = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue2 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                        if (booleanValue) {
                            if (booleanValue3) {
                                sparseArray4.put(R.id.tag_from, 1);
                                sparseArray4.put(R.id.tag_check_mute_from, 2);
                                a.this.c(sparseArray4);
                                return;
                            }
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            a.this.cP(view);
                            return;
                        } else if (booleanValue2) {
                            a.this.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 8:
                    if (bf.checkUpIsLogin(a.this.kHB.getContext()) && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.aYc() != null) {
                            a.this.d(postData.aYc());
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final b.InterfaceC0492b kpq = new b.InterfaceC0492b() { // from class: com.baidu.tieba.pb.videopb.b.a.21
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0492b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.koC != null && !TextUtils.isEmpty(a.this.koD)) {
                if (i == 0) {
                    if (a.this.koE == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.koD));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.koD;
                        aVar.pkgId = a.this.koE.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.koE.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.kHB.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.kHB.getPageContext().getPageActivity())) {
                        if (a.this.dKK == null) {
                            a.this.dKK = new bd(a.this.kHB.getPageContext());
                        }
                        a.this.dKK.j(a.this.koD, a.this.koC.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.koC = null;
                a.this.koD = null;
            }
        }
    };

    public void cMQ() {
        f pbData;
        bv cKx;
        boolean z = true;
        if (this.kHB != null && this.kHB.cLP() != null && this.kHB.cLP().getPbData() != null && (cKx = (pbData = this.kHB.cLP().getPbData()).cKx()) != null && cKx.aWl() != null) {
            this.kHB.cPw();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), cKx.aWl().getUserId());
            ak akVar = new ak();
            int cKM = this.kHB.cLP().getPbData().cKM();
            if (cKM == 1 || cKM == 3) {
                akVar.ktk = true;
                akVar.ktj = true;
                akVar.ktp = cKx.aWg() == 1;
                akVar.kto = cKx.aWh() == 1;
            } else {
                akVar.ktk = false;
                akVar.ktj = false;
            }
            if (cKM == 1002 && !equals) {
                akVar.ktq = true;
            }
            akVar.kth = sn(equals);
            akVar.ktl = cMR();
            akVar.kti = so(equals);
            akVar.Ef = this.kHB.cLP().cNN();
            akVar.kte = true;
            akVar.ktd = sm(equals);
            akVar.ktn = TbadkCoreApplication.getInst().getSkinType() == 1;
            akVar.ktm = true;
            akVar.isHostOnly = this.kHB.cLP().getHostMode();
            akVar.ktg = true;
            if (cKx.aWD() == null) {
                akVar.ktf = true;
            } else {
                akVar.ktf = false;
            }
            if (pbData.cLa()) {
                akVar.kte = false;
                akVar.ktg = false;
                akVar.ktf = false;
                akVar.ktj = false;
                akVar.ktk = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.cLa()) {
                z = false;
            }
            akVar.ktr = z;
            a(akVar);
        }
    }

    private boolean sn(boolean z) {
        boolean z2;
        aa aaVar;
        if (this.kHB == null || this.kHB.cLP() == null || this.kHB.cLP().getPbData() == null) {
            return false;
        }
        f pbData = this.kHB.cLP().getPbData();
        bv cKx = pbData.cKx();
        if (cKx != null) {
            if (cKx.aUT() || cKx.aUU()) {
                return false;
            }
            if (cKx.aYg() || cKx.aYh()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.cKM() != 0) {
                return pbData.cKM() != 3;
            }
            List<br> cKU = pbData.cKU();
            if (x.getCount(cKU) > 0) {
                for (br brVar : cKU) {
                    if (brVar != null && (aaVar = brVar.dRa) != null && aaVar.dON && !aaVar.dOO && (aaVar.type == 1 || aaVar.type == 2)) {
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

    private boolean so(boolean z) {
        if (z || this.kHB == null || this.kHB.cLP() == null || this.kHB.cLP().getPbData() == null) {
            return false;
        }
        return ((this.kHB.cLP().getPbData().getForum() != null && this.kHB.cLP().getPbData().getForum().isBlockBawuDelete) || this.kHB.cLP().getPbData().cKM() == 0 || this.kHB.cLP().getPbData().cKM() == 3) ? false : true;
    }

    private boolean cMR() {
        if (this.kHB == null || this.kHB.cLP() == null || !this.kHB.cLP().cNN()) {
            return false;
        }
        return this.kHB.cLP().getPageData() == null || this.kHB.cLP().getPageData().aVc() != 0;
    }

    public void a(ak akVar) {
        if (!this.kHB.getBaseFragmentActivity().isProgressBarShown()) {
            this.kBp = new aj(this.kHB, this.kHB.awi);
            this.kBo = new AlertDialog.Builder(this.kHB.getContext(), R.style.DialogTheme).create();
            this.kBo.setCanceledOnTouchOutside(true);
            com.baidu.adp.lib.f.g.showDialog(this.kBo, this.kHB.getFragmentActivity());
            Window window = this.kBo.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.kBp.getView());
            this.kBp.sA(akVar == null ? false : akVar.ktd);
            this.kBp.sB(akVar == null ? false : akVar.kth);
            this.kBp.sC(akVar == null ? false : akVar.ktl);
            this.kBp.sE(akVar == null ? false : akVar.kti);
            this.kBp.sF(akVar == null ? true : akVar.ktf);
            if (akVar == null) {
                this.kBp.ag(false, false);
                this.kBp.ah(false, false);
            } else {
                this.kBp.ag(akVar.ktj, akVar.ktp);
                this.kBp.ah(akVar.ktk, akVar.kto);
            }
            boolean z = akVar == null ? false : akVar.Ef;
            boolean z2 = akVar == null ? false : akVar.isHostOnly;
            boolean z3 = akVar == null ? false : akVar.ktg;
            boolean z4 = akVar == null ? false : akVar.kte;
            boolean z5 = akVar == null ? false : akVar.ktn;
            boolean z6 = akVar == null ? false : akVar.ktm;
            this.kBp.af(z3, z2);
            this.kBp.ai(z4, z);
            this.kBp.aj(z6, z5);
            if (akVar != null) {
                this.kBp.kta = akVar.ktq;
                if (akVar.ktq) {
                    this.kBp.cOY().setText(R.string.report_text);
                    this.kBp.sE(false);
                }
            }
            this.kBp.sD(akVar != null ? akVar.ktr : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.kHB.cLP() != null && this.kHB.cLP().getPbData() != null && this.kHB.cLP().getPbData().getThreadId() != null && this.kHB.cLP().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.kBp.cPb().setText(R.string.have_called_fans_short);
            }
            cRs();
        }
    }

    private void cRs() {
        if (this.kBp != null) {
            this.kBp.cPf();
        }
    }

    public void aIX() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.kBo != null) {
                        com.baidu.adp.lib.f.g.dismissDialog(a.this.kBo, a.this.kHB.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.lt().postDelayed(this.runnable, 100L);
    }

    public void cRt() {
        if (this.kBo != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.kBo, this.kHB.getPageContext().getPageActivity());
        }
    }

    public aj cRu() {
        return this.kBp;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.kHB = videoPbFragment;
        this.koA = videoPbFragment.getUniqueId();
        this.koc = new com.baidu.tieba.pb.pb.report.a(this.kHB.getContext());
        this.koc.x(this.kHB.getUniqueId());
        this.kwS = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.16
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.kHB.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.kHB.cLP().getPbData().getUserData().getUserId());
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
                a.this.kHB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.kHB.getPageContext().getPageActivity(), a.this.kHB.cLP().getPbData().getForum().getId(), a.this.kHB.cLP().getPbData().getForum().getName(), a.this.kHB.cLP().getPbData().cKx().getId(), valueOf, str, str3, str2, str4)));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJ(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            n(postData);
        }
    }

    protected void n(PostData postData) {
        PostData I;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.kHB.cLP().aWt())) {
                z = true;
            }
            MarkData o = this.kHB.cLP().o(postData);
            if (this.kHB.cLP().getPbData() != null && this.kHB.cLP().getPbData().cLa() && (I = this.kHB.I(this.kHB.cLP().getPbData())) != null) {
                o = this.kHB.cLP().o(I);
            }
            if (o != null) {
                this.kHB.cPV();
                if (this.kHB.cSZ() != null) {
                    this.kHB.cSZ().a(o);
                    if (!z) {
                        this.kHB.cSZ().aSl();
                    } else {
                        this.kHB.cSZ().aSk();
                    }
                }
            }
        }
    }

    public int h(f fVar) {
        if (fVar != null && fVar.cKx() != null) {
            if (fVar.cKx().getThreadType() == 0) {
                return 1;
            }
            if (fVar.cKx().getThreadType() == 54) {
                return 2;
            }
            if (fVar.cKx().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sm(boolean z) {
        if (this.kHB.cLP() == null || this.kHB.cLP().getPbData() == null) {
            return false;
        }
        return ((this.kHB.cLP().getPbData().cKM() != 0) || this.kHB.cLP().getPbData().cKx() == null || this.kHB.cLP().getPbData().cKx().aWl() == null || TextUtils.equals(this.kHB.cLP().getPbData().cKx().aWl().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void KB(String str) {
        if (this.kHB.cLP() != null && this.kHB.cLP().getPbData() != null && this.kHB.cLP().getPbData().cLa()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.kHB.cLP().cNL(), str);
            bv cKx = this.kHB.cLP().getPbData().cKx();
            if (cKx.aUT()) {
                format = format + "&channelid=33833";
            } else if (cKx.aYf()) {
                format = format + "&channelid=33842";
            } else if (cKx.aUU()) {
                format = format + "&channelid=33840";
            }
            KC(format);
            return;
        }
        this.koc.Lc(str);
    }

    private void KC(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.kHB.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.kok != null && this.kok.isShowing()) {
                this.kok.dismiss();
                this.kok = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.kHB.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.kok != null) {
                            a.this.kok.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.koA);
                            userMuteAddAndDelCustomMessage.setTag(a.this.koA);
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
                kVar.aS(arrayList);
                this.kok = new i(this.kHB.getPageContext(), kVar);
                this.kok.showDialog();
            }
        }
    }

    public void cNm() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kHB.getPageContext().getPageActivity());
        aVar.xl(this.kHB.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.19
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.kHB.getFragmentActivity(), 2, true, 4);
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
        aVar.b(this.kHB.getPageContext()).aYL();
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
        sparseArray.put(kwk, Integer.valueOf(kwl));
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
        this.kvt = new com.baidu.tbadk.core.dialog.a(this.kHB.getActivity());
        if (StringUtils.isNull(str2)) {
            this.kvt.ln(i3);
        } else {
            this.kvt.setOnlyMessageShowCenter(false);
            this.kvt.xl(str2);
        }
        this.kvt.setYesButtonTag(sparseArray);
        this.kvt.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.kHB.a(aVar, (JSONArray) null);
            }
        });
        this.kvt.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kvt.hJ(true);
        this.kvt.b(this.kHB.getPageContext());
        if (z) {
            this.kvt.aYL();
        } else {
            a(this.kvt, i);
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.kHB != null && aVar != null) {
            if (this.ikU == null && this.kHB.getView() != null) {
                this.ikU = new com.baidu.tieba.NEGFeedBack.e(this.kHB.getPageContext(), this.kHB.getView());
            }
            AntiData cax = cax();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cax != null && cax.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cax.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            aq aqVar = new aq();
            aqVar.setFeedBackReasonMap(sparseArray);
            this.ikU.setDefaultReasonArray(new String[]{this.kHB.getString(R.string.delete_thread_reason_1), this.kHB.getString(R.string.delete_thread_reason_2), this.kHB.getString(R.string.delete_thread_reason_3), this.kHB.getString(R.string.delete_thread_reason_4), this.kHB.getString(R.string.delete_thread_reason_5)});
            this.ikU.setData(aqVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.ikU.AK(str);
            this.ikU.a(new e.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void U(JSONArray jSONArray) {
                    a.this.kHB.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData cax() {
        if (this.kHB.cLP() == null || this.kHB.cLP().getPbData() == null) {
            return null;
        }
        return this.kHB.cLP().getPbData().getAnti();
    }

    public void cP(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        g gVar;
        g gVar2;
        k kVar = new k(this.kHB.getContext());
        kVar.setTitleText(this.kHB.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.4
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.kvs.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (a.this.kwS != null) {
                                a.this.kwS.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
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
        int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
        if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
            if ((sparseArray.get(R.id.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue() : -1) == 0) {
                gVar2 = new g(0, this.kHB.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new g(0, this.kHB.getString(R.string.delete), kVar);
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
            g gVar3 = new g(1, this.kHB.getString(R.string.forbidden_person), kVar);
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
                gVar = new g(2, this.kHB.getString(R.string.un_mute), kVar);
            } else {
                gVar = new g(2, this.kHB.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.aS(arrayList);
        if (this.kvs == null) {
            this.kvs = new i(this.kHB.getPageContext(), kVar);
        } else {
            this.kvs.a(kVar);
        }
        this.kvs.showDialog();
    }

    public void cMJ() {
        if (this.knI == null) {
            this.knI = new com.baidu.tbadk.core.dialog.b(this.kHB.getPageContext().getPageActivity());
            this.knI.a(new String[]{this.kHB.getPageContext().getString(R.string.call_phone), this.kHB.getPageContext().getString(R.string.sms_phone), this.kHB.getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0492b() { // from class: com.baidu.tieba.pb.videopb.b.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0492b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.kHB.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.kkf = a.this.kkf.trim();
                        UtilHelper.callPhone(a.this.kHB.getPageContext().getPageActivity(), a.this.kkf);
                        new com.baidu.tieba.pb.pb.main.b(a.this.kHB.cLP().cNL(), a.this.kkf, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.kHB.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.kkf = a.this.kkf.trim();
                        UtilHelper.smsPhone(a.this.kHB.getPageContext().getPageActivity(), a.this.kkf);
                        new com.baidu.tieba.pb.pb.main.b(a.this.kHB.cLP().cNL(), a.this.kkf, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.kkf = a.this.kkf.trim();
                        UtilHelper.startBaiDuBar(a.this.kHB.getPageContext().getPageActivity(), a.this.kkf);
                        bVar.dismiss();
                    }
                }
            }).ls(b.a.BOTTOM_TO_TOP).lt(17).d(this.kHB.getPageContext());
        }
    }

    public void cW(final View view) {
        String[] strArr;
        int i = 0;
        if (this.kHB != null && this.kHB.cLP() != null) {
            final i iVar = new i(this.kHB.getPageContext());
            if (this.kHB.cLP().getPbData().khm == null || this.kHB.cLP().getPbData().khm.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.kHB.cLP().getPbData().khm.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.kHB.cLP().getPbData().khm.size()) {
                        break;
                    }
                    strArr2[i2] = this.kHB.cLP().getPbData().khm.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.kHB.cLP().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.kHB.cLP().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.kHB.cLP().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.kHB.cLP().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new ap("c12097").ah("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).ah("obj_type", i4));
                    if (a.this.kHB.cLP().getPbData().khm != null && a.this.kHB.cLP().getPbData().khm.size() > i3) {
                        i3 = a.this.kHB.cLP().getPbData().khm.get(i3).sort_type.intValue();
                    }
                    boolean BT = a.this.kHB.cLP().BT(i3);
                    view.setTag(Integer.valueOf(a.this.kHB.cLP().cOe()));
                    if (BT) {
                        a.this.kHB.setIsLoading(true);
                    }
                }
            });
            iVar.showDialog();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kHB.getActivity());
            aVar.xk(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.xl(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.hJ(false);
            aVar.b(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new ap("c12528").dn("obj_id", metaData.getUserId()).ah("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new ap("c12528").dn("obj_id", metaData.getUserId()).ah("obj_locate", 1));
                    aVar2.dismiss();
                    if (a.this.kHB.cTk() != null) {
                        a.this.kHB.cTk().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.kHB.getPageContext().getUniqueId(), a.this.kHB.cLP().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.kHB.getPageContext()).aYL();
            TiebaStatic.log(new ap("c12527"));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.koA);
        userMuteAddAndDelCustomMessage.setTag(this.koA);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void zN(String str) {
        if (str == null) {
            str = "";
        }
        if (this.kHB != null && this.kHB.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kHB.getPageContext().getPageActivity());
            aVar.xl(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.kHB.getPageContext()).aYL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kHB.getBaseFragmentActivity());
        if (as.isEmpty(str)) {
            aVar.xl(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.xl(str);
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
        aVar.b(this.kHB.getPageContext()).aYL();
    }

    public void showLoadingDialog() {
        if (this.hdc == null) {
            this.hdc = new com.baidu.tbadk.core.view.a(this.kHB.getPageContext());
        }
        this.hdc.setDialogVisiable(true);
    }

    public void bMt() {
        if (this.hdc != null) {
            this.hdc.setDialogVisiable(false);
        }
    }

    public void f(SparseArray<Object> sparseArray) {
        PostData postData;
        boolean z;
        String str;
        g gVar;
        if (this.kHB != null && this.kHB.cLP() != null && sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            if (this.kol == null) {
                this.kol = new k(this.kHB.getContext());
                this.kol.a(this.kpd);
            }
            ArrayList arrayList = new ArrayList();
            boolean z2 = this.kHB.cLP().getPbData() != null && this.kHB.cLP().getPbData().cLa();
            if (sparseArray != null) {
                boolean z3 = false;
                boolean z4 = false;
                boolean z5 = false;
                boolean z6 = false;
                if (!(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                    z = false;
                } else {
                    z = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                }
                if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                    z3 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                }
                if (sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                    z4 = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
                }
                if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                    z5 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                }
                if (sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                    z6 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
                }
                if (!(sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String)) {
                    str = null;
                } else {
                    str = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
                }
                if (postData.aYc() != null) {
                    g gVar2 = new g(8, (postData.aYc().hasAgree && postData.aXM() == 5) ? this.kHB.getString(R.string.action_cancel_dislike) : this.kHB.getString(R.string.action_dislike), this.kol);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    gVar2.mTextView.setTag(sparseArray2);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z4 && z3) {
                        g gVar3 = new g(5, this.kHB.getString(R.string.mute_option), this.kol);
                        SparseArray sparseArray3 = new SparseArray();
                        sparseArray3.put(R.id.tag_user_mute_visible, true);
                        sparseArray3.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                        sparseArray3.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                        sparseArray3.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                        sparseArray3.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                        sparseArray3.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                        sparseArray3.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                        sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                        sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                        sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                        sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                        gVar3.mTextView.setTag(sparseArray3);
                        arrayList.add(gVar3);
                    } else {
                        if ((sm(z) && TbadkCoreApplication.isLogin()) && !z2) {
                            g gVar4 = new g(5, this.kHB.getString(R.string.report_text), this.kol);
                            gVar4.mTextView.setTag(str);
                            arrayList.add(gVar4);
                        }
                    }
                    g gVar5 = null;
                    if (z4) {
                        SparseArray sparseArray4 = new SparseArray();
                        sparseArray4.put(R.id.tag_should_manage_visible, true);
                        sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                        sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                        sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                        sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                        sparseArray4.put(R.id.tag_forbid_user_post_id, str);
                        if (z5) {
                            sparseArray4.put(R.id.tag_user_mute_visible, true);
                            sparseArray4.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                            sparseArray4.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                            sparseArray4.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                            sparseArray4.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                            sparseArray4.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                            sparseArray4.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                        } else {
                            sparseArray4.put(R.id.tag_user_mute_visible, false);
                        }
                        if (z6) {
                            sparseArray4.put(R.id.tag_should_delete_visible, true);
                            sparseArray4.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                            sparseArray4.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                            sparseArray4.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                            gVar5 = new g(6, this.kHB.getString(R.string.delete), this.kol);
                            gVar5.mTextView.setTag(sparseArray4);
                        } else {
                            sparseArray4.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, this.kHB.getString(R.string.bar_manager), this.kol);
                        gVar.mTextView.setTag(sparseArray4);
                    } else {
                        if (z6) {
                            SparseArray sparseArray5 = new SparseArray();
                            sparseArray5.put(R.id.tag_should_manage_visible, false);
                            sparseArray5.put(R.id.tag_user_mute_visible, false);
                            sparseArray5.put(R.id.tag_should_delete_visible, true);
                            sparseArray5.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                            sparseArray5.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                            sparseArray5.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                            sparseArray5.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                            if (this.kHB.cLP().getPbData().cKM() == 1002 && !z) {
                                gVar5 = new g(6, this.kHB.getString(R.string.report_text), this.kol);
                            } else {
                                gVar5 = new g(6, this.kHB.getString(R.string.delete), this.kol);
                            }
                            gVar5.mTextView.setTag(sparseArray5);
                        }
                        gVar = null;
                    }
                    if (gVar5 != null) {
                        arrayList.add(gVar5);
                    }
                    if (gVar != null) {
                        arrayList.add(gVar);
                    }
                }
                this.kol.aS(arrayList);
                this.kok = new i(this.kHB.getPageContext(), this.kol);
                this.kok.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eeP == null) {
                this.eeP = new com.baidu.tbadk.core.message.a();
            }
            if (this.eez == null) {
                this.eez = new com.baidu.tieba.tbadkCore.data.e();
                this.eez.uniqueId = this.kHB.getUniqueId();
            }
            c cVar = new c();
            cVar.dNB = 5;
            cVar.dNH = 8;
            cVar.dNG = 2;
            if (this.kHB != null && this.kHB.cLP() != null) {
                cVar.dNF = this.kHB.cLP().cOv();
            }
            if (cVar != null) {
                cVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (cVar != null) {
                        cVar.dNI = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (cVar != null) {
                        cVar.dNI = 1;
                        i = 0;
                    }
                }
                this.eeP.a(agreeData, i, this.kHB.getUniqueId(), false);
                this.eeP.a(agreeData, this.eez);
                if (this.kHB == null && this.kHB.cLP() != null && this.kHB.cLP().getPbData() != null) {
                    this.eeP.a(this.kHB.cNt(), cVar, agreeData, this.kHB.cLP().getPbData().cKx());
                    return;
                }
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (cVar != null) {
                cVar.dNI = 1;
            }
            i = 0;
            this.eeP.a(agreeData, i, this.kHB.getUniqueId(), false);
            this.eeP.a(agreeData, this.eez);
            if (this.kHB == null) {
            }
        }
    }

    public void a(final b.InterfaceC0492b interfaceC0492b, boolean z) {
        if (this.kvB != null) {
            this.kvB.dismiss();
            this.kvB = null;
        }
        k kVar = new k(this.kHB.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.kHB.cLP().getPbData() != null && this.kHB.cLP().getPbData().cKx() != null && !this.kHB.cLP().getPbData().cKx().isBjh()) {
            arrayList.add(new g(0, this.kHB.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new g(1, this.kHB.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.aS(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.kvB.dismiss();
                interfaceC0492b.a(null, i, view);
            }
        });
        this.kvB = new i(this.kHB.getPageContext(), kVar);
        this.kvB.showDialog();
    }

    public void aR(ArrayList<ai> arrayList) {
        if (this.kvw == null) {
            this.kvw = LayoutInflater.from(this.kHB.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.kHB.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.kvw);
        if (this.kvv == null) {
            this.kvv = new Dialog(this.kHB.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.kvv.setCanceledOnTouchOutside(true);
            this.kvv.setCancelable(true);
            this.kvE = (ScrollView) this.kvw.findViewById(R.id.good_scroll);
            this.kvv.setContentView(this.kvw);
            WindowManager.LayoutParams attributes = this.kvv.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.kvv.getWindow().setAttributes(attributes);
            this.gZi = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.14
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.kvA = (String) compoundButton.getTag();
                        if (a.this.gZh != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.gZh) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.kvA != null && !str.equals(a.this.kvA)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.kvx = (LinearLayout) this.kvw.findViewById(R.id.good_class_group);
            this.kvz = (TextView) this.kvw.findViewById(R.id.dialog_button_cancel);
            this.kvz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.kvv instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(a.this.kvv, a.this.kHB.getPageContext());
                    }
                }
            });
            this.kvy = (TextView) this.kvw.findViewById(R.id.dialog_button_ok);
            this.kvy.setOnClickListener(this.kHB.cTa());
        }
        this.kvx.removeAllViews();
        this.gZh = new ArrayList();
        CustomBlueCheckRadioButton fc = fc("0", this.kHB.getPageContext().getString(R.string.thread_good_class));
        this.gZh.add(fc);
        fc.setChecked(true);
        this.kvx.addView(fc);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                ai aiVar = arrayList.get(i2);
                if (aiVar != null && !TextUtils.isEmpty(aiVar.aUz()) && aiVar.aUA() > 0) {
                    CustomBlueCheckRadioButton fc2 = fc(String.valueOf(aiVar.aUA()), aiVar.aUz());
                    this.gZh.add(fc2);
                    View view = new View(this.kHB.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    ao.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.kvx.addView(view);
                    this.kvx.addView(fc2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.kvE.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.kHB.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.kHB.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.kHB.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.kvE.setLayoutParams(layoutParams2);
            this.kvE.removeAllViews();
            if (this.kvx != null && this.kvx.getParent() == null) {
                this.kvE.addView(this.kvx);
            }
        }
        com.baidu.adp.lib.f.g.a(this.kvv, this.kHB.getPageContext());
    }

    private CustomBlueCheckRadioButton fc(String str, String str2) {
        Activity pageActivity = this.kHB.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.gZi);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public boolean cK(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.koA;
        userMuteCheckCustomMessage.setTag(this.koA);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void cQq() {
        if (this.kvt != null) {
            this.kvt.dismiss();
        }
        if (this.kvu != null) {
            com.baidu.adp.lib.f.g.b(this.kvu, this.kHB.getPageContext());
        }
        if (this.kvv != null) {
            com.baidu.adp.lib.f.g.b(this.kvv, this.kHB.getPageContext());
        }
        if (this.kvs != null) {
            this.kvs.dismiss();
        }
    }

    public void cTO() {
        if (this.kok != null) {
            this.kok.dismiss();
        }
    }

    public void cQp() {
        aIX();
        this.kHB.cPw();
        if (this.kok != null) {
            this.kok.dismiss();
        }
        cQq();
    }

    public void cQo() {
        aIX();
        this.kHB.cPw();
        if (this.kok != null) {
            this.kok.dismiss();
        }
        this.kHB.cbV();
        cQq();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener cTc() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b cTP() {
        return this.knI;
    }

    public void setPhoneNumber(String str) {
        this.kkf = str;
    }

    public String cPU() {
        return this.kvA;
    }

    public View cPT() {
        if (this.kvw != null) {
            return this.kvw.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
