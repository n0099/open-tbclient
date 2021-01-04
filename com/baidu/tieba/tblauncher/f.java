package com.baidu.tieba.tblauncher;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class f {
    public static void F(Uri uri) {
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
                String queryParameter9 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.eGt);
                String queryParameter10 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.eGu);
                String queryParameter11 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.eGv);
                String queryParameter12 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.eGw);
                String queryParameter13 = uri.getQueryParameter("obj_name");
                String queryParameter14 = uri.getQueryParameter("eqid");
                aq aqVar = new aq("c13561");
                aqVar.dX("obj_locate", queryParameter2);
                aqVar.dX("obj_type", queryParameter3);
                aqVar.dX("obj_param1", queryParameter4);
                aqVar.dX(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                aqVar.dX(TiebaInitialize.Params.OBJ_PARAM3, queryParameter6);
                aqVar.dX("tid", queryParameter7);
                aqVar.dX("fname", queryParameter8);
                aqVar.dX(com.baidu.tbadk.BdToken.f.eGt, queryParameter9);
                aqVar.dX(com.baidu.tbadk.BdToken.f.eGu, queryParameter10);
                aqVar.dX(com.baidu.tbadk.BdToken.f.eGv, queryParameter11);
                aqVar.dX(com.baidu.tbadk.BdToken.f.eGw, queryParameter12);
                aqVar.dX("obj_source", queryParameter);
                aqVar.dX("obj_name", queryParameter13);
                aqVar.dX("query", queryParameter14);
                aqVar.an("obj_id", TbadkCoreApplication.getInst().getStartType());
                aqVar.an(TiebaInitialize.Params.OBJ_TO, 1);
                TiebaStatic.log(aqVar);
            }
        }
    }

    public static void G(Uri uri) {
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
                aq aqVar = new aq("c13561");
                aqVar.dX("obj_locate", queryParameter2);
                aqVar.dX("obj_type", queryParameter3);
                aqVar.dX("obj_param1", queryParameter4);
                aqVar.dX(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                aqVar.dX("fname", queryParameter6);
                aqVar.dX("obj_source", queryParameter);
                aqVar.dX("obj_name", queryParameter7);
                aqVar.dX("fname", queryParameter8);
                aqVar.an("obj_id", TbadkCoreApplication.getInst().getStartType());
                aqVar.an(TiebaInitialize.Params.OBJ_TO, 1);
                TiebaStatic.log(aqVar);
            }
        }
    }

    public static void H(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("is_new_schema");
            if (!TextUtils.isEmpty(queryParameter) && queryParameter.equals("1")) {
                String queryParameter2 = uri.getQueryParameter("obj_source");
                String queryParameter3 = uri.getQueryParameter("obj_locate");
                String queryParameter4 = uri.getQueryParameter("obj_type");
                String queryParameter5 = uri.getQueryParameter("obj_param1");
                aq aqVar = new aq("c13998");
                aqVar.dX("obj_source", queryParameter2);
                aqVar.dX("obj_locate", queryParameter3);
                aqVar.dX("obj_type", queryParameter4);
                aqVar.dX("obj_param1", queryParameter5);
                TiebaStatic.log(aqVar);
            }
        }
    }

    public static void I(Uri uri) {
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
                aq aqVar = new aq("c13561");
                aqVar.dX("obj_locate", queryParameter2);
                aqVar.dX("obj_type", queryParameter3);
                aqVar.dX("obj_param1", queryParameter4);
                aqVar.dX(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                aqVar.dX("fname", queryParameter6);
                aqVar.dX("obj_source", queryParameter);
                aqVar.dX("obj_name", queryParameter7);
                aqVar.dX("topic_id", queryParameter8);
                aqVar.an("obj_id", TbadkCoreApplication.getInst().getStartType());
                aqVar.an(TiebaInitialize.Params.OBJ_TO, 1);
                TiebaStatic.log(aqVar);
            }
        }
    }

    public static void J(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter) || "zhongjianye".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("obj_name");
                aq aqVar = new aq("c13561");
                aqVar.dX("obj_locate", queryParameter2);
                aqVar.dX("obj_type", queryParameter3);
                aqVar.dX("obj_param1", queryParameter4);
                aqVar.dX(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                aqVar.dX("obj_source", queryParameter);
                aqVar.dX("obj_name", queryParameter6);
                aqVar.an("obj_id", TbadkCoreApplication.getInst().getStartType());
                aqVar.an(TiebaInitialize.Params.OBJ_TO, 1);
                TiebaStatic.log(aqVar);
            }
        }
    }

    public static void K(Uri uri) {
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
                aq aqVar = new aq("c13561");
                aqVar.dX("obj_locate", queryParameter2);
                aqVar.dX("obj_type", queryParameter3);
                aqVar.dX("obj_param1", queryParameter4);
                aqVar.dX(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                aqVar.dX("obj_source", queryParameter);
                aqVar.dX("obj_name", queryParameter6);
                aqVar.an("obj_id", TbadkCoreApplication.getInst().getStartType());
                aqVar.an(TiebaInitialize.Params.OBJ_TO, 1);
                TiebaStatic.log(aqVar);
            }
        }
    }
}
