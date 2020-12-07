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
    private ImageView gOj;
    private VoiceManager iSU;
    private com.baidu.tieba.g.b iXO;
    private com.baidu.tieba.frs.profession.permission.c iXo;
    private com.baidu.tieba.callfans.a iko;
    public View jjn;
    public am kJC;
    public bb kNk;
    private com.baidu.tieba.pb.videopb.c.a lBt;
    private com.baidu.tieba.pb.pb.main.emotion.model.a lHG;
    int lHJ;
    private PbFakeFloorModel lHi;
    private PbActivity lHn;
    private g lIf;
    private com.baidu.tbadk.editortools.pb.e lIg;
    private com.baidu.tieba.frs.profession.permission.c lIi;
    private EmotionImageData lIj;
    private com.baidu.tbadk.core.view.c lIn;
    private View lPO;
    private LinearLayout lPQ;
    private HeadImageView lPR;
    private ImageView lPS;
    private ImageView lPT;
    private ImageView lPU;
    private com.baidu.tieba.pb.view.d lPV;
    private TextView lPW;
    private TextView lPX;
    private int lPZ;
    private View lPx;
    private String lQP;
    private int lQa;
    private v lQx;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mStatusBar;
    private View maA;
    private ValueAnimator maB;
    private ValueAnimator maC;
    public com.baidu.tieba.pb.videopb.b.a maD;
    private float maH;
    private float maI;
    private boolean maJ;
    private ObjectAnimator maN;
    private ObjectAnimator maO;
    private NewPagerSlidingTabBaseStrip maj;
    private VideoPbFragmentAdapter mak;
    private View mal;
    private View mam;
    private VideoContainerLayout man;
    private com.baidu.tieba.pb.videopb.videoView.a mao;
    private f maq;
    private View mar;
    private View mas;
    private TextView mau;
    private TextView mav;
    private ImageView maw;
    private TBSpecificationBtn may;
    private TbImageView maz;
    private RelativeLayout rootView;
    public static int maf = 0;
    public static int mag = 1;
    public static int mah = 0;
    public static int lQp = 3;
    public static int lQq = 0;
    public static int lQr = 3;
    public static int lQs = 4;
    public static int lQt = 5;
    public static int lQu = 6;
    private static final int jUZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int mai = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a lJg = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.g.b.a
        public void cW(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.doa();
            } else {
                com.baidu.tieba.pb.a.b.dnZ();
            }
        }
    };
    private long lHv = 0;
    private boolean lHC = false;
    View.OnClickListener mat = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.lBt == null || VideoPbFragment.this.lBt.dwV()) {
                if (VideoPbFragment.this.lBt != null) {
                    if (VideoPbFragment.this.lBt.isChushou) {
                        VideoPbFragment.this.eH(VideoPbFragment.this.lBt.thirdRoomId, VideoPbFragment.this.lBt.thirdLiveType);
                    } else {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = VideoPbFragment.this.lBt.dwW();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(VideoPbFragment.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_RECOMMEND, null, false, "")));
                    }
                    if (VideoPbFragment.this.dok() != null && VideoPbFragment.this.dok().getPbData() != null && VideoPbFragment.this.dok().getPbData().getForum() != null) {
                        TiebaStatic.log(new ar("c13713").dY("fid", VideoPbFragment.this.dok().getPbData().getForum().getId()).dY("fname", VideoPbFragment.this.dok().getPbData().getForum().getName()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("tid", VideoPbFragment.this.dok().getPbData().getThreadId()).w("obj_param1", VideoPbFragment.this.lBt.userId));
                        return;
                    }
                    return;
                }
                return;
            }
            TiebaStatic.log(new ar("c13590").dY("obj_id", VideoPbFragment.this.lBt.getTitle()).dY("obj_name", VideoPbFragment.this.lBt.dwS()).al("obj_type", 2).dY("fid", VideoPbFragment.this.dok().getPbData().getForumId()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("tid", VideoPbFragment.this.dok().getPbData().getThreadId()));
            String link = VideoPbFragment.this.lBt.getLink();
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
    private com.baidu.tbadk.baseEditMark.a lHS = null;
    private com.baidu.tbadk.coreExtra.model.a eTC = null;
    private ForumManageModel fXb = null;
    private boolean lHz = false;
    private View lPP = null;
    private TextView jYr = null;
    private boolean lPL = false;
    private String fwy = null;
    private boolean lHV = false;
    private boolean lHW = false;
    private boolean lHX = false;
    private boolean lHB = false;
    int[] lHI = new int[2];
    private int lHK = -1;
    private int lHL = Integer.MIN_VALUE;
    private int lIt = 0;
    private int maF = Integer.MIN_VALUE;
    private boolean bIA = false;
    private boolean lHP = com.baidu.tbadk.a.d.bkr();
    private final PbModel.a lIW = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.h sg;
            VideoPbFragment.this.dsA();
            VideoPbFragment.this.cYl();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.vy(false);
            if (z && fVar != null) {
                by dmT = fVar.dmT();
                ((e) y.b(VideoPbFragment.this.getActivity()).l(e.class)).c(fVar, i2);
                VideoPbFragment.this.M(fVar);
                com.baidu.tieba.pb.videopb.c.a dnz = fVar.dnz();
                if (dnz != null && !dnz.mcG) {
                    VideoPbFragment.this.a(dnz);
                }
                VideoPbFragment.this.N(fVar);
                VideoPbFragment.this.c(z, i, i2, i3, fVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.lHS != null) {
                    VideoPbFragment.this.lHS.iH(fVar.bkY());
                }
                AntiData anti = fVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.fwy = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.fwy) && VideoPbFragment.this.lIg != null && VideoPbFragment.this.lIg.bCn() != null && (sg = VideoPbFragment.this.lIg.bCn().sg(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.fwy)) {
                        ((View) sg).setOnClickListener(VideoPbFragment.this.fxl);
                    }
                }
                if (VideoPbFragment.this.kJC != null && dmT != null && dmT.boP() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(dmT.boP());
                    VideoPbFragment.this.kJC.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.dok().dqj());
                        jSONObject.put("fid", VideoPbFragment.this.dok().getForumId());
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
                if ((!com.baidu.tbadk.a.d.bkt() || VideoPbFragment.this.dvW() != null) && VideoPbFragment.this.dvU() != null) {
                    if (com.baidu.tbadk.a.d.bkt()) {
                        if (i != -1) {
                            ArrayList<PostData> arrayList = null;
                            if (VideoPbFragment.this.dok() != null && VideoPbFragment.this.dok().getPbData() != null) {
                                arrayList = VideoPbFragment.this.dok().getPbData().dmV();
                            }
                            if (com.baidu.tbadk.core.util.y.getCount(arrayList) == 0 || (com.baidu.tbadk.core.util.y.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).dPg() == 1)) {
                                if (VideoPbFragment.this.dvW().dpJ()) {
                                    VideoPbFragment.this.dvW().Qs(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.dvW().Qs(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.dvW().Qr(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.dvW().Qr("");
                        }
                        VideoPbFragment.this.dvW().endLoadData();
                    } else {
                        if (i != -1) {
                            ArrayList<PostData> arrayList2 = null;
                            if (VideoPbFragment.this.dok() != null && VideoPbFragment.this.dok().getPbData() != null) {
                                arrayList2 = VideoPbFragment.this.dok().getPbData().dmV();
                            }
                            if (com.baidu.tbadk.core.util.y.getCount(arrayList2) == 0 || (com.baidu.tbadk.core.util.y.getCount(arrayList2) == 1 && arrayList2.get(0) != null && arrayList2.get(0).dPg() == 1)) {
                                if (VideoPbFragment.this.dvU().dpJ()) {
                                    VideoPbFragment.this.dvU().Qs(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.dvU().Qs(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.dvU().Qr(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.dvU().Qr("");
                        }
                        VideoPbFragment.this.dvU().endLoadData();
                    }
                } else {
                    return;
                }
            }
            com.baidu.tieba.t.c.dOe().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0583a lIY = new a.InterfaceC0583a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0583a
        public void d(boolean z, boolean z2, String str) {
            VideoPbFragment.this.dsA();
            if (z && VideoPbFragment.this.dok() != null) {
                if (VideoPbFragment.this.lHS != null) {
                    VideoPbFragment.this.lHS.iH(z2);
                }
                VideoPbFragment.this.dok().vc(z2);
                if (VideoPbFragment.this.dok().bkY()) {
                    VideoPbFragment.this.dpu();
                } else if (com.baidu.tbadk.a.d.bkt() && VideoPbFragment.this.dvW() != null) {
                    VideoPbFragment.this.dvW().dwF();
                } else if (VideoPbFragment.this.dvU() != null) {
                    VideoPbFragment.this.dvU().dwF();
                }
                if (z2) {
                    if (VideoPbFragment.this.lHS != null) {
                        if (VideoPbFragment.this.lHS.blb() != null && VideoPbFragment.this.dok() != null && VideoPbFragment.this.dok().getPbData() != null && VideoPbFragment.this.dok().getPbData().dmT() != null && VideoPbFragment.this.dok().getPbData().dmT().boP() != null) {
                            MarkData blb = VideoPbFragment.this.lHS.blb();
                            MetaData boP = VideoPbFragment.this.dok().getPbData().dmT().boP();
                            if (blb != null && boP != null) {
                                if (!au.equals(TbadkCoreApplication.getCurrentAccount(), boP.getUserId()) && !boP.hadConcerned()) {
                                    VideoPbFragment.this.maD.b(boP);
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
                    VideoPbFragment.this.dpr();
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
            if (VideoPbFragment.this.kNk == null || VideoPbFragment.this.kNk.dts() == null || !VideoPbFragment.this.kNk.dts().dYo()) {
                return !VideoPbFragment.this.Hd(am.eTx);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kNk.dts().dYq());
            if (VideoPbFragment.this.lIg != null && (VideoPbFragment.this.lIg.bDi() || VideoPbFragment.this.lIg.bDj())) {
                VideoPbFragment.this.lIg.a(false, VideoPbFragment.this.kNk.dtv());
            }
            VideoPbFragment.this.kNk.vE(true);
            return true;
        }
    };
    private final CustomMessageListener lIA = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.dok() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.lIg != null) {
                    VideoPbFragment.this.vw(VideoPbFragment.this.lIg.bDb());
                }
                VideoPbFragment.this.dsb();
                VideoPbFragment.this.maD.dsR();
            }
        }
    };
    private CustomMessageListener lID = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
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
    private final CustomMessageListener iUw = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.64
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.bIA) {
                VideoPbFragment.this.dpM();
            }
        }
    };
    private CustomMessageListener lIX = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.65
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.dpl();
            }
        }
    };
    private CustomMessageListener lIP = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.66
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.maD != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.maD.lIo) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.maD.ckt();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.maD.getExtra();
                DataRes dataRes = aVar.nAK;
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
                    VideoPbFragment.this.maD.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.maD.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener lIN = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.maD != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.maD.lIo) {
                VideoPbFragment.this.maD.ckt();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.dok().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.dnj().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.lIn.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.maD.Ea(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.maD.dpI();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (au.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.lIn.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lIO = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.maD != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.maD.lIo) {
                VideoPbFragment.this.maD.ckt();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.lIn.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (au.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.lIn.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b lIl = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bCR() {
            if (VideoPbFragment.this.kNk == null || VideoPbFragment.this.kNk.dtt() == null || !VideoPbFragment.this.kNk.dtt().dYo()) {
                return !VideoPbFragment.this.Hd(am.eTy);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kNk.dtt().dYq());
            if (VideoPbFragment.this.lQx != null && VideoPbFragment.this.lQx.doV() != null && VideoPbFragment.this.lQx.doV().bDj()) {
                VideoPbFragment.this.lQx.doV().a(VideoPbFragment.this.kNk.dtv());
            }
            VideoPbFragment.this.kNk.vF(true);
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
                if (VideoPbFragment.this.dok() != null && VideoPbFragment.this.dok().getPbData() != null) {
                    arVar.dY("fid", VideoPbFragment.this.dok().getPbData().getForumId());
                }
                arVar.dY("tid", VideoPbFragment.this.dok().dqj());
                arVar.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            VideoPbFragment.this.cCE();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.dok() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.dok().Qm(postWriteCallBackData.getPostId());
                    if (com.baidu.tbadk.a.d.bkt() && VideoPbFragment.this.dvW() != null) {
                        VideoPbFragment.this.lIt = VideoPbFragment.this.dvW().dsC();
                        VideoPbFragment.this.maF = VideoPbFragment.this.dvW().dwI();
                        VideoPbFragment.this.dok().dg(VideoPbFragment.this.lIt, VideoPbFragment.this.maF);
                    } else if (VideoPbFragment.this.dvU() != null) {
                        VideoPbFragment.this.lIt = VideoPbFragment.this.dvU().dsC();
                        VideoPbFragment.this.maF = VideoPbFragment.this.dvU().dwI();
                        VideoPbFragment.this.dok().dg(VideoPbFragment.this.lIt, VideoPbFragment.this.maF);
                    }
                }
                if (VideoPbFragment.this.eRw != null) {
                    if (com.baidu.tbadk.a.d.bkt()) {
                        VideoPbFragment.this.eRw.setCurrentItem(VideoPbFragment.mah);
                    } else {
                        VideoPbFragment.this.eRw.setCurrentItem(VideoPbFragment.mag);
                    }
                }
                VideoPbFragment.this.maD.dsR();
                VideoPbFragment.this.kNk.dtr();
                if (VideoPbFragment.this.lIg != null) {
                    VideoPbFragment.this.vw(VideoPbFragment.this.lIg.bDb());
                }
                VideoPbFragment.this.drX();
                VideoPbFragment.this.vy(true);
                VideoPbFragment.this.dok().dqF();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null) {
                            if (com.baidu.tbadk.a.d.bkt() && VideoPbFragment.this.dvW() != null) {
                                VideoPbFragment.this.dvW().dwF();
                            } else if (VideoPbFragment.this.dvU() != null) {
                                VideoPbFragment.this.dvU().dwF();
                            }
                        }
                    } else if (VideoPbFragment.this.dok().getHostMode()) {
                        com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.dok().getPbData();
                        if (pbData != null && pbData.dmT() != null && pbData.dmT().boP() != null && (userId = pbData.dmT().boP().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.dok().dqw()) {
                            VideoPbFragment.this.dsy();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.dok().dqw()) {
                        VideoPbFragment.this.dsy();
                    }
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    videoPbFragment.uN(z2);
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.lIg.bDi() || VideoPbFragment.this.lIg.bDj()) {
                    VideoPbFragment.this.lIg.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.kNk.h(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.kJC != null) {
                    VideoPbFragment.this.kJC.a(postWriteCallBackData.getReplyPrivacyTip());
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
    private CustomMessageListener lIC = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.lIg != null) {
                    VideoPbFragment.this.vw(VideoPbFragment.this.lIg.bDb());
                }
                VideoPbFragment.this.vy(false);
            }
        }
    };
    private int maG = 0;
    private boolean maK = true;
    private View.OnTouchListener maL = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.maG == 1) {
                if (!VideoPbFragment.this.maK) {
                    VideoPbFragment.this.dvZ();
                    UtilHelper.showStatusBar(VideoPbFragment.this.dpQ(), VideoPbFragment.this.dpQ().getRootView());
                    VideoPbFragment.this.maK = true;
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(VideoPbFragment.this.maM);
                    com.baidu.adp.lib.f.e.mY().postDelayed(VideoPbFragment.this.maM, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (VideoPbFragment.this.maG == 2 && (VideoPbFragment.this.maK || VideoPbFragment.this.dwb())) {
                VideoPbFragment.this.dwa();
                UtilHelper.hideStatusBar(VideoPbFragment.this.dpQ(), VideoPbFragment.this.dpQ().getRootView());
                VideoPbFragment.this.maK = false;
                if (VideoPbFragment.this.mao != null) {
                    VideoPbFragment.this.mao.wa(false);
                }
            }
            VideoPbFragment.this.maG = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener jeY = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.maG = 0;
            VideoPbFragment.this.maH = 0.0f;
            VideoPbFragment.this.maI = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.maH += f;
            VideoPbFragment.this.maI += f2;
            if (VideoPbFragment.this.maG == 0 && !VideoPbFragment.this.maJ && VideoPbFragment.this.mao != null && !VideoPbFragment.this.mao.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.maI) <= Math.abs(VideoPbFragment.this.maH) || VideoPbFragment.this.maI > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.maI) > Math.abs(VideoPbFragment.this.maH) && VideoPbFragment.this.maI > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.maG = 2;
                    }
                } else {
                    VideoPbFragment.this.maG = 1;
                }
            }
            return true;
        }
    };
    private Runnable maM = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.maK && !VideoPbFragment.this.dwb()) {
                VideoPbFragment.this.dwa();
                UtilHelper.hideStatusBar(VideoPbFragment.this.dpQ(), VideoPbFragment.this.dpQ().getRootView());
                VideoPbFragment.this.maK = false;
            }
        }
    };
    private final com.baidu.adp.base.d ikt = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.dok() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.fXb.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.fXb.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.dok().dqF();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.lXw != 1002 || bVar.gZr) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.mSuccess, dVar.noI, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.fXb.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.fXb.getLoadDataMode(), gVar.mSuccess, gVar.noI, false);
                    VideoPbFragment.this.maD.bf(gVar.noL);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener fGd = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.iXO.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d lIU = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                ar arVar = new ar("c13268");
                arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.dok() != null && VideoPbFragment.this.dok().getPbData() != null) {
                    arVar.dY("fid", VideoPbFragment.this.dok().getPbData().getForumId());
                }
                if (VideoPbFragment.this.dok() != null) {
                    arVar.dY("tid", VideoPbFragment.this.dok().dqj());
                }
                arVar.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            if (z) {
                if (VideoPbFragment.this.kNk != null) {
                    VideoPbFragment.this.kNk.dtq();
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
                if (VideoPbFragment.this.kJC != null) {
                    VideoPbFragment.this.kJC.a(postWriteCallBackData.getReplyPrivacyTip());
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
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.kNk != null) {
                if (VideoPbFragment.this.lQx != null && VideoPbFragment.this.lQx.doV() != null && VideoPbFragment.this.lQx.doV().bDj()) {
                    VideoPbFragment.this.lQx.doV().a(postWriteCallBackData);
                }
                VideoPbFragment.this.kNk.i(postWriteCallBackData);
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
                    arVar.dY("tid", VideoPbFragment.this.dok().dqj());
                    arVar.dY("fid", VideoPbFragment.this.dok().getForumId());
                    arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.al("obj_locate", 1);
                    TiebaStatic.log(arVar);
                    if (VideoPbFragment.this.lHz) {
                        VideoPbFragment.this.lHz = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.dok() != null && VideoPbFragment.this.dok().getPbData() != null && VideoPbFragment.this.lHi != null && postData.boP() != null && postData.dPg() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.lQx != null) {
                                    VideoPbFragment.this.lQx.doR();
                                }
                                p pVar = new p();
                                pVar.a(VideoPbFragment.this.dok().getPbData().getForum());
                                pVar.setThreadData(VideoPbFragment.this.dok().getPbData().dmT());
                                pVar.g(postData);
                                VideoPbFragment.this.lHi.d(pVar);
                                VideoPbFragment.this.lHi.setPostId(postData.getId());
                                VideoPbFragment.this.a(view, postData.boP().getUserId(), "", postData);
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.dok().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.lIg != null) {
                                    VideoPbFragment.this.vw(VideoPbFragment.this.lIg.bDb());
                                }
                            }
                        }
                    }
                } else if ((VideoPbFragment.this.dvU() != null && VideoPbFragment.this.dvU().dsN() != null && view == VideoPbFragment.this.dvU().dsN()) || ((com.baidu.tbadk.a.d.bkt() && VideoPbFragment.this.dvW() != null && VideoPbFragment.this.dvW().dsN() != null && view == VideoPbFragment.this.dvW().dsN()) || view.getId() == R.id.pb_more)) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.dok().va(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        if (com.baidu.tbadk.a.d.bkt()) {
                            VideoPbFragment.this.dvW().dsz();
                        } else {
                            VideoPbFragment.this.dvU().dsz();
                        }
                    }
                } else if (VideoPbFragment.this.maD != null && VideoPbFragment.this.maD.dtY() != null && view == VideoPbFragment.this.maD.dtY().drv()) {
                    VideoPbFragment.this.maD.bca();
                } else if ((VideoPbFragment.this.maD != null && ((VideoPbFragment.this.maD.dtY() != null && view == VideoPbFragment.this.maD.dtY().drw()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) || view.getId() == R.id.floor_owner_reply || view.getId() == R.id.reply_title) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.maD.dsR();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.cCE();
                        VideoPbFragment.this.dsy();
                        if (view.getId() == R.id.owner_reply) {
                            C = VideoPbFragment.this.dok().C(true, VideoPbFragment.this.dpy());
                        } else {
                            C = view.getId() == R.id.all_reply ? VideoPbFragment.this.dok().C(false, VideoPbFragment.this.dpy()) : VideoPbFragment.this.dok().Qj(VideoPbFragment.this.dpy());
                        }
                        view.setTag(Boolean.valueOf(C));
                        if (C) {
                            VideoPbFragment.this.cYm();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.fEN) {
                    if (VideoPbFragment.this.dok() != null && VideoPbFragment.this.dok().getPbData() != null) {
                        if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            ar arVar2 = new ar("c13266");
                            arVar2.dY("uid", TbadkCoreApplication.getCurrentAccount());
                            arVar2.dY("fid", VideoPbFragment.this.dok().getPbData().getForumId());
                            arVar2.dY("tid", VideoPbFragment.this.dok().dqj());
                            arVar2.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(arVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.lHn, VideoPbFragment.this.fEN);
                        VideoPbFragment.this.lHn.finish();
                    }
                } else if (view == VideoPbFragment.this.jjn && VideoPbFragment.this.maD != null) {
                    if (VideoPbFragment.this.dok() == null || VideoPbFragment.this.dok().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> dmV = VideoPbFragment.this.dok().getPbData().dmV();
                    if ((dmV == null || dmV.size() <= 0) && VideoPbFragment.this.dok().dql()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new ar("c12378").dY("tid", VideoPbFragment.this.dok().dqj()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("fid", VideoPbFragment.this.dok().getForumId()));
                    VideoPbFragment.this.maD.dpm();
                } else if (VideoPbFragment.this.maD.dtY() != null && view == VideoPbFragment.this.maD.dtY().drA()) {
                    if (VideoPbFragment.this.dok() != null) {
                        VideoPbFragment.this.maD.dsR();
                        if (j.isNetWorkAvailable()) {
                            VideoPbFragment.this.cCE();
                            VideoPbFragment.this.dsy();
                            VideoPbFragment.this.dok().Hj(1);
                            return;
                        }
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    }
                } else if (VideoPbFragment.this.maD != null && VideoPbFragment.this.maD.dtY() != null && view == VideoPbFragment.this.maD.dtY().drw()) {
                    VideoPbFragment.this.maD.bca();
                } else if (VideoPbFragment.this.maD != null && ((VideoPbFragment.this.maD.dtY() != null && view == VideoPbFragment.this.maD.dtY().drD()) || view.getId() == R.id.pb_sort_type || view.getId() == R.id.pb_sort)) {
                    VideoPbFragment.this.maD.dsR();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.cCE();
                            VideoPbFragment.this.dsy();
                            VideoPbFragment.this.maD.dK(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.dok().dqD()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.maD != null && VideoPbFragment.this.maD.dtY() != null && view == VideoPbFragment.this.maD.dtY().dru()) {
                    if (VideoPbFragment.this.dok() != null && VideoPbFragment.this.dok().getPbData() != null && VideoPbFragment.this.dok().getPbData().dmT() != null) {
                        VideoPbFragment.this.maD.bca();
                        TiebaStatic.log(new ar("c13062"));
                        VideoPbFragment.this.maD.Qe(VideoPbFragment.this.dok().getPbData().dmT().bpg());
                    }
                } else if (view.getId() == R.id.pb_floor_feedback) {
                    try {
                        sparseArray = (SparseArray) view.getTag();
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                        sparseArray = null;
                    }
                    if (VideoPbFragment.this.maD != null) {
                        VideoPbFragment.this.maD.f(sparseArray);
                    }
                } else if (VideoPbFragment.this.maD != null && VideoPbFragment.this.maD.dtY() != null && view == VideoPbFragment.this.maD.dtY().drE()) {
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
                    VideoPbFragment.this.maD.dtX();
                } else if (VideoPbFragment.this.maD != null && (view == VideoPbFragment.this.maD.dsw() || (VideoPbFragment.this.maD.dtY() != null && (view == VideoPbFragment.this.maD.dtY().drz() || view == VideoPbFragment.this.maD.dtY().drx())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.dok() != null || VideoPbFragment.this.dok().getPbData() != null) {
                        if ((VideoPbFragment.this.dok().getPbData().dni() == 1 || VideoPbFragment.this.dok().getPbData().dni() == 3) && !VideoPbFragment.this.fXb.dQb()) {
                            VideoPbFragment.this.maD.dsR();
                            if (VideoPbFragment.this.maD.dtY() != null && view == VideoPbFragment.this.maD.dtY().drx()) {
                                if (VideoPbFragment.this.dok().getPbData().dmT().boK() == 1) {
                                    i2 = 5;
                                } else {
                                    i2 = 4;
                                }
                            } else if (VideoPbFragment.this.maD.dtY() != null && view == VideoPbFragment.this.maD.dtY().drz()) {
                                if (VideoPbFragment.this.dok().getPbData().dmT().boL() != 1) {
                                    i2 = 6;
                                }
                            } else {
                                i2 = view == VideoPbFragment.this.maD.dsw() ? 2 : 0;
                            }
                            ForumData forum = VideoPbFragment.this.dok().getPbData().getForum();
                            String name = forum.getName();
                            String id = forum.getId();
                            String id2 = VideoPbFragment.this.dok().getPbData().dmT().getId();
                            VideoPbFragment.this.showProgressBar();
                            VideoPbFragment.this.fXb.c(id, name, id2, i2, VideoPbFragment.this.maD.dsx());
                        }
                    }
                } else if (VideoPbFragment.this.maD != null && VideoPbFragment.this.maD.dtY() != null && view == VideoPbFragment.this.maD.dtY().drC()) {
                    if (VideoPbFragment.this.dok() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.maD.dsR();
                        SparseArray<Object> b = VideoPbFragment.this.b(VideoPbFragment.this.dok().getPbData(), VideoPbFragment.this.dok().dql(), 1);
                        if (b != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.dok().getPbData().getForum().getId(), VideoPbFragment.this.dok().getPbData().getForum().getName(), VideoPbFragment.this.dok().getPbData().dmT().getId(), String.valueOf(VideoPbFragment.this.dok().getPbData().getUserData().getUserId()), (String) b.get(R.id.tag_forbid_user_name), (String) b.get(R.id.tag_forbid_user_name_show), (String) b.get(R.id.tag_forbid_user_post_id), (String) b.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.maD != null && VideoPbFragment.this.maD.dtY() != null && view == VideoPbFragment.this.maD.dtY().dry()) {
                    if (VideoPbFragment.this.dok() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.dok().getPbData(), VideoPbFragment.this.dok().dql(), 1);
                        if (b2 != null) {
                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.maD.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.maD.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.maD.bca();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        ar arVar3 = new ar("c13398");
                        arVar3.dY("tid", VideoPbFragment.this.dok().dqj());
                        arVar3.dY("fid", VideoPbFragment.this.dok().getForumId());
                        arVar3.dY("uid", TbadkCoreApplication.getCurrentAccount());
                        arVar3.al("obj_locate", 4);
                        TiebaStatic.log(arVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new ar("c10517").al("obj_locate", 3).dY("fid", VideoPbFragment.this.dok().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.dok() != null && VideoPbFragment.this.dok().getPbData() != null) {
                        if (VideoPbFragment.this.maD != null) {
                            VideoPbFragment.this.maD.dsR();
                        }
                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                        PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                        PostData postData3 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                        if (postData2 != null) {
                            if (postData2.dPs() == 1) {
                                TiebaStatic.log(new ar("c12630"));
                            }
                            if (postData2.nmC != null) {
                                ar btS = postData2.nmC.btS();
                                btS.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    btS.al("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    btS.al("obj_locate", 8);
                                }
                                TiebaStatic.log(btS);
                            }
                            VideoPbFragment.this.cCE();
                            TiebaStatic.log("c11742");
                            if (postData3 != null) {
                                VideoPbFragment.this.a(postData2, postData3, false, true);
                            } else {
                                VideoPbFragment.this.a(postData2, (PostData) null, false, false);
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                    if (VideoPbFragment.this.dok() != null) {
                        if (view.getId() == R.id.pb_post_reply) {
                            ar arVar4 = new ar("c13398");
                            arVar4.dY("tid", VideoPbFragment.this.dok().dqj());
                            arVar4.dY("fid", VideoPbFragment.this.dok().getForumId());
                            arVar4.dY("uid", TbadkCoreApplication.getCurrentAccount());
                            arVar4.al("obj_locate", 6);
                            TiebaStatic.log(arVar4);
                        }
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData4 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                if (view.getId() == R.id.pb_post_reply && postData4.nmC != null) {
                                    ar btS2 = postData4.nmC.btS();
                                    btS2.delete("obj_locate");
                                    btS2.al("obj_locate", 8);
                                    TiebaStatic.log(btS2);
                                } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                    TiebaStatic.log(new ar("c13700").dY("tid", VideoPbFragment.this.dok().dqk()).dY("fid", VideoPbFragment.this.dok().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("post_id", postData4.getId()).al("obj_source", 1).al("obj_type", 3));
                                }
                                if (VideoPbFragment.this.dok() != null && VideoPbFragment.this.dok().getPbData() != null && VideoPbFragment.this.lHi != null && postData4.boP() != null && postData4.dPg() != 1) {
                                    if (VideoPbFragment.this.lQx != null) {
                                        VideoPbFragment.this.lQx.doR();
                                    }
                                    if ((VideoPbFragment.this.lHP || com.baidu.tbadk.a.d.bkh()) && postData4.dPd() != null && postData4.dPd().size() != 0) {
                                        if (com.baidu.tbadk.a.d.bki()) {
                                            VideoPbFragment.this.a(postData4, (PostData) null, false, false);
                                            return;
                                        } else {
                                            VideoPbFragment.this.a(postData4, (PostData) null, true, false);
                                            return;
                                        }
                                    }
                                    p pVar2 = new p();
                                    pVar2.a(VideoPbFragment.this.dok().getPbData().getForum());
                                    pVar2.setThreadData(VideoPbFragment.this.dok().getPbData().dmT());
                                    pVar2.g(postData4);
                                    VideoPbFragment.this.lHi.d(pVar2);
                                    VideoPbFragment.this.lHi.setPostId(postData4.getId());
                                    VideoPbFragment.this.a(view, postData4.boP().getUserId(), "", postData4);
                                    if (VideoPbFragment.this.lIg != null) {
                                        VideoPbFragment.this.vw(VideoPbFragment.this.lIg.bDb());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.maD != null && VideoPbFragment.this.dok() != null) {
                        if (com.baidu.tbadk.a.d.bkt() || VideoPbFragment.this.dvU() != null) {
                            if (!com.baidu.tbadk.a.d.bkt() || VideoPbFragment.this.dvW() != null) {
                                VideoPbFragment.this.maD.dsR();
                                if (VideoPbFragment.this.He(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.dok() != null) {
                                    VideoPbFragment.this.dpt();
                                    if (VideoPbFragment.this.dok().getPbData() != null && VideoPbFragment.this.dok().getPbData().dmT() != null && VideoPbFragment.this.dok().getPbData().dmT().boP() != null) {
                                        TiebaStatic.log(new ar("c13402").dY("tid", VideoPbFragment.this.dok().dqj()).dY("fid", VideoPbFragment.this.dok().getPbData().getForumId()).al("obj_locate", 3).dY("uid", VideoPbFragment.this.dok().getPbData().dmT().boP().getUserId()));
                                    }
                                    if (VideoPbFragment.this.dok().getPbData().dmT() != null && VideoPbFragment.this.dok().getPbData().dmT().boP() != null && VideoPbFragment.this.dok().getPbData().dmT().boP().getUserId() != null && VideoPbFragment.this.lHS != null) {
                                        int h = VideoPbFragment.this.maD.h(VideoPbFragment.this.dok().getPbData());
                                        by dmT = VideoPbFragment.this.dok().getPbData().dmT();
                                        if (!dmT.bnx()) {
                                            if (dmT.bny()) {
                                                i = 3;
                                            } else if (dmT.bqM()) {
                                                i = 4;
                                            } else {
                                                i = dmT.bqN() ? 5 : 1;
                                            }
                                        }
                                        TiebaStatic.log(new ar("c12526").dY("tid", VideoPbFragment.this.dok().dqj()).al("obj_locate", 1).dY("obj_id", VideoPbFragment.this.dok().getPbData().dmT().boP().getUserId()).al("obj_type", VideoPbFragment.this.lHS.bkY() ? 0 : 1).al("obj_source", h).al("obj_param1", i));
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.vY(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.dok() != null && VideoPbFragment.this.maD != null && VideoPbFragment.this.eRw != null && VideoPbFragment.this.dok().getPbData() != null && VideoPbFragment.this.dok().getPbData().dmT() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.dok().getPbData();
                        if (pbData.dmT().boG() != 0) {
                            int currentItem = VideoPbFragment.this.eRw.getCurrentItem();
                            if (!com.baidu.tbadk.a.d.bkt() && currentItem == VideoPbFragment.maf) {
                                VideoPbFragment.this.eRw.setCurrentItem(VideoPbFragment.mag);
                            } else if (com.baidu.tbadk.a.d.bkt() || currentItem == VideoPbFragment.mag) {
                                if (!com.baidu.tbadk.a.d.bkt() && VideoPbFragment.this.dvU() == null) {
                                    return;
                                }
                                if ((!com.baidu.tbadk.a.d.bkt() || VideoPbFragment.this.dvW() != null) && VideoPbFragment.this.cFw() != null) {
                                    ar dY = new ar("c13403").dY("tid", VideoPbFragment.this.dok().dqj()).dY("fid", VideoPbFragment.this.dok().getPbData().getForumId()).dY("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView cFw = VideoPbFragment.this.cFw();
                                    if (cFw != null) {
                                        boolean canScrollVertically = cFw.canScrollVertically(1);
                                        boolean canScrollVertically2 = cFw.canScrollVertically(-1);
                                        if (VideoPbFragment.this.Zj != null) {
                                            VideoPbFragment.this.Zj.setExpanded(false, true);
                                        }
                                        if (cFw.getLayoutManager() != null && (cFw.getLayoutManager() instanceof LinearLayoutManager)) {
                                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) cFw.getLayoutManager();
                                            if (!canScrollVertically2 && canScrollVertically) {
                                                if (VideoPbFragment.this.lHK != -1 || VideoPbFragment.this.lHL != Integer.MIN_VALUE) {
                                                    if (VideoPbFragment.this.lHK > 3 || (VideoPbFragment.this.lHK == 3 && VideoPbFragment.this.lHL < (-equipmentHeight))) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lHK, VideoPbFragment.this.lHL + equipmentHeight);
                                                        cFw.smoothScrollBy(0, equipmentHeight);
                                                    } else if (VideoPbFragment.this.lHK >= 2) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lHK, VideoPbFragment.this.lHL + (equipmentHeight / 2));
                                                        cFw.smoothScrollBy(0, equipmentHeight / 2);
                                                    } else if (VideoPbFragment.this.lHK == 1) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lHK, VideoPbFragment.this.lHL + (equipmentHeight / 4));
                                                        cFw.smoothScrollBy(0, equipmentHeight / 4);
                                                    } else {
                                                        cFw.smoothScrollBy(0, -VideoPbFragment.this.lHL);
                                                    }
                                                    dY.al("obj_locate", 2);
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                int firstVisiblePosition = cFw.getFirstVisiblePosition();
                                                View childAt = cFw.getChildAt(0);
                                                int top = childAt == null ? 0 : childAt.getTop();
                                                VideoPbFragment.this.lHK = firstVisiblePosition;
                                                VideoPbFragment.this.lHL = top;
                                                if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top < (-equipmentHeight) && cFw.getCount() >= 6)) {
                                                    linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                    cFw.smoothScrollToPosition(0);
                                                } else {
                                                    cFw.smoothScrollToPosition(0);
                                                }
                                                dY.al("obj_locate", 1);
                                            }
                                            TiebaStatic.log(dY);
                                            com.baidu.tbadk.pageExtra.c bM = com.baidu.tbadk.pageExtra.d.bM(view);
                                            ar arVar5 = new ar("c12942");
                                            arVar5.al("obj_type", 1);
                                            arVar5.al("obj_locate", 4);
                                            arVar5.dY("tid", VideoPbFragment.this.dok().dqj());
                                            arVar5.dY("nid", pbData.dmT().getNid());
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
                            if (VideoPbFragment.this.dok() != null && VideoPbFragment.this.dok().getPbData() != null && VideoPbFragment.this.dok().getPbData().dmT() != null && VideoPbFragment.this.dok().getPbData().dmT().boP() != null) {
                                TiebaStatic.log(new ar("c13402").dY("tid", VideoPbFragment.this.dok().dqj()).dY("fid", VideoPbFragment.this.dok().getPbData().getForumId()).al("obj_locate", 2).dY("uid", VideoPbFragment.this.dok().getPbData().dmT().boP().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.vZ(false);
                        VideoPbFragment.this.dph();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.lIt >= 0) {
                        if (VideoPbFragment.this.dok() != null) {
                            VideoPbFragment.this.dok().dqV();
                        }
                        if (com.baidu.tbadk.a.d.bkt() && VideoPbFragment.this.dvW() != null && VideoPbFragment.this.dvW().dwD() != null) {
                            VideoPbFragment.this.dvW().dwD().setData(VideoPbFragment.this.dok().getPbData());
                        } else if (VideoPbFragment.this.dok() != null && VideoPbFragment.this.dvU() != null && VideoPbFragment.this.dvU().dwD() != null) {
                            VideoPbFragment.this.dvU().dwD().setData(VideoPbFragment.this.dok().getPbData());
                        }
                        VideoPbFragment.this.lIt = 0;
                        VideoPbFragment.this.maF = Integer.MIN_VALUE;
                        if (com.baidu.tbadk.a.d.bkt() && VideoPbFragment.this.dok() != null && VideoPbFragment.this.dvW() != null) {
                            VideoPbFragment.this.dvW().dj(VideoPbFragment.this.dok().dqY(), VideoPbFragment.this.dok().dqZ());
                            VideoPbFragment.this.dok().dg(0, 0);
                        } else if (VideoPbFragment.this.dok() != null && VideoPbFragment.this.dvU() != null) {
                            VideoPbFragment.this.dvU().dj(VideoPbFragment.this.dok().dqY(), VideoPbFragment.this.dok().dqZ());
                            VideoPbFragment.this.dok().dg(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.dok() != null) {
                        ar arVar6 = new ar("c13398");
                        arVar6.dY("tid", VideoPbFragment.this.dok().dqj());
                        arVar6.dY("fid", VideoPbFragment.this.dok().getForumId());
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
                        VideoPbFragment.this.dsb();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.dsb();
                } else if (VideoPbFragment.this.maD.dtY() != null && view == VideoPbFragment.this.maD.dtY().drB()) {
                    VideoPbFragment.this.maD.dsR();
                    if (VideoPbFragment.this.dok() != null) {
                        VideoPbFragment.this.iko.setThreadId(VideoPbFragment.this.dok().dqj());
                    }
                    if (VideoPbFragment.this.dok() == null || !VideoPbFragment.this.dok().isPrivacy()) {
                        VideoPbFragment.this.iko.crC();
                        if (!TbSingleton.getInstance().mCanCallFans && VideoPbFragment.this.dok() != null && VideoPbFragment.this.dok().getPbData() != null && VideoPbFragment.this.dok().getPbData().getThreadId() != null && VideoPbFragment.this.dok().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                            i3 = 2;
                        }
                        if (VideoPbFragment.this.dok() != null && VideoPbFragment.this.dok().getPbData() != null) {
                            VideoPbFragment.this.iko.l(3, i3, VideoPbFragment.this.dok().getPbData().getThreadId());
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                    if (VideoPbFragment.this.dok().getPbData() != null) {
                        VideoPbFragment.this.iko.l(3, 3, VideoPbFragment.this.dok().getPbData().getThreadId());
                    }
                } else if (view.getId() == R.id.pb_floor_right_top_feedback || view.getId() == R.id.pb_post_op_more) {
                    ar arVar7 = new ar("c13398");
                    arVar7.dY("tid", VideoPbFragment.this.dok().dqj());
                    arVar7.dY("fid", VideoPbFragment.this.dok().getForumId());
                    arVar7.dY("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar7.al("obj_locate", 7);
                    TiebaStatic.log(arVar7);
                    VideoPbFragment.this.maD.wg(false);
                    VideoPbFragment.this.maD.dvL().onLongClick(view);
                }
            }
        }
    };
    private View.OnClickListener lED = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.maD != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.maD.c(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.maD.dD(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.maD.c(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.maD.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    private CustomMessageListener jhb = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
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
            VideoPbFragment.this.maD.wg(true);
            return VideoPbFragment.this.maD.dvL().onLongClick(view);
        }
    };
    public SortSwitchButton.a lIS = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean Az(int i) {
            if (VideoPbFragment.this.maD != null) {
                VideoPbFragment.this.maD.dsR();
            }
            if (!j.isNetWorkAvailable()) {
                VideoPbFragment.this.showToast(R.string.network_not_available);
                return false;
            } else if (VideoPbFragment.this.dok() == null || VideoPbFragment.this.dok().isLoading) {
                return false;
            } else {
                VideoPbFragment.this.cCE();
                VideoPbFragment.this.dsy();
                if (VideoPbFragment.this.dok().getPbData() != null && VideoPbFragment.this.dok().getPbData().lAJ != null && VideoPbFragment.this.dok().getPbData().lAJ.size() > i) {
                    int intValue = VideoPbFragment.this.dok().getPbData().lAJ.get(i).sort_type.intValue();
                    TiebaStatic.log(new ar("c13699").dY("tid", VideoPbFragment.this.dok().dqk()).dY("fid", VideoPbFragment.this.dok().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).al("obj_type", Hh(intValue)));
                    if (VideoPbFragment.this.dok().Ho(intValue)) {
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
    private a maE = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void dpr() {
        if (dok() != null && dok().getPbData() != null && dok().getPbData().dmT() != null) {
            by dmT = dok().getPbData().dmT();
            dmT.mRecomAbTag = dok().drf();
            dmT.mRecomWeight = dok().drd();
            dmT.mRecomSource = dok().dre();
            dmT.mRecomExtra = dok().drg();
            dmT.eMG = dok().dqr();
            if (dmT.getFid() == 0) {
                dmT.setFid(com.baidu.adp.lib.f.b.toLong(dok().getForumId(), 0L));
            }
            ar a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dmT, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uN(boolean z) {
        if (dok() != null && dok().getPbData() != null && dok().getPbData().dmT() != null) {
            by dmT = dok().getPbData().dmT();
            dmT.mRecomAbTag = dok().drf();
            dmT.mRecomWeight = dok().drd();
            dmT.mRecomSource = dok().dre();
            dmT.mRecomExtra = dok().drg();
            if (dmT.getFid() == 0) {
                dmT.setFid(com.baidu.adp.lib.f.b.toLong(dok().getForumId(), 0L));
            }
            ar a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dmT, "c13563");
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
            String string = !TextUtils.isEmpty(bVar.noI) ? bVar.noI : getString(R.string.delete_fail);
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
                a(0, bVar.mSuccess, bVar.noI, z);
            }
            if (bVar.mSuccess) {
                if (bVar.izO == 1) {
                    ArrayList<PostData> dmV = dok().getPbData().dmV();
                    int size = dmV.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(dmV.get(i).getId())) {
                            i++;
                        } else {
                            dmV.remove(i);
                            break;
                        }
                    }
                    dok().getPbData().dmT().oD(dok().getPbData().dmT().boG() - 1);
                    if (com.baidu.tbadk.a.d.bkt() && dvW() != null) {
                        dvW().dwF();
                    } else if (dvU() != null) {
                        dvU().dwF();
                    }
                } else if (bVar.izO == 0) {
                    dps();
                } else if (bVar.izO == 2) {
                    ArrayList<PostData> dmV2 = dok().getPbData().dmV();
                    int size2 = dmV2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= dmV2.get(i2).dPd().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(dmV2.get(i2).dPd().get(i3).getId())) {
                                i3++;
                            } else {
                                dmV2.get(i2).dPd().remove(i3);
                                dmV2.get(i2).dPf();
                                z2 = true;
                                break;
                            }
                        }
                        dmV2.get(i2).TG(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        if (com.baidu.tbadk.a.d.bkt() && dvW() != null) {
                            dvW().dwF();
                        } else if (dvU() != null) {
                            dvU().dwF();
                        }
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = dok().getPbData().dnh().lCq;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dPd().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dPd().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dPd().remove(i2);
                    list.get(i).dPf();
                    z = true;
                    break;
                }
            }
            list.get(i).TG(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            if (com.baidu.tbadk.a.d.bkt() && dvW() != null) {
                dvW().dwF();
            } else if (dvU() != null) {
                dvU().dwF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null && dok() != null && dok().getPbData() != null && dok().getPbData().dmT() != null) {
            a(this.fXb.getLoadDataMode(), gVar.mSuccess, gVar.noI, false);
            if (gVar.mSuccess) {
                this.lHV = true;
                if (i == 2 || i == 3) {
                    this.lHW = true;
                    this.lHX = false;
                } else if (i == 4 || i == 5) {
                    this.lHW = false;
                    this.lHX = true;
                }
                if (i == 2) {
                    dok().getPbData().dmT().oG(1);
                    dok().setIsGood(1);
                } else if (i == 3) {
                    dok().getPbData().dmT().oG(0);
                    dok().setIsGood(0);
                } else if (i == 4) {
                    dok().getPbData().dmT().oF(1);
                    dok().Hi(1);
                } else if (i == 5) {
                    dok().getPbData().dmT().oF(0);
                    dok().Hi(0);
                }
            }
            if (dok().getPbData().dmT() != null && dvV() != null) {
                dvV().dwP();
            }
        }
    }

    private void dps() {
        if (dok().dqm() || dok().dqo()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", dok().dqj());
            PbActivity pbActivity = this.lHn;
            PbActivity pbActivity2 = this.lHn;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, dok().dqj()));
        if (dpv()) {
            this.lHn.finish();
        }
    }

    private boolean dpv() {
        if (dok() == null) {
            return true;
        }
        if (dok().getPbData() == null || !dok().getPbData().dnx()) {
            if (dok().bkY()) {
                final MarkData dqE = dok().dqE();
                if (dqE == null || !dok().getIsFromMark() || cFw() == null) {
                    return true;
                }
                final MarkData Hp = dok().Hp(cFw().getFirstVisiblePosition());
                if (Hp == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", dqE);
                    this.lHn.setResult(-1, intent);
                    return true;
                } else if (Hp.getPostId() == null || Hp.getPostId().equals(dqE.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", dqE);
                    this.lHn.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.Bq(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.lHS != null) {
                                if (VideoPbFragment.this.lHS.bkY()) {
                                    VideoPbFragment.this.lHS.bkZ();
                                    VideoPbFragment.this.lHS.iH(false);
                                }
                                VideoPbFragment.this.lHS.a(Hp);
                                VideoPbFragment.this.lHS.iH(true);
                                VideoPbFragment.this.lHS.bla();
                            }
                            dqE.setPostId(Hp.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dqE);
                            VideoPbFragment.this.lHn.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.dox();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dqE);
                            VideoPbFragment.this.lHn.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.dox();
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
            } else if (dok().getPbData() == null || dok().getPbData().dmV() == null || dok().getPbData().dmV().size() <= 0 || !dok().getIsFromMark()) {
                return true;
            } else {
                this.lHn.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dox() {
        this.lHn.dox();
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
        if (dok() != null && this.maD != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = dok().getPbData()) != null) {
                by dmT = pbData.dmT();
                if (dmT != null && dmT.boP() != null) {
                    TiebaStatic.log(new ar("c13402").dY("tid", dok().dqj()).dY("fid", pbData.getForumId()).al("obj_locate", 4).dY("uid", dmT.boP().getUserId()));
                }
                if (dmT != null) {
                    if (dmT.bnx()) {
                        i = 2;
                    } else if (dmT.bny()) {
                        i = 3;
                    } else if (dmT.bqM()) {
                        i = 4;
                    } else if (dmT.bqN()) {
                        i = 5;
                    }
                    ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    arVar.dY("tid", dok().dqj());
                    arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.dY("fid", dok().getForumId());
                    if (!z) {
                        arVar.al("obj_locate", 6);
                    } else {
                        arVar.al("obj_locate", 5);
                    }
                    arVar.al("obj_name", i);
                    arVar.al("obj_type", 2);
                    if (dmT != null) {
                        if (dmT.bnx()) {
                            arVar.al("obj_type", 10);
                        } else if (dmT.bny()) {
                            arVar.al("obj_type", 9);
                        } else if (dmT.bqN()) {
                            arVar.al("obj_type", 8);
                        } else if (dmT.bqM()) {
                            arVar.al("obj_type", 7);
                        } else if (dmT.isShareThread) {
                            arVar.al("obj_type", 6);
                        } else if (dmT.threadType == 0) {
                            arVar.al("obj_type", 1);
                        } else if (dmT.threadType == 40) {
                            arVar.al("obj_type", 2);
                        } else if (dmT.threadType == 49) {
                            arVar.al("obj_type", 3);
                        } else if (dmT.threadType == 54) {
                            arVar.al("obj_type", 4);
                        } else {
                            arVar.al("obj_type", 5);
                        }
                        arVar.dY("nid", dmT.getNid());
                        arVar.al(IntentConfig.CARD_TYPE, dmT.bqQ());
                        arVar.dY(IntentConfig.RECOM_SOURCE, dmT.mRecomSource);
                        arVar.dY("ab_tag", dmT.mRecomAbTag);
                        arVar.dY("weight", dmT.mRecomWeight);
                        arVar.dY("extra", dmT.mRecomExtra);
                        arVar.dY("nid", dmT.getNid());
                        if (dmT.getBaijiahaoData() != null && !au.isEmpty(dmT.getBaijiahaoData().oriUgcVid)) {
                            arVar.dY("obj_param6", dmT.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        arVar.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    if (dpQ() != null) {
                        com.baidu.tbadk.pageInfo.c.b(dpQ(), arVar);
                    }
                    TiebaStatic.log(arVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (dok().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> dmV = pbData.dmV();
                        if ((dmV == null || dmV.size() <= 0) && dok().dql()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.maD.dsR();
                        cCE();
                        TiebaStatic.log(new ar("c11939"));
                        if (!AntiHelper.d(getContext(), dmT)) {
                            if (this.lPV != null) {
                                this.lPV.setEnable(false);
                                x(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                Hf(z ? 2 : 1);
                                return;
                            }
                            this.maD.showLoadingDialog();
                            dok().dqP().A(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                ar arVar2 = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                arVar2.dY("tid", dok().dqj());
                arVar2.dY("uid", TbadkCoreApplication.getCurrentAccount());
                arVar2.dY("fid", dok().getForumId());
                if (!z) {
                }
                arVar2.al("obj_name", i);
                arVar2.al("obj_type", 2);
                if (dmT != null) {
                }
                if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                if (dpQ() != null) {
                }
                TiebaStatic.log(arVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment dvB() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        e eVar = (e) y.b(getActivity()).l(e.class);
        M(eVar.dwh());
        N(eVar.dwh());
        if (dok() != null && dok().getPbData() != null) {
            boolean isFromMark = dok().getIsFromMark();
            com.baidu.tieba.pb.data.f pbData = dok().getPbData();
            if (isFromMark) {
                PostData L = L(pbData);
                if (pbData.bkX() != null && !pbData.bkX().equals(L.getId()) && this.eRw != null) {
                    if (com.baidu.tbadk.a.d.bkt()) {
                        this.eRw.setCurrentItem(mah);
                    } else {
                        this.eRw.setCurrentItem(mag);
                    }
                }
            }
        }
        eVar.dwi().observe(this, new q<by>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aQ */
            public void onChanged(@Nullable by byVar) {
                BdTypeRecyclerView cFw;
                if (byVar != null && byVar.bph() != null) {
                    if (VideoPbFragment.this.mao.getVideoUrl() == null || !VideoPbFragment.this.mao.getVideoUrl().equals(byVar.bph().video_url)) {
                        if (!au.isEmpty(VideoPbFragment.this.mao.getVideoUrl())) {
                            VideoPbFragment.this.lHB = true;
                            if (com.baidu.tbadk.a.d.bkt()) {
                                VideoPbFragment.this.eRw.setCurrentItem(VideoPbFragment.mah);
                            } else {
                                VideoPbFragment.this.eRw.setCurrentItem(VideoPbFragment.maf);
                            }
                            if (com.baidu.tbadk.a.d.bkt() && (cFw = VideoPbFragment.this.cFw()) != null) {
                                cFw.scrollToPosition(0);
                            }
                        }
                        if (VideoPbFragment.this.maq == null || !VideoPbFragment.this.maq.isPlaying()) {
                            VideoPbFragment.this.dvC();
                            VideoPbFragment.this.aP(byVar);
                        }
                        VideoPbFragment.this.dvD();
                        if (VideoPbFragment.this.maq.dwv()) {
                            VideoPbFragment.this.maq.start();
                        }
                        boolean z = !au.equals(VideoPbFragment.this.mao.getVideoUrl(), byVar.bph().video_url);
                        VideoPbFragment.this.mao.setData(byVar);
                        if (com.baidu.tbadk.a.d.bkt()) {
                            VideoPbFragment.this.mao.wi(false);
                        } else {
                            VideoPbFragment.this.mao.wi(VideoPbFragment.this.eRw.getCurrentItem() == 0);
                        }
                        if (z) {
                            VideoPbFragment.this.mao.startPlay();
                            VideoPbFragment.this.mao.dxg();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.mao.setData(byVar);
                }
            }
        });
        eVar.dwr().observe(this, new q<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: s */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.eRw.setCurrentItem(num.intValue());
            }
        });
        eVar.dwm().observe(this, new q<by>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aQ */
            public void onChanged(@Nullable by byVar) {
                VideoPbFragment.this.mao.aU(byVar);
            }
        });
        eVar.dwn().observe(this, new q<by>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aQ */
            public void onChanged(@Nullable by byVar) {
                VideoPbFragment.this.mao.aV(byVar);
            }
        });
        eVar.dwo().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: r */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.dvN();
            }
        });
        eVar.dwp().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: r */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvC() {
        ViewGroup.LayoutParams layoutParams = this.mas.getLayoutParams();
        layoutParams.height = 0;
        this.mas.setLayoutParams(layoutParams);
        this.mas.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvD() {
        if (this.maq == null) {
            this.maq = new f(getBaseFragmentActivity(), this.man);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(dpQ()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.man.getOriginHeight() + statusBarHeight);
            final e eVar = (e) y.b(getActivity()).l(e.class);
            this.maq.b(eVar.dwj(), rect);
            if (this.maq.dwv()) {
                this.maq.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (com.baidu.tbadk.a.d.bkt()) {
                            if (eVar.dwk() || VideoPbFragment.this.dok().dri() == VideoPbFragment.mah) {
                                VideoPbFragment.this.eRw.setCurrentItem(VideoPbFragment.mah);
                            }
                        } else if (eVar.dwk() || VideoPbFragment.this.dok().dri() == VideoPbFragment.mag) {
                            VideoPbFragment.this.eRw.setCurrentItem(VideoPbFragment.mag);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (com.baidu.tbadk.a.d.bkt()) {
                            if (eVar.dwk() || VideoPbFragment.this.dok().dri() == VideoPbFragment.mah) {
                                VideoPbFragment.this.eRw.setCurrentItem(VideoPbFragment.mah);
                            }
                        } else if (eVar.dwk() || VideoPbFragment.this.dok().dri() == VideoPbFragment.mag) {
                            VideoPbFragment.this.eRw.setCurrentItem(VideoPbFragment.mag);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (com.baidu.tbadk.a.d.bkt()) {
                if (eVar.dwk() || dok().dri() == mah) {
                    this.eRw.setCurrentItem(mah);
                }
            } else if (eVar.dwk() || dok().dri() == mag) {
                this.eRw.setCurrentItem(mag);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.maJ && (this.maK || dwb())) {
            dwa();
            UtilHelper.hideStatusBar(dpQ(), dpQ().getRootView());
            this.maK = false;
            if (this.mao != null) {
                this.mao.wa(false);
            }
        }
        if (i == 4) {
            return this.mao.dCt();
        }
        if (i == 24) {
            return this.mao.dxd();
        }
        if (i == 25) {
            return this.mao.dxe();
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
        Rect drh;
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
                int height = (dok() != null || (drh = dok().drh()) == null) ? ceil : drh.height();
                i = 0;
                layoutParams = this.man.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.man.setLayoutParams(layoutParams);
                this.man.setMaxHeight(ceil);
                this.man.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.man.setOriginHeight(height);
                if (!com.baidu.tbadk.a.d.bkt()) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.maj.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new RelativeLayout.LayoutParams(-1, mai);
                    } else {
                        layoutParams3.height = mai;
                    }
                    this.maj.setLayoutParams(layoutParams3);
                }
                layoutParams2 = (CoordinatorLayout.LayoutParams) this.Zj.getLayoutParams();
                if (!com.baidu.tbadk.a.d.bkt()) {
                    ceil += mai;
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
        if (dok() != null) {
        }
        i = 0;
        layoutParams = this.man.getLayoutParams();
        if (layoutParams != null) {
        }
        this.man.setLayoutParams(layoutParams);
        this.man.setMaxHeight(ceil2);
        this.man.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.man.setOriginHeight(height);
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
        this.lHv = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        at(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.lIn = new com.baidu.tbadk.core.view.c();
        this.lIn.toastTime = 1000L;
        if (this.maD != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.maD.lIo;
            userMuteAddAndDelCustomMessage.setTag(this.maD.lIo);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.maD.lIo;
            userMuteCheckCustomMessage.setTag(this.maD.lIo);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        this.iko = new com.baidu.tieba.callfans.a(getPageContext());
        com.baidu.tieba.t.c.dOe().z(getUniqueId());
    }

    private void initData() {
        this.lHS = com.baidu.tbadk.baseEditMark.a.a(this.lHn);
        if (this.lHS != null) {
            this.lHS.a(this.lIY);
        }
        this.fXb = new ForumManageModel(this.lHn);
        this.fXb.setLoadDataCallBack(this.ikt);
        this.eTC = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.maD = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void at(Bundle bundle) {
        this.lIf = new g();
        d(this.lIf);
        this.lIg = (com.baidu.tbadk.editortools.pb.e) this.lIf.eN(getActivity());
        this.lIg.a(this.lHn.getPageContext());
        this.lIg.a(this.fwI);
        this.lIg.a(this.fwB);
        this.lIg.setFrom(1);
        this.lIg.a(this.lHn.getPageContext(), bundle);
        this.lIg.bCn().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.lIg.bCn().ks(true);
        uM(true);
        this.lIg.a(dok().dqA(), dok().dqj(), dok().dqR());
        registerListener(this.lID);
        registerListener(this.lIX);
        registerListener(this.lIC);
        registerListener(this.lIA);
        registerListener(this.iUw);
        if (!dok().dqr()) {
            this.lIg.DV(dok().dqj());
        }
        if (dok().dqS()) {
            this.lIg.DT(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.lIg.DT(dsd());
        }
        this.kNk = new bb();
        if (this.lIg.bCT() != null) {
            this.kNk.e(this.lIg.bCT().getInputView());
        }
        this.lIg.a(this.fwC);
        this.kJC = new am(getPageContext());
        this.kJC.a(new am.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // com.baidu.tbadk.core.util.am.a
            public void r(boolean z, int i) {
                if (z) {
                    if (i == am.eTx) {
                        VideoPbFragment.this.lIg.a((String) null, (WriteData) null);
                    } else if (i == am.eTy && VideoPbFragment.this.lQx != null && VideoPbFragment.this.lQx.doV() != null) {
                        VideoPbFragment.this.lQx.doV().bDr();
                    } else if (i == am.eTz) {
                        VideoPbFragment.this.c(VideoPbFragment.this.lIj);
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
        this.iXO = new com.baidu.tieba.g.b(getActivity());
        this.iXO.a(lJg);
        this.maJ = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        bFP();
        this.Zj = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.mal = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.man = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.mao = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.man);
        this.mao.setStageType("2002");
        this.mao.setUniqueId(getUniqueId());
        this.mao.af(this);
        this.mao.dL(dpQ().getRootView());
        this.mao.dM(this.mar);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.maj = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.mas = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.eRw = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.mam = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.mam.setOnClickListener(this.aGQ);
        dvF();
        dvE();
        dvG();
        this.mak = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.eRw.setAdapter(this.mak);
        this.maj.setViewPager(this.eRw);
        this.maj.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (com.baidu.tbadk.a.d.bkt() && VideoPbFragment.this.dvW() != null) {
                        VideoPbFragment.this.dvW().wh(false);
                    } else if (VideoPbFragment.this.dvU() != null) {
                        VideoPbFragment.this.dvU().wh(false);
                    }
                    if (VideoPbFragment.this.dvV() != null) {
                        VideoPbFragment.this.dvV().wh(true);
                        VideoPbFragment.this.HP(VideoPbFragment.this.dvV().dwJ() != 0 ? 0 : 8);
                    }
                    e eVar = (e) y.b(VideoPbFragment.this.getActivity()).l(e.class);
                    if (eVar.dwo() != null && eVar.dwo().getValue() != null && eVar.dwo().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.mao.wi(z);
                    VideoPbFragment.this.dsb();
                    if (VideoPbFragment.this.dok() != null && VideoPbFragment.this.dok().getPbData() != null) {
                        TiebaStatic.log(new ar("c13592").dY("tid", VideoPbFragment.this.dok().dqj()).dY("fid", VideoPbFragment.this.dok().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.dvV() != null) {
                        VideoPbFragment.this.dvV().wh(false);
                    }
                    if (com.baidu.tbadk.a.d.bkt() && VideoPbFragment.this.dvW() != null) {
                        VideoPbFragment.this.dvW().wh(true);
                        int dwJ = VideoPbFragment.this.dvW().dwJ();
                        int dwK = VideoPbFragment.this.dvW().dwK();
                        if (dwJ != 0) {
                            VideoPbFragment.this.HP(8);
                            VideoPbFragment.this.dvW().HP(0);
                        } else if (dwK != 0) {
                            VideoPbFragment.this.dvW().HP(8);
                            VideoPbFragment.this.HP(0);
                        } else {
                            VideoPbFragment.this.dvW().HP(8);
                            VideoPbFragment.this.HP(8);
                        }
                    } else if (VideoPbFragment.this.dvU() != null) {
                        VideoPbFragment.this.dvU().wh(true);
                        int dwJ2 = VideoPbFragment.this.dvU().dwJ();
                        int dwK2 = VideoPbFragment.this.dvU().dwK();
                        if (dwJ2 != 0) {
                            VideoPbFragment.this.HP(8);
                            VideoPbFragment.this.dvU().HP(0);
                        } else if (dwK2 != 0) {
                            VideoPbFragment.this.dvU().HP(8);
                            VideoPbFragment.this.HP(0);
                        } else {
                            VideoPbFragment.this.dvU().HP(8);
                            VideoPbFragment.this.HP(8);
                        }
                    }
                    VideoPbFragment.this.mao.wi(false);
                    VideoPbFragment.this.Zj.setExpanded(false, true);
                    if (VideoPbFragment.this.dok() != null && VideoPbFragment.this.dok().getPbData() != null) {
                        TiebaStatic.log(new ar("c13593").dY("tid", VideoPbFragment.this.dok().dqj()).dY("fid", VideoPbFragment.this.dok().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.mak.HR(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.lPx = this.rootView.findViewById(R.id.viewstub_progress);
        dvH();
        bWU();
        if (!this.maJ && this.maK) {
            dwa();
            UtilHelper.hideStatusBar(dpQ(), dpQ().getRootView());
            this.maK = false;
        }
        if (com.baidu.tbadk.a.d.bkt()) {
            this.maj.getLayoutParams().height = 0;
        }
    }

    private void dvE() {
        this.mau = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.maz = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.mav = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.maw = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.may = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.maA = this.rootView.findViewById(R.id.ala_live_point);
        this.maz.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.maz.setConrers(15);
        this.may.setConfig(new com.baidu.tbadk.core.view.commonBtn.c());
        this.maw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPbFragment.this.lBt == null || VideoPbFragment.this.lBt.dwV()) {
                    if (VideoPbFragment.this.lBt != null) {
                        TiebaStatic.log(new ar("c13608").dY("tid", VideoPbFragment.this.dok().getPbData().getThreadId()));
                        VideoPbFragment.this.lBt.mcG = true;
                    }
                } else {
                    TiebaStatic.log(new ar("c13591"));
                }
                VideoPbFragment.this.dvP();
            }
        });
        this.may.setOnClickListener(this.mat);
        this.mas.setOnClickListener(this.mat);
    }

    private void dvF() {
        this.maj.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.maj.setContainerLayoutParams(layoutParams);
        this.maj.setRectPaintColor(R.color.CAM_X0302);
        this.maj.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.maj.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.maj.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.maj.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.maj.setExpandedTabLayoutParams(layoutParams2);
    }

    public void vZ(boolean z) {
        if (this.Zj != null) {
            this.Zj.setExpanded(z);
        }
    }

    private void dvG() {
        this.lPO = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.lPP = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.lPZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.lQa = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.lPR = (HeadImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lPR.setVisibility(0);
        this.lPR.setIsRound(true);
        this.lPR.setBorderWidth(l.getDimens(getContext(), R.dimen.L_X01));
        this.lPR.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.lPR.setPlaceHolder(0);
        dsh();
        this.jYr = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.lPQ = (LinearLayout) this.rootView.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lPQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.vZ(false);
                VideoPbFragment.this.dph();
                if (VideoPbFragment.this.dok() != null && VideoPbFragment.this.dok().getPbData() != null && VideoPbFragment.this.dok().getPbData().dmT() != null && VideoPbFragment.this.dok().getPbData().dmT().boP() != null) {
                    TiebaStatic.log(new ar("c13701").dY("tid", VideoPbFragment.this.dok().dqk()).dY("fid", VideoPbFragment.this.dok().getPbData().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new ar("c13402").dY("tid", VideoPbFragment.this.dok().dqj()).dY("fid", VideoPbFragment.this.dok().getPbData().getForumId()).al("obj_locate", 1).dY("uid", VideoPbFragment.this.dok().getPbData().dmT().boP().getUserId()));
                }
            }
        });
        this.lPS = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.lPS.setOnClickListener(this.aGQ);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.lPT = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.lPT.setOnClickListener(this.aGQ);
        if (booleanExtra) {
            this.lPT.setVisibility(8);
        } else {
            this.lPT.setVisibility(0);
        }
        this.lPU = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.lPU.setOnClickListener(this.aGQ);
        this.lPV = new com.baidu.tieba.pb.view.d(this.lPU);
        this.lPV.dxp();
        this.lPW = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.lPW.setVisibility(0);
        vy(false);
    }

    private void dsh() {
        if (this.lPR != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lPR.setImageResource(0);
            this.lPR.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            return;
        }
        this.lPR.setImageResource(R.drawable.transparent_bg);
    }

    private void bFP() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.cCF();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.mar = this.rootView.findViewById(R.id.status_bar_background);
        if (this.maJ) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(dpQ());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.mar.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(dpQ());
            this.mar.setLayoutParams(layoutParams2);
            this.mar.setVisibility(0);
        }
        this.fEN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aGQ);
        this.gOj = (ImageView) this.fEN.findViewById(R.id.widget_navi_back_button);
        SvgManager.btW().a(this.gOj, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jjn = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.aGQ);
        this.ahT = (ImageView) this.jjn.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.jjn.setLayoutParams(layoutParams3);
        SvgManager.btW().a(this.ahT, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jjn.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.jeY);
        this.mNavigationBar.setOnTouchListener(this.maL);
    }

    public void dvH() {
        setEditorTools(this.lIg.bCn());
    }

    private void bWU() {
        this.lHi = new PbFakeFloorModel(getPageContext());
        this.lQx = new v(getPageContext(), this.lHi, this.rootView);
        this.lQx.T(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.dsb();
            }
        });
        this.lQx.a(this.lIU);
        this.lHi.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                VideoPbFragment.this.lHi.u(postData);
                if (com.baidu.tbadk.a.d.bkt() || VideoPbFragment.this.dvW() != null) {
                    VideoPbFragment.this.dvW().dwF();
                } else if (VideoPbFragment.this.dvU() != null) {
                    VideoPbFragment.this.dvU().dwF();
                }
                VideoPbFragment.this.lQx.doR();
                VideoPbFragment.this.acn.bAK();
                VideoPbFragment.this.vy(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, PostData postData2, boolean z, boolean z2) {
        PbActivity.a Qh;
        String dqj = dok().dqj();
        String id = postData.getId();
        String str = "";
        if (postData2 != null) {
            str = postData2.getId();
        }
        int i = 0;
        if (dok().getPbData() != null) {
            i = dok().getPbData().dni();
        }
        if (dvU() != null && dvU().dwH() != null) {
            Qh = dvU().dwH().Qh(id);
        } else if (dvW() != null && dvW().dwH() != null) {
            Qh = dvW().dwH().Qh(id);
        } else {
            return;
        }
        if (postData != null && dok() != null && dok().getPbData() != null && Qh != null) {
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(dqj, id, "pb", true, null, false, str, i, postData.duY(), dok().getPbData().getAnti(), false, postData.boP().getIconInfo()).addBigImageData(Qh.lDY, Qh.eCN, Qh.eCL, Qh.index);
            if (z2) {
                addBigImageData.setHighLightPostId(str);
                addBigImageData.setKeyIsUseSpid(true);
            }
            addBigImageData.setKeyFromForumId(dok().getForumId());
            addBigImageData.setBjhData(dok().dqt());
            addBigImageData.setKeyPageStartFrom(dok().dqU());
            addBigImageData.setFromFrsForumId(dok().getFromForumId());
            addBigImageData.setIsOpenEditor(z);
            if (dok().getPbData().dnD() != null) {
                addBigImageData.setHasForumRule(dok().getPbData().dnD().has_forum_rule.intValue());
            }
            if (dok().getPbData().getUserData() != null) {
                addBigImageData.setIsManager(dok().getPbData().getUserData().getIs_manager());
            }
            if (dok().getPbData().getForum().getDeletedReasonInfo() != null) {
                addBigImageData.setDeletedReasonInfoIsGrayCaleForum(dok().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                addBigImageData.setDeletedReasonInfoIsIsBoomGrow(dok().getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue());
            }
            if (dok().getPbData().getForum() != null) {
                addBigImageData.setForumHeadUrl(dok().getPbData().getForum().getImage_url());
                addBigImageData.setUserLevel(dok().getPbData().getForum().getUser_level());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.lHn = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (dok() != null) {
            dok().aD(bundle);
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
        this.mao.rJ(true);
        if (dok() != null && !dok().dqr()) {
            this.lIg.DU(dok().dqj());
        }
        com.baidu.tbadk.BdToken.c.biD().biO();
        MessageManager.getInstance().unRegisterListener(this.lIN);
        MessageManager.getInstance().unRegisterListener(this.lIO);
        MessageManager.getInstance().unRegisterListener(this.lIP);
        MessageManager.getInstance().unRegisterListener(this.jhb);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bIA = false;
        getVoiceManager().onResume(getPageContext());
        this.mao.rJ(false);
        dpM();
        registerListener(this.lIN);
        registerListener(this.lIO);
        registerListener(this.lIP);
        registerListener(this.jhb);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.mak != null && this.eRw != null) {
            this.mak.HR(z ? this.eRw.getCurrentItem() : -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        dsh();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.t.c.dOe().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.t.c.dOe().A(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.lPV != null) {
            this.lPV.onDestroy();
        }
        if (this.fXb != null) {
            this.fXb.cancelLoadData();
        }
        if (this.mao != null) {
            this.mao.onDestroy();
        }
        if (this.lHG != null) {
            this.lHG.cancelLoadData();
        }
        if (this.kJC != null) {
            this.kJC.onDestroy();
        }
        if (dok() != null) {
            dok().cancelLoadData();
            dok().destory();
            if (dok().dqO() != null) {
                dok().dqO().onDestroy();
            }
        }
        if (this.lIg != null) {
            this.lIg.onDestroy();
        }
        this.lIn = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.lHn);
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        ap.setBackgroundColor(this.mStatusBar, R.color.CAM_X0611);
        ap.setBackgroundColor(this.mar, R.color.CAM_X0608);
        ap.setBackgroundColor(this.maj, R.color.CAM_X0207);
        if (this.maj != null) {
            this.maj.onChangeSkinType();
        }
        if (this.kNk != null) {
            this.kNk.onChangeSkinType();
        }
        if (this.maq == null || !this.maq.isPlaying()) {
            ap.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        }
        if (this.acn != null) {
            this.acn.onChangeSkinType(i);
        }
        if (this.lQx != null) {
            this.lQx.onChangeSkinType(i);
        }
        if (this.lPR != null) {
            this.lPR.setBorderColor(ap.getColor(R.color.CAM_X0401));
        }
        if (this.lPQ != null) {
            this.lPQ.setBackgroundDrawable(ap.aR(l.getDimens(getContext(), R.dimen.tbds47), ap.getColor(R.color.CAM_X0209)));
        }
        if (dok() != null && dok().bkY()) {
            WebPManager.a(this.lPT, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.a(this.lPT, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.a(this.lPS, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        SvgManager.btW().a(this.maw, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (dok() != null) {
            x(dok().getPbData());
        }
        ap.setBackgroundResource(this.mal, R.drawable.personalize_tab_shadow);
        ap.setBackgroundColor(this.mas, R.color.CAM_X0206);
        ap.setBackgroundColor(this.lPP, R.color.CAM_X0207);
        ap.setBackgroundColor(this.lPO, R.color.CAM_X0203);
        ap.setViewTextColor(this.mav, R.color.CAM_X0109);
        ap.setViewTextColor(this.mau, R.color.CAM_X0105);
        ap.setViewTextColor(this.jYr, R.color.CAM_X0109);
        ap.setViewTextColor(this.lPX, R.color.CAM_X0105);
        ap.setViewTextColor(this.lPW, R.color.CAM_X0107);
        ap.d(this.lPW, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        if (com.baidu.tbadk.a.d.bkt() && dvW() != null) {
            dvW().onChangeSkinType(i);
        } else if (dvU() != null) {
            dvU().onChangeSkinType(i);
        }
        if (dvV() != null) {
            dvV().onChangeSkinType(i);
        }
        if (this.maA != null) {
            this.maA.setBackgroundDrawable(ap.aR(l.getDimens(this.maA.getContext(), R.dimen.tbds32), ap.getColor(R.color.CAM_X0309)));
        }
        cCE();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iSU == null) {
            this.iSU = VoiceManager.instance();
        }
        return this.iSU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCE() {
        if (this.iSU != null) {
            this.iSU.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment dpO() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment dpP() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel dok() {
        return this.lHn.dok();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity dpQ() {
        return this.lHn;
    }

    public com.baidu.tbadk.baseEditMark.a dvI() {
        return this.lHS;
    }

    public View.OnClickListener dvJ() {
        return this.aGQ;
    }

    public View.OnClickListener dvK() {
        return this.lED;
    }

    public View.OnLongClickListener dvL() {
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

    public BdTypeRecyclerView cFw() {
        Iterator<BaseFragment> it = this.mak.dwf().iterator();
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
        this.lIg.kA(z);
        this.lIg.kB(z);
        this.lIg.kC(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.maD != null) {
            if (z) {
                this.maD.dsR();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.maD.dsS();
            } else {
                this.maD.dsR();
            }
        }
    }

    public boolean Hd(int i) {
        if (this.kJC == null || dok() == null || dok().getPbData() == null || dok().getPbData().getAnti() == null) {
            return true;
        }
        return this.kJC.aQ(dok().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean dpj() {
        if ((dok() != null && dok().getPbData().dnx()) || this.kJC == null || dok() == null || dok().getPbData() == null || dok().getPbData().getAnti() == null) {
            return true;
        }
        return this.kJC.pP(dok().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && dok() != null) {
            gVar.setForumName(dok().dod());
            if (dok().getPbData() != null && dok().getPbData().getForum() != null) {
                gVar.a(dok().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(dok());
        }
    }

    public void dss() {
        if (this.acn != null) {
            this.acn.su();
            if (this.lIg != null) {
                this.lIg.bCY();
            }
            dta();
        }
    }

    public com.baidu.tbadk.editortools.pb.e doW() {
        return this.lIg;
    }

    private boolean dpg() {
        PbModel dok = dok();
        if (dok == null || dok.getPbData() == null) {
            return false;
        }
        by dmT = dok.getPbData().dmT();
        dok.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), dmT);
    }

    public void dph() {
        if (checkUpIsLogin() && dok() != null && dok().getPbData() != null && dok().getPbData().getForum() != null && !dpg()) {
            if (dok().getPbData().dnx()) {
                cQX();
                return;
            }
            if (this.iXo == null) {
                this.iXo = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.iXo.Bo(0);
                this.iXo.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qi(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void C(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qj(boolean z) {
                        if (z) {
                            if (VideoPbFragment.this.lIg != null && VideoPbFragment.this.lIg.bCn() != null) {
                                VideoPbFragment.this.lIg.bCn().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            VideoPbFragment.this.cQX();
                        }
                    }
                });
            }
            this.iXo.G(dok().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(dok().dqj(), 0L));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.lIg.onActivityResult(i, i2, intent);
        if (this.lHG != null) {
            this.lHG.onActivityResult(i, i2, intent);
        }
        if (this.lQx != null) {
            this.lQx.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    dpt();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.p.a.dEK().F(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.lIj = emotionImageData;
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
        if (dpQ() != null) {
            if (this.maK && !TbSingleton.getInstance().isNotchScreen(dpQ()) && !TbSingleton.getInstance().isCutoutScreen(dpQ())) {
                dwa();
                UtilHelper.hideStatusBar(dpQ(), dpQ().getRootView());
                this.maK = false;
            }
            this.maE.maZ = z;
            dvM();
            dvN();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.lHn;
        if (i == 0) {
            drX();
            if (this.lQx != null) {
                this.lQx.doR();
            }
            vy(false);
        }
        dsb();
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
                        this.lIg.resetData();
                        this.lIg.setVoiceModel(pbEditorData.getVoiceModel());
                        this.lIg.b(writeData);
                        m sj = this.lIg.bCn().sj(6);
                        if (sj != null && sj.fub != null) {
                            sj.fub.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.lHn;
                        if (i == -1) {
                            this.lIg.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.lQx != null && this.lQx.doV() != null) {
                            com.baidu.tbadk.editortools.pb.h doV = this.lQx.doV();
                            doV.setThreadData(dok().getPbData().dmT());
                            doV.b(writeData);
                            doV.setVoiceModel(pbEditorData.getVoiceModel());
                            m sj2 = doV.bCn().sj(6);
                            if (sj2 != null && sj2.fub != null) {
                                sj2.fub.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.lHn;
                            if (i == -1) {
                                doV.bDr();
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
                if (dok() != null && !dok().dqr()) {
                    antiData.setBlock_forum_name(dok().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(dok().getPbData().getForum().getId());
                    antiData.setUser_name(dok().getPbData().getUserData().getUserName());
                    antiData.setUser_id(dok().getPbData().getUserData().getUserId());
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
            if (this.maD != null) {
                this.maD.Ea(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void dpS() {
        if (dok() != null && this.lHn != null) {
            if (this.lIg == null || !this.lIg.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.lIg = (com.baidu.tbadk.editortools.pb.e) dVar.eN(getContext());
                this.lIg.a(this.lHn.getPageContext());
                this.lIg.a(this.fwI);
                this.lIg.a(this.fwB);
                this.lIg.a(this.lHn.getPageContext(), this.lHn.getIntent() == null ? null : this.lHn.getIntent().getExtras());
                this.lIg.bCn().ks(true);
                setEditorTools(this.lIg.bCn());
                if (!dok().dqr()) {
                    this.lIg.DV(dok().dqj());
                }
                if (dok().dqS()) {
                    this.lIg.DT(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.lIg.DT(dsd());
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
                VideoPbFragment.this.dsb();
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
                            VideoPbFragment.this.lIg.c((u) aVar.data);
                            VideoPbFragment.this.lIg.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        drX();
        this.lIg.a(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47
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
                if (VideoPbFragment.this.kNk != null && VideoPbFragment.this.kNk.dts() != null) {
                    if (!VideoPbFragment.this.kNk.dts().dYp()) {
                        VideoPbFragment.this.kNk.vE(false);
                    }
                    VideoPbFragment.this.kNk.dts().zc(false);
                }
            }
        });
    }

    public void cQX() {
        if (!checkUpIsLogin()) {
            if (dok() != null) {
                TiebaStatic.log(new ar("c10517").al("obj_locate", 2).dY("fid", dok().getForumId()));
            }
        } else if (dpj()) {
            if (this.lIg != null && (this.lIg.bDi() || this.lIg.bDj())) {
                this.lIg.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.acn != null) {
                dss();
                this.maE.maY = false;
                if (this.acn.sj(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.acn.sj(2).fub, false, null);
                }
            }
            dta();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !dpg() && dpj()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.lHI);
                this.lHJ = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.lQx != null && postData != null) {
                String str3 = "";
                if (postData.dPi() != null) {
                    str3 = postData.dPi().toString();
                }
                this.lQx.Qb(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.boP().getName_show(), str3));
            }
            if (dok() != null && dok().getPbData() != null && dok().getPbData().dnx()) {
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.lHn.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.lHI[1] + VideoPbFragment.this.lHJ) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cFw() != null) {
                            VideoPbFragment.this.cFw().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.lQx != null) {
                            VideoPbFragment.this.lIg.bCn().setVisibility(8);
                            VideoPbFragment.this.lQx.h(str, str2, VideoPbFragment.this.dsd(), (VideoPbFragment.this.dok() == null || VideoPbFragment.this.dok().getPbData() == null || VideoPbFragment.this.dok().getPbData().dmT() == null || !VideoPbFragment.this.dok().getPbData().dmT().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h doV = VideoPbFragment.this.lQx.doV();
                            if (doV != null && VideoPbFragment.this.dok() != null && VideoPbFragment.this.dok().getPbData() != null) {
                                doV.a(VideoPbFragment.this.dok().getPbData().getAnti());
                                doV.setThreadData(VideoPbFragment.this.dok().getPbData().dmT());
                            }
                            if (VideoPbFragment.this.kNk.dtu() == null && VideoPbFragment.this.lQx.doV().bDz() != null) {
                                VideoPbFragment.this.lQx.doV().bDz().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kNk != null && VideoPbFragment.this.kNk.dtt() != null) {
                                            if (!VideoPbFragment.this.kNk.dtt().dYp()) {
                                                VideoPbFragment.this.kNk.vF(false);
                                            }
                                            VideoPbFragment.this.kNk.dtt().zc(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kNk.f(VideoPbFragment.this.lQx.doV().bDz().getInputView());
                                VideoPbFragment.this.lQx.doV().a(VideoPbFragment.this.lIl);
                            }
                        }
                        VideoPbFragment.this.dta();
                    }
                }, 0L);
                return;
            }
            if (this.lIi == null) {
                this.lIi = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.lIi.Bo(1);
                this.lIi.a(new AnonymousClass49(str, str2));
            }
            if (dok() != null && dok().getPbData() != null && dok().getPbData().getForum() != null) {
                this.lIi.G(dok().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(dok().dqj(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$49  reason: invalid class name */
    /* loaded from: classes22.dex */
    public class AnonymousClass49 implements c.a {
        final /* synthetic */ String lJq;
        final /* synthetic */ String lJr;

        AnonymousClass49(String str, String str2) {
            this.lJq = str;
            this.lJr = str2;
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
                        int i = (VideoPbFragment.this.lHI[1] + VideoPbFragment.this.lHJ) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cFw() != null) {
                            VideoPbFragment.this.cFw().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.lQx != null) {
                            VideoPbFragment.this.lIg.bCn().setVisibility(8);
                            VideoPbFragment.this.lQx.h(AnonymousClass49.this.lJq, AnonymousClass49.this.lJr, VideoPbFragment.this.dsd(), (VideoPbFragment.this.dok() == null || VideoPbFragment.this.dok().getPbData() == null || VideoPbFragment.this.dok().getPbData().dmT() == null || !VideoPbFragment.this.dok().getPbData().dmT().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h doV = VideoPbFragment.this.lQx.doV();
                            if (doV != null && VideoPbFragment.this.dok() != null && VideoPbFragment.this.dok().getPbData() != null) {
                                doV.a(VideoPbFragment.this.dok().getPbData().getAnti());
                                doV.setThreadData(VideoPbFragment.this.dok().getPbData().dmT());
                            }
                            if (VideoPbFragment.this.kNk.dtu() == null && VideoPbFragment.this.lQx.doV().bDz() != null) {
                                VideoPbFragment.this.lQx.doV().bDz().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kNk != null && VideoPbFragment.this.kNk.dtt() != null) {
                                            if (!VideoPbFragment.this.kNk.dtt().dYp()) {
                                                VideoPbFragment.this.kNk.vF(false);
                                            }
                                            VideoPbFragment.this.kNk.dtt().zc(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kNk.f(VideoPbFragment.this.lQx.doV().bDz().getInputView());
                                VideoPbFragment.this.lQx.doV().a(VideoPbFragment.this.lIl);
                            }
                        }
                        VideoPbFragment.this.dta();
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dni()));
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dni()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bu> dnq = fVar.dnq();
                if (com.baidu.tbadk.core.util.y.getCount(dnq) > 0) {
                    sb = new StringBuilder();
                    for (bu buVar : dnq) {
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
    public void dpt() {
        MarkData Hp;
        if (dok() != null && dok().getPbData() != null) {
            if (com.baidu.tbadk.a.d.bkt() || dvU() != null) {
                if ((!com.baidu.tbadk.a.d.bkt() || dvW() != null) && this.lHS != null) {
                    if (dok().getPbData() != null && dok().getPbData().dnx()) {
                        Hp = dok().Hp(0);
                    } else if (this.eRw != null && this.eRw.getCurrentItem() == maf) {
                        Hp = dok().o(L(dok().getPbData()));
                    } else if (com.baidu.tbadk.a.d.bkt()) {
                        Hp = dok().Hp(dvW().dsD());
                    } else {
                        Hp = dok().Hp(dvU().dsD());
                    }
                    if (Hp != null) {
                        if (!Hp.isApp() || (Hp = dok().Hp(dvU().dsD() + 1)) != null) {
                            dsy();
                            this.lHS.a(Hp);
                            if (!this.lHS.bkY()) {
                                this.lHS.bla();
                                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                                return;
                            }
                            this.lHS.bkZ();
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
            if (this.lHG == null) {
                this.lHG = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.lHn);
                this.lHG.b(this.fwB);
                this.lHG.c(this.fwI);
            }
            this.lHG.a(emotionImageData, dok(), dok().getPbData());
        }
    }

    public PostData L(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dng() != null) {
            return fVar.dng();
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dmV())) {
            Iterator<PostData> it = fVar.dmV().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dPg() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dnc();
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
        if (fVar == null || fVar.dmT() == null || fVar.dmT().boP() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData boP = fVar.dmT().boP();
        String userId = boP.getUserId();
        HashMap<String, MetaData> userMap = fVar.dmT().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = boP;
        }
        postData.KV(1);
        postData.setId(fVar.dmT().bpg());
        postData.setTitle(fVar.dmT().getTitle());
        postData.setTime(fVar.dmT().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dpy() {
        ArrayList<PostData> dmV;
        int count;
        int i;
        if (dok() == null || dok().getPbData() == null || dok().getPbData().dmV() == null || (count = com.baidu.tbadk.core.util.y.getCount((dmV = dok().getPbData().dmV()))) == 0) {
            return "";
        }
        if (dok().dqC()) {
            Iterator<PostData> it = dmV.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dPg() == 1) {
                    return next.getId();
                }
            }
        }
        if (cFw() == null) {
            i = 0;
        } else if (com.baidu.tbadk.a.d.bkt()) {
            i = dvW().dsC();
        } else {
            i = dvU().dsC();
        }
        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(dmV, i);
        if (postData == null || postData.boP() == null) {
            return "";
        }
        if (dok().Qk(postData.boP().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(dmV, i2);
            if (postData2 == null || postData2.boP() == null || postData2.boP().getUserId() == null) {
                break;
            } else if (dok().Qk(postData2.boP().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(dmV, i3);
            if (postData3 == null || postData3.boP() == null || postData3.boP().getUserId() == null) {
                return "";
            }
            if (dok().Qk(postData3.boP().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpu() {
        if (dok() != null) {
            com.baidu.tieba.pb.data.f pbData = dok().getPbData();
            dok().vc(true);
            if (this.lHS != null) {
                pbData.PV(this.lHS.bkX());
            }
            if (com.baidu.tbadk.a.d.bkt() && dvW() != null) {
                dvW().dwF();
            } else if (dvU() != null) {
                dvU().dwF();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (dok() != null) {
            dsA();
            dok().vc(z);
            if (this.lHS != null) {
                this.lHS.iH(z);
                if (markData != null) {
                    this.lHS.a(markData);
                }
            }
            if (dok().bkY()) {
                dpu();
            } else if (com.baidu.tbadk.a.d.bkt() && dvW() != null) {
                dvW().dwF();
            } else if (dvU() != null) {
                dvU().dwF();
            }
        }
    }

    public void b(p pVar) {
        boolean z;
        MetaData metaData;
        if (dok() != null && dok().getPbData() != null && pVar.dnM() != null) {
            String id = pVar.dnM().getId();
            ArrayList<PostData> dmV = dok().getPbData().dmV();
            int i = 0;
            while (true) {
                if (i >= dmV.size()) {
                    z = true;
                    break;
                }
                PostData postData = dmV.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> dnU = pVar.dnU();
                    postData.KU(pVar.getTotalCount());
                    if (postData.dPd() == null || dnU == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = dnU.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.boP() != null && (metaData = postData.getUserMap().get(next.boP().getUserId())) != null) {
                                next.a(metaData);
                                next.yc(true);
                                next.a(getPageContext(), dok().Qk(metaData.getUserId()));
                            }
                        }
                        z = dnU.size() != postData.dPd().size();
                        if (postData.dPd() != null && postData.dPd().size() < 2) {
                            postData.dPd().clear();
                            postData.dPd().addAll(dnU);
                        }
                    }
                    if (postData.dOZ() != null) {
                        postData.dPa();
                    }
                }
            }
            if (!dok().getIsFromMark() && z) {
                if (com.baidu.tbadk.a.d.bkt() && dvW() != null) {
                    dvW().dwF();
                } else if (dvU() != null) {
                    dvU().dwF();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpl() {
        if (dok() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.SQ(dok().getForumId()) && dok().getPbData() != null && dok().getPbData().getForum() != null) {
            if (dok().getPbData().getForum().isLike() == 1) {
                dok().dqQ().gn(dok().getForumId(), dok().dqj());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            by dmT = fVar.dmT();
            if (dmT != null && dmT.bnz()) {
                dpS();
            } else {
                d(this.lIf);
            }
            if (this.lIg != null) {
                vw(this.lIg.bDb());
                this.lIg.a(fVar.getAnti());
                this.lIg.a(fVar.getForum(), fVar.getUserData());
                this.lIg.setThreadData(dmT);
                if (dok() != null) {
                    this.lIg.a(dok().dqA(), dok().dqj(), dok().dqR());
                }
                if (dmT != null) {
                    this.lIg.kD(dmT.bqo());
                }
            }
        }
    }

    public void dsb() {
        reset();
        drX();
        this.lQx.doR();
        vy(false);
    }

    private void reset() {
        if (this.lIg != null && this.acn != null) {
            com.baidu.tbadk.editortools.pb.a.bCQ().setStatus(0);
            this.lIg.bDl();
            this.lIg.bCA();
            if (this.lIg.getWriteImagesInfo() != null) {
                this.lIg.getWriteImagesInfo().setMaxImagesAllowed(this.lIg.isBJH ? 1 : 9);
            }
            this.lIg.st(SendView.ALL);
            this.lIg.su(SendView.ALL);
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
        if (fVar != null && fVar.dmT() != null) {
            x(fVar);
            this.lPT.setVisibility(fVar.dnx() ? 8 : 0);
            if (fVar.bkY()) {
                WebPManager.a(this.lPT, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.lPT, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String Hx = Hx(fVar.dmT().boG());
            if (this.lPW != null) {
                this.lPW.setText(Hx);
            }
            if (this.lPX != null) {
                this.lPX.setText(Hx);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.dmT()));
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.bb(fVar.dmT())) {
            if (this.lPV != null) {
                this.lPV.setEnable(false);
                this.lPV.onDestroy();
            }
            ViewGroup.LayoutParams layoutParams = this.lPU.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.lPU.setLayoutParams(layoutParams);
            WebPManager.a(this.lPU, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (this.lPV == null || !this.lPV.isEnable()) {
            ViewGroup.LayoutParams layoutParams2 = this.lPU.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.lPU.setLayoutParams(layoutParams2);
            WebPManager.a(this.lPU, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
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
        if (this.lPP != null) {
            vw(this.lIg.bDb());
            if (this.lPL) {
                vn(z);
            } else {
                vo(z);
            }
            dvM();
            dvN();
        }
    }

    public void dta() {
        if (this.lPP != null) {
            this.lPO.setVisibility(8);
            this.lPP.setVisibility(8);
            this.maE.maY = false;
            dvM();
            dvN();
        }
    }

    private void dvM() {
        if (this.mao != null) {
            if (this.maE.dwe()) {
                this.mao.xa(false);
            } else {
                this.mao.xa(this.mao.caj() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvN() {
        if (this.mao != null && this.eRw != null) {
            if (com.baidu.tbadk.a.d.bkt()) {
                this.mao.wi(false);
            } else if (this.eRw.getCurrentItem() != 0) {
                this.mao.wi(false);
            } else if (this.maE.dwe()) {
                this.mao.wi(false);
            } else {
                e eVar = (e) y.b(getActivity()).l(e.class);
                if (eVar != null) {
                    this.mao.wi(eVar.dwo() == null || eVar.dwo().getValue() == null || eVar.dwo().getValue().booleanValue());
                }
            }
        }
    }

    private void Hf(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(dpQ(), dpk(), i);
    }

    private int dpk() {
        if (dok() == null || dok().getPbData() == null || dok().getPbData().dmT() == null) {
            return -1;
        }
        return dok().getPbData().dmT().bpC();
    }

    public void vw(boolean z) {
        this.lPL = z;
    }

    public void vn(boolean z) {
        if (this.lPP != null && this.jYr != null) {
            this.jYr.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lPP.startAnimation(alphaAnimation);
            }
            this.lPO.setVisibility(0);
            this.lPP.setVisibility(0);
            this.maE.maY = true;
        }
    }

    public void vo(boolean z) {
        if (this.lPP != null && this.jYr != null) {
            this.jYr.setText(dsd());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lPP.startAnimation(alphaAnimation);
            }
            this.lPO.setVisibility(0);
            this.lPP.setVisibility(0);
            this.maE.maY = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null && this.lBt == null) {
            this.lBt = aVar;
            this.mau.setText(aVar.getTitle());
            this.mav.setText(aVar.dwS());
            String dwT = aVar.dwT();
            TBSpecificationBtn tBSpecificationBtn = this.may;
            if (TextUtils.isEmpty(dwT)) {
                dwT = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(dwT);
            this.maz.startLoad(aVar.getImage(), 10, false);
            this.maA.setVisibility(aVar.dwV() ? 0 : 8);
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoPbFragment.this.lBt == null || VideoPbFragment.this.lBt.dwV()) {
                        if (VideoPbFragment.this.lBt != null && VideoPbFragment.this.dok() != null && VideoPbFragment.this.dok().getPbData() != null && VideoPbFragment.this.dok().getPbData().getForum() != null) {
                            TiebaStatic.log(new ar("c13712").dY("fid", VideoPbFragment.this.dok().getPbData().getForum().getId()).dY("fname", VideoPbFragment.this.dok().getPbData().getForum().getName()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("tid", VideoPbFragment.this.dok().getPbData().getThreadId()).w("obj_param1", VideoPbFragment.this.lBt.userId));
                        }
                    } else {
                        TiebaStatic.log(new ar("c13608").dY("obj_id", VideoPbFragment.this.lBt.getTitle()).dY("obj_name", VideoPbFragment.this.lBt.dwS()).al("obj_type", 2).dY("fid", VideoPbFragment.this.dok().getPbData().getForumId()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("tid", VideoPbFragment.this.dok().getPbData().getThreadId()));
                    }
                    VideoPbFragment.this.dvO();
                }
            }, aVar.dwU().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvO() {
        ViewGroup.LayoutParams layoutParams = this.mas.getLayoutParams();
        if (layoutParams != null) {
            if (this.maB == null || !this.maB.isRunning()) {
                this.mas.setAlpha(0.0f);
                this.mas.setVisibility(0);
                e(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvP() {
        if (this.mas.getLayoutParams() != null) {
            if (this.maB == null || !this.maB.isRunning()) {
                dvQ();
            }
        }
    }

    private void dvQ() {
        final ViewGroup.LayoutParams layoutParams = this.mas.getLayoutParams();
        if (layoutParams != null) {
            if (this.maC == null || !this.maC.isRunning()) {
                this.maC = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.maC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.mas.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.maC.setDuration(200L);
                this.maC.start();
                this.maC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
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
        this.maB = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.maB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.jUZ);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.jUZ);
                VideoPbFragment.this.mas.setLayoutParams(layoutParams);
                VideoPbFragment.this.Zj.setLayoutParams(layoutParams2);
            }
        });
        this.maB.setDuration(300L);
        this.maB.start();
        this.maB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.mas.setVisibility(8);
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
        this.maB = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.maB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.jUZ);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.mas.setLayoutParams(layoutParams);
                VideoPbFragment.this.Zj.setLayoutParams(layoutParams2);
            }
        });
        this.maB.setDuration(300L);
        this.maB.start();
        this.maB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.dvR();
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
    public void dvR() {
        this.maB = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.maB.setDuration(300L);
        this.maB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.mas.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.maB.start();
    }

    public String dsd() {
        if (!au.isEmpty(this.lQP)) {
            return this.lQP;
        }
        this.lQP = TbadkCoreApplication.getInst().getResources().getString(com.baidu.tieba.pb.pb.main.ay.drT());
        return this.lQP;
    }

    public void dsA() {
        hideProgressBar();
        if (com.baidu.tbadk.a.d.bkt() && dvW() != null) {
            dvW().endLoadData();
            dvW().dsB();
        } else if (dvU() != null) {
            dvU().endLoadData();
            dvU().dsB();
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
                    if (dok() == null || dok().getPbData() == null) {
                        return true;
                    }
                    if (this.lQx != null) {
                        this.lQx.doR();
                    }
                    p pVar = new p();
                    pVar.a(dok().getPbData().getForum());
                    pVar.setThreadData(dok().getPbData().dmT());
                    pVar.g(postData);
                    this.lHi.d(pVar);
                    this.lHi.setPostId(postData.getId());
                    a(view, postData.boP().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.lIg != null) {
                        vw(this.lIg.bDb());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void dvS() {
        if (this.lIg != null) {
            vw(this.lIg.bDb());
        }
        dsb();
        this.maD.dsR();
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

    public void cYm() {
        if (this.lPx != null) {
            this.lPx.setVisibility(0);
        }
    }

    public void cYl() {
        if (this.lPx != null) {
            this.lPx.setVisibility(8);
        }
    }

    public void HP(int i) {
        if (this.mal != null) {
            this.mal.setVisibility(i);
        }
    }

    public void dsy() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a dpo() {
        return this.lIW;
    }

    public void drX() {
        if (this.acn != null) {
            this.acn.hide();
        }
    }

    public void cCF() {
        if (this.lHn.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.lHn.getCurrentFocus());
        }
    }

    public void N(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmT() != null) {
            String valueOf = String.valueOf(fVar.dmT().boG());
            if (fVar.dmT().boG() == 0) {
                valueOf = "";
            }
            this.maj.Fa(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        for (BaseFragment baseFragment : this.mak.dwf()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, fVar, str, i4);
            }
        }
        b(z, i, i2, i3, fVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (dok() != null && dok().getPbData() != null && dok().getPbData().dmT() != null && dok().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(lQq)).intValue();
                if (intValue == lQr) {
                    if (!this.fXb.dQb()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.fXb.TT(au.S(jSONArray));
                        }
                        this.fXb.a(dok().getPbData().getForum().getId(), dok().getPbData().getForum().getName(), dok().getPbData().dmT().getId(), str, intValue3, intValue2, booleanValue, dok().getPbData().dmT().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == lQs || intValue == lQu) {
                    if (dok().dqN() != null) {
                        dok().dqN().GY(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == lQs) {
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
                /* renamed from: cwK */
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
                /* renamed from: dpT */
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
                    ((PlayVoiceBntNew) view).ccz();
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
                /* renamed from: dpV */
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
            /* renamed from: dpU */
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
        this.lHz = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        if (be.Qw(str) && dok() != null && dok().dqj() != null) {
            TiebaStatic.log(new ar("c11664").al("obj_param1", 1).dY("post_id", dok().dqj()));
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
            be.dtw().f(getPageContext(), str);
        }
        this.lHz = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ay(Context context, String str) {
        be.dtw().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.lHz = true;
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
            this.maD.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b dwB = this.maD.dwB();
            if (dwB == null) {
                this.maD.dpf();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                dwB.getItemView(1).setVisibility(8);
            } else {
                dwB.getItemView(1).setVisibility(0);
            }
            dwB.brx();
            this.lHz = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aB(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            bf.bua().b(getPageContext(), new String[]{str});
            this.lHz = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a dvT() {
        return this.eTC;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener bGL() {
        return this.fGd;
    }

    public ReplyFragment dvU() {
        if (this.mak == null || !(this.mak.HQ(mag) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.mak.HQ(mag);
    }

    public DetailInfoFragment dvV() {
        if (this.mak == null || !(this.mak.HQ(maf) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.mak.HQ(maf);
    }

    public DetailInfoAndReplyFragment dvW() {
        if (this.mak == null || !(this.mak.HQ(mah) instanceof DetailInfoAndReplyFragment)) {
            return null;
        }
        return (DetailInfoAndReplyFragment) this.mak.HQ(mah);
    }

    public boolean doc() {
        PbModel dok = this.lHn.dok();
        if (dok == null) {
            return false;
        }
        return dok.doc();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData dnf;
        PbModel dok = this.lHn.dok();
        if (dok != null && dok.getPbData() != null && !dok.getPbData().dnx()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = dok.getPbData().dmT().getId();
            if (dok.isShareThread() && dok.getPbData().dmT().eLH != null) {
                historyMessage.threadName = dok.getPbData().dmT().eLH.showText;
            } else {
                historyMessage.threadName = dok.getPbData().dmT().getTitle();
            }
            if (dok.isShareThread() && !doc()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = dok.getPbData().getForum().getName();
            }
            ArrayList<PostData> dmV = dok.getPbData().dmV();
            int dsC = dvU() != null ? dvU().dsC() : 0;
            if (dmV != null && dsC >= 0 && dsC < dmV.size()) {
                historyMessage.postID = dmV.get(dsC).getId();
            }
            historyMessage.isHostOnly = dok.getHostMode();
            historyMessage.isSquence = dok.dql();
            historyMessage.isShareThread = dok.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.lIg != null) {
            this.lIg.onDestroy();
        }
        if (dok != null && (dok.dqm() || dok.dqo())) {
            Intent intent = new Intent();
            intent.putExtra("tid", dok.dqj());
            if (this.lHV) {
                if (this.lHX) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", dok.cuT());
                }
                if (this.lHW) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", dok.getIsGood());
                }
            }
            if (dok.getPbData() != null && System.currentTimeMillis() - this.lHv >= 40000 && (dnf = dok.getPbData().dnf()) != null && !com.baidu.tbadk.core.util.y.isEmpty(dnf.getDataList())) {
                intent.putExtra("guess_like_data", dnf);
            }
            PbActivity pbActivity = this.lHn;
            PbActivity pbActivity2 = this.lHn;
            pbActivity.setResult(-1, intent);
        }
        if (dpv()) {
            if (dok != null) {
                com.baidu.tieba.pb.data.f pbData = dok.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.lHB) {
                        if (this.man != null) {
                            Rect rect = new Rect();
                            this.man.getGlobalVisibleRect(rect);
                            as.drI().h(rect);
                        }
                        as.drI().Ht(this.eRw.getCurrentItem());
                        BdTypeRecyclerView cFw = cFw();
                        Parcelable parcelable = null;
                        if (cFw != null) {
                            parcelable = cFw.onSaveInstanceState();
                        }
                        as.drI().a(dok.dqu(), parcelable, dok.dql(), dok.getHostMode(), false);
                    }
                }
            } else {
                as.drI().reset();
            }
            dox();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mao != null && !this.mao.caj()) {
            if ((this.mao.isFullScreen() && configuration.orientation == 1) || (!this.mao.isFullScreen() && configuration.orientation == 2)) {
                this.mao.wj(false);
            }
        }
    }

    public boolean dvX() {
        if (this.mao == null) {
            return false;
        }
        return this.mao.caj();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.t.c.dOe().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a {
        public boolean maY;
        public boolean maZ;

        private a() {
            this.maZ = true;
        }

        public boolean dwe() {
            return (this.maY && this.maZ) ? false : true;
        }
    }

    public void dvY() {
        this.lHK = -1;
        this.lHL = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpM() {
        if (dok() != null && !au.isEmpty(dok().dqj())) {
            com.baidu.tbadk.BdToken.c.biD().p(com.baidu.tbadk.BdToken.b.evv, com.baidu.adp.lib.f.b.toLong(dok().dqj(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.mam.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvZ() {
        if (this.maN == null) {
            this.maN = ObjectAnimator.ofFloat(this.mar, "alpha", 0.0f, 1.0f);
            this.maN.setDuration(200L);
        }
        this.maN.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwa() {
        if (this.maO == null) {
            this.maO = ObjectAnimator.ofFloat(this.mar, "alpha", 1.0f, 0.0f);
            this.maO.setDuration(200L);
        }
        this.maO.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dwb() {
        return this.mao != null && this.mao.dwc();
    }

    public boolean dwc() {
        return this.maK;
    }

    public void wa(boolean z) {
        this.maK = z;
    }

    public void uT(boolean z) {
        this.lHC = z;
    }

    public boolean dpK() {
        return this.lHC;
    }
}
