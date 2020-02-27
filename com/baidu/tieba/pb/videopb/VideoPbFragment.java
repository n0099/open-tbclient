package com.baidu.tieba.pb.videopb;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.arch.lifecycle.q;
import android.arch.lifecycle.y;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.media.ExifInterface;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.g;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.switchs.PbReplySwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.h;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.f.b;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ah;
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.pb.pb.main.as;
import com.baidu.tieba.pb.pb.main.s;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import java.io.Serializable;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes9.dex */
public class VideoPbFragment extends BaseFragment implements VoiceManager.c, TbRichTextView.c, h, com.baidu.tieba.pb.videopb.a, b {
    private AppBarLayout CD;
    private EditorTools FO;
    private ImageView Lb;
    private CustomViewPager cXZ;
    public View dFJ;
    private com.baidu.adp.lib.d.b<ImageView> dMm;
    private com.baidu.adp.lib.d.b<GifView> dMn;
    private com.baidu.adp.lib.d.b<TextView> dPa;
    private com.baidu.adp.lib.d.b<View> dPb;
    private com.baidu.adp.lib.d.b<LinearLayout> dPc;
    private com.baidu.adp.lib.d.b<RelativeLayout> dPd;
    private ImageView eEv;
    private VoiceManager goj;
    private com.baidu.tieba.frs.profession.permission.c grK;
    private com.baidu.tieba.f.b gsm;
    public aj hPw;
    private com.baidu.tieba.pb.videopb.c.a iCm;
    private PbFakeFloorModel iGW;
    private PbActivity iGZ;
    public ap iHF;
    private g iHN;
    private com.baidu.tbadk.editortools.pb.e iHO;
    private com.baidu.tieba.frs.profession.permission.c iHQ;
    private EmotionImageData iHR;
    private com.baidu.tbadk.core.view.d iHV;
    private com.baidu.tieba.pb.pb.main.emotion.model.a iHq;
    int iHt;
    private TextView iOA;
    private int iOC;
    private int iOD;
    private View iOd;
    private View iOu;
    private ImageView iOw;
    private ImageView iOx;
    private ImageView iOy;
    private com.baidu.tieba.pb.view.c iOz;
    private s iPa;
    private String iPr;
    public View iTM;
    private TbImageView iYA;
    private ValueAnimator iYB;
    private ValueAnimator iYC;
    public com.baidu.tieba.pb.videopb.b.a iYD;
    private float iYH;
    private float iYI;
    private boolean iYJ;
    private ObjectAnimator iYO;
    private ObjectAnimator iYP;
    private NewPagerSlidingTabBaseStrip iYm;
    private VideoPbFragmentAdapter iYn;
    private View iYo;
    private View iYp;
    private VideoContainerLayout iYq;
    private com.baidu.tieba.pb.videopb.videoView.a iYr;
    private f iYs;
    private View iYt;
    private View iYu;
    private TextView iYw;
    private TextView iYx;
    private ImageView iYy;
    private TBSpecificationBtn iYz;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View mStatusBar;
    private RelativeLayout rootView;
    public static int iYj = 0;
    public static int iYk = 1;
    public static int iOS = 3;
    public static int iOT = 0;
    public static int iOU = 3;
    public static int iOV = 4;
    public static int iOW = 5;
    public static int iOX = 6;
    private static final int hfi = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int iYl = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a iIK = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.f.b.a
        public void bk(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.cln();
            } else {
                com.baidu.tieba.pb.a.b.clm();
            }
        }
    };
    private long iHg = 0;
    View.OnClickListener iYv = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.iCm != null) {
                TiebaStatic.log(new an("c13590").cy("obj_id", VideoPbFragment.this.iCm.getTitle()).cy("obj_name", VideoPbFragment.this.iCm.ctH()).X("obj_type", 2).cy("fid", VideoPbFragment.this.clz().getPbData().getForumId()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("tid", VideoPbFragment.this.clz().getPbData().getThreadId()));
                String link = VideoPbFragment.this.iCm.getLink();
                if (!TextUtils.isEmpty(link)) {
                    if (URLUtil.isHttpUrl(link) || URLUtil.isHttpsUrl(link)) {
                        ba.aGE().b(VideoPbFragment.this.getPageContext(), new String[]{link});
                        return;
                    }
                    Uri parse = Uri.parse(link);
                    if (parse != null) {
                        UtilHelper.dealOneScheme(VideoPbFragment.this.getActivity(), parse.toString());
                    }
                }
            }
        }
    };
    private boolean mIsLoading = false;
    private com.baidu.tbadk.baseEditMark.a iHz = null;
    private com.baidu.tbadk.coreExtra.model.a daa = null;
    private ForumManageModel fKw = null;
    private boolean iHk = false;
    private View iOv = null;
    private TextView hgK = null;
    private boolean iOr = false;
    private String dyp = null;
    private boolean iHC = false;
    private boolean iHD = false;
    private boolean iHE = false;
    private boolean iHm = false;
    int[] iHs = new int[2];
    private int iHu = -1;
    private int iHv = Integer.MIN_VALUE;
    private int iIb = 0;
    private int iYF = Integer.MIN_VALUE;
    private boolean isPaused = false;
    private final PbModel.a iIA = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
            com.baidu.tbadk.editortools.g mm;
            VideoPbFragment.this.cpF();
            VideoPbFragment.this.bWp();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.qr(false);
            if (z && eVar != null) {
                bj cks = eVar.cks();
                ((e) y.b(VideoPbFragment.this.getActivity()).l(e.class)).c(eVar, i2);
                VideoPbFragment.this.G(eVar);
                com.baidu.tieba.pb.videopb.c.a ckS = eVar.ckS();
                if (ckS != null) {
                    VideoPbFragment.this.a(ckS);
                }
                VideoPbFragment.this.H(eVar);
                VideoPbFragment.this.c(z, i, i2, i3, eVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(eVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.iHz != null) {
                    VideoPbFragment.this.iHz.fm(eVar.ayJ());
                }
                AntiData anti = eVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.dyp = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.dyp) && VideoPbFragment.this.iHO != null && VideoPbFragment.this.iHO.aOr() != null && (mm = VideoPbFragment.this.iHO.aOr().mm(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.dyp)) {
                        ((View) mm).setOnClickListener(VideoPbFragment.this.dza);
                    }
                }
                if (VideoPbFragment.this.hPw != null && cks != null && cks.aCm() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(cks.aCm());
                    VideoPbFragment.this.hPw.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.clz().cnw());
                        jSONObject.put("fid", VideoPbFragment.this.clz().getForumId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB, jSONObject));
                }
                if (i != 0) {
                    k kVar = new k();
                    kVar.setOpType("2");
                    kVar.start();
                }
                if (VideoPbFragment.this.csR() != null) {
                    if (i != -1) {
                        ArrayList<PostData> arrayList = null;
                        if (VideoPbFragment.this.clz() != null && VideoPbFragment.this.clz().getPbData() != null) {
                            arrayList = VideoPbFragment.this.clz().getPbData().cku();
                        }
                        if (v.getCount(arrayList) == 0 || (v.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).cKY() == 1)) {
                            if (VideoPbFragment.this.csR().cna()) {
                                VideoPbFragment.this.csR().Gd(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                VideoPbFragment.this.csR().Gd(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                        } else {
                            VideoPbFragment.this.csR().Gc(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                        }
                    } else {
                        VideoPbFragment.this.csR().Gc("");
                    }
                    VideoPbFragment.this.csR().endLoadData();
                } else {
                    return;
                }
            }
            com.baidu.tieba.s.c.cJY().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.e eVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0374a iIC = new a.InterfaceC0374a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0374a
        public void c(boolean z, boolean z2, String str) {
            VideoPbFragment.this.cpF();
            if (z && VideoPbFragment.this.clz() != null) {
                if (VideoPbFragment.this.iHz != null) {
                    VideoPbFragment.this.iHz.fm(z2);
                }
                VideoPbFragment.this.clz().pX(z2);
                if (VideoPbFragment.this.clz().ayJ()) {
                    VideoPbFragment.this.cmL();
                } else if (VideoPbFragment.this.csR() != null) {
                    VideoPbFragment.this.csR().ctC();
                }
                if (z2) {
                    if (VideoPbFragment.this.iHz != null) {
                        if (VideoPbFragment.this.iHz.ayM() != null && VideoPbFragment.this.clz() != null && VideoPbFragment.this.clz().getPbData() != null && VideoPbFragment.this.clz().getPbData().cks() != null && VideoPbFragment.this.clz().getPbData().cks().aCm() != null) {
                            MarkData ayM = VideoPbFragment.this.iHz.ayM();
                            MetaData aCm = VideoPbFragment.this.clz().getPbData().cks().aCm();
                            if (ayM != null && aCm != null) {
                                if (!aq.equals(TbadkCoreApplication.getCurrentAccount(), aCm.getUserId()) && !aCm.hadConcerned()) {
                                    VideoPbFragment.this.iYD.b(aCm);
                                } else {
                                    VideoPbFragment.this.showToast(R.string.add_mark_on_pb);
                                }
                            } else {
                                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.add_mark));
                            }
                        } else {
                            return;
                        }
                    }
                    VideoPbFragment.this.cmI();
                    return;
                }
                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private com.baidu.tbadk.editortools.pb.b dyt = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aOO() {
            if (VideoPbFragment.this.iHF == null || VideoPbFragment.this.iHF.cqv() == null || !VideoPbFragment.this.iHF.cqv().cUc()) {
                return !VideoPbFragment.this.yN(aj.cZV);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.iHF.cqv().cUe());
            if (VideoPbFragment.this.iHO != null && (VideoPbFragment.this.iHO.aPe() || VideoPbFragment.this.iHO.aPf())) {
                VideoPbFragment.this.iHO.a(false, VideoPbFragment.this.iHF.cqy());
            }
            VideoPbFragment.this.iHF.qw(true);
            return true;
        }
    };
    private final CustomMessageListener iIi = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.clz() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.iHO != null) {
                    VideoPbFragment.this.qp(VideoPbFragment.this.iHO.aOX());
                }
                VideoPbFragment.this.cpi();
                VideoPbFragment.this.iYD.cpW();
            }
        }
    };
    private CustomMessageListener iIl = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        VideoPbFragment.this.b((com.baidu.tieba.pb.data.l) eVar.getData());
                        return;
                    case 1:
                        VideoPbFragment.this.a((ForumManageModel.b) eVar.getData(), false);
                        return;
                    case 2:
                        if (eVar.getData() == null) {
                            VideoPbFragment.this.a(false, (MarkData) null);
                            return;
                        } else {
                            VideoPbFragment.this.a(true, (MarkData) eVar.getData());
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    };
    private final CustomMessageListener gpv = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.isPaused) {
                VideoPbFragment.this.cnc();
            }
        }
    };
    private CustomMessageListener iIB = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.cmC();
            }
        }
    };
    private CustomMessageListener iIw = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.iYD != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.iYD.iHW) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.iYD.bqp();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.iYD.getExtra();
                DataRes dataRes = aVar.kuE;
                if (aVar.error == 0 && dataRes != null) {
                    int i = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = i == 1;
                    if (aq.isEmpty(str)) {
                        sparseArray.put(R.id.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.tag_user_mute_msg, str);
                    }
                    sparseArray.put(R.id.tag_user_mute_visible, true);
                    z = z2;
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, false);
                }
                int intValue = ((Integer) sparseArray.get(R.id.tag_from)).intValue();
                if (intValue == 0) {
                    VideoPbFragment.this.iYD.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.iYD.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener iIu = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.iYD != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.iYD.iHW) {
                VideoPbFragment.this.iYD.bqp();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.e pbData = VideoPbFragment.this.clz().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.ckF().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.iHV.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.iYD.vq(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.iYD.cmZ();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.iHV.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener iIv = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.iYD != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.iYD.iHW) {
                VideoPbFragment.this.iYD.bqp();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.iHV.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.iHV.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b iHT = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aOO() {
            if (VideoPbFragment.this.iHF == null || VideoPbFragment.this.iHF.cqw() == null || !VideoPbFragment.this.iHF.cqw().cUc()) {
                return !VideoPbFragment.this.yN(aj.cZW);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.iHF.cqw().cUe());
            if (VideoPbFragment.this.iPa != null && VideoPbFragment.this.iPa.cml() != null && VideoPbFragment.this.iPa.cml().aPf()) {
                VideoPbFragment.this.iPa.cml().a(VideoPbFragment.this.iHF.cqy());
            }
            VideoPbFragment.this.iHF.qx(true);
            return true;
        }
    };
    private final NewWriteModel.d dyz = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                an anVar = new an("c13268");
                anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.clz() != null && VideoPbFragment.this.clz().getPbData() != null) {
                    anVar.cy("fid", VideoPbFragment.this.clz().getPbData().getForumId());
                }
                anVar.cy("tid", VideoPbFragment.this.clz().cnw());
                anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            VideoPbFragment.this.bEi();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.clz() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.clz().FX(postWriteCallBackData.getPostId());
                    if (VideoPbFragment.this.csR() != null) {
                        VideoPbFragment.this.iIb = VideoPbFragment.this.csR().cpH();
                        VideoPbFragment.this.iYF = VideoPbFragment.this.csR().ctF();
                        VideoPbFragment.this.clz().cr(VideoPbFragment.this.iIb, VideoPbFragment.this.iYF);
                    }
                }
                if (VideoPbFragment.this.cXZ != null) {
                    VideoPbFragment.this.cXZ.setCurrentItem(VideoPbFragment.iYk);
                }
                VideoPbFragment.this.iYD.cpW();
                VideoPbFragment.this.iHF.cqu();
                if (VideoPbFragment.this.iHO != null) {
                    VideoPbFragment.this.qp(VideoPbFragment.this.iHO.aOX());
                }
                VideoPbFragment.this.cpe();
                VideoPbFragment.this.qr(true);
                VideoPbFragment.this.clz().cnQ();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null && VideoPbFragment.this.csR() != null) {
                            VideoPbFragment.this.csR().ctC();
                        }
                    } else if (VideoPbFragment.this.clz().getHostMode()) {
                        com.baidu.tieba.pb.data.e pbData = VideoPbFragment.this.clz().getPbData();
                        if (pbData != null && pbData.cks() != null && pbData.cks().aCm() != null && (userId = pbData.cks().aCm().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.clz().cnH()) {
                            VideoPbFragment.this.cpD();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.clz().cnH()) {
                        VideoPbFragment.this.cpD();
                    }
                    VideoPbFragment.this.cmB();
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.iHO.aPe() || VideoPbFragment.this.iHO.aPf()) {
                    VideoPbFragment.this.iHO.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.iHF.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.hPw != null) {
                    VideoPbFragment.this.hPw.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (aaVar == null && i != 227001) {
                VideoPbFragment.this.a(i, antiData, str);
            }
        }
    };
    private View.OnClickListener dza = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.showToast(VideoPbFragment.this.dyp);
        }
    };
    private CustomMessageListener iIk = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.iHO != null) {
                    VideoPbFragment.this.qp(VideoPbFragment.this.iHO.aOX());
                }
                VideoPbFragment.this.qr(false);
            }
        }
    };
    private int iYG = 0;
    private boolean iYK = true;
    private View.OnTouchListener iYL = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.iYG == 1) {
                if (!VideoPbFragment.this.iYK) {
                    VideoPbFragment.this.csV();
                    UtilHelper.showStatusBar(VideoPbFragment.this.cng(), VideoPbFragment.this.cng().getRootView());
                    VideoPbFragment.this.iYK = true;
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(VideoPbFragment.this.iYN);
                    com.baidu.adp.lib.f.e.gx().postDelayed(VideoPbFragment.this.iYN, 3000L);
                }
            } else if (VideoPbFragment.this.iYG == 2 && (VideoPbFragment.this.iYK || VideoPbFragment.this.csX())) {
                VideoPbFragment.this.csW();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cng(), VideoPbFragment.this.cng().getRootView());
                VideoPbFragment.this.iYK = false;
                if (VideoPbFragment.this.iYr != null) {
                    VideoPbFragment.this.iYr.qS(false);
                }
            }
            VideoPbFragment.this.iYG = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener iYM = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.iYG = 0;
            VideoPbFragment.this.iYH = 0.0f;
            VideoPbFragment.this.iYI = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.iYH += f;
            VideoPbFragment.this.iYI += f2;
            if (VideoPbFragment.this.iYG == 0 && !VideoPbFragment.this.iYJ && VideoPbFragment.this.iYr != null && !VideoPbFragment.this.iYr.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.iYI) <= Math.abs(VideoPbFragment.this.iYH) || VideoPbFragment.this.iYI > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.iYI) > Math.abs(VideoPbFragment.this.iYH) && VideoPbFragment.this.iYI > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.iYG = 2;
                    }
                } else {
                    VideoPbFragment.this.iYG = 1;
                }
            }
            return true;
        }
    };
    private Runnable iYN = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.iYK && !VideoPbFragment.this.csX()) {
                VideoPbFragment.this.csW();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cng(), VideoPbFragment.this.cng().getRootView());
                VideoPbFragment.this.iYK = false;
            }
        }
    };
    private final com.baidu.adp.base.d fKB = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.clz() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.fKw.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.fKw.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.clz().cnQ();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.iVF != 1002 || bVar.eLE) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.mSuccess, dVar.kjg, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.fKw.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.fKw.getLoadDataMode(), gVar.mSuccess, gVar.kjg, false);
                    VideoPbFragment.this.iYD.aM(gVar.kjj);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener drz = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.gsm.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d iIy = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                an anVar = new an("c13268");
                anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.clz() != null && VideoPbFragment.this.clz().getPbData() != null) {
                    anVar.cy("fid", VideoPbFragment.this.clz().getPbData().getForumId());
                }
                if (VideoPbFragment.this.clz() != null) {
                    anVar.cy("tid", VideoPbFragment.this.clz().cnw());
                }
                anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (VideoPbFragment.this.iHF != null) {
                    VideoPbFragment.this.iHF.cqt();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (VideoPbFragment.this.hPw != null) {
                    VideoPbFragment.this.hPw.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.iHF != null) {
                if (VideoPbFragment.this.iPa != null && VideoPbFragment.this.iPa.cml() != null && VideoPbFragment.this.iPa.cml().aPf()) {
                    VideoPbFragment.this.iPa.cml().a(postWriteCallBackData);
                }
                VideoPbFragment.this.iHF.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c dys = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aOP() {
            VideoPbFragment.this.showProgressBar();
        }
    };
    public View.OnClickListener auX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            boolean v;
            int i2 = 2;
            if (view != null && VideoPbFragment.this.isAdded()) {
                if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    an anVar = new an("c13398");
                    anVar.cy("tid", VideoPbFragment.this.clz().cnw());
                    anVar.cy("fid", VideoPbFragment.this.clz().getForumId());
                    anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.X("obj_locate", 1);
                    TiebaStatic.log(anVar);
                    if (VideoPbFragment.this.iHk) {
                        VideoPbFragment.this.iHk = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.clz() != null && VideoPbFragment.this.clz().getPbData() != null && VideoPbFragment.this.iGW != null && postData.aCm() != null && postData.cKY() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.iPa != null) {
                                    VideoPbFragment.this.iPa.cmh();
                                }
                                com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                                lVar.a(VideoPbFragment.this.clz().getPbData().getForum());
                                lVar.setThreadData(VideoPbFragment.this.clz().getPbData().cks());
                                lVar.f(postData);
                                VideoPbFragment.this.iGW.d(lVar);
                                VideoPbFragment.this.iGW.setPostId(postData.getId());
                                VideoPbFragment.this.b(view, postData.aCm().getUserId(), "");
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.clz().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.iHO != null) {
                                    VideoPbFragment.this.qp(VideoPbFragment.this.iHO.aOX());
                                }
                            }
                        }
                    }
                } else if (VideoPbFragment.this.csR() != null && VideoPbFragment.this.csR().cpS() != null && view == VideoPbFragment.this.csR().cpS()) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.clz().pV(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        VideoPbFragment.this.csR().cpE();
                    }
                } else if (VideoPbFragment.this.iYD != null && VideoPbFragment.this.iYD.cra() != null && view == VideoPbFragment.this.iYD.cra().coE()) {
                    VideoPbFragment.this.iYD.arS();
                } else if (VideoPbFragment.this.iYD != null && ((VideoPbFragment.this.iYD.cra() != null && view == VideoPbFragment.this.iYD.cra().coF()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.iYD.cpW();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.bEi();
                        VideoPbFragment.this.cpD();
                        if (view.getId() == R.id.owner_reply) {
                            v = VideoPbFragment.this.clz().v(true, VideoPbFragment.this.cmP());
                        } else {
                            v = view.getId() == R.id.all_reply ? VideoPbFragment.this.clz().v(false, VideoPbFragment.this.cmP()) : VideoPbFragment.this.clz().FU(VideoPbFragment.this.cmP());
                        }
                        view.setTag(Boolean.valueOf(v));
                        if (v) {
                            VideoPbFragment.this.bWq();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.dFJ) {
                    if (VideoPbFragment.this.clz() != null && VideoPbFragment.this.clz().getPbData() != null) {
                        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            an anVar2 = new an("c13266");
                            anVar2.cy("uid", TbadkCoreApplication.getCurrentAccount());
                            anVar2.cy("fid", VideoPbFragment.this.clz().getPbData().getForumId());
                            anVar2.cy("tid", VideoPbFragment.this.clz().cnw());
                            anVar2.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(anVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.iGZ, VideoPbFragment.this.dFJ);
                        VideoPbFragment.this.iGZ.finish();
                    }
                } else if (view == VideoPbFragment.this.iTM && VideoPbFragment.this.iYD != null) {
                    if (VideoPbFragment.this.clz() == null || VideoPbFragment.this.clz().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> cku = VideoPbFragment.this.clz().getPbData().cku();
                    if ((cku == null || cku.size() <= 0) && VideoPbFragment.this.clz().cnx()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new an("c12378").cy("tid", VideoPbFragment.this.clz().cnw()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("fid", VideoPbFragment.this.clz().getForumId()));
                    VideoPbFragment.this.iYD.cmD();
                } else if (VideoPbFragment.this.iYD != null && VideoPbFragment.this.iYD.cra() != null && view == VideoPbFragment.this.iYD.cra().coF()) {
                    VideoPbFragment.this.iYD.arS();
                } else if (VideoPbFragment.this.iYD != null && ((VideoPbFragment.this.iYD.cra() != null && view == VideoPbFragment.this.iYD.cra().coL()) || view.getId() == R.id.pb_sort_type)) {
                    VideoPbFragment.this.iYD.cpW();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.bEi();
                            VideoPbFragment.this.cpD();
                            VideoPbFragment.this.iYD.cG(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.clz().cnO()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.iYD != null && VideoPbFragment.this.iYD.cra() != null && view == VideoPbFragment.this.iYD.cra().coD()) {
                    if (VideoPbFragment.this.clz() != null && VideoPbFragment.this.clz().getPbData() != null && VideoPbFragment.this.clz().getPbData().cks() != null) {
                        VideoPbFragment.this.iYD.arS();
                        TiebaStatic.log(new an("c13062"));
                        VideoPbFragment.this.iYD.FP(VideoPbFragment.this.clz().getPbData().cks().aCC());
                    }
                } else if (VideoPbFragment.this.iYD != null && VideoPbFragment.this.iYD.cra() != null && view == VideoPbFragment.this.iYD.cra().coM()) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 1) {
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        am.v(true, false);
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).X("obj_type", 0).X("obj_source", 1));
                    } else if (skinType == 0 || skinType == 4) {
                        UtilHelper.showSkinChangeAnimation(VideoPbFragment.this.getActivity());
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        UtilHelper.setNavigationBarBackground(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                        TbadkCoreApplication.getInst().setSkinType(1);
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).X("obj_type", 1).X("obj_source", 1));
                    }
                    VideoPbFragment.this.iYD.cqZ();
                } else if (VideoPbFragment.this.iYD != null && (view == VideoPbFragment.this.iYD.cpB() || (VideoPbFragment.this.iYD.cra() != null && (view == VideoPbFragment.this.iYD.cra().coI() || view == VideoPbFragment.this.iYD.cra().coG())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.clz() != null || VideoPbFragment.this.clz().getPbData() != null) {
                        if ((VideoPbFragment.this.clz().getPbData().ckE() == 1 || VideoPbFragment.this.clz().getPbData().ckE() == 3) && !VideoPbFragment.this.fKw.cLM()) {
                            VideoPbFragment.this.iYD.cpW();
                            if (VideoPbFragment.this.iYD.cra() != null && view == VideoPbFragment.this.iYD.cra().coG()) {
                                if (VideoPbFragment.this.clz().getPbData().cks().aCh() == 1) {
                                    i = 5;
                                } else {
                                    i = 4;
                                }
                            } else if (VideoPbFragment.this.iYD.cra() != null && view == VideoPbFragment.this.iYD.cra().coI()) {
                                i = VideoPbFragment.this.clz().getPbData().cks().aCi() == 1 ? 3 : 6;
                            } else {
                                i = view == VideoPbFragment.this.iYD.cpB() ? 2 : 0;
                            }
                            ForumData forum = VideoPbFragment.this.clz().getPbData().getForum();
                            String name = forum.getName();
                            String id = forum.getId();
                            String id2 = VideoPbFragment.this.clz().getPbData().cks().getId();
                            VideoPbFragment.this.showProgressBar();
                            VideoPbFragment.this.fKw.b(id, name, id2, i, VideoPbFragment.this.iYD.cpC());
                        }
                    }
                } else if (VideoPbFragment.this.iYD != null && VideoPbFragment.this.iYD.cra() != null && view == VideoPbFragment.this.iYD.cra().coK()) {
                    if (VideoPbFragment.this.clz() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.iYD.cpW();
                        SparseArray<Object> b = VideoPbFragment.this.b(VideoPbFragment.this.clz().getPbData(), VideoPbFragment.this.clz().cnx(), 1);
                        if (b != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.clz().getPbData().getForum().getId(), VideoPbFragment.this.clz().getPbData().getForum().getName(), VideoPbFragment.this.clz().getPbData().cks().getId(), String.valueOf(VideoPbFragment.this.clz().getPbData().getUserData().getUserId()), (String) b.get(R.id.tag_forbid_user_name), (String) b.get(R.id.tag_forbid_user_name_show), (String) b.get(R.id.tag_forbid_user_post_id), (String) b.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.iYD != null && VideoPbFragment.this.iYD.cra() != null && view == VideoPbFragment.this.iYD.cra().coH()) {
                    if (VideoPbFragment.this.clz() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.clz().getPbData(), VideoPbFragment.this.clz().cnx(), 1);
                        if (b2 != null) {
                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.iYD.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.iYD.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.iYD.arS();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        an anVar3 = new an("c13398");
                        anVar3.cy("tid", VideoPbFragment.this.clz().cnw());
                        anVar3.cy("fid", VideoPbFragment.this.clz().getForumId());
                        anVar3.cy("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar3.X("obj_locate", 4);
                        TiebaStatic.log(anVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new an("c10517").X("obj_locate", 3).cy("fid", VideoPbFragment.this.clz().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.clz() != null && VideoPbFragment.this.clz().getPbData() != null) {
                        if (VideoPbFragment.this.iYD != null) {
                            VideoPbFragment.this.iYD.cpW();
                        }
                        PostData postData2 = (PostData) ((SparseArray) view.getTag()).get(R.id.tag_load_sub_data);
                        if (postData2 != null) {
                            if (postData2.cLk() == 1) {
                                TiebaStatic.log(new an("c12630"));
                            }
                            if (postData2.khp != null) {
                                an aGw = postData2.khp.aGw();
                                aGw.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    aGw.X("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    aGw.X("obj_locate", 8);
                                }
                                TiebaStatic.log(aGw);
                            }
                            String cnw = VideoPbFragment.this.clz().cnw();
                            String id3 = postData2.getId();
                            int ckE = VideoPbFragment.this.clz().getPbData() != null ? VideoPbFragment.this.clz().getPbData().ckE() : 0;
                            VideoPbFragment.this.bEi();
                            TiebaStatic.log("c11742");
                            if (VideoPbFragment.this.csR() != null && VideoPbFragment.this.csR().ctE() != null) {
                                PbActivity.a FS = VideoPbFragment.this.csR().ctE().FS(id3);
                                if (postData2 != null && VideoPbFragment.this.clz() != null && VideoPbFragment.this.clz().getPbData() != null && FS != null) {
                                    SubPbActivityConfig addBigImageData = new SubPbActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cnw, id3, "pb", true, null, false, null, ckE, postData2.crX(), VideoPbFragment.this.clz().getPbData().getAnti(), false, postData2.aCm().getIconInfo()).addBigImageData(FS.iEl, FS.iEm, FS.iEn, FS.index);
                                    addBigImageData.setKeyFromForumId(VideoPbFragment.this.clz().getForumId());
                                    addBigImageData.setBjhData(VideoPbFragment.this.clz().cnE());
                                    addBigImageData.setKeyPageStartFrom(VideoPbFragment.this.clz().cof());
                                    addBigImageData.setFromFrsForumId(VideoPbFragment.this.clz().getFromForumId());
                                    VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply) {
                    if (VideoPbFragment.this.clz() != null) {
                        an anVar4 = new an("c13398");
                        anVar4.cy("tid", VideoPbFragment.this.clz().cnw());
                        anVar4.cy("fid", VideoPbFragment.this.clz().getForumId());
                        anVar4.cy("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar4.X("obj_locate", 6);
                        TiebaStatic.log(anVar4);
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if (sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData3 = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                if (postData3.khp != null) {
                                    an aGw2 = postData3.khp.aGw();
                                    aGw2.delete("obj_locate");
                                    aGw2.X("obj_locate", 8);
                                    TiebaStatic.log(aGw2);
                                }
                                if (VideoPbFragment.this.clz() != null && VideoPbFragment.this.clz().getPbData() != null && VideoPbFragment.this.iGW != null && postData3.aCm() != null && postData3.cKY() != 1) {
                                    if (VideoPbFragment.this.iPa != null) {
                                        VideoPbFragment.this.iPa.cmh();
                                    }
                                    com.baidu.tieba.pb.data.l lVar2 = new com.baidu.tieba.pb.data.l();
                                    lVar2.a(VideoPbFragment.this.clz().getPbData().getForum());
                                    lVar2.setThreadData(VideoPbFragment.this.clz().getPbData().cks());
                                    lVar2.f(postData3);
                                    VideoPbFragment.this.iGW.d(lVar2);
                                    VideoPbFragment.this.iGW.setPostId(postData3.getId());
                                    VideoPbFragment.this.b(view, postData3.aCm().getUserId(), "");
                                    if (VideoPbFragment.this.iHO != null) {
                                        VideoPbFragment.this.qp(VideoPbFragment.this.iHO.aOX());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.iYD != null && VideoPbFragment.this.clz() != null && VideoPbFragment.this.csR() != null) {
                        VideoPbFragment.this.iYD.cpW();
                        if (VideoPbFragment.this.yO(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.clz() != null) {
                            VideoPbFragment.this.cmK();
                            if (VideoPbFragment.this.clz().getPbData() != null && VideoPbFragment.this.clz().getPbData().cks() != null && VideoPbFragment.this.clz().getPbData().cks().aCm() != null) {
                                TiebaStatic.log(new an("c13402").cy("tid", VideoPbFragment.this.clz().cnw()).cy("fid", VideoPbFragment.this.clz().getPbData().getForumId()).X("obj_locate", 3).cy("uid", VideoPbFragment.this.clz().getPbData().cks().aCm().getUserId()));
                            }
                            if (VideoPbFragment.this.clz().getPbData().cks() != null && VideoPbFragment.this.clz().getPbData().cks().aCm() != null && VideoPbFragment.this.clz().getPbData().cks().aCm().getUserId() != null && VideoPbFragment.this.iHz != null) {
                                int g = VideoPbFragment.this.iYD.g(VideoPbFragment.this.clz().getPbData());
                                bj cks = VideoPbFragment.this.clz().getPbData().cks();
                                if (!cks.aBb()) {
                                    if (cks.aBc()) {
                                        i2 = 3;
                                    } else if (cks.aEe()) {
                                        i2 = 4;
                                    } else {
                                        i2 = cks.aEf() ? 5 : 1;
                                    }
                                }
                                TiebaStatic.log(new an("c12526").cy("tid", VideoPbFragment.this.clz().cnw()).X("obj_locate", 1).cy("obj_id", VideoPbFragment.this.clz().getPbData().cks().aCm().getUserId()).X("obj_type", VideoPbFragment.this.iHz.ayJ() ? 0 : 1).X("obj_source", g).X("obj_param1", i2));
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.qQ(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.clz() != null && VideoPbFragment.this.iYD != null && VideoPbFragment.this.cXZ != null && VideoPbFragment.this.clz().getPbData() != null && VideoPbFragment.this.clz().getPbData().cks() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        if (VideoPbFragment.this.clz().getPbData().cks().aCd() != 0) {
                            int currentItem = VideoPbFragment.this.cXZ.getCurrentItem();
                            if (currentItem == VideoPbFragment.iYj) {
                                VideoPbFragment.this.cXZ.setCurrentItem(VideoPbFragment.iYk);
                            } else if (currentItem == VideoPbFragment.iYk) {
                                if (VideoPbFragment.this.csR() != null && VideoPbFragment.this.bGD() != null) {
                                    an cy = new an("c13403").cy("tid", VideoPbFragment.this.clz().cnw()).cy("fid", VideoPbFragment.this.clz().getPbData().getForumId()).cy("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView bGD = VideoPbFragment.this.bGD();
                                    boolean canScrollVertically = bGD.canScrollVertically(1);
                                    boolean canScrollVertically2 = bGD.canScrollVertically(-1);
                                    if (VideoPbFragment.this.CD != null) {
                                        VideoPbFragment.this.CD.setExpanded(false, true);
                                    }
                                    if (bGD.getLayoutManager() != null && (bGD.getLayoutManager() instanceof LinearLayoutManager)) {
                                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) bGD.getLayoutManager();
                                        if (!canScrollVertically2 && canScrollVertically) {
                                            if (VideoPbFragment.this.iHu != -1 || VideoPbFragment.this.iHv != Integer.MIN_VALUE) {
                                                if (VideoPbFragment.this.iHu > 3 || (VideoPbFragment.this.iHu == 3 && VideoPbFragment.this.iHv < (-equipmentHeight))) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.iHu, VideoPbFragment.this.iHv + equipmentHeight);
                                                    bGD.smoothScrollBy(0, equipmentHeight);
                                                } else if (VideoPbFragment.this.iHu >= 2) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.iHu, VideoPbFragment.this.iHv + (equipmentHeight / 2));
                                                    bGD.smoothScrollBy(0, equipmentHeight / 2);
                                                } else if (VideoPbFragment.this.iHu == 1) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.iHu, VideoPbFragment.this.iHv + (equipmentHeight / 4));
                                                    bGD.smoothScrollBy(0, equipmentHeight / 4);
                                                } else {
                                                    bGD.smoothScrollBy(0, -VideoPbFragment.this.iHv);
                                                }
                                                cy.X("obj_locate", 2);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            int firstVisiblePosition = bGD.getFirstVisiblePosition();
                                            View childAt = bGD.getChildAt(0);
                                            int top2 = childAt == null ? 0 : childAt.getTop();
                                            VideoPbFragment.this.iHu = firstVisiblePosition;
                                            VideoPbFragment.this.iHv = top2;
                                            if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top2 < (-equipmentHeight) && bGD.getCount() >= 6)) {
                                                linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                bGD.smoothScrollToPosition(0);
                                            } else {
                                                bGD.smoothScrollToPosition(0);
                                            }
                                            cy.X("obj_locate", 1);
                                        }
                                        TiebaStatic.log(cy);
                                        TiebaStatic.log(new an("c12942").X("obj_type", 1).X("obj_locate", 4).cy("tid", VideoPbFragment.this.clz().cnw()));
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (VideoPbFragment.this.clz() != null && VideoPbFragment.this.clz().getPbData() != null && VideoPbFragment.this.clz().getPbData().cks() != null && VideoPbFragment.this.clz().getPbData().cks().aCm() != null) {
                                TiebaStatic.log(new an("c13402").cy("tid", VideoPbFragment.this.clz().cnw()).cy("fid", VideoPbFragment.this.clz().getPbData().getForumId()).X("obj_locate", 2).cy("uid", VideoPbFragment.this.clz().getPbData().cks().aCm().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.qR(false);
                        VideoPbFragment.this.cmx();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.iIb >= 0) {
                        if (VideoPbFragment.this.clz() != null) {
                            VideoPbFragment.this.clz().cog();
                        }
                        if (VideoPbFragment.this.clz() != null && VideoPbFragment.this.csR() != null && VideoPbFragment.this.csR().ctD() != null) {
                            VideoPbFragment.this.csR().ctD().setData(VideoPbFragment.this.clz().getPbData());
                        }
                        VideoPbFragment.this.iIb = 0;
                        VideoPbFragment.this.iYF = Integer.MIN_VALUE;
                        if (VideoPbFragment.this.clz() != null && VideoPbFragment.this.csR() != null) {
                            VideoPbFragment.this.csR().cu(VideoPbFragment.this.clz().coj(), VideoPbFragment.this.clz().cok());
                            VideoPbFragment.this.clz().cr(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.clz() != null) {
                        an anVar5 = new an("c13398");
                        anVar5.cy("tid", VideoPbFragment.this.clz().cnw());
                        anVar5.cy("fid", VideoPbFragment.this.clz().getForumId());
                        anVar5.cy("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar5.X("obj_locate", 2);
                        TiebaStatic.log(anVar5);
                    }
                } else if (view.getId() == R.id.pb_item_tail_content) {
                    if (bc.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                        String string2 = com.baidu.tbadk.core.sharedPref.b.aFB().getString("tail_link", "");
                        if (!StringUtils.isNull(string2)) {
                            TiebaStatic.log("c10056");
                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                        }
                        VideoPbFragment.this.cpi();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.cpi();
                }
            }
        }
    };
    private View.OnClickListener iEQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.iYD != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.iYD.b(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.iYD.cA(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.iYD.b(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.iYD.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    private a iYE = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void cmI() {
        if (clz() != null && clz().getPbData() != null && clz().getPbData().cks() != null) {
            bj cks = clz().getPbData().cks();
            cks.mRecomAbTag = clz().coq();
            cks.mRecomWeight = clz().coo();
            cks.mRecomSource = clz().cop();
            cks.mRecomExtra = clz().cor();
            if (cks.getFid() == 0) {
                cks.setFid(com.baidu.adp.lib.f.b.toLong(clz().getForumId(), 0L));
            }
            an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cks, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmB() {
        if (clz() != null && clz().getPbData() != null && clz().getPbData().cks() != null) {
            bj cks = clz().getPbData().cks();
            cks.mRecomAbTag = clz().coq();
            cks.mRecomWeight = clz().coo();
            cks.mRecomSource = clz().cop();
            cks.mRecomExtra = clz().cor();
            if (cks.getFid() == 0) {
                cks.setFid(com.baidu.adp.lib.f.b.toLong(clz().getForumId(), 0L));
            }
            an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cks, "c13563");
            if (a2 != null) {
                a2.X("reply_type", 1);
                TiebaStatic.log(a2);
            }
        }
    }

    public void a(int i, boolean z, String str, boolean z2) {
        hideProgressBar();
        if (z && z2) {
            showToast(getPageContext().getString(R.string.success));
        } else if (z2) {
            if (aq.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.kjg) ? bVar.kjg : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.sS(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.15
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.fG(true);
                aVar.b(getPageContext());
                aVar.aEA();
            } else {
                a(0, bVar.mSuccess, bVar.kjg, z);
            }
            if (bVar.mSuccess) {
                if (bVar.fXV == 1) {
                    ArrayList<PostData> cku = clz().getPbData().cku();
                    int size = cku.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(cku.get(i).getId())) {
                            i++;
                        } else {
                            cku.remove(i);
                            break;
                        }
                    }
                    clz().getPbData().cks().jJ(clz().getPbData().cks().aCd() - 1);
                    if (csR() != null) {
                        csR().ctC();
                    }
                } else if (bVar.fXV == 0) {
                    cmJ();
                } else if (bVar.fXV == 2) {
                    ArrayList<PostData> cku2 = clz().getPbData().cku();
                    int size2 = cku2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= cku2.get(i2).cKV().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(cku2.get(i2).cKV().get(i3).getId())) {
                                i3++;
                            } else {
                                cku2.get(i2).cKV().remove(i3);
                                cku2.get(i2).cKX();
                                z2 = true;
                                break;
                            }
                        }
                        cku2.get(i2).Jb(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3 && csR() != null) {
                        csR().ctC();
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = clz().getPbData().ckD().iCQ;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cKV().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cKV().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cKV().remove(i2);
                    list.get(i).cKX();
                    z = true;
                    break;
                }
            }
            list.get(i).Jb(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2 && csR() != null) {
            csR().ctC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null && clz() != null && clz().getPbData() != null && clz().getPbData().cks() != null) {
            a(this.fKw.getLoadDataMode(), gVar.mSuccess, gVar.kjg, false);
            if (gVar.mSuccess) {
                this.iHC = true;
                if (i == 2 || i == 3) {
                    this.iHD = true;
                    this.iHE = false;
                } else if (i == 4 || i == 5) {
                    this.iHD = false;
                    this.iHE = true;
                }
                if (i == 2) {
                    clz().getPbData().cks().jM(1);
                    clz().setIsGood(1);
                } else if (i == 3) {
                    clz().getPbData().cks().jM(0);
                    clz().setIsGood(0);
                } else if (i == 4) {
                    clz().getPbData().cks().jL(1);
                    clz().yQ(1);
                } else if (i == 5) {
                    clz().getPbData().cks().jL(0);
                    clz().yQ(0);
                }
            }
            if (clz().getPbData().cks() != null && csS() != null) {
                csS().ctz();
            }
        }
    }

    private void cmJ() {
        if (clz().cny() || clz().cnA()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", clz().cnw());
            PbActivity pbActivity = this.iGZ;
            PbActivity pbActivity2 = this.iGZ;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, clz().cnw()));
        if (cmM()) {
            this.iGZ.finish();
        }
    }

    private boolean cmM() {
        if (clz() == null) {
            return true;
        }
        if (clz().getPbData() == null || !clz().getPbData().ckQ()) {
            if (clz().ayJ()) {
                final MarkData cnP = clz().cnP();
                if (cnP == null || !clz().getIsFromMark() || bGD() == null) {
                    return true;
                }
                final MarkData yX = clz().yX(bGD().getFirstVisiblePosition());
                if (yX == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cnP);
                    this.iGZ.setResult(-1, intent);
                    return true;
                } else if (yX.getPostId() == null || yX.getPostId().equals(cnP.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cnP);
                    this.iGZ.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.sS(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.iHz != null) {
                                if (VideoPbFragment.this.iHz.ayJ()) {
                                    VideoPbFragment.this.iHz.ayK();
                                    VideoPbFragment.this.iHz.fm(false);
                                }
                                VideoPbFragment.this.iHz.a(yX);
                                VideoPbFragment.this.iHz.fm(true);
                                VideoPbFragment.this.iHz.ayL();
                            }
                            cnP.setPostId(yX.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cnP);
                            VideoPbFragment.this.iGZ.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.clM();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cnP);
                            VideoPbFragment.this.iGZ.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.clM();
                        }
                    });
                    aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.19
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.b(getBaseFragmentActivity().getPageContext());
                    aVar.aEA();
                    return false;
                }
            } else if (clz().getPbData() == null || clz().getPbData().cku() == null || clz().getPbData().cku().size() <= 0 || !clz().getIsFromMark()) {
                return true;
            } else {
                this.iGZ.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clM() {
        this.iGZ.clM();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void qQ(boolean z) {
        com.baidu.tieba.pb.data.e pbData;
        int i;
        if (clz() != null && this.iYD != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = clz().getPbData()) != null) {
                bj cks = pbData.cks();
                if (cks != null && cks.aCm() != null) {
                    TiebaStatic.log(new an("c13402").cy("tid", clz().cnw()).cy("fid", pbData.getForumId()).X("obj_locate", 4).cy("uid", cks.aCm().getUserId()));
                }
                if (cks != null) {
                    if (cks.aBb()) {
                        i = 2;
                    } else if (cks.aBc()) {
                        i = 3;
                    } else if (cks.aEe()) {
                        i = 4;
                    } else if (cks.aEf()) {
                        i = 5;
                    }
                    an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    anVar.cy("tid", clz().cnw());
                    anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.cy("fid", clz().getForumId());
                    if (!z) {
                        anVar.X("obj_locate", 6);
                    } else {
                        anVar.X("obj_locate", 5);
                    }
                    anVar.X("obj_name", i);
                    anVar.X("obj_type", 2);
                    if (cks != null) {
                        if (cks.aBb()) {
                            anVar.X("obj_type", 10);
                        } else if (cks.aBc()) {
                            anVar.X("obj_type", 9);
                        } else if (cks.aEf()) {
                            anVar.X("obj_type", 8);
                        } else if (cks.aEe()) {
                            anVar.X("obj_type", 7);
                        } else if (cks.isShareThread) {
                            anVar.X("obj_type", 6);
                        } else if (cks.threadType == 0) {
                            anVar.X("obj_type", 1);
                        } else if (cks.threadType == 40) {
                            anVar.X("obj_type", 2);
                        } else if (cks.threadType == 49) {
                            anVar.X("obj_type", 3);
                        } else if (cks.threadType == 54) {
                            anVar.X("obj_type", 4);
                        } else {
                            anVar.X("obj_type", 5);
                        }
                    }
                    if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    TiebaStatic.log(anVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (clz().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> cku = pbData.cku();
                        if ((cku == null || cku.size() <= 0) && clz().cnx()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.iYD.cpW();
                        bEi();
                        TiebaStatic.log(new an("c11939"));
                        if (!AntiHelper.d(getContext(), cks)) {
                            if (this.iOz != null) {
                                this.iOz.setEnable(false);
                                t(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                yP(z ? 2 : 1);
                                return;
                            }
                            this.iYD.showLoadingDialog();
                            clz().coa().t(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                an anVar2 = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                anVar2.cy("tid", clz().cnw());
                anVar2.cy("uid", TbadkCoreApplication.getCurrentAccount());
                anVar2.cy("fid", clz().getForumId());
                if (!z) {
                }
                anVar2.X("obj_name", i);
                anVar2.X("obj_type", 2);
                if (cks != null) {
                }
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                TiebaStatic.log(anVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment csx() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        e eVar = (e) y.b(getActivity()).l(e.class);
        G(eVar.ctd());
        H(eVar.ctd());
        if (clz() != null && clz().getPbData() != null) {
            boolean isFromMark = clz().getIsFromMark();
            com.baidu.tieba.pb.data.e pbData = clz().getPbData();
            if (isFromMark) {
                PostData F = F(pbData);
                if (pbData.ayI() != null && !pbData.ayI().equals(F.getId()) && this.cXZ != null) {
                    this.cXZ.setCurrentItem(iYk);
                }
            }
        }
        eVar.cte().observe(this, new q<bj>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aM */
            public void onChanged(@Nullable bj bjVar) {
                if (bjVar != null && bjVar.aCD() != null) {
                    if (VideoPbFragment.this.iYr.getVideoUrl() == null || !VideoPbFragment.this.iYr.getVideoUrl().equals(bjVar.aCD().video_url)) {
                        if (!aq.isEmpty(VideoPbFragment.this.iYr.getVideoUrl())) {
                            VideoPbFragment.this.iHm = true;
                            VideoPbFragment.this.cXZ.setCurrentItem(VideoPbFragment.iYj);
                        }
                        if (VideoPbFragment.this.iYs == null || !VideoPbFragment.this.iYs.isPlaying()) {
                            VideoPbFragment.this.csy();
                            VideoPbFragment.this.aL(bjVar);
                        }
                        VideoPbFragment.this.csz();
                        if (VideoPbFragment.this.iYs.ctr()) {
                            VideoPbFragment.this.iYs.start();
                        }
                        boolean z = !aq.equals(VideoPbFragment.this.iYr.getVideoUrl(), bjVar.aCD().video_url);
                        VideoPbFragment.this.iYr.setData(bjVar);
                        VideoPbFragment.this.iYr.ctO();
                        VideoPbFragment.this.iYr.qZ(VideoPbFragment.this.cXZ.getCurrentItem() == 0);
                        if (z) {
                            VideoPbFragment.this.iYr.startPlay();
                            VideoPbFragment.this.iYr.ctX();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.iYr.setData(bjVar);
                }
            }
        });
        eVar.ctn().observe(this, new q<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: p */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.cXZ.setCurrentItem(num.intValue());
            }
        });
        eVar.cti().observe(this, new q<bj>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aM */
            public void onChanged(@Nullable bj bjVar) {
                VideoPbFragment.this.iYr.aQ(bjVar);
            }
        });
        eVar.ctj().observe(this, new q<bj>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aM */
            public void onChanged(@Nullable bj bjVar) {
                VideoPbFragment.this.iYr.aR(bjVar);
            }
        });
        eVar.ctk().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.csK();
            }
        });
        eVar.ctl().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csy() {
        ViewGroup.LayoutParams layoutParams = this.iYu.getLayoutParams();
        layoutParams.height = 0;
        this.iYu.setLayoutParams(layoutParams);
        this.iYu.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csz() {
        if (this.iYs == null) {
            this.iYs = new f(getBaseFragmentActivity(), this.iYq);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(cng()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.iYq.getOriginHeight() + statusBarHeight);
            final e eVar = (e) y.b(getActivity()).l(e.class);
            this.iYs.b(eVar.ctf(), rect);
            if (this.iYs.ctr()) {
                this.iYs.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (eVar.ctg() || VideoPbFragment.this.clz().getTabIndex() == VideoPbFragment.iYk) {
                            VideoPbFragment.this.cXZ.setCurrentItem(VideoPbFragment.iYk);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (eVar.ctg() || VideoPbFragment.this.clz().getTabIndex() == VideoPbFragment.iYk) {
                            VideoPbFragment.this.cXZ.setCurrentItem(VideoPbFragment.iYk);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (eVar.ctg() || clz().getTabIndex() == iYk) {
                this.cXZ.setCurrentItem(iYk);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.iYJ && (this.iYK || csX())) {
            csW();
            UtilHelper.hideStatusBar(cng(), cng().getRootView());
            this.iYK = false;
            if (this.iYr != null) {
                this.iYr.qS(false);
            }
        }
        if (i == 4) {
            return this.iYr.onBackPress();
        }
        if (i == 24) {
            return this.iYr.ctT();
        }
        if (i == 25) {
            return this.iYr.ctU();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aL(bj bjVar) {
        double d;
        int i;
        ViewGroup.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        CoordinatorLayout.LayoutParams layoutParams3;
        Rect cos;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        double equipmentHeight = (2.0d * equipmentWidth) / l.getEquipmentHeight(getContext());
        if (bjVar != null && bjVar.aCD() != null) {
            int intValue = bjVar.aCD().video_width.intValue();
            int intValue2 = bjVar.aCD().video_height.intValue();
            if (intValue2 > 0) {
                d = (intValue * 1.0f) / intValue2;
                if (d > 1.7777777777777777d) {
                    d = 1.7777777777777777d;
                }
                if (d >= equipmentHeight) {
                    equipmentHeight = d;
                }
                int ceil = (int) Math.ceil(equipmentWidth / equipmentHeight);
                int height = (clz() != null || (cos = clz().cos()) == null) ? ceil : cos.height();
                i = 0;
                layoutParams = this.iYq.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.iYq.setLayoutParams(layoutParams);
                this.iYq.setMaxHeight(ceil);
                this.iYq.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.iYq.setOriginHeight(height);
                layoutParams2 = (RelativeLayout.LayoutParams) this.iYm.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, iYl);
                } else {
                    layoutParams2.height = iYl;
                }
                this.iYm.setLayoutParams(layoutParams2);
                layoutParams3 = (CoordinatorLayout.LayoutParams) this.CD.getLayoutParams();
                int i2 = ceil + iYl;
                if (layoutParams3 != null) {
                    layoutParams3 = new CoordinatorLayout.LayoutParams(-1, i2);
                } else {
                    layoutParams3.height = i2;
                }
                this.CD.setLayoutParams(layoutParams3);
                if (i == 0 && (this.CD.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.CD.getLayoutParams()).getBehavior();
                    if (behavior instanceof VideoZoomBehavior) {
                        ((VideoZoomBehavior) behavior).setTopAndBottomOffset(-i);
                        return;
                    }
                    return;
                }
            }
        }
        d = 1.7777777777777777d;
        if (d > 1.7777777777777777d) {
        }
        if (d >= equipmentHeight) {
        }
        int ceil2 = (int) Math.ceil(equipmentWidth / equipmentHeight);
        if (clz() != null) {
        }
        i = 0;
        layoutParams = this.iYq.getLayoutParams();
        if (layoutParams != null) {
        }
        this.iYq.setLayoutParams(layoutParams);
        this.iYq.setMaxHeight(ceil2);
        this.iYq.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.iYq.setOriginHeight(height);
        layoutParams2 = (RelativeLayout.LayoutParams) this.iYm.getLayoutParams();
        if (layoutParams2 != null) {
        }
        this.iYm.setLayoutParams(layoutParams2);
        layoutParams3 = (CoordinatorLayout.LayoutParams) this.CD.getLayoutParams();
        int i22 = ceil2 + iYl;
        if (layoutParams3 != null) {
        }
        this.CD.setLayoutParams(layoutParams3);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.iHg = System.currentTimeMillis();
        super.onCreate(bundle);
        initData();
        ak(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.iHV = new com.baidu.tbadk.core.view.d();
        this.iHV.toastTime = 1000L;
        if (this.iYD != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.iYD.iHW;
            userMuteAddAndDelCustomMessage.setTag(this.iYD.iHW);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.iYD.iHW;
            userMuteCheckCustomMessage.setTag(this.iYD.iHW);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        com.baidu.tieba.s.c.cJY().w(getUniqueId());
    }

    private void initData() {
        this.iHz = com.baidu.tbadk.baseEditMark.a.a(this.iGZ);
        if (this.iHz != null) {
            this.iHz.a(this.iIC);
        }
        this.fKw = new ForumManageModel(this.iGZ);
        this.fKw.setLoadDataCallBack(this.fKB);
        this.daa = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.iYD = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void ak(Bundle bundle) {
        this.iHN = new g();
        d(this.iHN);
        this.iHO = (com.baidu.tbadk.editortools.pb.e) this.iHN.dV(getActivity());
        this.iHO.a(this.iGZ.getPageContext());
        this.iHO.a(this.dyz);
        this.iHO.a(this.dys);
        this.iHO.a(this.iGZ.getPageContext(), bundle);
        this.iHO.aOr().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.iHO.aOr().gB(true);
        pK(true);
        this.iHO.a(clz().cnL(), clz().cnw(), clz().coc());
        registerListener(this.iIl);
        registerListener(this.iIB);
        registerListener(this.iIk);
        registerListener(this.iIi);
        registerListener(this.gpv);
        if (!clz().cnC()) {
            this.iHO.vl(clz().cnw());
        }
        if (clz().cod()) {
            this.iHO.vk(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.iHO.vk(cpk());
        }
        this.iHF = new ap();
        if (this.iHO.aOQ() != null) {
            this.iHF.e(this.iHO.aOQ().getInputView());
        }
        this.iHO.a(this.dyt);
        this.hPw = new aj(getPageContext());
        this.hPw.a(new aj.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
            @Override // com.baidu.tbadk.core.util.aj.a
            public void l(boolean z, int i) {
                if (z) {
                    if (i == aj.cZV) {
                        VideoPbFragment.this.iHO.a((String) null, (WriteData) null);
                    } else if (i == aj.cZW && VideoPbFragment.this.iPa != null && VideoPbFragment.this.iPa.cml() != null) {
                        VideoPbFragment.this.iPa.cml().aPm();
                    } else if (i == aj.cZX) {
                        VideoPbFragment.this.c(VideoPbFragment.this.iHR);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = (RelativeLayout) layoutInflater.inflate(R.layout.video_pb_fragment, viewGroup, false);
        initUI();
        return this.rootView;
    }

    private void initUI() {
        this.gsm = new com.baidu.tieba.f.b(getActivity());
        this.gsm.a(iIK);
        this.iYJ = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        bcH();
        this.CD = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.iYo = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.iYq = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.iYr = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.iYq);
        this.iYr.setUniqueId(getUniqueId());
        this.iYr.ad(this);
        this.iYr.cH(cng().getRootView());
        this.iYr.cI(this.iYt);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.iYm = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.iYu = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.cXZ = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.iYp = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.iYp.setOnClickListener(this.auX);
        csB();
        csA();
        csC();
        this.iYn = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.cXZ.setAdapter(this.iYn);
        this.iYm.setViewPager(this.cXZ);
        this.iYm.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (VideoPbFragment.this.csR() != null) {
                        VideoPbFragment.this.csR().qY(false);
                    }
                    if (VideoPbFragment.this.csS() != null) {
                        VideoPbFragment.this.csS().qY(true);
                        VideoPbFragment.this.zv(VideoPbFragment.this.csS().ctB() != 0 ? 0 : 8);
                    }
                    e eVar = (e) y.b(VideoPbFragment.this.getActivity()).l(e.class);
                    if (eVar.ctk() != null && eVar.ctk().getValue() != null && eVar.ctk().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.iYr.qZ(z);
                    VideoPbFragment.this.cpi();
                    if (VideoPbFragment.this.clz() != null && VideoPbFragment.this.clz().getPbData() != null) {
                        TiebaStatic.log(new an("c13592").cy("tid", VideoPbFragment.this.clz().cnw()).cy("fid", VideoPbFragment.this.clz().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.csS() != null) {
                        VideoPbFragment.this.csS().qY(false);
                    }
                    if (VideoPbFragment.this.csR() != null) {
                        VideoPbFragment.this.csR().qY(true);
                        int ctB = VideoPbFragment.this.csR().ctB();
                        int ctG = VideoPbFragment.this.csR().ctG();
                        if (ctB != 0) {
                            VideoPbFragment.this.zv(8);
                            VideoPbFragment.this.csR().zv(0);
                        } else if (ctG != 0) {
                            VideoPbFragment.this.csR().zv(8);
                            VideoPbFragment.this.zv(0);
                        } else {
                            VideoPbFragment.this.csR().zv(8);
                            VideoPbFragment.this.zv(8);
                        }
                    }
                    VideoPbFragment.this.iYr.qZ(false);
                    VideoPbFragment.this.CD.setExpanded(false, true);
                    if (VideoPbFragment.this.clz() != null && VideoPbFragment.this.clz().getPbData() != null) {
                        TiebaStatic.log(new an("c13593").cy("tid", VideoPbFragment.this.clz().cnw()).cy("fid", VideoPbFragment.this.clz().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.iYn.zx(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.iOd = this.rootView.findViewById(R.id.viewstub_progress);
        csD();
        csE();
        if (!this.iYJ && this.iYK) {
            csW();
            UtilHelper.hideStatusBar(cng(), cng().getRootView());
            this.iYK = false;
        }
    }

    private void csA() {
        this.iYw = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.iYA = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.iYx = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.iYy = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.iYz = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.iYA.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.iYA.setConrers(15);
        this.iYz.setConfig(new com.baidu.tbadk.core.view.commonBtn.d());
        this.iYy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c13591"));
                VideoPbFragment.this.csM();
            }
        });
        this.iYz.setOnClickListener(this.iYv);
        this.iYu.setOnClickListener(this.iYv);
    }

    private void csB() {
        this.iYm.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.iYm.setContainerLayoutParams(layoutParams);
        this.iYm.setRectPaintColor(R.color.cp_link_tip_a);
        this.iYm.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.iYm.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.iYm.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.iYm.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.iYm.setExpandedTabLayoutParams(layoutParams2);
    }

    public void qR(boolean z) {
        if (this.CD != null) {
            this.CD.setExpanded(z);
        }
    }

    private void csC() {
        this.iOu = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.iOv = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.iOC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.iOD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.hgK = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.hgK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.qR(false);
                VideoPbFragment.this.cmx();
                if (VideoPbFragment.this.clz() != null && VideoPbFragment.this.clz().getPbData() != null && VideoPbFragment.this.clz().getPbData().cks() != null && VideoPbFragment.this.clz().getPbData().cks().aCm() != null) {
                    TiebaStatic.log(new an("c13402").cy("tid", VideoPbFragment.this.clz().cnw()).cy("fid", VideoPbFragment.this.clz().getPbData().getForumId()).X("obj_locate", 1).cy("uid", VideoPbFragment.this.clz().getPbData().cks().aCm().getUserId()));
                }
            }
        });
        this.iOw = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.iOw.setOnClickListener(this.auX);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.iOx = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.iOx.setOnClickListener(this.auX);
        if (booleanExtra) {
            this.iOx.setVisibility(8);
        } else {
            this.iOx.setVisibility(0);
        }
        this.iOy = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.iOy.setOnClickListener(this.auX);
        this.iOz = new com.baidu.tieba.pb.view.c(this.iOy);
        this.iOz.cuh();
        this.iOA = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
        qr(false);
    }

    private void bcH() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.bEj();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.iYt = this.rootView.findViewById(R.id.status_bar_background);
        if (this.iYJ) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(cng());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.iYt.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(cng());
            this.iYt.setLayoutParams(layoutParams2);
            this.iYt.setVisibility(0);
        }
        this.dFJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.auX);
        this.eEv = (ImageView) this.dFJ.findViewById(R.id.widget_navi_back_button);
        SvgManager.aGA().a(this.eEv, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.iTM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.auX);
        this.Lb = (ImageView) this.iTM.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.iTM.setLayoutParams(layoutParams3);
        SvgManager.aGA().a(this.Lb, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.iTM.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.iYM);
        this.mNavigationBar.setOnTouchListener(this.iYL);
    }

    public void csD() {
        setEditorTools(this.iHO.aOr());
    }

    private void csE() {
        this.iGW = new PbFakeFloorModel(getPageContext());
        this.iPa = new s(getPageContext(), this.iGW, this.rootView);
        this.iPa.a(this.iIy);
        this.iGW.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void p(PostData postData) {
                VideoPbFragment.this.iGW.q(postData);
                if (VideoPbFragment.this.csR() != null) {
                    VideoPbFragment.this.csR().ctC();
                }
                VideoPbFragment.this.iPa.cmh();
                VideoPbFragment.this.FO.aMO();
                VideoPbFragment.this.qr(false);
            }
        });
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.iGZ = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (clz() != null) {
            clz().au(bundle);
        }
        if (getPageContext() != null && getPageContext().getPageActivity() != null) {
            getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.isPaused = true;
        getVoiceManager().onPause(getPageContext());
        this.iYr.mL(true);
        if (clz() != null && !clz().cnC()) {
            this.iHO.saveDraft(clz().cnw());
        }
        com.baidu.tbadk.BdToken.c.axx().axC();
        MessageManager.getInstance().unRegisterListener(this.iIu);
        MessageManager.getInstance().unRegisterListener(this.iIv);
        MessageManager.getInstance().unRegisterListener(this.iIw);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.isPaused = false;
        getVoiceManager().onResume(getPageContext());
        this.iYr.mL(false);
        cnc();
        registerListener(this.iIu);
        registerListener(this.iIv);
        registerListener(this.iIw);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.iYn != null && this.cXZ != null) {
            this.iYn.zx(z ? this.cXZ.getCurrentItem() : -1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.s.c.cJY().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.cJY().x(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.iOz != null) {
            this.iOz.onDestroy();
        }
        if (this.fKw != null) {
            this.fKw.cancelLoadData();
        }
        if (this.iYr != null) {
            this.iYr.onDestroy();
        }
        if (this.iHq != null) {
            this.iHq.cancelLoadData();
        }
        if (this.hPw != null) {
            this.hPw.onDestroy();
        }
        if (clz() != null) {
            clz().cancelLoadData();
            clz().destory();
            if (clz().cnZ() != null) {
                clz().cnZ().onDestroy();
            }
        }
        if (this.iHO != null) {
            this.iHO.onDestroy();
        }
        this.iHV = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.iGZ);
        this.iYm.onChangeSkinType();
        am.setBackgroundColor(this.iYm, R.color.cp_bg_line_h);
        this.iHF.onChangeSkinType();
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        if (this.iYs == null || !this.iYs.isPlaying()) {
            am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        }
        am.setBackgroundColor(this.mStatusBar, R.color.cp_mask_b);
        am.setBackgroundColor(this.iYt, R.color.cp_mask_b_alpha66);
        if (this.FO != null) {
            this.FO.onChangeSkinType(i);
        }
        if (this.iPa != null) {
            this.iPa.onChangeSkinType(i);
        }
        if (this.hgK != null) {
            am.setViewTextColor(this.hgK, (int) R.color.cp_cont_d);
            this.hgK.setBackgroundDrawable(am.ay(l.getDimens(getContext(), R.dimen.tbds47), am.getColor(R.color.cp_bg_line_j)));
        }
        if (this.iOx != null && clz() != null) {
            if (clz().ayJ()) {
                SvgManager.aGA().a(this.iOx, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aGA().a(this.iOx, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.iOw != null) {
            SvgManager.aGA().a(this.iOw, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (clz() != null) {
            t(clz().getPbData());
        }
        am.setViewTextColor(this.iOA, (int) R.color.cp_cont_b);
        if (this.iOu != null) {
            am.setBackgroundResource(this.iOu, R.drawable.bottom_shadow);
        }
        am.setBackgroundColor(this.iOv, R.color.cp_bg_line_h);
        if (csR() != null) {
            csR().onChangeSkinType(i);
        }
        if (csS() != null) {
            csS().onChangeSkinType(i);
        }
        if (this.iYo != null) {
            am.setBackgroundResource(this.iYo, R.drawable.personalize_tab_shadow);
        }
        if (this.iYu != null) {
            am.setBackgroundColor(this.iYu, R.color.cp_bg_line_g);
        }
        if (this.iYy != null) {
            SvgManager.aGA().a(this.iYy, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.iYw != null) {
            am.setViewTextColor(this.iYw, (int) R.color.cp_cont_b);
        }
        if (this.iYx != null) {
            am.setViewTextColor(this.iYx, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.goj == null) {
            this.goj = VoiceManager.instance();
        }
        return this.goj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEi() {
        if (this.goj != null) {
            this.goj.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment cne() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cnf() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel clz() {
        return this.iGZ.clz();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cng() {
        return this.iGZ;
    }

    public com.baidu.tbadk.baseEditMark.a csF() {
        return this.iHz;
    }

    public View.OnClickListener csG() {
        return this.auX;
    }

    public View.OnClickListener csH() {
        return this.iEQ;
    }

    public View.OnLongClickListener csI() {
        return this.iYD.csI();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (as.Gh(objArr[i].getLink()) && (drawable = am.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                    spannableStringBuilder2.setSpan(new com.baidu.tbadk.widget.c(drawable), 0, "#4%2&@#907$12#@96476)w7we9e~@$%&&".length(), 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                    spannableStringBuilder.setSpan(objArr[i], spannableStringBuilder.getSpanStart(objArr[i]), spannableStringBuilder.length(), 18);
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                    spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                    return;
                }
            }
        }
    }

    public BdTypeRecyclerView bGD() {
        Iterator<BaseFragment> it = this.iYn.ctb().iterator();
        while (it.hasNext()) {
            BaseFragment next = it.next();
            if (next instanceof ReplyFragment) {
                return ((ReplyFragment) next).getListView();
            }
        }
        return null;
    }

    private void pK(boolean z) {
        this.iHO.gF(z);
        this.iHO.gG(z);
        this.iHO.gH(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.iYD != null) {
            if (z) {
                this.iYD.cpW();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.iYD.cpX();
            } else {
                this.iYD.cpW();
            }
        }
    }

    public boolean yN(int i) {
        if (this.hPw == null || clz() == null || clz().getPbData() == null || clz().getPbData().getAnti() == null) {
            return true;
        }
        return this.hPw.ax(clz().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean cmz() {
        if ((clz() != null && clz().getPbData().ckQ()) || this.hPw == null || clz() == null || clz().getPbData() == null || clz().getPbData().getAnti() == null) {
            return true;
        }
        return this.hPw.ks(clz().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && clz() != null) {
            gVar.setForumName(clz().clq());
            if (clz().getPbData() != null && clz().getPbData().getForum() != null) {
                gVar.a(clz().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(clz());
        }
    }

    public void cpy() {
        if (this.FO != null) {
            this.FO.display();
            if (this.iHO != null) {
                this.iHO.aOU();
            }
            cqg();
        }
    }

    private boolean cmw() {
        PbModel clz = clz();
        if (clz == null || clz.getPbData() == null) {
            return false;
        }
        bj cks = clz.getPbData().cks();
        clz.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), cks);
    }

    public void cmx() {
        if (checkUpIsLogin() && clz() != null && clz().getPbData() != null && clz().getPbData().getForum() != null && !cmw()) {
            if (clz().getPbData().ckQ()) {
                bPv();
                return;
            }
            if (this.grK == null) {
                this.grK = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.grK.tP(0);
                this.grK.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void lw(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void t(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void lx(boolean z) {
                        if (z) {
                            VideoPbFragment.this.bPv();
                        }
                    }
                });
            }
            this.grK.C(clz().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(clz().cnw(), 0L));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.iHO.onActivityResult(i, i2, intent);
        if (this.iHq != null) {
            this.iHq.onActivityResult(i, i2, intent);
        }
        if (this.iPa != null) {
            this.iPa.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cmK();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.cBY().A(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.iHR = emotionImageData;
                        if (yN(aj.cZX)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                default:
                    return;
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (cng() != null) {
            if (this.iYK && !TbSingleton.getInstance().isNotchScreen(cng()) && !TbSingleton.getInstance().isCutoutScreen(cng())) {
                csW();
                UtilHelper.hideStatusBar(cng(), cng().getRootView());
                this.iYK = false;
            }
            this.iYE.iYY = z;
            csJ();
            csK();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.iGZ;
        if (i == 0) {
            cpe();
            if (this.iPa != null) {
                this.iPa.cmh();
            }
            qr(false);
        }
        cpi();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.iHO.resetData();
                        this.iHO.setVoiceModel(pbEditorData.getVoiceModel());
                        this.iHO.b(writeData);
                        com.baidu.tbadk.editortools.l mp = this.iHO.aOr().mp(6);
                        if (mp != null && mp.dwz != null) {
                            mp.dwz.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.iGZ;
                        if (i == -1) {
                            this.iHO.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.iPa != null && this.iPa.cml() != null) {
                            com.baidu.tbadk.editortools.pb.h cml = this.iPa.cml();
                            cml.setThreadData(clz().getPbData().cks());
                            cml.b(writeData);
                            cml.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l mp2 = cml.aOr().mp(6);
                            if (mp2 != null && mp2.dwz != null) {
                                mp2.dwz.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.iGZ;
                            if (i == -1) {
                                cml.aPm();
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (clz() != null && !clz().cnC()) {
                    antiData.setBlock_forum_name(clz().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(clz().getPbData().getForum().getId());
                    antiData.setUser_name(clz().getPbData().getUserData().getUserName());
                    antiData.setUser_id(clz().getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bb(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            if (this.iYD != null) {
                this.iYD.vq(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void cni() {
        if (clz() != null && this.iGZ != null) {
            if (this.iHO == null || !this.iHO.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.iHO = (com.baidu.tbadk.editortools.pb.e) dVar.dV(getContext());
                this.iHO.a(this.iGZ.getPageContext());
                this.iHO.a(this.dyz);
                this.iHO.a(this.dys);
                this.iHO.a(this.iGZ.getPageContext(), this.iGZ.getIntent() == null ? null : this.iGZ.getIntent().getExtras());
                this.iHO.aOr().gB(true);
                setEditorTools(this.iHO.aOr());
                if (!clz().cnC()) {
                    this.iHO.vl(clz().cnw());
                }
                if (clz().cod()) {
                    this.iHO.vk(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.iHO.vk(cpk());
                }
            }
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.FO = editorTools;
        this.FO.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.FO.getParent() == null) {
            this.rootView.addView(this.FO, layoutParams);
        }
        this.FO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.FO.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.40
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                    if (((com.baidu.tbadk.coreExtra.data.q) aVar.data).aJu() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.q) aVar.data).aJu() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.iHO.c((com.baidu.tbadk.coreExtra.data.q) aVar.data);
                            VideoPbFragment.this.iHO.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cpe();
        this.iHO.b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (VideoPbFragment.this.FO != null && VideoPbFragment.this.FO.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3 && TextUtils.isEmpty(charSequence.toString().substring(i, i + i3))) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (VideoPbFragment.this.iHF != null && VideoPbFragment.this.iHF.cqv() != null) {
                    if (!VideoPbFragment.this.iHF.cqv().cUd()) {
                        VideoPbFragment.this.iHF.qw(false);
                    }
                    VideoPbFragment.this.iHF.cqv().tH(false);
                }
            }
        });
    }

    public void bPv() {
        if (!checkUpIsLogin()) {
            if (clz() != null) {
                TiebaStatic.log(new an("c10517").X("obj_locate", 2).cy("fid", clz().getForumId()));
            }
        } else if (cmz()) {
            if (this.iHO != null && (this.iHO.aPe() || this.iHO.aPf())) {
                this.iHO.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.FO != null) {
                cpy();
                this.iYE.iYX = false;
                if (this.FO.mp(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.FO.mp(2).dwz, false, null);
                }
            }
            cqg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && !cmw() && cmz()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.iHs);
                this.iHt = ((View) view.getParent()).getMeasuredHeight();
            }
            if (clz() != null && clz().getPbData() != null && clz().getPbData().ckQ()) {
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.iGZ.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        VideoPbFragment.this.bGD().smoothScrollBy(0, (VideoPbFragment.this.iHs[1] + VideoPbFragment.this.iHt) - (equipmentHeight - dimens));
                        if (VideoPbFragment.this.iPa != null) {
                            VideoPbFragment.this.iHO.aOr().setVisibility(8);
                            VideoPbFragment.this.iPa.g(str, str2, VideoPbFragment.this.cpk(), (VideoPbFragment.this.clz() == null || VideoPbFragment.this.clz().getPbData() == null || VideoPbFragment.this.clz().getPbData().cks() == null || !VideoPbFragment.this.clz().getPbData().cks().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cml = VideoPbFragment.this.iPa.cml();
                            if (cml != null && VideoPbFragment.this.clz() != null && VideoPbFragment.this.clz().getPbData() != null) {
                                cml.a(VideoPbFragment.this.clz().getPbData().getAnti());
                                cml.setThreadData(VideoPbFragment.this.clz().getPbData().cks());
                            }
                            if (VideoPbFragment.this.iHF.cqx() == null && VideoPbFragment.this.iPa.cml().aPu() != null) {
                                VideoPbFragment.this.iPa.cml().aPu().c(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.iHF != null && VideoPbFragment.this.iHF.cqw() != null) {
                                            if (!VideoPbFragment.this.iHF.cqw().cUd()) {
                                                VideoPbFragment.this.iHF.qx(false);
                                            }
                                            VideoPbFragment.this.iHF.cqw().tH(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.iHF.f(VideoPbFragment.this.iPa.cml().aPu().getInputView());
                                VideoPbFragment.this.iPa.cml().a(VideoPbFragment.this.iHT);
                            }
                        }
                        VideoPbFragment.this.cqg();
                    }
                }, 0L);
                return;
            }
            if (this.iHQ == null) {
                this.iHQ = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.iHQ.tP(1);
                this.iHQ.a(new AnonymousClass43(str, str2));
            }
            if (clz() != null && clz().getPbData() != null && clz().getPbData().getForum() != null) {
                this.iHQ.C(clz().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(clz().cnw(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$43  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass43 implements c.a {
        final /* synthetic */ String iIW;
        final /* synthetic */ String iIX;

        AnonymousClass43(String str, String str2) {
            this.iIW = str;
            this.iIX = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lw(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void t(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lx(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        VideoPbFragment.this.bGD().smoothScrollBy(0, (VideoPbFragment.this.iHs[1] + VideoPbFragment.this.iHt) - (equipmentHeight - dimens));
                        if (VideoPbFragment.this.iPa != null) {
                            VideoPbFragment.this.iHO.aOr().setVisibility(8);
                            VideoPbFragment.this.iPa.g(AnonymousClass43.this.iIW, AnonymousClass43.this.iIX, VideoPbFragment.this.cpk(), (VideoPbFragment.this.clz() == null || VideoPbFragment.this.clz().getPbData() == null || VideoPbFragment.this.clz().getPbData().cks() == null || !VideoPbFragment.this.clz().getPbData().cks().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cml = VideoPbFragment.this.iPa.cml();
                            if (cml != null && VideoPbFragment.this.clz() != null && VideoPbFragment.this.clz().getPbData() != null) {
                                cml.a(VideoPbFragment.this.clz().getPbData().getAnti());
                                cml.setThreadData(VideoPbFragment.this.clz().getPbData().cks());
                            }
                            if (VideoPbFragment.this.iHF.cqx() == null && VideoPbFragment.this.iPa.cml().aPu() != null) {
                                VideoPbFragment.this.iPa.cml().aPu().c(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.iHF != null && VideoPbFragment.this.iHF.cqw() != null) {
                                            if (!VideoPbFragment.this.iHF.cqw().cUd()) {
                                                VideoPbFragment.this.iHF.qx(false);
                                            }
                                            VideoPbFragment.this.iHF.cqw().tH(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.iHF.f(VideoPbFragment.this.iPa.cml().aPu().getInputView());
                                VideoPbFragment.this.iPa.cml().a(VideoPbFragment.this.iHT);
                            }
                        }
                        VideoPbFragment.this.cqg();
                    }
                }, 0L);
            }
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.e eVar, boolean z, int i) {
        PostData F;
        w wVar;
        StringBuilder sb = null;
        if (eVar != null && (F = F(eVar)) != null) {
            String userId = F.aCm().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, F.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.ckE()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (F.aCm() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, F.aCm().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, F.aCm().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, F.aCm().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, F.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, F.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.ckE()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bf> ckL = eVar.ckL();
                if (v.getCount(ckL) > 0) {
                    sb = new StringBuilder();
                    for (bf bfVar : ckL) {
                        if (bfVar != null && !StringUtils.isNull(bfVar.getForumName()) && (wVar = bfVar.cQO) != null && wVar.cOI && !wVar.cOJ && (wVar.type == 1 || wVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bfVar.getForumName(), 12)).append(TbadkCoreApplication.getInst().getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(TbadkCoreApplication.getInst().getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmK() {
        MarkData yX;
        if (clz() != null && clz().getPbData() != null && csR() != null && this.iHz != null) {
            if (clz().getPbData() != null && clz().getPbData().ckQ()) {
                yX = clz().yX(0);
            } else if (this.cXZ != null && this.cXZ.getCurrentItem() == iYj) {
                yX = clz().l(F(clz().getPbData()));
            } else {
                yX = clz().yX(csR().cpI());
            }
            if (yX != null) {
                if (!yX.isApp() || (yX = clz().yX(csR().cpI() + 1)) != null) {
                    cpD();
                    this.iHz.a(yX);
                    if (!this.iHz.ayJ()) {
                        this.iHz.ayL();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.iHz.ayK();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yO(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EmotionImageData emotionImageData) {
        if (emotionImageData != null) {
            if (this.iHq == null) {
                this.iHq = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.iGZ);
                this.iHq.b(this.dys);
                this.iHq.c(this.dyz);
            }
            this.iHq.a(emotionImageData, clz(), clz().getPbData());
        }
    }

    public PostData F(com.baidu.tieba.pb.data.e eVar) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        if (eVar.ckC() != null) {
            return eVar.ckC();
        }
        if (!v.isEmpty(eVar.cku())) {
            Iterator<PostData> it = eVar.cku().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cKY() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.ckz();
        }
        if (postData == null) {
            postData = a(eVar);
        }
        if (postData != null && postData.aCm() != null && postData.aCm().getUserTbVipInfoData() != null && postData.aCm().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aCm().getGodUserData().setIntro(postData.aCm().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.cks() == null || eVar.cks().aCm() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aCm = eVar.cks().aCm();
        String userId = aCm.getUserId();
        HashMap<String, MetaData> userMap = eVar.cks().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aCm;
        }
        postData.Cw(1);
        postData.setId(eVar.cks().aCC());
        postData.setTitle(eVar.cks().getTitle());
        postData.setTime(eVar.cks().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cmP() {
        ArrayList<PostData> cku;
        int count;
        int i;
        if (clz() == null || clz().getPbData() == null || clz().getPbData().cku() == null || (count = v.getCount((cku = clz().getPbData().cku()))) == 0) {
            return "";
        }
        if (clz().cnN()) {
            Iterator<PostData> it = cku.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cKY() == 1) {
                    return next.getId();
                }
            }
        }
        if (bGD() == null) {
            i = 0;
        } else {
            i = csR().cpH();
        }
        PostData postData = (PostData) v.getItem(cku, i);
        if (postData == null || postData.aCm() == null) {
            return "";
        }
        if (clz().FV(postData.aCm().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) v.getItem(cku, i2);
            if (postData2 == null || postData2.aCm() == null || postData2.aCm().getUserId() == null) {
                break;
            } else if (clz().FV(postData2.aCm().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) v.getItem(cku, i3);
            if (postData3 == null || postData3.aCm() == null || postData3.aCm().getUserId() == null) {
                return "";
            }
            if (clz().FV(postData3.aCm().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmL() {
        if (clz() != null) {
            com.baidu.tieba.pb.data.e pbData = clz().getPbData();
            clz().pX(true);
            if (this.iHz != null) {
                pbData.FI(this.iHz.ayI());
            }
            if (csR() != null) {
                csR().ctC();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (clz() != null) {
            cpF();
            clz().pX(z);
            if (this.iHz != null) {
                this.iHz.fm(z);
                if (markData != null) {
                    this.iHz.a(markData);
                }
            }
            if (clz().ayJ()) {
                cmL();
            } else if (csR() != null) {
                csR().ctC();
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        MetaData metaData;
        boolean z = true;
        if (clz() != null && clz().getPbData() != null && lVar.cld() != null) {
            String id = lVar.cld().getId();
            ArrayList<PostData> cku = clz().getPbData().cku();
            int i = 0;
            while (true) {
                if (i >= cku.size()) {
                    break;
                }
                PostData postData = cku.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> clh = lVar.clh();
                    postData.Cv(lVar.getTotalCount());
                    if (postData.cKV() != null && clh != null) {
                        Iterator<PostData> it = clh.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aCm() != null && (metaData = postData.getUserMap().get(next.aCm().getUserId())) != null) {
                                next.a(metaData);
                                next.sO(true);
                                next.a(getPageContext(), clz().FV(metaData.getUserId()));
                            }
                        }
                        boolean z2 = clh.size() != postData.cKV().size();
                        postData.cKV().clear();
                        postData.cKV().addAll(clh);
                        z = z2;
                    }
                    if (postData.cKR() != null) {
                        postData.cKS();
                    }
                }
            }
            if (!clz().getIsFromMark() && z && csR() != null) {
                csR().ctC();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmC() {
        if (clz() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.Iw(clz().getForumId()) && clz().getPbData() != null && clz().getPbData().getForum() != null) {
            if (clz().getPbData().getForum().isLike() == 1) {
                clz().cob().ev(clz().getForumId(), clz().cnw());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            bj cks = eVar.cks();
            if (cks != null && cks.aEg()) {
                cni();
            } else {
                d(this.iHN);
            }
            if (this.iHO != null) {
                qp(this.iHO.aOX());
                this.iHO.a(eVar.getAnti());
                this.iHO.a(eVar.getForum(), eVar.getUserData());
                this.iHO.setThreadData(cks);
                if (clz() != null) {
                    this.iHO.a(clz().cnL(), clz().cnw(), clz().coc());
                }
                if (cks != null) {
                    this.iHO.gI(cks.aDE());
                }
            }
        }
    }

    public void cpi() {
        reset();
        cpe();
        this.iPa.cmh();
        qr(false);
    }

    private void reset() {
        if (this.iHO != null && this.FO != null) {
            com.baidu.tbadk.editortools.pb.a.aON().setStatus(0);
            this.iHO.aPh();
            this.iHO.aOB();
            if (this.iHO.getWriteImagesInfo() != null) {
                this.iHO.getWriteImagesInfo().setMaxImagesAllowed(this.iHO.isBJH ? 1 : 9);
            }
            this.iHO.mv(SendView.ALL);
            this.iHO.mw(SendView.ALL);
            com.baidu.tbadk.editortools.g mm = this.FO.mm(23);
            com.baidu.tbadk.editortools.g mm2 = this.FO.mm(2);
            com.baidu.tbadk.editortools.g mm3 = this.FO.mm(5);
            if (mm2 != null) {
                mm2.display();
            }
            if (mm3 != null) {
                mm3.display();
            }
            if (mm != null) {
                mm.hide();
            }
            this.FO.invalidate();
        }
    }

    public void q(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cks() != null) {
            t(eVar);
            if (eVar.ayJ()) {
                SvgManager.aGA().a(this.iOx, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aGA().a(this.iOx, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.iOA.setText(zf(eVar.cks().aCd()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.cks()));
        }
    }

    public void t(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && AntiHelper.aY(eVar.cks())) {
            if (this.iOz != null) {
                this.iOz.setEnable(false);
                this.iOz.onDestroy();
            }
            SvgManager.aGA().a(this.iOy, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.iOz == null || !this.iOz.isEnable()) {
            SvgManager.aGA().a(this.iOy, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private String zf(int i) {
        if (i == 0) {
            return getString(R.string.pb_comment_red_dot_no_reply);
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setRoundingMode(RoundingMode.HALF_UP);
        if (i > 9990000) {
            return "· · ·";
        }
        if (i >= 1000000) {
            numberFormat.setMaximumFractionDigits(0);
            return numberFormat.format(i / 10000.0f) + ExifInterface.LONGITUDE_WEST;
        } else if (i >= 10000) {
            numberFormat.setMaximumFractionDigits(1);
            return numberFormat.format(i / 10000.0f) + ExifInterface.LONGITUDE_WEST;
        } else {
            return "" + i;
        }
    }

    public void qr(boolean z) {
        if (this.iOv != null) {
            qp(this.iHO.aOX());
            if (this.iOr) {
                qg(z);
            } else {
                qh(z);
            }
            csJ();
            csK();
        }
    }

    public void cqg() {
        if (this.iOv != null) {
            this.iOu.setVisibility(8);
            this.iOv.setVisibility(8);
            this.iYE.iYX = false;
            csJ();
            csK();
        }
    }

    private void csJ() {
        if (this.iYr != null) {
            if (this.iYE.cta()) {
                this.iYr.rQ(false);
            } else {
                this.iYr.rQ(this.iYr.bik() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csK() {
        if (this.iYr != null && this.cXZ != null) {
            if (this.cXZ.getCurrentItem() != 0) {
                this.iYr.qZ(false);
            } else if (this.iYE.cta()) {
                this.iYr.qZ(false);
            } else {
                e eVar = (e) y.b(getActivity()).l(e.class);
                if (eVar != null) {
                    this.iYr.qZ(eVar.ctk() == null || eVar.ctk().getValue() == null || eVar.ctk().getValue().booleanValue());
                }
            }
        }
    }

    private void yP(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(cng(), cmA(), i);
    }

    private int cmA() {
        if (clz() == null || clz().getPbData() == null || clz().getPbData().cks() == null) {
            return -1;
        }
        return clz().getPbData().cks().aCW();
    }

    public void qp(boolean z) {
        this.iOr = z;
    }

    public void qg(boolean z) {
        if (this.iOv != null && this.hgK != null) {
            this.hgK.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.iOv.startAnimation(alphaAnimation);
            }
            this.iOu.setVisibility(0);
            this.iOv.setVisibility(0);
            this.iYE.iYX = true;
        }
    }

    public void qh(boolean z) {
        if (this.iOv != null && this.hgK != null) {
            this.hgK.setText(cpk());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.iOv.startAnimation(alphaAnimation);
            }
            this.iOu.setVisibility(0);
            this.iOv.setVisibility(0);
            this.iYE.iYX = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null) {
            this.iCm = aVar;
            this.iYw.setText(aVar.getTitle());
            this.iYx.setText(aVar.ctH());
            String ctI = aVar.ctI();
            TBSpecificationBtn tBSpecificationBtn = this.iYz;
            if (TextUtils.isEmpty(ctI)) {
                ctI = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(ctI);
            this.iYA.startLoad(aVar.getImage(), 10, false);
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44
                @Override // java.lang.Runnable
                public void run() {
                    TiebaStatic.log(new an("c13608").cy("obj_id", VideoPbFragment.this.iCm.getTitle()).cy("obj_name", VideoPbFragment.this.iCm.ctH()).X("obj_type", 2).cy("fid", VideoPbFragment.this.clz().getPbData().getForumId()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("tid", VideoPbFragment.this.clz().getPbData().getThreadId()));
                    VideoPbFragment.this.csL();
                }
            }, aVar.ctJ().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csL() {
        ViewGroup.LayoutParams layoutParams = this.iYu.getLayoutParams();
        if (layoutParams != null) {
            if (this.iYB == null || !this.iYB.isRunning()) {
                this.iYu.setAlpha(0.0f);
                this.iYu.setVisibility(0);
                f(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csM() {
        if (this.iYu.getLayoutParams() != null) {
            if (this.iYB == null || !this.iYB.isRunning()) {
                csN();
            }
        }
    }

    private void csN() {
        final ViewGroup.LayoutParams layoutParams = this.iYu.getLayoutParams();
        if (layoutParams != null) {
            if (this.iYC == null || !this.iYC.isRunning()) {
                this.iYC = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.iYC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.iYu.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.iYC.setDuration(200L);
                this.iYC.start();
                this.iYC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPbFragment.this.e(layoutParams);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final ViewGroup.LayoutParams layoutParams) {
        final ViewGroup.LayoutParams layoutParams2 = this.CD.getLayoutParams();
        final int i = layoutParams2.height;
        this.iYB = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.iYB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.hfi);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.hfi);
                VideoPbFragment.this.iYu.setLayoutParams(layoutParams);
                VideoPbFragment.this.CD.setLayoutParams(layoutParams2);
            }
        });
        this.iYB.setDuration(300L);
        this.iYB.start();
        this.iYB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.iYu.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private void f(final ViewGroup.LayoutParams layoutParams) {
        final ViewGroup.LayoutParams layoutParams2 = this.CD.getLayoutParams();
        final int i = layoutParams2.height;
        this.iYB = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iYB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.hfi);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.iYu.setLayoutParams(layoutParams);
                VideoPbFragment.this.CD.setLayoutParams(layoutParams2);
            }
        });
        this.iYB.setDuration(300L);
        this.iYB.start();
        this.iYB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.csO();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csO() {
        this.iYB = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iYB.setDuration(300L);
        this.iYB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.iYu.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.iYB.start();
    }

    public String cpk() {
        if (!aq.isEmpty(this.iPr)) {
            return this.iPr;
        }
        this.iPr = TbadkCoreApplication.getInst().getResources().getString(com.baidu.tieba.pb.pb.main.am.coZ());
        return this.iPr;
    }

    public void cpF() {
        hideProgressBar();
        if (csR() != null) {
            csR().endLoadData();
            csR().cpG();
        }
    }

    public boolean ct(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && i.azM().isShowImages()) {
                    return FR(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (clz() == null || clz().getPbData() == null) {
                        return true;
                    }
                    if (this.iPa != null) {
                        this.iPa.cmh();
                    }
                    com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                    lVar.a(clz().getPbData().getForum());
                    lVar.setThreadData(clz().getPbData().cks());
                    lVar.f(postData);
                    this.iGW.d(lVar);
                    this.iGW.setPostId(postData.getId());
                    b(view, postData.aCm().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.iHO != null) {
                        qp(this.iHO.aOX());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void csP() {
        if (this.iHO != null) {
            qp(this.iHO.aOX());
        }
        cpi();
        this.iYD.cpW();
    }

    private boolean FR(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aFB().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.a.startWebActivity(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), string + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void bWq() {
        if (this.iOd != null) {
            this.iOd.setVisibility(0);
        }
    }

    public void bWp() {
        if (this.iOd != null) {
            this.iOd.setVisibility(8);
        }
    }

    public void zv(int i) {
        if (this.iYo != null) {
            this.iYo.setVisibility(i);
        }
    }

    public void cpD() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a cmF() {
        return this.iIA;
    }

    public void cpe() {
        if (this.FO != null) {
            this.FO.hide();
        }
    }

    public void bEj() {
        if (this.iGZ.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.iGZ.getCurrentFocus());
        }
    }

    public void H(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cks() != null) {
            String valueOf = String.valueOf(eVar.cks().aCd());
            if (eVar.cks().aCd() == 0) {
                valueOf = "";
            }
            this.iYm.wi(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        for (BaseFragment baseFragment : this.iYn.ctb()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, eVar, str, i4);
            }
        }
        b(z, i, i2, i3, eVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (clz() != null && clz().getPbData() != null && clz().getPbData().cks() != null && clz().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(iOT)).intValue();
                if (intValue == iOU) {
                    if (!this.fKw.cLM()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.fKw.Jg(aq.O(jSONArray));
                        }
                        this.fKw.a(clz().getPbData().getForum().getId(), clz().getPbData().getForum().getName(), clz().getPbData().cks().getId(), str, intValue3, intValue2, booleanValue, clz().getPbData().cks().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == iOV || intValue == iOX) {
                    if (clz().cnY() != null) {
                        clz().cnY().yI(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == iOV) {
                        TiebaStatic.log("c10499");
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int aUx() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> aUy() {
        if (this.dMm == null) {
            this.dMm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: aUK */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = i.azM().isShowImages();
                    foreDrawableImageView.setDefaultBg(am.getDrawable(R.color.common_color_10220));
                    if (isShowImages) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                        foreDrawableImageView.setAdjustViewBounds(true);
                        foreDrawableImageView.setInterceptOnClick(true);
                    }
                    return foreDrawableImageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: a */
                public void destroyObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: b */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (i.azM().isShowImages()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(R.drawable.icon_click);
                            tbImageView.setAdjustViewBounds(true);
                            tbImageView.setInterceptOnClick(true);
                        }
                    }
                    return imageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: c */
                public ImageView passivateObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.dMm;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> aUz() {
        if (this.dPa == null) {
            this.dPa = TbRichTextView.z(getPageContext().getPageActivity(), 8);
        }
        return this.dPa;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> aUA() {
        if (this.dMn == null) {
            this.dMn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bGX */
                public GifView makeObject() {
                    GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = i.azM().isShowImages();
                    gifView.setDefaultBg(am.getDrawable(R.color.common_color_10220));
                    if (isShowImages) {
                        gifView.setAdjustViewBounds(false);
                        gifView.setInterceptOnClick(false);
                    } else {
                        gifView.setDefaultResource(R.drawable.icon_click);
                        gifView.setAdjustViewBounds(true);
                        gifView.setInterceptOnClick(true);
                    }
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: g */
                public void destroyObject(GifView gifView) {
                    gifView.setBackgroundDrawable(null);
                    gifView.setImageDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: h */
                public GifView activateObject(GifView gifView) {
                    gifView.setTag(null);
                    if (i.azM().isShowImages()) {
                        gifView.setAdjustViewBounds(false);
                        gifView.setInterceptOnClick(false);
                    } else {
                        gifView.setDefaultResource(R.drawable.icon_click);
                        gifView.setAdjustViewBounds(true);
                        gifView.setInterceptOnClick(true);
                    }
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: i */
                public GifView passivateObject(GifView gifView) {
                    gifView.release();
                    gifView.onDestroy();
                    gifView.setImageDrawable(null);
                    gifView.aPM();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.dMn;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> aUB() {
        if (this.dPb == null) {
            this.dPb = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cnj */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(VideoPbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(VideoPbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cw */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cx */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).cMf();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cy */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.dPb;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> aUC() {
        if (this.dPc == null) {
            this.dPc = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cnl */
                public LinearLayout makeObject() {
                    LinearLayout linearLayout = new LinearLayout(VideoPbFragment.this.getPageContext().getPageActivity());
                    linearLayout.setId(R.id.pb_text_voice_layout);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    linearLayout.setLayoutParams(layoutParams);
                    linearLayout.setGravity(16);
                    linearLayout.setBaselineAligned(true);
                    linearLayout.setOrientation(1);
                    linearLayout.setLayoutParams(layoutParams);
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: c */
                public void destroyObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: d */
                public LinearLayout activateObject(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: e */
                public LinearLayout passivateObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.dPc;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> aUD() {
        this.dPd = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cnk */
            public RelativeLayout makeObject() {
                return new RelativeLayout(VideoPbFragment.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public RelativeLayout activateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public RelativeLayout passivateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.dPd;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aC(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.iHk = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void d(Context context, String str, boolean z) {
        if (as.Gh(str) && clz() != null && clz().cnw() != null) {
            TiebaStatic.log(new an("c11664").X("obj_param1", 1).cy("post_id", clz().cnw()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                lVar.mLink = str;
                lVar.type = 3;
                lVar.dvC = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
            }
        } else {
            as.cqz().c(getPageContext(), str);
        }
        this.iHk = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aD(Context context, String str) {
        as.cqz().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.iHk = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aE(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void r(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.iYD.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b ctu = this.iYD.ctu();
            if (ctu == null) {
                this.iYD.cmv();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                ctu.getItemView(1).setVisibility(8);
            } else {
                ctu.getItemView(1).setVisibility(0);
            }
            ctu.aEB();
            this.iHk = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            ba.aGE().b(getPageContext(), new String[]{str});
            this.iHk = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a csQ() {
        return this.daa;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener aSn() {
        return this.drz;
    }

    public ReplyFragment csR() {
        if (this.iYn == null || !(this.iYn.zw(iYk) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.iYn.zw(iYk);
    }

    public DetailInfoFragment csS() {
        if (this.iYn == null || !(this.iYn.zw(iYj) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.iYn.zw(iYj);
    }

    public boolean clp() {
        PbModel clz = this.iGZ.clz();
        if (clz == null) {
            return false;
        }
        return clz.clp();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData ckB;
        PbModel clz = this.iGZ.clz();
        if (clz != null && clz.getPbData() != null && !clz.getPbData().ckQ()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = clz.getPbData().cks().getId();
            if (clz.isShareThread() && clz.getPbData().cks().cTP != null) {
                historyMessage.threadName = clz.getPbData().cks().cTP.showText;
            } else {
                historyMessage.threadName = clz.getPbData().cks().getTitle();
            }
            if (clz.isShareThread() && !clp()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = clz.getPbData().getForum().getName();
            }
            ArrayList<PostData> cku = clz.getPbData().cku();
            int cpH = csR() != null ? csR().cpH() : 0;
            if (cku != null && cpH >= 0 && cpH < cku.size()) {
                historyMessage.postID = cku.get(cpH).getId();
            }
            historyMessage.isHostOnly = clz.getHostMode();
            historyMessage.isSquence = clz.cnx();
            historyMessage.isShareThread = clz.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.iHO != null) {
            this.iHO.onDestroy();
        }
        if (clz != null && (clz.cny() || clz.cnA())) {
            Intent intent = new Intent();
            intent.putExtra("tid", clz.cnw());
            if (this.iHC) {
                if (this.iHE) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", clz.bxO());
                }
                if (this.iHD) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", clz.getIsGood());
                }
            }
            if (clz.getPbData() != null && System.currentTimeMillis() - this.iHg >= 40000 && (ckB = clz.getPbData().ckB()) != null && !v.isEmpty(ckB.getDataList())) {
                intent.putExtra("guess_like_data", ckB);
            }
            PbActivity pbActivity = this.iGZ;
            PbActivity pbActivity2 = this.iGZ;
            pbActivity.setResult(-1, intent);
        }
        if (cmM()) {
            if (clz != null) {
                com.baidu.tieba.pb.data.e pbData = clz.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.iHm) {
                        if (this.iYq != null) {
                            Rect rect = new Rect();
                            this.iYq.getGlobalVisibleRect(rect);
                            ah.coO().h(rect);
                        }
                        ah.coO().zb(this.cXZ.getCurrentItem());
                        BdTypeRecyclerView bGD = bGD();
                        Parcelable parcelable = null;
                        if (bGD != null) {
                            parcelable = bGD.onSaveInstanceState();
                        }
                        ah.coO().a(clz.cnF(), parcelable, clz.cnx(), clz.getHostMode(), false);
                    }
                }
            } else {
                ah.coO().reset();
            }
            clM();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.iYr != null && !this.iYr.bik()) {
            if ((this.iYr.isFullScreen() && configuration.orientation == 1) || (!this.iYr.isFullScreen() && configuration.orientation == 2)) {
                this.iYr.ra(false);
            }
        }
    }

    public boolean csT() {
        if (this.iYr == null) {
            return false;
        }
        return this.iYr.bik();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.s.c.cJY().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        public boolean iYX;
        public boolean iYY;

        private a() {
            this.iYY = true;
        }

        public boolean cta() {
            return (this.iYX && this.iYY) ? false : true;
        }
    }

    public void csU() {
        this.iHu = -1;
        this.iHv = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnc() {
        if (clz() != null && !aq.isEmpty(clz().cnw())) {
            com.baidu.tbadk.BdToken.c.axx().o(com.baidu.tbadk.BdToken.b.cGK, com.baidu.adp.lib.f.b.toLong(clz().cnw(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.iYp.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csV() {
        if (this.iYO == null) {
            this.iYO = ObjectAnimator.ofFloat(this.iYt, "alpha", 0.0f, 1.0f);
            this.iYO.setDuration(200L);
        }
        this.iYO.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csW() {
        if (this.iYP == null) {
            this.iYP = ObjectAnimator.ofFloat(this.iYt, "alpha", 1.0f, 0.0f);
            this.iYP.setDuration(200L);
        }
        this.iYP.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean csX() {
        return this.iYr != null && this.iYr.csY();
    }

    public boolean csY() {
        return this.iYK;
    }

    public void qS(boolean z) {
        this.iYK = z;
    }
}
