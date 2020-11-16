package com.baidu.tieba.tblauncher;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes21.dex */
public class f {
    public static void D(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter) || "zhongjianye".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM3);
                String queryParameter7 = uri.getQueryParameter("tid");
                String queryParameter8 = uri.getQueryParameter("kw");
                String queryParameter9 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.eqd);
                String queryParameter10 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.eqe);
                String queryParameter11 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.eqf);
                String queryParameter12 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.eqg);
                String queryParameter13 = uri.getQueryParameter("obj_name");
                String queryParameter14 = uri.getQueryParameter("eqid");
                String queryParameter15 = uri.getQueryParameter("is_new_schema");
                if (!TextUtils.isEmpty(queryParameter15) && queryParameter15.equals("1")) {
                    ar arVar = new ar("c13998");
                    arVar.dR("obj_source", queryParameter);
                    arVar.dR("obj_locate", queryParameter2);
                    arVar.dR("obj_type", queryParameter3);
                    arVar.dR("obj_param1", queryParameter4);
                    TiebaStatic.log(arVar);
                    return;
                }
                ar arVar2 = new ar("c13561");
                arVar2.dR("obj_locate", queryParameter2);
                arVar2.dR("obj_type", queryParameter3);
                arVar2.dR("obj_param1", queryParameter4);
                arVar2.dR(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                arVar2.dR(TiebaInitialize.Params.OBJ_PARAM3, queryParameter6);
                arVar2.dR("tid", queryParameter7);
                arVar2.dR("fname", queryParameter8);
                arVar2.dR(com.baidu.tbadk.BdToken.f.eqd, queryParameter9);
                arVar2.dR(com.baidu.tbadk.BdToken.f.eqe, queryParameter10);
                arVar2.dR(com.baidu.tbadk.BdToken.f.eqf, queryParameter11);
                arVar2.dR(com.baidu.tbadk.BdToken.f.eqg, queryParameter12);
                arVar2.dR("obj_source", queryParameter);
                arVar2.dR("obj_name", queryParameter13);
                arVar2.dR("query", queryParameter14);
                TiebaStatic.log(arVar2);
            }
        }
    }

    public static void E(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter) || "PC".equals(queryParameter) || "zhongjianye".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("is_new_schema");
                if (!TextUtils.isEmpty(queryParameter2) && queryParameter2.equals("1")) {
                    ar arVar = new ar("c13998");
                    arVar.dR("obj_source", uri.getQueryParameter("obj_source"));
                    arVar.dR("obj_locate", uri.getQueryParameter("obj_locate"));
                    arVar.dR("obj_type", uri.getQueryParameter("obj_type"));
                    arVar.dR("obj_param1", uri.getQueryParameter("obj_param1"));
                    TiebaStatic.log(arVar);
                }
            }
        }
    }

    public static void F(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter) || "PC".equals(queryParameter) || "zhongjianye".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("kw");
                String queryParameter7 = uri.getQueryParameter("obj_name");
                String queryParameter8 = uri.getQueryParameter("fname");
                String queryParameter9 = uri.getQueryParameter("is_new_schema");
                if (!TextUtils.isEmpty(queryParameter9) && queryParameter9.equals("1")) {
                    ar arVar = new ar("c13998");
                    arVar.dR("obj_source", queryParameter);
                    arVar.dR("obj_locate", queryParameter2);
                    arVar.dR("obj_type", queryParameter3);
                    arVar.dR("obj_param1", queryParameter4);
                    TiebaStatic.log(arVar);
                    return;
                }
                ar arVar2 = new ar("c13561");
                arVar2.dR("obj_locate", queryParameter2);
                arVar2.dR("obj_type", queryParameter3);
                arVar2.dR("obj_param1", queryParameter4);
                arVar2.dR(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                arVar2.dR("fname", queryParameter6);
                arVar2.dR("obj_source", queryParameter);
                arVar2.dR("obj_name", queryParameter7);
                arVar2.dR("fname", queryParameter8);
                TiebaStatic.log(arVar2);
            }
        }
    }

    public static void G(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter) || "zhongjianye".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("kw");
                String queryParameter7 = uri.getQueryParameter("obj_name");
                String queryParameter8 = uri.getQueryParameter("topic_id");
                ar arVar = new ar("c13561");
                arVar.dR("obj_locate", queryParameter2);
                arVar.dR("obj_type", queryParameter3);
                arVar.dR("obj_param1", queryParameter4);
                arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                arVar.dR("fname", queryParameter6);
                arVar.dR("obj_source", queryParameter);
                arVar.dR("obj_name", queryParameter7);
                arVar.dR("topic_id", queryParameter8);
                TiebaStatic.log(arVar);
            }
        }
    }

    public static void H(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter) || "zhongjianye".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("obj_name");
                ar arVar = new ar("c13561");
                arVar.dR("obj_locate", queryParameter2);
                arVar.dR("obj_type", queryParameter3);
                arVar.dR("obj_param1", queryParameter4);
                arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                arVar.dR("obj_source", queryParameter);
                arVar.dR("obj_name", queryParameter6);
                TiebaStatic.log(arVar);
            }
        }
    }

    public static void I(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter) || "PC".equals(queryParameter) || "zhongjianye".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                uri.getQueryParameter("kw");
                String queryParameter6 = uri.getQueryParameter("obj_name");
                uri.getQueryParameter("fname");
                ar arVar = new ar("c13561");
                arVar.dR("obj_locate", queryParameter2);
                arVar.dR("obj_type", queryParameter3);
                arVar.dR("obj_param1", queryParameter4);
                arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                arVar.dR("obj_source", queryParameter);
                arVar.dR("obj_name", queryParameter6);
                TiebaStatic.log(arVar);
            }
        }
    }
}
