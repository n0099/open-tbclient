package com.baidu.tieba.pb.videopb;

import android.animation.Animator;
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
import com.baidu.tbadk.coreExtra.data.p;
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
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ak;
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.pb.pb.main.as;
import com.baidu.tieba.pb.pb.main.av;
import com.baidu.tieba.pb.pb.main.t;
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
/* loaded from: classes6.dex */
public class VideoPbFragment extends BaseFragment implements VoiceManager.c, TbRichTextView.c, h, com.baidu.tieba.pb.videopb.a, b {
    private AppBarLayout Cf;
    private EditorTools Fq;
    private ImageView KA;
    private CustomViewPager cTN;
    public View dBy;
    private com.baidu.adp.lib.d.b<ImageView> dHY;
    private com.baidu.adp.lib.d.b<GifView> dHZ;
    private com.baidu.adp.lib.d.b<TextView> dKO;
    private com.baidu.adp.lib.d.b<View> dKP;
    private com.baidu.adp.lib.d.b<LinearLayout> dKQ;
    private com.baidu.adp.lib.d.b<RelativeLayout> dKR;
    private ImageView eyT;
    private VoiceManager giZ;
    private com.baidu.tieba.frs.profession.permission.c gmA;
    private com.baidu.tieba.f.b gnc;
    public aj hJV;
    private PbFakeFloorModel iBO;
    private PbActivity iBR;
    private g iCF;
    private com.baidu.tbadk.editortools.pb.e iCG;
    private com.baidu.tieba.frs.profession.permission.c iCI;
    private EmotionImageData iCJ;
    private com.baidu.tbadk.core.view.d iCN;
    private com.baidu.tieba.pb.pb.main.emotion.model.a iCi;
    int iCl;
    public as iCx;
    private ImageView iJA;
    private TextView iJB;
    private int iJD;
    private int iJE;
    private View iJf;
    private View iJw;
    private ImageView iJy;
    private ImageView iJz;
    private t iKb;
    private String iKs;
    public View iON;
    private ImageView iTA;
    private TBSpecificationBtn iTB;
    private TbImageView iTC;
    private ValueAnimator iTD;
    private ValueAnimator iTE;
    public com.baidu.tieba.pb.videopb.b.a iTF;
    private NewPagerSlidingTabBaseStrip iTp;
    private VideoPbFragmentAdapter iTq;
    private View iTr;
    private View iTs;
    private VideoContainerLayout iTt;
    private com.baidu.tieba.pb.videopb.videoView.a iTu;
    private f iTv;
    private View iTw;
    private TextView iTy;
    private TextView iTz;
    private com.baidu.tieba.pb.videopb.c.a iwR;
    public NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View mStatusBar;
    private RelativeLayout rootView;
    public static int iTm = 0;
    public static int iTn = 1;
    public static int iJT = 3;
    public static int iJU = 0;
    public static int iJV = 3;
    public static int iJW = 4;
    public static int iJX = 5;
    public static int iJY = 6;
    private static final int gZG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int iTo = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a iDD = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // com.baidu.tieba.f.b.a
        public void aY(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.ciH();
            } else {
                com.baidu.tieba.pb.a.b.ciG();
            }
        }
    };
    private long iBY = 0;
    View.OnClickListener iTx = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.iwR != null) {
                TiebaStatic.log(new an("c13590").cp("obj_id", VideoPbFragment.this.iwR.getTitle()).cp("obj_name", VideoPbFragment.this.iwR.crf()).Z("obj_type", 2).cp("fid", VideoPbFragment.this.ciU().getPbData().getForumId()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("tid", VideoPbFragment.this.ciU().getPbData().getThreadId()));
                String link = VideoPbFragment.this.iwR.getLink();
                if (!TextUtils.isEmpty(link)) {
                    if (URLUtil.isHttpUrl(link) || URLUtil.isHttpsUrl(link)) {
                        ba.aEa().b(VideoPbFragment.this.getPageContext(), new String[]{link});
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
    private com.baidu.tbadk.baseEditMark.a iCr = null;
    private com.baidu.tbadk.coreExtra.model.a cVO = null;
    private ForumManageModel fEP = null;
    private boolean iCc = false;
    private View iJx = null;
    private TextView hbh = null;
    private boolean iJt = false;
    private String dtY = null;
    private boolean iCu = false;
    private boolean iCv = false;
    private boolean iCw = false;
    private boolean iCe = false;
    int[] iCk = new int[2];
    private int iCm = -1;
    private int iCn = Integer.MIN_VALUE;
    private int iCT = 0;
    private int iTH = Integer.MIN_VALUE;
    private boolean isPaused = false;
    private final PbModel.a iDt = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.g lU;
            VideoPbFragment.this.cnh();
            VideoPbFragment.this.bTF();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.qc(false);
            if (z && fVar != null) {
                bj chK = fVar.chK();
                if (chK == null || !chK.aBC()) {
                    VideoPbFragment.this.d(VideoPbFragment.this.iCF);
                } else {
                    VideoPbFragment.this.ckG();
                }
                ((e) y.b(VideoPbFragment.this.getActivity()).l(e.class)).c(fVar, i2);
                com.baidu.tieba.pb.videopb.c.a cim = fVar.cim();
                if (cim != null) {
                    VideoPbFragment.this.a(cim);
                }
                VideoPbFragment.this.F(fVar);
                VideoPbFragment.this.c(z, i, i2, i3, fVar, str, i4);
                if (VideoPbFragment.this.iCG != null) {
                    VideoPbFragment.this.qa(VideoPbFragment.this.iCG.aMi());
                }
                TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.iCG != null) {
                    VideoPbFragment.this.iCG.a(fVar.getAnti());
                    VideoPbFragment.this.iCG.a(fVar.getForum(), fVar.getUserData());
                    VideoPbFragment.this.iCG.setThreadData(chK);
                    if (VideoPbFragment.this.ciU() != null) {
                        VideoPbFragment.this.iCG.a(VideoPbFragment.this.ciU().clj(), VideoPbFragment.this.ciU().ckU(), VideoPbFragment.this.ciU().clD());
                    }
                    if (chK != null) {
                        VideoPbFragment.this.iCG.gw(chK.aAY());
                    }
                }
                if (VideoPbFragment.this.iCr != null) {
                    VideoPbFragment.this.iCr.fa(fVar.awd());
                }
                AntiData anti = fVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.dtY = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.dtY) && VideoPbFragment.this.iCG != null && VideoPbFragment.this.iCG.aLC() != null && (lU = VideoPbFragment.this.iCG.aLC().lU(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.dtY)) {
                        ((View) lU).setOnClickListener(VideoPbFragment.this.duK);
                    }
                }
                if (VideoPbFragment.this.hJV != null && chK != null && chK.azE() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(chK.azE());
                    VideoPbFragment.this.hJV.a(attentionHostData);
                    return;
                }
                return;
            }
            if (i == 4 || i == 350008) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tid", VideoPbFragment.this.ciU().ckU());
                    jSONObject.put("fid", VideoPbFragment.this.ciU().getForumId());
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
            if (VideoPbFragment.this.cqt() != null) {
                if (i != -1) {
                    ArrayList<PostData> arrayList = null;
                    if (VideoPbFragment.this.ciU() != null && VideoPbFragment.this.ciU().getPbData() != null) {
                        arrayList = VideoPbFragment.this.ciU().getPbData().chM();
                    }
                    if (v.getCount(arrayList) == 0 || (v.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).cIt() == 1)) {
                        if (VideoPbFragment.this.cqt().cky()) {
                            VideoPbFragment.this.cqt().FE(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                        } else {
                            VideoPbFragment.this.cqt().FE(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                        }
                    } else {
                        VideoPbFragment.this.cqt().FD(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                    }
                } else {
                    VideoPbFragment.this.cqt().FD("");
                }
                VideoPbFragment.this.cqt().endLoadData();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0362a iDv = new a.InterfaceC0362a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0362a
        public void c(boolean z, boolean z2, String str) {
            VideoPbFragment.this.cnh();
            if (z && VideoPbFragment.this.ciU() != null) {
                if (VideoPbFragment.this.iCr != null) {
                    VideoPbFragment.this.iCr.fa(z2);
                }
                VideoPbFragment.this.ciU().pI(z2);
                if (VideoPbFragment.this.ciU().awd()) {
                    VideoPbFragment.this.ckj();
                } else if (VideoPbFragment.this.cqt() != null) {
                    VideoPbFragment.this.cqt().cra();
                }
                if (z2) {
                    if (VideoPbFragment.this.iCr != null) {
                        if (VideoPbFragment.this.iCr.awg() != null && VideoPbFragment.this.ciU() != null && VideoPbFragment.this.ciU().getPbData() != null && VideoPbFragment.this.ciU().getPbData().chK() != null && VideoPbFragment.this.ciU().getPbData().chK().azE() != null) {
                            MarkData awg = VideoPbFragment.this.iCr.awg();
                            MetaData azE = VideoPbFragment.this.ciU().getPbData().chK().azE();
                            if (awg != null && azE != null) {
                                if (!aq.equals(TbadkCoreApplication.getCurrentAccount(), azE.getUserId()) && !azE.hadConcerned()) {
                                    VideoPbFragment.this.iTF.b(azE);
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
                    VideoPbFragment.this.ckg();
                    return;
                }
                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private com.baidu.tbadk.editortools.pb.b duc = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aLZ() {
            if (VideoPbFragment.this.iCx == null || VideoPbFragment.this.iCx.cnW() == null || !VideoPbFragment.this.iCx.cnW().cRJ()) {
                return !VideoPbFragment.this.yB(aj.cVJ);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.iCx.cnW().cRL());
            if (VideoPbFragment.this.iCG != null && (VideoPbFragment.this.iCG.aMp() || VideoPbFragment.this.iCG.aMq())) {
                VideoPbFragment.this.iCG.a(false, VideoPbFragment.this.iCx.cnZ());
            }
            VideoPbFragment.this.iCx.qh(true);
            return true;
        }
    };
    private final CustomMessageListener iDa = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.ciU() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.iCG != null) {
                    VideoPbFragment.this.qa(VideoPbFragment.this.iCG.aMi());
                }
                VideoPbFragment.this.cmK();
                VideoPbFragment.this.iTF.cny();
            }
        }
    };
    private CustomMessageListener iDd = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.f fVar = (com.baidu.tieba.pb.f) customResponsedMessage.getData();
                switch (fVar.getType()) {
                    case 0:
                        VideoPbFragment.this.b((m) fVar.getData());
                        return;
                    case 1:
                        VideoPbFragment.this.a((ForumManageModel.b) fVar.getData(), false);
                        return;
                    case 2:
                        if (fVar.getData() == null) {
                            VideoPbFragment.this.a(false, (MarkData) null);
                            return;
                        } else {
                            VideoPbFragment.this.a(true, (MarkData) fVar.getData());
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    };
    private final CustomMessageListener gkl = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.isPaused) {
                VideoPbFragment.this.ckA();
            }
        }
    };
    private CustomMessageListener iDu = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.cjZ();
            }
        }
    };
    private CustomMessageListener iDp = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.iTF != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.iTF.iCO) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.iTF.bnJ();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.iTF.getExtra();
                DataRes dataRes = aVar.kpZ;
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
                    VideoPbFragment.this.iTF.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.iTF.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener iDn = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.iTF != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.iTF.iCO) {
                VideoPbFragment.this.iTF.bnJ();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.ciU().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.chX().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.iCN.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.iTF.uU(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.iTF.ckx();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.iCN.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener iDo = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.iTF != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.iTF.iCO) {
                VideoPbFragment.this.iTF.bnJ();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.iCN.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.iCN.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b iCL = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aLZ() {
            if (VideoPbFragment.this.iCx == null || VideoPbFragment.this.iCx.cnX() == null || !VideoPbFragment.this.iCx.cnX().cRJ()) {
                return !VideoPbFragment.this.yB(aj.cVK);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.iCx.cnX().cRL());
            if (VideoPbFragment.this.iKb != null && VideoPbFragment.this.iKb.cjJ() != null && VideoPbFragment.this.iKb.cjJ().aMq()) {
                VideoPbFragment.this.iKb.cjJ().a(VideoPbFragment.this.iCx.cnZ());
            }
            VideoPbFragment.this.iCx.qi(true);
            return true;
        }
    };
    private final NewWriteModel.d dui = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.y yVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                an anVar = new an("c13268");
                anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.ciU() != null && VideoPbFragment.this.ciU().getPbData() != null) {
                    anVar.cp("fid", VideoPbFragment.this.ciU().getPbData().getForumId());
                }
                anVar.cp("tid", VideoPbFragment.this.ciU().ckU());
                anVar.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            VideoPbFragment.this.bBD();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.ciU() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.ciU().Fz(postWriteCallBackData.getPostId());
                    if (VideoPbFragment.this.cqt() != null) {
                        VideoPbFragment.this.iCT = VideoPbFragment.this.cqt().cnj();
                        VideoPbFragment.this.iTH = VideoPbFragment.this.cqt().crd();
                        VideoPbFragment.this.ciU().cr(VideoPbFragment.this.iCT, VideoPbFragment.this.iTH);
                    }
                }
                if (VideoPbFragment.this.cTN != null) {
                    VideoPbFragment.this.cTN.setCurrentItem(VideoPbFragment.iTn);
                }
                VideoPbFragment.this.iTF.cny();
                VideoPbFragment.this.iCx.cnV();
                if (VideoPbFragment.this.iCG != null) {
                    VideoPbFragment.this.qa(VideoPbFragment.this.iCG.aMi());
                }
                VideoPbFragment.this.cmG();
                VideoPbFragment.this.qc(true);
                VideoPbFragment.this.ciU().clp();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null && VideoPbFragment.this.cqt() != null) {
                            VideoPbFragment.this.cqt().cra();
                        }
                    } else if (VideoPbFragment.this.ciU().getHostMode()) {
                        com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.ciU().getPbData();
                        if (pbData != null && pbData.chK() != null && pbData.chK().azE() != null && (userId = pbData.chK().azE().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.ciU().clf()) {
                            VideoPbFragment.this.cnf();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.ciU().clf()) {
                        VideoPbFragment.this.cnf();
                    }
                    VideoPbFragment.this.cjY();
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.iCG.aMp() || VideoPbFragment.this.iCG.aMq()) {
                    VideoPbFragment.this.iCG.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.iCx.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.hJV != null) {
                    VideoPbFragment.this.hJV.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (yVar == null && i != 227001) {
                VideoPbFragment.this.a(i, antiData, str);
            }
        }
    };
    private View.OnClickListener duK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.showToast(VideoPbFragment.this.dtY);
        }
    };
    private CustomMessageListener iDc = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.iCG != null) {
                    VideoPbFragment.this.qa(VideoPbFragment.this.iCG.aMi());
                }
                VideoPbFragment.this.qc(false);
            }
        }
    };
    private final com.baidu.adp.base.d fEU = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.ciU() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.fEP.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.fEP.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.ciU().clp();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.iQH != 1002 || bVar.eGA) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.mSuccess, dVar.kew, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.fEP.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.fEP.getLoadDataMode(), gVar.mSuccess, gVar.kew, false);
                    VideoPbFragment.this.iTF.aM(gVar.keA);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener dne = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.gnc.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d iDr = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.y yVar, WriteData writeData, AntiData antiData) {
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                an anVar = new an("c13268");
                anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.ciU() != null && VideoPbFragment.this.ciU().getPbData() != null) {
                    anVar.cp("fid", VideoPbFragment.this.ciU().getPbData().getForumId());
                }
                if (VideoPbFragment.this.ciU() != null) {
                    anVar.cp("tid", VideoPbFragment.this.ciU().ckU());
                }
                anVar.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (VideoPbFragment.this.iCx != null) {
                    VideoPbFragment.this.iCx.cnU();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (VideoPbFragment.this.hJV != null) {
                    VideoPbFragment.this.hJV.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.iCx != null) {
                if (VideoPbFragment.this.iKb != null && VideoPbFragment.this.iKb.cjJ() != null && VideoPbFragment.this.iKb.cjJ().aMq()) {
                    VideoPbFragment.this.iKb.cjJ().a(postWriteCallBackData);
                }
                VideoPbFragment.this.iCx.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c dub = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aMa() {
            VideoPbFragment.this.showProgressBar();
        }
    };
    public View.OnClickListener aqZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            boolean u;
            int i2 = 2;
            if (view != null && VideoPbFragment.this.isAdded()) {
                if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    an anVar = new an("c13398");
                    anVar.cp("tid", VideoPbFragment.this.ciU().ckU());
                    anVar.cp("fid", VideoPbFragment.this.ciU().getForumId());
                    anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.Z("obj_locate", 1);
                    TiebaStatic.log(anVar);
                    if (VideoPbFragment.this.iCc) {
                        VideoPbFragment.this.iCc = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.ciU() != null && VideoPbFragment.this.ciU().getPbData() != null && VideoPbFragment.this.iBO != null && postData.azE() != null && postData.cIt() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.iKb != null) {
                                    VideoPbFragment.this.iKb.cjF();
                                }
                                m mVar = new m();
                                mVar.a(VideoPbFragment.this.ciU().getPbData().getForum());
                                mVar.setThreadData(VideoPbFragment.this.ciU().getPbData().chK());
                                mVar.f(postData);
                                VideoPbFragment.this.iBO.d(mVar);
                                VideoPbFragment.this.iBO.setPostId(postData.getId());
                                VideoPbFragment.this.b(view, postData.azE().getUserId(), "");
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.ciU().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.iCG != null) {
                                    VideoPbFragment.this.qa(VideoPbFragment.this.iCG.aMi());
                                }
                            }
                        }
                    }
                } else if (VideoPbFragment.this.cqt() != null && VideoPbFragment.this.cqt().cnu() != null && view == VideoPbFragment.this.cqt().cnu()) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.ciU().pG(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        VideoPbFragment.this.cqt().cng();
                    }
                } else if (VideoPbFragment.this.iTF != null && VideoPbFragment.this.iTF.coB() != null && view == VideoPbFragment.this.iTF.coB().cmf()) {
                    VideoPbFragment.this.iTF.apm();
                } else if (VideoPbFragment.this.iTF != null && ((VideoPbFragment.this.iTF.coB() != null && view == VideoPbFragment.this.iTF.coB().cmg()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.iTF.cny();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.bBD();
                        VideoPbFragment.this.cnf();
                        if (view.getId() == R.id.owner_reply) {
                            u = VideoPbFragment.this.ciU().u(true, VideoPbFragment.this.ckn());
                        } else {
                            u = view.getId() == R.id.all_reply ? VideoPbFragment.this.ciU().u(false, VideoPbFragment.this.ckn()) : VideoPbFragment.this.ciU().Fw(VideoPbFragment.this.ckn());
                        }
                        view.setTag(Boolean.valueOf(u));
                        if (u) {
                            VideoPbFragment.this.bTG();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.dBy) {
                    if (VideoPbFragment.this.ciU() != null && VideoPbFragment.this.ciU().getPbData() != null) {
                        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            an anVar2 = new an("c13266");
                            anVar2.cp("uid", TbadkCoreApplication.getCurrentAccount());
                            anVar2.cp("fid", VideoPbFragment.this.ciU().getPbData().getForumId());
                            anVar2.cp("tid", VideoPbFragment.this.ciU().ckU());
                            anVar2.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(anVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.iBR, VideoPbFragment.this.dBy);
                        VideoPbFragment.this.iBR.finish();
                    }
                } else if (view == VideoPbFragment.this.iON && VideoPbFragment.this.iTF != null) {
                    if (VideoPbFragment.this.ciU() == null || VideoPbFragment.this.ciU().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> chM = VideoPbFragment.this.ciU().getPbData().chM();
                    if ((chM == null || chM.size() <= 0) && VideoPbFragment.this.ciU().ckV()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new an("c12378").cp("tid", VideoPbFragment.this.ciU().ckU()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("fid", VideoPbFragment.this.ciU().getForumId()));
                    VideoPbFragment.this.iTF.ckb();
                } else if (VideoPbFragment.this.iTF != null && VideoPbFragment.this.iTF.coB() != null && view == VideoPbFragment.this.iTF.coB().cmg()) {
                    VideoPbFragment.this.iTF.apm();
                } else if (VideoPbFragment.this.iTF != null && ((VideoPbFragment.this.iTF.coB() != null && view == VideoPbFragment.this.iTF.coB().cmm()) || view.getId() == R.id.pb_sort_type)) {
                    VideoPbFragment.this.iTF.cny();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.bBD();
                            VideoPbFragment.this.cnf();
                            VideoPbFragment.this.iTF.cC(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.ciU().cln()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.iTF != null && VideoPbFragment.this.iTF.coB() != null && view == VideoPbFragment.this.iTF.coB().cme()) {
                    if (VideoPbFragment.this.ciU() != null && VideoPbFragment.this.ciU().getPbData() != null && VideoPbFragment.this.ciU().getPbData().chK() != null) {
                        VideoPbFragment.this.iTF.apm();
                        TiebaStatic.log(new an("c13062"));
                        VideoPbFragment.this.iTF.Fq(VideoPbFragment.this.ciU().getPbData().chK().azU());
                    }
                } else if (VideoPbFragment.this.iTF != null && VideoPbFragment.this.iTF.coB() != null && view == VideoPbFragment.this.iTF.coB().cmn()) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 1) {
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        am.t(true, false);
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).Z("obj_type", 0).Z("obj_source", 1));
                    } else if (skinType == 0 || skinType == 4) {
                        UtilHelper.showSkinChangeAnimation(VideoPbFragment.this.getActivity());
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        UtilHelper.setNavigationBarBackground(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                        TbadkCoreApplication.getInst().setSkinType(1);
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).Z("obj_type", 1).Z("obj_source", 1));
                    }
                    VideoPbFragment.this.iTF.coA();
                } else if (VideoPbFragment.this.iTF != null && (view == VideoPbFragment.this.iTF.cnd() || (VideoPbFragment.this.iTF.coB() != null && (view == VideoPbFragment.this.iTF.coB().cmj() || view == VideoPbFragment.this.iTF.coB().cmh())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.ciU() != null || VideoPbFragment.this.ciU().getPbData() != null) {
                        if ((VideoPbFragment.this.ciU().getPbData().chW() == 1 || VideoPbFragment.this.ciU().getPbData().chW() == 3) && !VideoPbFragment.this.fEP.cJi()) {
                            VideoPbFragment.this.iTF.cny();
                            if (VideoPbFragment.this.iTF.coB() != null && view == VideoPbFragment.this.iTF.coB().cmh()) {
                                if (VideoPbFragment.this.ciU().getPbData().chK().azz() == 1) {
                                    i = 5;
                                } else {
                                    i = 4;
                                }
                            } else if (VideoPbFragment.this.iTF.coB() != null && view == VideoPbFragment.this.iTF.coB().cmj()) {
                                i = VideoPbFragment.this.ciU().getPbData().chK().azA() == 1 ? 3 : 6;
                            } else {
                                i = view == VideoPbFragment.this.iTF.cnd() ? 2 : 0;
                            }
                            ForumData forum = VideoPbFragment.this.ciU().getPbData().getForum();
                            String name = forum.getName();
                            String id = forum.getId();
                            String id2 = VideoPbFragment.this.ciU().getPbData().chK().getId();
                            VideoPbFragment.this.showProgressBar();
                            VideoPbFragment.this.fEP.b(id, name, id2, i, VideoPbFragment.this.iTF.cne());
                        }
                    }
                } else if (VideoPbFragment.this.iTF != null && VideoPbFragment.this.iTF.coB() != null && view == VideoPbFragment.this.iTF.coB().cml()) {
                    if (VideoPbFragment.this.ciU() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.iTF.cny();
                        SparseArray<Object> b = VideoPbFragment.this.b(VideoPbFragment.this.ciU().getPbData(), VideoPbFragment.this.ciU().ckV(), 1);
                        if (b != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.ciU().getPbData().getForum().getId(), VideoPbFragment.this.ciU().getPbData().getForum().getName(), VideoPbFragment.this.ciU().getPbData().chK().getId(), String.valueOf(VideoPbFragment.this.ciU().getPbData().getUserData().getUserId()), (String) b.get(R.id.tag_forbid_user_name), (String) b.get(R.id.tag_forbid_user_name_show), (String) b.get(R.id.tag_forbid_user_post_id), (String) b.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.iTF != null && VideoPbFragment.this.iTF.coB() != null && view == VideoPbFragment.this.iTF.coB().cmi()) {
                    if (VideoPbFragment.this.ciU() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.ciU().getPbData(), VideoPbFragment.this.ciU().ckV(), 1);
                        if (b2 != null) {
                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.iTF.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.iTF.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.iTF.apm();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        an anVar3 = new an("c13398");
                        anVar3.cp("tid", VideoPbFragment.this.ciU().ckU());
                        anVar3.cp("fid", VideoPbFragment.this.ciU().getForumId());
                        anVar3.cp("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar3.Z("obj_locate", 4);
                        TiebaStatic.log(anVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new an("c10517").Z("obj_locate", 3).cp("fid", VideoPbFragment.this.ciU().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.ciU() != null && VideoPbFragment.this.ciU().getPbData() != null) {
                        if (VideoPbFragment.this.iTF != null) {
                            VideoPbFragment.this.iTF.cny();
                        }
                        PostData postData2 = (PostData) ((SparseArray) view.getTag()).get(R.id.tag_load_sub_data);
                        if (postData2 != null) {
                            if (postData2.cIF() == 1) {
                                TiebaStatic.log(new an("c12630"));
                            }
                            if (postData2.kcG != null) {
                                an aDS = postData2.kcG.aDS();
                                aDS.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    aDS.Z("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    aDS.Z("obj_locate", 8);
                                }
                                TiebaStatic.log(aDS);
                            }
                            String ckU = VideoPbFragment.this.ciU().ckU();
                            String id3 = postData2.getId();
                            int chW = VideoPbFragment.this.ciU().getPbData() != null ? VideoPbFragment.this.ciU().getPbData().chW() : 0;
                            VideoPbFragment.this.bBD();
                            TiebaStatic.log("c11742");
                            if (VideoPbFragment.this.cqt() != null && VideoPbFragment.this.cqt().crc() != null) {
                                PbActivity.a Fu = VideoPbFragment.this.cqt().crc().Fu(id3);
                                if (postData2 != null && VideoPbFragment.this.ciU() != null && VideoPbFragment.this.ciU().getPbData() != null && Fu != null) {
                                    SubPbActivityConfig addBigImageData = new SubPbActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(ckU, id3, "pb", true, null, false, null, chW, postData2.cpy(), VideoPbFragment.this.ciU().getPbData().getAnti(), false, postData2.azE().getIconInfo()).addBigImageData(Fu.iyY, Fu.iyZ, Fu.iza, Fu.index);
                                    addBigImageData.setKeyFromForumId(VideoPbFragment.this.ciU().getForumId());
                                    addBigImageData.setBjhData(VideoPbFragment.this.ciU().clc());
                                    addBigImageData.setKeyPageStartFrom(VideoPbFragment.this.ciU().clG());
                                    addBigImageData.setFromFrsForumId(VideoPbFragment.this.ciU().getFromForumId());
                                    VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply) {
                    if (VideoPbFragment.this.ciU() != null) {
                        an anVar4 = new an("c13398");
                        anVar4.cp("tid", VideoPbFragment.this.ciU().ckU());
                        anVar4.cp("fid", VideoPbFragment.this.ciU().getForumId());
                        anVar4.cp("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar4.Z("obj_locate", 6);
                        TiebaStatic.log(anVar4);
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if (sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData3 = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                if (VideoPbFragment.this.ciU() != null && VideoPbFragment.this.ciU().getPbData() != null && VideoPbFragment.this.iBO != null && postData3.azE() != null && postData3.cIt() != 1) {
                                    if (VideoPbFragment.this.iKb != null) {
                                        VideoPbFragment.this.iKb.cjF();
                                    }
                                    m mVar2 = new m();
                                    mVar2.a(VideoPbFragment.this.ciU().getPbData().getForum());
                                    mVar2.setThreadData(VideoPbFragment.this.ciU().getPbData().chK());
                                    mVar2.f(postData3);
                                    VideoPbFragment.this.iBO.d(mVar2);
                                    VideoPbFragment.this.iBO.setPostId(postData3.getId());
                                    VideoPbFragment.this.b(view, postData3.azE().getUserId(), "");
                                    if (VideoPbFragment.this.iCG != null) {
                                        VideoPbFragment.this.qa(VideoPbFragment.this.iCG.aMi());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.iTF != null && VideoPbFragment.this.ciU() != null && VideoPbFragment.this.cqt() != null) {
                        VideoPbFragment.this.iTF.cny();
                        if (VideoPbFragment.this.yC(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.ciU() != null) {
                            VideoPbFragment.this.cki();
                            if (VideoPbFragment.this.ciU().getPbData() != null && VideoPbFragment.this.ciU().getPbData().chK() != null && VideoPbFragment.this.ciU().getPbData().chK().azE() != null) {
                                TiebaStatic.log(new an("c13402").cp("tid", VideoPbFragment.this.ciU().ckU()).cp("fid", VideoPbFragment.this.ciU().getPbData().getForumId()).Z("obj_locate", 3).cp("uid", VideoPbFragment.this.ciU().getPbData().chK().azE().getUserId()));
                            }
                            if (VideoPbFragment.this.ciU().getPbData().chK() != null && VideoPbFragment.this.ciU().getPbData().chK().azE() != null && VideoPbFragment.this.ciU().getPbData().chK().azE().getUserId() != null && VideoPbFragment.this.iCr != null) {
                                int g = VideoPbFragment.this.iTF.g(VideoPbFragment.this.ciU().getPbData());
                                bj chK = VideoPbFragment.this.ciU().getPbData().chK();
                                if (!chK.ays()) {
                                    if (chK.aBz()) {
                                        i2 = 3;
                                    } else if (chK.aBA()) {
                                        i2 = 4;
                                    } else {
                                        i2 = chK.aBB() ? 5 : 1;
                                    }
                                }
                                TiebaStatic.log(new an("c12526").cp("tid", VideoPbFragment.this.ciU().ckU()).Z("obj_locate", 1).cp("obj_id", VideoPbFragment.this.ciU().getPbData().chK().azE().getUserId()).Z("obj_type", VideoPbFragment.this.iCr.awd() ? 0 : 1).Z("obj_source", g).Z("obj_param1", i2));
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.cpY();
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.ciU() != null && VideoPbFragment.this.iTF != null && VideoPbFragment.this.cTN != null && VideoPbFragment.this.ciU().getPbData() != null && VideoPbFragment.this.ciU().getPbData().chK() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        if (VideoPbFragment.this.ciU().getPbData().chK().azv() != 0) {
                            int currentItem = VideoPbFragment.this.cTN.getCurrentItem();
                            if (currentItem == VideoPbFragment.iTm) {
                                VideoPbFragment.this.cTN.setCurrentItem(VideoPbFragment.iTn);
                            } else if (currentItem == VideoPbFragment.iTn) {
                                if (VideoPbFragment.this.cqt() != null && VideoPbFragment.this.bDZ() != null) {
                                    an cp = new an("c13403").cp("tid", VideoPbFragment.this.ciU().ckU()).cp("fid", VideoPbFragment.this.ciU().getPbData().getForumId()).cp("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView bDZ = VideoPbFragment.this.bDZ();
                                    boolean canScrollVertically = bDZ.canScrollVertically(1);
                                    boolean canScrollVertically2 = bDZ.canScrollVertically(-1);
                                    if (VideoPbFragment.this.Cf != null) {
                                        VideoPbFragment.this.Cf.setExpanded(false, true);
                                    }
                                    if (bDZ.getLayoutManager() != null && (bDZ.getLayoutManager() instanceof LinearLayoutManager)) {
                                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) bDZ.getLayoutManager();
                                        if (!canScrollVertically2 && canScrollVertically) {
                                            if (VideoPbFragment.this.iCm != -1 || VideoPbFragment.this.iCn != Integer.MIN_VALUE) {
                                                if (VideoPbFragment.this.iCm > 3 || (VideoPbFragment.this.iCm == 3 && VideoPbFragment.this.iCn < (-equipmentHeight))) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.iCm, VideoPbFragment.this.iCn + equipmentHeight);
                                                    bDZ.smoothScrollBy(0, equipmentHeight);
                                                } else if (VideoPbFragment.this.iCm >= 2) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.iCm, VideoPbFragment.this.iCn + (equipmentHeight / 2));
                                                    bDZ.smoothScrollBy(0, equipmentHeight / 2);
                                                } else if (VideoPbFragment.this.iCm == 1) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.iCm, VideoPbFragment.this.iCn + (equipmentHeight / 4));
                                                    bDZ.smoothScrollBy(0, equipmentHeight / 4);
                                                } else {
                                                    bDZ.smoothScrollBy(0, -VideoPbFragment.this.iCn);
                                                }
                                                cp.Z("obj_locate", 2);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            int firstVisiblePosition = bDZ.getFirstVisiblePosition();
                                            View childAt = bDZ.getChildAt(0);
                                            int top = childAt == null ? 0 : childAt.getTop();
                                            VideoPbFragment.this.iCm = firstVisiblePosition;
                                            VideoPbFragment.this.iCn = top;
                                            if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top < (-equipmentHeight) && bDZ.getCount() >= 6)) {
                                                linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                bDZ.smoothScrollToPosition(0);
                                            } else {
                                                bDZ.smoothScrollToPosition(0);
                                            }
                                            cp.Z("obj_locate", 1);
                                        }
                                        TiebaStatic.log(cp);
                                        TiebaStatic.log(new an("c12942").Z("obj_type", 1).Z("obj_locate", 4).cp("tid", VideoPbFragment.this.ciU().ckU()));
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (VideoPbFragment.this.ciU() != null && VideoPbFragment.this.ciU().getPbData() != null && VideoPbFragment.this.ciU().getPbData().chK() != null && VideoPbFragment.this.ciU().getPbData().chK().azE() != null) {
                                TiebaStatic.log(new an("c13402").cp("tid", VideoPbFragment.this.ciU().ckU()).cp("fid", VideoPbFragment.this.ciU().getPbData().getForumId()).Z("obj_locate", 2).cp("uid", VideoPbFragment.this.ciU().getPbData().chK().azE().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.cjU();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.iCT >= 0) {
                        if (VideoPbFragment.this.ciU() != null) {
                            VideoPbFragment.this.ciU().clH();
                        }
                        if (VideoPbFragment.this.ciU() != null && VideoPbFragment.this.cqt() != null && VideoPbFragment.this.cqt().crb() != null) {
                            VideoPbFragment.this.cqt().crb().setData(VideoPbFragment.this.ciU().getPbData());
                        }
                        VideoPbFragment.this.iCT = 0;
                        VideoPbFragment.this.iTH = Integer.MIN_VALUE;
                        if (VideoPbFragment.this.ciU() != null && VideoPbFragment.this.cqt() != null) {
                            VideoPbFragment.this.cqt().cu(VideoPbFragment.this.ciU().clK(), VideoPbFragment.this.ciU().clL());
                            VideoPbFragment.this.ciU().cr(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.ciU() != null) {
                        an anVar5 = new an("c13398");
                        anVar5.cp("tid", VideoPbFragment.this.ciU().ckU());
                        anVar5.cp("fid", VideoPbFragment.this.ciU().getForumId());
                        anVar5.cp("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar5.Z("obj_locate", 2);
                        TiebaStatic.log(anVar5);
                    }
                } else if (view.getId() == R.id.pb_item_tail_content) {
                    if (bc.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                        String string2 = com.baidu.tbadk.core.sharedPref.b.aCY().getString("tail_link", "");
                        if (!StringUtils.isNull(string2)) {
                            TiebaStatic.log("c10056");
                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                        }
                        VideoPbFragment.this.cmK();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.cmK();
                }
            }
        }
    };
    private View.OnClickListener izF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.iTF != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.iTF.b(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.iTF.cw(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.iTF.b(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.iTF.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    private a iTG = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void ckg() {
        if (ciU() != null && ciU().getPbData() != null && ciU().getPbData().chK() != null) {
            bj chK = ciU().getPbData().chK();
            chK.mRecomAbTag = ciU().clR();
            chK.mRecomWeight = ciU().clP();
            chK.mRecomSource = ciU().clQ();
            chK.mRecomExtra = ciU().clS();
            if (chK.getFid() == 0) {
                chK.setFid(com.baidu.adp.lib.f.b.toLong(ciU().getForumId(), 0L));
            }
            an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), chK, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjY() {
        if (ciU() != null && ciU().getPbData() != null && ciU().getPbData().chK() != null) {
            bj chK = ciU().getPbData().chK();
            chK.mRecomAbTag = ciU().clR();
            chK.mRecomWeight = ciU().clP();
            chK.mRecomSource = ciU().clQ();
            chK.mRecomExtra = ciU().clS();
            if (chK.getFid() == 0) {
                chK.setFid(com.baidu.adp.lib.f.b.toLong(ciU().getForumId(), 0L));
            }
            an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), chK, "c13563");
            if (a2 != null) {
                a2.Z("reply_type", 1);
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
            String string = !TextUtils.isEmpty(bVar.kew) ? bVar.kew : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.sz(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.fu(true);
                aVar.b(getPageContext());
                aVar.aBW();
            } else {
                a(0, bVar.mSuccess, bVar.kew, z);
            }
            if (bVar.mSuccess) {
                if (bVar.fSL == 1) {
                    ArrayList<PostData> chM = ciU().getPbData().chM();
                    int size = chM.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(chM.get(i).getId())) {
                            i++;
                        } else {
                            chM.remove(i);
                            break;
                        }
                    }
                    ciU().getPbData().chK().js(ciU().getPbData().chK().azv() - 1);
                    if (cqt() != null) {
                        cqt().cra();
                    }
                } else if (bVar.fSL == 0) {
                    ckh();
                } else if (bVar.fSL == 2) {
                    ArrayList<PostData> chM2 = ciU().getPbData().chM();
                    int size2 = chM2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= chM2.get(i2).cIq().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(chM2.get(i2).cIq().get(i3).getId())) {
                                i3++;
                            } else {
                                chM2.get(i2).cIq().remove(i3);
                                chM2.get(i2).cIs();
                                z2 = true;
                                break;
                            }
                        }
                        chM2.get(i2).ID(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3 && cqt() != null) {
                        cqt().cra();
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = ciU().getPbData().chV().ixt;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cIq().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cIq().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cIq().remove(i2);
                    list.get(i).cIs();
                    z = true;
                    break;
                }
            }
            list.get(i).ID(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2 && cqt() != null) {
            cqt().cra();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null && ciU() != null && ciU().getPbData() != null && ciU().getPbData().chK() != null) {
            a(this.fEP.getLoadDataMode(), gVar.mSuccess, gVar.kew, false);
            if (gVar.mSuccess) {
                this.iCu = true;
                if (i == 2 || i == 3) {
                    this.iCv = true;
                    this.iCw = false;
                } else if (i == 4 || i == 5) {
                    this.iCv = false;
                    this.iCw = true;
                }
                if (i == 2) {
                    ciU().getPbData().chK().jv(1);
                    ciU().setIsGood(1);
                } else if (i == 3) {
                    ciU().getPbData().chK().jv(0);
                    ciU().setIsGood(0);
                } else if (i == 4) {
                    ciU().getPbData().chK().ju(1);
                    ciU().yF(1);
                } else if (i == 5) {
                    ciU().getPbData().chK().ju(0);
                    ciU().yF(0);
                }
            }
            if (ciU().getPbData().chK() != null && cqu() != null) {
                cqu().cqX();
            }
        }
    }

    private void ckh() {
        if (ciU().ckW() || ciU().ckY()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", ciU().ckU());
            PbActivity pbActivity = this.iBR;
            PbActivity pbActivity2 = this.iBR;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, ciU().ckU()));
        if (ckk()) {
            this.iBR.finish();
        }
    }

    private boolean ckk() {
        if (ciU() == null) {
            return true;
        }
        if (ciU().getPbData() == null || !ciU().getPbData().cik()) {
            if (ciU().awd()) {
                final MarkData clo = ciU().clo();
                if (clo == null || !ciU().getIsFromMark() || bDZ() == null) {
                    return true;
                }
                final MarkData yM = ciU().yM(bDZ().getFirstVisiblePosition());
                if (yM == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", clo);
                    this.iBR.setResult(-1, intent);
                    return true;
                } else if (yM.getPostId() == null || yM.getPostId().equals(clo.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", clo);
                    this.iBR.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.sz(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.iCr != null) {
                                if (VideoPbFragment.this.iCr.awd()) {
                                    VideoPbFragment.this.iCr.awe();
                                    VideoPbFragment.this.iCr.fa(false);
                                }
                                VideoPbFragment.this.iCr.a(yM);
                                VideoPbFragment.this.iCr.fa(true);
                                VideoPbFragment.this.iCr.awf();
                            }
                            clo.setPostId(yM.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", clo);
                            VideoPbFragment.this.iBR.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.cjj();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.15
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", clo);
                            VideoPbFragment.this.iBR.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.cjj();
                        }
                    });
                    aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.b(getBaseFragmentActivity().getPageContext());
                    aVar.aBW();
                    return false;
                }
            } else if (ciU().getPbData() == null || ciU().getPbData().chM() == null || ciU().getPbData().chM().size() <= 0 || !ciU().getIsFromMark()) {
                return true;
            } else {
                this.iBR.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjj() {
        this.iBR.cjj();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void cpY() {
        int i = 4;
        if (ciU() != null && this.iTF != null) {
            if (ShareSwitch.isOn() || checkUpIsLogin()) {
                if (ciU().getPbData() != null && ciU().getPbData().chK() != null && ciU().getPbData().chK().azE() != null) {
                    TiebaStatic.log(new an("c13402").cp("tid", ciU().ckU()).cp("fid", ciU().getPbData().getForumId()).Z("obj_locate", 4).cp("uid", ciU().getPbData().chK().azE().getUserId()));
                }
                if (ciU().getPbData() != null && ciU().getPbData().chK() != null) {
                    bj chK = ciU().getPbData().chK();
                    if (chK.ays()) {
                        i = 2;
                    } else if (chK.aBz()) {
                        i = 3;
                    } else if (!chK.aBA()) {
                        if (chK.aBB()) {
                            i = 5;
                        }
                    }
                    an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    anVar.cp("tid", ciU().ckU());
                    anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.cp("fid", ciU().getForumId());
                    anVar.Z("obj_locate", 5);
                    anVar.Z("obj_name", i);
                    anVar.Z("obj_type", 2);
                    if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        anVar.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    TiebaStatic.log(anVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (ciU().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> chM = ciU().getPbData().chM();
                        if ((chM == null || chM.size() <= 0) && ciU().ckV()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.iTF.cny();
                        bBD();
                        TiebaStatic.log(new an("c11939"));
                        if (ShareSwitch.isOn()) {
                            yE(6);
                            return;
                        }
                        this.iTF.showLoadingDialog();
                        ciU().clB().t(CheckRealNameModel.TYPE_PB_SHARE, 6);
                        return;
                    }
                }
                i = 1;
                an anVar2 = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                anVar2.cp("tid", ciU().ckU());
                anVar2.cp("uid", TbadkCoreApplication.getCurrentAccount());
                anVar2.cp("fid", ciU().getForumId());
                anVar2.Z("obj_locate", 5);
                anVar2.Z("obj_name", i);
                anVar2.Z("obj_type", 2);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                TiebaStatic.log(anVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment cpZ() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        e eVar = (e) y.b(getActivity()).l(e.class);
        F(eVar.cqB());
        if (ciU() != null && ciU().getPbData() != null) {
            boolean isFromMark = ciU().getIsFromMark();
            com.baidu.tieba.pb.data.f pbData = ciU().getPbData();
            if (isFromMark) {
                PostData E = E(pbData);
                if (pbData.awc() != null && !pbData.awc().equals(E.getId()) && this.cTN != null) {
                    this.cTN.setCurrentItem(iTn);
                }
            }
        }
        eVar.cqC().observe(this, new q<bj>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aI */
            public void onChanged(@Nullable bj bjVar) {
                if (bjVar != null && bjVar.azV() != null) {
                    if (VideoPbFragment.this.iTu.getVideoUrl() == null || !VideoPbFragment.this.iTu.getVideoUrl().equals(bjVar.azV().video_url)) {
                        if (!aq.isEmpty(VideoPbFragment.this.iTu.getVideoUrl())) {
                            VideoPbFragment.this.iCe = true;
                            VideoPbFragment.this.cTN.setCurrentItem(VideoPbFragment.iTm);
                        }
                        if (VideoPbFragment.this.iTv == null || !VideoPbFragment.this.iTv.isPlaying()) {
                            VideoPbFragment.this.cqa();
                            VideoPbFragment.this.aH(bjVar);
                        }
                        VideoPbFragment.this.cqb();
                        if (VideoPbFragment.this.iTv.cqP()) {
                            VideoPbFragment.this.iTv.start();
                        }
                        boolean z = !aq.equals(VideoPbFragment.this.iTu.getVideoUrl(), bjVar.azV().video_url);
                        VideoPbFragment.this.iTu.setData(bjVar);
                        VideoPbFragment.this.iTu.crm();
                        VideoPbFragment.this.iTu.qH(VideoPbFragment.this.cTN.getCurrentItem() == 0);
                        if (z) {
                            VideoPbFragment.this.iTu.startPlay();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.iTu.setData(bjVar);
                }
            }
        });
        eVar.cqL().observe(this, new q<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: p */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.cTN.setCurrentItem(num.intValue());
            }
        });
        eVar.cqG().observe(this, new q<bj>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aI */
            public void onChanged(@Nullable bj bjVar) {
                VideoPbFragment.this.iTu.aM(bjVar);
            }
        });
        eVar.cqH().observe(this, new q<bj>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aI */
            public void onChanged(@Nullable bj bjVar) {
                VideoPbFragment.this.iTu.aN(bjVar);
            }
        });
        eVar.cqI().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.cqm();
            }
        });
        eVar.cqJ().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqa() {
        ViewGroup.LayoutParams layoutParams = this.iTw.getLayoutParams();
        layoutParams.height = 0;
        this.iTw.setLayoutParams(layoutParams);
        this.iTw.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqb() {
        if (this.iTv == null) {
            this.iTv = new f(getBaseFragmentActivity(), this.iTt);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(ckE()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.iTt.getOriginHeight() + statusBarHeight);
            final e eVar = (e) y.b(getActivity()).l(e.class);
            this.iTv.b(eVar.cqD(), rect);
            if (this.iTv.cqP()) {
                this.iTv.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (eVar.cqE() || VideoPbFragment.this.ciU().clU() == VideoPbFragment.iTn) {
                            VideoPbFragment.this.cTN.setCurrentItem(VideoPbFragment.iTn);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (eVar.cqE() || VideoPbFragment.this.ciU().clU() == VideoPbFragment.iTn) {
                            VideoPbFragment.this.cTN.setCurrentItem(VideoPbFragment.iTn);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (eVar.cqE() || ciU().clU() == iTn) {
                this.cTN.setCurrentItem(iTn);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return this.iTu.onBackPress();
        }
        if (i == 24) {
            return this.iTu.crr();
        }
        if (i == 25) {
            return this.iTu.crs();
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
    public void aH(bj bjVar) {
        double d;
        int i;
        ViewGroup.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        CoordinatorLayout.LayoutParams layoutParams3;
        Rect clT;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        double equipmentHeight = (2.0d * equipmentWidth) / l.getEquipmentHeight(getContext());
        if (bjVar != null && bjVar.azV() != null) {
            int intValue = bjVar.azV().video_width.intValue();
            int intValue2 = bjVar.azV().video_height.intValue();
            if (intValue2 > 0) {
                d = (intValue * 1.0f) / intValue2;
                if (d > 1.7777777777777777d) {
                    d = 1.7777777777777777d;
                }
                if (d >= equipmentHeight) {
                    equipmentHeight = d;
                }
                int ceil = (int) Math.ceil(equipmentWidth / equipmentHeight);
                int height = (ciU() != null || (clT = ciU().clT()) == null) ? ceil : clT.height();
                i = 0;
                layoutParams = this.iTt.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.iTt.setLayoutParams(layoutParams);
                this.iTt.setMaxHeight(ceil);
                this.iTt.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.iTt.setOriginHeight(height);
                layoutParams2 = (RelativeLayout.LayoutParams) this.iTp.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, iTo);
                } else {
                    layoutParams2.height = iTo;
                }
                this.iTp.setLayoutParams(layoutParams2);
                layoutParams3 = (CoordinatorLayout.LayoutParams) this.Cf.getLayoutParams();
                int i2 = ceil + iTo;
                if (layoutParams3 != null) {
                    layoutParams3 = new CoordinatorLayout.LayoutParams(-1, i2);
                } else {
                    layoutParams3.height = i2;
                }
                this.Cf.setLayoutParams(layoutParams3);
                if (i == 0 && (this.Cf.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.Cf.getLayoutParams()).getBehavior();
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
        if (ciU() != null) {
        }
        i = 0;
        layoutParams = this.iTt.getLayoutParams();
        if (layoutParams != null) {
        }
        this.iTt.setLayoutParams(layoutParams);
        this.iTt.setMaxHeight(ceil2);
        this.iTt.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.iTt.setOriginHeight(height);
        layoutParams2 = (RelativeLayout.LayoutParams) this.iTp.getLayoutParams();
        if (layoutParams2 != null) {
        }
        this.iTp.setLayoutParams(layoutParams2);
        layoutParams3 = (CoordinatorLayout.LayoutParams) this.Cf.getLayoutParams();
        int i22 = ceil2 + iTo;
        if (layoutParams3 != null) {
        }
        this.Cf.setLayoutParams(layoutParams3);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.iBY = System.currentTimeMillis();
        super.onCreate(bundle);
        initData();
        ak(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.iCN = new com.baidu.tbadk.core.view.d();
        this.iCN.toastTime = 1000L;
        if (this.iTF != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.iTF.iCO;
            userMuteAddAndDelCustomMessage.setTag(this.iTF.iCO);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.iTF.iCO;
            userMuteCheckCustomMessage.setTag(this.iTF.iCO);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    private void initData() {
        this.iCr = com.baidu.tbadk.baseEditMark.a.a(this.iBR);
        if (this.iCr != null) {
            this.iCr.a(this.iDv);
        }
        this.fEP = new ForumManageModel(this.iBR);
        this.fEP.setLoadDataCallBack(this.fEU);
        this.cVO = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.iTF = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void ak(Bundle bundle) {
        this.iCF = new g();
        d(this.iCF);
        this.iCG = (com.baidu.tbadk.editortools.pb.e) this.iCF.dR(getActivity());
        this.iCG.a(this.iBR.getPageContext());
        this.iCG.a(this.dui);
        this.iCG.a(this.dub);
        this.iCG.a(this.iBR.getPageContext(), bundle);
        this.iCG.aLC().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.iCG.aLC().gp(true);
        pv(true);
        this.iCG.a(ciU().clj(), ciU().ckU(), ciU().clD());
        registerListener(this.iDd);
        registerListener(this.iDu);
        registerListener(this.iDc);
        registerListener(this.iDa);
        registerListener(this.gkl);
        if (!ciU().cla()) {
            this.iCG.uP(ciU().ckU());
        }
        if (ciU().clE()) {
            this.iCG.uO(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.iCG.uO(cmM());
        }
        this.iCx = new as();
        if (this.iCG.aMb() != null) {
            this.iCx.e(this.iCG.aMb().getInputView());
        }
        this.iCG.a(this.duc);
        this.hJV = new aj(getPageContext());
        this.hJV.a(new aj.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            @Override // com.baidu.tbadk.core.util.aj.a
            public void j(boolean z, int i) {
                if (z) {
                    if (i == aj.cVJ) {
                        VideoPbFragment.this.iCG.a((String) null, (WriteData) null);
                    } else if (i == aj.cVK && VideoPbFragment.this.iKb != null && VideoPbFragment.this.iKb.cjJ() != null) {
                        VideoPbFragment.this.iKb.cjJ().aMx();
                    } else if (i == aj.cVL) {
                        VideoPbFragment.this.c(VideoPbFragment.this.iCJ);
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
        this.gnc = new com.baidu.tieba.f.b(getActivity());
        this.gnc.a(iDD);
        aZT();
        this.Cf = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.iTr = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.iTt = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.iTu = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.iTt);
        this.iTu.setUniqueId(getUniqueId());
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.iTp = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.iTw = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.cTN = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.iTs = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.iTs.setOnClickListener(this.aqZ);
        cqd();
        cqc();
        cqe();
        this.iTq = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.cTN.setAdapter(this.iTq);
        this.iTp.setViewPager(this.cTN);
        this.iTp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (VideoPbFragment.this.cqt() != null) {
                        VideoPbFragment.this.cqt().qG(false);
                    }
                    if (VideoPbFragment.this.cqu() != null) {
                        VideoPbFragment.this.cqu().qG(true);
                        VideoPbFragment.this.zk(VideoPbFragment.this.cqu().cqZ() != 0 ? 0 : 8);
                    }
                    e eVar = (e) y.b(VideoPbFragment.this.getActivity()).l(e.class);
                    if (eVar.cqI() != null && eVar.cqI().getValue() != null && eVar.cqI().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.iTu.qH(z);
                    VideoPbFragment.this.cmK();
                    if (VideoPbFragment.this.ciU() != null && VideoPbFragment.this.ciU().getPbData() != null) {
                        TiebaStatic.log(new an("c13592").cp("tid", VideoPbFragment.this.ciU().ckU()).cp("fid", VideoPbFragment.this.ciU().getPbData().getForumId()));
                        return;
                    }
                    return;
                }
                if (VideoPbFragment.this.cqu() != null) {
                    VideoPbFragment.this.cqu().qG(false);
                }
                if (VideoPbFragment.this.cqt() != null) {
                    VideoPbFragment.this.cqt().qG(true);
                    int cqZ = VideoPbFragment.this.cqt().cqZ();
                    int cre = VideoPbFragment.this.cqt().cre();
                    if (cqZ != 0) {
                        VideoPbFragment.this.zk(8);
                        VideoPbFragment.this.cqt().zk(0);
                    } else if (cre != 0) {
                        VideoPbFragment.this.cqt().zk(8);
                        VideoPbFragment.this.zk(0);
                    } else {
                        VideoPbFragment.this.cqt().zk(8);
                        VideoPbFragment.this.zk(8);
                    }
                }
                VideoPbFragment.this.iTu.qH(false);
                VideoPbFragment.this.Cf.setExpanded(false, true);
                if (VideoPbFragment.this.ciU() != null && VideoPbFragment.this.ciU().getPbData() != null) {
                    TiebaStatic.log(new an("c13593").cp("tid", VideoPbFragment.this.ciU().ckU()).cp("fid", VideoPbFragment.this.ciU().getPbData().getForumId()));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.iJf = this.rootView.findViewById(R.id.viewstub_progress);
        cqf();
        cqg();
    }

    private void cqc() {
        this.iTy = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.iTC = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.iTz = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.iTA = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.iTB = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.iTC.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.iTC.setConrers(15);
        this.iTB.setConfig(new com.baidu.tbadk.core.view.commonBtn.d());
        this.iTA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c13591"));
                VideoPbFragment.this.cqo();
            }
        });
        this.iTB.setOnClickListener(this.iTx);
        this.iTw.setOnClickListener(this.iTx);
    }

    private void cqd() {
        this.iTp.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.iTp.setContainerLayoutParams(layoutParams);
        this.iTp.setRectPaintColor(R.color.cp_link_tip_a);
        this.iTp.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.iTp.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.iTp.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.iTp.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.iTp.setExpandedTabLayoutParams(layoutParams2);
    }

    private void cqe() {
        this.iJw = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.iJx = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.iJD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.iJE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.hbh = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.hbh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.cjU();
                if (VideoPbFragment.this.ciU() != null && VideoPbFragment.this.ciU().getPbData() != null && VideoPbFragment.this.ciU().getPbData().chK() != null && VideoPbFragment.this.ciU().getPbData().chK().azE() != null) {
                    TiebaStatic.log(new an("c13402").cp("tid", VideoPbFragment.this.ciU().ckU()).cp("fid", VideoPbFragment.this.ciU().getPbData().getForumId()).Z("obj_locate", 1).cp("uid", VideoPbFragment.this.ciU().getPbData().chK().azE().getUserId()));
                }
            }
        });
        this.iJy = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.iJy.setOnClickListener(this.aqZ);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.iJz = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.iJz.setOnClickListener(this.aqZ);
        if (booleanExtra) {
            this.iJz.setVisibility(8);
        } else {
            this.iJz.setVisibility(0);
        }
        this.iJA = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.iJA.setOnClickListener(this.aqZ);
        this.iJB = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
        qc(false);
    }

    private void aZT() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.bBE();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mNavigationBar.setStatusBarVisibility(8);
        }
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        if (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(ckE());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        }
        this.dBy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aqZ);
        this.eyT = (ImageView) this.dBy.findViewById(R.id.widget_navi_back_button);
        SvgManager.aDW().a(this.eyT, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.iON = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.aqZ);
        this.KA = (ImageView) this.iON.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams2.rightMargin = dimens2;
        this.iON.setLayoutParams(layoutParams2);
        SvgManager.aDW().a(this.KA, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.iON.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
    }

    public void cqf() {
        setEditorTools(this.iCG.aLC());
    }

    private void cqg() {
        this.iBO = new PbFakeFloorModel(getPageContext());
        this.iKb = new t(getPageContext(), this.iBO, this.rootView);
        this.iKb.a(this.iDr);
        this.iBO.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void q(PostData postData) {
                VideoPbFragment.this.iBO.r(postData);
                if (VideoPbFragment.this.cqt() != null) {
                    VideoPbFragment.this.cqt().cra();
                }
                VideoPbFragment.this.iKb.cjF();
                VideoPbFragment.this.Fq.aJZ();
                VideoPbFragment.this.qc(false);
            }
        });
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.iBR = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (ciU() != null) {
            ciU().au(bundle);
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
        this.iTu.my(true);
        if (ciU() != null && !ciU().cla()) {
            this.iCG.saveDraft(ciU().ckU());
        }
        com.baidu.tbadk.BdToken.c.auQ().auV();
        MessageManager.getInstance().unRegisterListener(this.iDn);
        MessageManager.getInstance().unRegisterListener(this.iDo);
        MessageManager.getInstance().unRegisterListener(this.iDp);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.isPaused = false;
        getVoiceManager().onResume(getPageContext());
        this.iTu.my(false);
        ckA();
        registerListener(this.iDn);
        registerListener(this.iDo);
        registerListener(this.iDp);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        if (this.fEP != null) {
            this.fEP.cancelLoadData();
        }
        if (this.iTu != null) {
            this.iTu.onDestroy();
        }
        if (this.iCi != null) {
            this.iCi.cancelLoadData();
        }
        if (this.hJV != null) {
            this.hJV.onDestroy();
        }
        if (ciU() != null) {
            ciU().cancelLoadData();
            ciU().destory();
            if (ciU().clA() != null) {
                ciU().clA().onDestroy();
            }
        }
        if (this.iCG != null) {
            this.iCG.onDestroy();
        }
        this.iCN = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.iBR);
        this.iTp.onChangeSkinType();
        am.setBackgroundColor(this.iTp, R.color.cp_bg_line_h);
        this.iCx.onChangeSkinType();
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        if (this.iTv == null || !this.iTv.isPlaying()) {
            am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        }
        am.setBackgroundColor(this.mStatusBar, R.color.cp_mask_b);
        if (this.Fq != null) {
            this.Fq.onChangeSkinType(i);
        }
        if (this.iKb != null) {
            this.iKb.onChangeSkinType(i);
        }
        if (this.hbh != null) {
            am.setViewTextColor(this.hbh, (int) R.color.cp_cont_d);
            this.hbh.setBackgroundDrawable(am.au(l.getDimens(getContext(), R.dimen.tbds47), am.getColor(R.color.cp_bg_line_j)));
        }
        if (this.iJz != null && ciU() != null) {
            if (ciU().awd()) {
                SvgManager.aDW().a(this.iJz, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aDW().a(this.iJz, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.iJA != null) {
            SvgManager.aDW().a(this.iJA, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.iJy != null) {
            SvgManager.aDW().a(this.iJy, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        am.setViewTextColor(this.iJB, (int) R.color.cp_cont_b);
        if (this.iJw != null) {
            am.setBackgroundResource(this.iJw, R.drawable.bottom_shadow);
        }
        am.setBackgroundColor(this.iJx, R.color.cp_bg_line_h);
        if (cqt() != null) {
            cqt().onChangeSkinType(i);
        }
        if (cqu() != null) {
            cqu().onChangeSkinType(i);
        }
        if (this.iTr != null) {
            am.setBackgroundResource(this.iTr, R.drawable.personalize_tab_shadow);
        }
        if (this.iTw != null) {
            am.setBackgroundColor(this.iTw, R.color.cp_bg_line_g);
        }
        if (this.iTA != null) {
            SvgManager.aDW().a(this.iTA, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.iTy != null) {
            am.setViewTextColor(this.iTy, (int) R.color.cp_cont_b);
        }
        if (this.iTz != null) {
            am.setViewTextColor(this.iTz, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.giZ == null) {
            this.giZ = VoiceManager.instance();
        }
        return this.giZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBD() {
        if (this.giZ != null) {
            this.giZ.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment ckC() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment ckD() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel ciU() {
        return this.iBR.ciU();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity ckE() {
        return this.iBR;
    }

    public com.baidu.tbadk.baseEditMark.a cqh() {
        return this.iCr;
    }

    public View.OnClickListener cqi() {
        return this.aqZ;
    }

    public View.OnClickListener cqj() {
        return this.izF;
    }

    public View.OnLongClickListener cqk() {
        return this.iTF.cqk();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (av.FI(objArr[i].getLink()) && (drawable = am.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    public BdTypeRecyclerView bDZ() {
        Iterator<BaseFragment> it = this.iTq.cqz().iterator();
        while (it.hasNext()) {
            BaseFragment next = it.next();
            if (next instanceof ReplyFragment) {
                return ((ReplyFragment) next).getListView();
            }
        }
        return null;
    }

    private void pv(boolean z) {
        this.iCG.gt(z);
        this.iCG.gu(z);
        this.iCG.gv(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.iTF != null) {
            if (z) {
                this.iTF.cny();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.iTF.cnz();
            } else {
                this.iTF.cny();
            }
        }
    }

    public boolean yB(int i) {
        if (this.hJV == null || ciU() == null || ciU().getPbData() == null || ciU().getPbData().getAnti() == null) {
            return true;
        }
        return this.hJV.at(ciU().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean cjW() {
        if ((ciU() != null && ciU().getPbData().cik()) || this.hJV == null || ciU() == null || ciU().getPbData() == null || ciU().getPbData().getAnti() == null) {
            return true;
        }
        return this.hJV.kb(ciU().getPbData().getAnti().replyPrivateFlag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(g gVar) {
        if (gVar != null && ciU() != null) {
            gVar.setForumName(ciU().ciK());
            if (ciU().getPbData() != null && ciU().getPbData().getForum() != null) {
                gVar.a(ciU().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(ciU());
        }
    }

    public void cna() {
        if (this.Fq != null) {
            this.Fq.lw();
            if (this.iCG != null) {
                this.iCG.aMf();
            }
            cnH();
        }
    }

    public void cjU() {
        if (checkUpIsLogin() && ciU() != null && ciU().getPbData() != null && ciU().getPbData().getForum() != null) {
            if (ciU().getPbData().cik()) {
                bML();
                return;
            }
            if (this.gmA == null) {
                this.gmA = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.gmA.tE(0);
                this.gmA.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void li(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void r(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void lj(boolean z) {
                        if (z) {
                            VideoPbFragment.this.bML();
                        }
                    }
                });
            }
            this.gmA.B(ciU().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(ciU().ckU(), 0L));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.iCG.onActivityResult(i, i2, intent);
        if (this.iCi != null) {
            this.iCi.onActivityResult(i, i2, intent);
        }
        if (this.iKb != null) {
            this.iKb.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cki();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.n.a.czt().A(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.iCJ = emotionImageData;
                        if (yB(aj.cVL)) {
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
        if (ckE() != null) {
            ckE().cjg();
        }
        this.iTG.iTQ = z;
        cql();
        cqm();
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.iBR;
        if (i == 0) {
            cmG();
            if (this.iKb != null) {
                this.iKb.cjF();
            }
            qc(false);
        }
        cmK();
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
                        this.iCG.resetData();
                        this.iCG.setVoiceModel(pbEditorData.getVoiceModel());
                        this.iCG.b(writeData);
                        com.baidu.tbadk.editortools.l lX = this.iCG.aLC().lX(6);
                        if (lX != null && lX.dsh != null) {
                            lX.dsh.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.iBR;
                        if (i == -1) {
                            this.iCG.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.iKb != null && this.iKb.cjJ() != null) {
                            com.baidu.tbadk.editortools.pb.h cjJ = this.iKb.cjJ();
                            cjJ.setThreadData(ciU().getPbData().chK());
                            cjJ.b(writeData);
                            cjJ.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l lX2 = cjJ.aLC().lX(6);
                            if (lX2 != null && lX2.dsh != null) {
                                lX2.dsh.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.iBR;
                            if (i == -1) {
                                cjJ.aMx();
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
                if (ciU() != null && !ciU().cla()) {
                    antiData.setBlock_forum_name(ciU().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(ciU().getPbData().getForum().getId());
                    antiData.setUser_name(ciU().getPbData().getUserData().getUserName());
                    antiData.setUser_id(ciU().getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.aW(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).Z("obj_locate", at.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).Z("obj_locate", at.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).Z("obj_locate", at.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            if (this.iTF != null) {
                this.iTF.uU(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void ckG() {
        if (ciU() != null) {
            if (this.iCG == null || !this.iCG.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.iCG = (com.baidu.tbadk.editortools.pb.e) dVar.dR(getContext());
                this.iCG.a(this.iBR.getPageContext());
                this.iCG.a(this.dui);
                this.iCG.a(this.dub);
                this.iCG.a(this.iBR.getPageContext(), this.iBR.getIntent() == null ? null : this.iBR.getIntent().getExtras());
                this.iCG.aLC().gp(true);
                setEditorTools(this.iCG.aLC());
                if (!ciU().cla()) {
                    this.iCG.uP(ciU().ckU());
                }
                if (ciU().clE()) {
                    this.iCG.uO(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.iCG.uO(cmM());
                }
            }
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Fq = editorTools;
        this.Fq.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.Fq.getParent() == null) {
            this.rootView.addView(this.Fq, layoutParams);
        }
        this.Fq.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.Fq.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof p) {
                    if (((p) aVar.data).aGJ() == EmotionGroupType.BIG_EMOTION || ((p) aVar.data).aGJ() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.iCG.c((p) aVar.data);
                            VideoPbFragment.this.iCG.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cmG();
        this.iCG.b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (VideoPbFragment.this.Fq != null && VideoPbFragment.this.Fq.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3 && TextUtils.isEmpty(charSequence.toString().substring(i, i + i3))) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (VideoPbFragment.this.iCx != null && VideoPbFragment.this.iCx.cnW() != null) {
                    if (!VideoPbFragment.this.iCx.cnW().cRK()) {
                        VideoPbFragment.this.iCx.qh(false);
                    }
                    VideoPbFragment.this.iCx.cnW().tr(false);
                }
            }
        });
    }

    public void bML() {
        if (!checkUpIsLogin()) {
            if (ciU() != null) {
                TiebaStatic.log(new an("c10517").Z("obj_locate", 2).cp("fid", ciU().getForumId()));
            }
        } else if (cjW()) {
            if (this.iCG != null && (this.iCG.aMp() || this.iCG.aMq())) {
                this.iCG.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.Fq != null) {
                cna();
                this.iTG.iTP = false;
                if (this.Fq.lX(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.Fq.lX(2).dsh, false, null);
                }
            }
            cnH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && cjW()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.iCk);
                this.iCl = ((View) view.getParent()).getMeasuredHeight();
            }
            if (ciU() != null && ciU().getPbData() != null && ciU().getPbData().cik()) {
                com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.iBR.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        VideoPbFragment.this.bDZ().smoothScrollBy(0, (VideoPbFragment.this.iCk[1] + VideoPbFragment.this.iCl) - (equipmentHeight - dimens));
                        if (VideoPbFragment.this.iKb != null) {
                            VideoPbFragment.this.iCG.aLC().setVisibility(8);
                            VideoPbFragment.this.iKb.g(str, str2, VideoPbFragment.this.cmM(), (VideoPbFragment.this.ciU() == null || VideoPbFragment.this.ciU().getPbData() == null || VideoPbFragment.this.ciU().getPbData().chK() == null || !VideoPbFragment.this.ciU().getPbData().chK().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cjJ = VideoPbFragment.this.iKb.cjJ();
                            if (cjJ != null && VideoPbFragment.this.ciU() != null && VideoPbFragment.this.ciU().getPbData() != null) {
                                cjJ.a(VideoPbFragment.this.ciU().getPbData().getAnti());
                                cjJ.setThreadData(VideoPbFragment.this.ciU().getPbData().chK());
                            }
                            if (VideoPbFragment.this.iCx.cnY() == null && VideoPbFragment.this.iKb.cjJ().aMF() != null) {
                                VideoPbFragment.this.iKb.cjJ().aMF().c(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.iCx != null && VideoPbFragment.this.iCx.cnX() != null) {
                                            if (!VideoPbFragment.this.iCx.cnX().cRK()) {
                                                VideoPbFragment.this.iCx.qi(false);
                                            }
                                            VideoPbFragment.this.iCx.cnX().tr(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.iCx.f(VideoPbFragment.this.iKb.cjJ().aMF().getInputView());
                                VideoPbFragment.this.iKb.cjJ().a(VideoPbFragment.this.iCL);
                            }
                        }
                        VideoPbFragment.this.cnH();
                    }
                }, 0L);
                return;
            }
            if (this.iCI == null) {
                this.iCI = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.iCI.tE(1);
                this.iCI.a(new AnonymousClass40(str, str2));
            }
            if (ciU() != null && ciU().getPbData() != null && ciU().getPbData().getForum() != null) {
                this.iCI.B(ciU().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(ciU().ckU(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$40  reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass40 implements c.a {
        final /* synthetic */ String iDP;
        final /* synthetic */ String iDQ;

        AnonymousClass40(String str, String str2) {
            this.iDP = str;
            this.iDQ = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void li(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void r(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lj(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.40.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        VideoPbFragment.this.bDZ().smoothScrollBy(0, (VideoPbFragment.this.iCk[1] + VideoPbFragment.this.iCl) - (equipmentHeight - dimens));
                        if (VideoPbFragment.this.iKb != null) {
                            VideoPbFragment.this.iCG.aLC().setVisibility(8);
                            VideoPbFragment.this.iKb.g(AnonymousClass40.this.iDP, AnonymousClass40.this.iDQ, VideoPbFragment.this.cmM(), (VideoPbFragment.this.ciU() == null || VideoPbFragment.this.ciU().getPbData() == null || VideoPbFragment.this.ciU().getPbData().chK() == null || !VideoPbFragment.this.ciU().getPbData().chK().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cjJ = VideoPbFragment.this.iKb.cjJ();
                            if (cjJ != null && VideoPbFragment.this.ciU() != null && VideoPbFragment.this.ciU().getPbData() != null) {
                                cjJ.a(VideoPbFragment.this.ciU().getPbData().getAnti());
                                cjJ.setThreadData(VideoPbFragment.this.ciU().getPbData().chK());
                            }
                            if (VideoPbFragment.this.iCx.cnY() == null && VideoPbFragment.this.iKb.cjJ().aMF() != null) {
                                VideoPbFragment.this.iKb.cjJ().aMF().c(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.40.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.iCx != null && VideoPbFragment.this.iCx.cnX() != null) {
                                            if (!VideoPbFragment.this.iCx.cnX().cRK()) {
                                                VideoPbFragment.this.iCx.qi(false);
                                            }
                                            VideoPbFragment.this.iCx.cnX().tr(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.iCx.f(VideoPbFragment.this.iKb.cjJ().aMF().getInputView());
                                VideoPbFragment.this.iKb.cjJ().a(VideoPbFragment.this.iCL);
                            }
                        }
                        VideoPbFragment.this.cnH();
                    }
                }, 0L);
            }
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData E;
        w wVar;
        StringBuilder sb = null;
        if (fVar != null && (E = E(fVar)) != null) {
            String userId = E.azE().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, E.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.chW()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (E.azE() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, E.azE().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, E.azE().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, E.azE().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, E.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, E.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.chW()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bf> cie = fVar.cie();
                if (v.getCount(cie) > 0) {
                    sb = new StringBuilder();
                    for (bf bfVar : cie) {
                        if (bfVar != null && !StringUtils.isNull(bfVar.getForumName()) && (wVar = bfVar.cMB) != null && wVar.cKu && !wVar.cKv && (wVar.type == 1 || wVar.type == 2)) {
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
    public void cki() {
        MarkData yM;
        if (ciU() != null && ciU().getPbData() != null && cqt() != null && this.iCr != null) {
            if (ciU().getPbData() != null && ciU().getPbData().cik()) {
                yM = ciU().yM(0);
            } else if (this.cTN != null && this.cTN.getCurrentItem() == iTm) {
                yM = ciU().l(E(ciU().getPbData()));
            } else {
                yM = ciU().yM(cqt().cnk());
            }
            if (yM != null) {
                if (!yM.isApp() || (yM = ciU().yM(cqt().cnk() + 1)) != null) {
                    cnf();
                    this.iCr.a(yM);
                    if (!this.iCr.awd()) {
                        this.iCr.awf();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.iCr.awe();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yC(int i) {
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
            if (this.iCi == null) {
                this.iCi = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.iBR);
                this.iCi.b(this.dub);
                this.iCi.c(this.dui);
            }
            this.iCi.a(emotionImageData, ciU(), ciU().getPbData());
        }
    }

    public PostData E(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.chU() != null) {
            return fVar.chU();
        }
        if (!v.isEmpty(fVar.chM())) {
            Iterator<PostData> it = fVar.chM().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cIt() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.chR();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.azE() != null && postData.azE().getUserTbVipInfoData() != null && postData.azE().getUserTbVipInfoData().getvipIntro() != null) {
            postData.azE().getGodUserData().setIntro(postData.azE().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.chK() == null || fVar.chK().azE() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData azE = fVar.chK().azE();
        String userId = azE.getUserId();
        HashMap<String, MetaData> userMap = fVar.chK().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = azE;
        }
        postData.Cl(1);
        postData.setId(fVar.chK().azU());
        postData.setTitle(fVar.chK().getTitle());
        postData.setTime(fVar.chK().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ckn() {
        ArrayList<PostData> chM;
        int count;
        int i;
        if (ciU() == null || ciU().getPbData() == null || ciU().getPbData().chM() == null || (count = v.getCount((chM = ciU().getPbData().chM()))) == 0) {
            return "";
        }
        if (ciU().clm()) {
            Iterator<PostData> it = chM.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cIt() == 1) {
                    return next.getId();
                }
            }
        }
        if (bDZ() == null) {
            i = 0;
        } else {
            i = cqt().cnj();
        }
        PostData postData = (PostData) v.getItem(chM, i);
        if (postData == null || postData.azE() == null) {
            return "";
        }
        if (ciU().Fx(postData.azE().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) v.getItem(chM, i2);
            if (postData2 == null || postData2.azE() == null || postData2.azE().getUserId() == null) {
                break;
            } else if (ciU().Fx(postData2.azE().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) v.getItem(chM, i3);
            if (postData3 == null || postData3.azE() == null || postData3.azE().getUserId() == null) {
                return "";
            }
            if (ciU().Fx(postData3.azE().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckj() {
        if (ciU() != null) {
            com.baidu.tieba.pb.data.f pbData = ciU().getPbData();
            ciU().pI(true);
            if (this.iCr != null) {
                pbData.Fj(this.iCr.awc());
            }
            if (cqt() != null) {
                cqt().cra();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (ciU() != null) {
            cnh();
            ciU().pI(z);
            if (this.iCr != null) {
                this.iCr.fa(z);
                if (markData != null) {
                    this.iCr.a(markData);
                }
            }
            if (ciU().awd()) {
                ckj();
            } else if (cqt() != null) {
                cqt().cra();
            }
        }
    }

    public void b(m mVar) {
        MetaData metaData;
        boolean z = true;
        if (ciU() != null && ciU().getPbData() != null && mVar.cix() != null) {
            String id = mVar.cix().getId();
            ArrayList<PostData> chM = ciU().getPbData().chM();
            int i = 0;
            while (true) {
                if (i >= chM.size()) {
                    break;
                }
                PostData postData = chM.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> ciB = mVar.ciB();
                    postData.Ck(mVar.getTotalCount());
                    if (postData.cIq() != null && ciB != null) {
                        Iterator<PostData> it = ciB.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.azE() != null && (metaData = postData.getUserMap().get(next.azE().getUserId())) != null) {
                                next.a(metaData);
                                next.sy(true);
                                next.a(getPageContext(), ciU().Fx(metaData.getUserId()));
                            }
                        }
                        boolean z2 = ciB.size() != postData.cIq().size();
                        postData.cIq().clear();
                        postData.cIq().addAll(ciB);
                        z = z2;
                    }
                    if (postData.cIm() != null) {
                        postData.cIn();
                    }
                }
            }
            if (!ciU().getIsFromMark() && z && cqt() != null) {
                cqt().cra();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjZ() {
        if (ciU() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.HY(ciU().getForumId()) && ciU().getPbData() != null && ciU().getPbData().getForum() != null) {
            if (ciU().getPbData().getForum().isLike() == 1) {
                ciU().clC().ek(ciU().getForumId(), ciU().ckU());
            }
        }
    }

    public void cmK() {
        reset();
        cmG();
        this.iKb.cjF();
        qc(false);
    }

    private void reset() {
        if (this.iCG != null && this.Fq != null) {
            com.baidu.tbadk.editortools.pb.a.aLY().setStatus(0);
            this.iCG.aMs();
            this.iCG.aLM();
            if (this.iCG.getWriteImagesInfo() != null) {
                this.iCG.getWriteImagesInfo().setMaxImagesAllowed(this.iCG.isBJH ? 1 : 9);
            }
            this.iCG.md(SendView.ALL);
            this.iCG.me(SendView.ALL);
            com.baidu.tbadk.editortools.g lU = this.Fq.lU(23);
            com.baidu.tbadk.editortools.g lU2 = this.Fq.lU(2);
            com.baidu.tbadk.editortools.g lU3 = this.Fq.lU(5);
            if (lU2 != null) {
                lU2.lw();
            }
            if (lU3 != null) {
                lU3.lw();
            }
            if (lU != null) {
                lU.hide();
            }
            this.Fq.invalidate();
        }
    }

    public void q(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.chK() != null) {
            if (fVar.awd()) {
                SvgManager.aDW().a(this.iJz, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aDW().a(this.iJz, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.iJB.setText(yU(fVar.chK().azv()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.chK()));
        }
    }

    private String yU(int i) {
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

    public void qc(boolean z) {
        if (this.iJx != null) {
            qa(this.iCG.aMi());
            if (this.iJt) {
                pR(z);
            } else {
                pS(z);
            }
            cql();
            cqm();
        }
    }

    public void cnH() {
        if (this.iJx != null) {
            this.iJw.setVisibility(8);
            this.iJx.setVisibility(8);
            this.iTG.iTP = false;
            cql();
            cqm();
        }
    }

    private void cql() {
        if (this.iTu != null) {
            if (this.iTG.cqy()) {
                this.iTu.rA(false);
            } else {
                this.iTu.rA(this.iTu.bfB() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqm() {
        if (this.iTu != null && this.cTN != null) {
            if (this.cTN.getCurrentItem() != 0) {
                this.iTu.qH(false);
            } else if (this.iTG.cqy()) {
                this.iTu.qH(false);
            } else {
                e eVar = (e) y.b(getActivity()).l(e.class);
                if (eVar != null) {
                    this.iTu.qH(eVar.cqI() == null || eVar.cqI().getValue() == null || eVar.cqI().getValue().booleanValue());
                }
            }
        }
    }

    private void yE(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(ckE(), cjX(), i);
    }

    private int cjX() {
        if (ciU() == null || ciU().getPbData() == null || ciU().getPbData().chK() == null) {
            return -1;
        }
        return ciU().getPbData().chK().aAo();
    }

    public void qa(boolean z) {
        this.iJt = z;
    }

    public void pR(boolean z) {
        if (this.iJx != null && this.hbh != null) {
            this.hbh.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.iJx.startAnimation(alphaAnimation);
            }
            this.iJw.setVisibility(0);
            this.iJx.setVisibility(0);
            this.iTG.iTP = true;
        }
    }

    public void pS(boolean z) {
        if (this.iJx != null && this.hbh != null) {
            this.hbh.setText(cmM());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.iJx.startAnimation(alphaAnimation);
            }
            this.iJw.setVisibility(0);
            this.iJx.setVisibility(0);
            this.iTG.iTP = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null) {
            this.iwR = aVar;
            this.iTy.setText(aVar.getTitle());
            this.iTz.setText(aVar.crf());
            String crg = aVar.crg();
            TBSpecificationBtn tBSpecificationBtn = this.iTB;
            if (TextUtils.isEmpty(crg)) {
                crg = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(crg);
            this.iTC.startLoad(aVar.getImage(), 10, false);
            com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
                @Override // java.lang.Runnable
                public void run() {
                    TiebaStatic.log(new an("c13608").cp("obj_id", VideoPbFragment.this.iwR.getTitle()).cp("obj_name", VideoPbFragment.this.iwR.crf()).Z("obj_type", 2).cp("fid", VideoPbFragment.this.ciU().getPbData().getForumId()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("tid", VideoPbFragment.this.ciU().getPbData().getThreadId()));
                    VideoPbFragment.this.cqn();
                }
            }, aVar.crh().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqn() {
        ViewGroup.LayoutParams layoutParams = this.iTw.getLayoutParams();
        if (layoutParams != null) {
            if (this.iTD == null || !this.iTD.isRunning()) {
                this.iTw.setAlpha(0.0f);
                this.iTw.setVisibility(0);
                f(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqo() {
        if (this.iTw.getLayoutParams() != null) {
            if (this.iTD == null || !this.iTD.isRunning()) {
                cqp();
            }
        }
    }

    private void cqp() {
        final ViewGroup.LayoutParams layoutParams = this.iTw.getLayoutParams();
        if (layoutParams != null) {
            if (this.iTE == null || !this.iTE.isRunning()) {
                this.iTE = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.iTE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.iTw.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.iTE.setDuration(200L);
                this.iTE.start();
                this.iTE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43
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
        final ViewGroup.LayoutParams layoutParams2 = this.Cf.getLayoutParams();
        final int i = layoutParams2.height;
        this.iTD = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.iTD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.gZG);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.gZG);
                VideoPbFragment.this.iTw.setLayoutParams(layoutParams);
                VideoPbFragment.this.Cf.setLayoutParams(layoutParams2);
            }
        });
        this.iTD.setDuration(300L);
        this.iTD.start();
        this.iTD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.iTw.setVisibility(8);
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
        final ViewGroup.LayoutParams layoutParams2 = this.Cf.getLayoutParams();
        final int i = layoutParams2.height;
        this.iTD = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iTD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.gZG);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.iTw.setLayoutParams(layoutParams);
                VideoPbFragment.this.Cf.setLayoutParams(layoutParams2);
            }
        });
        this.iTD.setDuration(300L);
        this.iTD.start();
        this.iTD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.cqq();
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
    public void cqq() {
        this.iTD = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iTD.setDuration(300L);
        this.iTD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.iTw.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.iTD.start();
    }

    public String cmM() {
        if (!aq.isEmpty(this.iKs)) {
            return this.iKs;
        }
        this.iKs = TbadkCoreApplication.getInst().getResources().getString(ap.cmB());
        return this.iKs;
    }

    public void cnh() {
        hideProgressBar();
        if (cqt() != null) {
            cqt().endLoadData();
            cqt().cni();
        }
    }

    public boolean cp(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && i.axf().isShowImages()) {
                    return Ft(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (ciU() == null || ciU().getPbData() == null) {
                        return true;
                    }
                    if (this.iKb != null) {
                        this.iKb.cjF();
                    }
                    m mVar = new m();
                    mVar.a(ciU().getPbData().getForum());
                    mVar.setThreadData(ciU().getPbData().chK());
                    mVar.f(postData);
                    this.iBO.d(mVar);
                    this.iBO.setPostId(postData.getId());
                    b(view, postData.azE().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.iCG != null) {
                        qa(this.iCG.aMi());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void cqr() {
        if (this.iCG != null) {
            qa(this.iCG.aMi());
        }
        cmK();
        this.iTF.cny();
    }

    private boolean Ft(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aCY().getString("bubble_link", "");
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

    public void bTG() {
        this.iJf.setVisibility(0);
    }

    public void bTF() {
        this.iJf.setVisibility(8);
    }

    public void zk(int i) {
        if (this.iTr != null) {
            this.iTr.setVisibility(i);
        }
    }

    public void cnf() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a ckd() {
        return this.iDt;
    }

    public void cmG() {
        if (this.Fq != null) {
            this.Fq.hide();
        }
    }

    public void bBE() {
        if (this.iBR.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.iBR.getCurrentFocus());
        }
    }

    public void F(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.chK() != null) {
            String valueOf = String.valueOf(fVar.chK().azv());
            if (fVar.chK().azv() == 0) {
                valueOf = "";
            }
            this.iTp.vK(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        for (BaseFragment baseFragment : this.iTq.cqz()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, fVar, str, i4);
            }
        }
        b(z, i, i2, i3, fVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (ciU() != null && ciU().getPbData() != null && ciU().getPbData().chK() != null && ciU().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(iJU)).intValue();
                if (intValue == iJV) {
                    if (!this.fEP.cJi()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.fEP.IJ(aq.N(jSONArray));
                        }
                        this.fEP.a(ciU().getPbData().getForum().getId(), ciU().getPbData().getForum().getName(), ciU().getPbData().chK().getId(), str, intValue3, intValue2, booleanValue, ciU().getPbData().chK().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == iJW || intValue == iJY) {
                    if (ciU().clz() != null) {
                        ciU().clz().yw(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == iJW) {
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
    public int aRM() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> aRN() {
        if (this.dHY == null) {
            this.dHY = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: aRZ */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = i.axf().isShowImages();
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
                        if (i.axf().isShowImages()) {
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
        return this.dHY;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> aRO() {
        if (this.dKO == null) {
            this.dKO = TbRichTextView.z(getPageContext().getPageActivity(), 8);
        }
        return this.dKO;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> aRP() {
        if (this.dHZ == null) {
            this.dHZ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bEt */
                public GifView makeObject() {
                    GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = i.axf().isShowImages();
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
                    if (i.axf().isShowImages()) {
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
                    gifView.aMX();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.dHZ;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> aRQ() {
        if (this.dKP == null) {
            this.dKP = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: ckH */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(VideoPbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(VideoPbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cs */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: ct */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).cJE();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cu */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.dKP;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> aRR() {
        if (this.dKQ == null) {
            this.dKQ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: ckJ */
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
        return this.dKQ;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> aRS() {
        this.dKR = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: ckI */
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
        return this.dKR;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aB(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.iCc = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void d(Context context, String str, boolean z) {
        if (av.FI(str) && ciU() != null && ciU().ckU() != null) {
            TiebaStatic.log(new an("c11664").Z("obj_param1", 1).cp("post_id", ciU().ckU()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                lVar.mLink = str;
                lVar.type = 3;
                lVar.drj = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
            }
        } else {
            av.coa().c(getPageContext(), str);
        }
        this.iCc = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aC(Context context, String str) {
        av.coa().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.iCc = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aD(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aE(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void r(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.iTF.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b cqS = this.iTF.cqS();
            if (cqS == null) {
                this.iTF.cjT();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                cqS.getItemView(1).setVisibility(8);
            } else {
                cqS.getItemView(1).setVisibility(0);
            }
            cqS.aBX();
            this.iCc = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            ba.aEa().b(getPageContext(), new String[]{str});
            this.iCc = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a cqs() {
        return this.cVO;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener aPD() {
        return this.dne;
    }

    public ReplyFragment cqt() {
        if (this.iTq == null || !(this.iTq.zl(iTn) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.iTq.zl(iTn);
    }

    public DetailInfoFragment cqu() {
        if (this.iTq == null || !(this.iTq.zl(iTm) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.iTq.zl(iTm);
    }

    public boolean ciJ() {
        PbModel ciU = this.iBR.ciU();
        if (ciU == null) {
            return false;
        }
        return ciU.ciJ();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData chT;
        PbModel ciU = this.iBR.ciU();
        if (ciU != null && ciU.getPbData() != null && !ciU.getPbData().cik()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = ciU.getPbData().chK().getId();
            if (ciU.isShareThread() && ciU.getPbData().chK().cPD != null) {
                historyMessage.threadName = ciU.getPbData().chK().cPD.showText;
            } else {
                historyMessage.threadName = ciU.getPbData().chK().getTitle();
            }
            if (ciU.isShareThread() && !ciJ()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = ciU.getPbData().getForum().getName();
            }
            ArrayList<PostData> chM = ciU.getPbData().chM();
            int cnj = cqt() != null ? cqt().cnj() : 0;
            if (chM != null && cnj >= 0 && cnj < chM.size()) {
                historyMessage.postID = chM.get(cnj).getId();
            }
            historyMessage.isHostOnly = ciU.getHostMode();
            historyMessage.isSquence = ciU.ckV();
            historyMessage.isShareThread = ciU.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.iCG != null) {
            this.iCG.onDestroy();
        }
        if (ciU != null && (ciU.ckW() || ciU.ckY())) {
            Intent intent = new Intent();
            intent.putExtra("tid", ciU.ckU());
            if (this.iCu) {
                if (this.iCw) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", ciU.bvj());
                }
                if (this.iCv) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", ciU.getIsGood());
                }
            }
            if (ciU.getPbData() != null && System.currentTimeMillis() - this.iBY >= 40000 && (chT = ciU.getPbData().chT()) != null && !v.isEmpty(chT.getDataList())) {
                intent.putExtra("guess_like_data", chT);
            }
            PbActivity pbActivity = this.iBR;
            PbActivity pbActivity2 = this.iBR;
            pbActivity.setResult(-1, intent);
        }
        if (ckk()) {
            if (ciU != null) {
                com.baidu.tieba.pb.data.f pbData = ciU.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.iCe) {
                        if (this.iTt != null) {
                            Rect rect = new Rect();
                            this.iTt.getGlobalVisibleRect(rect);
                            ak.cmq().h(rect);
                        }
                        ak.cmq().yQ(this.cTN.getCurrentItem());
                        BdTypeRecyclerView bDZ = bDZ();
                        Parcelable parcelable = null;
                        if (bDZ != null) {
                            parcelable = bDZ.onSaveInstanceState();
                        }
                        ak.cmq().a(ciU.cld(), parcelable, ciU.ckV(), ciU.getHostMode(), false);
                    }
                }
            } else {
                ak.cmq().reset();
            }
            cjj();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.iTu != null && !this.iTu.bfB()) {
            if ((this.iTu.isFullScreen() && configuration.orientation == 1) || (!this.iTu.isFullScreen() && configuration.orientation == 2)) {
                this.iTu.qI(false);
            }
        }
    }

    public boolean cqv() {
        if (this.iTu == null) {
            return false;
        }
        return this.iTu.bfB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a {
        public boolean iTP;
        public boolean iTQ;

        private a() {
            this.iTQ = true;
        }

        public boolean cqy() {
            return (this.iTP && this.iTQ) ? false : true;
        }
    }

    public void cqw() {
        this.iCm = -1;
        this.iCn = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckA() {
        if (ciU() != null && !aq.isEmpty(ciU().ckU())) {
            com.baidu.tbadk.BdToken.c.auQ().o(com.baidu.tbadk.BdToken.b.cCB, com.baidu.adp.lib.f.b.toLong(ciU().ckU(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.iTs.setVisibility(z ? 0 : 8);
    }
}
