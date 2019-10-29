package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.c;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.Agree;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class PostData implements com.baidu.adp.widget.ListView.m, ae {
    private Agree agree;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private long cdR;
    private int cdT;
    private SkinInfo cdo;
    private String cdr;
    private OriginalThreadInfo cec;
    private TbRichTextVoiceInfo crA;
    private String hIE;
    private String hJp;
    private SmallTailInfo icW;
    private ArrayList<PostData> jiB;
    private com.baidu.tbadk.data.c jiI;
    private com.baidu.tbadk.data.f jiJ;
    private i jiM;
    private bd jiN;
    public boolean jiP;
    private com.baidu.tbadk.widget.richText.f jiQ;
    private String jiR;
    private String jiS;
    private TPointPost jiT;
    public int jiW;
    public AlaLiveInfoCoreData jjb;
    private boolean jjf;
    private boolean jji;
    public an jjk;
    public int locate;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId jin = BdUniqueId.gen();
    public static final BdUniqueId jio = BdUniqueId.gen();
    public static final BdUniqueId cdp = BdUniqueId.gen();
    public static final BdUniqueId jip = BdUniqueId.gen();
    public static final BdUniqueId cbI = BdUniqueId.gen();
    public static final BdUniqueId jiq = BdUniqueId.gen();
    public static final BdUniqueId jir = BdUniqueId.gen();
    public static final BdUniqueId jis = BdUniqueId.gen();
    public static final BdUniqueId jit = BdUniqueId.gen();
    public static final BdUniqueId jiu = BdUniqueId.gen();
    public static boolean jiv = false;
    private int jiw = 0;
    private boolean jiC = false;
    private ArrayList<PostData> jiD = null;
    private TbRichText jiE = null;
    private boolean jiH = false;
    private boolean jiK = false;
    private boolean jiL = false;
    public boolean jiO = false;
    public int ccN = 0;
    private boolean jiU = false;
    private long agreeNum = 0;
    private boolean hasAgree = false;
    public boolean fCZ = false;
    public boolean jiV = false;
    public boolean jiX = false;
    public boolean jiY = true;
    public boolean jiZ = false;
    public boolean jja = false;
    private boolean jjc = false;
    private int jjd = 0;
    private boolean jje = true;
    public boolean jjg = false;
    public boolean jjh = false;
    public boolean jjj = false;
    private b jjl = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.jjk != null) {
                an amJ = PostData.this.jjk.amJ();
                amJ.delete("obj_locate");
                amJ.O("obj_locate", 7);
                TiebaStatic.log(amJ);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int jix = 0;
    private long time = 0;
    private String date = null;
    private MetaData ccm = new MetaData();
    private ArrayList<l> jiy = new ArrayList<>();
    private ArrayList<l> jiz = new ArrayList<>();
    private int jiA = 0;
    private int ccY = 0;
    private PraiseData ccA = new PraiseData();
    private ao jiF = new ao();
    private c jiG = new c();
    private ArrayList<com.baidu.tbadk.data.c> cdl = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.jiB = null;
        this.jiW = 0;
        this.jiB = new ArrayList<>();
        this.jiW = 0;
    }

    public void qM(boolean z) {
        this.jjf = z;
    }

    public boolean coh() {
        return this.jjf;
    }

    public ArrayList<PostData> coi() {
        return this.jiD;
    }

    public void coj() {
        this.jiD.clear();
        this.jiD = null;
        this.jiC = false;
    }

    public void r(PostData postData) {
        if (postData != null) {
            if (this.jiD == null) {
                this.jiD = new ArrayList<>();
                if (v.getCount(this.jiB) > 2) {
                    this.jiD.addAll(v.subList(this.jiB, 0, 2));
                } else {
                    this.jiD.addAll(this.jiB);
                }
            }
            this.jiD.add(postData);
        }
    }

    public void s(PostData postData) {
        if (postData != null && this.jiB != null) {
            this.jiB.add(postData);
            con();
        }
    }

    public void DO(String str) {
        if (this.jiD != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.jiD.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.jiD.remove(next);
                    return;
                }
            }
        }
    }

    public void qN(boolean z) {
        this.jje = z;
    }

    public boolean cok() {
        return this.jje;
    }

    public void qO(boolean z) {
        this.jiC = z;
    }

    public boolean col() {
        return this.jiC;
    }

    public ArrayList<PostData> com() {
        return this.jiB;
    }

    public void con() {
        this.jiA++;
    }

    public void coo() {
        this.jiA--;
    }

    public void zQ(int i) {
        this.jiA = i;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public long getTid() {
        return this.tid;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String bQt() {
        return this.hIE;
    }

    public int cop() {
        return this.jix;
    }

    public void zR(int i) {
        this.jix = i;
    }

    public boolean coq() {
        return this.jiL;
    }

    public void qP(boolean z) {
        this.jiL = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = aq.getFormatTime(j);
    }

    public MetaData aiG() {
        return this.ccm;
    }

    public void a(MetaData metaData) {
        this.ccm = metaData;
    }

    public void a(PraiseData praiseData) {
        this.ccA = praiseData;
    }

    public TbRichText cor() {
        return this.jiE;
    }

    public void c(TbRichText tbRichText) {
        this.jiE = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo bXF() {
        return this.icW;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.icW = smallTailInfo;
    }

    public com.baidu.tbadk.data.f cos() {
        return this.jiJ;
    }

    public SkinInfo ajb() {
        return this.cdo;
    }

    public void qQ(boolean z) {
        this.jjc = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.jiE != null && this.jiE.azh() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.ccm != null && this.ccm.getIs_bawu() == 1) {
                    if (this.jjf) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.ccm.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.ccm.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.ccm.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.ccm.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = aiG().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.fT().loadResourceFromMemery(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.fT().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.isValidNow()) {
                                            cVar2.setDrawable(PostData.this.j(aVar2));
                                            PostData.this.jiE.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.j(aVar);
                        }
                    }, 0, 1);
                    cVar.setEmptyBounds(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds32));
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.ccm.getSealPrefix())) {
                sb.append(HanziToPinyin.Token.SEPARATOR);
                sb.append(this.ccm.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(HanziToPinyin.Token.SEPARATOR);
            }
            String sb2 = sb.toString();
            if (this.ccm == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.ccm.getName_show() + str + "：");
                str2 = this.ccm.getUserName();
                str3 = this.ccm.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.ccm.getSealPrefix())) {
                Bitmap bitmap = am.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                kVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.ccm.getSealPrefix().length() + 1;
                spannableString.setSpan(kVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.jjl), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.ccm != null && this.ccm.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.c am = am(z, this.ccm != null && this.ccm.getIs_bawu() == 1);
                if (am != null) {
                    if (this.ccm != null) {
                        int i3 = 0;
                        if (this.ccm.getName_show() != null) {
                            i3 = this.ccm.getName_show().length();
                        }
                        spannableString.setSpan(am, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(am, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> azh = this.jiE.azh();
            if (azh != null && azh.size() > 0) {
                TbRichTextData tbRichTextData2 = azh.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.azq() != null) {
                    if (this.jjc) {
                        int indexOf = tbRichTextData2.azq().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.azq().delete(0, indexOf + 1);
                        }
                        this.jjc = false;
                    }
                    tbRichTextData2.kO(sb.length());
                    tbRichTextData2.azq().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= azh.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (azh.get(i5) == null || azh.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo azr = azh.get(i5).azr();
                            azh.remove(i5);
                            tbRichTextVoiceInfo = azr;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.kO(sb.length());
                    tbRichTextData.i(spannableString);
                    azh.add(0, tbRichTextData);
                }
            }
            this.jjg = true;
        }
    }

    private com.baidu.tbadk.core.view.c am(boolean z, boolean z2) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds5), this.jjf ? R.color.cp_link_tip_a_alpha50 : R.color.cp_link_tip_a, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26), this.jjf ? R.color.cp_link_tip_a : R.color.cp_bg_line_d, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds12), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40));
        if (this.jjf) {
            cVar.er(false);
            return cVar;
        }
        cVar.er(true);
        return cVar;
    }

    protected Drawable j(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (aVar == null || (rawBitmap = aVar.getRawBitmap()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(rawBitmap);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.ds36));
        return bitmapDrawable;
    }

    public int cot() {
        return this.jiA;
    }

    public void eb(Context context) {
        int type;
        int i;
        int i2;
        if (this.jiy != null) {
            int i3 = -1;
            int size = this.jiz.size();
            if (size > 0) {
                try {
                    i3 = this.jiz.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.jiy.size()) {
                l lVar = this.jiy.get(i4);
                if (l.cs(i5, lVar.getType())) {
                    this.jiz.get(size - 1).b(lVar.ea(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.jiz.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.ea(context));
                        this.jiz.add(lVar2);
                        type = 0;
                    }
                    i = type;
                    i2 = size + 1;
                }
                i4++;
                i5 = i;
                size = i2;
            }
        }
    }

    public void ec(Context context) {
        try {
            if (this.jiE != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.jiE.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.jiz == null || this.jiz.size() == 0) {
                eb(context);
            }
            ArrayList<l> arrayList = this.jiz;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.coa() != null) {
                            sb.append((CharSequence) next.coa());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String pB = TbFaceManager.avt().pB(next.getText());
                        if (pB != null) {
                            sb.append("[");
                            sb.append(pB);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !aq.isEmpty(next.cnZ())) {
                        sb.append("[").append(next.cnZ()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                if (clipboardManager2.getText() != null) {
                }
            }
        } catch (NullPointerException e) {
            BdLog.detailException(e);
        }
    }

    public void a(SubPostList subPostList, Context context) {
        a(subPostList, context, false);
    }

    public void a(SubPostList subPostList, Context context, boolean z) {
        MetaData metaData;
        if (subPostList != null) {
            try {
                this.id = String.valueOf(subPostList.id);
                this.title = subPostList.title;
                this.jix = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = aq.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.jiK = subPostList.is_giftpost.intValue() == 1;
                this.agree = subPostList.agree;
                if (this.agree != null) {
                    this.cdT = this.agree.agree_type.intValue();
                    this.hasAgree = this.agree.has_agree.intValue() == 1;
                    this.agreeNum = this.agree.agree_num.longValue() > 0 ? this.agree.agree_num.longValue() : 0L;
                    this.cdR = this.agree.disagree_num.longValue() > 0 ? this.agree.disagree_num.longValue() : 0L;
                    this.agreeData.postId = this.id;
                    this.agreeData.agreeNum = this.agree.agree_num.longValue();
                    this.agreeData.disAgreeNum = this.agree.disagree_num.longValue();
                    this.agreeData.agreeType = this.agree.agree_type == null ? 0 : this.agree.agree_type.intValue();
                    this.agreeData.hasAgree = this.agree.has_agree.intValue() == 1;
                    this.agreeData.diffAgreeNum = this.agree.diff_agree_num != null ? this.agree.diff_agree_num.longValue() : 0L;
                }
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.ccm = metaData;
                }
                if ((this.ccm.getUserId() == null || this.ccm.getUserId().length() <= 0 || this.ccm.getUserId().equals("0")) && metaData2 != null) {
                    this.ccm = metaData2;
                }
                this.jiE = TbRichTextView.a(context, subPostList.content, z);
                if (this.jiE != null) {
                    this.jiE.setPostId(com.baidu.adp.lib.g.b.toLong(this.id, -1L));
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        MetaData metaData;
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.tid = post.tid.longValue();
                this.title = post.title;
                this.jix = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = aq.getFormatTime(this.time);
                this.hIE = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.ccm = metaData;
                }
                this.fCZ = post.need_log.intValue() == 1;
                this.jiV = post.img_num_abtest.intValue() == 1;
                this.jiN = new bd();
                this.jiN.parserProtobuf(post.from_forum);
                if (this.ccm.getUserId() == null || this.ccm.getUserId().length() <= 0 || this.ccm.getUserId().equals("0")) {
                    this.ccm.parserProtobuf(post.author);
                }
                if (this.ccm != null && context != null) {
                    this.jiR = this.ccm.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.jiS = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.ccm.getLevel_id()));
                }
                this.jiH = post.is_ntitle.intValue() == 1;
                this.jiA = post.sub_post_number.intValue();
                this.jiM = new i(post.tpoint_post);
                this.jiE = TbRichTextView.a(context, post.content, true);
                if (this.jiE != null) {
                    this.jiE.setPostId(com.baidu.adp.lib.g.b.toLong(this.id, -1L));
                    this.jiE.kN(this.jix);
                    if (this.ccm != null) {
                        this.jiE.setAuthorId(this.ccm.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.jiK = subPostList.is_giftpost.intValue() == 1;
                            postData.agree = subPostList.agree;
                            postData.setUserMap(this.userMap);
                            postData.qM(this.jjf);
                            postData.a(subPostList, context);
                            this.jiB.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.jiG.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.jiI = new com.baidu.tbadk.data.c();
                    this.jiI.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.jiJ = new com.baidu.tbadk.data.f();
                    this.jiJ.a(post.lbs_info);
                }
                this.ccY = post.storecount.intValue();
                this.jiF.a(post.present);
                this.ccA.setUserMap(this.userMap);
                this.ccA.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.icW = new SmallTailInfo();
                    this.icW.id = post.signature.signature_id.intValue();
                    this.icW.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.icW.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.icW.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.icW.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.cdl.add(cVar);
                    }
                }
                this.cdo = post.skin_info;
                this.cdr = post.lego_card;
                this.jiT = post.tpoint_post;
                if (post.agree != null) {
                    this.jiU = true;
                    this.hasAgree = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.agreeNum = post.agree.agree_num.longValue();
                    } else {
                        this.agreeNum = 0L;
                    }
                    if (post.agree.disagree_num.longValue() >= 0) {
                        this.cdR = post.agree.disagree_num.longValue();
                    } else {
                        this.cdR = 0L;
                    }
                    this.cdT = post.agree.agree_type.intValue();
                    this.agreeData.postId = this.id;
                    this.agreeData.agreeType = post.agree.agree_type == null ? 0 : post.agree.agree_type.intValue();
                    this.agreeData.hasAgree = post.agree.has_agree.intValue() == 1;
                    this.agreeData.agreeNum = this.agreeNum;
                    this.agreeData.disAgreeNum = this.cdR;
                    this.agreeData.diffAgreeNum = post.agree.diff_agree_num == null ? 0L : post.agree.diff_agree_num.longValue();
                } else {
                    this.jiU = false;
                }
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.cdR < 0) {
                    this.cdR = 0L;
                }
                this.jja = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.cec = new OriginalThreadInfo();
                    this.cec.parser(post.origin_thread_info);
                } else {
                    this.cec = null;
                }
                this.jjd = post.is_fold.intValue();
                this.hJp = post.fold_tip;
                this.jjh = post.is_top_agree_post.intValue() == 1;
                this.jji = post.show_squared.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int iaT;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(this.iaT));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> jjr;
        private b jjs;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.jjr = new SoftReference<>(context);
            this.jjs = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.jjr != null) {
                if (this.jjs != null) {
                    this.jjs.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.jjr.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String ed(Context context) {
        ArrayList<TbRichTextData> azh;
        if (this.jiE == null || (azh = this.jiE.azh()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = azh.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.azq().toString());
            } else if (next.getType() == 17) {
                String str = next.azu().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(R.string.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(R.string.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(R.string.video_title_str) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public String cou() {
        ArrayList<TbRichTextData> azh;
        String str;
        if (this.jiE == null || (azh = this.jiE.azh()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = azh.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.azq().toString());
                } else if (next.getType() == 17) {
                    if (next.azu() != null && next.azu().mGifInfo != null && (str = next.azu().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo cov() {
        ArrayList<TbRichTextData> azh;
        if (this.jiE != null && (azh = this.jiE.azh()) != null) {
            Iterator<TbRichTextData> it = azh.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.azp().getWidth();
                    preLoadImageInfo.height = next.azp().getHeight();
                    preLoadImageInfo.imgUrl = next.azp().azD();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.azv().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.azv().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.azv().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String cow() {
        k cnS;
        PreLoadImageInfo cov = cov();
        if (cov != null && !StringUtils.isNull(cov.imgUrl)) {
            return cov.imgUrl;
        }
        if (this.jiM != null && (cnS = this.jiM.cnS()) != null && !StringUtils.isNull(cnS.cnX())) {
            return cnS.cnX();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> azh;
        if (this.jiE == null || (azh = this.jiE.azh()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = azh.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.azp().getWidth();
                preLoadImageInfo.height = next.azp().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.azp().azI()) {
                    preLoadImageInfo.imgUrl = next.azp().azE();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.azp().azD();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.azu() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.azu().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.azu().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.azu();
                preLoadImageInfo2.procType = 20;
                arrayList.add(preLoadImageInfo2);
            }
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.bimg_url;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.procType = 19;
            arrayList.add(preLoadImageInfo3);
        }
        if (this.ccm == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.ccm.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.jiw == 52) {
            return jis;
        }
        if (this.jiw == 1) {
            return cdp;
        }
        if (this.jiw == 36) {
            return jip;
        }
        if (this.jiw == 40 || this.jiw == 50) {
            return cbI;
        }
        if (this.jiw == 41) {
            return jiq;
        }
        if (this.jiw == 53) {
            return jit;
        }
        if (cop() == 1) {
            return jin;
        }
        return jio;
    }

    public void setPostType(int i) {
        this.jiw = i;
    }

    public ao cox() {
        return this.jiF;
    }

    public void a(ao aoVar) {
        this.jiF = aoVar;
    }

    public i coy() {
        return this.jiM;
    }

    public com.baidu.tbadk.widget.richText.f azt() {
        if (this.jiQ != null) {
            return this.jiQ;
        }
        if (this.jiE != null && v.getCount(this.jiE.azh()) > 0) {
            Iterator<TbRichTextData> it = this.jiE.azh().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.jiQ = next.azt();
                    return this.jiQ;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo azr() {
        if (this.crA != null) {
            return this.crA;
        }
        if (this.jiE != null && v.getCount(this.jiE.azh()) > 0) {
            Iterator<TbRichTextData> it = this.jiE.azh().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.crA = next.azr();
                    return this.crA;
                }
            }
        }
        return null;
    }

    public String coz() {
        return this.jiR;
    }

    public String ajI() {
        return this.cdr;
    }

    public void ajK() {
        if (this.ccN == 0) {
            this.ccN = 1;
        }
    }

    public long ajY() {
        return this.agreeNum;
    }

    public long ajZ() {
        return this.cdR;
    }

    public void aL(long j) {
        this.agreeNum = j;
    }

    public boolean bmt() {
        return this.hasAgree;
    }

    public void hR(int i) {
        this.cdT = i;
    }

    public void qR(boolean z) {
        this.hasAgree = z;
    }

    public int akb() {
        return this.cdT;
    }

    public void aM(long j) {
        this.cdR = j;
    }

    public AgreeData akv() {
        return this.agreeData;
    }

    public OriginalThreadInfo coA() {
        return this.cec;
    }

    public void g(OriginalThreadInfo originalThreadInfo) {
        this.cec = originalThreadInfo;
    }

    public int coB() {
        return this.jjd;
    }

    public String bQH() {
        return this.hJp;
    }

    public boolean coC() {
        return this.jji;
    }
}
