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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.g;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.PbReplySwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tbadk.widget.richText.h;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.g.b;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.as;
import com.baidu.tieba.pb.pb.main.bb;
import com.baidu.tieba.pb.pb.main.be;
import com.baidu.tieba.pb.pb.main.v;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
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
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
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
/* loaded from: classes22.dex */
public class VideoPbFragment extends BaseFragment implements VoiceManager.c, TbRichTextView.c, h, com.baidu.tieba.pb.videopb.a, b {
    private AppBarLayout Zj;
    private EditorTools acn;
    private ImageView ahT;
    private CustomViewPager eRw;
    public View fEN;
    private com.baidu.adp.lib.d.b<ImageView> fMZ;
    private com.baidu.adp.lib.d.b<GifView> fNa;
    private com.baidu.adp.lib.d.b<TextView> fQq;
    private com.baidu.adp.lib.d.b<View> fQr;
    private com.baidu.adp.lib.d.b<LinearLayout> fQs;
    private com.baidu.adp.lib.d.b<RelativeLayout> fQt;
    private ImageView gOl;
    private VoiceManager iSW;
    private com.baidu.tieba.g.b iXQ;
    private com.baidu.tieba.frs.profession.permission.c iXq;
    private com.baidu.tieba.callfans.a ikq;
    public View jjp;
    public am kJE;
    public bb kNm;
    private com.baidu.tieba.pb.videopb.c.a lBv;
    private com.baidu.tieba.pb.pb.main.emotion.model.a lHI;
    int lHL;
    private PbFakeFloorModel lHk;
    private PbActivity lHp;
    private g lIh;
    private com.baidu.tbadk.editortools.pb.e lIi;
    private com.baidu.tieba.frs.profession.permission.c lIk;
    private EmotionImageData lIl;
    private com.baidu.tbadk.core.view.c lIp;
    private View lPQ;
    private LinearLayout lPS;
    private HeadImageView lPT;
    private ImageView lPU;
    private ImageView lPV;
    private ImageView lPW;
    private com.baidu.tieba.pb.view.d lPX;
    private TextView lPY;
    private TextView lPZ;
    private View lPz;
    private String lQR;
    private int lQb;
    private int lQc;
    private v lQz;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mStatusBar;
    private TBSpecificationBtn maA;
    private TbImageView maB;
    private View maC;
    private ValueAnimator maD;
    private ValueAnimator maE;
    public com.baidu.tieba.pb.videopb.b.a maF;
    private float maJ;
    private float maK;
    private boolean maL;
    private ObjectAnimator maP;
    private ObjectAnimator maQ;
    private NewPagerSlidingTabBaseStrip mal;
    private VideoPbFragmentAdapter mam;
    private View man;
    private View mao;
    private VideoContainerLayout maq;
    private com.baidu.tieba.pb.videopb.videoView.a mar;
    private f mas;
    private View mat;
    private View mau;
    private TextView maw;
    private TextView may;
    private ImageView maz;
    private RelativeLayout rootView;
    public static int mah = 0;
    public static int mai = 1;
    public static int maj = 0;
    public static int lQr = 3;
    public static int lQs = 0;
    public static int lQt = 3;
    public static int lQu = 4;
    public static int lQv = 5;
    public static int lQw = 6;
    private static final int jVb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int mak = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a lJi = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.g.b.a
        public void cW(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.dob();
            } else {
                com.baidu.tieba.pb.a.b.doa();
            }
        }
    };
    private long lHx = 0;
    private boolean lHE = false;
    View.OnClickListener mav = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.lBv == null || VideoPbFragment.this.lBv.dwW()) {
                if (VideoPbFragment.this.lBv != null) {
                    if (VideoPbFragment.this.lBv.isChushou) {
                        VideoPbFragment.this.eH(VideoPbFragment.this.lBv.thirdRoomId, VideoPbFragment.this.lBv.thirdLiveType);
                    } else {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = VideoPbFragment.this.lBv.dwX();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(VideoPbFragment.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_RECOMMEND, null, false, "")));
                    }
                    if (VideoPbFragment.this.dol() != null && VideoPbFragment.this.dol().getPbData() != null && VideoPbFragment.this.dol().getPbData().getForum() != null) {
                        TiebaStatic.log(new ar("c13713").dY("fid", VideoPbFragment.this.dol().getPbData().getForum().getId()).dY("fname", VideoPbFragment.this.dol().getPbData().getForum().getName()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("tid", VideoPbFragment.this.dol().getPbData().getThreadId()).w("obj_param1", VideoPbFragment.this.lBv.userId));
                        return;
                    }
                    return;
                }
                return;
            }
            TiebaStatic.log(new ar("c13590").dY("obj_id", VideoPbFragment.this.lBv.getTitle()).dY("obj_name", VideoPbFragment.this.lBv.dwT()).al("obj_type", 2).dY("fid", VideoPbFragment.this.dol().getPbData().getForumId()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("tid", VideoPbFragment.this.dol().getPbData().getThreadId()));
            String link = VideoPbFragment.this.lBv.getLink();
            if (!TextUtils.isEmpty(link)) {
                if (URLUtil.isHttpUrl(link) || URLUtil.isHttpsUrl(link)) {
                    bf.bua().b(VideoPbFragment.this.getPageContext(), new String[]{link});
                    return;
                }
                Uri parse = Uri.parse(link);
                if (parse != null) {
                    UtilHelper.dealOneScheme(VideoPbFragment.this.getActivity(), parse.toString());
                }
            }
        }
    };
    private boolean mIsLoading = false;
    private com.baidu.tbadk.baseEditMark.a lHU = null;
    private com.baidu.tbadk.coreExtra.model.a eTC = null;
    private ForumManageModel fXd = null;
    private boolean lHB = false;
    private View lPR = null;
    private TextView jYt = null;
    private boolean lPN = false;
    private String fwy = null;
    private boolean lHX = false;
    private boolean lHY = false;
    private boolean lHZ = false;
    private boolean lHD = false;
    int[] lHK = new int[2];
    private int lHM = -1;
    private int lHN = Integer.MIN_VALUE;
    private int lIv = 0;
    private int maH = Integer.MIN_VALUE;
    private boolean bIA = false;
    private boolean lHR = com.baidu.tbadk.a.d.bkr();
    private final PbModel.a lIY = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.h sg;
            VideoPbFragment.this.dsB();
            VideoPbFragment.this.cYm();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.vy(false);
            if (z && fVar != null) {
                by dmU = fVar.dmU();
                ((e) y.b(VideoPbFragment.this.getActivity()).l(e.class)).c(fVar, i2);
                VideoPbFragment.this.M(fVar);
                com.baidu.tieba.pb.videopb.c.a dnA = fVar.dnA();
                if (dnA != null && !dnA.mcI) {
                    VideoPbFragment.this.a(dnA);
                }
                VideoPbFragment.this.N(fVar);
                VideoPbFragment.this.c(z, i, i2, i3, fVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.lHU != null) {
                    VideoPbFragment.this.lHU.iH(fVar.bkY());
                }
                AntiData anti = fVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.fwy = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.fwy) && VideoPbFragment.this.lIi != null && VideoPbFragment.this.lIi.bCn() != null && (sg = VideoPbFragment.this.lIi.bCn().sg(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.fwy)) {
                        ((View) sg).setOnClickListener(VideoPbFragment.this.fxl);
                    }
                }
                if (VideoPbFragment.this.kJE != null && dmU != null && dmU.boP() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(dmU.boP());
                    VideoPbFragment.this.kJE.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.dol().dqk());
                        jSONObject.put("fid", VideoPbFragment.this.dol().getForumId());
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
                if ((!com.baidu.tbadk.a.d.bkt() || VideoPbFragment.this.dvX() != null) && VideoPbFragment.this.dvV() != null) {
                    if (com.baidu.tbadk.a.d.bkt()) {
                        if (i != -1) {
                            ArrayList<PostData> arrayList = null;
                            if (VideoPbFragment.this.dol() != null && VideoPbFragment.this.dol().getPbData() != null) {
                                arrayList = VideoPbFragment.this.dol().getPbData().dmW();
                            }
                            if (com.baidu.tbadk.core.util.y.getCount(arrayList) == 0 || (com.baidu.tbadk.core.util.y.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).dPh() == 1)) {
                                if (VideoPbFragment.this.dvX().dpK()) {
                                    VideoPbFragment.this.dvX().Qs(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.dvX().Qs(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.dvX().Qr(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.dvX().Qr("");
                        }
                        VideoPbFragment.this.dvX().endLoadData();
                    } else {
                        if (i != -1) {
                            ArrayList<PostData> arrayList2 = null;
                            if (VideoPbFragment.this.dol() != null && VideoPbFragment.this.dol().getPbData() != null) {
                                arrayList2 = VideoPbFragment.this.dol().getPbData().dmW();
                            }
                            if (com.baidu.tbadk.core.util.y.getCount(arrayList2) == 0 || (com.baidu.tbadk.core.util.y.getCount(arrayList2) == 1 && arrayList2.get(0) != null && arrayList2.get(0).dPh() == 1)) {
                                if (VideoPbFragment.this.dvV().dpK()) {
                                    VideoPbFragment.this.dvV().Qs(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.dvV().Qs(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.dvV().Qr(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.dvV().Qr("");
                        }
                        VideoPbFragment.this.dvV().endLoadData();
                    }
                } else {
                    return;
                }
            }
            com.baidu.tieba.t.c.dOf().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0583a lJa = new a.InterfaceC0583a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0583a
        public void d(boolean z, boolean z2, String str) {
            VideoPbFragment.this.dsB();
            if (z && VideoPbFragment.this.dol() != null) {
                if (VideoPbFragment.this.lHU != null) {
                    VideoPbFragment.this.lHU.iH(z2);
                }
                VideoPbFragment.this.dol().vc(z2);
                if (VideoPbFragment.this.dol().bkY()) {
                    VideoPbFragment.this.dpv();
                } else if (com.baidu.tbadk.a.d.bkt() && VideoPbFragment.this.dvX() != null) {
                    VideoPbFragment.this.dvX().dwG();
                } else if (VideoPbFragment.this.dvV() != null) {
                    VideoPbFragment.this.dvV().dwG();
                }
                if (z2) {
                    if (VideoPbFragment.this.lHU != null) {
                        if (VideoPbFragment.this.lHU.blb() != null && VideoPbFragment.this.dol() != null && VideoPbFragment.this.dol().getPbData() != null && VideoPbFragment.this.dol().getPbData().dmU() != null && VideoPbFragment.this.dol().getPbData().dmU().boP() != null) {
                            MarkData blb = VideoPbFragment.this.lHU.blb();
                            MetaData boP = VideoPbFragment.this.dol().getPbData().dmU().boP();
                            if (blb != null && boP != null) {
                                if (!au.equals(TbadkCoreApplication.getCurrentAccount(), boP.getUserId()) && !boP.hadConcerned()) {
                                    VideoPbFragment.this.maF.b(boP);
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
                    VideoPbFragment.this.dps();
                    return;
                }
                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private com.baidu.tbadk.editortools.pb.b fwC = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bCR() {
            if (VideoPbFragment.this.kNm == null || VideoPbFragment.this.kNm.dtt() == null || !VideoPbFragment.this.kNm.dtt().dYp()) {
                return !VideoPbFragment.this.Hd(am.eTx);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kNm.dtt().dYr());
            if (VideoPbFragment.this.lIi != null && (VideoPbFragment.this.lIi.bDi() || VideoPbFragment.this.lIi.bDj())) {
                VideoPbFragment.this.lIi.a(false, VideoPbFragment.this.kNm.dtw());
            }
            VideoPbFragment.this.kNm.vE(true);
            return true;
        }
    };
    private final CustomMessageListener lIC = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.dol() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.lIi != null) {
                    VideoPbFragment.this.vw(VideoPbFragment.this.lIi.bDb());
                }
                VideoPbFragment.this.dsc();
                VideoPbFragment.this.maF.dsS();
            }
        }
    };
    private CustomMessageListener lIF = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        VideoPbFragment.this.b((p) eVar.getData());
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
    private final CustomMessageListener iUy = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.64
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.bIA) {
                VideoPbFragment.this.dpN();
            }
        }
    };
    private CustomMessageListener lIZ = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.65
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.dpm();
            }
        }
    };
    private CustomMessageListener lIR = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.66
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.maF != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.maF.lIq) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.maF.cku();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.maF.getExtra();
                DataRes dataRes = aVar.nAM;
                if (aVar.error == 0 && dataRes != null) {
                    int i = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = i == 1;
                    if (au.isEmpty(str)) {
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
                    VideoPbFragment.this.maF.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.maF.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener lIP = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.maF != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.maF.lIq) {
                VideoPbFragment.this.maF.cku();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.dol().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.dnk().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.lIp.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.maF.Ea(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.maF.dpJ();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (au.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.lIp.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lIQ = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.maF != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.maF.lIq) {
                VideoPbFragment.this.maF.cku();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.lIp.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (au.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.lIp.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b lIn = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bCR() {
            if (VideoPbFragment.this.kNm == null || VideoPbFragment.this.kNm.dtu() == null || !VideoPbFragment.this.kNm.dtu().dYp()) {
                return !VideoPbFragment.this.Hd(am.eTy);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kNm.dtu().dYr());
            if (VideoPbFragment.this.lQz != null && VideoPbFragment.this.lQz.doW() != null && VideoPbFragment.this.lQz.doW().bDj()) {
                VideoPbFragment.this.lQz.doW().a(VideoPbFragment.this.kNm.dtw());
            }
            VideoPbFragment.this.kNm.vF(true);
            return true;
        }
    };
    private final NewWriteModel.d fwI = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                ar arVar = new ar("c13268");
                arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.dol() != null && VideoPbFragment.this.dol().getPbData() != null) {
                    arVar.dY("fid", VideoPbFragment.this.dol().getPbData().getForumId());
                }
                arVar.dY("tid", VideoPbFragment.this.dol().dqk());
                arVar.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            VideoPbFragment.this.cCF();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.dol() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.dol().Qm(postWriteCallBackData.getPostId());
                    if (com.baidu.tbadk.a.d.bkt() && VideoPbFragment.this.dvX() != null) {
                        VideoPbFragment.this.lIv = VideoPbFragment.this.dvX().dsD();
                        VideoPbFragment.this.maH = VideoPbFragment.this.dvX().dwJ();
                        VideoPbFragment.this.dol().dg(VideoPbFragment.this.lIv, VideoPbFragment.this.maH);
                    } else if (VideoPbFragment.this.dvV() != null) {
                        VideoPbFragment.this.lIv = VideoPbFragment.this.dvV().dsD();
                        VideoPbFragment.this.maH = VideoPbFragment.this.dvV().dwJ();
                        VideoPbFragment.this.dol().dg(VideoPbFragment.this.lIv, VideoPbFragment.this.maH);
                    }
                }
                if (VideoPbFragment.this.eRw != null) {
                    if (com.baidu.tbadk.a.d.bkt()) {
                        VideoPbFragment.this.eRw.setCurrentItem(VideoPbFragment.maj);
                    } else {
                        VideoPbFragment.this.eRw.setCurrentItem(VideoPbFragment.mai);
                    }
                }
                VideoPbFragment.this.maF.dsS();
                VideoPbFragment.this.kNm.dts();
                if (VideoPbFragment.this.lIi != null) {
                    VideoPbFragment.this.vw(VideoPbFragment.this.lIi.bDb());
                }
                VideoPbFragment.this.drY();
                VideoPbFragment.this.vy(true);
                VideoPbFragment.this.dol().dqG();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null) {
                            if (com.baidu.tbadk.a.d.bkt() && VideoPbFragment.this.dvX() != null) {
                                VideoPbFragment.this.dvX().dwG();
                            } else if (VideoPbFragment.this.dvV() != null) {
                                VideoPbFragment.this.dvV().dwG();
                            }
                        }
                    } else if (VideoPbFragment.this.dol().getHostMode()) {
                        com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.dol().getPbData();
                        if (pbData != null && pbData.dmU() != null && pbData.dmU().boP() != null && (userId = pbData.dmU().boP().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.dol().dqx()) {
                            VideoPbFragment.this.dsz();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.dol().dqx()) {
                        VideoPbFragment.this.dsz();
                    }
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    videoPbFragment.uN(z2);
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.lIi.bDi() || VideoPbFragment.this.lIi.bDj()) {
                    VideoPbFragment.this.lIi.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.kNm.h(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.kJE != null) {
                    VideoPbFragment.this.kJE.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.d(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.d(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPbFragment.this.getActivity());
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.Bq(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Bq(postWriteCallBackData.getErrorString());
                }
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(VideoPbFragment.this.getActivity(), 0, 26, 2)));
                        TiebaStatic.log(new ar("c13746").al("obj_locate", 1).al("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).brv();
                TiebaStatic.log(new ar("c13745").al("obj_locate", 1).al("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                VideoPbFragment.this.a(i, antiData, str);
            }
        }
    };
    private View.OnClickListener fxl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.showToast(VideoPbFragment.this.fwy);
        }
    };
    private CustomMessageListener lIE = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.lIi != null) {
                    VideoPbFragment.this.vw(VideoPbFragment.this.lIi.bDb());
                }
                VideoPbFragment.this.vy(false);
            }
        }
    };
    private int maI = 0;
    private boolean maM = true;
    private View.OnTouchListener maN = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.maI == 1) {
                if (!VideoPbFragment.this.maM) {
                    VideoPbFragment.this.dwa();
                    UtilHelper.showStatusBar(VideoPbFragment.this.dpR(), VideoPbFragment.this.dpR().getRootView());
                    VideoPbFragment.this.maM = true;
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(VideoPbFragment.this.maO);
                    com.baidu.adp.lib.f.e.mY().postDelayed(VideoPbFragment.this.maO, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (VideoPbFragment.this.maI == 2 && (VideoPbFragment.this.maM || VideoPbFragment.this.dwc())) {
                VideoPbFragment.this.dwb();
                UtilHelper.hideStatusBar(VideoPbFragment.this.dpR(), VideoPbFragment.this.dpR().getRootView());
                VideoPbFragment.this.maM = false;
                if (VideoPbFragment.this.mar != null) {
                    VideoPbFragment.this.mar.wa(false);
                }
            }
            VideoPbFragment.this.maI = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener jfa = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.maI = 0;
            VideoPbFragment.this.maJ = 0.0f;
            VideoPbFragment.this.maK = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.maJ += f;
            VideoPbFragment.this.maK += f2;
            if (VideoPbFragment.this.maI == 0 && !VideoPbFragment.this.maL && VideoPbFragment.this.mar != null && !VideoPbFragment.this.mar.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.maK) <= Math.abs(VideoPbFragment.this.maJ) || VideoPbFragment.this.maK > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.maK) > Math.abs(VideoPbFragment.this.maJ) && VideoPbFragment.this.maK > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.maI = 2;
                    }
                } else {
                    VideoPbFragment.this.maI = 1;
                }
            }
            return true;
        }
    };
    private Runnable maO = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.maM && !VideoPbFragment.this.dwc()) {
                VideoPbFragment.this.dwb();
                UtilHelper.hideStatusBar(VideoPbFragment.this.dpR(), VideoPbFragment.this.dpR().getRootView());
                VideoPbFragment.this.maM = false;
            }
        }
    };
    private final com.baidu.adp.base.d ikv = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.dol() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.fXd.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.fXd.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.dol().dqG();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.lXy != 1002 || bVar.gZt) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.mSuccess, dVar.noK, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.fXd.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.fXd.getLoadDataMode(), gVar.mSuccess, gVar.noK, false);
                    VideoPbFragment.this.maF.bf(gVar.noN);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener fGd = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.iXQ.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d lIW = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                ar arVar = new ar("c13268");
                arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.dol() != null && VideoPbFragment.this.dol().getPbData() != null) {
                    arVar.dY("fid", VideoPbFragment.this.dol().getPbData().getForumId());
                }
                if (VideoPbFragment.this.dol() != null) {
                    arVar.dY("tid", VideoPbFragment.this.dol().dqk());
                }
                arVar.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            if (z) {
                if (VideoPbFragment.this.kNm != null) {
                    VideoPbFragment.this.kNm.dtr();
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                    com.baidu.tbadk.coreExtra.c.b.a(VideoPbFragment.this.getPageContext(), postWriteCallBackData);
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (VideoPbFragment.this.kJE != null) {
                    VideoPbFragment.this.kJE.a(postWriteCallBackData.getReplyPrivacyTip());
                    return;
                }
                return;
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.d(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.d(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPbFragment.this.getActivity());
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.Bq(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Bq(postWriteCallBackData.getErrorString());
                }
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(VideoPbFragment.this.getActivity(), 0, 26, 2)));
                        TiebaStatic.log(new ar("c13746").al("obj_locate", 1).al("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).brv();
                TiebaStatic.log(new ar("c13745").al("obj_locate", 1).al("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.kNm != null) {
                if (VideoPbFragment.this.lQz != null && VideoPbFragment.this.lQz.doW() != null && VideoPbFragment.this.lQz.doW().bDj()) {
                    VideoPbFragment.this.lQz.doW().a(postWriteCallBackData);
                }
                VideoPbFragment.this.kNm.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c fwB = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bCS() {
            VideoPbFragment.this.showProgressBar();
        }
    };
    public final View.OnClickListener aGQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.21
        /* JADX DEBUG: Multi-variable search result rejected for r1v157, resolved type: com.baidu.tieba.pb.videopb.b.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray sparseArray;
            boolean C;
            int i = 2;
            int i2 = 3;
            int i3 = 1;
            if (view != null && VideoPbFragment.this.isAdded()) {
                if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    ar arVar = new ar("c13398");
                    arVar.dY("tid", VideoPbFragment.this.dol().dqk());
                    arVar.dY("fid", VideoPbFragment.this.dol().getForumId());
                    arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.al("obj_locate", 1);
                    TiebaStatic.log(arVar);
                    if (VideoPbFragment.this.lHB) {
                        VideoPbFragment.this.lHB = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.dol() != null && VideoPbFragment.this.dol().getPbData() != null && VideoPbFragment.this.lHk != null && postData.boP() != null && postData.dPh() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.lQz != null) {
                                    VideoPbFragment.this.lQz.doS();
                                }
                                p pVar = new p();
                                pVar.a(VideoPbFragment.this.dol().getPbData().getForum());
                                pVar.setThreadData(VideoPbFragment.this.dol().getPbData().dmU());
                                pVar.g(postData);
                                VideoPbFragment.this.lHk.d(pVar);
                                VideoPbFragment.this.lHk.setPostId(postData.getId());
                                VideoPbFragment.this.a(view, postData.boP().getUserId(), "", postData);
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.dol().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.lIi != null) {
                                    VideoPbFragment.this.vw(VideoPbFragment.this.lIi.bDb());
                                }
                            }
                        }
                    }
                } else if ((VideoPbFragment.this.dvV() != null && VideoPbFragment.this.dvV().dsO() != null && view == VideoPbFragment.this.dvV().dsO()) || ((com.baidu.tbadk.a.d.bkt() && VideoPbFragment.this.dvX() != null && VideoPbFragment.this.dvX().dsO() != null && view == VideoPbFragment.this.dvX().dsO()) || view.getId() == R.id.pb_more)) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.dol().va(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        if (com.baidu.tbadk.a.d.bkt()) {
                            VideoPbFragment.this.dvX().dsA();
                        } else {
                            VideoPbFragment.this.dvV().dsA();
                        }
                    }
                } else if (VideoPbFragment.this.maF != null && VideoPbFragment.this.maF.dtZ() != null && view == VideoPbFragment.this.maF.dtZ().drw()) {
                    VideoPbFragment.this.maF.bca();
                } else if ((VideoPbFragment.this.maF != null && ((VideoPbFragment.this.maF.dtZ() != null && view == VideoPbFragment.this.maF.dtZ().drx()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) || view.getId() == R.id.floor_owner_reply || view.getId() == R.id.reply_title) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.maF.dsS();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.cCF();
                        VideoPbFragment.this.dsz();
                        if (view.getId() == R.id.owner_reply) {
                            C = VideoPbFragment.this.dol().C(true, VideoPbFragment.this.dpz());
                        } else {
                            C = view.getId() == R.id.all_reply ? VideoPbFragment.this.dol().C(false, VideoPbFragment.this.dpz()) : VideoPbFragment.this.dol().Qj(VideoPbFragment.this.dpz());
                        }
                        view.setTag(Boolean.valueOf(C));
                        if (C) {
                            VideoPbFragment.this.cYn();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.fEN) {
                    if (VideoPbFragment.this.dol() != null && VideoPbFragment.this.dol().getPbData() != null) {
                        if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            ar arVar2 = new ar("c13266");
                            arVar2.dY("uid", TbadkCoreApplication.getCurrentAccount());
                            arVar2.dY("fid", VideoPbFragment.this.dol().getPbData().getForumId());
                            arVar2.dY("tid", VideoPbFragment.this.dol().dqk());
                            arVar2.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(arVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.lHp, VideoPbFragment.this.fEN);
                        VideoPbFragment.this.lHp.finish();
                    }
                } else if (view == VideoPbFragment.this.jjp && VideoPbFragment.this.maF != null) {
                    if (VideoPbFragment.this.dol() == null || VideoPbFragment.this.dol().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> dmW = VideoPbFragment.this.dol().getPbData().dmW();
                    if ((dmW == null || dmW.size() <= 0) && VideoPbFragment.this.dol().dqm()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new ar("c12378").dY("tid", VideoPbFragment.this.dol().dqk()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("fid", VideoPbFragment.this.dol().getForumId()));
                    VideoPbFragment.this.maF.dpn();
                } else if (VideoPbFragment.this.maF.dtZ() != null && view == VideoPbFragment.this.maF.dtZ().drB()) {
                    if (VideoPbFragment.this.dol() != null) {
                        VideoPbFragment.this.maF.dsS();
                        if (j.isNetWorkAvailable()) {
                            VideoPbFragment.this.cCF();
                            VideoPbFragment.this.dsz();
                            VideoPbFragment.this.dol().Hj(1);
                            return;
                        }
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    }
                } else if (VideoPbFragment.this.maF != null && VideoPbFragment.this.maF.dtZ() != null && view == VideoPbFragment.this.maF.dtZ().drx()) {
                    VideoPbFragment.this.maF.bca();
                } else if (VideoPbFragment.this.maF != null && ((VideoPbFragment.this.maF.dtZ() != null && view == VideoPbFragment.this.maF.dtZ().drE()) || view.getId() == R.id.pb_sort_type || view.getId() == R.id.pb_sort)) {
                    VideoPbFragment.this.maF.dsS();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.cCF();
                            VideoPbFragment.this.dsz();
                            VideoPbFragment.this.maF.dK(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.dol().dqE()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.maF != null && VideoPbFragment.this.maF.dtZ() != null && view == VideoPbFragment.this.maF.dtZ().drv()) {
                    if (VideoPbFragment.this.dol() != null && VideoPbFragment.this.dol().getPbData() != null && VideoPbFragment.this.dol().getPbData().dmU() != null) {
                        VideoPbFragment.this.maF.bca();
                        TiebaStatic.log(new ar("c13062"));
                        VideoPbFragment.this.maF.Qe(VideoPbFragment.this.dol().getPbData().dmU().bpg());
                    }
                } else if (view.getId() == R.id.pb_floor_feedback) {
                    try {
                        sparseArray = (SparseArray) view.getTag();
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                        sparseArray = null;
                    }
                    if (VideoPbFragment.this.maF != null) {
                        VideoPbFragment.this.maF.f(sparseArray);
                    }
                } else if (VideoPbFragment.this.maF != null && VideoPbFragment.this.maF.dtZ() != null && view == VideoPbFragment.this.maF.dtZ().drF()) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 1) {
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        ap.C(true, false);
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).al("obj_type", 0).al("obj_source", 1));
                    } else if (skinType == 0 || skinType == 4) {
                        UtilHelper.showSkinChangeAnimation(VideoPbFragment.this.getActivity());
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        UtilHelper.setNavigationBarBackground(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getResources().getColor(R.color.CAM_X0201_1));
                        TbadkCoreApplication.getInst().setSkinType(1);
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).al("obj_type", 1).al("obj_source", 1));
                    }
                    VideoPbFragment.this.maF.dtY();
                } else if (VideoPbFragment.this.maF != null && (view == VideoPbFragment.this.maF.dsx() || (VideoPbFragment.this.maF.dtZ() != null && (view == VideoPbFragment.this.maF.dtZ().drA() || view == VideoPbFragment.this.maF.dtZ().dry())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.dol() != null || VideoPbFragment.this.dol().getPbData() != null) {
                        if ((VideoPbFragment.this.dol().getPbData().dnj() == 1 || VideoPbFragment.this.dol().getPbData().dnj() == 3) && !VideoPbFragment.this.fXd.dQc()) {
                            VideoPbFragment.this.maF.dsS();
                            if (VideoPbFragment.this.maF.dtZ() != null && view == VideoPbFragment.this.maF.dtZ().dry()) {
                                if (VideoPbFragment.this.dol().getPbData().dmU().boK() == 1) {
                                    i2 = 5;
                                } else {
                                    i2 = 4;
                                }
                            } else if (VideoPbFragment.this.maF.dtZ() != null && view == VideoPbFragment.this.maF.dtZ().drA()) {
                                if (VideoPbFragment.this.dol().getPbData().dmU().boL() != 1) {
                                    i2 = 6;
                                }
                            } else {
                                i2 = view == VideoPbFragment.this.maF.dsx() ? 2 : 0;
                            }
                            ForumData forum = VideoPbFragment.this.dol().getPbData().getForum();
                            String name = forum.getName();
                            String id = forum.getId();
                            String id2 = VideoPbFragment.this.dol().getPbData().dmU().getId();
                            VideoPbFragment.this.showProgressBar();
                            VideoPbFragment.this.fXd.c(id, name, id2, i2, VideoPbFragment.this.maF.dsy());
                        }
                    }
                } else if (VideoPbFragment.this.maF != null && VideoPbFragment.this.maF.dtZ() != null && view == VideoPbFragment.this.maF.dtZ().drD()) {
                    if (VideoPbFragment.this.dol() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.maF.dsS();
                        SparseArray<Object> b = VideoPbFragment.this.b(VideoPbFragment.this.dol().getPbData(), VideoPbFragment.this.dol().dqm(), 1);
                        if (b != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.dol().getPbData().getForum().getId(), VideoPbFragment.this.dol().getPbData().getForum().getName(), VideoPbFragment.this.dol().getPbData().dmU().getId(), String.valueOf(VideoPbFragment.this.dol().getPbData().getUserData().getUserId()), (String) b.get(R.id.tag_forbid_user_name), (String) b.get(R.id.tag_forbid_user_name_show), (String) b.get(R.id.tag_forbid_user_post_id), (String) b.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.maF != null && VideoPbFragment.this.maF.dtZ() != null && view == VideoPbFragment.this.maF.dtZ().drz()) {
                    if (VideoPbFragment.this.dol() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.dol().getPbData(), VideoPbFragment.this.dol().dqm(), 1);
                        if (b2 != null) {
                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.maF.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.maF.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.maF.bca();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        ar arVar3 = new ar("c13398");
                        arVar3.dY("tid", VideoPbFragment.this.dol().dqk());
                        arVar3.dY("fid", VideoPbFragment.this.dol().getForumId());
                        arVar3.dY("uid", TbadkCoreApplication.getCurrentAccount());
                        arVar3.al("obj_locate", 4);
                        TiebaStatic.log(arVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new ar("c10517").al("obj_locate", 3).dY("fid", VideoPbFragment.this.dol().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.dol() != null && VideoPbFragment.this.dol().getPbData() != null) {
                        if (VideoPbFragment.this.maF != null) {
                            VideoPbFragment.this.maF.dsS();
                        }
                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                        PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                        PostData postData3 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                        if (postData2 != null) {
                            if (postData2.dPt() == 1) {
                                TiebaStatic.log(new ar("c12630"));
                            }
                            if (postData2.nmE != null) {
                                ar btS = postData2.nmE.btS();
                                btS.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    btS.al("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    btS.al("obj_locate", 8);
                                }
                                TiebaStatic.log(btS);
                            }
                            VideoPbFragment.this.cCF();
                            TiebaStatic.log("c11742");
                            if (postData3 != null) {
                                VideoPbFragment.this.a(postData2, postData3, false, true);
                            } else {
                                VideoPbFragment.this.a(postData2, (PostData) null, false, false);
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                    if (VideoPbFragment.this.dol() != null) {
                        if (view.getId() == R.id.pb_post_reply) {
                            ar arVar4 = new ar("c13398");
                            arVar4.dY("tid", VideoPbFragment.this.dol().dqk());
                            arVar4.dY("fid", VideoPbFragment.this.dol().getForumId());
                            arVar4.dY("uid", TbadkCoreApplication.getCurrentAccount());
                            arVar4.al("obj_locate", 6);
                            TiebaStatic.log(arVar4);
                        }
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData4 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                if (view.getId() == R.id.pb_post_reply && postData4.nmE != null) {
                                    ar btS2 = postData4.nmE.btS();
                                    btS2.delete("obj_locate");
                                    btS2.al("obj_locate", 8);
                                    TiebaStatic.log(btS2);
                                } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                    TiebaStatic.log(new ar("c13700").dY("tid", VideoPbFragment.this.dol().dql()).dY("fid", VideoPbFragment.this.dol().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("post_id", postData4.getId()).al("obj_source", 1).al("obj_type", 3));
                                }
                                if (VideoPbFragment.this.dol() != null && VideoPbFragment.this.dol().getPbData() != null && VideoPbFragment.this.lHk != null && postData4.boP() != null && postData4.dPh() != 1) {
                                    if (VideoPbFragment.this.lQz != null) {
                                        VideoPbFragment.this.lQz.doS();
                                    }
                                    if ((VideoPbFragment.this.lHR || com.baidu.tbadk.a.d.bkh()) && postData4.dPe() != null && postData4.dPe().size() != 0) {
                                        if (com.baidu.tbadk.a.d.bki()) {
                                            VideoPbFragment.this.a(postData4, (PostData) null, false, false);
                                            return;
                                        } else {
                                            VideoPbFragment.this.a(postData4, (PostData) null, true, false);
                                            return;
                                        }
                                    }
                                    p pVar2 = new p();
                                    pVar2.a(VideoPbFragment.this.dol().getPbData().getForum());
                                    pVar2.setThreadData(VideoPbFragment.this.dol().getPbData().dmU());
                                    pVar2.g(postData4);
                                    VideoPbFragment.this.lHk.d(pVar2);
                                    VideoPbFragment.this.lHk.setPostId(postData4.getId());
                                    VideoPbFragment.this.a(view, postData4.boP().getUserId(), "", postData4);
                                    if (VideoPbFragment.this.lIi != null) {
                                        VideoPbFragment.this.vw(VideoPbFragment.this.lIi.bDb());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.maF != null && VideoPbFragment.this.dol() != null) {
                        if (com.baidu.tbadk.a.d.bkt() || VideoPbFragment.this.dvV() != null) {
                            if (!com.baidu.tbadk.a.d.bkt() || VideoPbFragment.this.dvX() != null) {
                                VideoPbFragment.this.maF.dsS();
                                if (VideoPbFragment.this.He(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.dol() != null) {
                                    VideoPbFragment.this.dpu();
                                    if (VideoPbFragment.this.dol().getPbData() != null && VideoPbFragment.this.dol().getPbData().dmU() != null && VideoPbFragment.this.dol().getPbData().dmU().boP() != null) {
                                        TiebaStatic.log(new ar("c13402").dY("tid", VideoPbFragment.this.dol().dqk()).dY("fid", VideoPbFragment.this.dol().getPbData().getForumId()).al("obj_locate", 3).dY("uid", VideoPbFragment.this.dol().getPbData().dmU().boP().getUserId()));
                                    }
                                    if (VideoPbFragment.this.dol().getPbData().dmU() != null && VideoPbFragment.this.dol().getPbData().dmU().boP() != null && VideoPbFragment.this.dol().getPbData().dmU().boP().getUserId() != null && VideoPbFragment.this.lHU != null) {
                                        int h = VideoPbFragment.this.maF.h(VideoPbFragment.this.dol().getPbData());
                                        by dmU = VideoPbFragment.this.dol().getPbData().dmU();
                                        if (!dmU.bnx()) {
                                            if (dmU.bny()) {
                                                i = 3;
                                            } else if (dmU.bqM()) {
                                                i = 4;
                                            } else {
                                                i = dmU.bqN() ? 5 : 1;
                                            }
                                        }
                                        TiebaStatic.log(new ar("c12526").dY("tid", VideoPbFragment.this.dol().dqk()).al("obj_locate", 1).dY("obj_id", VideoPbFragment.this.dol().getPbData().dmU().boP().getUserId()).al("obj_type", VideoPbFragment.this.lHU.bkY() ? 0 : 1).al("obj_source", h).al("obj_param1", i));
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.vY(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.dol() != null && VideoPbFragment.this.maF != null && VideoPbFragment.this.eRw != null && VideoPbFragment.this.dol().getPbData() != null && VideoPbFragment.this.dol().getPbData().dmU() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.dol().getPbData();
                        if (pbData.dmU().boG() != 0) {
                            int currentItem = VideoPbFragment.this.eRw.getCurrentItem();
                            if (!com.baidu.tbadk.a.d.bkt() && currentItem == VideoPbFragment.mah) {
                                VideoPbFragment.this.eRw.setCurrentItem(VideoPbFragment.mai);
                            } else if (com.baidu.tbadk.a.d.bkt() || currentItem == VideoPbFragment.mai) {
                                if (!com.baidu.tbadk.a.d.bkt() && VideoPbFragment.this.dvV() == null) {
                                    return;
                                }
                                if ((!com.baidu.tbadk.a.d.bkt() || VideoPbFragment.this.dvX() != null) && VideoPbFragment.this.cFx() != null) {
                                    ar dY = new ar("c13403").dY("tid", VideoPbFragment.this.dol().dqk()).dY("fid", VideoPbFragment.this.dol().getPbData().getForumId()).dY("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView cFx = VideoPbFragment.this.cFx();
                                    if (cFx != null) {
                                        boolean canScrollVertically = cFx.canScrollVertically(1);
                                        boolean canScrollVertically2 = cFx.canScrollVertically(-1);
                                        if (VideoPbFragment.this.Zj != null) {
                                            VideoPbFragment.this.Zj.setExpanded(false, true);
                                        }
                                        if (cFx.getLayoutManager() != null && (cFx.getLayoutManager() instanceof LinearLayoutManager)) {
                                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) cFx.getLayoutManager();
                                            if (!canScrollVertically2 && canScrollVertically) {
                                                if (VideoPbFragment.this.lHM != -1 || VideoPbFragment.this.lHN != Integer.MIN_VALUE) {
                                                    if (VideoPbFragment.this.lHM > 3 || (VideoPbFragment.this.lHM == 3 && VideoPbFragment.this.lHN < (-equipmentHeight))) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lHM, VideoPbFragment.this.lHN + equipmentHeight);
                                                        cFx.smoothScrollBy(0, equipmentHeight);
                                                    } else if (VideoPbFragment.this.lHM >= 2) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lHM, VideoPbFragment.this.lHN + (equipmentHeight / 2));
                                                        cFx.smoothScrollBy(0, equipmentHeight / 2);
                                                    } else if (VideoPbFragment.this.lHM == 1) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lHM, VideoPbFragment.this.lHN + (equipmentHeight / 4));
                                                        cFx.smoothScrollBy(0, equipmentHeight / 4);
                                                    } else {
                                                        cFx.smoothScrollBy(0, -VideoPbFragment.this.lHN);
                                                    }
                                                    dY.al("obj_locate", 2);
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                int firstVisiblePosition = cFx.getFirstVisiblePosition();
                                                View childAt = cFx.getChildAt(0);
                                                int top = childAt == null ? 0 : childAt.getTop();
                                                VideoPbFragment.this.lHM = firstVisiblePosition;
                                                VideoPbFragment.this.lHN = top;
                                                if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top < (-equipmentHeight) && cFx.getCount() >= 6)) {
                                                    linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                    cFx.smoothScrollToPosition(0);
                                                } else {
                                                    cFx.smoothScrollToPosition(0);
                                                }
                                                dY.al("obj_locate", 1);
                                            }
                                            TiebaStatic.log(dY);
                                            com.baidu.tbadk.pageExtra.c bM = com.baidu.tbadk.pageExtra.d.bM(view);
                                            ar arVar5 = new ar("c12942");
                                            arVar5.al("obj_type", 1);
                                            arVar5.al("obj_locate", 4);
                                            arVar5.dY("tid", VideoPbFragment.this.dol().dqk());
                                            arVar5.dY("nid", pbData.dmU().getNid());
                                            if (bM != null) {
                                                arVar5.dY("obj_cur_page", bM.getCurrentPageKey());
                                            }
                                            if (com.baidu.tbadk.pageExtra.d.bET() != null) {
                                                arVar5.dY("obj_pre_page", com.baidu.tbadk.pageExtra.d.bET());
                                            }
                                            TiebaStatic.log(arVar5);
                                        } else {
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (VideoPbFragment.this.dol() != null && VideoPbFragment.this.dol().getPbData() != null && VideoPbFragment.this.dol().getPbData().dmU() != null && VideoPbFragment.this.dol().getPbData().dmU().boP() != null) {
                                TiebaStatic.log(new ar("c13402").dY("tid", VideoPbFragment.this.dol().dqk()).dY("fid", VideoPbFragment.this.dol().getPbData().getForumId()).al("obj_locate", 2).dY("uid", VideoPbFragment.this.dol().getPbData().dmU().boP().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.vZ(false);
                        VideoPbFragment.this.dpi();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.lIv >= 0) {
                        if (VideoPbFragment.this.dol() != null) {
                            VideoPbFragment.this.dol().dqW();
                        }
                        if (com.baidu.tbadk.a.d.bkt() && VideoPbFragment.this.dvX() != null && VideoPbFragment.this.dvX().dwE() != null) {
                            VideoPbFragment.this.dvX().dwE().setData(VideoPbFragment.this.dol().getPbData());
                        } else if (VideoPbFragment.this.dol() != null && VideoPbFragment.this.dvV() != null && VideoPbFragment.this.dvV().dwE() != null) {
                            VideoPbFragment.this.dvV().dwE().setData(VideoPbFragment.this.dol().getPbData());
                        }
                        VideoPbFragment.this.lIv = 0;
                        VideoPbFragment.this.maH = Integer.MIN_VALUE;
                        if (com.baidu.tbadk.a.d.bkt() && VideoPbFragment.this.dol() != null && VideoPbFragment.this.dvX() != null) {
                            VideoPbFragment.this.dvX().dj(VideoPbFragment.this.dol().dqZ(), VideoPbFragment.this.dol().dra());
                            VideoPbFragment.this.dol().dg(0, 0);
                        } else if (VideoPbFragment.this.dol() != null && VideoPbFragment.this.dvV() != null) {
                            VideoPbFragment.this.dvV().dj(VideoPbFragment.this.dol().dqZ(), VideoPbFragment.this.dol().dra());
                            VideoPbFragment.this.dol().dg(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.dol() != null) {
                        ar arVar6 = new ar("c13398");
                        arVar6.dY("tid", VideoPbFragment.this.dol().dqk());
                        arVar6.dY("fid", VideoPbFragment.this.dol().getForumId());
                        arVar6.dY("uid", TbadkCoreApplication.getCurrentAccount());
                        arVar6.al("obj_locate", 2);
                        TiebaStatic.log(arVar6);
                    }
                } else if (view.getId() == R.id.pb_item_tail_content) {
                    if (bh.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                        String string2 = com.baidu.tbadk.core.sharedPref.b.bsO().getString("tail_link", "");
                        if (!StringUtils.isNull(string2)) {
                            TiebaStatic.log("c10056");
                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                        }
                        VideoPbFragment.this.dsc();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.dsc();
                } else if (VideoPbFragment.this.maF.dtZ() != null && view == VideoPbFragment.this.maF.dtZ().drC()) {
                    VideoPbFragment.this.maF.dsS();
                    if (VideoPbFragment.this.dol() != null) {
                        VideoPbFragment.this.ikq.setThreadId(VideoPbFragment.this.dol().dqk());
                    }
                    if (VideoPbFragment.this.dol() == null || !VideoPbFragment.this.dol().isPrivacy()) {
                        VideoPbFragment.this.ikq.crD();
                        if (!TbSingleton.getInstance().mCanCallFans && VideoPbFragment.this.dol() != null && VideoPbFragment.this.dol().getPbData() != null && VideoPbFragment.this.dol().getPbData().getThreadId() != null && VideoPbFragment.this.dol().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                            i3 = 2;
                        }
                        if (VideoPbFragment.this.dol() != null && VideoPbFragment.this.dol().getPbData() != null) {
                            VideoPbFragment.this.ikq.l(3, i3, VideoPbFragment.this.dol().getPbData().getThreadId());
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                    if (VideoPbFragment.this.dol().getPbData() != null) {
                        VideoPbFragment.this.ikq.l(3, 3, VideoPbFragment.this.dol().getPbData().getThreadId());
                    }
                } else if (view.getId() == R.id.pb_floor_right_top_feedback || view.getId() == R.id.pb_post_op_more) {
                    ar arVar7 = new ar("c13398");
                    arVar7.dY("tid", VideoPbFragment.this.dol().dqk());
                    arVar7.dY("fid", VideoPbFragment.this.dol().getForumId());
                    arVar7.dY("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar7.al("obj_locate", 7);
                    TiebaStatic.log(arVar7);
                    VideoPbFragment.this.maF.wg(false);
                    VideoPbFragment.this.maF.dvM().onLongClick(view);
                }
            }
        }
    };
    private View.OnClickListener lEF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.maF != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.maF.c(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.maF.dD(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.maF.c(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.maF.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    private CustomMessageListener jhd = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(VideoPbFragment.this.getPageContext(), VideoPbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.40
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            VideoPbFragment.this.maF.wg(true);
            return VideoPbFragment.this.maF.dvM().onLongClick(view);
        }
    };
    public SortSwitchButton.a lIU = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean Az(int i) {
            if (VideoPbFragment.this.maF != null) {
                VideoPbFragment.this.maF.dsS();
            }
            if (!j.isNetWorkAvailable()) {
                VideoPbFragment.this.showToast(R.string.network_not_available);
                return false;
            } else if (VideoPbFragment.this.dol() == null || VideoPbFragment.this.dol().isLoading) {
                return false;
            } else {
                VideoPbFragment.this.cCF();
                VideoPbFragment.this.dsz();
                if (VideoPbFragment.this.dol().getPbData() != null && VideoPbFragment.this.dol().getPbData().lAL != null && VideoPbFragment.this.dol().getPbData().lAL.size() > i) {
                    int intValue = VideoPbFragment.this.dol().getPbData().lAL.get(i).sort_type.intValue();
                    TiebaStatic.log(new ar("c13699").dY("tid", VideoPbFragment.this.dol().dql()).dY("fid", VideoPbFragment.this.dol().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).al("obj_type", Hh(intValue)));
                    if (VideoPbFragment.this.dol().Ho(intValue)) {
                        VideoPbFragment.this.mIsLoading = true;
                    }
                }
                return true;
            }
        }

        private int Hh(int i) {
            if (i == 2) {
                return 1;
            }
            if (i == 0) {
                return 2;
            }
            if (i == 1) {
                return 3;
            }
            return 0;
        }
    };
    private a maG = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void dps() {
        if (dol() != null && dol().getPbData() != null && dol().getPbData().dmU() != null) {
            by dmU = dol().getPbData().dmU();
            dmU.mRecomAbTag = dol().drg();
            dmU.mRecomWeight = dol().dre();
            dmU.mRecomSource = dol().drf();
            dmU.mRecomExtra = dol().drh();
            dmU.eMG = dol().dqs();
            if (dmU.getFid() == 0) {
                dmU.setFid(com.baidu.adp.lib.f.b.toLong(dol().getForumId(), 0L));
            }
            ar a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dmU, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uN(boolean z) {
        if (dol() != null && dol().getPbData() != null && dol().getPbData().dmU() != null) {
            by dmU = dol().getPbData().dmU();
            dmU.mRecomAbTag = dol().drg();
            dmU.mRecomWeight = dol().dre();
            dmU.mRecomSource = dol().drf();
            dmU.mRecomExtra = dol().drh();
            if (dmU.getFid() == 0) {
                dmU.setFid(com.baidu.adp.lib.f.b.toLong(dol().getForumId(), 0L));
            }
            ar a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dmU, "c13563");
            TbPageTag fa = com.baidu.tbadk.pageInfo.c.fa(getContext());
            if (a2 != null && fa != null && PageStayDurationConstants.PageName.VIDEO_LIST.equals(fa.locatePage)) {
                a2.dY("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dY("obj_pre_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            if (a2 != null) {
                a2.al("reply_type", 1);
                if (z) {
                    a2.al("obj_type", 2);
                } else {
                    a2.al("obj_type", 1);
                }
                com.baidu.tbadk.pageExtra.c eX = com.baidu.tbadk.pageExtra.d.eX(getContext());
                if (eX != null) {
                    a2.dY("obj_cur_page", eX.getCurrentPageKey());
                }
                if (com.baidu.tbadk.pageExtra.d.bET() != null) {
                    a2.dY("obj_pre_page", com.baidu.tbadk.pageExtra.d.bET());
                }
                TiebaStatic.log(a2);
            }
        }
    }

    public void a(int i, boolean z, String str, boolean z2) {
        hideProgressBar();
        if (z && z2) {
            showToast(getPageContext().getString(R.string.success));
        } else if (z2) {
            if (au.isEmpty(str)) {
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
            String string = !TextUtils.isEmpty(bVar.noK) ? bVar.noK : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.Bq(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.15
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.jl(true);
                aVar.b(getPageContext());
                aVar.brv();
            } else {
                a(0, bVar.mSuccess, bVar.noK, z);
            }
            if (bVar.mSuccess) {
                if (bVar.izQ == 1) {
                    ArrayList<PostData> dmW = dol().getPbData().dmW();
                    int size = dmW.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(dmW.get(i).getId())) {
                            i++;
                        } else {
                            dmW.remove(i);
                            break;
                        }
                    }
                    dol().getPbData().dmU().oD(dol().getPbData().dmU().boG() - 1);
                    if (com.baidu.tbadk.a.d.bkt() && dvX() != null) {
                        dvX().dwG();
                    } else if (dvV() != null) {
                        dvV().dwG();
                    }
                } else if (bVar.izQ == 0) {
                    dpt();
                } else if (bVar.izQ == 2) {
                    ArrayList<PostData> dmW2 = dol().getPbData().dmW();
                    int size2 = dmW2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= dmW2.get(i2).dPe().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(dmW2.get(i2).dPe().get(i3).getId())) {
                                i3++;
                            } else {
                                dmW2.get(i2).dPe().remove(i3);
                                dmW2.get(i2).dPg();
                                z2 = true;
                                break;
                            }
                        }
                        dmW2.get(i2).TG(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        if (com.baidu.tbadk.a.d.bkt() && dvX() != null) {
                            dvX().dwG();
                        } else if (dvV() != null) {
                            dvV().dwG();
                        }
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = dol().getPbData().dni().lCs;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dPe().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dPe().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dPe().remove(i2);
                    list.get(i).dPg();
                    z = true;
                    break;
                }
            }
            list.get(i).TG(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            if (com.baidu.tbadk.a.d.bkt() && dvX() != null) {
                dvX().dwG();
            } else if (dvV() != null) {
                dvV().dwG();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null && dol() != null && dol().getPbData() != null && dol().getPbData().dmU() != null) {
            a(this.fXd.getLoadDataMode(), gVar.mSuccess, gVar.noK, false);
            if (gVar.mSuccess) {
                this.lHX = true;
                if (i == 2 || i == 3) {
                    this.lHY = true;
                    this.lHZ = false;
                } else if (i == 4 || i == 5) {
                    this.lHY = false;
                    this.lHZ = true;
                }
                if (i == 2) {
                    dol().getPbData().dmU().oG(1);
                    dol().setIsGood(1);
                } else if (i == 3) {
                    dol().getPbData().dmU().oG(0);
                    dol().setIsGood(0);
                } else if (i == 4) {
                    dol().getPbData().dmU().oF(1);
                    dol().Hi(1);
                } else if (i == 5) {
                    dol().getPbData().dmU().oF(0);
                    dol().Hi(0);
                }
            }
            if (dol().getPbData().dmU() != null && dvW() != null) {
                dvW().dwQ();
            }
        }
    }

    private void dpt() {
        if (dol().dqn() || dol().dqp()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", dol().dqk());
            PbActivity pbActivity = this.lHp;
            PbActivity pbActivity2 = this.lHp;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, dol().dqk()));
        if (dpw()) {
            this.lHp.finish();
        }
    }

    private boolean dpw() {
        if (dol() == null) {
            return true;
        }
        if (dol().getPbData() == null || !dol().getPbData().dny()) {
            if (dol().bkY()) {
                final MarkData dqF = dol().dqF();
                if (dqF == null || !dol().getIsFromMark() || cFx() == null) {
                    return true;
                }
                final MarkData Hp = dol().Hp(cFx().getFirstVisiblePosition());
                if (Hp == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", dqF);
                    this.lHp.setResult(-1, intent);
                    return true;
                } else if (Hp.getPostId() == null || Hp.getPostId().equals(dqF.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", dqF);
                    this.lHp.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.Bq(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.lHU != null) {
                                if (VideoPbFragment.this.lHU.bkY()) {
                                    VideoPbFragment.this.lHU.bkZ();
                                    VideoPbFragment.this.lHU.iH(false);
                                }
                                VideoPbFragment.this.lHU.a(Hp);
                                VideoPbFragment.this.lHU.iH(true);
                                VideoPbFragment.this.lHU.bla();
                            }
                            dqF.setPostId(Hp.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dqF);
                            VideoPbFragment.this.lHp.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.doy();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dqF);
                            VideoPbFragment.this.lHp.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.doy();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.19
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.b(getBaseFragmentActivity().getPageContext());
                    aVar.brv();
                    return false;
                }
            } else if (dol().getPbData() == null || dol().getPbData().dmW() == null || dol().getPbData().dmW().size() <= 0 || !dol().getIsFromMark()) {
                return true;
            } else {
                this.lHp.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doy() {
        this.lHp.doy();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void vY(boolean z) {
        com.baidu.tieba.pb.data.f pbData;
        int i;
        if (dol() != null && this.maF != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = dol().getPbData()) != null) {
                by dmU = pbData.dmU();
                if (dmU != null && dmU.boP() != null) {
                    TiebaStatic.log(new ar("c13402").dY("tid", dol().dqk()).dY("fid", pbData.getForumId()).al("obj_locate", 4).dY("uid", dmU.boP().getUserId()));
                }
                if (dmU != null) {
                    if (dmU.bnx()) {
                        i = 2;
                    } else if (dmU.bny()) {
                        i = 3;
                    } else if (dmU.bqM()) {
                        i = 4;
                    } else if (dmU.bqN()) {
                        i = 5;
                    }
                    ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    arVar.dY("tid", dol().dqk());
                    arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.dY("fid", dol().getForumId());
                    if (!z) {
                        arVar.al("obj_locate", 6);
                    } else {
                        arVar.al("obj_locate", 5);
                    }
                    arVar.al("obj_name", i);
                    arVar.al("obj_type", 2);
                    if (dmU != null) {
                        if (dmU.bnx()) {
                            arVar.al("obj_type", 10);
                        } else if (dmU.bny()) {
                            arVar.al("obj_type", 9);
                        } else if (dmU.bqN()) {
                            arVar.al("obj_type", 8);
                        } else if (dmU.bqM()) {
                            arVar.al("obj_type", 7);
                        } else if (dmU.isShareThread) {
                            arVar.al("obj_type", 6);
                        } else if (dmU.threadType == 0) {
                            arVar.al("obj_type", 1);
                        } else if (dmU.threadType == 40) {
                            arVar.al("obj_type", 2);
                        } else if (dmU.threadType == 49) {
                            arVar.al("obj_type", 3);
                        } else if (dmU.threadType == 54) {
                            arVar.al("obj_type", 4);
                        } else {
                            arVar.al("obj_type", 5);
                        }
                        arVar.dY("nid", dmU.getNid());
                        arVar.al(IntentConfig.CARD_TYPE, dmU.bqQ());
                        arVar.dY(IntentConfig.RECOM_SOURCE, dmU.mRecomSource);
                        arVar.dY("ab_tag", dmU.mRecomAbTag);
                        arVar.dY("weight", dmU.mRecomWeight);
                        arVar.dY("extra", dmU.mRecomExtra);
                        arVar.dY("nid", dmU.getNid());
                        if (dmU.getBaijiahaoData() != null && !au.isEmpty(dmU.getBaijiahaoData().oriUgcVid)) {
                            arVar.dY("obj_param6", dmU.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        arVar.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    if (dpR() != null) {
                        com.baidu.tbadk.pageInfo.c.b(dpR(), arVar);
                    }
                    TiebaStatic.log(arVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (dol().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> dmW = pbData.dmW();
                        if ((dmW == null || dmW.size() <= 0) && dol().dqm()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.maF.dsS();
                        cCF();
                        TiebaStatic.log(new ar("c11939"));
                        if (!AntiHelper.d(getContext(), dmU)) {
                            if (this.lPX != null) {
                                this.lPX.setEnable(false);
                                x(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                Hf(z ? 2 : 1);
                                return;
                            }
                            this.maF.showLoadingDialog();
                            dol().dqQ().A(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                ar arVar2 = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                arVar2.dY("tid", dol().dqk());
                arVar2.dY("uid", TbadkCoreApplication.getCurrentAccount());
                arVar2.dY("fid", dol().getForumId());
                if (!z) {
                }
                arVar2.al("obj_name", i);
                arVar2.al("obj_type", 2);
                if (dmU != null) {
                }
                if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                if (dpR() != null) {
                }
                TiebaStatic.log(arVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment dvC() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        e eVar = (e) y.b(getActivity()).l(e.class);
        M(eVar.dwi());
        N(eVar.dwi());
        if (dol() != null && dol().getPbData() != null) {
            boolean isFromMark = dol().getIsFromMark();
            com.baidu.tieba.pb.data.f pbData = dol().getPbData();
            if (isFromMark) {
                PostData L = L(pbData);
                if (pbData.bkX() != null && !pbData.bkX().equals(L.getId()) && this.eRw != null) {
                    if (com.baidu.tbadk.a.d.bkt()) {
                        this.eRw.setCurrentItem(maj);
                    } else {
                        this.eRw.setCurrentItem(mai);
                    }
                }
            }
        }
        eVar.dwj().observe(this, new q<by>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aQ */
            public void onChanged(@Nullable by byVar) {
                BdTypeRecyclerView cFx;
                if (byVar != null && byVar.bph() != null) {
                    if (VideoPbFragment.this.mar.getVideoUrl() == null || !VideoPbFragment.this.mar.getVideoUrl().equals(byVar.bph().video_url)) {
                        if (!au.isEmpty(VideoPbFragment.this.mar.getVideoUrl())) {
                            VideoPbFragment.this.lHD = true;
                            if (com.baidu.tbadk.a.d.bkt()) {
                                VideoPbFragment.this.eRw.setCurrentItem(VideoPbFragment.maj);
                            } else {
                                VideoPbFragment.this.eRw.setCurrentItem(VideoPbFragment.mah);
                            }
                            if (com.baidu.tbadk.a.d.bkt() && (cFx = VideoPbFragment.this.cFx()) != null) {
                                cFx.scrollToPosition(0);
                            }
                        }
                        if (VideoPbFragment.this.mas == null || !VideoPbFragment.this.mas.isPlaying()) {
                            VideoPbFragment.this.dvD();
                            VideoPbFragment.this.aP(byVar);
                        }
                        VideoPbFragment.this.dvE();
                        if (VideoPbFragment.this.mas.dww()) {
                            VideoPbFragment.this.mas.start();
                        }
                        boolean z = !au.equals(VideoPbFragment.this.mar.getVideoUrl(), byVar.bph().video_url);
                        VideoPbFragment.this.mar.setData(byVar);
                        if (com.baidu.tbadk.a.d.bkt()) {
                            VideoPbFragment.this.mar.wi(false);
                        } else {
                            VideoPbFragment.this.mar.wi(VideoPbFragment.this.eRw.getCurrentItem() == 0);
                        }
                        if (z) {
                            VideoPbFragment.this.mar.startPlay();
                            VideoPbFragment.this.mar.dxh();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.mar.setData(byVar);
                }
            }
        });
        eVar.dws().observe(this, new q<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: s */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.eRw.setCurrentItem(num.intValue());
            }
        });
        eVar.dwn().observe(this, new q<by>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aQ */
            public void onChanged(@Nullable by byVar) {
                VideoPbFragment.this.mar.aU(byVar);
            }
        });
        eVar.dwo().observe(this, new q<by>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aQ */
            public void onChanged(@Nullable by byVar) {
                VideoPbFragment.this.mar.aV(byVar);
            }
        });
        eVar.dwp().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: r */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.dvO();
            }
        });
        eVar.dwq().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: r */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvD() {
        ViewGroup.LayoutParams layoutParams = this.mau.getLayoutParams();
        layoutParams.height = 0;
        this.mau.setLayoutParams(layoutParams);
        this.mau.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvE() {
        if (this.mas == null) {
            this.mas = new f(getBaseFragmentActivity(), this.maq);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(dpR()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.maq.getOriginHeight() + statusBarHeight);
            final e eVar = (e) y.b(getActivity()).l(e.class);
            this.mas.b(eVar.dwk(), rect);
            if (this.mas.dww()) {
                this.mas.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (com.baidu.tbadk.a.d.bkt()) {
                            if (eVar.dwl() || VideoPbFragment.this.dol().drj() == VideoPbFragment.maj) {
                                VideoPbFragment.this.eRw.setCurrentItem(VideoPbFragment.maj);
                            }
                        } else if (eVar.dwl() || VideoPbFragment.this.dol().drj() == VideoPbFragment.mai) {
                            VideoPbFragment.this.eRw.setCurrentItem(VideoPbFragment.mai);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (com.baidu.tbadk.a.d.bkt()) {
                            if (eVar.dwl() || VideoPbFragment.this.dol().drj() == VideoPbFragment.maj) {
                                VideoPbFragment.this.eRw.setCurrentItem(VideoPbFragment.maj);
                            }
                        } else if (eVar.dwl() || VideoPbFragment.this.dol().drj() == VideoPbFragment.mai) {
                            VideoPbFragment.this.eRw.setCurrentItem(VideoPbFragment.mai);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (com.baidu.tbadk.a.d.bkt()) {
                if (eVar.dwl() || dol().drj() == maj) {
                    this.eRw.setCurrentItem(maj);
                }
            } else if (eVar.dwl() || dol().drj() == mai) {
                this.eRw.setCurrentItem(mai);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.maL && (this.maM || dwc())) {
            dwb();
            UtilHelper.hideStatusBar(dpR(), dpR().getRootView());
            this.maM = false;
            if (this.mar != null) {
                this.mar.wa(false);
            }
        }
        if (i == 4) {
            return this.mar.dCu();
        }
        if (i == 24) {
            return this.mar.dxe();
        }
        if (i == 25) {
            return this.mar.dxf();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aP(by byVar) {
        double d;
        int i;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        Rect dri;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        double equipmentHeight = (2.0d * equipmentWidth) / l.getEquipmentHeight(getContext());
        if (byVar != null && byVar.bph() != null) {
            int intValue = byVar.bph().video_width.intValue();
            int intValue2 = byVar.bph().video_height.intValue();
            if (intValue2 > 0) {
                d = (intValue * 1.0f) / intValue2;
                if (d > 1.7777777777777777d) {
                    d = 1.7777777777777777d;
                }
                if (d >= equipmentHeight) {
                    equipmentHeight = d;
                }
                int ceil = (int) Math.ceil(equipmentWidth / equipmentHeight);
                int height = (dol() != null || (dri = dol().dri()) == null) ? ceil : dri.height();
                i = 0;
                layoutParams = this.maq.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.maq.setLayoutParams(layoutParams);
                this.maq.setMaxHeight(ceil);
                this.maq.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.maq.setOriginHeight(height);
                if (!com.baidu.tbadk.a.d.bkt()) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mal.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new RelativeLayout.LayoutParams(-1, mak);
                    } else {
                        layoutParams3.height = mak;
                    }
                    this.mal.setLayoutParams(layoutParams3);
                }
                layoutParams2 = (CoordinatorLayout.LayoutParams) this.Zj.getLayoutParams();
                if (!com.baidu.tbadk.a.d.bkt()) {
                    ceil += mak;
                }
                if (layoutParams2 != null) {
                    layoutParams2 = new CoordinatorLayout.LayoutParams(-1, ceil);
                } else {
                    layoutParams2.height = ceil;
                }
                this.Zj.setLayoutParams(layoutParams2);
                if (i == 0 && (this.Zj.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.Zj.getLayoutParams()).getBehavior();
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
        if (dol() != null) {
        }
        i = 0;
        layoutParams = this.maq.getLayoutParams();
        if (layoutParams != null) {
        }
        this.maq.setLayoutParams(layoutParams);
        this.maq.setMaxHeight(ceil2);
        this.maq.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.maq.setOriginHeight(height);
        if (!com.baidu.tbadk.a.d.bkt()) {
        }
        layoutParams2 = (CoordinatorLayout.LayoutParams) this.Zj.getLayoutParams();
        if (!com.baidu.tbadk.a.d.bkt()) {
        }
        if (layoutParams2 != null) {
        }
        this.Zj.setLayoutParams(layoutParams2);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.lHx = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        at(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.lIp = new com.baidu.tbadk.core.view.c();
        this.lIp.toastTime = 1000L;
        if (this.maF != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.maF.lIq;
            userMuteAddAndDelCustomMessage.setTag(this.maF.lIq);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.maF.lIq;
            userMuteCheckCustomMessage.setTag(this.maF.lIq);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        this.ikq = new com.baidu.tieba.callfans.a(getPageContext());
        com.baidu.tieba.t.c.dOf().z(getUniqueId());
    }

    private void initData() {
        this.lHU = com.baidu.tbadk.baseEditMark.a.a(this.lHp);
        if (this.lHU != null) {
            this.lHU.a(this.lJa);
        }
        this.fXd = new ForumManageModel(this.lHp);
        this.fXd.setLoadDataCallBack(this.ikv);
        this.eTC = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.maF = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void at(Bundle bundle) {
        this.lIh = new g();
        d(this.lIh);
        this.lIi = (com.baidu.tbadk.editortools.pb.e) this.lIh.eN(getActivity());
        this.lIi.a(this.lHp.getPageContext());
        this.lIi.a(this.fwI);
        this.lIi.a(this.fwB);
        this.lIi.setFrom(1);
        this.lIi.a(this.lHp.getPageContext(), bundle);
        this.lIi.bCn().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.lIi.bCn().ks(true);
        uM(true);
        this.lIi.a(dol().dqB(), dol().dqk(), dol().dqS());
        registerListener(this.lIF);
        registerListener(this.lIZ);
        registerListener(this.lIE);
        registerListener(this.lIC);
        registerListener(this.iUy);
        if (!dol().dqs()) {
            this.lIi.DV(dol().dqk());
        }
        if (dol().dqT()) {
            this.lIi.DT(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.lIi.DT(dse());
        }
        this.kNm = new bb();
        if (this.lIi.bCT() != null) {
            this.kNm.e(this.lIi.bCT().getInputView());
        }
        this.lIi.a(this.fwC);
        this.kJE = new am(getPageContext());
        this.kJE.a(new am.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // com.baidu.tbadk.core.util.am.a
            public void r(boolean z, int i) {
                if (z) {
                    if (i == am.eTx) {
                        VideoPbFragment.this.lIi.a((String) null, (WriteData) null);
                    } else if (i == am.eTy && VideoPbFragment.this.lQz != null && VideoPbFragment.this.lQz.doW() != null) {
                        VideoPbFragment.this.lQz.doW().bDr();
                    } else if (i == am.eTz) {
                        VideoPbFragment.this.c(VideoPbFragment.this.lIl);
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
        this.iXQ = new com.baidu.tieba.g.b(getActivity());
        this.iXQ.a(lJi);
        this.maL = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        bFP();
        this.Zj = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.man = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.maq = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.mar = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.maq);
        this.mar.setStageType("2002");
        this.mar.setUniqueId(getUniqueId());
        this.mar.af(this);
        this.mar.dL(dpR().getRootView());
        this.mar.dM(this.mat);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.mal = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.mau = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.eRw = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.mao = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.mao.setOnClickListener(this.aGQ);
        dvG();
        dvF();
        dvH();
        this.mam = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.eRw.setAdapter(this.mam);
        this.mal.setViewPager(this.eRw);
        this.mal.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (com.baidu.tbadk.a.d.bkt() && VideoPbFragment.this.dvX() != null) {
                        VideoPbFragment.this.dvX().wh(false);
                    } else if (VideoPbFragment.this.dvV() != null) {
                        VideoPbFragment.this.dvV().wh(false);
                    }
                    if (VideoPbFragment.this.dvW() != null) {
                        VideoPbFragment.this.dvW().wh(true);
                        VideoPbFragment.this.HP(VideoPbFragment.this.dvW().dwK() != 0 ? 0 : 8);
                    }
                    e eVar = (e) y.b(VideoPbFragment.this.getActivity()).l(e.class);
                    if (eVar.dwp() != null && eVar.dwp().getValue() != null && eVar.dwp().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.mar.wi(z);
                    VideoPbFragment.this.dsc();
                    if (VideoPbFragment.this.dol() != null && VideoPbFragment.this.dol().getPbData() != null) {
                        TiebaStatic.log(new ar("c13592").dY("tid", VideoPbFragment.this.dol().dqk()).dY("fid", VideoPbFragment.this.dol().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.dvW() != null) {
                        VideoPbFragment.this.dvW().wh(false);
                    }
                    if (com.baidu.tbadk.a.d.bkt() && VideoPbFragment.this.dvX() != null) {
                        VideoPbFragment.this.dvX().wh(true);
                        int dwK = VideoPbFragment.this.dvX().dwK();
                        int dwL = VideoPbFragment.this.dvX().dwL();
                        if (dwK != 0) {
                            VideoPbFragment.this.HP(8);
                            VideoPbFragment.this.dvX().HP(0);
                        } else if (dwL != 0) {
                            VideoPbFragment.this.dvX().HP(8);
                            VideoPbFragment.this.HP(0);
                        } else {
                            VideoPbFragment.this.dvX().HP(8);
                            VideoPbFragment.this.HP(8);
                        }
                    } else if (VideoPbFragment.this.dvV() != null) {
                        VideoPbFragment.this.dvV().wh(true);
                        int dwK2 = VideoPbFragment.this.dvV().dwK();
                        int dwL2 = VideoPbFragment.this.dvV().dwL();
                        if (dwK2 != 0) {
                            VideoPbFragment.this.HP(8);
                            VideoPbFragment.this.dvV().HP(0);
                        } else if (dwL2 != 0) {
                            VideoPbFragment.this.dvV().HP(8);
                            VideoPbFragment.this.HP(0);
                        } else {
                            VideoPbFragment.this.dvV().HP(8);
                            VideoPbFragment.this.HP(8);
                        }
                    }
                    VideoPbFragment.this.mar.wi(false);
                    VideoPbFragment.this.Zj.setExpanded(false, true);
                    if (VideoPbFragment.this.dol() != null && VideoPbFragment.this.dol().getPbData() != null) {
                        TiebaStatic.log(new ar("c13593").dY("tid", VideoPbFragment.this.dol().dqk()).dY("fid", VideoPbFragment.this.dol().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.mam.HR(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.lPz = this.rootView.findViewById(R.id.viewstub_progress);
        dvI();
        bWV();
        if (!this.maL && this.maM) {
            dwb();
            UtilHelper.hideStatusBar(dpR(), dpR().getRootView());
            this.maM = false;
        }
        if (com.baidu.tbadk.a.d.bkt()) {
            this.mal.getLayoutParams().height = 0;
        }
    }

    private void dvF() {
        this.maw = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.maB = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.may = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.maz = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.maA = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.maC = this.rootView.findViewById(R.id.ala_live_point);
        this.maB.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.maB.setConrers(15);
        this.maA.setConfig(new com.baidu.tbadk.core.view.commonBtn.c());
        this.maz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPbFragment.this.lBv == null || VideoPbFragment.this.lBv.dwW()) {
                    if (VideoPbFragment.this.lBv != null) {
                        TiebaStatic.log(new ar("c13608").dY("tid", VideoPbFragment.this.dol().getPbData().getThreadId()));
                        VideoPbFragment.this.lBv.mcI = true;
                    }
                } else {
                    TiebaStatic.log(new ar("c13591"));
                }
                VideoPbFragment.this.dvQ();
            }
        });
        this.maA.setOnClickListener(this.mav);
        this.mau.setOnClickListener(this.mav);
    }

    private void dvG() {
        this.mal.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.mal.setContainerLayoutParams(layoutParams);
        this.mal.setRectPaintColor(R.color.CAM_X0302);
        this.mal.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.mal.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.mal.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.mal.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.mal.setExpandedTabLayoutParams(layoutParams2);
    }

    public void vZ(boolean z) {
        if (this.Zj != null) {
            this.Zj.setExpanded(z);
        }
    }

    private void dvH() {
        this.lPQ = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.lPR = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.lQb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.lQc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.lPT = (HeadImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lPT.setVisibility(0);
        this.lPT.setIsRound(true);
        this.lPT.setBorderWidth(l.getDimens(getContext(), R.dimen.L_X01));
        this.lPT.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.lPT.setPlaceHolder(0);
        dsi();
        this.jYt = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.lPS = (LinearLayout) this.rootView.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lPS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.vZ(false);
                VideoPbFragment.this.dpi();
                if (VideoPbFragment.this.dol() != null && VideoPbFragment.this.dol().getPbData() != null && VideoPbFragment.this.dol().getPbData().dmU() != null && VideoPbFragment.this.dol().getPbData().dmU().boP() != null) {
                    TiebaStatic.log(new ar("c13701").dY("tid", VideoPbFragment.this.dol().dql()).dY("fid", VideoPbFragment.this.dol().getPbData().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new ar("c13402").dY("tid", VideoPbFragment.this.dol().dqk()).dY("fid", VideoPbFragment.this.dol().getPbData().getForumId()).al("obj_locate", 1).dY("uid", VideoPbFragment.this.dol().getPbData().dmU().boP().getUserId()));
                }
            }
        });
        this.lPU = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.lPU.setOnClickListener(this.aGQ);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.lPV = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.lPV.setOnClickListener(this.aGQ);
        if (booleanExtra) {
            this.lPV.setVisibility(8);
        } else {
            this.lPV.setVisibility(0);
        }
        this.lPW = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.lPW.setOnClickListener(this.aGQ);
        this.lPX = new com.baidu.tieba.pb.view.d(this.lPW);
        this.lPX.dxq();
        this.lPY = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.lPY.setVisibility(0);
        vy(false);
    }

    private void dsi() {
        if (this.lPT != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lPT.setImageResource(0);
            this.lPT.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            return;
        }
        this.lPT.setImageResource(R.drawable.transparent_bg);
    }

    private void bFP() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.cCG();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.mat = this.rootView.findViewById(R.id.status_bar_background);
        if (this.maL) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(dpR());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.mat.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(dpR());
            this.mat.setLayoutParams(layoutParams2);
            this.mat.setVisibility(0);
        }
        this.fEN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aGQ);
        this.gOl = (ImageView) this.fEN.findViewById(R.id.widget_navi_back_button);
        SvgManager.btW().a(this.gOl, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jjp = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.aGQ);
        this.ahT = (ImageView) this.jjp.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.jjp.setLayoutParams(layoutParams3);
        SvgManager.btW().a(this.ahT, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jjp.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.jfa);
        this.mNavigationBar.setOnTouchListener(this.maN);
    }

    public void dvI() {
        setEditorTools(this.lIi.bCn());
    }

    private void bWV() {
        this.lHk = new PbFakeFloorModel(getPageContext());
        this.lQz = new v(getPageContext(), this.lHk, this.rootView);
        this.lQz.T(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.dsc();
            }
        });
        this.lQz.a(this.lIW);
        this.lHk.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                VideoPbFragment.this.lHk.u(postData);
                if (com.baidu.tbadk.a.d.bkt() || VideoPbFragment.this.dvX() != null) {
                    VideoPbFragment.this.dvX().dwG();
                } else if (VideoPbFragment.this.dvV() != null) {
                    VideoPbFragment.this.dvV().dwG();
                }
                VideoPbFragment.this.lQz.doS();
                VideoPbFragment.this.acn.bAK();
                VideoPbFragment.this.vy(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, PostData postData2, boolean z, boolean z2) {
        PbActivity.a Qh;
        String dqk = dol().dqk();
        String id = postData.getId();
        String str = "";
        if (postData2 != null) {
            str = postData2.getId();
        }
        int i = 0;
        if (dol().getPbData() != null) {
            i = dol().getPbData().dnj();
        }
        if (dvV() != null && dvV().dwI() != null) {
            Qh = dvV().dwI().Qh(id);
        } else if (dvX() != null && dvX().dwI() != null) {
            Qh = dvX().dwI().Qh(id);
        } else {
            return;
        }
        if (postData != null && dol() != null && dol().getPbData() != null && Qh != null) {
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(dqk, id, "pb", true, null, false, str, i, postData.duZ(), dol().getPbData().getAnti(), false, postData.boP().getIconInfo()).addBigImageData(Qh.lEa, Qh.eCN, Qh.eCL, Qh.index);
            if (z2) {
                addBigImageData.setHighLightPostId(str);
                addBigImageData.setKeyIsUseSpid(true);
            }
            addBigImageData.setKeyFromForumId(dol().getForumId());
            addBigImageData.setBjhData(dol().dqu());
            addBigImageData.setKeyPageStartFrom(dol().dqV());
            addBigImageData.setFromFrsForumId(dol().getFromForumId());
            addBigImageData.setIsOpenEditor(z);
            if (dol().getPbData().dnE() != null) {
                addBigImageData.setHasForumRule(dol().getPbData().dnE().has_forum_rule.intValue());
            }
            if (dol().getPbData().getUserData() != null) {
                addBigImageData.setIsManager(dol().getPbData().getUserData().getIs_manager());
            }
            if (dol().getPbData().getForum().getDeletedReasonInfo() != null) {
                addBigImageData.setDeletedReasonInfoIsGrayCaleForum(dol().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                addBigImageData.setDeletedReasonInfoIsIsBoomGrow(dol().getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue());
            }
            if (dol().getPbData().getForum() != null) {
                addBigImageData.setForumHeadUrl(dol().getPbData().getForum().getImage_url());
                addBigImageData.setUserLevel(dol().getPbData().getForum().getUser_level());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.lHp = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (dol() != null) {
            dol().aD(bundle);
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
        this.bIA = true;
        getVoiceManager().onPause(getPageContext());
        this.mar.rJ(true);
        if (dol() != null && !dol().dqs()) {
            this.lIi.DU(dol().dqk());
        }
        com.baidu.tbadk.BdToken.c.biD().biO();
        MessageManager.getInstance().unRegisterListener(this.lIP);
        MessageManager.getInstance().unRegisterListener(this.lIQ);
        MessageManager.getInstance().unRegisterListener(this.lIR);
        MessageManager.getInstance().unRegisterListener(this.jhd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bIA = false;
        getVoiceManager().onResume(getPageContext());
        this.mar.rJ(false);
        dpN();
        registerListener(this.lIP);
        registerListener(this.lIQ);
        registerListener(this.lIR);
        registerListener(this.jhd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.mam != null && this.eRw != null) {
            this.mam.HR(z ? this.eRw.getCurrentItem() : -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        dsi();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.t.c.dOf().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.t.c.dOf().A(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.lPX != null) {
            this.lPX.onDestroy();
        }
        if (this.fXd != null) {
            this.fXd.cancelLoadData();
        }
        if (this.mar != null) {
            this.mar.onDestroy();
        }
        if (this.lHI != null) {
            this.lHI.cancelLoadData();
        }
        if (this.kJE != null) {
            this.kJE.onDestroy();
        }
        if (dol() != null) {
            dol().cancelLoadData();
            dol().destory();
            if (dol().dqP() != null) {
                dol().dqP().onDestroy();
            }
        }
        if (this.lIi != null) {
            this.lIi.onDestroy();
        }
        this.lIp = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.lHp);
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        ap.setBackgroundColor(this.mStatusBar, R.color.CAM_X0611);
        ap.setBackgroundColor(this.mat, R.color.CAM_X0608);
        ap.setBackgroundColor(this.mal, R.color.CAM_X0207);
        if (this.mal != null) {
            this.mal.onChangeSkinType();
        }
        if (this.kNm != null) {
            this.kNm.onChangeSkinType();
        }
        if (this.mas == null || !this.mas.isPlaying()) {
            ap.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        }
        if (this.acn != null) {
            this.acn.onChangeSkinType(i);
        }
        if (this.lQz != null) {
            this.lQz.onChangeSkinType(i);
        }
        if (this.lPT != null) {
            this.lPT.setBorderColor(ap.getColor(R.color.CAM_X0401));
        }
        if (this.lPS != null) {
            this.lPS.setBackgroundDrawable(ap.aR(l.getDimens(getContext(), R.dimen.tbds47), ap.getColor(R.color.CAM_X0209)));
        }
        if (dol() != null && dol().bkY()) {
            WebPManager.a(this.lPV, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.a(this.lPV, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.a(this.lPU, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        SvgManager.btW().a(this.maz, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (dol() != null) {
            x(dol().getPbData());
        }
        ap.setBackgroundResource(this.man, R.drawable.personalize_tab_shadow);
        ap.setBackgroundColor(this.mau, R.color.CAM_X0206);
        ap.setBackgroundColor(this.lPR, R.color.CAM_X0207);
        ap.setBackgroundColor(this.lPQ, R.color.CAM_X0203);
        ap.setViewTextColor(this.may, R.color.CAM_X0109);
        ap.setViewTextColor(this.maw, R.color.CAM_X0105);
        ap.setViewTextColor(this.jYt, R.color.CAM_X0109);
        ap.setViewTextColor(this.lPZ, R.color.CAM_X0105);
        ap.setViewTextColor(this.lPY, R.color.CAM_X0107);
        ap.d(this.lPY, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        if (com.baidu.tbadk.a.d.bkt() && dvX() != null) {
            dvX().onChangeSkinType(i);
        } else if (dvV() != null) {
            dvV().onChangeSkinType(i);
        }
        if (dvW() != null) {
            dvW().onChangeSkinType(i);
        }
        if (this.maC != null) {
            this.maC.setBackgroundDrawable(ap.aR(l.getDimens(this.maC.getContext(), R.dimen.tbds32), ap.getColor(R.color.CAM_X0309)));
        }
        cCF();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iSW == null) {
            this.iSW = VoiceManager.instance();
        }
        return this.iSW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCF() {
        if (this.iSW != null) {
            this.iSW.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment dpP() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment dpQ() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel dol() {
        return this.lHp.dol();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity dpR() {
        return this.lHp;
    }

    public com.baidu.tbadk.baseEditMark.a dvJ() {
        return this.lHU;
    }

    public View.OnClickListener dvK() {
        return this.aGQ;
    }

    public View.OnClickListener dvL() {
        return this.lEF;
    }

    public View.OnLongClickListener dvM() {
        return this.mOnLongClickListener;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (be.Qw(objArr[i].getLink()) && (drawable = ap.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                    spannableStringBuilder2.setSpan(new com.baidu.tbadk.widget.d(drawable), 0, "#4%2&@#907$12#@96476)w7we9e~@$%&&".length(), 33);
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

    public BdTypeRecyclerView cFx() {
        Iterator<BaseFragment> it = this.mam.dwg().iterator();
        while (it.hasNext()) {
            BaseFragment next = it.next();
            if (next instanceof DetailInfoAndReplyFragment) {
                return ((DetailInfoAndReplyFragment) next).getListView();
            }
            if (next instanceof ReplyFragment) {
                return ((ReplyFragment) next).getListView();
            }
        }
        return null;
    }

    private void uM(boolean z) {
        this.lIi.kA(z);
        this.lIi.kB(z);
        this.lIi.kC(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.maF != null) {
            if (z) {
                this.maF.dsS();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.maF.dsT();
            } else {
                this.maF.dsS();
            }
        }
    }

    public boolean Hd(int i) {
        if (this.kJE == null || dol() == null || dol().getPbData() == null || dol().getPbData().getAnti() == null) {
            return true;
        }
        return this.kJE.aQ(dol().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean dpk() {
        if ((dol() != null && dol().getPbData().dny()) || this.kJE == null || dol() == null || dol().getPbData() == null || dol().getPbData().getAnti() == null) {
            return true;
        }
        return this.kJE.pP(dol().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && dol() != null) {
            gVar.setForumName(dol().doe());
            if (dol().getPbData() != null && dol().getPbData().getForum() != null) {
                gVar.a(dol().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(dol());
        }
    }

    public void dst() {
        if (this.acn != null) {
            this.acn.su();
            if (this.lIi != null) {
                this.lIi.bCY();
            }
            dtb();
        }
    }

    public com.baidu.tbadk.editortools.pb.e doX() {
        return this.lIi;
    }

    private boolean dph() {
        PbModel dol = dol();
        if (dol == null || dol.getPbData() == null) {
            return false;
        }
        by dmU = dol.getPbData().dmU();
        dol.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), dmU);
    }

    public void dpi() {
        if (checkUpIsLogin() && dol() != null && dol().getPbData() != null && dol().getPbData().getForum() != null && !dph()) {
            if (dol().getPbData().dny()) {
                cQY();
                return;
            }
            if (this.iXq == null) {
                this.iXq = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.iXq.Bo(0);
                this.iXq.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qi(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void C(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qj(boolean z) {
                        if (z) {
                            if (VideoPbFragment.this.lIi != null && VideoPbFragment.this.lIi.bCn() != null) {
                                VideoPbFragment.this.lIi.bCn().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            VideoPbFragment.this.cQY();
                        }
                    }
                });
            }
            this.iXq.G(dol().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(dol().dqk(), 0L));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.lIi.onActivityResult(i, i2, intent);
        if (this.lHI != null) {
            this.lHI.onActivityResult(i, i2, intent);
        }
        if (this.lQz != null) {
            this.lQz.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    dpu();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.p.a.dEL().F(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.lIl = emotionImageData;
                        if (Hd(am.eTz)) {
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
        if (dpR() != null) {
            if (this.maM && !TbSingleton.getInstance().isNotchScreen(dpR()) && !TbSingleton.getInstance().isCutoutScreen(dpR())) {
                dwb();
                UtilHelper.hideStatusBar(dpR(), dpR().getRootView());
                this.maM = false;
            }
            this.maG.mbb = z;
            dvN();
            dvO();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.lHp;
        if (i == 0) {
            drY();
            if (this.lQz != null) {
                this.lQz.doS();
            }
            vy(false);
        }
        dsc();
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
                        this.lIi.resetData();
                        this.lIi.setVoiceModel(pbEditorData.getVoiceModel());
                        this.lIi.b(writeData);
                        m sj = this.lIi.bCn().sj(6);
                        if (sj != null && sj.fub != null) {
                            sj.fub.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.lHp;
                        if (i == -1) {
                            this.lIi.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.lQz != null && this.lQz.doW() != null) {
                            com.baidu.tbadk.editortools.pb.h doW = this.lQz.doW();
                            doW.setThreadData(dol().getPbData().dmU());
                            doW.b(writeData);
                            doW.setVoiceModel(pbEditorData.getVoiceModel());
                            m sj2 = doW.bCn().sj(6);
                            if (sj2 != null && sj2.fub != null) {
                                sj2.fub.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.lHp;
                            if (i == -1) {
                                doW.bDr();
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
                if (dol() != null && !dol().dqs()) {
                    antiData.setBlock_forum_name(dol().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(dol().getPbData().getForum().getId());
                    antiData.setUser_name(dol().getPbData().getUserData().getUserName());
                    antiData.setUser_id(dol().getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            String errorString = postWriteCallBackData.getErrorString();
            String preMsg = postWriteCallBackData.getPreMsg();
            String colorMsg = postWriteCallBackData.getColorMsg();
            if (postWriteCallBackData.getIconStampData() != null) {
                com.baidu.tbadk.coreExtra.c.b.a(getPageContext(), postWriteCallBackData);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.c.h(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bP(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ay.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ay.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ay.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            if (this.maF != null) {
                this.maF.Ea(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void dpT() {
        if (dol() != null && this.lHp != null) {
            if (this.lIi == null || !this.lIi.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.lIi = (com.baidu.tbadk.editortools.pb.e) dVar.eN(getContext());
                this.lIi.a(this.lHp.getPageContext());
                this.lIi.a(this.fwI);
                this.lIi.a(this.fwB);
                this.lIi.a(this.lHp.getPageContext(), this.lHp.getIntent() == null ? null : this.lHp.getIntent().getExtras());
                this.lIi.bCn().ks(true);
                setEditorTools(this.lIi.bCn());
                if (!dol().dqs()) {
                    this.lIi.DV(dol().dqk());
                }
                if (dol().dqT()) {
                    this.lIi.DT(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.lIi.DT(dse());
                }
            }
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.acn = editorTools;
        this.acn.setId(R.id.pb_editor);
        this.acn.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.dsc();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.acn.getParent() == null) {
            this.rootView.addView(this.acn, layoutParams);
        }
        this.acn.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.acn.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof u) {
                    if (((u) aVar.data).bxC() == EmotionGroupType.BIG_EMOTION || ((u) aVar.data).bxC() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.lIi.c((u) aVar.data);
                            VideoPbFragment.this.lIi.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        drY();
        this.lIi.a(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (VideoPbFragment.this.acn != null && VideoPbFragment.this.acn.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3 && TextUtils.isEmpty(charSequence.toString().substring(i, i + i3))) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (VideoPbFragment.this.kNm != null && VideoPbFragment.this.kNm.dtt() != null) {
                    if (!VideoPbFragment.this.kNm.dtt().dYq()) {
                        VideoPbFragment.this.kNm.vE(false);
                    }
                    VideoPbFragment.this.kNm.dtt().zc(false);
                }
            }
        });
    }

    public void cQY() {
        if (!checkUpIsLogin()) {
            if (dol() != null) {
                TiebaStatic.log(new ar("c10517").al("obj_locate", 2).dY("fid", dol().getForumId()));
            }
        } else if (dpk()) {
            if (this.lIi != null && (this.lIi.bDi() || this.lIi.bDj())) {
                this.lIi.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.acn != null) {
                dst();
                this.maG.mba = false;
                if (this.acn.sj(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.acn.sj(2).fub, false, null);
                }
            }
            dtb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !dph() && dpk()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.lHK);
                this.lHL = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.lQz != null && postData != null) {
                String str3 = "";
                if (postData.dPj() != null) {
                    str3 = postData.dPj().toString();
                }
                this.lQz.Qb(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.boP().getName_show(), str3));
            }
            if (dol() != null && dol().getPbData() != null && dol().getPbData().dny()) {
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.lHp.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.lHK[1] + VideoPbFragment.this.lHL) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cFx() != null) {
                            VideoPbFragment.this.cFx().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.lQz != null) {
                            VideoPbFragment.this.lIi.bCn().setVisibility(8);
                            VideoPbFragment.this.lQz.h(str, str2, VideoPbFragment.this.dse(), (VideoPbFragment.this.dol() == null || VideoPbFragment.this.dol().getPbData() == null || VideoPbFragment.this.dol().getPbData().dmU() == null || !VideoPbFragment.this.dol().getPbData().dmU().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h doW = VideoPbFragment.this.lQz.doW();
                            if (doW != null && VideoPbFragment.this.dol() != null && VideoPbFragment.this.dol().getPbData() != null) {
                                doW.a(VideoPbFragment.this.dol().getPbData().getAnti());
                                doW.setThreadData(VideoPbFragment.this.dol().getPbData().dmU());
                            }
                            if (VideoPbFragment.this.kNm.dtv() == null && VideoPbFragment.this.lQz.doW().bDz() != null) {
                                VideoPbFragment.this.lQz.doW().bDz().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kNm != null && VideoPbFragment.this.kNm.dtu() != null) {
                                            if (!VideoPbFragment.this.kNm.dtu().dYq()) {
                                                VideoPbFragment.this.kNm.vF(false);
                                            }
                                            VideoPbFragment.this.kNm.dtu().zc(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kNm.f(VideoPbFragment.this.lQz.doW().bDz().getInputView());
                                VideoPbFragment.this.lQz.doW().a(VideoPbFragment.this.lIn);
                            }
                        }
                        VideoPbFragment.this.dtb();
                    }
                }, 0L);
                return;
            }
            if (this.lIk == null) {
                this.lIk = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.lIk.Bo(1);
                this.lIk.a(new AnonymousClass49(str, str2));
            }
            if (dol() != null && dol().getPbData() != null && dol().getPbData().getForum() != null) {
                this.lIk.G(dol().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(dol().dqk(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$49  reason: invalid class name */
    /* loaded from: classes22.dex */
    public class AnonymousClass49 implements c.a {
        final /* synthetic */ String lJs;
        final /* synthetic */ String lJt;

        AnonymousClass49(String str, String str2) {
            this.lJs = str;
            this.lJt = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qi(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void C(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qj(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.lHK[1] + VideoPbFragment.this.lHL) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cFx() != null) {
                            VideoPbFragment.this.cFx().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.lQz != null) {
                            VideoPbFragment.this.lIi.bCn().setVisibility(8);
                            VideoPbFragment.this.lQz.h(AnonymousClass49.this.lJs, AnonymousClass49.this.lJt, VideoPbFragment.this.dse(), (VideoPbFragment.this.dol() == null || VideoPbFragment.this.dol().getPbData() == null || VideoPbFragment.this.dol().getPbData().dmU() == null || !VideoPbFragment.this.dol().getPbData().dmU().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h doW = VideoPbFragment.this.lQz.doW();
                            if (doW != null && VideoPbFragment.this.dol() != null && VideoPbFragment.this.dol().getPbData() != null) {
                                doW.a(VideoPbFragment.this.dol().getPbData().getAnti());
                                doW.setThreadData(VideoPbFragment.this.dol().getPbData().dmU());
                            }
                            if (VideoPbFragment.this.kNm.dtv() == null && VideoPbFragment.this.lQz.doW().bDz() != null) {
                                VideoPbFragment.this.lQz.doW().bDz().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kNm != null && VideoPbFragment.this.kNm.dtu() != null) {
                                            if (!VideoPbFragment.this.kNm.dtu().dYq()) {
                                                VideoPbFragment.this.kNm.vF(false);
                                            }
                                            VideoPbFragment.this.kNm.dtu().zc(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kNm.f(VideoPbFragment.this.lQz.doW().bDz().getInputView());
                                VideoPbFragment.this.lQz.doW().a(VideoPbFragment.this.lIn);
                            }
                        }
                        VideoPbFragment.this.dtb();
                    }
                }, 0L);
            }
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData L;
        ac acVar;
        StringBuilder sb = null;
        if (fVar != null && (L = L(fVar)) != null) {
            String userId = L.boP().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, L.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dnj()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (L.boP() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, L.boP().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, L.boP().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, L.boP().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, L.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, L.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dnj()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bu> dnr = fVar.dnr();
                if (com.baidu.tbadk.core.util.y.getCount(dnr) > 0) {
                    sb = new StringBuilder();
                    for (bu buVar : dnr) {
                        if (buVar != null && !StringUtils.isNull(buVar.getForumName()) && (acVar = buVar.eIt) != null && acVar.eGf && !acVar.eGg && (acVar.type == 1 || acVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(buVar.getForumName(), 12)).append(TbadkCoreApplication.getInst().getString(R.string.forum)).append("、");
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
    public void dpu() {
        MarkData Hp;
        if (dol() != null && dol().getPbData() != null) {
            if (com.baidu.tbadk.a.d.bkt() || dvV() != null) {
                if ((!com.baidu.tbadk.a.d.bkt() || dvX() != null) && this.lHU != null) {
                    if (dol().getPbData() != null && dol().getPbData().dny()) {
                        Hp = dol().Hp(0);
                    } else if (this.eRw != null && this.eRw.getCurrentItem() == mah) {
                        Hp = dol().o(L(dol().getPbData()));
                    } else if (com.baidu.tbadk.a.d.bkt()) {
                        Hp = dol().Hp(dvX().dsE());
                    } else {
                        Hp = dol().Hp(dvV().dsE());
                    }
                    if (Hp != null) {
                        if (!Hp.isApp() || (Hp = dol().Hp(dvV().dsE() + 1)) != null) {
                            dsz();
                            this.lHU.a(Hp);
                            if (!this.lHU.bkY()) {
                                this.lHU.bla();
                                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                                return;
                            }
                            this.lHU.bkZ();
                            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean He(int i) {
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
            if (this.lHI == null) {
                this.lHI = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.lHp);
                this.lHI.b(this.fwB);
                this.lHI.c(this.fwI);
            }
            this.lHI.a(emotionImageData, dol(), dol().getPbData());
        }
    }

    public PostData L(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dnh() != null) {
            return fVar.dnh();
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dmW())) {
            Iterator<PostData> it = fVar.dmW().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dPh() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dnd();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.boP() != null && postData.boP().getUserTbVipInfoData() != null && postData.boP().getUserTbVipInfoData().getvipIntro() != null) {
            postData.boP().getGodUserData().setIntro(postData.boP().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dmU() == null || fVar.dmU().boP() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData boP = fVar.dmU().boP();
        String userId = boP.getUserId();
        HashMap<String, MetaData> userMap = fVar.dmU().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = boP;
        }
        postData.KV(1);
        postData.setId(fVar.dmU().bpg());
        postData.setTitle(fVar.dmU().getTitle());
        postData.setTime(fVar.dmU().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dpz() {
        ArrayList<PostData> dmW;
        int count;
        int i;
        if (dol() == null || dol().getPbData() == null || dol().getPbData().dmW() == null || (count = com.baidu.tbadk.core.util.y.getCount((dmW = dol().getPbData().dmW()))) == 0) {
            return "";
        }
        if (dol().dqD()) {
            Iterator<PostData> it = dmW.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dPh() == 1) {
                    return next.getId();
                }
            }
        }
        if (cFx() == null) {
            i = 0;
        } else if (com.baidu.tbadk.a.d.bkt()) {
            i = dvX().dsD();
        } else {
            i = dvV().dsD();
        }
        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(dmW, i);
        if (postData == null || postData.boP() == null) {
            return "";
        }
        if (dol().Qk(postData.boP().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(dmW, i2);
            if (postData2 == null || postData2.boP() == null || postData2.boP().getUserId() == null) {
                break;
            } else if (dol().Qk(postData2.boP().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(dmW, i3);
            if (postData3 == null || postData3.boP() == null || postData3.boP().getUserId() == null) {
                return "";
            }
            if (dol().Qk(postData3.boP().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpv() {
        if (dol() != null) {
            com.baidu.tieba.pb.data.f pbData = dol().getPbData();
            dol().vc(true);
            if (this.lHU != null) {
                pbData.PV(this.lHU.bkX());
            }
            if (com.baidu.tbadk.a.d.bkt() && dvX() != null) {
                dvX().dwG();
            } else if (dvV() != null) {
                dvV().dwG();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (dol() != null) {
            dsB();
            dol().vc(z);
            if (this.lHU != null) {
                this.lHU.iH(z);
                if (markData != null) {
                    this.lHU.a(markData);
                }
            }
            if (dol().bkY()) {
                dpv();
            } else if (com.baidu.tbadk.a.d.bkt() && dvX() != null) {
                dvX().dwG();
            } else if (dvV() != null) {
                dvV().dwG();
            }
        }
    }

    public void b(p pVar) {
        boolean z;
        MetaData metaData;
        if (dol() != null && dol().getPbData() != null && pVar.dnN() != null) {
            String id = pVar.dnN().getId();
            ArrayList<PostData> dmW = dol().getPbData().dmW();
            int i = 0;
            while (true) {
                if (i >= dmW.size()) {
                    z = true;
                    break;
                }
                PostData postData = dmW.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> dnV = pVar.dnV();
                    postData.KU(pVar.getTotalCount());
                    if (postData.dPe() == null || dnV == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = dnV.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.boP() != null && (metaData = postData.getUserMap().get(next.boP().getUserId())) != null) {
                                next.a(metaData);
                                next.yc(true);
                                next.a(getPageContext(), dol().Qk(metaData.getUserId()));
                            }
                        }
                        z = dnV.size() != postData.dPe().size();
                        if (postData.dPe() != null && postData.dPe().size() < 2) {
                            postData.dPe().clear();
                            postData.dPe().addAll(dnV);
                        }
                    }
                    if (postData.dPa() != null) {
                        postData.dPb();
                    }
                }
            }
            if (!dol().getIsFromMark() && z) {
                if (com.baidu.tbadk.a.d.bkt() && dvX() != null) {
                    dvX().dwG();
                } else if (dvV() != null) {
                    dvV().dwG();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpm() {
        if (dol() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.SQ(dol().getForumId()) && dol().getPbData() != null && dol().getPbData().getForum() != null) {
            if (dol().getPbData().getForum().isLike() == 1) {
                dol().dqR().gn(dol().getForumId(), dol().dqk());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            by dmU = fVar.dmU();
            if (dmU != null && dmU.bnz()) {
                dpT();
            } else {
                d(this.lIh);
            }
            if (this.lIi != null) {
                vw(this.lIi.bDb());
                this.lIi.a(fVar.getAnti());
                this.lIi.a(fVar.getForum(), fVar.getUserData());
                this.lIi.setThreadData(dmU);
                if (dol() != null) {
                    this.lIi.a(dol().dqB(), dol().dqk(), dol().dqS());
                }
                if (dmU != null) {
                    this.lIi.kD(dmU.bqo());
                }
            }
        }
    }

    public void dsc() {
        reset();
        drY();
        this.lQz.doS();
        vy(false);
    }

    private void reset() {
        if (this.lIi != null && this.acn != null) {
            com.baidu.tbadk.editortools.pb.a.bCQ().setStatus(0);
            this.lIi.bDl();
            this.lIi.bCA();
            if (this.lIi.getWriteImagesInfo() != null) {
                this.lIi.getWriteImagesInfo().setMaxImagesAllowed(this.lIi.isBJH ? 1 : 9);
            }
            this.lIi.st(SendView.ALL);
            this.lIi.su(SendView.ALL);
            com.baidu.tbadk.editortools.h sg = this.acn.sg(23);
            com.baidu.tbadk.editortools.h sg2 = this.acn.sg(2);
            com.baidu.tbadk.editortools.h sg3 = this.acn.sg(5);
            if (sg2 != null) {
                sg2.su();
            }
            if (sg3 != null) {
                sg3.su();
            }
            if (sg != null) {
                sg.hide();
            }
            this.acn.invalidate();
        }
    }

    public void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmU() != null) {
            x(fVar);
            this.lPV.setVisibility(fVar.dny() ? 8 : 0);
            if (fVar.bkY()) {
                WebPManager.a(this.lPV, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.lPV, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String Hx = Hx(fVar.dmU().boG());
            if (this.lPY != null) {
                this.lPY.setText(Hx);
            }
            if (this.lPZ != null) {
                this.lPZ.setText(Hx);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.dmU()));
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.bb(fVar.dmU())) {
            if (this.lPX != null) {
                this.lPX.setEnable(false);
                this.lPX.onDestroy();
            }
            ViewGroup.LayoutParams layoutParams = this.lPW.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.lPW.setLayoutParams(layoutParams);
            WebPManager.a(this.lPW, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (this.lPX == null || !this.lPX.isEnable()) {
            ViewGroup.LayoutParams layoutParams2 = this.lPW.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.lPW.setLayoutParams(layoutParams2);
            WebPManager.a(this.lPW, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    private String Hx(int i) {
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

    public void vy(boolean z) {
        if (this.lPR != null) {
            vw(this.lIi.bDb());
            if (this.lPN) {
                vn(z);
            } else {
                vo(z);
            }
            dvN();
            dvO();
        }
    }

    public void dtb() {
        if (this.lPR != null) {
            this.lPQ.setVisibility(8);
            this.lPR.setVisibility(8);
            this.maG.mba = false;
            dvN();
            dvO();
        }
    }

    private void dvN() {
        if (this.mar != null) {
            if (this.maG.dwf()) {
                this.mar.xa(false);
            } else {
                this.mar.xa(this.mar.cak() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvO() {
        if (this.mar != null && this.eRw != null) {
            if (com.baidu.tbadk.a.d.bkt()) {
                this.mar.wi(false);
            } else if (this.eRw.getCurrentItem() != 0) {
                this.mar.wi(false);
            } else if (this.maG.dwf()) {
                this.mar.wi(false);
            } else {
                e eVar = (e) y.b(getActivity()).l(e.class);
                if (eVar != null) {
                    this.mar.wi(eVar.dwp() == null || eVar.dwp().getValue() == null || eVar.dwp().getValue().booleanValue());
                }
            }
        }
    }

    private void Hf(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(dpR(), dpl(), i);
    }

    private int dpl() {
        if (dol() == null || dol().getPbData() == null || dol().getPbData().dmU() == null) {
            return -1;
        }
        return dol().getPbData().dmU().bpC();
    }

    public void vw(boolean z) {
        this.lPN = z;
    }

    public void vn(boolean z) {
        if (this.lPR != null && this.jYt != null) {
            this.jYt.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lPR.startAnimation(alphaAnimation);
            }
            this.lPQ.setVisibility(0);
            this.lPR.setVisibility(0);
            this.maG.mba = true;
        }
    }

    public void vo(boolean z) {
        if (this.lPR != null && this.jYt != null) {
            this.jYt.setText(dse());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lPR.startAnimation(alphaAnimation);
            }
            this.lPQ.setVisibility(0);
            this.lPR.setVisibility(0);
            this.maG.mba = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null && this.lBv == null) {
            this.lBv = aVar;
            this.maw.setText(aVar.getTitle());
            this.may.setText(aVar.dwT());
            String dwU = aVar.dwU();
            TBSpecificationBtn tBSpecificationBtn = this.maA;
            if (TextUtils.isEmpty(dwU)) {
                dwU = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(dwU);
            this.maB.startLoad(aVar.getImage(), 10, false);
            this.maC.setVisibility(aVar.dwW() ? 0 : 8);
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoPbFragment.this.lBv == null || VideoPbFragment.this.lBv.dwW()) {
                        if (VideoPbFragment.this.lBv != null && VideoPbFragment.this.dol() != null && VideoPbFragment.this.dol().getPbData() != null && VideoPbFragment.this.dol().getPbData().getForum() != null) {
                            TiebaStatic.log(new ar("c13712").dY("fid", VideoPbFragment.this.dol().getPbData().getForum().getId()).dY("fname", VideoPbFragment.this.dol().getPbData().getForum().getName()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("tid", VideoPbFragment.this.dol().getPbData().getThreadId()).w("obj_param1", VideoPbFragment.this.lBv.userId));
                        }
                    } else {
                        TiebaStatic.log(new ar("c13608").dY("obj_id", VideoPbFragment.this.lBv.getTitle()).dY("obj_name", VideoPbFragment.this.lBv.dwT()).al("obj_type", 2).dY("fid", VideoPbFragment.this.dol().getPbData().getForumId()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("tid", VideoPbFragment.this.dol().getPbData().getThreadId()));
                    }
                    VideoPbFragment.this.dvP();
                }
            }, aVar.dwV().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvP() {
        ViewGroup.LayoutParams layoutParams = this.mau.getLayoutParams();
        if (layoutParams != null) {
            if (this.maD == null || !this.maD.isRunning()) {
                this.mau.setAlpha(0.0f);
                this.mau.setVisibility(0);
                e(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvQ() {
        if (this.mau.getLayoutParams() != null) {
            if (this.maD == null || !this.maD.isRunning()) {
                dvR();
            }
        }
    }

    private void dvR() {
        final ViewGroup.LayoutParams layoutParams = this.mau.getLayoutParams();
        if (layoutParams != null) {
            if (this.maE == null || !this.maE.isRunning()) {
                this.maE = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.maE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.mau.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.maE.setDuration(200L);
                this.maE.start();
                this.maE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPbFragment.this.d(layoutParams);
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
    public void d(final ViewGroup.LayoutParams layoutParams) {
        final ViewGroup.LayoutParams layoutParams2 = this.Zj.getLayoutParams();
        final int i = layoutParams2.height;
        this.maD = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.maD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.jVb);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.jVb);
                VideoPbFragment.this.mau.setLayoutParams(layoutParams);
                VideoPbFragment.this.Zj.setLayoutParams(layoutParams2);
            }
        });
        this.maD.setDuration(300L);
        this.maD.start();
        this.maD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.mau.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private void e(final ViewGroup.LayoutParams layoutParams) {
        final ViewGroup.LayoutParams layoutParams2 = this.Zj.getLayoutParams();
        final int i = layoutParams2.height;
        this.maD = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.maD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.jVb);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.mau.setLayoutParams(layoutParams);
                VideoPbFragment.this.Zj.setLayoutParams(layoutParams2);
            }
        });
        this.maD.setDuration(300L);
        this.maD.start();
        this.maD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.dvS();
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
    public void dvS() {
        this.maD = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.maD.setDuration(300L);
        this.maD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.mau.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.maD.start();
    }

    public String dse() {
        if (!au.isEmpty(this.lQR)) {
            return this.lQR;
        }
        this.lQR = TbadkCoreApplication.getInst().getResources().getString(com.baidu.tieba.pb.pb.main.ay.drU());
        return this.lQR;
    }

    public void dsB() {
        hideProgressBar();
        if (com.baidu.tbadk.a.d.bkt() && dvX() != null) {
            dvX().endLoadData();
            dvX().dsC();
        } else if (dvV() != null) {
            dvV().endLoadData();
            dvV().dsC();
        }
    }

    public boolean du(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.blV().isShowImages()) {
                    return Qg(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (dol() == null || dol().getPbData() == null) {
                        return true;
                    }
                    if (this.lQz != null) {
                        this.lQz.doS();
                    }
                    p pVar = new p();
                    pVar.a(dol().getPbData().getForum());
                    pVar.setThreadData(dol().getPbData().dmU());
                    pVar.g(postData);
                    this.lHk.d(pVar);
                    this.lHk.setPostId(postData.getId());
                    a(view, postData.boP().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.lIi != null) {
                        vw(this.lIi.bDb());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void dvT() {
        if (this.lIi != null) {
            vw(this.lIi.bDb());
        }
        dsc();
        this.maF.dsS();
    }

    private boolean Qg(String str) {
        if (!StringUtils.isNull(str) && bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString("bubble_link", "");
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

    public void cYn() {
        if (this.lPz != null) {
            this.lPz.setVisibility(0);
        }
    }

    public void cYm() {
        if (this.lPz != null) {
            this.lPz.setVisibility(8);
        }
    }

    public void HP(int i) {
        if (this.man != null) {
            this.man.setVisibility(i);
        }
    }

    public void dsz() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a dpp() {
        return this.lIY;
    }

    public void drY() {
        if (this.acn != null) {
            this.acn.hide();
        }
    }

    public void cCG() {
        if (this.lHp.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.lHp.getCurrentFocus());
        }
    }

    public void N(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmU() != null) {
            String valueOf = String.valueOf(fVar.dmU().boG());
            if (fVar.dmU().boG() == 0) {
                valueOf = "";
            }
            this.mal.Fa(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        for (BaseFragment baseFragment : this.mam.dwg()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, fVar, str, i4);
            }
        }
        b(z, i, i2, i3, fVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (dol() != null && dol().getPbData() != null && dol().getPbData().dmU() != null && dol().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(lQs)).intValue();
                if (intValue == lQt) {
                    if (!this.fXd.dQc()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.fXd.TT(au.S(jSONArray));
                        }
                        this.fXd.a(dol().getPbData().getForum().getId(), dol().getPbData().getForum().getName(), dol().getPbData().dmU().getId(), str, intValue3, intValue2, booleanValue, dol().getPbData().dmU().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == lQu || intValue == lQw) {
                    if (dol().dqO() != null) {
                        dol().dqO().GY(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == lQu) {
                        TiebaStatic.log("c10499");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(String str, String str2) {
        bf.bua().b(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bJm() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bJn() {
        if (this.fMZ == null) {
            this.fMZ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bJz */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.blV().isShowImages();
                    foreDrawableImageView.setDefaultBg(ap.getDrawable(R.color.common_color_10220));
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
                        if (com.baidu.tbadk.core.k.blV().isShowImages()) {
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
        return this.fMZ;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bJo() {
        if (this.fQq == null) {
            this.fQq = TbRichTextView.J(getPageContext().getPageActivity(), 8);
        }
        return this.fQq;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bJp() {
        if (this.fNa == null) {
            this.fNa = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cwL */
                public GifView makeObject() {
                    GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.blV().isShowImages();
                    gifView.setDefaultBg(ap.getDrawable(R.color.common_color_10220));
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
                    if (com.baidu.tbadk.core.k.blV().isShowImages()) {
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
                    gifView.bDT();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.fNa;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bJq() {
        if (this.fQr == null) {
            this.fQr = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dpU */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(VideoPbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(VideoPbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dz */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dA */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).ccA();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dB */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fQr;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bJr() {
        if (this.fQs == null) {
            this.fQs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.62
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dpW */
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
                /* renamed from: d */
                public void destroyObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: e */
                public LinearLayout activateObject(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: f */
                public LinearLayout passivateObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.fQs;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bJs() {
        this.fQt = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.63
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dpV */
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
        return this.fQt;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ax(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.lHB = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        if (be.Qw(str) && dol() != null && dol().dqk() != null) {
            TiebaStatic.log(new ar("c11664").al("obj_param1", 1).dY("post_id", dol().dqk()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.m mVar = new com.baidu.tbadk.data.m();
                mVar.mLink = str;
                mVar.type = 3;
                mVar.fsY = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, mVar));
            }
        } else {
            be.dtx().f(getPageContext(), str);
        }
        this.lHB = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ay(Context context, String str) {
        be.dtx().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.lHB = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void az(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aA(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void u(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.maF.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b dwC = this.maF.dwC();
            if (dwC == null) {
                this.maF.dpg();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                dwC.getItemView(1).setVisibility(8);
            } else {
                dwC.getItemView(1).setVisibility(0);
            }
            dwC.brx();
            this.lHB = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aB(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            bf.bua().b(getPageContext(), new String[]{str});
            this.lHB = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a dvU() {
        return this.eTC;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener bGL() {
        return this.fGd;
    }

    public ReplyFragment dvV() {
        if (this.mam == null || !(this.mam.HQ(mai) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.mam.HQ(mai);
    }

    public DetailInfoFragment dvW() {
        if (this.mam == null || !(this.mam.HQ(mah) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.mam.HQ(mah);
    }

    public DetailInfoAndReplyFragment dvX() {
        if (this.mam == null || !(this.mam.HQ(maj) instanceof DetailInfoAndReplyFragment)) {
            return null;
        }
        return (DetailInfoAndReplyFragment) this.mam.HQ(maj);
    }

    public boolean dod() {
        PbModel dol = this.lHp.dol();
        if (dol == null) {
            return false;
        }
        return dol.dod();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData dng;
        PbModel dol = this.lHp.dol();
        if (dol != null && dol.getPbData() != null && !dol.getPbData().dny()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = dol.getPbData().dmU().getId();
            if (dol.isShareThread() && dol.getPbData().dmU().eLH != null) {
                historyMessage.threadName = dol.getPbData().dmU().eLH.showText;
            } else {
                historyMessage.threadName = dol.getPbData().dmU().getTitle();
            }
            if (dol.isShareThread() && !dod()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = dol.getPbData().getForum().getName();
            }
            ArrayList<PostData> dmW = dol.getPbData().dmW();
            int dsD = dvV() != null ? dvV().dsD() : 0;
            if (dmW != null && dsD >= 0 && dsD < dmW.size()) {
                historyMessage.postID = dmW.get(dsD).getId();
            }
            historyMessage.isHostOnly = dol.getHostMode();
            historyMessage.isSquence = dol.dqm();
            historyMessage.isShareThread = dol.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.lIi != null) {
            this.lIi.onDestroy();
        }
        if (dol != null && (dol.dqn() || dol.dqp())) {
            Intent intent = new Intent();
            intent.putExtra("tid", dol.dqk());
            if (this.lHX) {
                if (this.lHZ) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", dol.cuU());
                }
                if (this.lHY) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", dol.getIsGood());
                }
            }
            if (dol.getPbData() != null && System.currentTimeMillis() - this.lHx >= 40000 && (dng = dol.getPbData().dng()) != null && !com.baidu.tbadk.core.util.y.isEmpty(dng.getDataList())) {
                intent.putExtra("guess_like_data", dng);
            }
            PbActivity pbActivity = this.lHp;
            PbActivity pbActivity2 = this.lHp;
            pbActivity.setResult(-1, intent);
        }
        if (dpw()) {
            if (dol != null) {
                com.baidu.tieba.pb.data.f pbData = dol.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.lHD) {
                        if (this.maq != null) {
                            Rect rect = new Rect();
                            this.maq.getGlobalVisibleRect(rect);
                            as.drJ().h(rect);
                        }
                        as.drJ().Ht(this.eRw.getCurrentItem());
                        BdTypeRecyclerView cFx = cFx();
                        Parcelable parcelable = null;
                        if (cFx != null) {
                            parcelable = cFx.onSaveInstanceState();
                        }
                        as.drJ().a(dol.dqv(), parcelable, dol.dqm(), dol.getHostMode(), false);
                    }
                }
            } else {
                as.drJ().reset();
            }
            doy();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mar != null && !this.mar.cak()) {
            if ((this.mar.isFullScreen() && configuration.orientation == 1) || (!this.mar.isFullScreen() && configuration.orientation == 2)) {
                this.mar.wj(false);
            }
        }
    }

    public boolean dvY() {
        if (this.mar == null) {
            return false;
        }
        return this.mar.cak();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.t.c.dOf().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a {
        public boolean mba;
        public boolean mbb;

        private a() {
            this.mbb = true;
        }

        public boolean dwf() {
            return (this.mba && this.mbb) ? false : true;
        }
    }

    public void dvZ() {
        this.lHM = -1;
        this.lHN = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpN() {
        if (dol() != null && !au.isEmpty(dol().dqk())) {
            com.baidu.tbadk.BdToken.c.biD().p(com.baidu.tbadk.BdToken.b.evv, com.baidu.adp.lib.f.b.toLong(dol().dqk(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.mao.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwa() {
        if (this.maP == null) {
            this.maP = ObjectAnimator.ofFloat(this.mat, "alpha", 0.0f, 1.0f);
            this.maP.setDuration(200L);
        }
        this.maP.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwb() {
        if (this.maQ == null) {
            this.maQ = ObjectAnimator.ofFloat(this.mat, "alpha", 1.0f, 0.0f);
            this.maQ.setDuration(200L);
        }
        this.maQ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dwc() {
        return this.mar != null && this.mar.dwd();
    }

    public boolean dwd() {
        return this.maM;
    }

    public void wa(boolean z) {
        this.maM = z;
    }

    public void uT(boolean z) {
        this.lHE = z;
    }

    public boolean dpL() {
        return this.lHE;
    }
}
